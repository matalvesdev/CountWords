package org.example;

import java.util.Map;
import java.util.Scanner;

public class Textify {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Bem vindo ao CountWords!");
        System.out.println("Indique o caminho do arquivo:");
        String caminho = sc.nextLine();

        String conteudo = LeitorArquivo.lerArquivo(caminho);
        String conteudoNormalizado = NormalizadorConteudo.converterMinusculo(conteudo);
        Map<String, Integer> resultado = ContadorPalavras.contarPalavras(conteudoNormalizado);
        ImpressoraResultados.imprimirResultados(resultado);
    }
}