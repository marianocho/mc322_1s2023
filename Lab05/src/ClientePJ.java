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
        this.cnpj =  cnpj; //validar cnpj quando for obter ele
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
		Frota frota = new Frota();
        this.listaFrota.add(frota);
        return true;
	}

    public String escolheFrota(ClientePJ cliente){
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual o codigo da frota desejada?\n");
        for(Frota f : cliente.getListaFrota()){
            System.out.println(f);
        }

        return scan.next();
    }

	public boolean atualizarFrota(String comando, Veiculo v, String code){
        //Adicionar veiculo na frota
        if(comando.equals("A")){
            //Achar a frota desejada
            for(Frota f : listaFrota){
                if(code.equals(f.getCode())){
                    f.getListaVeiculos().add(v); //add o veiculo
                    return true;
                }
            }
        }
        //Remover veiculo da frota
        else if(comando.equals("R")){
            //Achar a frota desejada
            for(Frota f : listaFrota){
                if(code.equals(f.getCode())){
                 //rmv o veiculo
                    if(f.removeVeiculo(v)){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        //Remover frota
        else if(comando.equals("RF")){
            for(Frota f : listaFrota){
                if(code.equals(f.getCode())){
                    listaFrota.remove(f);
                    return true;
                }
            }
        }
        else{
            System.out.println("Comando invalido!\n");
            return false;
        }
        
        return false;

	}
	
    public ArrayList<Veiculo> getVeiculosPorFrota(String code){
        for(Frota f : listaFrota){
            //se for a frota desejada
            if(f.getCode() == code){
                return f.getListaVeiculos();
            }
        }

        return new ArrayList<Veiculo>();
    }

    //Retorna a frota em que tal veiculo esta
    public Frota getFrotaPorVeiculo(Veiculo veiculo){
        for(Frota f : listaFrota){
            for(Veiculo v : f.getListaVeiculos()){
                if(v == veiculo){
                    return f;
                }
            }
        }
        return null;
    }
}