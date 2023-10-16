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

public class RelatoriosController {

    @FXML
    private Button botaoExportar;

    @FXML
    private Button botaoHome;

    @FXML
    private Button botaoTG1;

    @FXML
    private Button botaoTG12;

    @FXML
    private Button botaoTG2;

    @FXML
    private Button dropdownAluno;

    @FXML
    private Button dropdownTipoTG;

    @FXML
    private TextField textAluno;

    @FXML
    private TextField textAptoDefesa;

    @FXML
    private TextField textAtividade;

    @FXML
    private TextArea textDadosDevolutiva;

    @FXML
    private TextArea textDadosEntrega;

    @FXML
    private TextField textDataDefesa;

    @FXML
    private TextField textEmailAluno;

    @FXML
    private TextField textEmailInstitucionalAluno;

    @FXML
    private TextField textEmailOrientador;

    @FXML
    private TextField textEntrega1;

    @FXML
    private TextField textEntrega2;

    @FXML
    private TextField textEntrega3;

    @FXML
    private TextField textMediaNotas;

    @FXML
    private TextField textNomeAluno;

    @FXML
    private TextField textNomeOrientador;

    @FXML
    private TextField textNota1;

    @FXML
    private TextField textNota2;

    @FXML
    private TextField textNota3;

    @FXML
    private TextField textNotaEntrega;

    @FXML
    private TextField textTipoTG;

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
    void exportarCSV(MouseEvent event) {
        JOptionPane.showMessageDialog(null, "Relatório exportado!!!", "Exportado!", 1);
    }

}
