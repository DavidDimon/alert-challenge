package com.involves.selecao.utils;

import com.involves.selecao.alerta.Pesquisa;
import com.involves.selecao.alerta.Resposta;

import java.util.Arrays;

public class MockPesquisaParticipacao {

    //mock participacao
    public static Pesquisa getPesquisaParticipacaoAcima(){
        Pesquisa pesquisa = new Pesquisa();
        pesquisa.setId(9);
        pesquisa.setRotulo("Acompanhamento de evolução dos refrigerantes");
        pesquisa.setNotificante("Paulo");
        pesquisa.setPonto_de_venda("Padaria do Alemão");
        pesquisa.setCategoria("Sabonetes");
        pesquisa.setParticipacao_estipulada("25");
        Resposta resposta = new Resposta();
        resposta.setPergunta("%Share");
        resposta.setResposta("27");
        pesquisa.setRespostas(Arrays.asList(resposta));
        return pesquisa;
    }

    public static Pesquisa getPesquisaParticipacaoAbaixo(){
        Pesquisa pesquisa = new Pesquisa();
        pesquisa.setId(4);
        pesquisa.setRotulo("Acompanhamento de evolução dos refrigerantes");
        pesquisa.setNotificante("Malaquias");
        pesquisa.setPonto_de_venda("Padaria do Alemão");
        pesquisa.setCategoria("Refrigerantes");
        pesquisa.setParticipacao_estipulada("50");
        Resposta resposta = new Resposta();
        resposta.setPergunta("%Share");
        resposta.setResposta("48");
        pesquisa.setRespostas(Arrays.asList(resposta));
        return pesquisa;
    }

    public static Pesquisa getPesquisaParticipacaoIgual(){
        Pesquisa pesquisa = new Pesquisa();
        pesquisa.setId(4);
        pesquisa.setRotulo("Acompanhamento de evolução dos refrigerantes");
        pesquisa.setNotificante("Malaquias");
        pesquisa.setPonto_de_venda("Padaria do Alemão");
        pesquisa.setCategoria("Refrigerantes");
        pesquisa.setParticipacao_estipulada("50");
        Resposta resposta = new Resposta();
        resposta.setPergunta("%Share");
        resposta.setResposta("50");
        pesquisa.setRespostas(Arrays.asList(resposta));
        return pesquisa;
    }
}
