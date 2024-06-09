package controller;

import model.*;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.application.Platform;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.shape.Line;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControllerGeral implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView firstBackground;

    @FXML
    private ImageView jumpingBackLoginCliente;

    @FXML
    private ImageView jumpingBackLoginEmpresa;

    @FXML
    private ImageView clienteCadastroBackground;

    @FXML
    private ImageView empresaCadastroBackground;

    @FXML
    private ImageView clienteLoginBackground;

    @FXML
    private ImageView empresaLoginBackground;

    @FXML
    private ImageView thankYouBackground;

    @FXML
    private Button botaoInicialCliente;

    @FXML
    private Button botaoInicialEmpresa;

    @FXML
    private Button botaoLoginPelaPrimeiraVezCliente;

    @FXML
    private Button botaoLoginPelaPrimeiraVezEmpresa;

    @FXML
    private Button botaoLoginCliente;

    @FXML
    private TextField campoCadastroClienteNome;

    @FXML
    private TextField campoCadastroClienteEmail;

    @FXML
    private TextField campoCadastroClienteSenha;

    @FXML
    private TextField campoLoginClienteEmail;

    @FXML
    private TextField campoLoginClienteSenha;

    @FXML
    private Label labelLoginCliente;

    @FXML
    private Label labelLoginEmpresa;

    @FXML
    private Label counter;

    @FXML
    private TextField campoCadastroEmpresaNome;

    @FXML
    private TextField campoCadastroEmpresaEmail;

    @FXML
    private TextField campoCadastroEmpresaDescricao;

    @FXML
    private TextField campoCadastroEmpresaData;

    @FXML
    private TextField campoCadastroEmpresaSenha;

    @FXML
    private TextField campoLoginEmpresaEmail;

    @FXML
    private TextField campoLoginEmpresaSenha;

    @FXML
    private Button botaoLoginEmpresa;

    ClienteController clienteController = new ClienteController();
    EmpresaController empresaController = new EmpresaController();

    public void initialize(URL location, ResourceBundle resources) {
        telaInicial();
    }

    @FXML
    private void cadastroCliente() {
        try {
            String nome = campoCadastroClienteNome.getText();
            String email = campoCadastroClienteEmail.getText();
            String senha = campoCadastroClienteSenha.getText();

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
            }

            if (!email.contains("@")) {
                throw new IllegalArgumentException("Insira um e-mail valido.");
            }

            Cliente novoCliente = new Cliente(nome, email, senha);
            clienteController.cadastrarNovoCliente(novoCliente);
            mostrarPaginaConfirmacao();

        } catch (IllegalArgumentException e) {
            exibirMensagemErro(e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cadastroEmpresa() {
        try {
            String nome = campoCadastroEmpresaNome.getText();
            String email = campoCadastroEmpresaEmail.getText();
            String descricao = campoCadastroEmpresaDescricao.getText();
            String data = campoCadastroEmpresaData.getText();
            String senha = campoCadastroEmpresaSenha.getText();

            if (nome.isEmpty() || email.isEmpty() || descricao.isEmpty() || data.isEmpty() || senha.isEmpty()) {
                throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
            }

            if (!email.contains("@")) {
                throw new IllegalArgumentException("Insira um e-mail valido.");
            }

            Empresa novaEmpresa = new Empresa(nome, email, descricao, data, senha);
            empresaController.cadastrarNovaEmpresa(novaEmpresa);
            mostrarPaginaConfirmacao();

        } catch (IllegalArgumentException e) {
            exibirMensagemErro(e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void exibirMensagemErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro no preenchimento dos dados!");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    public void mostrarPaginaConfirmacao() {
        thankYouBackground.setVisible(true);
        counter.setVisible(true);
        esconderElementosDentroDoLogin();

        final int[] segundos = { 5 };

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(1),
                event -> {
                    segundos[0]--;
                    counter.setText(String.valueOf(segundos[0]));
                    if (segundos[0] == 0) {
                        counter.setVisible(false);
                        thankYouBackground.setVisible(false);
                        telaInicial();
                    }
                }));

        timeline.setCycleCount(5);
        timeline.play();
    }

    @FXML
    private void loginCliente() {
        try {
            String email = campoLoginClienteEmail.getText();
            String senha = campoLoginClienteSenha.getText();

            if (email.isEmpty() || senha.isEmpty()) {
                throw new IllegalArgumentException("Ambos os campos de email e senha devem ser preenchidos.");
            }

            if (!email.contains("@")) {
                throw new IllegalArgumentException("Insira um e-mail valido.");
            }

        } catch (IllegalArgumentException e) {
            exibirMensagemErro(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // BANCO DE DADOS
    }

    @FXML
    private void loginEmpresa() {
        try {
            String email = campoLoginEmpresaEmail.getText();
            String senha = campoLoginEmpresaSenha.getText();

            if (email.isEmpty() || senha.isEmpty()) {
                throw new IllegalArgumentException("Ambos os campos de email e senha devem ser preenchidos.");
            }

            if (!email.contains("@")) {
                throw new IllegalArgumentException("Insira um e-mail valido.");
            }

        } catch (IllegalArgumentException e) {
            exibirMensagemErro(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // BANCO DE DADOS
    }

    public void telaInicial() {
        firstBackground.setVisible(true);
        botaoInicialCliente.setVisible(true);
        botaoInicialEmpresa.setVisible(true);
        botaoLoginPelaPrimeiraVezCliente.setVisible(false);
        botaoLoginPelaPrimeiraVezEmpresa.setVisible(false);
        botaoLoginCliente.setVisible(false);
        campoCadastroClienteNome.setVisible(false);
        campoCadastroClienteSenha.setVisible(false);
        campoLoginClienteEmail.setVisible(false);
        campoLoginClienteSenha.setVisible(false);
        clienteCadastroBackground.setVisible(false);
        campoCadastroClienteEmail.setVisible(false);
        jumpingBackLoginCliente.setVisible(false);
        jumpingBackLoginEmpresa.setVisible(false);
        labelLoginCliente.setVisible(false);
        labelLoginEmpresa.setVisible(false);
        clienteLoginBackground.setVisible(false);
        empresaLoginBackground.setVisible(false);
        campoCadastroEmpresaNome.setVisible(false);
        campoCadastroEmpresaEmail.setVisible(false);
        campoCadastroEmpresaDescricao.setVisible(false);
        campoCadastroEmpresaData.setVisible(false);
        campoCadastroEmpresaSenha.setVisible(false);
        empresaCadastroBackground.setVisible(false);
        campoLoginEmpresaEmail.setVisible(false);
        campoLoginEmpresaSenha.setVisible(false);
        botaoLoginEmpresa.setVisible(false);
    }

    @FXML
    private void voltarLoginCliente() {
        telaInicial();
    }

    @FXML
    private void voltarLoginEmpresa() {
        telaInicial();
    }

    public void esconderElementosDentroDoLogin() {
        firstBackground.setVisible(false);
        botaoInicialCliente.setVisible(false);
        botaoInicialEmpresa.setVisible(false);
        campoCadastroClienteNome.setVisible(false);
        campoCadastroClienteEmail.setVisible(false);
        clienteCadastroBackground.setVisible(false);
        botaoLoginPelaPrimeiraVezCliente.setVisible(false);
        campoCadastroClienteSenha.setVisible(false);
        labelLoginCliente.setVisible(false);
        campoCadastroEmpresaNome.setVisible(false);
        campoCadastroEmpresaEmail.setVisible(false);
        campoCadastroEmpresaDescricao.setVisible(false);
        campoCadastroEmpresaData.setVisible(false);
        campoCadastroEmpresaSenha.setVisible(false);
        botaoLoginPelaPrimeiraVezEmpresa.setVisible(false);
        labelLoginEmpresa.setVisible(false);
    }

    @FXML
    private void botaoClienteEscolhido() {
        clienteCadastroBackground.setVisible(true);
        campoCadastroClienteNome.setVisible(true);
        campoCadastroClienteEmail.setVisible(true);
        botaoLoginPelaPrimeiraVezCliente.setVisible(true);
        firstBackground.setVisible(false);
        labelLoginCliente.setVisible(true);
        botaoInicialCliente.setVisible(false);
        botaoInicialEmpresa.setVisible(false);
        campoCadastroClienteSenha.setVisible(true);
        jumpingBackLoginCliente.setVisible(true);
        clienteLoginBackground.setVisible(false);
    }

    @FXML
    private void botaoEmpresaEscolhido() {

        empresaCadastroBackground.setVisible(true);
        firstBackground.setVisible(false);
        botaoInicialCliente.setVisible(false);
        botaoInicialEmpresa.setVisible(false);
        clienteLoginBackground.setVisible(false);
        campoCadastroEmpresaNome.setVisible(true);
        campoCadastroEmpresaEmail.setVisible(true);
        campoCadastroEmpresaDescricao.setVisible(true);
        campoCadastroEmpresaData.setVisible(true);
        campoCadastroEmpresaSenha.setVisible(true);
        botaoLoginPelaPrimeiraVezEmpresa.setVisible(true);
        jumpingBackLoginEmpresa.setVisible(true);
        labelLoginEmpresa.setVisible(true);
    }

    @FXML
    private void irParaLoginCliente() {
        jumpingBackLoginCliente.setVisible(true);
        jumpingBackLoginCliente.toFront();
        jumpingBackLoginCliente.setLayoutX(20);
        clienteLoginBackground.setVisible(true);
        esconderElementosDentroDoLogin();
        campoLoginClienteEmail.setVisible(true);
        campoLoginClienteSenha.setVisible(true);
        botaoLoginCliente.setVisible(true);
    }

    @FXML
    private void irParaLoginEmpresa() {
        campoLoginEmpresaEmail.setVisible(true);
        campoLoginEmpresaSenha.setVisible(true);
        jumpingBackLoginEmpresa.setVisible(true);
        jumpingBackLoginEmpresa.toFront();
        jumpingBackLoginEmpresa.setLayoutX(20);
        botaoLoginEmpresa.setVisible(true);
        empresaLoginBackground.setVisible(true);
        esconderElementosDentroDoLogin();
    }

}
