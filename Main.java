
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.util.Arrays;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Slider;
import javafx.application.Platform;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.*;
import controller.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

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
    }

    public static void main(String[] args) {
        launch(args);
    }
}
