import java.util.ArrayList;
import java.util.List;

// Classe Banco
class InstituicaoFinanceira {
    private String nomeInstituicao;
    private String codigoAgencia;
    private int numeroContaBancaria;
    private String categoriaConta;

    public InstituicaoFinanceira(String nomeInstituicao, String codigoAgencia, int numeroContaBancaria, String categoriaConta) {
        this.nomeInstituicao = nomeInstituicao;
        this.codigoAgencia = codigoAgencia;
        this.numeroContaBancaria = numeroContaBancaria;
        this.categoriaConta = categoriaConta;
    }

    public void receberTransferencia(double quantia) {
        System.out.println("Transferência recebida: " + quantia);
    }

    public void realizarPagamento(double quantia) {
        System.out.println("Pagamento realizado: " + quantia);
    }

    public void exibirSaldo() {
        System.out.println("Saldo atual: [exibir saldo aqui]");
    }
}

// Classe Pessoa
abstract class Individuo {
    protected String nomeCompleto;
    protected String enderecoEmail;
    protected int numeroTelefone;

    public Individuo(String nomeCompleto, String enderecoEmail, int numeroTelefone) {
        this.nomeCompleto = nomeCompleto;
        this.enderecoEmail = enderecoEmail;
        this.numeroTelefone = numeroTelefone;
    }

    public void registrar() {
        System.out.println("Indivíduo registrado: " + nomeCompleto);
    }

    public void remover() {
        System.out.println("Indivíduo removido: " + nomeCompleto);
    }

    public void atualizar() {
        System.out.println("Indivíduo atualizado: " + nomeCompleto);
    }
}

// Pessoa Física (herda de Individuo)
class IndividuoFisico extends Individuo {
    private int cpfNumero;
    private int rgNumero;
    private List<IndividuoFisico> dependentes = new ArrayList<>();

    public IndividuoFisico(String nomeCompleto, String enderecoEmail, int numeroTelefone, int cpfNumero, int rgNumero) {
        super(nomeCompleto, enderecoEmail, numeroTelefone);
        this.cpfNumero = cpfNumero;
        this.rgNumero = rgNumero;
    }

    public void relatorioDespesasMensais() {
        System.out.println("Relatório de despesas mensais para " + nomeCompleto);
    }

    public void adicionarDependente(IndividuoFisico dependente) {
        dependentes.add(dependente);
        System.out.println("Dependente adicionado: " + dependente.nomeCompleto);
    }
}

// Pessoa Jurídica (herda de Individuo)
class Empresa extends Individuo {
    private String cnpjNumero;

    public Empresa(String nomeCompleto, String enderecoEmail, int numeroTelefone, String cnpjNumero) {
        super(nomeCompleto, enderecoEmail, numeroTelefone);
        this.cnpjNumero = cnpjNumero;
    }

    public void efetuarCompra() {
        System.out.println("Compra efetuada pela empresa: " + nomeCompleto);
    }
}

// Classe Produto
class Item {
    private String descricao;
    private int idItem;
    private String categoriaItem;
    private String dataValidade;
    private double valor;

    public Item(String descricao, int idItem, String categoriaItem, String dataValidade, double valor) {
        this.descricao = descricao;
        this.idItem = idItem;
        this.categoriaItem = categoriaItem;
        this.dataValidade = dataValidade;
        this.valor = valor;
    }

    public void verificarDisponibilidade() {
        System.out.println("Item disponível: " + descricao);
    }

    public void relatorioMensal() {
        System.out.println("Relatório do item: " + descricao);
    }
}

// Classe Estoque
class Armazem {
    private int totalItens;
    private List<Item> listaItens = new ArrayList<>();

    public Armazem(int totalItens) {
        this.totalItens = totalItens;
    }

    public void registrarItem(Item item) {
        listaItens.add(item);
        System.out.println("Item registrado: " + item);
    }

    public void relatorioEstoqueAtual() {
        System.out.println("Relatório de estoque atual.");
    }

    public void validarEntradaItem(Item item) {
        System.out.println("Validação de entrada do item: " + item);
    }

    public void removerItem(Item item) {
        listaItens.remove(item);
        System.out.println("Item removido.");
    }

    public void atualizarItem(Item item) {
        System.out.println("Item atualizado: " + item);
    }
}

// Classe VendaItem
class TransacaoItem {
    private int idTransacao;
    private String nomeItem;
    private float precoItem;
    private String metodoPagamento;

    public TransacaoItem(int idTransacao, String nomeItem, float precoItem, String metodoPagamento) {
        this.idTransacao = idTransacao;
        this.nomeItem = nomeItem;
        this.precoItem = precoItem;
        this.metodoPagamento = metodoPagamento;
    }

    public void concluirVenda() {
        System.out.println("Venda concluída: " + nomeItem);
    }

    public void cancelarTransacao() {
        System.out.println("Transação cancelada.");
    }

    public void exibirCarrinho() {
        System.out.println("Exibindo carrinho de vendas.");
    }
}

// Classe Main para testar o sistema
public class Principal {
    public static void main(String[] args) {
        // Criando instituição financeira
        InstituicaoFinanceira instituicao = new InstituicaoFinanceira("Banco XYZ", "1234", 56789, "Corrente");
        instituicao.exibirSaldo();

        // Criando indivíduo físico
        IndividuoFisico individuo1 = new IndividuoFisico("João", "joao@mail.com", 987654321, 123456789, 987654321);
        individuo1.registrar();
        individuo1.relatorioDespesasMensais();

        // Criando empresa
        Empresa companhia = new Empresa("Empresa ABC", "contato@empresa.com", 123456789, "12.345.678/0001-99");
        companhia.efetuarCompra();

        // Criando item
        Item item = new Item("Notebook", 1, "Eletrônico", "2025-12-31", 2500.00);
        item.verificarDisponibilidade();

        // Registrando item no armazém
        Armazem armazem = new Armazem(100);
        armazem.registrarItem(item);
        armazem.relatorioEstoqueAtual();

        // Realizando venda
        TransacaoItem transacao = new TransacaoItem(1, "Notebook", 2500.00f, "Cartão");
        transacao.concluirVenda();
        transacao.exibirCarrinho();
    }
}
