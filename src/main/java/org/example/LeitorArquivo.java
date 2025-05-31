package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UncheckedIOException;

public class LeitorArquivo {

    public static String lerArquivo(String caminho) {

        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha).append(" ");
            }

        } catch (IOException e) {
            System.out.println(String.format("Falha ao ler o arquivo %s", caminho));
            e.printStackTrace();
            throw new UncheckedIOException(e);
        }

        return conteudo.toString();
    }
}