import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] agrs){
        //Instaciando uma nova seguradora
        ArrayList<Sinistro> lS = new ArrayList<Sinistro>(); //Lista de sinistros vazia
        ArrayList<Cliente> lC = new ArrayList<Cliente>(); //Lista de Clientes vazia
        Seguradora seg = new Seguradora("SegTeste", "19996681234", "teste@gmail.com", "Rua Seguradora 100", lS, lC);
        
        //Criar clientePF
        ArrayList<Veiculo> v1 = new ArrayList<Veiculo>();
        LocalDate dL = LocalDate.of(2022, 10, 20);
        LocalDate dN = LocalDate.of(2003, 12, 30);
        ClientePF cliente_pf = new ClientePF("Joao da Costa", "Rua do Joao 123", dL, "EM completo", "masculino", 
                                                "Classe media", v1, "126.632.950-19", dN);
        //Se CPF é valido cadastrar ClientePF
        if(cliente_pf.validarCPF(cliente_pf.getCpf())){
            System.out.println("CPF valido!");
            seg.cadastrarCliente(cliente_pf); //add cliente_pf na lista
        }
        else{
            System.out.println("CPF invalido!");
        }
        
        //Criar clientePJ
        ArrayList<Veiculo> v2 = new ArrayList<Veiculo>();
        LocalDate dF = LocalDate.of(2010, 02, 11);
        ClientePJ cliente_pj = new ClientePJ("Corps teste", "Rua do Corps 456", v2, "11.222.333/0001-81", dF);
        //Se CNPJ é valido cadastrar ClientePJ
        if(cliente_pj.validarCNPJ(cliente_pj.getCnpj())){
            System.out.println("CNPJ valido!");
            seg.cadastrarCliente(cliente_pj); //add cliente_pj na lista
        }
        else{
            System.out.println("CNPJ invalido!");
        }

        //Criar clientePJ que sera removido
        ArrayList<Veiculo> vr = new ArrayList<Veiculo>();
        LocalDate dR = LocalDate.of(2000, 9, 18);
        ClientePJ cliente_rmv = new ClientePJ("Brownies da Mari", "Rua Pascal 65", vr, "54.949.404/0001-55",dR);
        //CNPJ é valido ou nao
        if(cliente_rmv.validarCNPJ(cliente_rmv.getCnpj())){
            System.out.println("CNPJ valido!");
            seg.cadastrarCliente(cliente_rmv);
        }
        else{
            System.out.println("CNPJ invalido!");
        }
        //Remover clientePJ
        seg.removerCliente(cliente_rmv.getNome());

        //Tentando adicionar um cliente repetido
        seg.cadastrarCliente(cliente_pj);

        //Adicionar um veiculo para ClientePF
        Veiculo novoVPF = new Veiculo("ABC1D23", "Honda", "Civic", 2020);
        System.out.println("Adicionando veiculo!");
        cliente_pf.addVeiculo(novoVPF);

        //Adicionar um veiculo para ClientePJ
        Veiculo novoVPJ = new Veiculo("WXY9Z87", "Toyota", "Corolla", 2022);
        System.out.println("Adicionando veiculo!");
        cliente_pj.addVeiculo(novoVPJ);


        //Gerando sinistro
        Veiculo v_sinistro = cliente_pf.getListaVeiculos().get(0); //Veiculo envolvido no sinistro
        System.out.println("Gerando sinistro!");
        seg.gerarSinistro(v_sinistro, cliente_pf);
        Veiculo v_sinistro2 = cliente_pj.getListaVeiculos().get(0);
        System.out.println("Gerando sinistro!");
        seg.gerarSinistro(v_sinistro2, cliente_pj);

        //toString de cada classe
        System.out.println(cliente_pf); //ClientePF
        System.out.println(cliente_pj); //ClientePJ
        System.out.println(seg); //Seguradora
        System.out.println(seg.getListaSinistros().get(0)); //Sinistro 1
        System.out.println(seg.getListaSinistros().get(1)); //Sinistro 2
        System.out.println(cliente_pf.getListaVeiculos().get(0)); //Veiculo

        //Listar clientes PF
        ArrayList<Cliente> listac = new ArrayList<Cliente>();
        System.out.println("Listando ClientesPF!");
        listac = seg.listarClientes("ClientePF");

        //Vizualizar sinistro de certo cliente
        System.out.println("Vizualizando sinistros!");
        seg.vizualizarSinistro(cliente_pf.getNome());

        //Listar sinistros
        System.out.println("Listando sinistros!");
        seg.listarSinistros();

        //SCANNER
        Scanner scan = new Scanner(System.in);
        System.out.println("Pressione enter");
        while(scan.hasNextLine()){
            //lista clientes
            System.out.println("Deseja listar todos os clientes? S/N");
            //le a resposta do usuario
            String resposta = scan.next();
            //se sim
            if(resposta.equals("S")){
                System.out.println("ClientesPF:\n");
                seg.listarClientes("ClientePF");
                System.out.println("ClientesPJ:\n");
                seg.listarClientes("ClientePJ");
            }
    
            //lista sinistros
            System.out.println("Deseja listar os sinistros? S/N");
            //le a resposta do usuario
            String resposta2 = scan.next();
            //se sim
            if(resposta2.equals("S")){
                seg.listarSinistros();
            }
    
            //lista sinistro de um cliente específico
            System.out.println("Deseja listar os sinistros de um cliente? S/N");
            //le a resposta do usuario
            String resposta3 = scan.next();
            //se sim
            if(resposta3.equals("S")){
                System.out.println("De qual cliente deseja listar?");
                String cliente_esp = scan.next();
                seg.vizualizarSinistro(cliente_esp);
            }

            //Pergunta se quer fechar
            System.out.println("Deseja continuar? S/N");
            String resposta4 = scan.next();
            if(resposta4.equals("N")){
                break;
            }
        }
        //scan.close();
    }
}
