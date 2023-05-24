import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class ClientePJ extends Cliente{
    private final String cnpj;
    private LocalDate dataFundacao;
    private int qtdeFuncionarios;
    private ArrayList<Frota> listaFrota;

    //Construtora da classe
    public ClientePJ(String nome, String endereco, String telefone, String email, String cnpj, LocalDate dataFundacao, int qtdeFuncionarios){

        //chama o construtor da superclasse
        super(nome, endereco, telefone, email);
        //Verificando cnpj
        if(Validacao.validarCNPJ(cnpj)){
            this.cnpj =  cnpj;
        }
        else{
            Scanner scan = new Scanner(System.in);
            System.out.println("CNPJ inválido! Digite novamente: ");
            this.cnpj = scan.next();
            scan.close();
        }
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
        this.listaFrota = new ArrayList<Frota>();

    }

    //Get da classe
    public String getCnpj(){
        return cnpj;
    }
    public LocalDate getDataFundacao(){
        return dataFundacao;
    }
    public int getQtdeFuncionarios(){
        return qtdeFuncionarios;
    }
    public ArrayList<Frota> getListaFrota(){
        return listaFrota;
    }
    //calcular a idade do clientePJ
    public int getAnosPosFundacao(){
        LocalDate hoje = LocalDate.now();
		int idade = hoje.getYear() - dataFundacao.getYear();
		//se a pessoa nao fez o aniversario no ano atual ainda
		if(dataFundacao.getMonthValue() > hoje.getMonthValue()){ //checando o mes
			idade -= 1;
		}
        //como o mes é igual, checando o dia
		else if(dataFundacao.getMonthValue() == hoje.getMonthValue() && dataFundacao.getDayOfMonth() > hoje.getDayOfMonth()){
			idade -= 1;
		}
		return idade;
    }
    
    //Set da classe
    public void setDataFundacao(LocalDate dataFundacao){
        this.dataFundacao = dataFundacao;
    }
    public void setQtdeFuncionarios(int qtdeFuncionarios){
        this.qtdeFuncionarios = qtdeFuncionarios;
    }
    public void setListaFrota(ArrayList<Frota> listaFrota){
        this.listaFrota = listaFrota;
    }

    @Override
    //toString da classe, retorna todas as variaveis da classe
    public String toString(){ 
        return "nome: " + getNome() + "\n" + "endereco: " + getEndereco() + "\n" + "telefone: " + getTelefone() + "\n" 
                + "email: " + getEmail() + "\n" + "cnpj: " + cnpj + "\n" + "dataFundacao: " + dataFundacao + "\n" + "qtdeFuncionarios: " 
                + qtdeFuncionarios + "\n" + "listaFrota: " + listaFrota + "\n";
    }

    @Override
    public double calculaScore(){
        return CalcSeguro.VALOR_BASE.getValor() * (1 + ( qtdeFuncionarios ) /100) * getListaFrota().size();
    }

    //Controle da listaFrota
    public boolean cadastrarFrota(){
		
	}

	public boolean ataulizarFrota(){
		
	}
	
    public boolean getVeiculosPorFrota(){
        
    }
}