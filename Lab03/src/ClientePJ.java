import java.util.Date;
import java.util.ArrayList;

public class ClientePJ extends Cliente{
    private String cnpj;
    private Date dataFundacao;


    //Construtora da classe
    public ClientePJ(String nome, String endereco, Date dataLicenca, 
                        String educacao, String genero, String classeEconomica,
                         ArrayList<Veiculo> listaVeiculos, String cnpj, Date dataFundacao){

        //chama o construtor da superclasse
        super(nome, endereco, dataLicenca, educacao, genero, classeEconomica, listaVeiculos);
        this.cnpj =  cnpj;
        this.dataFundacao = dataFundacao;

    }

    //Get da classe
    public String getCnpj(){
        return cnpj;
    }

    public Date getDataFundacao(){
        return dataFundacao;
    }

    //Set da classe
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }

    public void setDataFundacao(Date dataFundacao){
        this.dataFundacao = dataFundacao;
    }

    //toString da classe, retorna todas as variaveis da classe
    public String toString(){
        return "nome: " + getNome() + "\n" + "endereco: " + getEndereco() + "\n" + "dataLicenca: " + getDataLicenca() + "\n"
				+ "educacao: " + getEducacao() + "\n" + "genero: " + getGenero() + "\n" + "classeEconomica: " + getClasseEconomica() + "\n"
				+ "listaVeiculos: " + getListaVeiculos() + "\n" + "cnpj: " + cnpj + "\n" + "dataFundacao: " + dataFundacao + "\n";
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
    }

}