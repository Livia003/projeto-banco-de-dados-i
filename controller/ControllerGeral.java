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
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
    private ImageView homeBackground;

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
    private ImageView complaintForm;

    @FXML
    private ImageView complaintViewer;

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
    private Button botaoFazerReclamacao;

    @FXML
    private Button botaoPedirDevolucao;

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
    private Label nomeCliente;

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

    @FXML
    private ChoiceBox<String> empresasCadastradas;

    @FXML
    private ChoiceBox<String> motivoReclamacao;

    @FXML
    private TextField idProduto;

    @FXML
    private TextField justificativaReclamacao;

    @FXML
    private Button botaoEnviarReclamacao;

    @FXML
    private ImageView botaoVerReclamacao;

    @FXML
    private ImageView jumpingBackLoginReclamacao;

    @FXML
    private ImageView logOutSymbol;

    @FXML
    private TextArea textAreaConsultaReclamacoes;

    ClienteController clienteController = new ClienteController();
    EmpresaController empresaController = new EmpresaController();

    int idCliente, idEmpresa;

    public void initialize(URL location, ResourceBundle resources) {
        telaInicial();

        Empresa empresa1 = new Empresa("Tech Solutions Ltda.", "techsolutions@example.com",
                "Especializada em soluções tecnológicas", "2023-05-01", "senha123");

        Empresa empresa2 = new Empresa("Express Logistica e Transporte", "expresslogistica@example.com",
                "Entregas rápidas e seguras em todo o país", "2023-05-02", "senha456");

        Empresa empresa3 = new Empresa("Comida Facil Delivery", "comidafacil@example.com",
                "Serviço de delivery de refeições práticas", "2023-05-03", "senha789");

        Empresa empresa4 = new Empresa("Construcoes Urbanas S.A.", "construcoesurbanas@example.com",
                "Projetos e obras para o desenvolvimento urbano", "2023-05-04", "senhaabc");

        Empresa empresa5 = new Empresa("Clinica Bem-Estar", "clinicabemestar@example.com",
                "Cuidando da saúde e bem-estar de nossos pacientes", "2023-05-05", "senhaxyz");

        empresasCadastradas.getItems().addAll(
                "Tech Solutions Ltda.",
                "Express Logistica e Transporte",
                "Comida Facil Delivery",
                "Construcoes Urbanas S.A.",
                "Clinica Bem-Estar");

        motivoReclamacao.getItems().addAll("Produto defeituoso ou danificado",
                "Produto incorreto",
                "Atraso na entrega",
                "Produto falsificado",
                "Problemas com uma conta",
                "Cobranca incorreta",
                "Falta de pecas ou acessorios",
                "Problemas com uma assinatura",
                "Nenhum dos motivos acima");
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

            atualizarNomeCliente(nome);

            Cliente novoCliente = new Cliente(nome, email, senha);
            clienteController.cadastrarNovoCliente(novoCliente);
            idCliente = novoCliente.getId();
            mostrarPaginaConfirmacao();

            campoCadastroClienteNome.clear();
            campoCadastroClienteEmail.clear();
            campoCadastroClienteSenha.clear();

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
            atualizarChoiceBoxEmpresas();
            mostrarPaginaConfirmacao();

            campoCadastroEmpresaNome.clear();
            campoCadastroEmpresaEmail.clear();
            campoCadastroEmpresaDescricao.clear();
            campoCadastroEmpresaData.clear();
            campoCadastroEmpresaSenha.clear();

        } catch (IllegalArgumentException e) {
            exibirMensagemErro(e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
        }

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

            ClienteController clienteController = new ClienteController();
            Cliente cliente = clienteController.buscarClientePorEmailESenha(email, senha);

            if (cliente == null) {
                throw new IllegalArgumentException("Email ou senha incorretos.");
            }

            idCliente = cliente.getId();
            atualizarNomeCliente(cliente.getNome());
            mostrarPaginaConfirmacao();

            campoLoginClienteEmail.clear();
            campoLoginClienteSenha.clear();

        } catch (IllegalArgumentException e) {
            exibirMensagemErro(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

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

            EmpresaController empresaController = new EmpresaController();
            Empresa empresa = empresaController.buscarEmpresaPorEmailESenha(email, senha);

            if (empresa == null) {
                throw new IllegalArgumentException("Email ou senha incorretos.");
            }

            idEmpresa = empresa.getId();
            mostrarPaginaConfirmacao();
            atualizarChoiceBoxEmpresas();

            campoCadastroEmpresaNome.clear();
            campoCadastroEmpresaEmail.clear();
            campoCadastroEmpresaDescricao.clear();
            campoCadastroEmpresaData.clear();
            campoCadastroEmpresaSenha.clear();

        } catch (IllegalArgumentException e) {
            exibirMensagemErro(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // BANCO DE DADOS
    }

    public void mostrarPaginaConfirmacao() {
        jumpingBackLoginCliente.setVisible(false);
        jumpingBackLoginEmpresa.setVisible(false);
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
                        mostrarHome();
                    }
                }));

        timeline.setCycleCount(5);
        timeline.play();
    }

    @FXML
    private void enviarReclamacao() {
        try {
            String empresaSelecionada = empresasCadastradas.getValue();
            String motivoSelecionado = motivoReclamacao.getValue();
            String produtoId = idProduto.getText();
            String justificativa = justificativaReclamacao.getText();

            if (empresaSelecionada == null || motivoSelecionado == null || produtoId.isEmpty()
                    || justificativa.isEmpty()) {
                throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
            }

            int produtoIdInt;

            try {
                produtoIdInt = Integer.parseInt(produtoId);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ID do produto deve ser um numero inteiro.");
            }

            EmpresaController empresaController = new EmpresaController();
            Empresa empresa = empresaController.buscarEmpresaPorNome(empresaSelecionada);

            if (empresa == null) {
                throw new IllegalArgumentException("Empresa nao encontrada.");
            }

            Reclamacao reclamacao = new Reclamacao(idCliente, empresa.getId(), produtoIdInt, justificativa);

            empresa.adicionarReclamacao(reclamacao);

            Cliente cliente = Cliente.buscarClientePorId(idCliente);
            if (cliente != null) {
                cliente.adicionarReclamacao(reclamacao);
            }

            empresasCadastradas.setValue(null);
            motivoReclamacao.setValue(null);
            idProduto.clear();
            justificativaReclamacao.clear();

            Alert alert = new Alert(AlertType.CONFIRMATION,
                    "Reclamacao enviada com sucesso! Uma resposta sera recebida em ate 72h.", ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    mostrarHome();
                }
            });

        } catch (IllegalArgumentException e) {
            exibirMensagemErro(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void consultarReclamacoes() {
        try {
            Cliente cliente = Cliente.buscarClientePorId(idCliente);

            if (cliente == null) {
                throw new IllegalArgumentException("Cliente nao encontrado.");
            }

            List<Reclamacao> reclamacoes = cliente.getReclamacoes();

            StringBuilder reclamacoesTexto = new StringBuilder();
            for (Reclamacao reclamacao : reclamacoes) {
                Empresa empresa = EmpresaController.buscarEmpresaPorId(reclamacao.getEmpresaId());

                reclamacoesTexto.append("\nRECLAMACAO NUMERO ").append(reclamacao.getId()).append("\n")
                        .append("STATUS: ").append(reclamacao.getStatus()).append("\n\n")
                        .append("ID CLIENTE: ").append(reclamacao.getClienteId()).append("\n")
                        .append("NOME DO CLIENTE: ")
                        .append(cliente != null ? cliente.getNome() : "Cliente não encontrado").append("\n")
                        .append("EMAIL DO CLIENTE: ")
                        .append(cliente != null ? cliente.getEmail() : "Email não encontrado").append("\n")
                        .append("EMPRESA: ").append(empresa != null ? empresa.getNome() : "Empresa não encontrada")
                        .append("\n")
                        .append("PRODUTO ID: ").append(reclamacao.getProdutoId()).append("\n")
                        .append("JUSTIFICATIVA: ").append(reclamacao.getDescricao()).append("\n\n");
            }

            textAreaConsultaReclamacoes.setStyle("-fx-font-weight: bold;");
            textAreaConsultaReclamacoes.setText(reclamacoesTexto.toString());

            esconderElementosDentroDoLogin();
            jumpingBackLoginReclamacao.setVisible(true);
            jumpingBackLoginReclamacao.toFront();
            complaintViewer.setVisible(true);
            textAreaConsultaReclamacoes.setVisible(true);

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

    private void atualizarChoiceBoxEmpresas() {
        empresasCadastradas.getItems().clear();
        empresasCadastradas.getItems().addAll(empresaController.getNomesEmpresas());
    }

    private void atualizarNomeCliente(String nome) {
        nomeCliente.setText(nome);
    }

    @FXML
    private void voltarLoginCliente() {
        telaInicial();
    }

    @FXML
    private void voltarLoginEmpresa() {
        telaInicial();
    }

    @FXML
    private void voltarFormReclamacao() {
        mostrarHome();
    }

    @FXML
    private void voltarParaOInicio() {
        homeBackground.setVisible(false);
        botaoPedirDevolucao.setVisible(false);
        botaoFazerReclamacao.setVisible(false);
        nomeCliente.setVisible(false);
        complaintForm.setVisible(false);
        jumpingBackLoginReclamacao.setVisible(false);
        esconderElementosDentroDoLogin();
        logOutSymbol.setVisible(false);
        // idCliente = (Integer) null;
        telaInicial();
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
        botaoPedirDevolucao.setVisible(false);
        botaoFazerReclamacao.setVisible(false);
        nomeCliente.setVisible(false);
        complaintForm.setVisible(false);
        empresasCadastradas.setVisible(false);
        motivoReclamacao.setVisible(false);
        idProduto.setVisible(false);
        justificativaReclamacao.setVisible(false);
        botaoEnviarReclamacao.setVisible(false);
        jumpingBackLoginReclamacao.setVisible(false);
        logOutSymbol.setVisible(false);
        botaoVerReclamacao.setVisible(false);
        textAreaConsultaReclamacoes.setVisible(false);
    }

    private void mostrarHome() {
        jumpingBackLoginCliente.setVisible(false);
        jumpingBackLoginEmpresa.setVisible(false);
        homeBackground.setVisible(true);
        botaoPedirDevolucao.setVisible(true);
        botaoFazerReclamacao.setVisible(true);
        nomeCliente.setVisible(true);
        complaintForm.setVisible(false);
        jumpingBackLoginReclamacao.setVisible(false);
        esconderElementosDentroDoLogin();
        logOutSymbol.setVisible(true);
        botaoVerReclamacao.setVisible(true);
        complaintViewer.setVisible(false);
    }

    @FXML
    private void fazerReclamacao() {
        botaoPedirDevolucao.setVisible(false);
        botaoFazerReclamacao.setVisible(false);
        nomeCliente.setVisible(false);
        complaintForm.setVisible(true);
        empresasCadastradas.setVisible(true);
        motivoReclamacao.setVisible(true);
        idProduto.setVisible(true);
        justificativaReclamacao.setVisible(true);
        botaoEnviarReclamacao.setVisible(true);
        jumpingBackLoginReclamacao.setVisible(true);
        logOutSymbol.setVisible(false);
        botaoVerReclamacao.setVisible(false);
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
        empresasCadastradas.setVisible(false);
        motivoReclamacao.setVisible(false);
        idProduto.setVisible(false);
        justificativaReclamacao.setVisible(false);
        botaoEnviarReclamacao.setVisible(false);
        jumpingBackLoginReclamacao.setVisible(false);
        botaoVerReclamacao.setVisible(false);
        textAreaConsultaReclamacoes.setVisible(false);

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
