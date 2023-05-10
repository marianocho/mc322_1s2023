import java.time.LocalDate;
import java.util.ArrayList;

import Validacao.validacaoS;

public class AppMain {
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

        //FUNCAO DE MENU DE OPERACOES
    }
}
