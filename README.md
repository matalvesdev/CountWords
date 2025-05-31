# CountWords

O **CountWords** é uma aplicação de contagem de palavras desenvolvida para analisar arquivos de texto e exibir quantas vezes cada palavra aparece. Este projeto foi construído com o objetivo de exercitar os fundamentos da Programação Orientada a Objetos (POO) em Java, aliando boas práticas como separação de responsabilidades, legibilidade e reutilização de código.

---

## Funcionalidades

- **Leitura de Arquivo de Texto**: Recebe como entrada o caminho para um arquivo `.txt`.
- **Normalização do Conteúdo**: Converte todo o texto para letras minúsculas, facilitando a contagem precisa.
- **Contagem de Palavras**: Analisa o conteúdo e contabiliza a ocorrência de cada palavra.
- **Impressão de Resultados**: Exibe no terminal a quantidade de vezes que cada palavra apareceu no arquivo.

---

## Estrutura do Projeto

O projeto está dividido em cinco classes principais:

### 1. Classe `Textify`

Responsável por orquestrar a aplicação, unificando a leitura, normalização, contagem e impressão dos resultados.

```java
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
```

---

### 2. Classe `LeitorArquivo`

Responsável por realizar a leitura do conteúdo de um arquivo de texto.

**Principais Métodos:**

- `lerArquivo(String caminho)`: Retorna o conteúdo do arquivo como uma única String.

```java
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
            throw new UncheckedIOException(e);
        }
        return conteudo.toString();
    }
}
```

---

### 3. Classe `NormalizadorConteudo`

Responsável por normalizar o texto lido.

**Principais Métodos:**

- `converterMinusculo(String conteudo)`: Converte todo o texto para letras minúsculas.

```java
public class NormalizadorConteudo {
    public static String converterMinusculo(String conteudo) {
        return conteudo.toLowerCase();
    }
}
```

---

### 4. Classe `ContadorPalavras`

Responsável por contar a frequência das palavras no texto.

**Principais Métodos:**

- `contarPalavras(String conteudo)`: Retorna um `Map` com as palavras como chaves e suas contagens como valores.

```java
public class ContadorPalavras {
    public static Map<String, Integer> contarPalavras(String conteudo) {
        Map<String, Integer> resultado = new HashMap<>();
        String[] palavras = conteudo.split("\\s+");

        for (String palavra : palavras) {
            Integer qtd = resultado.getOrDefault(palavra, 0);
            resultado.put(palavra, qtd + 1);
        }

        return resultado;
    }
}
```

---

### 5. Classe `ImpressoraResultados`

Responsável por exibir os resultados da contagem no terminal.

**Principais Métodos:**

- `imprimirResultados(Map<String, Integer>)`: Exibe cada palavra e sua respectiva contagem.

```java
public class ImpressoraResultados {
    public static void imprimirResultados(Map<String, Integer> resultado) {
        System.out.println("============ RESULTADO ===============");
        for (Map.Entry<String, Integer> entry : resultado.entrySet()) {
            System.out.println("- " + entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("======================================");
    }
}
```

---

## Como Executar

1. Clone este repositório:

   ```bash
   git clone https://github.com/seuusuario/CountWords.git
   cd CountWords
   ```

2. Compile os arquivos Java:

   ```bash
   javac Textify.java LeitorArquivo.java NormalizadorConteudo.java ContadorPalavras.java ImpressoraResultados.java
   ```

3. Execute o programa:

   ```bash
   java Textify
   ```

---

## Objetivos de Aprendizagem

- Praticar os pilares da Programação Orientada a Objetos (POO).
- Entender como organizar sistemas em múltiplas classes com responsabilidades únicas.
- Desenvolver um projeto funcional e reutilizável para portfólio.
- Aprender a manipular arquivos, normalizar texto e trabalhar com estruturas de dados como `Map`.

---
