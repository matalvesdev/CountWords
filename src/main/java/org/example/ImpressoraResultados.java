package org.example;

import java.util.Map;

public class ImpressoraResultados {

    public static void imprimirResultados(Map<String, Integer> resultado) {

        System.out.println("============ RESULTADO ===============");

        for(Map.Entry<String, Integer> entry : resultado.entrySet()) {
            System.out.println("- " + entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("======================================");
    }
}