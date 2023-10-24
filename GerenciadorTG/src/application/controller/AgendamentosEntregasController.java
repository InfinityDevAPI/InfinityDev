package application.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AgendamentosEntregasController {

    @FXML
    private Button botaoConfirmar;

    @FXML
    private Button botaoDefesasTG;

    @FXML
    private Button botaoHome;

    @FXML
    private Button botaoTG1;

    @FXML
    private Button botaoTG12;

    @FXML
    private Button botaoTG2;

    @FXML
    private DatePicker dropdownCalendario;

    @FXML
    private Button dropdownEntrega;

    @FXML
    private TextArea textDescEntrega;

    @FXML
    private TextField textEntrega;

    @FXML
    private TextField textNumEntregas;

    @FXML
    void abrirDefesasTG(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) botaoDefesasTG.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/ui/AgendamentosDefesasTG.fxml"));
        Scene agendamentosDefesasTG = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Agendamentos: Defesas de TG");
        stage.setScene(agendamentosDefesasTG);
        stage.setResizable(false);
        currentStage.close();
        stage.show();
    }

    @FXML
    void abrirHome(MouseEvent event) throws IOException {
        Stage currentStage = (Stage) botaoHome.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/ui/Home.fxml"));
        Scene home = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Home");
        stage.setScene(home);
        stage.setResizable(false);
        currentStage.close();
        stage.show();
    }

    @FXML
    void confirmarEntrega(MouseEvent event) {
        JOptionPane.showMessageDialog(null, "Entrega confirmada!!!", "Confirmado!", 1);
    }

}