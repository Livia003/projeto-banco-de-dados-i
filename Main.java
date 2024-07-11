import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.*;
import data.ConnectionFactory;
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

        scene.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();

            System.out.println("X: " + x + ", Y: " + y);
        });

    }
    
    public static void main(String[] args) {
       /*  String sqlQuery = "SELECT * FROM app.reclamacao WHERE c_id = ?";
    try (Connection connection = new ConnectionFactory().getConnection();
         PreparedStatement pst = connection.prepareStatement(sqlQuery)) {
        
        pst.setInt(1, c_id);
        
        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                // Extrair e processar os campos da tabela
                int cId = rs.getInt("c_id");
                int eId = rs.getInt("e_id");
                int produtoId = rs.getInt("produto_id");
                String descricao = rs.getString("descricao");
                int id = rs.getInt("id");
                String status = rs.getString("status");
                String motivo = rs.getString("motivo");
                
                // Exemplo de processamento: imprimir os valores
                System.out.println("c_id: " + cId + ", e_id: " + eId + ", produto_id: " + produtoId +
                                   ", descricao: " + descricao + ", id: " + id + 
                                   ", status: " + status + ", motivo: " + motivo);
            }
        }
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }*/
        launch(args);
    }
}
