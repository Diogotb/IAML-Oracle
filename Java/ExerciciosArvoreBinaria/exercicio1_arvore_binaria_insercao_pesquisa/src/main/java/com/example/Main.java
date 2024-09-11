package com.example;

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaDeBusca arvore = new ArvoreBinariaDeBusca();

        // Inserindo valores na árvore
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);

        // Imprimindo a árvore em ordem
        System.out.println("Árvore em ordem:");
        arvore.imprimirEmOrdem();
        System.out.println();

        // Pesquisando valores na árvore
        System.out.println("Pesquisar 40: " + (arvore.pesquisar(40) ? "Encontrado" : "Não encontrado"));
        System.out.println("Pesquisar 90: " + (arvore.pesquisar(90) ? "Encontrado" : "Não encontrado"));

        // Pesquisando valores com caminho
        System.out.println("Caminho para 40: " + arvore.pesquisarComCaminho(40));
        System.out.println("Caminho para 80: " + arvore.pesquisarComCaminho(80));
        System.out.println("Caminho para 100: " + arvore.pesquisarComCaminho(100));

        // Teste com valores em ordem crescente
        ArvoreBinariaDeBusca arvoreCrescente = new ArvoreBinariaDeBusca();
        for (int i = 1; i <= 10; i++) {
            arvoreCrescente.inserir(i);
        }

        System.out.println("\nÁrvore em ordem crescente:");
        arvoreCrescente.imprimirEmOrdem();
    
    }
}