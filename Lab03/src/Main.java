import java.util.ArrayList;
import java.time.LocalDate;

public class Main {
    public static void main(String[] agrs){
        //Criar clientePF
        ArrayList<Veiculo> v1 = new ArrayList<Veiculo>();
        LocalDate dL = LocalDate.of(2022, 10, 20);
        LocalDate dN = LocalDate.of(2003, 12, 30);
        ClientePF cliente_pf = new ClientePF("Joao da Costa", "Rua do Joao 123", dL, "EM completo", "masculino", 
                                                "Classe media", v1, "126.632.950-19", dN);
        //Se CPF é valido cadastrar ClientePF
        if(validarCpf(cliente_pf.getCpf())){
            cadastrarCliente(cliente_pf);
        }
        else{
            System.out.println("CPF invalido!");
        }
        //Criar clientePJ
        ArrayList<Veiculo> v2 = new ArrayList<Veiculo>();
        LocalDate dF = LocalDate.of(2010, 02, 11);
        ClientePJ cliente_pj = new ClientePJ("Felipe Araujo", "Rua do Lipe 456", "Ensino Superior completo", "masculino",
                                 "Classe alta", v2, "87.162.721/0001-86", dF);
        //Se CNPJ é valido cadastrar ClientePJ
        if(validarCnpj(cliente_pj.getCnpj())){
            cadastrarCliente(cliente_pj);
        }
        else{
            System.out.println("CNPJ invalido!");
        }

        //Adicionar um veiculo para ClientePF
        Veiculo novoVPF = new Veiculo();
        cliente_pf.getListaVeiculos().add(novoVPF);
        //Adicionar um veiculo para ClientePJ
        Veiculo novoVPJ = new Veiculo();
        cliente_pj.getListaVeiculos().add(novoVPJ);
    }
}
