import java.util.ArrayList;
import java.time.LocalDate;

public class ClientePJ extends Cliente{
    private String cnpj;
    private LocalDate dataFundacao;


    //Construtora da classe
    public ClientePJ(String nome, String endereco, String educacao, String genero, String classeEconomica,
                         ArrayList<Veiculo> listaVeiculos, String cnpj, LocalDate dataFundacao){

        //chama o construtor da superclasse
        super(nome, endereco, listaVeiculos);
        this.cnpj =  cnpj;
        this.dataFundacao = dataFundacao;

    }

    //Get da classe
    public String getCnpj(){
        return cnpj;
    }

    public LocalDate getDataFundacao(){
        return dataFundacao;
    }

    //Set da classe
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }

    public void setDataFundacao(LocalDate dataFundacao){
        this.dataFundacao = dataFundacao;
    }

    @Override
    //toString da classe, retorna todas as variaveis da classe
    public String toString(){
        return "nome: " + getNome() + "\n" + "endereco: " + getEndereco() + "\n" + "listaVeiculos: " + getListaVeiculos() + "\n" 
                + "cnpj: " + cnpj + "\n" + "dataFundacao: " + dataFundacao + "\n";
    }

    //Valida CNPJ
    public boolean validarCNPJ(String cnpj){
        //deixando o cnpj apenas com numeros
        cnpj = cnpj.replaceAll("[^0-9]", "");
        //ver se o cnpj tem 14 digitos
        if(cnpj.length() != 14){
            return false;
        }
        //verificando se todos os digitos sao iguais
        int ok = 0;
		for(int i = 0; i < cnpj.length(); i++) {
			if(i < 13 && cnpj.charAt(i) != cnpj.charAt(i+1)){
				ok = 1;
				break;
			}
		}
		if(ok == 0){
			return false;
		}
        //calculando o primeiro digito verificador
        int soma = 0;
        int digito1;
        int resto;
        soma = cnpj.charAt(0)*5 + cnpj.charAt(1)*4 + cnpj.charAt(2)*3 + cnpj.charAt(3)*2 +
                cnpj.charAt(4)*9 + cnpj.charAt(5)*8 + cnpj.charAt(6)*7 + cnpj.charAt(7)*6 + cnpj.charAt(8)*5 
                + cnpj.charAt(9)*4 + cnpj.charAt(10)*3 + cnpj.charAt(11)*2;
        resto = soma%11;
        if(resto < 2){
            digito1= 0;
        }
        else{
            digito1 = 11-resto;
        }
        //calculando o segundo digito verificador
        int digito2;
        soma = cnpj.charAt(0)*6 + cnpj.charAt(1)*5 + cnpj.charAt(2)*4 + cnpj.charAt(3)*3 +
                cnpj.charAt(4)*2 + cnpj.charAt(5)*9 + cnpj.charAt(6)*8 + cnpj.charAt(7)*7 + cnpj.charAt(8)*6 
                + cnpj.charAt(9)*5 + cnpj.charAt(10)*4 + cnpj.charAt(11)*3 + digito1*2;
        resto = soma%11;
        if(resto < 2){
            digito2 = 0;
        }
        else{
            digito2 = 11-resto;
        }
        //verificando se os digitos verificadores coincidem com o do cnpj
        if(cnpj.charAt(12) == digito1 && cnpj.charAt(13) == digito2){
            return true;
        }
        else{
            return false;
        }
    }

}