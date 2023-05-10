import java.util.ArrayList;

//OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK
public class Cliente {
	private String nome;
	private String endereco;
	private ArrayList<Veiculo> listaVeiculos;
	private double valorSeguro;

	//Construtor
	public Cliente(String nome, String endereco, ArrayList<Veiculo> listaVeiculos) {

		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = listaVeiculos;
		this.valorSeguro = 0.0;
	}

	//Get da classe
	public String getNome() {
		return nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public ArrayList<Veiculo> getListaVeiculos(){
		return listaVeiculos;
	}
	public double getValorSeguro(){
		return valorSeguro;
	}
	
	//Set da classe
	public void setNome(String nome) {
		this.nome = nome;
	}	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos){
		this.listaVeiculos = listaVeiculos;
	}
	public void setValorSeguro(double valorSeguro){
		this.valorSeguro = valorSeguro;
	}
	
	//ToString, retorna todas as variaveis
	public String toString() {
		return "nome: " + nome + "\n" + "endereco: " + endereco + "\n" + "listaVeiculos: " + listaVeiculos + "\n" + 
				"valorSeguro: " + valorSeguro + "\n";
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

	//Funcao polimorfa
	public double calculaScore(){
		return 0.0;
	}

}
