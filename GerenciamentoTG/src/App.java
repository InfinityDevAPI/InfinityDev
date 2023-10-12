
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fl=new FXMLLoader(getClass().getResource("resources/fxml/Home.fxml"));
        System.out.println(getClass().getResource("resources/fxml/Home.fxml"));
        Parent r= fl.load();
        Scene t=new Scene(r);
        primaryStage.setTitle("Teste");
        primaryStage.setScene(t);
        primaryStage.show();
        }
}
