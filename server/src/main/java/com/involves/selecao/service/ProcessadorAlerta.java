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
                if (resposta.getPergunta().toLowerCase().equals("qual a situação do produto?")) {
                    gateway.salvar(this.getAlertaSituacao(pesquisas[i], resposta));
                } else if (resposta.getPergunta().toLowerCase().equals("qual o preço do produto?")) {
                    gateway.salvar(this.getAlertaPreco(pesquisas[i], resposta));
                } else if (resposta.getPergunta().toLowerCase().equals("%share")) {
                    gateway.salvar(this.getAlertaParticipacao(pesquisas[i], resposta));
                } else {
                    System.out.println("Alerta ainda não implementado!");
                }
            }
        }
    }

    public Alerta getAlertaSituacao(Pesquisa pesquisa, Resposta resposta) {
        if (pesquisa == null || resposta == null || resposta.getResposta() == null) {
            return null;
        }

        if (resposta.getResposta().toLowerCase().equals("produto ausente na gondola")) {
            Alerta alerta = new Alerta();
            alerta.setPontoDeVenda(pesquisa.getPonto_de_venda());
            alerta.setDescricao("Ruptura detectada!");
            if (pesquisa.getProduto() != null) {
                alerta.setProduto(pesquisa.getProduto());
            } else {
                alerta.setProduto(pesquisa.getCategoria());
            }
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
        if (pesquisa.getProduto() != null) {
            alerta.setProduto(pesquisa.getProduto());
        } else {
            alerta.setProduto(pesquisa.getCategoria());
        }
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
        if (pesquisa == null || resposta == null || resposta.getResposta() == null) {
            return null;
        }

        int participacaoColetada = Integer.parseInt(resposta.getResposta());
        int participacaoEstipulada = Integer.parseInt(pesquisa.getParticipacao_estipulada());
        int margem =  participacaoEstipulada - participacaoColetada;

        Alerta alerta = new Alerta();
        if (pesquisa.getProduto() != null) {
            alerta.setProduto(pesquisa.getProduto());
        } else {
            alerta.setProduto(pesquisa.getCategoria());
        }
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

