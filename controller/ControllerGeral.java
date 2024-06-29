package controller;

import model.*;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

import java.util.HashSet;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

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
    private ImageView returnForm;

    @FXML
    private ImageView complaintViewer;

    @FXML
    private ImageView returnViewer;

    @FXML
    private ImageView homeSymbol;

    @FXML
    private ImageView complaintDiv;

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
    private ChoiceBox<String> empresasCadastradasDevolucao;

    @FXML
    private ChoiceBox<String> motivoReclamacao;

    @FXML
    private ChoiceBox<String> motivoDevolucao;

    @FXML
    private TextField idProduto;

    @FXML
    private TextField idProdutoDevolucao;

    @FXML
    private TextField justificativaReclamacao;

    @FXML
    private TextField justificativaDevolucao;

    @FXML
    private TextField dataCompraDevolucao;

    @FXML
    private Button botaoEnviarReclamacao;

    @FXML
    private Button botaoEnviarDevolucao;

    @FXML
    private TextField quantidadesItensDevolucao;

    @FXML
    private TextField idSubstituicaoDevolucao;

    @FXML
    private TextField descricaoItemDevolucao;

    @FXML
    private ImageView botaoVerReclamacao;

    @FXML
    private ImageView botaoVerDevolucao;

    @FXML
    private ImageView jumpingBackLoginReclamacao;

    @FXML
    private ImageView logOutSymbol;

    @FXML
    private TextArea textAreaConsultaReclamacoes;

    @FXML
    private VBox reclamacoesVBox;

    @FXML
    private VBox mainVBox;

    @FXML
    private TextArea textAreaConsultaDevolucoes;

    @FXML
    private VBox mainVBoxDevolucoes;

    @FXML
    private VBox devolucoesVBox;

    @FXML
    private VBox mainVBoxDevolucoesEmpresa;

    @FXML
    private VBox devolucoesVBoxEmpresa;

    @FXML
    private ImageView homeCompanyBackground;

    @FXML
    private VBox mainVBoxReclamacaoesEmpresa;

    @FXML
    private VBox reclamacoesVBoxEmpresa;

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

        empresasCadastradasDevolucao.getItems().addAll(
                "Tech Solutions Ltda.",
                "Express Logistica e Transporte",
                "Comida Facil Delivery",
                "Construcoes Urbanas S.A.",
                "Clinica Bem-Estar");

        motivoDevolucao.getItems().addAll("Produto defeituoso ou danificado",
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
            mostrarPaginaConfirmacao(1);

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
            idEmpresa = novaEmpresa.getId();
            atualizarChoiceBoxEmpresas();
            mostrarPaginaConfirmacao(0);

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
            mostrarPaginaConfirmacao(1);

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
            mostrarPaginaConfirmacao(0);
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

    public void mostrarPaginaConfirmacao(int decideHome) {
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
                        if (decideHome == 0) {
                            mostrarHomeEmpresa();
                        } else {
                            mostrarHomeCliente();
                        }
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
                    "Reclamacao enviada com sucesso! Uma resposta sera recebida em ate 72h. Acompanhe o status em nosso menu na Home.",
                    ButtonType.OK);
            alert.setHeaderText(null);
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    mostrarHomeCliente();
                }
            });

        } catch (IllegalArgumentException e) {
            exibirMensagemErro(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void enviarDevolucao() {
        try {
            String empresaSelecionada = empresasCadastradasDevolucao.getValue();
            String motivoSelecionado = motivoDevolucao.getValue();
            String produtoId = idProdutoDevolucao.getText();
            String justificativa = justificativaDevolucao.getText();
            String quantidadesItens = quantidadesItensDevolucao.getText();
            String idSubstituicao = idSubstituicaoDevolucao.getText();
            String descricaoItem = descricaoItemDevolucao.getText();

            if (empresaSelecionada == null || motivoSelecionado == null || produtoId.isEmpty()
                    || justificativa.isEmpty() || quantidadesItens.isEmpty() || idSubstituicao.isEmpty()
                    || descricaoItem.isEmpty()) {
                throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
            }

            int produtoIdInt;

            try {
                produtoIdInt = Integer.parseInt(produtoId);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ID do produto deve ser um numero inteiro.");
            }

            int quantidadeItensInt;
            try {
                quantidadeItensInt = Integer.parseInt(quantidadesItens);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("A quantidade de itens deve ser um numero inteiro.");
            }

            int idSubstituicaoInt;
            try {
                idSubstituicaoInt = Integer.parseInt(idSubstituicao);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ID de substituicao deve ser um numero inteiro.");
            }

            EmpresaController empresaController = new EmpresaController();
            Empresa empresa = empresaController.buscarEmpresaPorNome(empresaSelecionada);

            if (empresa == null) {
                throw new IllegalArgumentException("Empresa nao encontrada.");
            }

            Devolucao devolucao = new Devolucao(idCliente, empresa.getId(), produtoIdInt, descricaoItem,
                    motivoSelecionado, quantidadeItensInt, idSubstituicaoInt);

            empresa.adicionarDevolucao(devolucao);

            empresasCadastradasDevolucao.setValue(null);
            motivoDevolucao.setValue(null);
            idProdutoDevolucao.clear();
            justificativaDevolucao.clear();
            quantidadesItensDevolucao.clear();
            idSubstituicaoDevolucao.clear();
            descricaoItemDevolucao.clear();
            dataCompraDevolucao.clear();

            Alert alert = new Alert(AlertType.CONFIRMATION,
                    "Pedido de devolucao enviado. Acompanhe o status em nosso menu na Home.", ButtonType.OK);

            alert.setHeaderText(null);
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    mostrarHomeCliente();
                }
            });

            Cliente cliente = Cliente.buscarClientePorId(idCliente);
            if (cliente != null) {
                cliente.adicionarDevolucao(devolucao);
            }
        } catch (IllegalArgumentException e) {
            exibirMensagemErro(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void consultarDevolucoes() {
        Cliente cliente = Cliente.buscarClientePorId(idCliente);

        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }

        List<Devolucao> devolucoes = cliente.getDevolucoes();

        devolucoesVBox.getChildren().clear();

        Set<Integer> devolucoesExibidas = new HashSet<>();

        for (Devolucao devolucao : devolucoes) {
            if (!devolucoesExibidas.contains(devolucao.getId())) {
                Empresa empresa = EmpresaController.buscarEmpresaPorId(devolucao.getEmpresaId());
                adicionarDevolucao(devolucao, cliente, empresa);
                devolucoesExibidas.add(devolucao.getId());
            }
        }

        esconderElementosDentroDoLogin();
        jumpingBackLoginReclamacao.setVisible(true);
        jumpingBackLoginReclamacao.toFront();
        returnViewer.setVisible(true);
        devolucoesVBox.setVisible(true);
        mainVBoxDevolucoes.setVisible(true);
    }

    @FXML
    private void consultarReclamacoes() {
        try {
            Cliente cliente = Cliente.buscarClientePorId(idCliente);

            if (cliente == null) {
                throw new IllegalArgumentException("Cliente não encontrado.");
            }

            List<Reclamacao> reclamacoes = cliente.getReclamacoes();

            reclamacoesVBox.getChildren().clear();

            Set<Integer> reclamacoesExibidas = new HashSet<>();

            for (Reclamacao reclamacao : reclamacoes) {
                if (!reclamacoesExibidas.contains(reclamacao.getId())) {
                    Empresa empresa = EmpresaController.buscarEmpresaPorId(reclamacao.getEmpresaId());
                    adicionarReclamacao(reclamacao, cliente, empresa);
                    reclamacoesExibidas.add(reclamacao.getId());
                }
            }

            esconderElementosDentroDoLogin();
            jumpingBackLoginReclamacao.setVisible(true);
            jumpingBackLoginReclamacao.toFront();
            complaintViewer.setVisible(true);
            reclamacoesVBox.setVisible(true);
            mainVBox.setVisible(true);

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

    public void adicionarReclamacao(Reclamacao reclamacao, Cliente cliente, Empresa empresa) {

        if (reclamacao == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Tente novamente!");
            alert.setHeaderText(null);
            alert.setContentText("Voce nao possui reclamacoes cadastradas.");
            alert.showAndWait();
            return;
        }

        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-padding: 10;");

        VBox labelsVBox = new VBox(3);
        labelsVBox.setStyle("-fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 10px;");

        Label idLabel = new Label("ID Cliente: " + reclamacao.getClienteId());
        idLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label nomeLabel = new Label("Nome do Cliente: " + reclamacao.getClienteId());
        nomeLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label emailLabel = new Label("Email do Cliente: " + cliente.getNome());
        emailLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label empresaLabel = new Label("Empresa: " + empresa.getNome());
        empresaLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label produtoLabel = new Label("Produto ID: " + reclamacao.getProdutoId());
        produtoLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label justificativaLabel = new Label("Justificativa: " + reclamacao.getDescricao());
        justificativaLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label statusLabel = new Label("Status: " + reclamacao.getStatus().toString());
        statusLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        labelsVBox.getChildren().addAll(idLabel, nomeLabel, emailLabel, empresaLabel, produtoLabel, justificativaLabel,
                statusLabel);

        pane.setCenter(labelsVBox);
        reclamacoesVBox.getChildren().add(pane);

    }

    public void adicionarDevolucao(Devolucao devolucao, Cliente cliente, Empresa empresa) {

        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-padding: 10;");

        VBox labelsVBox = new VBox(3);
        labelsVBox.setStyle("-fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 10px;");

        Label idLabel = new Label("ID Cliente: " + devolucao.getClienteId());
        idLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label empresaLabel = new Label("Empresa: " + empresa.getNome());
        empresaLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label produtoLabel = new Label("Produto ID: " + devolucao.getProdutoId());
        produtoLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label justificativaLabel = new Label("Justificativa: " + devolucao.getMotivo());
        justificativaLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label statusLabel = new Label("Status: " + devolucao.getStatus().toString());
        statusLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        labelsVBox.getChildren().addAll(idLabel, empresaLabel, produtoLabel, justificativaLabel, statusLabel);

        pane.setCenter(labelsVBox);
        devolucoesVBox.getChildren().add(pane);
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
        mostrarHomeCliente();
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
        telaInicial();
    }

    private void mostrarHomeCliente() {
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
        botaoVerDevolucao.setVisible(true);
        complaintViewer.setVisible(false);
        returnForm.setVisible(false);
        reclamacoesVBox.setVisible(false);
        mainVBox.setVisible(false);
        returnViewer.setVisible(false);
        returnForm.setVisible(false);
        devolucoesVBox.setVisible(false);
        mainVBoxDevolucoes.setVisible(false);
        homeSymbol.setVisible(true);
    }

    private void mostrarHomeEmpresa() {
        jumpingBackLoginCliente.setVisible(false);
        jumpingBackLoginEmpresa.setVisible(false);
        esconderElementosDentroDoLogin();
        homeCompanyBackground.setVisible(true);
        mainVBoxReclamacaoesEmpresa.setVisible(true);
        reclamacoesVBoxEmpresa.setVisible(true);
        mainVBoxDevolucoesEmpresa.setVisible(true);
        devolucoesVBoxEmpresa.setVisible(true);
        logOutSymbol.setVisible(true);
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
        botaoVerDevolucao.setVisible(false);
        homeSymbol.setVisible(false);
        buscarTodasAsReclamacoesDaEmpresa();

    }

    private void buscarTodasAsReclamacoesDaEmpresa() {
        try {

            reclamacoesVBoxEmpresa.getChildren().clear();

            Empresa empresa = Empresa.buscarEmpresaPorId(idEmpresa);

            if (empresa == null) {
                throw new IllegalArgumentException("Empresa não encontrada.");
            }

            List<Reclamacao> reclamacoes = empresa.getReclamacoesRecebidas();

            for (Reclamacao reclamacao : reclamacoes) {
                adicionarReclamacaoEmpresa(reclamacao, empresa);
            }

            mainVBoxReclamacaoesEmpresa.setVisible(true);
            reclamacoesVBoxEmpresa.setVisible(true);

        } catch (IllegalArgumentException e) {
            exibirMensagemErro(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void adicionarReclamacaoEmpresa(Reclamacao reclamacao, Empresa empresa) {
        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-padding: 10;");

        VBox labelsVBox = new VBox(3);
        labelsVBox.setStyle("-fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 10px;");

        Label empresaLabel = new Label("Empresa: " + empresa.getNome());
        empresaLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label produtoLabel = new Label("Produto ID: " + reclamacao.getProdutoId());
        produtoLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label justificativaLabel = new Label("Justificativa: " + reclamacao.getDescricao());
        justificativaLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label statusLabel = new Label("Status: " + reclamacao.getStatus().toString());
        statusLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        labelsVBox.getChildren().addAll(empresaLabel, produtoLabel,
                justificativaLabel, statusLabel);

        pane.setCenter(labelsVBox);
        reclamacoesVBox.getChildren().add(pane);
    }

    @FXML
    private void fazerDevolucao() {
        botaoPedirDevolucao.setVisible(false);
        botaoFazerReclamacao.setVisible(false);
        nomeCliente.setVisible(false);
        returnForm.setVisible(true);
        motivoDevolucao.setVisible(true);
        empresasCadastradasDevolucao.setVisible(true);
        logOutSymbol.setVisible(false);
        botaoVerReclamacao.setVisible(false);
        idProdutoDevolucao.setVisible(true);
        dataCompraDevolucao.setVisible(true);
        justificativaDevolucao.setVisible(true);
        idSubstituicaoDevolucao.setVisible(true);
        descricaoItemDevolucao.setVisible(true);
        botaoEnviarDevolucao.setVisible(true);
        quantidadesItensDevolucao.setVisible(true);
        jumpingBackLoginReclamacao.setVisible(true);
        jumpingBackLoginReclamacao.toFront();
        jumpingBackLoginReclamacao.toFront();
        homeSymbol.setVisible(false);
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
        empresasCadastradasDevolucao.setVisible(false);
        motivoReclamacao.setVisible(false);
        motivoDevolucao.setVisible(false);
        idProduto.setVisible(false);
        idProdutoDevolucao.setVisible(false);
        dataCompraDevolucao.setVisible(false);
        justificativaReclamacao.setVisible(false);
        botaoEnviarReclamacao.setVisible(false);
        jumpingBackLoginReclamacao.setVisible(false);
        botaoVerReclamacao.setVisible(false);
        textAreaConsultaReclamacoes.setVisible(false);
        justificativaDevolucao.setVisible(false);
        quantidadesItensDevolucao.setVisible(false);
        idSubstituicaoDevolucao.setVisible(false);
        descricaoItemDevolucao.setVisible(false);
        botaoEnviarDevolucao.setVisible(false);
        reclamacoesVBox.setVisible(false);
        mainVBox.setVisible(false);
        botaoVerDevolucao.setVisible(false);
        homeSymbol.setVisible(false);
        empresaCadastroBackground.setVisible(false);

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
        empresasCadastradasDevolucao.setVisible(false);
        motivoReclamacao.setVisible(false);
        motivoDevolucao.setVisible(false);
        idProduto.setVisible(false);
        justificativaReclamacao.setVisible(false);
        botaoEnviarReclamacao.setVisible(false);
        jumpingBackLoginReclamacao.setVisible(false);
        logOutSymbol.setVisible(false);
        botaoVerReclamacao.setVisible(false);
        botaoVerDevolucao.setVisible(false);
        textAreaConsultaReclamacoes.setVisible(false);
        idProdutoDevolucao.setVisible(false);
        dataCompraDevolucao.setVisible(false);
        justificativaDevolucao.setVisible(false);
        quantidadesItensDevolucao.setVisible(false);
        idSubstituicaoDevolucao.setVisible(false);
        descricaoItemDevolucao.setVisible(false);
        botaoEnviarDevolucao.setVisible(false);
        reclamacoesVBox.setVisible(false);
        mainVBox.setVisible(false);
        homeSymbol.setVisible(false);
        homeCompanyBackground.setVisible(false);
        mainVBoxReclamacaoesEmpresa.setVisible(false);
        reclamacoesVBoxEmpresa.setVisible(false);
        mainVBoxDevolucoesEmpresa.setVisible(false);
        devolucoesVBoxEmpresa.setVisible(false);

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
