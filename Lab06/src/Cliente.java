import java.util.ArrayList;

public abstract class Cliente {
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private boolean autorizacao;

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
	public String getTelefone(){
		return telefone;
	}
	public String getEmail(){
		return email;
	}
	public boolean getAutorizacao(){
		return autorizacao;
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
	public void setAutorizacao(boolean autorizacao){
		this.autorizacao = autorizacao;
	}
	
	//ToString, retorna todas as variaveis
	public String toString() {
		return "nome: " + nome + "\n" + "endereco: " + endereco + "\n" + "telefone: " + telefone + "\n" + 
				"email: " + email + "\n" + "autorizacao: " + autorizacao + "\n";
	}

	//Funcao polimorfa
	public double calculaScore(){
		return 0.0;
	}

}
