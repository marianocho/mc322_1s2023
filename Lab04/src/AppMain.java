import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AppMain {
    //funcao de checar caso
    public static void qualOperacaoPrincipal(MenuOperacoes operacao, ArrayList<Seguradora> listaSeg, int ind){
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
                        System.out.println("Cadastrar ClientePF ou ClientePJ? PF/PJ");
                        Scanner info = new Scanner(System.in);
                        if(scanC.next().equals("PF")){
                            //Instanciando clientePF
                            ClientePF cliPF = new ClientePF(null, null, null, null, null, null, null, null, null);
                            //Obtendo nome do cliente
                            System.out.println("Nome: \n");
                            cliPF.setNome(info.next());
                            //Validando nome
                            if(!Validacao.validarNome(cliPF.getNome())){
                                while(!Validacao.validarNome(cliPF.getNome())){
                                   System.out.println("Nome invalido!\n");
                                   cliPF.setNome(info.next()); 
                                }
                            }
                            //Obtendo endereco
                            System.out.println("Endereco: (digite _ ao inves de barra de espaco)\n");
                            cliPF.setEndereco(info.next());
                            //Definindo lista veiculos como vazia
                            cliPF.setListaVeiculos(new ArrayList<Veiculo>());
                            //Obtendo CPF
                            System.out.println("CPF:\n");
                            cliPF.setCpf(info.next());
                            //Validando CPF
                            if(!Validacao.validarCPF(cliPF.getCpf())){
                                System.out.println("CPF invalido!\n");
                            }
                            while(!Validacao.validarCPF(cliPF.getCpf())){
                                cliPF.setCpf(info.next());
                            }
                            //Obtendo dataNascimento
                            System.out.println("Data de nascimento? yyyy-mm-dd\n");
                            cliPF.setDataNascimento(LocalDate.parse(info.next()));
                            //Obtendo dataLicenca
                            System.out.println("Data da licenca? yyyy-mm-dd\n");
                            cliPF.setDataLicenca(LocalDate.parse(info.next()));
                            //Obtendo educacao
                            System.out.println("Nivel de educacao? (digite '_' ao inves de barra de espaco)\n");
                            cliPF.setEducacao(info.next());
                            //Obtendo genero
                            System.out.println("Genero?\n");
                            cliPF.setGenero(info.next());
                            //Obtendo classe economica
                            System.out.println("Classe economica? (digite '_' ao inves de barra de espaco)\n");
                            cliPF.setClasseEconomica(info.next());
                            //Cadastrando
                            listaSeg.get(ind).cadastrarCliente(cliPF);
                        }
                        else{
                            //Instanciando um clientePJ
                            ClientePJ cliPJ = new ClientePJ(null, null, null, null, null, -1);
                            //Obtendo nome
                            System.out.println("Nome?\n");
                            cliPJ.setNome(info.next());
                            //Validando nome
                            if(!Validacao.validarNome(cliPJ.getNome())){
                                while(!Validacao.validarNome(cliPJ.getNome())){
                                   System.out.println("Nome invalido!\n");
                                   cliPJ.setNome(info.next());
                                }
                            }
                            //Obtendo endereco
                            System.out.println("Endereco?\n");
                            cliPJ.setEndereco(info.next());
                            //Definindo listaVeiculos
                            cliPJ.setListaVeiculos(new ArrayList<Veiculo>());
                            //Obtendo cnpj
                            System.out.println("CNPJ?\n");
                            cliPJ.setCnpj(info.next());
                            //Validando cnpj
                            if(!Validacao.validarCNPJ(cliPJ.getCnpj())){
                                while(!Validacao.validarCNPJ(cliPJ.getCnpj())){
                                    System.out.println("CNPJ invalido!\n");
                                    cliPJ.setCnpj(info.next());
                                }
                            }
                            //Obtendo data fundacao
                            System.out.println("Data de fundacao:?\n");
                            cliPJ.setDataFundacao(LocalDate.parse(info.next()));
                            //Obtendo qtd funcionarios
                            System.out.println("Quantide de funcionarios?\n");
                            cliPJ.setQtdeFuncionarios(info.nextInt());
                            //Cadastrando
                            listaSeg.get(ind).cadastrarCliente(cliPJ);    
                        }
                    }
                    else if(comandoC == 2){
                        //Instanciando um objeto veiculo
                        Veiculo v = new Veiculo(null, null, null, -1);
                        Scanner info = new Scanner(System.in);
                        //Perguntar qual é o cliente
                        System.out.println("Qual o dono do veículo a ser adicionado?\n");
                        String dono = info.next();
                        //Perguntar qual a placa do veiculo
                        System.out.println("Qual a placa do veiculo?\n");
                        v.setPlaca(info.next());
                        //Perguntar qual a marca
                        System.out.println("Qual a marca?\n");
                        v.setMarca(info.next());
                        //Perguntar qual o modelo
                        System.out.println("Qual o modelo?\n");
                        v.setModelo(info.next());
                        //Perguntar qual o ano
                        System.out.println("Qual o ano de fabricacao?\n");
                        v.setAnoFabricacao(info.nextInt());
                        //Procurando o dono do carro na seguradora
                        for(Cliente c : listaSeg.get(ind).getListaClientes()){
                            if(c.getNome().equals(dono)){
                                //Adicionando veiculo
                                c.addVeiculo(v);
                            }
                        }
                    }
                    else if(comandoC == 3){
                        Scanner info = new Scanner(System.in);
                        //Cadastrar seguradora
                        Seguradora segNova = new Seguradora(null, null, null, null, null, null);
                        //Obter nome
                        System.out.println("Qual o nome da seguradora?\n");
                        segNova.setNome(info.next());
                        //Obter telefone
                        System.out.println("Qual o numero?\n");
                        segNova.setTelefone(info.next());
                        //Obter email
                        System.out.println("Qual o email?\n");
                        segNova.setEmail(info.next());
                        //Obter endereco
                        System.out.println("Qual o endereco da seguradora? (digite '_' ao inves de barra de espaco)\n");
                        segNova.setEndereco(info.next());
                        //Definindo listaSinistros e listaClientes
                        segNova.setListaSinistros(new ArrayList<Sinistro>());
                        segNova.setListaClientes(new ArrayList<Cliente>());
                        //Adicionando na lista
                        listaSeg.add(segNova);
                    }
                    if(comandoC!=4){
                        System.out.println("1.1 - Cadastrar Cliente\n1.2 - Cadastrar Veiculo\n1.3 - Cadastrar Seguradora\n1.4 - Voltar\n");
                    }
                }
                break;
            //listar (2)
            case LISTAR:
                System.out.println("2.1 - Listar Cliente (PF/PJ) por Seguradora\n2.2 - Listar Sinistros por Seguradora\n2.3 - Listar Sinistro por Cliente\n2.4 - Listar Veiculo por Cliente\n2.5 - Listar Veiculo por Seguradora\n2.6 - Voltar\n");
                int comandoL = 0;
                Scanner scanL = new Scanner(System.in);
                //Enquanto nao voltar
                while(comandoL != 6){
                    //pergunta qual opcao o usuario quer
                    System.out.println("Qual acao 2.x voce deseja tomar? x = ?\n");
                    comandoL = scanL.nextInt();
                    if(comandoL == 1){
                        //Listar cliente por Seg.
                        for(Seguradora s : listaSeg){
                            System.out.println("Seguradora: " + s.getNome() + "\n");
                            System.out.println("ClientesPFs:\n");
                            s.listarClientes("ClientePF");
                            System.out.println("ClientesPJs:\n");
                            s.listarClientes("ClientePJ");
                        }
                    }
                    else if(comandoL == 2){
                        //Listar sinistros por Seg.
                        for(Seguradora s : listaSeg){
                            System.out.println("Seguradora: " + s.getNome() + "\n");
                            s.listarSinistros();
                        }
                    }
                    else if(comandoL == 3){
                        //Listar sinistro por cliente de uma seguradora
                        for(Cliente c : listaSeg.get(ind).getListaClientes()){
                            listaSeg.get(ind).vizualizarSinistro(c.getNome());
                        }
                    }
                    else if(comandoL == 4){
                        //Listar veiculo por cliente de uma seguradora
                        for(Cliente c : listaSeg.get(ind).getListaClientes()){ //Para cada cliente da seguradora
                            System.out.println(c.getNome()+"\n");
                            c.listarVeiculos();
                        }
                    }
                    else if(comandoL == 5){
                        //Listar veiculo por seguradora
                        for(Seguradora s : listaSeg){ //Para cada seguradora
                            //Listar veiculos da seguradora s
                            System.out.println(s.getNome()+"\n");
                            for(Cliente c : s.getListaClientes()){
                                c.listarVeiculos();
                            }
                        }
                    }
                    if(comandoL!=6){
                        System.out.println("2.1 - Listar Cliente (PF/PJ) por Seguradora\n2.2 - Listar Sinistros por Seguradora\n2.3 - Listar Sinistro por Cliente\n2.4 - Listar Veiculo por Cliente\n2.5 - Listar Veiculo por Seguradora\n2.6 - Voltar\n");
                    }
                }
                break;
            //excluir (3)
            case EXCLUIR:
                System.out.println("3.1 - Excluir Cliente\n3.2 - Excluir Veiculo\n3.3 - Excluir Sinistro\n3.4 - Voltar");
                int comandoE = 0;
                Scanner scanE = new Scanner(System.in);
                while(comandoE != 4){
                    Scanner info = new Scanner(System.in);
                    //pergunta qual opcao o usuario quer
                    System.out.println("Qual acao 3.x voce deseja tomar? x = ?\n");
                    comandoE = scanE.nextInt();
                    if(comandoE == 1){
                        int removido = 0;
                        //Pegar o nome do cliente desejado
                        System.out.println("Nome do cliente a ser removido\n");
                        String cliDesejado = info.next();
                        //Excluir cliente
                        for(Seguradora s : listaSeg){ //Para cada seguradora
                            for(Cliente c : s.getListaClientes()){//Ver os clientes dela
                                if(c.getNome().equals(cliDesejado)){ //Achamos o cliente que queremos remover
                                    s.removerCliente(cliDesejado);
                                    removido = 1;
                                    break;
                                }        
                            }
                            if(removido == 1){
                                break;
                            }
                        }
                    }
                    else if(comandoE == 2){
                        System.out.println("Qual a placa do veiculo a ser removido?\n");
                        String vDesejado = info.next();
                        //Excluir veiculo
                        int removido = 0;
                        for(Seguradora s : listaSeg){ //Para cada seguradora
                            for(Cliente c : s.getListaClientes()){ //Para cada cliente
                                for(Veiculo v : c.getListaVeiculos()){ //Para cada veiculo desse cliente
                                    if(v.getPlaca().equals(vDesejado)){ //Achamos o veiculo a ser removido
                                        c.removeVeiculo(v);
                                        removido = 1;
                                        break;
                                    }
                                }
                                if(removido == 1){
                                    break;
                                }
                            }
                            if(removido == 1){
                                break;
                            }
                        }
                    }
                    else if(comandoE == 3){
                        //Excluir sinistro
                        System.out.println("ID do sinistro a ser removido\n");
                        int IDrmv = info.nextInt();
                        for(Seguradora seg : listaSeg){ //Para cada seguradora
                            for(Sinistro sin : seg.getListaSinistros()){ //Para cada sinistro dessa seguradora
                                if(sin.getId() == IDrmv){ //Achamos o id do sinistro a ser removido
                                    seg.getListaSinistros().remove(sin);
                                    System.out.println("Sinistro removido!\n");
                                }
                            }
                        }
                    }
                    if(comandoE!=4){
                        System.out.println("3.1 - Excluir Cliente\n3.2 - Excluir Veiculo\n3.3 - Excluir Sinistro\n3.4 - Voltar");
                    }
                }
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
                int gerado = 0;
                for(Cliente c : listaSeg.get(ind).getListaClientes()){
                    if(c.getNome().equals(cSin)){
                        //Procurando o objeto veiculo que corresponde vSin, o qual cSin é dono
                        for(Veiculo v : c.getListaVeiculos()){
                            if(v.getPlaca().equals(vSin)){
                                //gerar sinistro com esse cliente e esse veiculo
                                listaSeg.get(ind).gerarSinistro(v, c, endSin);
                                gerado = 1;
                                break;
                            }
                        }
                        if(gerado == 1){
                            break;
                        }
                    }
                }
            break;
                
            //transferir seguro (5)
            case TRANSFERIR_SEGURO:
                //recebendo o que vai transferir
                Scanner scan1 = new Scanner(System.in);
                System.out.println("Digite o cliente que irá transferir:\n");
                String cliente_transf = scan1.next();
                int existe = 0;
                //Vendo se ele existe
                for(Seguradora s : listaSeg){ //Para cada seguradora
                    for(Cliente c : s.getListaClientes()){ //Para cada cliente da seguradora
                        if(c.getNome().equals(cliente_transf)){ //Se existe o cliente
                            existe = 1;
                        }
                    }
                }
                if(existe == 0){ //Se nao existe
                    System.out.println("Nao existe!\n");
                    break;
                }
                //recebendo o que vai receber
                existe = 0;
                System.out.println("Digite o cliente que irá receber:\n");
                String cliente_recebe = scan1.next();
                //Vendo se ele existe
                for(Seguradora s : listaSeg){ //Para cada seguradora
                    for(Cliente c : s.getListaClientes()){ //Para cada cliente da seguradora
                        if(c.getNome().equals(cliente_recebe)){ //Se existe o cliente
                            existe = 1;
                        }
                    }
                }
                if(existe == 0){ //Se nao existe
                    System.out.println("Nao existe!\n");
                    break;
                }
                //Procurando o cliente_transf
                Cliente ct = null;
                for(Cliente c : listaSeg.get(ind).getListaClientes()){
                    if(c.getNome().equals(cliente_transf)){
                        ct = c;
                    }
                }
                //Procurando o cliente que vai receber
                for(Cliente c : listaSeg.get(ind).getListaClientes()){
                    if(c.getNome().equals(cliente_recebe)){
                        //Transferindo os veiculos para ele
                        for(Veiculo v : ct.getListaVeiculos()){
                            c.getListaVeiculos().add(v);
                        }
                        //Esvaziando a lista do cliente_transf
                        ct.setListaVeiculos(new ArrayList<Veiculo>());
                        break;
                    }
                }
                break;
            
            //calcular receita seguradora (6)
            case CALCULAR_RECEITA_SEGURADORA:
                System.out.println("Receita: " + listaSeg.get(ind).calcularReceita() + "\n");
                break;
            //sair (0)
            case SAIR:
                System.exit(0);
        }
    }

    public static void main(String args[]){
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

        //Criar uma lista de seguradoras
        ArrayList<Seguradora> listaSeg = new ArrayList<Seguradora>();
        //Instanciando um objeto da classe Seguradora
        ArrayList<Sinistro> seg_ls = new ArrayList<Sinistro>();
        ArrayList<Cliente> seg_lc = new ArrayList<Cliente>();
        Seguradora seg = new Seguradora("Seguro", "11996672772", "seguro@gmail.com", "Rua Seguradora 55", 
                                            seg_ls, seg_lc);
        listaSeg.add(seg);

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
        System.out.println(seg);
        double receita_seg = seg.calcularReceita();
        
        //Calculando o valor de seguro de cada cliente
        double valorSeg_pf = seg.calcularPrecoSeguroCliente(cli_pf);
        double valorSeg_pj = seg.calcularPrecoSeguroCliente(cli_pj);
        
        //Printando a receita da seguradora
        System.out.println("Receita " + receita_seg + "\n");

        //-----------FUNCAO DE MENU DE OPERACOES------------------
        System.out.println("1 - Cadastros\n2 - Listar\n3 - Excluir\n4 - Gerar Sinistro\n5 - Transferir Seguro\n6 - Calcular Receita Seguradora\n0 - Sair\n");
        int comando = 0;
        Scanner entrada = new Scanner(System.in);
        //leio o comando
        comando = entrada.nextInt();
        while(true){
            System.out.println("Qual o nome da seguradora que voce deseja operar?\n");
            //Mostrando os seguros disponiveis
            for(Seguradora s : listaSeg){
                System.out.println("-" + s.getNome()+"\n");
            }
            Scanner seguro = new Scanner(System.in);
            int ind = 0;
            int achou = -1;
            while(achou == -1){
                //recebendo o seguro desejado
                String nomeSegDesejada = seguro.next();
                //Procurando o indice do seguro desejado
                for(Seguradora s : listaSeg){
                    if(s.getNome().equals(nomeSegDesejada)){
                        achou = 1;
                        break;
                    }
                    ind++;
                }
                if(achou != 1){
                    System.out.println("Nao existe tal seguradora!\n");
                }
            }
            //está no menu principal
            if(comando == -1){
                System.out.println("1 - Cadastros\n2 - Listar\n3 - Excluir\n4 - Gerar Sinistro\n5 - Transferir Seguro\n6 - Calcular Receita Seguradora\n0 - Sair\n");
                //acao que o usuario quer tomar
                comando = entrada.nextInt();
            }
            //Procuro no MenuOperacoes a operacao que corresponde o valor do comando
            MenuOperacoes operacao = MenuOperacoes.getOperacao(comando);
            qualOperacaoPrincipal(operacao, listaSeg, ind);
            comando = -1;
        }
    }
}

