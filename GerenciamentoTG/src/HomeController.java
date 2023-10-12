import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    void abrirAgendamentos(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("resources/fxml/Agendamentos.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}