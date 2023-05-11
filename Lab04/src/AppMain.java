import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AppMain {
    //funcao de checar caso
    public static void qualOperacaoPrincipal(MenuOperacoes operacao, Seguradora seg){
        switch(operacao){
            //cadastrar (1)
            case CADASTRAR:
                int comandoC = 0;
                Scanner scanC = new Scanner(System.in);
                //Mostra as opcoes
                System.out.println("1.1 - Cadastrar Cliente\n1.2 - Cadastrar Veiculo\n1.3 - Cadastrar Seguradora\n1.4 - Voltar\n");
                //Enquanto nao voltar
                while(comandoC != 4){
                    //pergunta qual opcao o usuario quer
                    System.out.println("Qual acao 1.x voce deseja tomar? x = ?\n");
                    comandoC = scanC.nextInt();
                    if(comandoC == 1){
                        //Cadastrar cliente pf ou pj
                    }
                    else if(comandoC == 2){
                        //Cadastrar veiculo
                    }
                    else if(comandoC == 3){
                        //Cadastrar seguradora
                    }
                }
                break;
            //listar (2)
            case LISTAR:
                System.out.println("2.1 - Listar Cliente (PF/PJ) por Seguradora\n2.2 - Listar Sinistros por Seguradora\n2.3 - Listar Sinistro por Cliente\n2.4 - Listar Veiculo por Cliente\n2.5 - Listar Veiculo por Seguradora\n2.6 - Voltar\n");
                break;
            //excluir (3)
            case EXCLUIR:
                System.out.println("3.1 - Excluir Cliente\n3.2 - Excluir Veiculo\n3.3 - Excluir Sinistro\n3.4 - Voltar");
                break;
            //gerar sinistro (4)
            case GERAR_SINISTRO:
                Scanner scan = new Scanner(System.in);
                //Recebendo o veiculo do sinistro
                System.out.println("Qual a placa do veiculo envolvido no sinistro?\n");
                String vSin = scan.next();
                //Recebendo o cliente do sinistro 
                System.out.println("Quem é o dono do veiculo?\n");
                String cSin = scan.next();
                //Recebendo o endereco do sinistro
                System.out.println("Onde ocorreu o sinistro?\n");
                String endSin = scan.next();
                //Procurando objeto cliente que correponde cSin
                for(Cliente c : seg.getListaClientes()){
                    if(c.getNome() == cSin){
                        //Procurando o objeto veiculo que corresponde vSin, o qual cSin é dono
                        for(Veiculo v : c.getListaVeiculos()){
                            if(v.getPlaca() == vSin){
                                //gerar sinistro com esse cliente e esse veiculo
                                seg.gerarSinistro(v, c, endSin);
                            }
                        }
                    }
                }
                scan.close();
                
            //transferir seguro (5)
            case TRANSFERIR_SEGURO:
                //recebendo o que vai transferir
                Scanner scan1 = new Scanner(System.in);
                System.out.println("Digite o cliente que irá transferir:\n");
                String cliente_transf = scan1.next();
                //recebendo o que vai receber
                System.out.println("Digite o cliente que irá receber:\n");
                String cliente_recebe = scan1.next();
                //fechando scanner
                scan1.close();
                //Procurando o cliente_transf
                Cliente ct;
                for(Cliente c : seg.getListaClientes()){
                    if(c.getNome() == cliente_transf){
                        ct = c;
                    }
                }
                //Procurando o cliente que vai receber
                for(Cliente c : seg.getListaClientes()){
                    if(c.getNome() == cliente_recebe){
                        //Transferindo os veiculos para ele
                        for(Veiculo v : ct.getListaVeiculos()){
                            c.getListaVeiculos().add(v);
                            //Esvaziando a lista do cliente_transf
                            ct.getListaVeiculos().remove(v);
                        }
                    }
                }
                break;
            
            //calcular receita seguradora (6)
            case CALCULAR_RECEITA_SEGURADORA:
                System.out.println("Receita: " + seg.calcularReceita() + "\n");
                break;
            //sair (0)
            case SAIR:
                System.exit(0);
        }
    }

    public static void appMain(String args[]){
        //Instanciando dois veiculos
        Veiculo v1 = new Veiculo("PLACA1", "Honda", "Civic", 2022);
        Veiculo v2 = new Veiculo("PLACA2", "BMW", "X1", 2021);
        
        //Instanciando um ClientePF
        LocalDate dl_pf = LocalDate.of(2020, 10, 20);
        LocalDate dn_pf = LocalDate.of(2002, 01, 10);
        ArrayList<Veiculo> v_pf = new ArrayList<Veiculo>();
        ClientePF cli_pf = new ClientePF("Joao", "Rua Teste 123", dl_pf, "EM completo", "Masculino", 
                                            "Classe média", v_pf, "615.890.473-20", dn_pf);
        //Checando cpf e nome
        Validacao.validarNome(cli_pf.getNome());
        Validacao.validarCPF(cli_pf.getCpf());
        
        //Instanciando um ClientePJ
        ArrayList<Veiculo> v_pj = new ArrayList<Veiculo>();
        LocalDate df_pj = LocalDate.of(2020, 07, 28);
        ClientePJ cli_pj = new ClientePJ("Company", "Rua Marte 321", v_pj, "83.088.557/0001-53", df_pj, 3);
        //Checando cnpj e nome
        Validacao.validarNome(cli_pj.getNome());
        Validacao.validarCNPJ(cli_pj.getCnpj());

        //Instanciando um objeto da classe Seguradora
        ArrayList<Sinistro> seg_ls = new ArrayList<Sinistro>();
        ArrayList<Cliente> seg_lc = new ArrayList<Cliente>();
        Seguradora seg = new Seguradora("Seguro", "11996672772", "seguro@gmail.com", "Rua Seguradora 55", 
                                            seg_ls, seg_lc);

        //Adicionando um veiculo para cada cliente
        if(cli_pf.addVeiculo(v1)){ //Add v1 ao clientePF
            System.out.println("Ok!\n");
        }
        if(cli_pj.addVeiculo(v2)){ //Add v2 ao clientePJ
            System.out.println("Ok!\n");
        }

        //Cadastrando os dois clientes na seguradora
        seg.cadastrarCliente(cli_pf);
        seg.cadastrarCliente(cli_pj);

        //Instanciando dois sinistros
        LocalDate data_s1 = LocalDate.of(2023, 05, 10);
        Sinistro s1 = new Sinistro(data_s1, "Rua Sinistro 111", seg, v1, cli_pf); //criando sinistro 1
        seg.getListaSinistros().add(s1);

        LocalDate data_s2 = LocalDate.of(2023, 03, 20);
        Sinistro s2 = new Sinistro(data_s2, "Rua Nistro 344", seg, v2, cli_pj); //criando sinistro 2
        seg.getListaSinistros().add(s2);

        //Chamando os métodos desejados da classe seguradora
        seg.listarClientes("ClientePF");
        seg.vizualizarSinistro(cli_pj.getNome());
        seg.listarSinistros();
        double receita_seg = seg.calcularReceita();
        System.out.println("Receita" + receita_seg + "\n");

        //Calculando o valor de seguro de cada cliente
        double valorSeg_pf = seg.calcularPrecoSeguroCliente(cli_pf);
        double valorSeg_pj = seg.calcularPrecoSeguroCliente(cli_pj);

        //Printando a receita da seguradora
        System.out.println(receita_seg);

        //FUNCAO DE MENU DE OPERACOES//
        System.out.println("1 - Cadastros\n2 - Listar\n3 - Excluir\n4 - Gerar Sinistro\n5 - Transferir Seguro\n6 - Calcular Receita Seguradora\n0 - Sair\n");
        int comando;
        Scanner entrada = new Scanner(System.in);
        //leio o comando
        comando = entrada.nextInt();
        while(true){
            //está no menu principal
            if(comando == -1){
                System.out.println("1 - Cadastros\n2 - Listar\n3 - Excluir\n4 - Gerar Sinistro\n5 - Transferir Seguro\n6 - Calcular Receita Seguradora\n0 - Sair\n");
                //acao que o usuario quer tomar
                comando = entrada.nextInt();
            }
            //Procuro no MenuOperacoes a operacao que corresponde o valor do comando
            MenuOperacoes operacao = MenuOperacoes.getOperacao(comando);
            qualOperacaoPrincipal(operacao, seg);
        }
    }
}

