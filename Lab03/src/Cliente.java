import java.util.Date;
import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String endereco;
	private Date dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica;
	private ArrayList<Veiculo> listaVeiculos;

	//Construtor
	public Cliente(String nome, String endereco, Date dataLicenca, String educacao, String genero, 
					String classeEconomica, ArrayList<Veiculo> listaVeiculos) {

		this.nome = nome;
		this.endereco = endereco;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.genero = genero;
		this.classeEconomica = classeEconomica;
		this.listaVeiculos = listaVeiculos;
	}

	//Get da classe
	public String getNome() {
		return nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public Date getDataLicenca() {
		return dataLicenca;
	}
	public String getEducacao() {
		return educacao;
	}
	public String getGenero() {
		return genero;
	}
	public String getClasseEconomica(){
		return classeEconomica;
	}
	public ArrayList<Veiculo> getListaVeiculos(){
		return listaVeiculos;
	}
	
	//Set da classe
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}
	
	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setClasseEconomica(String classeEconomica){
		this.classeEconomica = classeEconomica;
	}

	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos){
		this.listaVeiculos = listaVeiculos;
	}
	
	//ToString, retorna todas as variaveis
	public String toString() {
		return "nome: " + nome + "\n" + "endereco: " + endereco + "\n" + "dataLicenca: " + dataLicenca + "\n"
				+ "educacao: " + educacao + "\n" + "genero: " + genero + "\n" + "classeEconomica: " + classeEconomica + "\n"
				+ "listaVeiculos: " + listaVeiculos + "\n";
	}
	
}
