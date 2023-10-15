import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EntregasCadastrarEntregaController {

    @FXML
    private TextArea Descrição_Entrega;

    @FXML
    private Button botaoCadastrarEntrega;

    @FXML
    private Button botaoCadastrarNota;

    @FXML
    private Button botaoConfirmar;

    @FXML
    private Button botaoDevolutiva;

    @FXML
    private Button botaoHome;

    @FXML
    private Button dropdownAluno;

    @FXML
    private Button dropdownAtividade;

    @FXML
    private Button dropdownCalendario;

    @FXML
    private TextField textAluno;

    @FXML
    private TextField textAtividade;

    @FXML
    void abrirCadastrarNota(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) botaoCadastrarNota.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/fxml/Entregas_Cadastrar_Nota.fxml"));
        Scene cadastrarNota = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Entregas: Cadastrar Nota");
        stage.setScene(cadastrarNota);  
        currentStage.close();
        stage.show();
    }

    @FXML
    void abrirDevolutiva(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) botaoDevolutiva.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/fxml/Entregas_Devolutiva.fxml"));
        Scene devolutiva = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Entregas: Devolutiva");
        stage.setScene(devolutiva);  
        currentStage.close();
        stage.show();
    }

    @FXML
    void abrirHome(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) botaoHome.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/fxml/Home.fxml"));
        Scene home = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Home");
        stage.setScene(home);  
        currentStage.close();
        stage.show();
    }

    @FXML
    void confirmarEntrega(MouseEvent event) {
        JOptionPane.showMessageDialog(null, "Entrega confirmada!!!", "Confirmado!", 1);
    }

}