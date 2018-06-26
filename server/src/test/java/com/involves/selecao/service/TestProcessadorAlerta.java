package com.involves.selecao.service;

import com.involves.selecao.alerta.Pesquisa;
import com.involves.selecao.alerta.Resposta;
import com.involves.selecao.ProcessadorAlerta;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class TestProcessadorAlerta {

    protected ProcessadorAlerta processadorAlerta;

    @Test
    public void testGetAlertaSituacaoWithNull01(){
        Assert.assertNull(processadorAlerta.getAlertaSituacao(null,null));
    }

    @Test
    public void testGetAlertaSituacaoWithNull02(){
        Assert.assertNull(processadorAlerta.getAlertaSituacao(getPesquisaSituacaoAusente(),null));
    }

    @Test
    public void testGetAlertaSituacaoWithNull03(){
        Assert.assertNull(processadorAlerta.getAlertaSituacao(null,getPesquisaSituacaoAusente().getRespostas().get(0)));
    }

    //mocks
    public Pesquisa getPesquisaSituacaoAusente(){
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
}
