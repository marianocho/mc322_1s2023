import java.util.*;
import java.time.LocalDate;

public class AppMain {
    //Gerador de veiculo
    public static Veiculo gerarVeiculo(){
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

        return v;
    }
    public static Cliente gerarCliente(){
        //Cadastrar cliente pf ou pj
        System.out.println("Cadastrar ClientePF ou ClientePJ? PF/PJ");
        Scanner info = new Scanner(System.in);
        if(info.next().equals("PF")){
            System.out.println("Qual o cpf?\n");
            //Obtendo cpf
            String cpfCadastrado = info.next();
            //Validando cpf
            while(!Validacao.validarCPF(cpfCadastrado)){
                System.out.println("CPF invalido!Digite novamente");
                cpfCadastrado = info.next();
            }
            //Instanciando clientePF
            ClientePF cliPF = new ClientePF(null, null, null, null, cpfCadastrado, null, null, null);
            //Obtendo nome do cliente
            System.out.println("Nome: (digite '_' ao inves de barra de espaco)\n");
            cliPF.setNome(info.next());
            //Validando nome
            if(!Validacao.validarNome(cliPF.getNome())){
                while(!Validacao.validarNome(cliPF.getNome())){
                System.out.println("Nome invalido!\n");
                cliPF.setNome(info.next()); 
                }
            }
            //Obtendo endereco
            System.out.println("Endereco: (digite '_' ao inves de barra de espaco)\n");
            cliPF.setEndereco(info.next());
            //Obtendo dataNascimento
            System.out.println("Data de nascimento? yyyy-mm-dd\n");
            cliPF.setDataNascimento(LocalDate.parse(info.next()));
            //Obtendo educacao
            System.out.println("Nivel de educacao? (digite '_' ao inves de barra de espaco)\n");
            cliPF.setEducacao(info.next());
            //Obtendo genero
            System.out.println("Genero?\n");
            cliPF.setGenero(info.next());
            
            return cliPF;
        }
        else{
            System.out.println("Qual o cnpj?\n");
            //Obtendo cnpj
            String cnpjCadastrado = info.next();
            //Validando cnpj
            while(!Validacao.validarCNPJ(cnpjCadastrado)){
                System.out.print("Cnpj invalido! Digite novamente:");
                cnpjCadastrado = info.next();
            }
            //Instanciando um clientePJ
            ClientePJ cliPJ = new ClientePJ(null, null, null, null, cnpjCadastrado, null, -1);
            //Obtendo nome
            System.out.println("Nome? (digite '_' ao inves de barra de espaco)\n");
            cliPJ.setNome(info.next());
            //Validando nome
            if(!Validacao.validarNome(cliPJ.getNome())){
                while(!Validacao.validarNome(cliPJ.getNome())){
                System.out.println("Nome invalido!\n");
                }
            }
            //Obtendo endereco
            System.out.println("Endereco? (digite '_' ao inves de barra de espaco)\n");
            cliPJ.setEndereco(info.next());
            //Obtendo telefone
            //Obtendo email
            //Obtendo data fundacao
            System.out.println("Data de fundacao:? yyyy-mm-dd\n");
            cliPJ.setDataFundacao(LocalDate.parse(info.next()));
            //Obtendo qtd funcionarios
            System.out.println("Quantide de funcionarios?\n");
            cliPJ.setQtdeFuncionarios(info.nextInt());
            
            return cliPJ;
        }
    }
    public static Condutor gerarCondutor(){
        Scanner info = new Scanner(System.in);
        System.out.println("Qual o cpf?\n");
        //Obtendo cpf
        String cpfCadastrado = info.next();
        //Validando cpf
        while(!Validacao.validarCPF(cpfCadastrado)){
            System.out.println("CPF invalido!Digite novamente");
            cpfCadastrado = info.next();
        }
        
        Condutor condutor = new Condutor(cpfCadastrado, null, null, null, null, null, new ArrayList<Sinistro>());
        //NOME
        System.out.println("Qual o nome? Digite '_' ao inves de barra de espaco\n");
        condutor.setNome(info.next());
        //TELEFONE
        System.out.println("Qual o numero de telefone?\n");
        condutor.setTelefone(info.next());
        //ENDERECO
        System.out.println("Qual o endereco do condutor? Digite '_' ao inves de barra de espaco\n");
        condutor.setEndereco(info.next());
        //EMAIL
        System.out.println("Qual o email?\n");
        condutor.setEmail(info.next());
        //DATA DE NASCIMENTO
        System.out.println("Qual a data de nascimento?yyyy-mm-dd\n");
        LocalDate data = LocalDate.parse(info.next());
        condutor.setDataNasc(data);
        return condutor;
    }
    
    //funcao de checar caso
    public static void qualOperacaoPrincipal(MenuOperacoes operacao, ArrayList<Seguradora> listaSeg, int ind){
        Seguradora seguradora = listaSeg.get(ind);
        switch(operacao){
            //cadastrar (1)
            case CADASTRAR:
                int comandoC = 0;
                Scanner scanC = new Scanner(System.in);
                //Mostra as opcoes
                System.out.println("1.1 - Cadastrar Cliente\n1.2 - Cadastrar Veiculo\n1.3 - Cadastrar Seguradora\n1.4 - Cadastrar Frota\n1.5 - Cadastrar condutor\n1.6 - Voltar");
                //Enquanto nao voltar
                while(comandoC != 6){
                    //pergunta qual opcao o usuario quer
                    System.out.println("Qual acao 1.x voce deseja tomar? x = ?\n");
                    comandoC = scanC.nextInt();
                    if(comandoC == 1){
                        Cliente cliente = gerarCliente();
                        //Cadastrando
                        listaSeg.get(ind).cadastrarCliente(cliente);
                    }
                    else if(comandoC == 2){
                        //Veiculo a ser cadastrado
                        Veiculo v = gerarVeiculo();
                        System.out.println("Voce deseja cadastrar o veiculo para um cliente existente ou para uma frota existente? C/F\n");
                        Scanner info = new Scanner(System.in);
                        if(info.next().equals("C")){
                            Cliente cliente = listaSeg.get(ind).escolheCliente();
                            ClientePF cliPF = (ClientePF) cliente; //Downcasting
                            cliPF.addVeiculo(v);
                        }
                        else{
                            System.out.println("De qual cliente é a frota?\n");
                            Cliente cliente = listaSeg.get(ind).escolheCliente();
                            while(cliente instanceof ClientePF){
                                System.out.println("Este cliente nao possui frotas\n");
                                cliente = listaSeg.get(ind).escolheCliente();
                            }
                            ClientePJ cliPJ = (ClientePJ) cliente; //Downcasting
                            String codeDesejado = cliPJ.escolheFrota(cliPJ);
                            cliPJ.atualizarFrota("A", v, codeDesejado);
                        }
                    }
                    else if(comandoC == 3){
                        Scanner info = new Scanner(System.in);
                        //Obtendo cnpj
                        System.out.println("Qual o cnpj da seguradora?\n");
                        String cnpjCadastrar = info.next();
                        //Validando cnpj
                        while(!Validacao.validarCNPJ(cnpjCadastrar)){
                            System.out.println("Cnpj invalido! Digite novamente:");
                            cnpjCadastrar = info.next();
                        }
                        //Cadastrar seguradora
                        Seguradora seguradoraNova = new Seguradora(cnpjCadastrar, null, null, null, null);
                        //Obter nome
                        System.out.println("Qual o nome da seguradora?\n");
                        seguradoraNova.setNome(info.next());
                        //Obter telefone
                        System.out.println("Qual o numero?\n");
                        seguradoraNova.setTelefone(info.next());
                        //Obter email
                        System.out.println("Qual o email?\n");
                        seguradoraNova.setEmail(info.next());
                        //Obter endereco
                        System.out.println("Qual o endereco da seguradora? (digite '_' ao inves de barra de espaco)\n");
                        seguradoraNova.setEndereco(info.next());
                        //Adicionando na lista
                        listaSeg.add(seguradoraNova);
                    }
                    else if(comandoC == 4){
                        Scanner info = new Scanner(System.in);
                        Frota frota = new Frota(); //Gerar frota
                        System.out.println("Para qual cliente voce quer cadastrar a frota?\n");
                        Cliente cliente = listaSeg.get(ind).escolheCliente();
                        //Se o cliente escolhido nao for PJ
                        while(cliente instanceof ClientePF){
                            System.out.println("Esse tipo de cliente nao possui frota!\n");
                            cliente = listaSeg.get(ind).escolheCliente();
                        }
                        ClientePJ cliPJ = (ClientePJ) cliente; //Downcasting
                        cliPJ.getListaFrota().add(frota); //adicionando frota no cliente
                    }
                    else if(comandoC == 5){
                        Scanner info = new Scanner(System.in);
                        System.out.println("Qual o cpf?\n");
                        //Obtendo cpf
                        String cpfCadastrado = info.next();
                        //Validando cpf
                        while(!Validacao.validarCPF(cpfCadastrado)){
                            System.out.println("CPF invalido!Digite novamente");
                            cpfCadastrado = info.next();
                        }
                        Condutor condutor = new Condutor(cpfCadastrado, null, null, null, null, null, new ArrayList<Sinistro>());
                        //Obtendo o nome
                        System.out.println("Nome: (digite '_' ao inves de barra de espaco)\n");
                        condutor.setNome(info.next());
                        //Validando nome
                        if(!Validacao.validarNome(condutor.getNome())){
                            while(!Validacao.validarNome(condutor.getNome())){
                                System.out.println("Nome invalido!\n");
                                condutor.setNome(info.next()); 
                            }
                        }
                        //Obtendo o telefone
                        System.out.println("Digite o numero de telefeone\n");
                        condutor.setTelefone(info.next());
                        //Obtendo o endereco
                        System.out.println("Digite o endereco: (use '_' ao inves de barra de espaco)\n");
                        condutor.setEndereco(info.next());
                        //Obtendo o email
                        System.out.println("Digite o email:\n");
                        condutor.setEmail(info.next());
                        //Obtendo dataNascimento
                        System.out.println("Digite a data de nascimento: yyyy-mm-dd\n");
                        condutor.setDataNasc(LocalDate.parse(info.next()));

                        System.out.println("Em qual seguro deseja adicionar o condutor?\n");
                        Seguro segCond = seguradora.escolheSeguro();
                        segCond.getListaCondutores().add(condutor);
                    }
                    if(comandoC!=6){
                        System.out.println("1.1 - Cadastrar Cliente\n1.2 - Cadastrar Veiculo\n1.3 - Cadastrar Seguradora\n1.4 - Cadastrar Frota\n1.5 - Cadastrar condutor\n1.6 - Voltar");
                    }
                }
                break;
            //listar (2)
            case LISTAR:
                System.out.println("2.1 - Listar Cliente (PF/PJ) por Seguradora\n2.2 - Listar Seguros por Seguradora\n2.3 - Listar Seguros por Cliente\n2.4 - Listar Sinistros por Cliente\n2.5 - Listar Veiculo por Cliente\n2.6 - Listar Frota por Cliente\n2.7 - Listar Sinistros por Seguro\n2.8 - Listar Condutores por Seguro\n2.9 - Listar Seguradoras\n2.10 - Voltar\n");
                int comandoL = 0;
                Scanner scanL = new Scanner(System.in);
                //Enquanto nao voltar
                while(comandoL != 10){
                    //pergunta qual opcao o usuario quer
                    System.out.println("Qual acao 2.x voce deseja tomar? x = ?\n");
                    comandoL = scanL.nextInt();
                    if(comandoL == 1){
                        //Listar cliente por S
                        Seguradora s = listaSeg.get(ind);
                        System.out.println("Seguradora: " + s.getNome() + "\n");
                        System.out.println("ClientesPFs:\n");
                        s.listarClientes("ClientePF");
                        System.out.println("ClientesPJs:\n");
                        s.listarClientes("ClientePJ");
                    }
                    else if(comandoL == 2){
                        //Listar seguros por Seg.
                        Seguradora s = listaSeg.get(ind);
                        System.out.println("Seguradora: " + s.getNome() + "\n");
                        for(Seguro seguro : s.getListaSeguros()){
                            //Printando seguro
                            System.out.println(seguro + "\n");
                        }
                    }
                    else if(comandoL == 3){
                        //Listar seguros por cliente
                        Seguradora s = listaSeg.get(ind);
                        ArrayList<Seguro> listaSeguros = s.getSegurosPorCliente();
                        for(Seguro seguro : listaSeguros){
                            System.out.println(seguro+"\n");
                        }
                    }
                    else if(comandoL == 4){
                        //Listar sinistros por cliente
                        Seguradora s = listaSeg.get(ind);
                        ArrayList<Sinistro> listaSinistros = s.getSinistrosPorCliente();
                        for(Sinistro sinistro : listaSinistros){
                            System.out.println(sinistro+"\n");
                        }
                    }
                    else if(comandoL == 5){
                        //Listar veiculos por cliente
                        Seguradora s = listaSeg.get(ind);
                        Cliente cliente = s.escolheCliente();
                        //Se for clientePF
                        if(cliente instanceof ClientePF){
                            ClientePF cliPF = (ClientePF) cliente;//Downcasting
                            //Percorrer listaVeiculos do cliente
                            for(Veiculo v : cliPF.getListaVeiculos()){
                                System.out.println(v+"\n");
                            }
                        }
                        else{
                            ClientePJ cliPJ = (ClientePJ) cliente; //Downcasting
                            //Para cada frota do cliente
                            for(Frota f : cliPJ.getListaFrota()){
                                //Para listaVeiculos da frota
                                for(Veiculo v : f.getListaVeiculos()){
                                    System.out.println(v+"\n");
                                }
                            }
                        }
                    }
                    else if(comandoL == 6){
                        Seguradora s = listaSeg.get(ind);
                        //Listar frota por cliente
                        Cliente cliente = s.escolheCliente();
                        if(cliente instanceof ClientePF){
                            System.out.println("Este tipo de cliente nao possui frota!\n");
                        }
                        else{
                            ClientePJ cliPJ = (ClientePJ) cliente; //Downcasting
                            String codigoDesejado = cliPJ.escolheFrota(cliPJ);
                            for(Frota frota : cliPJ.getListaFrota()){ //Percorre lista de frotas
                                //Se for a frota desejada
                                if(frota.getCode().equals(codigoDesejado)){
                                    System.out.println(frota+"\n");
                                }
                            }
                        }
                    }
                    else if(comandoL == 7){
                        //Listar sinistros por seguro
                        Seguradora s = listaSeg.get(ind);
                        Seguro seguro = s.escolheSeguro();
                        System.out.println(seguro.getListaSinistros());
                    }
                    else if(comandoL == 8){
                        //Listar condutores por seguro
                        Seguradora s = listaSeg.get(ind);
                        Seguro seguro = s.escolheSeguro();
                        System.out.println(seguro.getListaCondutores());
                    }
                    else if(comandoL == 9){
                        System.out.println(listaSeg);
                    }
                    if(comandoL!=10){
                        System.out.println("2.1 - Listar Cliente (PF/PJ) por Seguradora\n2.2 - Listar Seguros por Seguradora\n2.3 - Listar Seguros por Cliente\n2.4 - Listar Sinistros por Cliente\n2.5 - Listar Veiculo por Cliente\n2.6 - Listar Frota por Cliente\n2.7 - Listar Sinistros por Seguro\n2.8 - Listar Condutores por Seguro\n2.9 - Listar Seguradoras\n2.10 - Voltar\n");
                    }
                }
                break;
            //excluir (3)
            case EXCLUIR:
                System.out.println("3.1 - Excluir Cliente\n3.2 - Excluir Veiculo\n3.3 - Excluir Sinistro\n3.4 - Excluir Frota\n3.5 - Excluir Seguro\n3.6 - Voltar");
                int comandoE = 0;
                Scanner scanE = new Scanner(System.in);
                while(comandoE != 6){
                    Scanner info = new Scanner(System.in);
                    //pergunta qual opcao o usuario quer
                    System.out.println("Qual acao 3.x voce deseja tomar? x = ?\n");
                    comandoE = scanE.nextInt();
                    if(comandoE == 1){
                        int removido = 0;
                        //Pegar o nome do cliente desejado
                        System.out.println("Nome do cliente a ser removido\n");
                        //Listar clientes
                        for(Cliente c : seguradora.getListaClientes()){
                            System.out.println(c.getNome()+"\n");
                        }
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
                        Seguradora s = listaSeg.get(ind);
                        Cliente clienteDesejado = s.escolheCliente();
                        Veiculo vDesejado = s.escolheVeiculo(clienteDesejado);
                        //Excluir veiculo
                        for(Cliente cliente : s.getListaClientes()){
                            if(cliente == clienteDesejado){ //É o cliente desejado
                                if(cliente instanceof ClientePF){
                                    ClientePF cliPF = (ClientePF) cliente; //Downcasting
                                    cliPF.removeVeiculo(vDesejado);
                                    break;
                                }
                                else if(cliente instanceof ClientePJ){
                                    ClientePJ cliPJ = (ClientePJ) cliente; //Downcasting
                                    Frota frota = cliPJ.getFrotaPorVeiculo(vDesejado); //Obter o codigo da frota que contem o veiculo a ser removido
                                    cliPJ.atualizarFrota("R", vDesejado, frota.getCode());
                                    break;
                                }
                            }
                        }
                    }
                    else if(comandoE == 3){
                        //Excluir sinistro
                        Scanner scan = new Scanner(System.in);
                        Seguradora s = listaSeg.get(ind);
                        int removido = 0;

                        ArrayList<Sinistro> listaSin = s.getSinistrosPorCliente();
                        for(Sinistro sinistro : listaSin){
                            System.out.println(sinistro+"\n");
                        }

                        System.out.println("Qual o id do sinistro que deseja remover?\n");
                        int idDesejado = scan.nextInt();

                        for(Seguro seguro : s.getListaSeguros()){ //Para cada seguro da seguradora
                            for(Sinistro sinistro : seguro.getListaSinistros()){ //Para cada sinistro do seguro
                                if(sinistro.getId() == idDesejado){
                                    seguro.getListaSinistros().remove(sinistro);
                                    removido = 1;
                                    break;
                                }
                            }
                            if(removido == 1){
                                break;
                            }
                        }
                    }
                    else if(comandoE == 4){
                        //Excluir frota
                        Seguradora s = listaSeg.get(ind);
                        Cliente cliente = s.escolheCliente();
                        if(cliente instanceof ClientePJ){
                            ClientePJ cliPJ = (ClientePJ) cliente;
                            String codigo = cliPJ.escolheFrota(cliPJ); //Escolhendo frota
                            cliPJ.atualizarFrota("RF", null, codigo);
                        }
                        else{
                            System.out.println("Este tipo de cliente nao possui frota!\n");
                        }
                    }
                    else if(comandoE == 5){
                        //Excluir seguro
                        Seguradora s = listaSeg.get(ind);
                        Seguro seguro = s.escolheSeguro();
                        s.getListaSeguros().remove(seguro);
                    }
                    if(comandoE!=6){
                        System.out.println("3.1 - Excluir Cliente\n3.2 - Excluir Veiculo\n3.3 - Excluir Sinistro\n3.4 - Exclui Frota\n3.5 - Excluir Seguro\n3.6 - Voltar");
                    }
                }
                break;
            //gerar sinistro (4)
            case GERAR_SINISTRO:
                Scanner scan = new Scanner(System.in);
                Seguradora s = listaSeg.get(ind);
                Seguro seguro = s.escolheSeguro();
                //DATA
                System.out.println("Qual a data do sinistro?yyyy-mm-dd\n");
                LocalDate data = LocalDate.parse(scan.next());
                //ENDERECO
                System.out.println("Qual o endereco do sinistro? obs: digite '_' ao inves de barra de espaco\n");
                String endereco = scan.next();
                //CONDUTOR
                Condutor condutor = gerarCondutor();
                //GERANDO SINISTRO
                seguro.gerarSinistro(data, endereco, condutor);
                break;
                
            //transferir seguro (5)
            case TRANSFERIR_SEGURO:
                System.out.println("Escolha o cliente que ira transferir\n");
                Cliente clienteTransf = seguradora.escolheCliente();
                System.out.println("Escolha o cliente que ira receber\n");
                Cliente clienteRecebe = seguradora.escolheCliente();
                if(clienteRecebe == clienteTransf){
                    System.out.println("Os clientes sao os mesmos!\n");
                    break;
                }

                Seguro seguroTransf = seguradora.escolheSeguro();
                //CLIENTEPF --SEGURO--> CLIENTEPF2
                if(seguroTransf instanceof SeguroPF && clienteTransf instanceof ClientePF){
                    SeguroPF segTPF = (SeguroPF) seguroTransf; //Downcasting
                    ClientePF cliPF = (ClientePF) clienteTransf; //Downcasting do cliente que vai transferir
                    //Vendo se o cliente do seguro é o mesmo que vai transferir
                    if(segTPF.getCliente() != cliPF){
                        System.out.println("O seguro nao pertence ao cliente!\n");
                        break;
                    }
                    //Transferir
                    if(clienteRecebe instanceof ClientePF){
                        ClientePF cliRPF = (ClientePF) clienteRecebe;//Downcasting
                        segTPF.setClientePF(cliRPF);
                    }
                    else{
                        System.out.println("O tipo do cliente que vai receber o seguro nao eh o mesmo do que ira transferir!\n");
                    }
                }
                //CLIENTEPJ --SEGURO--> CLIENTEPJ2
                else if(seguroTransf instanceof SeguroPJ && clienteTransf instanceof ClientePJ){
                    SeguroPJ segTPJ = (SeguroPJ) seguroTransf; //Downcasting
                    ClientePJ cliPJ = (ClientePJ) clienteTransf; //Downcasting do cliente que vai transferir
                    //Vendo se o cliente do seguro é o mesmo que vai transferir
                    if(segTPJ.getCliente() != cliPJ){
                        System.out.println("O seguro nao pertence ao cliente!\n");
                        break;
                    }
                    //Transferir
                    if(clienteRecebe instanceof ClientePJ){
                        ClientePJ cliRPJ = (ClientePJ) clienteRecebe;//Downcasting
                        segTPJ.setCliente(cliRPJ);
                    }
                    else{
                        System.out.println("O tipo do cliente que vai receber o seguro nao eh o mesmo do que ira transferir!\n");
                    }
                }
                break;
            //calcular receita seguradora (6)
            case CALCULAR_RECEITA_SEGURADORA:
                System.out.println("Receita: " + listaSeg.get(ind).calcularReceita() + "\n");
                break;
            //sair (0)
            case AUTORIZACAO_CONDUTOR:
                System.out.println("Escolha o seguro, cujo condutor principal vai ser autorizado ou desautorizado\n");
                Seguro seg = seguradora.escolheSeguro(); //s é seguradora
                System.out.println("Voce deseja autorizar ou desautorizar o condutor? A/D\n");
                Scanner info = new Scanner(System.in);
                String resposta = info.next();
                if(seg instanceof SeguroPF){
                    SeguroPF segPF = (SeguroPF) seg; //Downcasting
                    if(resposta.equals("A")){
                        segPF.autorizarCondutor();
                    }
                    else{
                        segPF.desautorizarCondutor();
                    }
                }
                else{
                    SeguroPJ segPJ = (SeguroPJ) seg; //Downcasting
                    if(resposta.equals("A")){
                        segPJ.autorizarCondutor();
                    }
                    else{
                        segPJ.desautorizarCondutor();
                    }
                }
                break;
            case SAIR:
                System.exit(0);
        }
    }

    public static void main(String args[]){
        //Instanciando duas seguradoras
        Seguradora seguradora1 = new Seguradora("69.318.543/0001-58", "Porto", "11998823773", "porto@gmail.com", "Rua Porto 10");
        Seguradora seguradora2 = new Seguradora("53.336.795/0001-70", "Bradesco", "19976683113", "bradesco@gmail.com", "Rua Bradesco 20");

        //Instanciando 4 clientes
        //2 PF
        LocalDate datapf1 = LocalDate.of(2003, 12, 30);
        LocalDate datapf2 = LocalDate.of(2002, 10, 6);
        ClientePF clipf1 = new ClientePF("Joao", "Rua Joao 30", "11987665432", "joao@gmail.com", "787.331.860-57", datapf1, "EM completo", "M");
        ClientePF clipf2 = new ClientePF("Maria", "Rua Maria 40", "19900854123", "maria@gmail.com", "910.630.590-38", datapf2, "EM completo", "F");
        //2 PJ
        LocalDate datapj1 = LocalDate.of(1998, 7, 20);
        LocalDate datapj2 = LocalDate.of(2012, 4, 12);
        ClientePJ clipj1 = new ClientePJ("Maca", "Rua Maca 50", "11976635212", "maca@gmail.com", "84.552.520/0001-05", datapj1, 10);
        ClientePJ clipj2 = new ClientePJ("Banana", "Rua Banana 60", "19908734004", "banana@gmail.com", "86.468.273/0001-80", datapj2, 6); 

        //Instanciando 4 veiculos
        Veiculo vpf1 = new Veiculo("ABC1234", "Audi", "A5", 2021);
        Veiculo vpf2 = new Veiculo("DEF5678", "Honda", "HRV", 2022);
        Veiculo vpj1 = new Veiculo("CBA4321", "Toyota", "Corolla", 2022);
        Veiculo vpj2 = new Veiculo("FED8765", "Volvo", "XC60", 2020);

        //Instanciando 2 frotas
        Frota frota1 = new Frota();
        Frota frota2 = new Frota();
        frota1.addVeiculo(vpj1);
        frota2.addVeiculo(vpj2);
        clipj1.getListaFrota().add(frota1);
        clipj2.getListaFrota().add(frota2);

        //Instanciando 4 seguros
        seguradora1.gerarSeguro(clipf1, vpf1);
        seguradora1.gerarSeguro(clipj1, vpj1);
        seguradora2.gerarSeguro(clipf2, vpf2);
        seguradora2.gerarSeguro(clipj2, vpj2);
        
        //Gerando 2 condutores
        LocalDate datacond1 = LocalDate.of(2000, 5, 29);
        LocalDate datacond2 = LocalDate.of(1999, 10, 3);
        ArrayList<Sinistro> listaSin1 = new ArrayList<Sinistro>();
        ArrayList<Sinistro> listaSin2 = new ArrayList<Sinistro>();
        Condutor cond1 = new Condutor("453.565.800-53", "Marcos", "119381237226", "Rua Marcos 200", 
                                        "marcos@gmail.com", datacond1, listaSin1);
        Condutor cond2 = new Condutor("710.535.830-01", "Ana", "19921238043", "Rua Ana 100", 
                                        "ana@gmail.com", datacond2, listaSin2);

        //Gerando sinistros
        Seguro seguro1 = seguradora1.getListaSeguros().get(0);
        Seguro seguro2 = seguradora1.getListaSeguros().get(1);
        Seguro seguro3 = seguradora2.getListaSeguros().get(0);
        Seguro seguro4 = seguradora2.getListaSeguros().get(1);

        LocalDate datasin1 = LocalDate.of(2023, 5, 1);
        LocalDate datasin2 = LocalDate.of(2023, 3, 19);
        LocalDate datasin3 = LocalDate.of(2023, 1, 13);
        LocalDate datasin4 = LocalDate.of(2023, 4, 25);
        seguro1.gerarSinistro(datasin1, "Rua Sinistro 1", cond1);
        seguro2.gerarSinistro(datasin2, "Rua Sinistro 2", cond2);
        seguro3.gerarSinistro(datasin3, "Rua Sinistro 3", cond1);        
        seguro4.gerarSinistro(datasin4, "Rua Sinistro 4", cond2);
        
        //toStrings
        System.out.println("toStrings");
        System.out.println(seguradora1); //seguradora
        System.out.println(clipf1); //cliente pf
        System.out.println(clipj1); //cliente pj
        System.out.println(frota2); //frota
        System.out.println(seguro1); //seguro pf
        System.out.println(seguro2); //seguro pj
        System.out.println(vpf1); //veiculo
        System.out.println(seguro1.getListaSinistros().get(0)); //sinistro
        System.out.println(cond1); //condutor
        
        //-------METODOS DA SEGURADORA-------
        System.out.println(seguradora1.listarClientes("ClientePJ")); //listarClientes
        //gerarSeguro ja foi chamada
        System.out.println(seguradora2.getListaSeguros());
        seguradora2.cancelarSeguro(3); //cancelarSeguro
        seguradora1.cadastrarCliente(clipj2); //cadastrarCliente
        seguradora1.removerCliente(clipj2.getNome()); //removerCliente
        System.out.println(seguradora1.getSegurosPorCliente()); //getSegurosPorCliente
        System.out.println(seguradora1.getSinistrosPorCliente()); //getSinistrosPorCliente
        double receita = seguradora1.calcularReceita(); //calcularReceita

        //lista das seguradoras
        ArrayList<Seguradora> listaSeg = new ArrayList<Seguradora>();
        listaSeg.add(seguradora1);
        listaSeg.add(seguradora2);

        //-----------MENU INTERATIVO--------------
        System.out.println("1 - Cadastrar/Gerar\n2 - Listar\n3 - Excluir/Cancelar\n4 - Gerar sinistro\n5 - Transferir Seguro\n6 - Calcular Receita Seguradora\n7 - Autorizacao do Condutor\n0 - Sair\n");
        int comando = 0;
        Scanner entrada = new Scanner(System.in);
        //leio o comando
        comando = entrada.nextInt();
        while(true){
            System.out.println("Qual o nome da seguradora que voce deseja operar?\n");
            //Mostrando os seguros disponiveis
            for(Seguradora s : listaSeg){
                System.out.println("-" + s.getNome());
            }
            Scanner seguro = new Scanner(System.in);
            int ind = 0; //indice da seguradora desejada
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
                System.out.println("1 - Cadastrar/Gerar\n2 - Listar\n3 - Excluir/Cancelar\n4 - Gerar sinistro\n5 - Transferir Seguro\n6 - Calcular Receita Seguradora\n7 - Autorizacao do Condutor\n0 - Sair\n");
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
