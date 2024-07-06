import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import controller.*;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

    private ControllerGeral controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/layout.fxml"));

        controller = new ControllerGeral();
        loader.setController(controller);

        Parent root = loader.load();
        Scene scene = new Scene(root, 1000, 700);

        primaryStage.setTitle("Fale Feedback");
        Image icon = new Image("/util/icon.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
