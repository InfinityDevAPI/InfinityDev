package application.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CorrecaoCSV {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Arquivo CSV Formatado.csv"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("arquivocorrigido.csv"));

            String linha;
            boolean isHeader = true;
            while ((linha = br.readLine()) != null) {
                if (isHeader) {
                    bw.write(linha);
                    bw.newLine();
                    isHeader = false;
                    continue;
                }

                String[] campos = linha.split(",");

                if (campos.length >= 6) {
                    Timestamp timestamp = corrigirTimestamp(campos[0]);
                    String emailAddress = campos[1]; 
                    String emailFatec = campos[2];
                    String nomeCompleto = campos[3];
                    String nomeCompletoOrientador = campos[4];
                    String emailFatecOrientador = campos[5];

                    // Substitua "null" por uma data válida ou uma string vazia se não houver data
                    if (timestamp == null) {
                        timestamp = new Timestamp(System.currentTimeMillis());
                    }

                    bw.write(timestamp + "," + emailAddress + "," + emailFatec + "," + nomeCompleto + "," + nomeCompletoOrientador + "," +
                            emailFatecOrientador + ",");
                    bw.newLine();
                }
            }

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Timestamp corrigirTimestamp(String string) {
        try {
            if (string != null && !string.trim().isEmpty() && !string.equalsIgnoreCase("null")) {
                SimpleDateFormat inputFormat = new SimpleDateFormat("M/dd/yyyy H:mm:ss");
                SimpleDateFormat outputFormat = new SimpleDateFormat("M/dd/yyyy H:mm:ss");

                Date parsedDate = inputFormat.parse(string);
                String formattedDate = outputFormat.format(parsedDate);

                return Timestamp.valueOf(formattedDate);
            } else {
                // Se a data estiver vazia ou "null", retorne null
                return null;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    // Função para corrigir o nome (primeira letra maiúscula, sem números)
    public static String corrigirNome(String nome) {
        nome = nome.trim();
        nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
        nome = nome.replaceAll("[0-9]", "");
        return nome;
    }

    // Função para corrigir o email (letras minúsculas)
    public static String corrigirEmail(String email) {
        return email.toLowerCase();
    }
}
