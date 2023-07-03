import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ArquivoClientePJ {

    private ArrayList<ClientePJ> listaClientes = new ArrayList<ClientePJ>();
    private ArrayList<String> infos = new ArrayList<String>();

    public boolean gravarArquivo(){
        return false;
    }

    public String lerArquivo(){
        try(FileReader fileReader = new FileReader("../lib/clientesPJ.csv")){
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha = "";
            StringTokenizer tokenizer = new StringTokenizer(linha, ",");
            while((linha = bufferedReader.readLine()) != null){
                while (tokenizer.hasMoreTokens()) {
                    String info = tokenizer.nextToken();
                    //Pegar as infos e criar um novo cliente com elas
                    infos.add(info);
                }
                //validarCNPJ
                if(Validacao.validarCNPJ(infos.get(0))){ //indice 0 eh cnpj
                    ClientePJ cli = new ClientePJ(null, null, null, null, infos.get(0), null, 0)
                }
            }
        }
        catch(IOException e){
            System.out.println("Houve um erro ao tentar ler/abrir o arquivo de clientesPJ.csv\n");
        }
        return "";
    }

}
