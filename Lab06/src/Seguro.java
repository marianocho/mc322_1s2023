import java.util.*;
import java.time.LocalDate;

public abstract class Seguro {
    private final int id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    private double valorMensal;
    //Primeiro idGerado é o 1, o proximo id sera idGerado++
	private static int idGerado = 1;

    //Construtora da classe
    public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, double valorMensal){
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
    public double getValorMensal(){
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
    public void setValorMensal(double valorMensal){
        this.valorMensal = valorMensal;
    }

    //----------FUNCOES POLIMORFAS--------------

    //Gera sinistro
    public void gerarSinistro(LocalDate data, String endereco, Condutor condutor){
        //Criando o novo sinistro
        Sinistro novoSinistro = new Sinistro(data, endereco, condutor, this);
        //Adicionando o sinistro na listaSinistro do seguro
        listaSinistros.add(novoSinistro);
        //Adicionando o sinistro na listaSinistro do condutor
        for(Condutor cond : listaCondutores){
            if(cond == condutor){
                cond.getListaSinistros().add(novoSinistro);
            }
        }
    }
    
    //Calcula valor do seguro
    public double calcularValor(){
        return 0.0;
    }

    //toString da classe
    public String toString(){
        return "id: " + id + "\n" + "dataInicio: " + dataInicio + "\n" + "dataFim: " + dataFim + "\n" + "seguradora: " + seguradora.getNome() + "\n" + 
            "Quantidade de Sinistros: " + listaSinistros.size() + "\n" + "listaCondutores: " + listaCondutores + "\n" + "valorMensal: " + valorMensal + "\n";
    }

}
