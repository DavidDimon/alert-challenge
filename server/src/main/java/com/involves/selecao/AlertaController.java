package com.involves.selecao;

import java.io.IOException;
import java.util.List;

import com.involves.selecao.service.BuscaAlertasService;
import com.involves.selecao.service.ProcessadorAlerta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.involves.selecao.alerta.Alerta;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

	@Autowired
	private BuscaAlertasService buscaAlertasService;
	
	@Autowired
	private ProcessadorAlerta processador;
	
	@GetMapping()
	@CrossOrigin(origins = "http://localhost:3000")
    public List<Alerta> alertas() {
		return buscaAlertasService.buscarTodos();
    }
	
	@GetMapping("/processar")
	@CrossOrigin(origins = "http://localhost:3000")
    public void processar() {
		try {
			processador.processa();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
