package com.example;

class Filme {
    String titulo;
    int ano;
    String genero;
    double nota;
    Filme esquerda; // Referência para o filho à esquerda
    Filme direita;  // Referência para o filho à direita

    Filme(String titulo, int ano, String genero, double nota) {
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
        this.nota = nota;
        this.esquerda = null;
        this.direita = null;
    }
}
