import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AgendamentosController {

    @FXML
    private Button botaoDefesasTG;

    @FXML
    private Button botaoEntregas;

    @FXML
    private Button botaoHome;

    @FXML
    void abrirDefesasTG(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) botaoDefesasTG.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/fxml/Agendamentos_Defesas_TG.fxml"));
        Scene agendamentosDefesasTG = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Agendamentos: Defesas de TG");
        stage.setScene(agendamentosDefesasTG);
        currentStage.close();
        stage.show();
    }

    @FXML
    void abrirEntregas(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) botaoEntregas.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/fxml/Agendamentos_Entregas.fxml"));
        Scene agendamentosDefesasTG = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Agendamentos: Entregas");
        stage.setScene(agendamentosDefesasTG);
        currentStage.close();
        stage.show();
    }

    @FXML
    void abrirHome(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) botaoHome.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/fxml/Home.fxml"));
        Scene agendamentosDefesasTG = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Home");
        stage.setScene(agendamentosDefesasTG);
        currentStage.close();
        stage.show();
    }

}
