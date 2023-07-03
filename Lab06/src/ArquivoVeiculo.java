import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ArquivoVeiculo {

    private ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
    private ArrayList<String> infos = new ArrayList<String>();

    public boolean gravarArquivo(){
        return false;
    }

    public String lerArquivo(){
        
        try(FileReader fileReader = new FileReader("../lib/clientesPF.csv")){
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha = "";
            StringTokenizer tokenizer = new StringTokenizer(linha, ",");
            while((linha = bufferedReader.readLine()) != null){
                while (tokenizer.hasMoreTokens()) {
                    String info = tokenizer.nextToken();
                    //Pegar as infos e criar um novo veiculo com elas
                    infos.add(info);
                }
            }
        }
        catch(IOException e){
            System.out.println("Houve um erro ao tentar ler/abrir o arquivo de veiculos.csv\n");
        }

        return "";
    }

}
