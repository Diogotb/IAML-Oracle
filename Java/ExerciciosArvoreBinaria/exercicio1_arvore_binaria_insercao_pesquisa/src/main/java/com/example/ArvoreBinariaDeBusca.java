package com.example;

public class ArvoreBinariaDeBusca {
    No raiz;

    // Método para inserir um valor na árvore
    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No atual, int valor) {
        if (atual == null) {
            return new No(valor); // Cria um novo nó se o atual for null
        }

        if (valor < atual.valor) {
            atual.esquerda = inserirRecursivo(atual.esquerda, valor); // Insere na subárvore esquerda
        } else if (valor > atual.valor) {
            atual.direita = inserirRecursivo(atual.direita, valor); // Insere na subárvore direita
        }

        return atual;
    }

    // Método para pesquisar um valor na árvore
    public boolean pesquisar(int valor) {
        return pesquisarRecursivo(raiz, valor);
    }

    private boolean pesquisarRecursivo(No atual, int valor) {
        if (atual == null) {
            return false; // Valor não encontrado
        }

        if (valor == atual.valor) {
            return true; // Valor encontrado
        }

        return valor < atual.valor
            ? pesquisarRecursivo(atual.esquerda, valor)
            : pesquisarRecursivo(atual.direita, valor);
    }

    // Método para pesquisar um valor e retornar o caminho até o nó
    public String pesquisarComCaminho(int valor) {
        return pesquisarCaminhoRecursivo(raiz, valor, "");
    }

    private String pesquisarCaminhoRecursivo(No atual, int valor, String caminho) {
        if (atual == null) {
            return "Valor não encontrado"; // Valor não encontrado
        }

        if (valor == atual.valor) {
            return caminho + " " + atual.valor; // Valor encontrado, retorna o caminho
        }

        caminho += atual.valor + " -> "; // Atualiza o caminho

        return valor < atual.valor
            ? pesquisarCaminhoRecursivo(atual.esquerda, valor, caminho)
            : pesquisarCaminhoRecursivo(atual.direita, valor, caminho);
    }

    // Método para imprimir a árvore em ordem
    public void imprimirEmOrdem() {
        imprimirEmOrdemRecursivo(raiz);
    }

    private void imprimirEmOrdemRecursivo(No atual) {
        if (atual != null) {
            imprimirEmOrdemRecursivo(atual.esquerda);
            System.out.print(atual.valor + " ");
            imprimirEmOrdemRecursivo(atual.direita);
        }
    }
}
