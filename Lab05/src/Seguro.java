import java.util.*;
import java.time.LocalDate;

public abstract class Seguro {
    private final int id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    private int valorMensal;
    //Primeiro idGerado é o 1, o proximo id sera idGerado++
	private static int idGerado = 1;

    //Construtora da classe
    public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, int valorMensal){
        this.id = idGerado;
        //Gerado um id, o proximo sera id++
        idGerado++;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaCondutores = new ArrayList<Condutor>();
        this.valorMensal = valorMensal;
    }

    //Gets da classe
    public int getId(){
        return id;
    }
    public LocalDate getDataInicio(){
        return dataInicio;
    }
    public LocalDate getDataFim(){
        return dataFim;
    }
    public Seguradora getSeguradora(){
        return seguradora;
    }
    public ArrayList<Sinistro> getListaSinistros(){
        return listaSinistros;
    }
    public ArrayList<Condutor> getListaCondutores(){
        return listaCondutores;
    }
    public int getValorMensal(){
        return valorMensal;
    }

    //Sets da classe
    public void setDataInicio(LocalDate dataInicio){
        this.dataInicio = dataInicio;
    }
    public void setDataFim(LocalDate dataFim){
        this.dataFim = dataFim;
    }
    public void setSeguradora(Seguradora seguradora){
        this.seguradora = seguradora;
    }
    public void setListaSinistros(ArrayList<Sinistro> listaSinistros){
        this.listaSinistros = listaSinistros;
    }
    public void setListaCondutores(ArrayList<Condutor> listaCondutores){
        this.listaCondutores = listaCondutores;
    }
    public void setValorMensal(int valorMensal){
        this.valorMensal = valorMensal;
    }

    //----------FUNCOES POLIMORFAS--------------

    //Autorizacao/Desautorizacao do condutor
    public boolean autorizarCondutor(){

    }
    public boolean desautorizarCondutor(){

    }

    //Gera sinistro
    public void gerarSinistro(){

    }
    
    //Calcula valor do seguro
    public void calcularValor(){

    }

    //toString da classe
    public String toString(){
        return "id: " + id + "\n" + "dataInicio: " + dataInicio + "\n" + "dataFim: " + dataFim + "\n" + "seguradora: " + seguradora + "\n" + 
            "listaSinistros: " + listaSinistros + "\n" + "listaCondutores: " + listaCondutores + "\n" + "valorMensal: " + valorMensal + "\n";
    }

}
