package com.example;

public class BinaryTreeNavigation {
    Node raiz;

    // Método para inserir um valor na árvore
    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private Node inserirRecursivo(Node atual, int valor) {
        if (atual == null) {
            return new Node(valor); // Cria um novo nó se o atual for null
        }

        if (valor < atual.valor) {
            atual.esquerda = inserirRecursivo(atual.esquerda, valor); // Insere na subárvore esquerda
        } else if (valor > atual.valor) {
            atual.direita = inserirRecursivo(atual.direita, valor); // Insere na subárvore direita
        }

        return atual;
    }

    // Travessia in-order (Em ordem)
    public void percorrerInOrder(Node no) {
        if (no != null) {
            percorrerInOrder(no.esquerda);
            System.out.print(no.valor + " ");
            percorrerInOrder(no.direita);
        }
    }

    // Travessia pre-order (Pré-ordem)
    public void percorrerPreOrder(Node no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            percorrerPreOrder(no.esquerda);
            percorrerPreOrder(no.direita);
        }
    }

    // Travessia post-order (Pós-ordem)
    public void percorrerPostOrder(Node no) {
        if (no != null) {
            percorrerPostOrder(no.esquerda);
            percorrerPostOrder(no.direita);
            System.out.print(no.valor + " ");
        }
    }

    // Método para iniciar as travessias a partir da raiz
    public void imprimirInOrder() {
        percorrerInOrder(raiz);
    }

    public void imprimirPreOrder() {
        percorrerPreOrder(raiz);
    }

    public void imprimirPostOrder() {
        percorrerPostOrder(raiz);
    }
}
