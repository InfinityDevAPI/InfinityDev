package importaCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class ImportaCSV {
	
	

	 public static void importaCsv(){
			
		File arquivoCsv = new File("C:\\Users\\paulo\\Documents\\BD2\\InfinityDev\\GerenciadorTG\\documentos\\arquivo2CSVformatado");
		
		try {
		
			String linhaArquivo = new String ();
			
			Scanner leitor = new Scanner (arquivoCsv);
			
			leitor.nextLine();
			
			while(leitor.hasNext()) {
				
				linhaArquivo = leitor.nextLine();
				
				String[] valoresEntreVirgula = linhaArquivo.split(",");
				
								
			}
				
				
			}catch(FileNotFoundException e) {
				
			}
	}
	

}
