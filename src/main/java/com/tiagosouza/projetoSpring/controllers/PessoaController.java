package com.tiagosouza.projetoSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagosouza.projetoSpring.entities.Pessoa;
import com.tiagosouza.projetoSpring.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

  @Autowired
  PessoaService pessoaService;

  @GetMapping
  public ResponseEntity<Page<Pessoa>> buscarTodos(Pageable pageable) {
    Page<Pessoa> list = pessoaService.buscarTodos(pageable);
    return ResponseEntity.ok(list);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) {
    Pessoa pessoa = pessoaService.buscarPorId(id);
    return ResponseEntity.ok(pessoa);
  }

  @PostMapping
  public ResponseEntity<?> cadastrar(@RequestBody Pessoa pessoa) {
    try {
      pessoaService.cadastrar(pessoa);
      return ResponseEntity.status(201).body(pessoa);

    } catch (Exception e) {
      return ResponseEntity.status(500).body("Erro ao processsar requisicao" + e.getMessage());
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa) {
    pessoaService.atualizar(id, pessoa);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(Long id) {
    pessoaService.deletar(id);
    return ResponseEntity.noContent().build();
  }
}
