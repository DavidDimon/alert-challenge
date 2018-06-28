package com.involves.selecao.utils;

import com.involves.selecao.alerta.Pesquisa;
import com.involves.selecao.alerta.Resposta;

import java.util.Arrays;

public class MockPesquisaPreco {

    public static Pesquisa getPesquisaPrecoAcima(){
        Pesquisa pesquisa = new Pesquisa();
        pesquisa.setId(3);
        pesquisa.setRotulo("Campanha de pascoa");
        pesquisa.setNotificante("Malaquias");
        pesquisa.setPonto_de_venda("Padaria do Alemão");
        pesquisa.setProduto("Ovo de Pascoa Barbie 48");
        pesquisa.setPreco_estipulado("100");
        Resposta resposta = new Resposta();
        resposta.setPergunta("Qual o preço do produto?");
        resposta.setResposta("105");
        pesquisa.setRespostas(Arrays.asList(resposta));
        return pesquisa;
    }

    public static Pesquisa getPesquisaPrecoAbaixo(){
        Pesquisa pesquisa = new Pesquisa();
        pesquisa.setId(2);
        pesquisa.setRotulo("Campanha de pascoa");
        pesquisa.setNotificante("José");
        pesquisa.setPonto_de_venda("Padaria do seu João");
        pesquisa.setProduto("Ovo de Pascoa Kinder 48");
        pesquisa.setPreco_estipulado("100");
        Resposta resposta = new Resposta();
        resposta.setPergunta("Qual o preço do produto?");
        resposta.setResposta("95");
        pesquisa.setRespostas(Arrays.asList(resposta));
        return pesquisa;
    }

    public static Pesquisa getPesquisaPrecoIgual(){
        Pesquisa pesquisa = new Pesquisa();
        pesquisa.setId(2);
        pesquisa.setRotulo("Campanha de pascoa");
        pesquisa.setNotificante("José");
        pesquisa.setPonto_de_venda("Padaria do seu João");
        pesquisa.setProduto("Ovo de Pascoa Kinder 48");
        pesquisa.setPreco_estipulado("100");
        Resposta resposta = new Resposta();
        resposta.setPergunta("Qual o preço do produto?");
        resposta.setResposta("100");
        pesquisa.setRespostas(Arrays.asList(resposta));
        return pesquisa;
    }
}
