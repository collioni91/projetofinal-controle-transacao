package com.aj5.BancoAJ5.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aj5.BancoAJ5.domains.TipoOperacao;
import com.aj5.BancoAJ5.service.TipoOperacaoService;


@RestController
@RequestMapping("/tipoOperacao")
public class TipoOperacaoController {
	
	private TipoOperacaoService service;

	public TipoOperacaoController(TipoOperacaoService service) {
		this.service = service;
	}
	
	@ApiOperation(value="Consulta todos TipoOperacaos do sistema", notes="Consulta Assíncrona.")
	@GetMapping
	public ResponseEntity<List<TipoOperacao>> getAll(){
		return ResponseEntity.ok(this.service.findAll());
	}
	
	@ApiOperation(value="Consulta TipoOperacao específico do sistema", notes="Consulta Assíncrona.")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<TipoOperacao>> getByID(@PathVariable("id") Long id){
		return ResponseEntity.ok(this.service.getById(id));
	}
	
	@ApiOperation(value="Cadastra TipoOperacao no sistema", notes="Consulta Assíncrona.")
	@PostMapping
	public String save(@RequestBody TipoOperacao TipoOperacao) {
		return this.service.create(TipoOperacao).toString();
	}
	
	@ApiOperation(value="Deleta TipoOperacao específico do sistema", notes="Consulta Assíncrona.")
	@DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
    	this.service.remove(id);
    	return "TipoOperacao " + id + " deletado.";
    }
}
