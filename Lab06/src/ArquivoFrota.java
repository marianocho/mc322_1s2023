import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ArquivoFrota {
    public boolean gravarArquivo(){
        return false;
    }

    public String lerArquivo(){
        return "";
    }

    try(FileReader fileReader = new FileReader("../lib/frotas.csv")){
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String linha;
        StringTokenizer tokenizer = new StringTokenizer(linha, ",");
        while((linha = bufferedReader.readLine()) != null){
            while (tokenizer.hasMoreTokens()) {
                String info = tokenizer.nextToken();
            }
        }
    }
    catch(IOException e){
        System.out.println("Houve um erro ao tentar ler/abrir o arquivo de frotas.csv\n");
    }
}