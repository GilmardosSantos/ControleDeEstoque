package br.com.mapa;

import java.util.Scanner;

public class Menu{

    private     int     opcao;

public void menuPrincipal(){
    System.out.println("------------------------------------------------");
    System.out.println("--- EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA. ---");
    System.out.println("--- Sistema de controle de estoque ---");
    System.out.println("-- Menu Principal --");
    System.out.println("-- 1) Cadastro de produtos --");
    System.out.println("-- 2) Movimentação --");
    System.out.println("-- 3) Reajuste de preços --");
    System.out.println("-- 4) Relatórios --");
    System.out.println("-- 0) Finalizar --");
    System.out.println("-- Opção: ");
}

public void menuCadastro(){
    System.out.println("--- Cadastro de produtos ---");
    System.out.println("-- 1) Inclusão --");
    System.out.println("-- 2) Alteração --");
    System.out.println("-- 3) Consulta --");
    System.out.println("-- 4) Exclusão --");
    System.out.println("-- 0) Retornar --");
    System.out.println("-- Opção: ");
}

public void menuMovimentacao(){
    System.out.println("--- Movimentação ---");
    System.out.println("-- 1) Entrada --");
    System.out.println("-- 2) Saída --");
    System.out.println("-- 0) Retornar --");
    System.out.println("-- Opção: ");
}

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }
}
