package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 
import data.ClienteDAOjbdc;
import data.ConnectionFactory;
import data.DevolucaoDAOjbdc;
import data.EmpresaDAOjbdc;
import data.ReclamacaoDAOjbdc;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.Cliente;
import model.Devolucao;
import model.Empresa;
import model.Reclamacao;
import model.StatusDevolucao;
import model.StatusReclamacao;

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
    private ImageView concederDevolucaoBackground;

    @FXML
    private ImageView complaintForm;

    @FXML
    private ImageView returnForm;

    @FXML
    private ImageView sucessoResponderReclamacao;

    @FXML
    private Label nomeClienteReclamacaoLabel;

    @FXML
    private Label cpfClienteReclamacaoLabel;

    @FXML
    private Label emailClienteReclamacaoLabel;

    @FXML
    private ImageView complaintViewer;

    @FXML
    private ImageView sucessoEnvioReclamacao;

    @FXML
    private ImageView returnViewer;

    @FXML
    private ImageView homeSymbol;

    @FXML
    private ImageView responderReclamacaoBackground;

    @FXML
    private ImageView complaintDiv;

    @FXML
    private Button botaoInicialCliente;

    @FXML
    private Button botaoInicialEmpresa;

    @FXML
    private Button botaoReclamacaoEnviada;

    @FXML
    private Button botaoLoginPelaPrimeiraVezCliente;

    @FXML
    private Button botaoLoginPelaPrimeiraVezEmpresa;

    @FXML
    private Button botaoLoginCliente;

    @FXML
    private Button botaoFazerReclamacao;

    @FXML
    private Button botaoRespostaReclamacaoEnviada;

    @FXML
    private Button botaoPedirDevolucao;

    @FXML
    private TextField campoCadastroClienteNome;

    @FXML
    private TextField campoCadastroClienteEmail;

    @FXML
    private PasswordField campoCadastroClienteSenha;

    @FXML
    private TextField campoLoginClienteEmail;

    @FXML
    private PasswordField campoLoginClienteSenha;

    @FXML
    private Label labelLoginCliente;

    @FXML
    private Label labelLoginEmpresa;

    @FXML
    private Label nomeCliente;

    @FXML
    private Label nomeEmpresa;

    @FXML
    private Label counter;

    @FXML
    private TextArea respostaReclamacaoTextArea;

    @FXML
    private TextArea detalhamentoClienteReclamacaoLabel;

    @FXML
    private Button botaoResponderReclamacao;

    @FXML
    private TextField campoCadastroEmpresaNome;

    @FXML
    private TextField campoCadastroEmpresaEmail;

    @FXML
    private TextField campoCadastroEmpresaDescricao;

    @FXML
    private DatePicker campoCadastroEmpresaData;

    @FXML
    private TextField campoCadastroEmpresaCNPJ;

    @FXML
    private PasswordField campoCadastroEmpresaSenha;

    @FXML
    private TextField campoLoginEmpresaEmail;

    @FXML
    private TextField campoCadastroClienteCPF;

    @FXML
    private TextField campoCadastroClienteTelefone;

    @FXML
    private TextField campoCadastroClienteEndereco;

    @FXML
    private DatePicker campoCadastroClienteDataNascimento;

    @FXML
    private TextField campoLoginEmpresaSenha;

    @FXML
    private Button botaoLoginEmpresa;

    @FXML
    private TextField empresasCadastradas;
    //private ChoiceBox<String> empresasCadastradas;

    @FXML
    private TextField empresasCadastradasDevolucao;
    //private ChoiceBox<String> empresasCadastradasDevolucao;

    @FXML
    private ChoiceBox<String> motivoReclamacao;

    @FXML
    private ChoiceBox<String> motivoDevolucao;

    @FXML
    private TextField idProduto;

    @FXML
    private TextField idProdutoDevolucao;

    @FXML
    private TextField descricao;

    @FXML
    private TextField justificativaDevolucao;

    @FXML
    private DatePicker dataCompraDevolucao;

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

    @FXML
    private VBox loginBackground;

    @FXML
    private Label motivoReclamacaoLabel;

    @FXML
    private Label motivoDevolucaoLabel;

    @FXML
    private Label nomeClienteDevolucaoLabel;

    @FXML
    private Label cpfClienteDevolucaoLabel;

    @FXML
    private Label emailClienteDevolucaoLabel;

    @FXML
    private Label dataCompraDevolucaoLabel;

    @FXML
    private Label idProdutoDevolucaoLabel;

    @FXML
    private Label quantidadeProdutoDevolucaoLabel;

    @FXML
    private TextArea substituicaoReembolsoDevolucaoTextArea;

    @FXML
    private TextArea IDSubstituicaoDevolucaoTextArea;

    @FXML
    private RadioButton opcaoDevolucaoReembolso;

    @FXML
    private RadioButton opcaoDevolucaoSubsituicao;

    @FXML
    private RadioButton opcaoDevolucaoNegar;

    @FXML
    private Button botaoDevolucaoConcedidaEnviada;

    @FXML
    private TextArea detalhamentoDevolucaoTextArea;

    @FXML
    private ImageView sucessoConcederDevolucao;

    @FXML
    private ImageView negacaoConcederDevolucao;

    ClienteController clienteController = new ClienteController();
    EmpresaController empresaController = new EmpresaController();
    ClienteDAOjbdc cDao = new ClienteDAOjbdc();
    EmpresaDAOjbdc eDao = new EmpresaDAOjbdc();
    DevolucaoDAOjbdc dDao = new DevolucaoDAOjbdc();
    ReclamacaoDAOjbdc rDAO = new ReclamacaoDAOjbdc();

    int idCliente, idEmpresa;

    private FadeTransition fadeTransition;

    public void initialize(URL location, ResourceBundle resources) {
        telaInicial();

        motivoReclamacao.getItems().addAll("Produto defeituoso ou danificado",
                "Produto incorreto",
                "Atraso na entrega",
                "Produto falsificado",
                "Problemas com uma conta",
                "Cobranca incorreta",
                "Falta de pecas ou acessorios",
                "Problemas com uma assinatura",
                "Nenhum dos motivos acima");

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
            String cpfStr = campoCadastroClienteCPF.getText();
            String telefoneStr = campoCadastroClienteTelefone.getText();
            String endereco = campoCadastroClienteEndereco.getText();
            LocalDate dataNascimento = campoCadastroClienteDataNascimento.getValue();

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || cpfStr.isEmpty() || telefoneStr.isEmpty()
                    || endereco.isEmpty() || dataNascimento == null) {
                throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
            }

            if (!verificarFormatoEmail(email)) {
                throw new IllegalArgumentException("Email invalido. Verifique o formato.");
            }

            if (!verificarFormatoCpf(cpfStr)) {
                throw new IllegalArgumentException("CPF inválido");
            }
            atualizarNomeCliente(nome);
            long cpf = Long.parseLong(cpfStr);
            long telefone = Long.parseLong(telefoneStr);
            Date dataNascimentoDate = java.sql.Date.valueOf(dataNascimento);

            Cliente novoCliente = new Cliente(nome, email, senha, cpf, dataNascimentoDate, telefone, endereco);
            clienteController.cadastrarNovoCliente(novoCliente);
            idCliente = novoCliente.getId();
            mostrarPaginaConfirmacao(1);
            cDao.createCliente(novoCliente);

            campoCadastroClienteNome.clear();
            campoCadastroClienteEmail.clear();
            campoCadastroClienteSenha.clear();
            campoCadastroClienteCPF.clear();
            campoCadastroClienteTelefone.clear();
            campoCadastroClienteEndereco.clear();
            campoCadastroClienteDataNascimento.setValue(null);

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
            String senha = campoCadastroEmpresaSenha.getText();
            String cnpjStr = campoCadastroEmpresaCNPJ.getText();
            long cnpj = Long.parseLong(cnpjStr);
            LocalDate data = campoCadastroEmpresaData.getValue();
            
            if (nome.isEmpty() || email.isEmpty() || descricao.isEmpty() || data == null || senha.isEmpty()) {
                throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
            }

            if (!verificarFormatoEmail(email)) {
                throw new IllegalArgumentException("Email invalido. Verifique o formato.");
            }
            Date dataDate = java.sql.Date.valueOf(data);
            atualizarNomeEmpresa(nome);
            Empresa novaEmpresa = new Empresa(nome, email, descricao, dataDate, senha, cnpj);
            empresaController.cadastrarNovaEmpresa(novaEmpresa);
            idEmpresa = novaEmpresa.getId();
            eDao.createEmpresa(novaEmpresa);
            mostrarPaginaConfirmacao(0);

            campoCadastroEmpresaNome.clear();
            campoCadastroEmpresaEmail.clear();
            campoCadastroEmpresaDescricao.clear();
            campoCadastroEmpresaData.setValue(null);
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

            campoLoginClienteEmail.toFront();
            campoLoginClienteSenha.toFront();

            String email = campoLoginClienteEmail.getText();
            String senha = campoLoginClienteSenha.getText();

            if (email.isEmpty() || senha.isEmpty()) {
                throw new IllegalArgumentException("Ambos os campos de e-mail e senha devem ser preenchidos.");
            }

            if (!verificarFormatoEmail(email)) {
                throw new IllegalArgumentException("Email invalido. Verifique o formato.");
            }

            Cliente cliente = cDao.readCliente(email);
            if (cliente == null || !cliente.getSenha().equals(senha)) {
                throw new IllegalArgumentException("Email ou senha incorretos.");
            }

            idCliente = cliente.getId();
            System.out.println(cliente.getId());
            atualizarNomeCliente(cliente.getNome());
            mostrarPaginaConfirmacao(1);

            campoLoginClienteEmail.clear();
            campoLoginClienteSenha.clear();
            campoLoginClienteEmail.setVisible(false);
            campoLoginClienteSenha.setVisible(false);

        } catch (IllegalArgumentException e) {
            exibirMensagemErro(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loginEmpresa() {
        try {

            campoLoginEmpresaEmail.toFront();
            campoLoginEmpresaSenha.toFront();

            campoLoginEmpresaEmail.setVisible(true);
            campoLoginEmpresaSenha.setVisible(true);

            String email = campoLoginEmpresaEmail.getText();
            String senha = campoLoginEmpresaSenha.getText();

            if (email.isEmpty() || senha.isEmpty()) {
                throw new IllegalArgumentException("Ambos os campos de e-mail e senha devem ser preenchidos.");
            }

            if (!verificarFormatoEmail(email)) {
                throw new IllegalArgumentException("Email inválido. Verifique o formato.");
            }
            Empresa empresa = eDao.readEmpresa(email);
            if (empresa == null || !empresa.getSenha().equals(senha)) {
                throw new IllegalArgumentException("Email ou senha incorretos.");
            }

            idEmpresa = empresa.getId();
            System.out.println(idEmpresa);
            mostrarPaginaConfirmacao(0);
            atualizarNomeEmpresa(empresa.getNome());
            buscarTodasAsReclamacoesAgrupadasPorEmpresa(idEmpresa);

            campoCadastroEmpresaNome.clear();
            campoCadastroEmpresaEmail.clear();
            campoCadastroEmpresaDescricao.clear();
            campoCadastroEmpresaData.setValue(null);
            campoCadastroEmpresaSenha.clear();

        } catch (IllegalArgumentException e) {
            exibirMensagemErro(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarPaginaConfirmacao(int decideHome) {
        jumpingBackLoginCliente.setVisible(false);
        jumpingBackLoginEmpresa.setVisible(false);
        campoLoginEmpresaEmail.setVisible(false);
        campoLoginEmpresaSenha.setVisible(false);
        counter.setVisible(true);
        esconderElementosDentroDoLogin();

        thankYouBackground.setOpacity(0.0);
        thankYouBackground.setVisible(true);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), thankYouBackground);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();

        final int[] segundos = { 5 };
        counter.setText(String.valueOf(segundos[0]));
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    segundos[0]--;
                    counter.setText(String.valueOf(segundos[0]));
                    if (segundos[0] == 0) {
                        fadeTransition.stop();
                        counter.setVisible(false);
                        thankYouBackground.setVisible(false);
                        if (decideHome == 0) {
                            mostrarHomeEmpresa();
                        } else {
                            mostrarHomeCliente();
                        }
                    }
                }));
        timeline.setCycleCount(segundos[0]);
        timeline.play();
    }

    public void mostrarPaginaConfirmacaoLogin(int decideHome) {
        jumpingBackLoginCliente.setVisible(false);
        jumpingBackLoginEmpresa.setVisible(false);
        clienteLoginBackground.setVisible(false);
        empresaLoginBackground.setVisible(false);
        campoLoginEmpresaEmail.setVisible(false);
        campoLoginEmpresaSenha.setVisible(false);
        counter.setVisible(true);
        counter.setStyle("-fx-text-fill: #0057FF;");
        esconderElementosDentroDoLogin();

        loginBackground.setOpacity(0.0);
        loginBackground.setVisible(true);
        loginBackground.toFront();

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), loginBackground);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();

        final int[] segundos = { 5 };
        counter.setText(String.valueOf(segundos[0]));
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    segundos[0]--;
                    counter.setText(String.valueOf(segundos[0]));
                    if (segundos[0] == 0) {
                        fadeTransition.stop();
                        counter.setVisible(false);
                        loginBackground.setVisible(false);
                        if (decideHome == 0) {
                            mostrarHomeEmpresa();
                        } else {
                            mostrarHomeCliente();
                        }
                    }
                }));
        timeline.setCycleCount(segundos[0]);
        timeline.play();

    }

    @FXML
    private void enviarReclamacao() {
        try {
            motivoReclamacao.toFront();
            empresasCadastradas.toFront();
            String motivoSelecionado = motivoReclamacao.getValue();
            String produtoId = idProduto.getText();
            String empresaSelecionada = empresasCadastradas.getText();
            String desc = descricao.getText();

            Empresa empresa = eDao.queryName(empresaSelecionada);

            if (empresa == null || !empresa.getNome().equals(empresaSelecionada)) {
                throw new IllegalArgumentException("Empresa nao cadastrada");
            }
            if (empresaSelecionada == null || motivoSelecionado == null || produtoId.isEmpty()
                    || desc.isEmpty()) {
                throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
            }

            int produtoIdInt;

            try {
                produtoIdInt = Integer.parseInt(produtoId);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ID do produto deve ser um numero inteiro.");
            }
            
            Reclamacao reclamacao = new Reclamacao(idCliente, empresa.getId(), produtoIdInt, desc, motivoSelecionado);
            rDAO.createReclamacao(reclamacao);

            empresasCadastradas.clear();
            motivoReclamacao.setValue(null);
            idProduto.clear();
            descricao.clear();

            buscarTodasAsReclamacoesAgrupadasPorEmpresa(empresa.getId());
            sucessoEnvioReclamacao.setVisible(true);
            sucessoEnvioReclamacao.toFront();
            fadeInTransition(sucessoEnvioReclamacao);

            botaoReclamacaoEnviada.setVisible(true);
            botaoReclamacaoEnviada.toFront();
            botaoReclamacaoEnviada.setOnAction(event -> {
                fadeOutTransition(sucessoEnvioReclamacao);
                sucessoEnvioReclamacao.setVisible(false);
                botaoReclamacaoEnviada.setVisible(false);
                mostrarHomeCliente();
            });

        } catch (IllegalArgumentException e) {
            exibirMensagemErro(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fadeInTransition(ImageView imageView) {
        fadeTransition = new FadeTransition(Duration.seconds(1.0), imageView);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();
    }

    private void fadeOutTransition(ImageView imageView) {
        fadeTransition = new FadeTransition(Duration.seconds(1.0), imageView);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.play();
    }

    public static boolean verificarFormatoCnpj(String cnpj) {
        boolean valido = false;
        if (cnpj != null && cnpj.length() > 0) {
            String expression = "^\\d{2}\\.\\d{3}\\.\\d{3}/000\\d-\\d{2}$";
            Pattern pattern = Pattern.compile(expression);
            Matcher matcher = pattern.matcher(cnpj);
            valido = matcher.matches();
        }
        return valido;
    }

    public static boolean verificarFormatoCpf(String cpf) {
        cpf = cpf.replaceAll("[.-]", "");
        boolean valido = true;
        if (cpf.length() != 11) {
            valido = false;
        }
        if (!cpf.matches("[0-9]*")) {
            valido = false;
        }
        return valido;
    }

    public static boolean verificarFormatoEmail(String email) {
        boolean valido = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            valido = matcher.matches();
        }
        return valido;
    }

    @FXML
    private void enviarDevolucao() {
        try {
            motivoDevolucao.toFront();
            String motivoSelecionado = motivoDevolucao.getValue();
            String produtoId = idProdutoDevolucao.getText();
            String justificativa = justificativaDevolucao.getText();
            String empresaSelecionada = empresasCadastradasDevolucao.getText();
            String quantidadesItens = quantidadesItensDevolucao.getText();
            String idSubstituicao = idSubstituicaoDevolucao.getText();
            String descricaoItem = descricaoItemDevolucao.getText();
            LocalDate dataCompra = dataCompraDevolucao.getValue();
            Date dataCompraDate = java.sql.Date.valueOf(dataCompra);

            Empresa empresa = eDao.queryName(empresaSelecionada);
            if (empresa == null || !empresa.getNome().equals(empresaSelecionada)) {
                throw new IllegalArgumentException("Empresa nao cadastrada");
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
            Devolucao devolucao = new Devolucao(idCliente, empresa.getId(), produtoIdInt, descricaoItem, motivoSelecionado, quantidadeItensInt, idSubstituicaoInt, justificativa, dataCompraDate);
            dDao.createDevolucao(devolucao);

            empresasCadastradasDevolucao.clear();
            motivoDevolucao.setValue(null);
            idProdutoDevolucao.clear();
            justificativaDevolucao.clear();
            quantidadesItensDevolucao.clear();
            idSubstituicaoDevolucao.clear();
            descricaoItemDevolucao.clear();
            dataCompraDevolucao.setValue(null);

            Alert alert = new Alert(AlertType.CONFIRMATION,
                    "Pedido de devolucao enviado. Acompanhe o status em nosso menu na Home.", ButtonType.OK);

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
    private void consultarDevolucoes() {
        try {  
            reclamacoesVBox.getChildren().clear();
            String sqlQuery = "SELECT * FROM app.devolucao WHERE c_id = ?";
                try (Connection connection = new ConnectionFactory().getConnection();
                    PreparedStatement pst = connection.prepareStatement(sqlQuery)) {
                    
                    pst.setInt(1, idCliente);
                    
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
                            adicionarReclamacao(cId, eId, produtoId, descricao,id,status,motivo);
                            
                            // Exemplo de processamento: imprimir os valores
                            System.out.println("c_id: " + cId + ", e_id: " + eId + ", produto_id: " + produtoId +
                                               ", descricao: " + descricao + ", id: " + id + 
                                               ", status: " + status + ", motivo: " + motivo);
                        }
                    }
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
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
    
    @FXML
    private void consultarReclamacoes() {
      
        try {  
            reclamacoesVBox.getChildren().clear();
            String sqlQuery = "SELECT * FROM app.reclamacao WHERE c_id = ?";
                try (Connection connection = new ConnectionFactory().getConnection();
                    PreparedStatement pst = connection.prepareStatement(sqlQuery)) {
                    
                    pst.setInt(1, idCliente);
                    
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
                            adicionarReclamacao(cId, eId, produtoId, descricao,id,status,motivo);
                            
                            // Exemplo de processamento: imprimir os valores
                            System.out.println("c_id: " + cId + ", e_id: " + eId + ", produto_id: " + produtoId +
                                               ", descricao: " + descricao + ", id: " + id + 
                                               ", status: " + status + ", motivo: " + motivo);
                        }
                    }
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
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

    public void adicionarReclamacao(int cId, int eId,int produtoId, String descricao,int id,String status, String motivo) {

        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-padding: 10;");

        VBox labelsVBox = new VBox(3);
        labelsVBox.setStyle("-fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 10px;");

        Label clienteIdLabel = new Label("Id do Cliente: " + cId);
        clienteIdLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label produtoLabel = new Label("Produto ID: " + produtoId);
        produtoLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label justificativaLabel = new Label("Justificativa: " + descricao);
        justificativaLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label statusLabel = new Label("Status:" + status);
        statusLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        labelsVBox.getChildren().addAll(clienteIdLabel, produtoLabel, justificativaLabel,statusLabel);
        
        Reclamacao reclamacao = rDAO.queryAccount(id);
        String status02 = reclamacao.getStatus().toString();
        String resp = reclamacao.getResposta();

        if (status02 == "RESPONDIDA") {
            Label respostaLabel = new Label("Resposta da Empresa: " + resp);
            respostaLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");
            labelsVBox.getChildren().add(respostaLabel);
        }
        pane.setCenter(labelsVBox);
        reclamacoesVBox.getChildren().add(pane);



    }


    //--------------------------------------------------------------------------------------------------------------------------------------------
    

    public void adicionarDevolucao(Devolucao devolucao, Cliente cliente, Empresa empresa) {

        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-padding: 10;");

        VBox labelsVBox = new VBox(3);
        labelsVBox.setStyle("-fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 10px;");

        Label empresaLabel = new Label("Empresa: " + empresa.getNome());
        empresaLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label produtoLabel = new Label("Produto ID: " + devolucao.getProdutoId());
        produtoLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label justificativaLabel = new Label("Justificativa: " + devolucao.getMotivo());
        justificativaLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label statusLabel = new Label("Status: " + devolucao.getStatus().toString());
        statusLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        labelsVBox.getChildren().addAll(empresaLabel, produtoLabel, justificativaLabel, statusLabel);

        pane.setCenter(labelsVBox);
        devolucoesVBox.getChildren().add(pane);
    }
 
  private void apresentarReclamacoesParaAEmpresa() {

        try (Connection connection = new ConnectionFactory().getConnection()) {
            reclamacoesVBoxEmpresa.getChildren().clear();
    
            String sqlQuery = "SELECT * FROM app.reclamacao WHERE e_id = ? AND status = 'NAO_RESPONDIDA'";
            try (PreparedStatement pst = connection.prepareStatement(sqlQuery)) {
                pst.setInt(1, idEmpresa);
    
                try (ResultSet rs = pst.executeQuery()) {
                    if (!rs.isBeforeFirst()) {
                        Label semReclamacoesLabel = new Label("Nenhuma reclamacao encontrada.");
                        semReclamacoesLabel
                                .setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");
                        reclamacoesVBoxEmpresa.getChildren().add(semReclamacoesLabel);
                    } else {
                        while (rs.next()) {
                            int cId = rs.getInt("c_id");
                            int produtoId = rs.getInt("produto_id");
                            String descricao = rs.getString("descricao");
                            int id = rs.getInt("id");
                            String motivo = rs.getString("motivo");
                            // Exemplo de processamento: imprimir os valores
                            System.out.println("c_id: " + cId + ", produto_id: " + produtoId +
                                               ", descricao: " + descricao + ", id: " + id  + ", motivo: " + motivo);
                            BorderPane pane = new BorderPane();
                            pane.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-padding: 10;");
    
                            VBox labelsVBox = new VBox(3);
                            labelsVBox.setStyle(
                                    "-fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 10px;");
    
                            Label novaReclamacaoLabel = new Label("Você tem uma nova reclamação:");
                            novaReclamacaoLabel.setStyle(
                                    "-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");
    
                            Label idLabel = new Label("ID do Cliente: " + cId);
                            Label motivoLabel = new Label("Motivo: " + motivo);
    
                            idLabel.setStyle(
                                    "-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");
                            novaReclamacaoLabel.setStyle(
                                    "-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: red;");
                            motivoLabel.setStyle(
                                    "-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");
    
                            labelsVBox.getChildren().addAll(novaReclamacaoLabel, idLabel, motivoLabel);
                            pane.setCenter(labelsVBox);
                            reclamacoesVBoxEmpresa.getChildren().add(pane);
    
                            pane.setOnMouseClicked(event -> {
                                responderReclamacao(id, cId); // Passa o id da reclamação e o id do cliente
                            });
    
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Adicione tratamento de erro aqui, se necessário
        }
    }

  private void responderReclamacao(int reclamacaoId, int clienteId) {

    Cliente cliente = cDao.queryAccount(clienteId);
    System.out.println(clienteId);
    Reclamacao reclamacao = rDAO.queryAccount(reclamacaoId);
    System.out.println(reclamacaoId);

    if (reclamacao == null || cliente == null) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText("Reclamação ou cliente não encontrados.");
        alert.showAndWait();
        return;
    }

    nomeEmpresa.setVisible(false);
    esconderElementosDentroDoLogin();
    responderReclamacaoBackground.setVisible(true);

    motivoReclamacaoLabel.setText(reclamacao.getMotivo());
    motivoReclamacaoLabel.setVisible(true);
    motivoReclamacaoLabel.toFront();

    nomeClienteReclamacaoLabel.setText(cliente.getNome());
    nomeClienteReclamacaoLabel.setVisible(true);
    nomeClienteReclamacaoLabel.toFront();

    cpfClienteReclamacaoLabel.setText(String.valueOf(cliente.getCpf()));
    cpfClienteReclamacaoLabel.setVisible(true);
    cpfClienteReclamacaoLabel.toFront();

    emailClienteReclamacaoLabel.setText(cliente.getEmail());
    emailClienteReclamacaoLabel.setVisible(true);
    emailClienteReclamacaoLabel.toFront();

    detalhamentoClienteReclamacaoLabel.setText(reclamacao.getDescricao());
    detalhamentoClienteReclamacaoLabel.setVisible(true);
    detalhamentoClienteReclamacaoLabel.toFront();

    respostaReclamacaoTextArea.setVisible(true);
    respostaReclamacaoTextArea.toFront();

    botaoResponderReclamacao.setVisible(true);
    botaoResponderReclamacao.toFront();

    logOutSymbol.setVisible(false);

    botaoResponderReclamacao.setOnAction(event -> {
        String resposta = respostaReclamacaoTextArea.getText();
        reclamacao.setResposta(resposta);
        reclamacao.setStatus(StatusReclamacao.RESPONDIDA);

        rDAO.updateReclamacao(reclamacao);

        motivoReclamacaoLabel.setVisible(false);
        nomeClienteReclamacaoLabel.setVisible(false);
        cpfClienteReclamacaoLabel.setVisible(false);
        emailClienteReclamacaoLabel.setVisible(false);
        detalhamentoClienteReclamacaoLabel.setVisible(false);
        respostaReclamacaoTextArea.setVisible(false);
        botaoResponderReclamacao.setVisible(false);
        responderReclamacaoBackground.setVisible(false);
        motivoReclamacaoLabel.setText("");
        nomeClienteReclamacaoLabel.setText("");
        cpfClienteReclamacaoLabel.setText("");
        emailClienteReclamacaoLabel.setText("");
        detalhamentoClienteReclamacaoLabel.setText("");
        respostaReclamacaoTextArea.clear();
        fadeOutTransition(sucessoEnvioReclamacao);
        sucessoResponderReclamacao.setVisible(true);
        botaoRespostaReclamacaoEnviada.setVisible(true);
    });

    botaoRespostaReclamacaoEnviada.setOnAction(event -> {
        sucessoResponderReclamacao.setVisible(false);
        botaoRespostaReclamacaoEnviada.setVisible(false);

        mostrarHomeEmpresa();
    });
}


    
private void apresentarDevolucoesParaAEmpresa() {

    try (Connection connection = new ConnectionFactory().getConnection()) {
        devolucoesVBoxEmpresa.getChildren().clear();

        String sqlQuery = "SELECT * FROM app.devolucao WHERE e_id = ? AND status = 'EM_ANALISE'";
        try (PreparedStatement pst = connection.prepareStatement(sqlQuery)) {
            pst.setInt(1, idEmpresa);

            try (ResultSet rs = pst.executeQuery()) {
                if (!rs.isBeforeFirst()) {
                    Label semDevolucoesLabel = new Label("Nenhuma devolucao encontrada.");
                    semDevolucoesLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");
                    devolucoesVBoxEmpresa.getChildren().add(semDevolucoesLabel);
                } else {
                    while (rs.next()) {
                        int cId = rs.getInt("c_id");
                        int produtoId = rs.getInt("produto_id");
                        String descricao = rs.getString("descricao");
                        int id = rs.getInt("id");
                        String motivo = rs.getString("motivo");
                        String justificativa = rs.getString("justificativa");
                        int quantidade = rs.getInt("quantidade");

                        BorderPane pane = new BorderPane();
                        pane.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-padding: 10;");

                        VBox labelsVBox = new VBox(3);
                        labelsVBox.setStyle("-fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 10px;");

                        Label novaDevolucaoLabel = new Label("Você tem uma nova devolução:");
                        novaDevolucaoLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: red;");

                        Label idLabel = new Label("ID do Cliente: " + cId);
                        Label motivoLabel = new Label("Motivo: " + motivo);
                        Label idProdutoLabel = new Label("ID do Produto: " + produtoId);
                        Label descricaLabel = new Label("Descricao: " + descricao);

                        idLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");
                        novaDevolucaoLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: red;");
                        motivoLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

                        labelsVBox.getChildren().addAll(novaDevolucaoLabel, idLabel, motivoLabel, idProdutoLabel, descricaLabel);
                        pane.setCenter(labelsVBox);
                        devolucoesVBoxEmpresa.getChildren().add(pane);

                        pane.setOnMouseClicked(event -> {
                            concederDevolucao(id, cId); // Passa o id da devolução e o id do cliente
                        });
                    }
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Adicione tratamento de erro aqui, se necessário
    }
}

private void concederDevolucao(int devolucaoId, int clienteId) {
   Cliente cliente = cDao.queryAccount(clienteId);
    Devolucao devolucao = dDao.queryAccount(clienteId);
    // Configuração da interface gráfica para exibir os detalhes da devolução e as opções de ação
    nomeEmpresa.setVisible(false);

    dataCompraDevolucaoLabel.setVisible(true);
    dataCompraDevolucaoLabel.toFront();

    motivoDevolucaoLabel.setVisible(true);
    motivoDevolucaoLabel.toFront();

    nomeClienteDevolucaoLabel.setVisible(true);
    nomeClienteDevolucaoLabel.toFront();

    cpfClienteDevolucaoLabel.setVisible(true);
    cpfClienteDevolucaoLabel.toFront();

    emailClienteDevolucaoLabel.setVisible(true);
    emailClienteDevolucaoLabel.toFront();

    idProdutoDevolucaoLabel.setVisible(true);
    idProdutoDevolucaoLabel.toFront();
    logOutSymbol.setVisible(false);

    quantidadeProdutoDevolucaoLabel.setVisible(true);
    quantidadeProdutoDevolucaoLabel.toFront();

    substituicaoReembolsoDevolucaoTextArea.setVisible(true);
    substituicaoReembolsoDevolucaoTextArea.toFront();

    IDSubstituicaoDevolucaoTextArea.setVisible(true);
    IDSubstituicaoDevolucaoTextArea.toFront();

    opcaoDevolucaoReembolso.setVisible(true);
    opcaoDevolucaoSubsituicao.setVisible(true);
    opcaoDevolucaoNegar.setVisible(true);
    opcaoDevolucaoNegar.toFront();
    opcaoDevolucaoReembolso.toFront();
    opcaoDevolucaoSubsituicao.toFront();

    botaoDevolucaoConcedidaEnviada.setVisible(true);
    botaoDevolucaoConcedidaEnviada.toFront();

    detalhamentoDevolucaoTextArea.setVisible(true);
    detalhamentoDevolucaoTextArea.toFront();

    esconderElementosDentroDoLogin();

    concederDevolucaoBackground.setVisible(true);
    motivoDevolucaoLabel.setText(devolucao.getMotivo());

    nomeClienteDevolucaoLabel.setText(cliente.getNome());
    cpfClienteDevolucaoLabel.setText(String.valueOf(cliente.getCpf()));

    emailClienteDevolucaoLabel.setText(cliente.getEmail());
    // dataCompraDevolucaoLabel.setText(devolucao.getDataCompra());

    idProdutoDevolucaoLabel.setText("" + devolucao.getProdutoId());
    quantidadeProdutoDevolucaoLabel.setText("" + devolucao.getQuantidade());

    substituicaoReembolsoDevolucaoTextArea.setText(devolucao.getJustificativa());
    IDSubstituicaoDevolucaoTextArea.setText(String.valueOf(devolucao.getIdSubstituicao()));
    detalhamentoDevolucaoTextArea.setText("" + devolucao.getDescricao());

    logOutSymbol.setVisible(false);

    opcaoDevolucaoReembolso.selectedProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue) {
            opcaoDevolucaoSubsituicao.setSelected(false);
            opcaoDevolucaoNegar.setSelected(false);
        }
    });

    opcaoDevolucaoSubsituicao.selectedProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue) {
            opcaoDevolucaoReembolso.setSelected(false);
            opcaoDevolucaoNegar.setSelected(false);
        }
    });

    opcaoDevolucaoNegar.selectedProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue) {
            opcaoDevolucaoReembolso.setSelected(false);
            opcaoDevolucaoSubsituicao.setSelected(false);
        }
    });

    botaoDevolucaoConcedidaEnviada.setOnAction(event -> {
        if (opcaoDevolucaoReembolso.isSelected() && opcaoDevolucaoSubsituicao.isSelected()
                && opcaoDevolucaoNegar.isSelected()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione apenas uma opção: Negacao, Reembolso ou Substituicao.");
            alert.showAndWait();
        } else if (opcaoDevolucaoReembolso.isSelected()) {
            devolucao.setStatus(StatusDevolucao.APROVADO);
            System.out.println("Opção Reembolso selecionada.");
            Empresa empresa = Empresa.buscarEmpresaPorId(devolucao.getEmpresaId());
            if (empresa != null) {
                limparECamposDevolucao();
                fadeOutTransition(sucessoConcederDevolucao);
                concederDevolucaoBackground.setVisible(false);
                mostrarHomeEmpresa();
            }
        } else if (opcaoDevolucaoSubsituicao.isSelected()) {
            devolucao.setStatus(StatusDevolucao.APROVADO);
            System.out.println("Opção Substituição selecionada.");
            Empresa empresa = Empresa.buscarEmpresaPorId(devolucao.getEmpresaId());
            if (empresa != null) {
                limparECamposDevolucao();
                fadeOutTransition(sucessoConcederDevolucao);
                concederDevolucaoBackground.setVisible(false);
                mostrarHomeEmpresa();
            }
        } else if (opcaoDevolucaoNegar.isSelected()) {
            devolucao.setStatus(StatusDevolucao.NEGADO);
            System.out.println("Opção Negação selecionada.");
            Empresa empresa = Empresa.buscarEmpresaPorId(devolucao.getEmpresaId());
            if (empresa != null) {
                limparECamposDevolucao();
                fadeOutTransition(negacaoConcederDevolucao);
                concederDevolucaoBackground.setVisible(false);
                mostrarHomeEmpresa();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione uma opção: Reembolso ou Substituição.");
            alert.showAndWait();
        }
    });
}
 
    private void buscarTodasAsReclamacoesAgrupadasPorEmpresa(int i) {
        try {
            String sqlQuery = "SELECT e_id, COUNT(*) as total_reclamacoes " +
                              "FROM app.reclamacao " +
                              "WHERE status = 'NAO_RESPONDIDA' " +
                              "GROUP BY e_id";
    
            try (Connection connection = new ConnectionFactory().getConnection();
                 PreparedStatement pst = connection.prepareStatement(sqlQuery);
                 ResultSet rs = pst.executeQuery()) {
    
                System.out.println("Consulta de Reclamações Agrupadas por Empresa:");
                while (rs.next()) {
                    int empresaId = rs.getInt("e_id");
                    int totalReclamacoes = rs.getInt("total_reclamacoes");
    
                    Empresa empresa = Empresa.buscarEmpresaPorId(empresaId);
                    if (empresa != null) {
                        System.out.println("Empresa: " + empresa.getNome() + " - Reclamações não respondidas: " + totalReclamacoes);
    
                        String reclamacoesQuery = "SELECT * FROM app.reclamacao WHERE e_id = ? AND status = 'NAO_RESPONDIDA'";
                        try (PreparedStatement pstReclamacoes = connection.prepareStatement(reclamacoesQuery)) {
                            pstReclamacoes.setInt(1, empresaId);
                            try (ResultSet rsReclamacoes = pstReclamacoes.executeQuery()) {
                                while (rsReclamacoes.next()) {
                                    int cId = rsReclamacoes.getInt("c_id");
                                    int produtoId = rsReclamacoes.getInt("produto_id");
                                    String descricao = rsReclamacoes.getString("descricao");
                                    int id = rsReclamacoes.getInt("id");
                                    String motivo = rsReclamacoes.getString("motivo");
                                    System.out.println("EMPRESAS AGRUPADAS POR ID SEM RESPOSTA");
                                    System.out.println("AS EMPRESAS SAO AGRUPADAS QUANDO UMA NOVA RECLAMAO E FEITA");
                                    System.out.println("ID do Cliente: " + cId);
                                    System.out.println("ID do Cliente: " + cId);
                                    System.out.println("Produto ID: " + produtoId);
                                    System.out.println("Descrição: " + descricao);
                                    System.out.println("ID da Reclamação: " + id);
                                    System.out.println("Motivo: " + motivo);
                                    System.out.println("-----");
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Adicione tratamento de erro aqui, se necessário
        }
    }
    
  
/*----------------------------------------------------------------------------------------------------------------------------- */
private void exibirMensagemErro(String mensagem) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Erro no preenchimento dos dados!");
    alert.setHeaderText(null);
    alert.setContentText(mensagem);
    alert.showAndWait();
}

          
    public void adicionarReclamacaoEmpresa(int cId, int eId, int produtoId, String descricao, int id, String status, String motivo) {

    
        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-padding: 10;");

        VBox labelsVBox = new VBox(3);
        labelsVBox.setStyle("-fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 10px;");

        Label clienteIdLabel = new Label("Id do Cliente: " + cId);
        clienteIdLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label produtoLabel = new Label("Produto ID: " + produtoId);
        produtoLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label justificativaLabel = new Label("Justificativa: " + descricao);
        justificativaLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        Label statusLabel = new Label("Status:" + status);
        statusLabel.setStyle("-fx-font-family: 'DM Sans'; -fx-font-weight: bold; -fx-text-fill: #8F8E8E;");

        labelsVBox.getChildren().addAll(clienteIdLabel, produtoLabel, justificativaLabel,statusLabel);

        pane.setCenter(labelsVBox);
        reclamacoesVBox.getChildren().add(pane);

    }

    private void fadeInBackground(Node background) {

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), background);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), background);
        translateTransition.setFromX(background.getTranslateX() + 50);
        translateTransition.setToX(0);
        translateTransition.play();
    }

    private void atualizarNomeCliente(String nome) {
        nomeCliente.setText(nome);
    }

    private void atualizarNomeEmpresa(String nome) {
        nomeEmpresa.setText(nome);
    }

    @FXML
    private void voltarLoginCliente() {
        campoCadastroClienteNome.clear();
        campoCadastroClienteEmail.clear();
        campoCadastroClienteSenha.clear();
        campoCadastroClienteCPF.clear();
        campoCadastroClienteTelefone.clear();
        campoCadastroClienteEndereco.clear();
        campoCadastroClienteDataNascimento.setValue(null);
        telaInicial();
    }

    @FXML
    private void voltarLoginEmpresa() {
        campoCadastroEmpresaNome.clear();
        campoCadastroEmpresaEmail.clear();
        campoCadastroEmpresaDescricao.clear();
        campoCadastroEmpresaData.setValue(null);
        campoCadastroEmpresaCNPJ.clear();
        telaInicial();
    }

    @FXML
    private void voltarFormReclamacao() {
        mostrarHomeCliente();
    }

    private void limparECamposDevolucao() {
        detalhamentoDevolucaoTextArea.setVisible(false);
        detalhamentoDevolucaoTextArea.setText("");
        opcaoDevolucaoNegar.setVisible(false);
        motivoDevolucaoLabel.setText("");
        nomeClienteDevolucaoLabel.setText("");
        cpfClienteDevolucaoLabel.setText("");
        emailClienteDevolucaoLabel.setText("");
        dataCompraDevolucaoLabel.setText("");
        idProdutoDevolucaoLabel.setText("");
        quantidadeProdutoDevolucaoLabel.setText("");
        substituicaoReembolsoDevolucaoTextArea.clear();
        IDSubstituicaoDevolucaoTextArea.clear();
        concederDevolucaoBackground.setVisible(false);
        motivoDevolucaoLabel.setVisible(false);
        nomeClienteDevolucaoLabel.setVisible(false);
        cpfClienteDevolucaoLabel.setVisible(false);
        emailClienteDevolucaoLabel.setVisible(false);
        dataCompraDevolucaoLabel.setVisible(false);
        idProdutoDevolucaoLabel.setVisible(false);
        quantidadeProdutoDevolucaoLabel.setVisible(false);
        substituicaoReembolsoDevolucaoTextArea.setVisible(false);
        IDSubstituicaoDevolucaoTextArea.setVisible(false);
        opcaoDevolucaoReembolso.setVisible(false);
        opcaoDevolucaoSubsituicao.setVisible(false);
        botaoDevolucaoConcedidaEnviada.setVisible(false);
        opcaoDevolucaoNegar.setSelected(false);
        opcaoDevolucaoReembolso.setSelected(false);
        opcaoDevolucaoSubsituicao.setSelected(false);
    }

   @FXML
    private void voltarParaOInicio() {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmacao");
        alert.setHeaderText("Confirmacao de saida");
        alert.setContentText("Tem certeza que deseja voltar para a tela inicial?");

        ButtonType buttonTypeSim = new ButtonType("Sim", ButtonData.YES);
        ButtonType buttonTypeNao = new ButtonType("Não", ButtonData.NO);

        alert.getButtonTypes().setAll(buttonTypeSim, buttonTypeNao);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == buttonTypeSim) {
            homeBackground.setVisible(false);
            botaoPedirDevolucao.setVisible(false);
            botaoFazerReclamacao.setVisible(false);
            nomeCliente.setVisible(false);
            complaintViewer.setVisible(false);
            complaintForm.setVisible(false);
            jumpingBackLoginReclamacao.setVisible(false);
            esconderElementosDentroDoLogin();
            logOutSymbol.setVisible(false);
            telaInicial();
        }

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
        responderReclamacaoBackground.setVisible(false);
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
        nomeEmpresa.setVisible(true);
        sucessoResponderReclamacao.setVisible(false);
        responderReclamacaoBackground.setVisible(false);
        homeCompanyBackground.setVisible(true);
        mainVBoxReclamacaoesEmpresa.setVisible(true);
        reclamacoesVBoxEmpresa.setVisible(true);
        mainVBoxDevolucoesEmpresa.setVisible(true);
        devolucoesVBoxEmpresa.setVisible(true);
        logOutSymbol.setVisible(true);
        apresentarReclamacoesParaAEmpresa();
        apresentarDevolucoesParaAEmpresa();
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
        descricao.setVisible(true);
        botaoEnviarReclamacao.setVisible(true);
        jumpingBackLoginReclamacao.setVisible(true);
        logOutSymbol.setVisible(false);
        botaoVerReclamacao.setVisible(false);
        botaoVerDevolucao.setVisible(false);
        homeSymbol.setVisible(false);
        //buscarTodasAsReclamacoesDaEmpresa();

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
        campoCadastroClienteCPF.setVisible(false);
        campoCadastroClienteTelefone.setVisible(false);
        campoCadastroClienteEndereco.setVisible(false);
        campoCadastroClienteDataNascimento.setVisible(false);
        clienteCadastroBackground.setVisible(false);
        botaoLoginPelaPrimeiraVezCliente.setVisible(false);
        campoCadastroClienteSenha.setVisible(false);
        labelLoginCliente.setVisible(false);
        campoCadastroEmpresaNome.setVisible(false);
        campoCadastroEmpresaEmail.setVisible(false);
        campoCadastroEmpresaDescricao.setVisible(false);
        campoCadastroEmpresaData.setVisible(false);
        campoCadastroEmpresaSenha.setVisible(false);
        campoCadastroEmpresaCNPJ.setVisible(false);
        botaoLoginPelaPrimeiraVezEmpresa.setVisible(false);
        labelLoginEmpresa.setVisible(false);
        empresasCadastradas.setVisible(false);
        empresasCadastradasDevolucao.setVisible(false);
        motivoReclamacao.setVisible(false);
        motivoDevolucao.setVisible(false);
        idProduto.setVisible(false);
        idProdutoDevolucao.setVisible(false);
        dataCompraDevolucao.setVisible(false);
        descricao.setVisible(false);
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
        mainVBoxReclamacaoesEmpresa.setVisible(false);
        reclamacoesVBoxEmpresa.setVisible(false);
        mainVBoxDevolucoesEmpresa.setVisible(false);
        devolucoesVBoxEmpresa.setVisible(false);

    }

    public void telaInicial() {
        botaoInicialCliente.setVisible(true);
        botaoInicialEmpresa.setVisible(true);
        campoCadastroClienteNome.toFront();
        firstBackground.setVisible(true);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1.5), firstBackground);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        motivoReclamacaoLabel.setVisible(false);
        nomeClienteReclamacaoLabel.setVisible(false);
        cpfClienteReclamacaoLabel.setVisible(false);
        emailClienteReclamacaoLabel.setVisible(false);
        detalhamentoClienteReclamacaoLabel.setVisible(false);
        respostaReclamacaoTextArea.setVisible(false);
        botaoResponderReclamacao.setVisible(false);
        responderReclamacaoBackground.setVisible(false);
        sucessoResponderReclamacao.setVisible(false);
        botaoRespostaReclamacaoEnviada.setVisible(false);
        concederDevolucaoBackground.setVisible(false);
        motivoDevolucaoLabel.setVisible(false);
        nomeClienteDevolucaoLabel.setVisible(false);
        cpfClienteDevolucaoLabel.setVisible(false);
        emailClienteDevolucaoLabel.setVisible(false);
        dataCompraDevolucaoLabel.setVisible(false);
        idProdutoDevolucaoLabel.setVisible(false);
        opcaoDevolucaoNegar.setVisible(false);
        quantidadeProdutoDevolucaoLabel.setVisible(false);
        substituicaoReembolsoDevolucaoTextArea.setVisible(false);
        detalhamentoDevolucaoTextArea.setVisible(false);
        IDSubstituicaoDevolucaoTextArea.setVisible(false);
        opcaoDevolucaoReembolso.setVisible(false);
        opcaoDevolucaoSubsituicao.setVisible(false);
        botaoDevolucaoConcedidaEnviada.setVisible(false);
        double larguraTela = 1000;
        nomeEmpresa.setVisible(false);
        TranslateTransition transicaoCliente = new TranslateTransition(Duration.seconds(1), botaoInicialCliente);
        transicaoCliente.setFromX(larguraTela);
        transicaoCliente.setToX(150);

        TranslateTransition transicaoEmpresa = new TranslateTransition(Duration.seconds(1), botaoInicialEmpresa);
        transicaoEmpresa.setFromX(larguraTela);
        transicaoEmpresa.setToX(395);

        transicaoCliente.play();
        transicaoEmpresa.play();

        botaoLoginPelaPrimeiraVezCliente.setVisible(false);
        botaoLoginPelaPrimeiraVezEmpresa.setVisible(false);
        botaoLoginCliente.setVisible(false);
        campoCadastroClienteNome.setVisible(false);
        campoCadastroClienteSenha.setVisible(false);
        campoLoginClienteEmail.setVisible(false);
        campoLoginClienteSenha.setVisible(false);
        clienteCadastroBackground.setVisible(false);
        campoCadastroClienteEmail.setVisible(false);
        campoCadastroClienteCPF.setVisible(false);
        campoCadastroClienteTelefone.setVisible(false);
        campoCadastroClienteEndereco.setVisible(false);
        campoCadastroClienteDataNascimento.setVisible(false);
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
        campoCadastroEmpresaCNPJ.setVisible(false);
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
        descricao.setVisible(false);
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
        campoCadastroClienteCPF.setVisible(true);
        campoCadastroClienteTelefone.setVisible(true);
        campoCadastroClienteEndereco.setVisible(true);
        campoCadastroClienteDataNascimento.setVisible(true);
        botaoLoginPelaPrimeiraVezCliente.setVisible(true);
        firstBackground.setVisible(false);
        campoCadastroClienteCPF.toFront();
        campoCadastroClienteTelefone.toFront();
        campoCadastroClienteEndereco.toFront();
        campoCadastroClienteDataNascimento.toFront();
        campoCadastroClienteNome.toFront();
        campoCadastroClienteEmail.toFront();
        campoCadastroClienteSenha.toFront();
        labelLoginCliente.setVisible(true);
        labelLoginCliente.toFront();
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
        campoCadastroEmpresaCNPJ.setVisible(true);
        botaoLoginPelaPrimeiraVezEmpresa.setVisible(true);
        jumpingBackLoginEmpresa.setVisible(true);
        labelLoginEmpresa.setVisible(true);
        labelLoginEmpresa.toFront();
    }

    @FXML
    private void irParaLoginCliente() {

        jumpingBackLoginCliente.setVisible(true);
        jumpingBackLoginCliente.toFront();
        jumpingBackLoginCliente.setLayoutX(20);
        clienteLoginBackground.setVisible(true);
        fadeInBackground(clienteLoginBackground);
        campoLoginClienteEmail.setVisible(true);
        campoLoginClienteSenha.setVisible(true);
        campoLoginClienteEmail.setText("");
        campoLoginClienteSenha.setText("");
        botaoLoginCliente.setVisible(true);
        esconderElementosDentroDoLogin();
    }

    @FXML
    private void irParaLoginEmpresa() {

        campoLoginEmpresaEmail.setVisible(true);
        campoLoginEmpresaSenha.setVisible(true);
        campoLoginEmpresaEmail.setText("");
        campoLoginEmpresaSenha.setText("");
        jumpingBackLoginEmpresa.setVisible(true);
        jumpingBackLoginEmpresa.toFront();
        botaoLoginEmpresa.setVisible(true);
        empresaLoginBackground.setVisible(true);
        fadeInBackground(empresaLoginBackground);
        esconderElementosDentroDoLogin();
    }

}
