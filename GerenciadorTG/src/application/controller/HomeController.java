package application.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import application.controller.CorrecaoCSV;

public class HomeController {
	

	@FXML
    private Button botaoAgendamentos;

    @FXML
    private Button botaoEntregas;

    @FXML
    private Button botaoImportarCSV;

    @FXML
    private Button botaoRelatorios;
    
    @FXML
    void abrirAgendamentos(MouseEvent event) {
        try {
            // Obtém a referência para a janela atual
            Stage currentStage = (Stage) botaoAgendamentos.getScene().getWindow();
            
            // Cria a nova janela de agendamentos
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/ui/Agendamentos.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Agendamentos");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            
            // Define o modality para Modality.APPLICATION_MODAL, isso faz com que a nova janela seja modal
            stage.initModality(Modality.APPLICATION_MODAL);
            
            // Fecha a janela atual
            currentStage.close();
            
            // Mostra a nova janela de agendamentos
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

    @FXML
    void abrirEntregas(MouseEvent event) throws IOException {
        try {
            Stage currentStage = (Stage) botaoEntregas.getScene().getWindow();
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/ui/Entregas.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Entregas");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            
            stage.initModality(Modality.APPLICATION_MODAL);
            
            currentStage.close();
            
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

    @FXML
    void abrirRelatorios(MouseEvent event) throws IOException {
        try {
            Stage currentStage = (Stage) botaoRelatorios.getScene().getWindow();
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/ui/Relatorios.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Relatorios");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            
            stage.initModality(Modality.APPLICATION_MODAL);
            
            currentStage.close();
            
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

   @FXML
    void importarCSV() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivos CSV", "*.csv"));
        File arquivoSelecionado = fileChooser.showOpenDialog(obterJanela());

        if (arquivoSelecionado != null) {
            try {
                // Ler e exibir o conteúdo do arquivo CSV selecionado
                importarArquivoCSV(arquivoSelecionado);
            } catch (IOException e) {
                exibirAlerta("Erro", "Falha ao importar o CSV", AlertType.ERROR);
            }
        }
    }

    private Window obterJanela() {
        return botaoImportarCSV.getScene().getWindow();
    }

    private void importarArquivoCSV(File arquivo) throws IOException {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        }
     // Mostra um aviso de sucesso
     exibirAlerta("Sucesso", "CSV importado com sucesso!",AlertType.INFORMATION);
    }

    private void exibirAlerta(String titulo, String cabecalho, AlertType tipoAlerta) {
        Alert alerta = new Alert(tipoAlerta);
        alerta.setTitle(titulo);
        alerta.setHeaderText(cabecalho);
        alerta.showAndWait();
    }

    
}
