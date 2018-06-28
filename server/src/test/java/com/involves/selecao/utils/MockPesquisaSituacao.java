package com.involves.selecao.utils;

import com.involves.selecao.alerta.Pesquisa;
import com.involves.selecao.alerta.Resposta;

import java.util.Arrays;

public class MockPesquisaSituacao {

    public static Pesquisa getPesquisaSituacaoAusente(){
        Pesquisa pesquisa = new Pesquisa();
        pesquisa.setId(5);
        pesquisa.setRotulo("Campanha de pascoa");
        pesquisa.setNotificante("Malaquias");
        pesquisa.setPonto_de_venda("Angel One Capoeiras");
        pesquisa.setProduto("Ovo de Pascoa Diamante Negro 48");
        Resposta resposta = new Resposta();
        resposta.setPergunta("Qual a Situação do produto");
        resposta.setResposta("Produto Ausente na gondola");
        pesquisa.setRespostas(Arrays.asList(resposta));
        return pesquisa;
    }

    public static Pesquisa getPesquisaSituacaoEstaNaGondola(){
        Pesquisa pesquisa = new Pesquisa();
        pesquisa.setId(5);
        pesquisa.setRotulo("Campanha de pascoa");
        pesquisa.setNotificante("Malaquias");
        pesquisa.setPonto_de_venda("Angel One Capoeiras");
        pesquisa.setProduto("Ovo de Pascoa Diamante Negro 48");
        Resposta resposta = new Resposta();
        resposta.setPergunta("Qual a Situação do produto");
        resposta.setResposta("Produto está na gondola");
        pesquisa.setRespostas(Arrays.asList(resposta));
        return pesquisa;
    }
}
