package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class PainelController implements Initializable {


    @FXML
    private ImageView Exit;

    @FXML
    private Label Menu;

    @FXML
    private Label MenuClose;
    
    @FXML
    private BorderPane borderPane;

    @FXML
    private JFXButton btnAgendamentos;

    @FXML
    private JFXButton btnRelatorios;

    @FXML
    private JFXButton btnSubmissoes;
    
    @FXML
    private JFXButton btnHome;
    
    @FXML
    private Button btnCSV;
   
    @FXML
    private AnchorPane mainpanel;
    
    @FXML
    private Pane rboxPane;
    
    @FXML
    private Pane paneHome;

    @FXML
    private Pane paneTop;

    @FXML
    private AnchorPane slider;
  
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Exit.setOnMouseClicked(event -> {
            System.exit(0);
        });
        slider.setTranslateX(-180);
        Menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-180);

            slide.setOnFinished((ActionEvent e)-> {
                Menu.setVisible(false);
                MenuClose.setVisible(true);
            });
        });

        MenuClose.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-180);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e)-> {
                Menu.setVisible(true);
                MenuClose.setVisible(false);
            });
        });
    }
    
    
    @FXML
    void painelAgendamentos(ActionEvent event) throws IOException {
    	AnchorPane view = FXMLLoader.load(getClass().getResource("/application/ui/AnchorAgendamentos.fxml"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/ui/VboxAgendamentos.fxml"));
        AnchorPane viewBar = loader.load();

        VboxAgendamentosController controller = loader.getController(); // passa o controle do BorderPanel para o controller
        controller.setBorderPane(borderPane); // define o atributo para o controllador VbixAgendamentos

        borderPane.getStylesheets().remove(getClass().getResource("/application/css/TelasIniciais.css").toExternalForm());
    	borderPane.getStylesheets().add(getClass().getResource("/application/css/TelasIniciais.css").toExternalForm());

        borderPane.setRight(viewBar);
    	borderPane.setCenter(view);

    }
    
    @FXML
    void painelRelatorios(ActionEvent event) throws IOException {
        Node nodeNoLadoDireito = borderPane.getRight(); //método para fechar qualquer fxml que esteja aberto nolado direito do borderpane
        if (nodeNoLadoDireito != null) {
            borderPane.getChildren().remove(nodeNoLadoDireito);
        }
        
    	AnchorPane view = FXMLLoader.load(getClass().getResource("/application/ui/AnchorRelatorios.fxml"));

    	borderPane.getStylesheets().remove(getClass().getResource("/application/css/TelasIniciais.css").toExternalForm());
        borderPane.getStylesheets().add(getClass().getResource("/application/css/TelasIniciais.css").toExternalForm());
    	
    	borderPane.setCenter(view);

    }

    @FXML
    void painelSubmissoes(ActionEvent event) throws IOException {
    	AnchorPane view = FXMLLoader.load(getClass().getResource("/application/ui/AnchorSubmissoes.fxml"));
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/ui/VboxSubmissoes.fxml"));
    	AnchorPane viewBar = loader.load();
    	
        VboxSubmissoesController controller = loader.getController(); // passa o controle do BorderPanel para o controller
        controller.setBorderPane(borderPane); // define o atributo para o controllador VbixAgendamentos

        borderPane.getStylesheets().remove(getClass().getResource("/application/css/TelasIniciais.css").toExternalForm());
        borderPane.getStylesheets().add(getClass().getResource("/application/css/TelasIniciais.css").toExternalForm());

        borderPane.setRight(viewBar);
    	borderPane.setCenter(view);

    }
    
    @FXML
    void telaInicial(ActionEvent event) {
    	borderPane.getStylesheets().remove(getClass().getResource("/application/css/TelasIniciais.css").toExternalForm());
    	borderPane.getStylesheets().add(getClass().getResource("/application/css/Painel.css").toExternalForm());
    	
    	borderPane.setCenter(paneHome);
    	borderPane.setRight(rboxPane);

    }
    
    @FXML
    void importaCSV(ActionEvent event) {

    }
    
}
