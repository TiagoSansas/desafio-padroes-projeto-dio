package com.tiagosouza.projetoSpring.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tiagosouza.projetoSpring.entities.Pessoa;
import com.tiagosouza.projetoSpring.repository.PessoaRepository;
import com.tiagosouza.projetoSpring.service.execption.PessoaNaoEncontrada;

import jakarta.transaction.Transactional;

@Service
public class PessoaService {

  @Autowired
  PessoaRepository pessoaRepository;

  @Transactional
  public Page<Pessoa> buscarTodos(Pageable pageable) {
    return pessoaRepository.findAll(pageable);
  }

  @Transactional
  public Pessoa buscarPorId(Long id) {
    return pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontrada("Pessoa não localizado no sistema"));
  }

  public Pessoa cadastrar(Pessoa pessoa) {
    return pessoaRepository.save(pessoa);
  }

  public Pessoa atualizar(Long id, Pessoa pessoa) {
    Pessoa update = this.buscarPorId(id);
    update.setNome(pessoa.getNome());
    return pessoaRepository.save(update);
  }

  public void deletar(Long id) {
    this.buscarPorId(id);
    pessoaRepository.deleteById(id);
  }

}
