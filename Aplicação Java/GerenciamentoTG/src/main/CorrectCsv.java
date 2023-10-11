package main;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CorrectCsv {

    public static String corrigirNome(String nome) {
        String[] partes = nome.split(" ");
        StringBuilder nomeCorrigido = new StringBuilder();

        for (String parte : partes) {
            if (parte.matches("[A-Za-zÀ-ÖØ-öø-ÿ]*")) {
                nomeCorrigido.append(parte.substring(0, 1).toUpperCase())
                        .append(parte.substring(1).toLowerCase());
            } else {
                nomeCorrigido.append(parte);
            }

            nomeCorrigido.append(" ");
        }

        return nomeCorrigido.toString().trim();
    }

    /**
     * @param args
     * @throws IOException
     * @throws CsvValidationException
     */
    public static void main(String[] args) throws IOException, CsvValidationException {
        String inputFile = "Documentos/trabalhodeGraduacao-202302.csv"; // Substitua pelo caminho do seu arquivo CSV
        String outputFile = "trabalhodegraduacaoCorrigido.csv"; // Substitua pelo nome do arquivo de saída

        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
            CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine.length > 3) {
                String nomeOriginal = nextLine[3];
                String nomeCorrigido = corrigirNome(nomeOriginal);
                nextLine[3] = nomeCorrigido;
            }

            if (nextLine.length > 4) {
                String nomeOriginal = nextLine[4];
                String nomeCorrigido = corrigirNome(nomeOriginal);
                nextLine[4] = nomeCorrigido;
            }

            // Verifica se existe um e-mail na segunda coluna e converte para minúsculas
            if (nextLine.length > 1) {
                String email1 = nextLine[1];
                if (email1 != null && !email1.isEmpty()) {
                    nextLine[1] = email1.toLowerCase();
                }
            }

            // Verifica se existe um e-mail na terceira coluna e converte para minúsculas
            if (nextLine.length > 2) {
                String email2 = nextLine[2];
                if (email2 != null && !email2.isEmpty()) {
                    nextLine[2] = email2.toLowerCase();
                }
            }

            // Verifica se existe um e-mail na sexta coluna e converte para minúsculas
            if (nextLine.length > 5) {
                String email3 = nextLine[5];
                if (email3 != null && !email3.isEmpty()) {
                    nextLine[5] = email3.toLowerCase();
                }
            }

            writer.writeNext(nextLine);
        }
        }
    }
}
