import java.util.ArrayList;
import java.time.LocalDate;

public class ClientePJ extends Cliente{
    private final String cnpj;
    private LocalDate dataFundacao;
    private int qtdeFuncionarios;

    //Construtora da classe
    public ClientePJ(String nome, String endereco, ArrayList<Veiculo> listaVeiculos, String cnpj, LocalDate dataFundacao, int qtdeFuncionarios){

        //chama o construtor da superclasse
        super(nome, endereco, listaVeiculos);
        if(Validacao.validarCNPJ(cnpj)){
            this.cnpj =  cnpj;
        }
        else{
            break;
        }
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;

    }

    //Get da classe
    public String getCnpj(){
        return cnpj;
    }

    public LocalDate getDataFundacao(){
        return dataFundacao;
    }

    public int getQtdeFuncionarios(){
        return qtdeFuncionarios;
    }

    //Set da classe
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }

    public void setDataFundacao(LocalDate dataFundacao){
        this.dataFundacao = dataFundacao;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios){
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    @Override
    //toString da classe, retorna todas as variaveis da classe
    public String toString(){
        return "nome: " + getNome() + "\n" + "endereco: " + getEndereco() + "\n" + "listaVeiculos: " + getListaVeiculos() + "\n" 
                + "cnpj: " + cnpj + "\n" + "dataFundacao: " + dataFundacao + "\n" + "qtdeFuncionarios: " + qtdeFuncionarios + "\n";
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
        soma = Character.getNumericValue(cnpj.charAt(0))*5 + 
                Character.getNumericValue(cnpj.charAt(1))*4 + 
                Character.getNumericValue(cnpj.charAt(2))*3 + 
                Character.getNumericValue(cnpj.charAt(3))*2 +
                Character.getNumericValue(cnpj.charAt(4))*9 + 
                Character.getNumericValue(cnpj.charAt(5))*8 + 
                Character.getNumericValue(cnpj.charAt(6))*7 + 
                Character.getNumericValue(cnpj.charAt(7))*6 + 
                Character.getNumericValue(cnpj.charAt(8))*5 + 
                Character.getNumericValue(cnpj.charAt(9))*4 + 
                Character.getNumericValue(cnpj.charAt(10))*3 + 
                Character.getNumericValue(cnpj.charAt(11))*2;
        resto = soma%11;
        if(resto < 2){
            digito1= 0;
        }
        else{
            digito1 = 11-resto;
        }
        //calculando o segundo digito verificador
        int digito2;
        soma = Character.getNumericValue(cnpj.charAt(0))*6 + 
                Character.getNumericValue(cnpj.charAt(1))*5 + 
                Character.getNumericValue(cnpj.charAt(2))*4 + 
                Character.getNumericValue(cnpj.charAt(3))*3 +
                Character.getNumericValue(cnpj.charAt(4))*2 + 
                Character.getNumericValue(cnpj.charAt(5))*9 + 
                Character.getNumericValue(cnpj.charAt(6))*8 + 
                Character.getNumericValue(cnpj.charAt(7))*7 + 
                Character.getNumericValue(cnpj.charAt(8))*6 + 
                Character.getNumericValue(cnpj.charAt(9))*5 + 
                Character.getNumericValue(cnpj.charAt(10))*4 + 
                Character.getNumericValue(cnpj.charAt(11))*3 + 
                digito1*2;
        resto = soma%11;
        if(resto < 2){
            digito2 = 0;
        }
        else{
            digito2 = 11-resto;
        }
        //verificando se os digitos verificadores coincidem com o do cnpj
        if(Character.getNumericValue(cnpj.charAt(12)) == digito1 && Character.getNumericValue(cnpj.charAt(13)) == digito2){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public double calculaScore(){
        return CalcSeguro.VALOR_BASE.getValor() * (1 + ( qtdeFuncionarios ) /100) * getListaVeiculos().size();
    }
}