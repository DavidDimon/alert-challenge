package com.involves.selecao.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import com.involves.selecao.utils.ConvertJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.involves.selecao.alerta.Alerta;
import com.involves.selecao.alerta.Pesquisa;
import com.involves.selecao.alerta.Resposta;
import com.involves.selecao.gateway.AlertaGateway;

@Service
public class ProcessadorAlerta {

    @Autowired
    private AlertaGateway gateway;

    public void processa() throws IOException {
        String content = ConvertJson.convertJsonToString("http://selecao-involves.agilepromoter.com/pesquisas");

        Gson gson = new Gson();
        Pesquisa[] pesquisas = gson.fromJson(content, Pesquisa[].class);
        for (int i = 0; i < pesquisas.length; i++) {
            for (int j = 0; j < pesquisas[i].getRespostas().size(); j++) {
                Resposta resposta = pesquisas[i].getRespostas().get(j);
                if (resposta.getPergunta().equals("Qual a situação do produto?")) {
                    gateway.salvar(this.getAlertaSituacao(pesquisas[i], resposta));
                } else if (resposta.getPergunta().equals("Qual o preço do produto?")) {
                    gateway.salvar(this.getAlertaPreco(pesquisas[i], resposta));
                } else if (resposta.getPergunta().equals("%Share")) {
                    gateway.salvar(this.getAlertaParticipacao(pesquisas[i], resposta));
                } else {
                    System.out.println("Alerta ainda não implementado!");
                }
            }
        }
    }

    private String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }

    }


    public Alerta getAlertaSituacao(Pesquisa pesquisa, Resposta resposta) {
        if (resposta == null || resposta.getResposta() == null
                && pesquisa == null) {
            return null;
        }

        if (resposta.getResposta().equals("Produto ausente na gondola")) {
            Alerta alerta = new Alerta();
            alerta.setPontoDeVenda(pesquisa.getPonto_de_venda());
            alerta.setDescricao("Ruptura detectada!");
            alerta.setProduto(pesquisa.getProduto());
            alerta.setFlTipo(1);
            return alerta;
        }
        return null;
    }

    public Alerta getAlertaPreco(Pesquisa pesquisa, Resposta resposta) {
        if (pesquisa == null || resposta == null || resposta.getResposta() == null) {
            return null;
        }

        int precoColetado = Integer.parseInt(resposta.getResposta());
        int precoEstipulado = Integer.parseInt(pesquisa.getPreco_estipulado());
        int margem = precoEstipulado - Integer.parseInt(resposta.getResposta());

        Alerta alerta = new Alerta();
        alerta.setProduto(pesquisa.getProduto());
        alerta.setPontoDeVenda(pesquisa.getPonto_de_venda());
        alerta.setMargem(margem);

        if (precoColetado > precoEstipulado) {
            alerta.setDescricao("Preço acima do estipulado!");
            alerta.setFlTipo(2);
        } else if (precoColetado < precoEstipulado) {
            alerta.setDescricao("Preço abaixo do estipulado!");
            alerta.setFlTipo(3);
        } else {
            return null;
        }

        return alerta;
    }

    public Alerta getAlertaParticipacao(Pesquisa pesquisa, Resposta resposta) {
        int participacaoColetada = Integer.parseInt(resposta.getResposta());
        int participacaoEstipulada = Integer.parseInt(pesquisa.getParticipacao_estipulada());
        int margem = participacaoColetada - participacaoEstipulada;

        Alerta alerta = new Alerta();
        alerta.setProduto(pesquisa.getProduto());
        alerta.setPontoDeVenda(pesquisa.getPonto_de_venda());
        alerta.setMargem(margem);

        if (participacaoColetada > participacaoEstipulada) {
            alerta.setDescricao("Participação acima da estipulada!");
            alerta.setFlTipo(2);
        } else if (participacaoColetada < participacaoEstipulada) {
            alerta.setDescricao("Participação abaixo da estipulada!");
            alerta.setFlTipo(3);
        } else {
            return null;
        }

        return alerta;
    }
}

