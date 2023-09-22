import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ManipulaCSV {

    public static void main(String[] args) {
        String arquivoCSV = "exemplo.csv";

        try {
            // Lê o arquivo CSV
            FileReader fileReader = new FileReader(arquivoCSV);
            CSVReader csvReader = new CSVReader(fileReader);
            List<String[]> registros = csvReader.readAll();

            // Modifica os dados (exemplo: incrementa um número)
            for (String[] registro : registros) {
                String valorAntigo = registro[0];
                int novoValor = Integer.parseInt(valorAntigo) + 1;
                registro[0] = String.valueOf(novoValor);
            }

            fileReader.close();

            // Escreve os dados modificados de volta no arquivo CSV
            FileWriter fileWriter = new FileWriter(arquivoCSV);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            csvWriter.writeAll(registros);

            fileWriter.flush();
            fileWriter.close();

            System.out.println("Arquivo CSV modificado com sucesso.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
