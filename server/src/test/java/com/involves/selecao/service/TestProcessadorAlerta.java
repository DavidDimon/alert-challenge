package com.involves.selecao.service;

import com.involves.selecao.alerta.Alerta;
import com.involves.selecao.alerta.Pesquisa;
import com.involves.selecao.alerta.Resposta;
import com.involves.selecao.utils.MockPesquisaParticipacao;
import com.involves.selecao.utils.MockPesquisaPreco;
import com.involves.selecao.utils.MockPesquisaSituacao;
import com.involves.selecao.utils.MockTestAlert;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class TestProcessadorAlerta {

    protected ProcessadorAlerta processadorAlerta = new ProcessadorAlerta();

    //tests alerta situacao
    @Test
    public void testGetAlertaSituacaoWithNull01(){
        Assert.assertNull(processadorAlerta.getAlertaSituacao(null,null));
    }

    @Test
    public void testGetAlertaSituacaoWithNull02(){
        Assert.assertNull(processadorAlerta.getAlertaSituacao(MockPesquisaSituacao.getPesquisaSituacaoAusente(),null));
    }

    @Test
    public void testGetAlertaSituacaoWithNull03(){
        Assert.assertNull(processadorAlerta.getAlertaSituacao(null,MockPesquisaSituacao.getPesquisaSituacaoAusente().getRespostas().get(0)));
    }

    @Test
    public void testGetAlertaSituacaoAusente(){
        Resposta resposta = MockPesquisaSituacao.getPesquisaSituacaoAusente().getRespostas().get(0);
        Alerta result = processadorAlerta.getAlertaSituacao(MockPesquisaSituacao.getPesquisaSituacaoAusente(),resposta);
        Alerta expected = MockTestAlert.getAlertaSituacaoAusente();
        Assert.assertEquals(expected,result);
    }

    @Test
    public void testGetAlertaSituacaoNaGondola(){
        Resposta resposta = MockPesquisaSituacao.getPesquisaSituacaoEstaNaGondola().getRespostas().get(0);
        Alerta result = processadorAlerta.getAlertaSituacao(MockPesquisaSituacao.getPesquisaSituacaoEstaNaGondola(),resposta);
        Assert.assertEquals(null,result);
    }

    //test alerta preco
    @Test
    public void testGetAlertaPrecoWithNull01(){
        Assert.assertNull(processadorAlerta.getAlertaPreco(null,null));
    }

    @Test
    public void testGetAlertaPrecoWithNull02(){
        Assert.assertNull(processadorAlerta.getAlertaPreco(MockPesquisaPreco.getPesquisaPrecoAcima(),null));
    }

    @Test
    public void testGetAlertaPrecoWithNull03(){
        Assert.assertNull(processadorAlerta.getAlertaPreco(null,MockPesquisaPreco.getPesquisaPrecoAcima().getRespostas().get(0)));
    }

    @Test
    public void testGetAlertaPrecoAcima(){
        Resposta resposta = MockPesquisaPreco.getPesquisaPrecoAcima().getRespostas().get(0);
        Alerta result = processadorAlerta.getAlertaPreco(MockPesquisaPreco.getPesquisaPrecoAcima(),resposta);
        Alerta expected = MockTestAlert.getAlertaPrecoAcima();
        Assert.assertEquals(expected,result);
    }

    @Test
    public void testGetAlertaPrecoAbaixo(){
        Resposta resposta = MockPesquisaPreco.getPesquisaPrecoAbaixo().getRespostas().get(0);
        Alerta result = processadorAlerta.getAlertaPreco(MockPesquisaPreco.getPesquisaPrecoAbaixo(),resposta);
        Alerta expected = MockTestAlert.getAlertaPrecoAbaixo();
        Assert.assertEquals(expected,result);
    }

    @Test
    public void testGetAlertaPrecoIgual(){
        Resposta resposta = MockPesquisaPreco.getPesquisaPrecoIgual().getRespostas().get(0);
        Alerta result = processadorAlerta.getAlertaPreco(MockPesquisaPreco.getPesquisaPrecoIgual(),resposta);
        Assert.assertEquals(null,result);
    }

    //tests participacao
    @Test
    public void testGetAlertaParticipacaoWithNull01(){
        Assert.assertNull(processadorAlerta.getAlertaParticipacao(null,null));
    }

    @Test
    public void testGetAlertaParticipacaoWithNull02(){
        Assert.assertNull(processadorAlerta.getAlertaParticipacao(MockPesquisaParticipacao.getPesquisaParticipacaoAbaixo(),null));
    }

    @Test
    public void testGetAlertaParticipacaoWithNull03(){
        Assert.assertNull(processadorAlerta.getAlertaParticipacao(null,MockPesquisaParticipacao.getPesquisaParticipacaoAbaixo().getRespostas().get(0)));
    }

    @Test
    public void testGetAlertaParticipacaoAcima(){
        Resposta resposta = MockPesquisaParticipacao.getPesquisaParticipacaoAcima().getRespostas().get(0);
        Alerta result = processadorAlerta.getAlertaParticipacao(MockPesquisaParticipacao.getPesquisaParticipacaoAcima(),resposta);
        Alerta expected = MockTestAlert.getAlertaParticipacaoAcima();
        Assert.assertEquals(expected,result);
    }

    @Test
    public void testGetAlertaParticipacaoAbaixo(){
        Resposta resposta = MockPesquisaParticipacao.getPesquisaParticipacaoAbaixo().getRespostas().get(0);
        Alerta result = processadorAlerta.getAlertaParticipacao(MockPesquisaParticipacao.getPesquisaParticipacaoAbaixo(),resposta);
        Alerta expected = MockTestAlert.getAlertaParticipacaoAbaixo();
        Assert.assertEquals(expected,result);
    }

    @Test
    public void testGetAlertaParticipacaoIgual(){
        Resposta resposta = MockPesquisaParticipacao.getPesquisaParticipacaoIgual().getRespostas().get(0);
        Alerta result = processadorAlerta.getAlertaParticipacao(MockPesquisaParticipacao.getPesquisaParticipacaoIgual(),resposta);
        Assert.assertEquals(null,result);
    }
}
