public class Main {
	
	public static void main(String[] args){
		//Cliente
		//Criando o objeto
		Cliente cli = new Cliente("Joao", "134.953.400-50", "15/04/2003", 19, "Rua Teste 10");
		//Validando cpf
		if(cli.validarCPF(cli.getCpf())){
			System.out.println("CPF valido!\n");
		}
		else {
			System.out.println("CPF invalido!\n");
		}
		//Get e print no nome
		System.out.println("Nome: " + cli.getNome() + "\n");
		//Set nome
		cli.setNome("Pedro");
		System.out.println("Nome: " + cli.getNome() + "\n");
		//toString
		System.out.println(cli);

		//Seguradora
		//Criando o objeto
		Seguradora seg = new Seguradora("Pedro", "11996601234", "teste@gmail.com", "Rua Teste 10");	
		//Get e print no telefone
		System.out.println("Telefone: " + seg.getTelefone() + "\n");
		//Set telefone
		seg.setTelefone("11969604321");
		System.out.println("Telefone: " + seg.getTelefone() + "\n");

		//Veiculo
		//Criando o objeto
		Veiculo vei = new Veiculo("BMW-6060", "BMW", "X6");
		//Get e print na placa
		System.out.println("Placa: " + vei.getPlaca() + "\n");
		//Set placa
		vei.setPlaca("TST-0101");
		System.out.println("Placa: " + vei.getPlaca() + "\n");
		
		//Sinistro
		//Criando o objeto
		Sinistro sin = new Sinistro("20/04/2023", "Rua Testing 200");
		//Get e print no endereco
		System.out.println("Endereco: " + sin.getEndereco() + "\n");
		//Set endereco
		sin.setEndereco("Rua Teste 200");
		System.out.println("Endereco: " + sin.getEndereco() + "\n");
		
	}
}
