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
				+ endereco + "\n" + "listaSeguros: " + listaSeguros + "\n" + "listaClientes: " + listaClientes + "\n";
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
		System.out.println("Qual cliente deseja selecionar?\n");
		indDesejado = scan.nextInt();
		return listaClientes.get(indDesejado);
	}

	//Lista todos os veiculos de um cliente e retorna o que o usuario desejar
	public Veiculo escolheVeiculo(Cliente cliente){
		Scanner scan = new Scanner(System.in);
		//se for pf
		if(cliente instanceof ClientePF){
			cliente.listarVeiculos();
			System.out.println("Qual o numero do veiculo desejado?\n");
			int indDesejado = scan.nextInt();
			return cliente.getListaVeiculos().get(indDesejado);
		}
		else if(cliente instanceof ClientePJ){
			//Listando a frota e seus respectivos veiculos
			for(Frota f : cliente.getListaFrota()){
				System.out.println("Frota: "+f.getCode()+"\n");
				int ind = 0;
				for(Veiculo v : f.getListaVeiculos()){
					System.out.println(ind+". "+v.getPlaca()+"\n");
					ind++;
				}
			}
			System.out.println("Qual o codigo da frota desejada?\n");
			String codeDesejado = scan.next();
			System.out.println("Qual o veiculo desejado?\n");
			int indDesejado = scan.nextInt();
			for(Frota f : cliente.getListaFrota()){
				if(f.getCode().equals(codeDesejado)){
					return f.getListaVeiculos().get(indDesejado);
				}
			}
		}

	}


	//Gerar seguro novo
	public boolean gerarSeguro(){
		Cliente cliDesejado = escolheCliente();
		Veiculo vDesejado = escolheVeiculo(cliDesejado);
		LocalDate hoje = LocalDate.now();
		
		//SeguroPF
		if(cliDesejado instanceof ClientePF){
			ClientePF cliPF = (ClientePF) cliDesejado;
			SeguroPF segNovo = new SeguroPF(hoje, hoje.plusYears(10), this, 0, vDesejado, cliPF);
			segNovo.setValorMensal(segNovo.calcularValor());
		}
		//SeguroPJ
		else{
			ClientePJ cliPJ = (ClientePJ) cliDesejado;
			SeguroPJ segNovo = new SeguroPJ(hoje, hoje.plusYears(10), this, 0, cliPJ.getFrotaPorVeiculo(vDesejado), cliPJ);
			segNovo.setValorMensal(segNovo.calcularValor());
		}
		//Verificando se o seguro ja existe
		for(Seguro seg : listaSeguros){
			if(seg == segNovo){
				System.out.println("Seguro ja existente!\n");
				return false;
			}
		}
		return true;
			//Instanciando o veiculo do seguro
			//System.out.println("Qual a placa do veiculo a ser registrado?\n");
			/*String placa = scan.next();
			System.out.println("Qual a marca do veiculo a ser registrado?\n");
			String marca = scan.next();
			System.out.println("Qual o modelo do veiculo a ser registrado?\n");
			String modelo = scan.next();
			System.out.println("Qual o ano de fabricacao do veiculo a ser registrado?\n");
			int anoFabricacao = scan.nextInt();
			Veiculo v = new Veiculo(placa, marca, modelo, anoFabricacao);
			//Instanciando o cliente do seguro
			System.out.println("Qual o nome do cliente a ser registrado?\n");
			String nome = scan.nextLine();
			System.out.println("Qual o endereco do cliente a ser registrado?\n");
			String endereco = scan.nextLine();
			System.out.println("Qual o telefone do cliente a ser registrado?\n");
			String telefone = scan.next();
			System.out.println("Qual o email do cliente a ser registrado?\n");
			String email = scan.next();
			System.out.println("Qual o cpf do cliente a ser registrado?\n");
			String cpf = scan.next();
			//Enquanto o cpf nao for valido pedir novamente
			while(!Validacao.validarCPF(cpf)){
				System.out.println("CPF invalido!\n");
				cpf = scan.next();
			}
			System.out.println("Qual a data de nascimento? yyyy-mm-dd\n");
			LocalDate dataNascimento = LocalDate.parse(scan.next());
			System.out.println("Qual a educacao do cliente a ser registrado?\n");
			String educacao = scan.nextLine();
			System.out.println("Qual o genero do cliente a ser registrado?\n");
			String genero = scan.next();
			ClientePF c = new ClientePF(nome, endereco, telefone, email, cpf, dataNascimento, educacao, genero);*/
			//Instanciando nova frota?
			/*Frota frota = new Frota();
			//Instanciando novo cliente
			System.out.println("Qual o nome do cliente?\n");
			String nome = scan.nextLine();
			System.out.println("Qual o endereco do cliente?\n");
			String endereco = scan.nextLine();
			System.out.println("Qual o telefone do cliente?\n");
			String telefone = scan.next();
			System.out.println("Qual o email do cliente?\n");
			String email = scan.next();
			System.out.println("Qual o cnpj do cliente?\n");
			String cnpj = scan.next();
			//Validando cnpj
			while(!Validacao.validarCNPJ(cnpj)){
				System.out.println("CNPJ invalido!\n");
				cnpj = scan.next();
			}
			System.out.println("Qual a data de fundacao? yyyy-mm-dd\n");
			LocalDate dataFundacao = LocalDate.parse(scan.next());
			System.out.println("Qual a quantidade de funcionarios?\n");
			int qtdeFuncionarios = scan.nextInt();
			ClientePJ c = new ClientePJ(nome, endereco, telefone, email, cnpj, dataFundacao, qtdeFuncionarios)*/
	}

	//Cancelar algum seguro
	public boolean cancelarSeguro(int idRemovido){
		Seguro segRemover;
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
			System.out.println("Nao existe este seguro!\n")
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
			//Ver se eh o cliente desejado
			if(cliente = seg.getCliente()){
				listaSegurosPorCliente.add(seg);
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
			if(seg instanceof SeguroPF && cliente instanceof ClientePF && seg.getCliente() == cliente){
				//Juntar a listaSinistros na lista que iremos retornar
				for(Sinistro sin : seg.getListaSinistros()){
					listaSinistroPorCliente.add(sin);					
				}
			}
			//Caso que o seguro e o cliente sao PJ
			else if(seg instanceof SeguroPJ && cliente instanceof ClientePJ && seg.getCliente() == cliente){
				//Juntar a listaSinistros na lista que iremos retornar
				for(Sinistro sin : seg.getListaSinistros()){
					listaSinistroPorCliente.add(sin);					
				}
			}
		}
		return listaSinistroPorCliente;
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

	/*//Retorna o preco do seguro do cliente desejado
	public double calcularPrecoSeguroCliente(Cliente cliente){
		int qtd_s = 0;
		//calcular a quantidade de sinistros
		for(Sinistro s : listaSinistros){
			if(cliente == s.getCliente()){
				qtd_s++;
			}
		}
		return (cliente.calculaScore() * (1 + qtd_s));
	}*/

	//Retorna o preco somado de todos os clientes da Seguradora
	public double calcularReceita(){
		double receita = 0.0;
		
		//Calculando valor de cada seguro e totalizando em receita
		for(Seguro seg : listaSeguros){
			receita += seg.calcularValor();
		}

		return receita;
	}
}
