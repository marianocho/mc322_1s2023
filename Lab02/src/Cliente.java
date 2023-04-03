public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	//Construtor
	public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.endereco = endereco;
	}
	
	//Get da classe
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	//Set da classe
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	//ToString, retorna o nome, cpf, dataNascimento, idade e endereco do cliente
	public String toString() {
		return "nome: " + nome + "\n" + "cpf: " + cpf + "\n" + "dataNascimento: " + dataNascimento + "\n"
				+ "idade: " + idade + "\n" + "endereco: " + endereco + "\n";
	}
	
	//Valida cpf
	public boolean validarCPF(String cpf) {
		//deixando o cpf apenas com numeros
		cpf = cpf.replaceAll("[^0-9]", "");
		//ver se o cpf tem 11 digitos
		if(cpf.length() != 11) {
			return false;
		}
		//ver se todos os digitos sao iguais
		for(int i = 0; i < cpf.length(); i++) {
			if(i < 10 && cpf.charAt(i) != cpf.charAt(i+1)) {
				break;
			}
			else {
				return false;
			}
		}
		//calculando o primeiro digito verificador
		int j = 0;
		int soma = 0;
		for(int i = 10; i > 1; i--) {
			soma += Character.getNumericValue(cpf.charAt(j))*i;
			j++;
		}
		int digito1;
		int resto = soma%11;
		if(resto >= 2) {
			digito1 = 11 - resto;
		}
		else {
			digito1 = 0;
		}
		//calculando o segundo digito verificador
		j = 0;
		soma = 0;
		for(int i = 11; i > 2; i--) {
			soma += Character.getNumericValue(cpf.charAt(j))*i;
			j++;
		}
		soma += digito1*2;
		int digito2;
		resto = soma%11;
		if(resto >= 2) {
			digito2 = 11 - resto;
		}
		else {
			digito2 = 0;
		}
		//verificando se os digitos verificadores coincidem
		if( digito1 == Character.getNumericValue(cpf.charAt(9)) && digito2 == Character.getNumericValue(cpf.charAt(10)) ) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
