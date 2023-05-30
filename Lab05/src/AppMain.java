public class AppMain {
    public static void main(String args[]){
        //Instanciando duas seguradoras
        Seguradora seguradora1 = new Seguradora("69.318.543/0001-58", "Porto", "11998823773", "porto@gmail.com", "Rua Porto 10");
        //Seguradora com cnpj errado (certo: 53.336.795/0001-70)
        Seguradora seguradora2 = new Seguradora("53.336.795/0001-72", "Bradesco", "19976683113", "bradesco@gmail.com", "Rua Bradesco 20");

        //Instanciando 4 clientes
        //2 PF
        LocalDate datapf1 = LocalDate.of(2003, 12, 30);
        LocalDate datapf2 = LocalDate.of(2002, 10, 6);
        ClientePf clipf1 = new ClientePF("Joao", "Rua Joao 30", "11987665432", "joao@gmail.com", "787.331.860-57", datapf1, "EM completo", "M");
        ClientePF clipf2 = new ClientePF("Maria", "Rua Maria 40", "19900854123", "maria@gmail.com", "910.630.590-58", datapf2, "EM completo", "F"); //cpf errado, o certo eh 910.630.590-38
        //2 PJ
        LocalDate datapj1 = LocalDate.of(1998, 7, 20);
        LocalDate datapj2 = LocalDate.of(2012, 4, 12);
        ClientePJ clipj1 = new ClientePJ("Maca", "Rua Maca 50", "11976635212", "maca@gmail.com", "84.552.520/0001-05", datapj1, 10);
        ClientePJ clipj2 = new ClientePJ("Banana", "Rua Banana 60", "19908734004", "banana@gmail.com", "86.468.273/0001-85", datapj2, 6); //cnpj errado, o certo eh 86.468.273/0001-80

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

        //Instanciando 4 seguros
        //2 PF
        LocalDate datainipf1 = LocalDate.of(2020, 11, 15);
        LocalDate datainipf2 = LocalDate.of(2019, 9, 25);
        LocalDate datafimpf1 = LocalDate.of(2028, 11, 16);
        LocalDate datafimpf2 = LocalDate.of(2027, 9, 26);
        SeguroPF seguropf1 = new SeguroPF(datainipf1, datafimpf1, seguradora1, 0.0, vpf1, clipf1);
        seguropf1.setValorMensal(calcularValor());
        SeguroPF seguropf2 = new SeguroPF(datainipf2, datafimpf2, seguradora2, 0.0, vpf2, clipf2);
        seguropf2.setValorMensal(calcularValor());
        //2 PJ
        LocalDate datainipj1 = LocalDate.of(2020, 8, 21);
        LocalDate datainipj2 = LocalDate.of(2019, 9, 25);
        LocalDate datafimpj1 = LocalDate.of(2030, 8, 22);
        LocalDate datafimpj2 = LocalDate.of(2039, 9, 26);
        SeguroPJ seguropj1 = new SeguroPJ(datainipj1, datafimpj1, seguradora1, 0.0, frota1, clipj1);
        SeguroPJ seguropj2 = new SeguroPJ(datainipj2, datafimpj2, seguradora2, 0.0, frota2, clipj2);

        //Gerando 2 condutores, um para cada PJ
        LocalDate datacond1 = LocalDate.of(2000, 5, 29);
        LocalDate datacond2 = LocalDate.of(1999, 10, 3);
        ArrayList<Sinistro> listaSin1 = new ArrayList<Sinistro>();
        ArrayList<Sinistro> listaSin2 = new ArrayList<Sinistro>();
        Condutor cond1 = new Condutor("453.565.800-53", "Marcos", "119381237226", "Rua Marcos 200", "marcos@gmail.com", datacond1, listaSin1);
        Condutor cond2 = new Condutor("710.535.830-00", "Ana", "19921238043", "Rua Ana 100", "ana@gmail.com", datacond2, listaSin2); //cpf certo eh 710.535.830-01
   
        //Gerando sinistros
        LocalDate datasin1 = LocalDate.of(2023, 5, 29);
        LocalDate datasin2 = LocalDate.of(2022, 6, 2);
        LocalDate datasin3 = LocalDate.of(2022, 12, 10);
        LocalDate datasin4 = LocalDate.of(2023, 1, 19);
        seguropf1.gerarSinistro();
        seguropf2.gerarSinistro();
        seguropj1.gerarSinistro();
        seguropj2.gerarSinistro();

    }
}
