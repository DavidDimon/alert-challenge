package com.involves.selecao.utils;

import com.involves.selecao.alerta.Alerta;
import com.involves.selecao.alerta.Pesquisa;
import com.involves.selecao.alerta.Resposta;

import java.util.Arrays;

public class MockTestAlert {

    public static Alerta getAlertaSituacaoAusente(){
        Alerta alerta = new Alerta();
        alerta.setPontoDeVenda("Angel One Capoeiras");
        alerta.setDescricao("Ruptura detectada!");
        alerta.setProduto("Ovo de Pascoa Diamante Negro 48");
        alerta.setFlTipo(1);
        return alerta;
    }

    public static Alerta getAlertaPrecoAcima(){
        Alerta alerta = new Alerta();
        alerta.setPontoDeVenda("Padaria do Alemão");
        alerta.setDescricao("Preço acima do estipulado!");
        alerta.setProduto("Ovo de Pascoa Barbie 48");
        alerta.setFlTipo(2);
        alerta.setMargem(-5);
        return alerta;
    }

    public static Alerta getAlertaPrecoAbaixo(){
        Alerta alerta = new Alerta();
        alerta.setPontoDeVenda("Padaria do seu João");
        alerta.setDescricao("Preço abaixo do estipulado!");
        alerta.setProduto("Ovo de Pascoa Kinder 48");
        alerta.setFlTipo(3);
        alerta.setMargem(5);
        return alerta;
    }

    public static Alerta getAlertaParticipacaoAcima(){
        Alerta alerta = new Alerta();
        alerta.setPontoDeVenda("Padaria do Alemão");
        alerta.setDescricao("Participação acima da estipulada!");
        alerta.setProduto("Sabonetes");
        alerta.setFlTipo(2);
        alerta.setMargem(-2);
        return alerta;
    }

    public static Alerta getAlertaParticipacaoAbaixo(){
        Alerta alerta = new Alerta();
        alerta.setPontoDeVenda("Padaria do Alemão");
        alerta.setDescricao("Participação abaixo da estipulada!");
        alerta.setProduto("Refrigerantes");
        alerta.setFlTipo(3);
        alerta.setMargem(2);
        return alerta;
    }
}
