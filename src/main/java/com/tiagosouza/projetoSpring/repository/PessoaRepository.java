package com.tiagosouza.projetoSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiagosouza.projetoSpring.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
