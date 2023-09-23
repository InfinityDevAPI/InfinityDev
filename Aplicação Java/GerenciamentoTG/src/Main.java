import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws CsvValidationException {
        String arquivoCSV = "C:\\Users\\miche\\Documents\\InfinityDev API\\InfintyDev\\Aplicação Java\\GerenciamentoTG\\resources\\Trabalho de Graduação - 202302 (Responses) - Form Responses 1.csv";

        try {
            // Lê o arquivo CSV
            FileReader fileReader = new FileReader(arquivoCSV);
            CSVReader csvReader = new CSVReader(fileReader);

            String[] linha;
            while ((linha = csvReader.readNext()) != null) {
                for (String valor : linha) {
                    System.out.print(valor + " ");
                }
                System.out.println(); // Adicione uma quebra de linha após cada linha do CSV
            }

            fileReader.close();
            csvReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
