import java.util.ArrayList;
import java.util.Date;

public class ClientePF extends Cliente{
    //variaveis do ClientePF
    private String cpf;
    private Date dataNascimento;

    //Construtora da classe
    public ClientePF(String nome, String endereco, Date dataLicenca, 
                        String educacao, String genero, String classeEconomica,
                         ArrayList<Veiculo> listaVeiculos, String cpf, Date dataNascimento){

        //chama o construtor da superclasse
        super(nome, endereco, dataLicenca, educacao, genero, classeEconomica, listaVeiculos);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;

    }

    //Get da classe
    public String getCpf(){
        return cpf;
    }

    public Date getDataNascimento(){
        return dataNascimento;
    }

    //Set da classe
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setDataNascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }

	@Override
    //toString da classe, retorna todas as variaveis
    public String toString(){
        return "nome: " + getNome() + "\n" + "endereco: " + getEndereco() + "\n" + "dataLicenca: " + getDataLicenca() + "\n"
				+ "educacao: " + getEducacao() + "\n" + "genero: " + getGenero() + "\n" + "classeEconomica: " + getClasseEconomica() + "\n"
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
}
