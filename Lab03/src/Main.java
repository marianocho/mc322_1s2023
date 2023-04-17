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
        Veiculo novoVPF = new Veiculo("ABC1D23", "Honda", "Civic", 2020);
        cliente_pf.getListaVeiculos().add(novoVPF);
        //Adicionar um veiculo para ClientePJ
        Veiculo novoVPJ = new Veiculo("WXY9Z87", "Toyota", "Corolla", 2022);
        cliente_pj.getListaVeiculos().add(novoVPJ);

        //Instaciando uma nova seguradora
        ArrayList<Sinistros> lS = new ArrayList<Sinistros>(); //Lista de sinistros vazia
        ArrayList<Cliente> lC = new ArrayList<Cliente>(); //Lista de Clientes vazia
        Seguradora seg = new Seguradora("SegTeste", "19996681234", "teste@gmail.com", "Rua Seguradora 100", lS, lC);
        seg.cadastrarCliente(cliente_pf); //add cliente_pf na lista
        seg.cadastrarCliente(cliente_pj); //add cliente_pj na lista

        //Gerando sinistro
        Veiculo v_sinistro = cliente_pf.getListaVeiculos().charAt(0);
        seg.gerarSinistro(v_sinistro, cliente_pf);
        Veiculo v_sinistro2 = cliente_pj.getListaVeiculos().charAt(0);
        seg.gerarSinistro(v_sinistro2, cliente_pj);

        //toString de cada classe
        System.out.println(cliente_pf); //ClientePF
        System.out.println(cliente_pj); //ClientePJ
        System.out.println(seg); //Seguradora
        System.out.println(seg.getListaSinistros().charAt(0)); //Sinistro
        System.out.println(cliente_pf.getListaVeiculos().charAt(0)); //Veiculo

        //Listar clientes PF
        ArrayList<Cliente> listac = new ArrayList<Cliente>();
        listac = seg.listarClientes("ClientePF");

        //Vizualizar sinistro de certo cliente
        seg.vizualizarSinistro(cliente_pf);

        //Listar sinistros
        seg.listarSinistros();


        //Se apertar 1, lista clientes
        //Se apertar 2, lista sinistros
        //Se apertar 3, lista sinistro de um cliente específico
    }
}
