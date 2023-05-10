import java.util.ArrayList;
import java.time.LocalDate;

//OK OK OK OK OK OK OK OK OK OK OK

public class ClientePF extends Cliente{
    //variaveis do ClientePF
    private String cpf;
    private LocalDate dataNascimento;
	private LocalDate dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica;

    //Construtora da classe
    public ClientePF(String nome, String endereco, LocalDate dataLicenca, 
                        String educacao, String genero, String classeEconomica,
                         ArrayList<Veiculo> listaVeiculos, String cpf, LocalDate dataNascimento){

        //chama o construtor da superclasse
        super(nome, endereco, listaVeiculos);
		//variaveis da classe
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.genero = genero;
		this.classeEconomica = classeEconomica;
    }

    //Get da classe
    public String getCpf(){
        return cpf;
    }
    public LocalDate getDataNascimento(){
        return dataNascimento;
    }
	public LocalDate getDataLicenca() {
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

	//calcular a idade baseado nas datas
	public int getIdade(){
		LocalDate hoje = LocalDate.now();
		int idade = hoje.getYear() - dataNascimento.getYear();
		//se a pessoa nao fez o aniversario no ano atual ainda
		if(dataNascimento.getMonthValue() > hoje.getMonthValue()){
			idade -= 1;
		}
		else if(dataNascimento.getMonthValue() == hoje.getMonthValue() && dataNascimento.getDay() > hoje.getDay()){
			idade -= 1;
		}

		return idade;
	}

    //Set da classe
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }
	public void setDataLicenca(LocalDate dataLicenca) {
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

	@Override
    //toString da classe, retorna todas as variaveis
    public String toString(){
        return "nome: " + getNome() + "\n" + "endereco: " + getEndereco() + "\n" + "dataLicenca: " + dataLicenca + "\n"
				+ "educacao: " + educacao + "\n" + "genero: " + genero + "\n" + "classeEconomica: " + classeEconomica + "\n"
				+ "listaVeiculos: " + getListaVeiculos() + "\n" + "cpf: " + cpf + "\n" + "dataNascimento: " + dataNascimento + "\n";
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
		int ok = 0;
		for(int i = 0; i < cpf.length(); i++) {
			if(i < 10 && cpf.charAt(i) != cpf.charAt(i+1)){
				ok = 1;
				break;
			}
		}
		if(ok == 0){
			return false;
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

	@Override
	public double calculaScore(){
		double fator_idade = 0.0;
		if(18 <= getIdade() && getIdade() < 30){
			fator_idade = CalcSeguro.FATOR_18_30.getValor();
		}
		else if(30 <= getIdade() && getIdade() < 60){
			fator_idade = CalcSeguro.FATOR_30_60.getValor();
		}
		else if(60 <= getIdade() && getIdade() <= 90){
			fator_idade = CalcSeguro.FATOR_60_90.getValor();
		}
		return CalcSeguro.VALOR_BASE.getValor() * fator_idade * getListaVeiculos().size();
	}
}
