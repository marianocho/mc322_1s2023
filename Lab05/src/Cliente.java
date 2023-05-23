import java.util.ArrayList;

public abstract class Cliente {
	private String nome;
	private String endereco;
	private String telefone;
	private String email;

	//Construtor
	public Cliente(String nome, String endereco, String telefone, String email) {

		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}

	//Get da classe
	public String getNome() {
		return nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getelefone(){
		return telefone;
	}
	public String getEmail(){
		return email;
	}
	
	//Set da classe
	public void setNome(String nome) {
		this.nome = nome;
	}	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
	public void setEmail(String email){
		this.email = email;
	}
	
	//ToString, retorna todas as variaveis
	public String toString() {
		return "nome: " + nome + "\n" + "endereco: " + endereco + "\n" + "telefone: " + telefone + "\n" + 
				"email: " + email + "\n";
	}

	//Funcao polimorfa
	public double calculaScore(){
		return 0.0;
	}

}
