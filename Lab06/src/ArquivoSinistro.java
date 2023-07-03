public class ArquivoSinistro implements I_Arquivo{
    @Override
    public boolean gravarArquivo(){
        return false;
    }
    @Override
    public String lerArquivo(){
        return "";
    }
}
