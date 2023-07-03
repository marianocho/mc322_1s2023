import java.time.LocalDate;
import java.util.*;

public class Seguradora {
	private final String cnpj;
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Seguro> listaSeguros;
	private ArrayList<Cliente> listaClientes;
	private ArquivoClientePF arquivoClientePF;
	private ArquivoClientePJ arquivoClientePJ;
	private ArquivoCondutor arquivoCondutor;
	private ArquivoFrota arquivoFrota;
	private ArquivoSeguro arquivoSeguro;
	private ArquivoSinistro arquivoSinistro;
	private ArquivoVeiculo arquivoVeiculo;
	
	//Construtor
	public Seguradora(String cnpj, String nome, String telefone, String email, String endereco) {
		if(Validacao.validarCNPJ(cnpj)){
			this.cnpj =  cnpj;
		}
		else{
			Scanner scan = new Scanner(System.in);
			System.out.println("CNPJ inválido! Digite novamente: ");
			this.cnpj = scan.next();
			scan.close();
		}
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaSeguros = new ArrayList<Seguro>();
		this.listaClientes = new ArrayList<Cliente>();
	}
	
	//Get da classe
	public String getCnpj(){
		return cnpj;
	}
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
	public ArrayList<Seguro> getListaSeguros(){
		return listaSeguros;
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
	public void setListaSeguros(ArrayList<Seguro> listaSeguros){
		this.listaSeguros = listaSeguros;
	}
	public void setListaClientes(ArrayList<Cliente> listaClientes){
		this.listaClientes = listaClientes;
	}

	//toString da classe
	public String toString(){
		return "cnpj: " + cnpj + "\n" + "nome: " + nome + "\n" + "telefone: " + telefone + "\n" + "email: " + email + "\n" + "endereco: " 
				+ endereco + "\n" + "Numero de Seguros: " + listaSeguros.size() + "\n" + "Numero de Clientes: " + listaClientes.size() + "\n";
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
	
	//Lista os clientes e retorna o que o usuario escolher
	public Cliente escolheCliente(){
		int ind = 0;
		int indDesejado;
		Scanner scan = new Scanner(System.in);
		//Lista todos clientes
		for(Cliente c : listaClientes){
			System.out.println(ind+". "+c.getNome()+"\n");
			ind++;
		}
		System.out.println("Qual o numero do cliente que deseja selecionar?\n");
		indDesejado = scan.nextInt();
		if(indDesejado < listaClientes.size()){
			return listaClientes.get(indDesejado);
		}
		else{
			System.out.println("Nao existe esse numero!\n");
			return null;
		}
	}

	//Lista todos os veiculos de um cliente e retorna o que o usuario desejar
	public Veiculo escolheVeiculo(Cliente cliente){
		Scanner scan = new Scanner(System.in);
		//se for pf
		if(cliente instanceof ClientePF){
			ClientePF clipf = (ClientePF) cliente;
			clipf.listarVeiculos();
			System.out.println("Qual o numero do veiculo desejado?\n");
			int indDesejado = scan.nextInt();
			if(indDesejado < clipf.getListaVeiculos().size()){
				return clipf.getListaVeiculos().get(indDesejado);
			}
			else{
				return null;
			}
		}
		else if(cliente instanceof ClientePJ){
			ClientePJ clipj = (ClientePJ) cliente;
			//Listando a frota e seus respectivos veiculos
			for(Frota f : clipj.getListaFrota()){
				System.out.println("Frota: "+f.getCode()+"\n");
				int ind = 0;
				for(Veiculo v : f.getListaVeiculos()){
					System.out.println(ind+". "+v.getPlaca()+"\n");
					ind++;
				}
			}
			System.out.println("Qual o codigo da frota desejada?\n");
			String codeDesejado = scan.next();
			System.out.println("Qual o numero do veiculo desejado? Se nao houver digite -1\n");
			int indDesejado = scan.nextInt();
			if(indDesejado== -1){
				return null;
			}
			for(Frota f : clipj.getListaFrota()){
				if(f.getCode().equals(codeDesejado)){
					return f.getListaVeiculos().get(indDesejado);
				}
			}
		}
		return null;
	}

	//Lista todos os seguros e retorna o que o usuario quiser
	public Seguro escolheSeguro(){
		int ind = 0;
		Scanner scan = new Scanner(System.in);
		for(Seguro seguro : listaSeguros){
			System.out.println(ind + ": " + seguro + "\n");
			ind++;
		}
		System.out.println("Qual o numero do seguro que voce deseja? obs: nao eh o id que esta sendo pedido\n");
		int indice = scan.nextInt();
		if(indice < listaSeguros.size()){
			return listaSeguros.get(indice);
		}
		else{
			System.out.println("Esse numero nao existe!\n");
			return null;
		}
	}
	
	//Gerar seguro novo
	public boolean gerarSeguro(Cliente cliDesejado, Veiculo vDesejado){
		LocalDate hoje = LocalDate.now();
		
		//SeguroPF
		if(cliDesejado instanceof ClientePF){
			//Downcasting
			ClientePF cliPF = (ClientePF) cliDesejado;
			SeguroPF segNovo = new SeguroPF(hoje, hoje.plusYears(10), this, 0, vDesejado, cliPF);
			segNovo.setValorMensal(segNovo.calcularValor());
			//Verificando se o seguro ja existe
			for(Seguro seg : listaSeguros){
				if(seg == segNovo){
					System.out.println("Seguro ja existente!\n");
					return false;
				}
			}
			listaSeguros.add(segNovo);
		}
		//SeguroPJ
		else{
			//Downcasting
			ClientePJ cliPJ = (ClientePJ) cliDesejado;
			SeguroPJ segNovo = new SeguroPJ(hoje, hoje.plusYears(10), this, 0, cliPJ.getFrotaPorVeiculo(vDesejado), cliPJ);
			segNovo.setValorMensal(segNovo.calcularValor());
			//Verificando se o seguro ja existe
			for(Seguro seg : listaSeguros){
				if(seg == segNovo){
					System.out.println("Seguro ja existente!\n");
					return false;
				}
			}
			listaSeguros.add(segNovo);
		}
		cadastrarCliente(cliDesejado);
		return true;
			
	}

	//Cancelar algum seguro
	public boolean cancelarSeguro(int idRemovido){
		Seguro segRemover = null;
		boolean existe = false;
		for(Seguro s : listaSeguros){
			//Se o seguro existe e é o desejado
			if(s.getId() == idRemovido){
				segRemover = s;
				existe = true;
			}
		}
		//Remover seguro se ele existe
		if(existe){
			listaSeguros.remove(segRemover);
			System.out.println("Removido!\n");
			return true;
		}
		else{
			System.out.println("Nao existe este seguro!\n");
			return false;
		}
		
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
			if(clienteExiste.getNome().equals(cliente)){
				System.out.println("Cliente removido!");
				listaClientes.remove(clienteExiste);
				return true;
			}
		}
		//Cliente nao existe na lista
		System.out.println("Cliente não existente!");
		return false;
	}

	public ArrayList<Seguro> getSegurosPorCliente(){
		Cliente cliente = escolheCliente();
		ArrayList<Seguro> listaSegurosPorCliente = new ArrayList<Seguro>();
		//Para cada seguro na listaSeguros
		for(Seguro seg : listaSeguros){
			//Ver se eh o cliente desejado, caso pf
			if(seg instanceof SeguroPF){
				SeguroPF segpf = (SeguroPF) seg; //Downcasting
				if(segpf.getCliente() == cliente){
					listaSegurosPorCliente.add(segpf);
				}
			}
			//Ver se eh o cliente desejado, caso pj
			else{
				SeguroPJ segpj = (SeguroPJ) seg; //Downcasting
				if(cliente == segpj.getCliente()){
					listaSegurosPorCliente.add(segpj);
				}
			}
		}
		return listaSegurosPorCliente;
		
	}

	public ArrayList<Sinistro> getSinistrosPorCliente(){
		Cliente cliente = escolheCliente();
		ArrayList<Sinistro> listaSinistroPorCliente = new ArrayList<Sinistro>();
		//Para cada seguro da listaSeguros
		for(Seguro seg : listaSeguros){
			//Caso que o seguro e o cliente sao PF, e o cliente é o mesmo do seguro
			if(seg instanceof SeguroPF && cliente instanceof ClientePF){
				SeguroPF segpf = (SeguroPF) seg; //Downcasting
				if(segpf.getCliente() == cliente){
					//Juntar a listaSinistros na lista que iremos retornar
					for(Sinistro sin : segpf.getListaSinistros()){
						listaSinistroPorCliente.add(sin);					
					}
				}
			}
			//Caso que o seguro e o cliente sao PJ
			else if(seg instanceof SeguroPJ && cliente instanceof ClientePJ){
				SeguroPJ segpj = (SeguroPJ) seg; //Downcasting
				if(segpj.getCliente() == cliente){
					//Juntar a listaSinistros na lista que iremos retornar
					for(Sinistro sin : segpj.getListaSinistros()){
						listaSinistroPorCliente.add(sin);					
					}
				}
			}
		}
		return listaSinistroPorCliente;
	}

	//Retorna o preco somado de todos os clientes da Seguradora
	public double calcularReceita(){
		double receita = 0.0;
		
		//Calculando valor de cada seguro e totalizando em receita
		for(Seguro seg : listaSeguros){
			receita += seg.calcularValor();
		}

		return receita;
	}

	public void lerDados(){

	}

	public void gravarDados(){

	}
}
