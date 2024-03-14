package com.tiagosouza.projetoSpring.service.execption;

public class PessoaNaoEncontrada extends RuntimeException {

  public PessoaNaoEncontrada(String msg) {
    super(msg);
  }
}
