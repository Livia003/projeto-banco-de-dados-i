import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

        scene.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();
            System.out.print("\n X = " + x + ", Y = " + y);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
