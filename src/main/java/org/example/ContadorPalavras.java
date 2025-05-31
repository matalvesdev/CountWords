package org.example;

import java.util.HashMap;
import java.util.Map;

public class ContadorPalavras {

    public static Map<String, Integer> contarPalavras(String conteudo) {

        Map<String, Integer> resultado = new HashMap<>();
        // input -> ola mundo teste
        // split \\s+
        // output -> [ola,mundo,teste]
        String[] palavras = conteudo.split("\\s+"); // regex - Regular Expression

        for (String palavra : palavras) {
            Integer qtdAparicoes = resultado.getOrDefault(palavra, 0);
            qtdAparicoes++;
            resultado.put(palavra, qtdAparicoes);
        }

        return resultado;
    }
}