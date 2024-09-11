package com.example;

public class Main {
    public static void main(String[] args) {
        BinaryTreeNavigation arvore = new BinaryTreeNavigation();

        // Inserindo valores na árvore
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);

        // Imprimindo as travessias
        System.out.println("Travessia In-Order:");
        arvore.imprimirInOrder(); // Deve retornar os valores em ordem crescente
        System.out.println();

        System.out.println("Travessia Pre-Order:");
        arvore.imprimirPreOrder(); // Primeiro a raiz, depois a subárvore esquerda e depois a direita
        System.out.println();

        System.out.println("Travessia Post-Order:");
        arvore.imprimirPostOrder(); // Primeiro as subárvores, depois a raiz
        System.out.println();

    }
}