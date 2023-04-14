import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String endereco;
	private ArrayList<Veiculo> listaVeiculos;

	//Construtor
	public Cliente(String nome, String endereco, ArrayList<Veiculo> listaVeiculos) {

		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = listaVeiculos;
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
	
	//ToString, retorna todas as variaveis
	public String toString() {
		return "nome: " + nome + "\n" + "endereco: " + endereco + "\n" + "listaVeiculos: " + listaVeiculos + "\n";
	}

	//Controle da listaVeiculos
	public void addVeiculo(Veiculo v){
		listaVeiculos.add(v);
	}

	public void removeVeiculo(Veiculo v){
		//Remover o veiculo desejado
		listaVeiculos.remove(v);
	}
	
}
