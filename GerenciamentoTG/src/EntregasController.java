import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EntregasController {

    @FXML
    private Button botaoCadastrarEntrega;

    @FXML
    private Button botaoCadastrarNota;

    @FXML
    private Button botaoDevolutiva;

    @FXML
    private Button botaoHome;

    @FXML
    private Button dropdownAluno;

    @FXML
    private Button dropdownAtividade;

    @FXML
    private TextField textAluno;

    @FXML
    private TextField textAtividade;

    @FXML
    void abrirCadastrarEntrega(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/fxml/Entregas_Cadastrar_Entrega.fxml"));
        Scene cadastrarEntrega = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Entregas: Cadastrar Entrega");
        stage.setScene(cadastrarEntrega);  
        stage.show();
    }

    @FXML
    void abrirCadastrarNota(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/fxml/Entregas_Cadastrar_Nota.fxml"));
        Scene cadastrarNota = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Entregas: Cadastrar Nota");
        stage.setScene(cadastrarNota);  
        stage.show();
    }

    @FXML
    void abrirDevolutiva(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/fxml/Entregas_Devolutiva.fxml"));
        Scene devolutiva = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Entregas: Devolutiva");
        stage.setScene(devolutiva);  
        stage.show();
    }

    @FXML
    void abrirHome(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/fxml/Home.fxml"));
        Scene home = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Home");
        stage.setScene(home);  
        stage.show();
    }

}
