package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exercicio1LeituraArquivo {
    // Arquivos de entrada e saída
    String inputFile = "alunos_notas.txt";

    // Lista para armazenar os alunos e suas médias
    List<Aluno> alunos = new ArrayList<>();
    double somaTotalNotas = 0; // Soma total das médias de todos os alunos
    int totalAlunos = 0; // Contador de alunos

    // método
    public void app(){

        try(BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length < 2) {
                    System.out.println("Linha com formato incorreto: " + linha);
                    continue; // Pula para a próxima linha
                }
                String nome = partes[0]; // Nome do aluno
                double somaNotas = 0; // Soma das notas do aluno
                int numeroNotas = 0; // Contador de notas
                try{
                    for (int i = 1; i < partes.length; i++) {
                    somaNotas += Double.parseDouble(partes[i]);
                    numeroNotas++;
                    }
                }catch(NumberFormatException e){
                    somaNotas += 0;
                }
                double media = somaNotas / numeroNotas; // Calcula a média do aluno
                alunos.add(new Aluno(nome, media)); // Adiciona o aluno à lista

                somaTotalNotas += media; // Soma a média do aluno à soma total
                totalAlunos++; // Incrementa o contador de alunos
               
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Aluno alunoMaiorNota = alunos.get(0); // Inicializa com o primeiro aluno
        Aluno alunoMenorNota = alunos.get(0);

        // Percorre a lista de alunos para encontrar o de maior e menor média
        for (Aluno aluno : alunos) {
            if (aluno.getMedia() > alunoMaiorNota.getMedia()) {
                alunoMaiorNota = aluno; // Atualiza o aluno com maior média
            }
            if (aluno.getMedia() < alunoMenorNota.getMedia()) {
                alunoMenorNota = aluno; // Atualiza o aluno com menor média
            }
        }

        double mediaGeralTurma = somaTotalNotas / totalAlunos; // Calcula a média geral da turma

        // Exibe os resultados no console
        System.out.println("");
        System.out.println("Aluno com a maior nota: " + alunoMaiorNota.getNome() 
                + " - Média: " + alunoMaiorNota.getMedia());
        System.out.println("Aluno com a menor nota: " + alunoMenorNota.getNome() 
                + " - Média: " + alunoMenorNota.getMedia());
        System.out.println("Média geral da turma: " + mediaGeralTurma);
    }
}
