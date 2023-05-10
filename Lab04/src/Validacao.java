public class Validacao{
    //Valida cpf
    public static boolean validarCPF(String cpf) {
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

    //Valida CNPJ
    public static boolean validarCNPJ(String cnpj){
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

    //Valida nome
    public static boolean validarNome(String nome){
        for(int i = 0; i < nome.length(); i++){
            char c = nome.charAt(i);
            if(!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }
}
