import java.util.*;

//OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Sinistro> listaSinistros;
	private ArrayList<Cliente> listaClientes;
	
	//Construtor
	public Seguradora(String nome, String telefone, String email, String endereco, 
						ArrayList<Sinistro> listaSinistros, ArrayList<Cliente> listaClientes) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaSinistros = listaSinistros;
		this.listaClientes = listaClientes;
	}
	
	//Get da classe
	public String getNome() {
		return nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public ArrayList<Sinistro> getListaSinistros(){
		return listaSinistros;
	}

	public ArrayList<Cliente> getListaClientes(){
		return listaClientes;
	}
	
	//Set da classe
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setListaSinistros(ArrayList<Sinistro> listaSinistros){
		this.listaSinistros = listaSinistros;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes){
		this.listaClientes = listaClientes;
	}

	//toString da classe
	public String toString(){
		return "nome: " + nome + "\n" + "telefone: " + telefone + "\n" + "email: " + email + "\n" + "endereco: " + endereco + "\n" +
				"listaSinistros: " + listaSinistros + "\n" + "listaClientes: " + listaClientes + "\n";
	}

	//Controle de clientes
	public boolean cadastrarCliente(Cliente cliente){
		//Verificar se o cliente ja existe na lista
		for(Cliente clienteExistente : listaClientes){
			if(clienteExistente == cliente){
				System.out.println("Cliente já existente!");
				return false;
			}
		}	
		//Cliente n existe na lista
		listaClientes.add(cliente);
		System.out.println("Cliente cadastrado!");
		return true;
	}

	public boolean removerCliente(String cliente){
		//Verificar se o cliente existe
		for(Cliente clienteExiste : listaClientes){
			if(clienteExiste.getNome() == cliente){
				System.out.println("Cliente removido!");
				listaClientes.remove(clienteExiste);
				return true;
			}
		}
		//Cliente nao existe na lista
		System.out.println("Cliente não existente!");
		return false;
	}

	//Listar clientes
	public ArrayList<Cliente> listarClientes(String tipoCliente){
		ArrayList<Cliente> listaCorrespondentes = new ArrayList<Cliente>(); 
		//Verificar se o cliente é PF ou PJ para cada um da listaClientes
		for(Cliente cliente : listaClientes){
			//Se for PJ
			if(tipoCliente == "ClientePF" && cliente instanceof ClientePF){
				//printa
				System.out.println(cliente);
				//add na lista q vai retornar
				listaCorrespondentes.add(cliente);
			}
			else if(tipoCliente == "ClientePJ" && cliente instanceof ClientePJ){
				//printa
				System.out.println(cliente);
				//add na lista q vai retornar
				listaCorrespondentes.add(cliente);
			}
		}

		return listaCorrespondentes;
	}

	//Funcoes de vizualicao e geracao de sinistros
	public boolean gerarSinistro(Veiculo veiculo, Cliente cliente, String endereco){
		//Gerando sinistro
		Sinistro novoSinistro = new Sinistro("2023/03/11", endereco, this, veiculo, cliente);
		listaSinistros.add(novoSinistro);
		System.out.println("Sinistro gerado!");
		return true;
	}

	//Printa o sinistro do cliente desejado
	public boolean vizualizarSinistro(String cliente){
		int ok = 0;
		//Percorrer a listaSinistros até achar o cliente correspondente
		for(Sinistro s : listaSinistros){
			//Pegar o cliente do sinistro correspondente
			Cliente c = s.getCliente();
			if(c.getNome().equals(cliente)){
				System.out.println(s);
				ok++;
			}
		}
		//se acharmos um sinistro para o cliente quer dizer que a operacao foi um sucesso
		if(ok >= 1){
			System.out.println(cliente + " possui " + ok + " sinistro(s)!");
			return true;
		}
		else{
			System.out.println(cliente + " não possui sinistro registrado!");
			return false;
		}
	}

	public void listarSinistros(){
		for(Sinistro s : listaSinistros){
			System.out.println(s);
		}
	}

	//Retorna o preco do seguro do cliente desejado
	public double calcularPrecoSeguroCliente(Cliente cliente){
		int qtd_s = 0;
		//calcular a quantidade de sinistros
		for(Sinistro s : listaSinistros){
			if(cliente == s.getCliente()){
				qtd_s++;
			}
		}
		return (cliente.calculaScore() * (1 + qtd_s));
	}

	//Retorna o preco somado de todos os clientes da Seguradora
	public double calcularReceita(){
		double receita = 0.0;
		for(Cliente c : listaClientes){
			receita += calcularPrecoSeguroCliente(c);
		}

		return receita;
	}
}
