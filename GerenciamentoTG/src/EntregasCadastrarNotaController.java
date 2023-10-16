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

public class EntregasCadastrarNotaController {

    @FXML
    private TextArea DescriçãoEntrega;

    @FXML
    private TextArea Devolutiva;

    @FXML
    private TextField Nota;

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
    private Button dropdownALuno;

    @FXML
    private Button dropdownAtividade;

    @FXML
    private TextField textAluno;

    @FXML
    private TextField textAtividade;

    @FXML
    void abrirCadastrarEntrega(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) botaoCadastrarEntrega.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/fxml/Entregas_Cadastrar_Entrega.fxml"));
        Scene cadastrarEntrega = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Entregas: Cadastrar Entrega");
        stage.setScene(cadastrarEntrega);  
        stage.setResizable(false);
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
        stage.setResizable(false);
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
        stage.setResizable(false);
        currentStage.close();
        stage.show();
    }

    @FXML
    void confirmarNota(MouseEvent event) {
        JOptionPane.showMessageDialog(null, "Nota confirmada!!!", "Confirmado!", 1);
    }

}
