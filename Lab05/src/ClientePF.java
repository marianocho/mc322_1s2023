import java.util.ArrayList;
import java.time.LocalDate;

public class ClientePF extends Cliente{
    //variaveis do ClientePF
    private final String cpf;
    private LocalDate dataNascimento;
	private String educacao;
	private String genero;
	private ArrayList<Veiculo> listaVeiculos;

    //Construtora da classe
    public ClientePF(String nome, String endereco, String telefone, String email,
                        String cpf, LocalDate dataNascimento, String educacao, String genero){

        //chama o construtor da superclasse
        super(nome, endereco, telefone, email);
		//variaveis da classe
		if(Validacao.validarCPF(cpf)){
			this.cpf = cpf;
		}
		else{
			break;
		}
        this.dataNascimento = dataNascimento;
		this.educacao = educacao;
		this.genero = genero;
		this.listaVeiculos = new ArrayList<Veiculo>();
    }

    //Get da classe
    public String getCpf(){
        return cpf;
    }
    public LocalDate getDataNascimento(){
        return dataNascimento;
    }
	public String getEducacao() {
		return educacao;
	}
	public String getGenero() {
		return genero;
	}
	public ArrayList<Veiculo> getListaVeiculos(){
		return listaVeiculos;
	}
	//calcular a idade baseado nas datas
	public int getIdade(){
		LocalDate hoje = LocalDate.now();
		int idade = hoje.getYear() - dataNascimento.getYear();
		//se a pessoa nao fez o aniversario no ano atual ainda
		if(dataNascimento.getMonthValue() > hoje.getMonthValue()){
			idade -= 1;
		}
		else if(dataNascimento.getMonthValue() == hoje.getMonthValue() && dataNascimento.getDayOfMonth() > hoje.getDayOfMonth()){
			idade -= 1;
		}

		return idade;
	}

    //Set da classe
    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }
	public void setEducacao(LocalDate educacao) {
		this.educacao = educacao;
	}
	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void setListaVeiculos(String listaVeiculos){
		this.listaVeiculos = listaVeiculos;
	}

	@Override
    //toString da classe, retorna todas as variaveis
    public String toString(){
        return "nome: " + getNome() + "\n" + "endereco: " + getEndereco() + "\n" + "telefone: " + getTelefone() + "\n"
				+ "email: " + email + "\n" + "cpf: " + cpf + "\n" + "dataNascimento: " + dataNascimento + "\n"
				+ "educacao: " + educacao + "\n" + "genero: " + genero + "\n" + "listaVeiculos: " + listaVeiculos + "\n";
    }

	@Override
	public double calculaScore(){
		double fator_idade = 0.0;
		if(18 <= getIdade() && getIdade() < 30){
			fator_idade = CalcSeguro.FATOR_18_30.getValor();
		}
		else if(30 <= getIdade() && getIdade() < 60){
			fator_idade = CalcSeguro.FATOR_30_60.getValor();
		}
		else if(60 <= getIdade() && getIdade() <= 90){
			fator_idade = CalcSeguro.FATOR_60_90.getValor();
		}
		return CalcSeguro.VALOR_BASE.getValor() * fator_idade * getListaVeiculos().size();
	}

	//Controle da listaVeiculos
	public boolean addVeiculo(Veiculo v){
		for(Veiculo veiculo : listaVeiculos){
			if(veiculo == v){
				System.out.println("Veiculo ja existente!");
				return false;
			}
		}
		System.out.println("Veiculo adicionado!");
		listaVeiculos.add(v);
		return true;
	}

	public boolean removeVeiculo(Veiculo v){
		for(Veiculo veiculo : listaVeiculos){
			if(veiculo == v){
				System.out.println("Removendo veiculo!");
				listaVeiculos.remove(v);
				return true;
			}
		}
		System.out.println("Nao existe esse veiculo!");
		return false;
	}
	
	public void listarVeiculos(){
		for(Veiculo v : listaVeiculos){
			System.out.println(v);
		}
	}
}
