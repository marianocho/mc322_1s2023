import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ArquivoClientePF {

    private ArrayList<ClientePF> listaClientes = new ArrayList<ClientePF>();
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
                    //Pegar as infos e criar um novo cliente com elas
                    infos.add(info);
                }
                //validarCPF
                if(Validacao.validarCPF(infos.get(0))){ //indice 0 eh cpf
                    ClientePF cli = new ClientePF(null, null, null, null, infos.get(0), null, null, null)
                    cli.setNome(infos.get(1));
                    cli.setTelefone(infos.get(2));
                    cli.setEndereco(infos.get(3));
                    cli.setEmail(infos.get(4));
                    cli.setGenero(infos.get(5));
                    cli.setEducacao(infos.get(6));
                    LocalDate dataNasc = LocalDate.parse(infos.get(7));
                    cli.setDataNascimento(dataNasc);
                    Veiculo v = new Veiculo(infos.get(8), null, null, 0);
                    cli.getListaVeiculos().add(v);
                    listaClientes.add(cli);
                }
                else{
                    System.out.println("CPF invalido\n");
                    break;
                }
            }
        }
        catch(IOException e){
            System.out.println("Houve um erro ao tentar ler/abrir o arquivo de clientesPF.csv\n");
        }
        return "";
    }

}
