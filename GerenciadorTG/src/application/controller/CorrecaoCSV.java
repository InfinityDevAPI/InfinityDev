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
            BufferedReader br = new BufferedReader(new FileReader("dados.csv"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("dados_corrijidos.csv"));

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

                if (campos.length >= 11) {
                    Timestamp timestamp = corrigirTimestamp(campos[0]);
                    String emailAddress = corrigirEmail(campos[1]);
                    String emailFatec = corrigirEmail(campos[2]);
                    String nomeCompleto = corrigirNome(campos[3]);
                    String nomeCompletoOrientador = corrigirNome(campos[4]);
                    String emailFatecOrientador = corrigirEmail(campos[5]);
                    String matriculadoEm = campos[6];
                    String tipoDeTG = campos[7];
                    String problemaASerResolvido = campos[8];
                    String empresaEnvolvida = campos[9];
                    String disciplina = corrigirNome(campos[10]);

                    bw.write(timestamp + "," + emailAddress + "," + emailFatec + "," + nomeCompleto + ","
                            + nomeCompletoOrientador + "," + emailFatecOrientador + "," + matriculadoEm + ","
                            + tipoDeTG + "," + problemaASerResolvido + "," + empresaEnvolvida + "," + disciplina);
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
            // Remova as aspas duplas se estiverem presentes
            string = string.replace("\"", "");
    
            if (string != null && !string.trim().isEmpty() && !string.equalsIgnoreCase("null")) {
                SimpleDateFormat inputFormat = new SimpleDateFormat("M/d/yyyy H:mm:ss");
                Date parsedDate = inputFormat.parse(string);
    
                return new Timestamp(parsedDate.getTime());
            } else {
                return null;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String corrigirNome(String nome) {
        nome = nome.trim();
        nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
        return nome;
    }

    public static String corrigirEmail(String email) {
        return email.toLowerCase();
    }
}
