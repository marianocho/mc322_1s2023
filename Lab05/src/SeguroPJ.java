import java.util.*;
import java.time.LocalDate;

public class SeguroPJ extends Seguro {
    private Frota frota;
    private ClientePJ cliente;

    public SeguroPJ(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, int valorMensal, Frota frota, ClientePJ cliente){
        //Chamando construtor da superclasse
        super(dataInicio, dataFim, seguradora, valorMensal);
        this.frota = frota;
        this.cliente = cliente;
    }

    //Gets da classe
    public Frota getFrota(){
        return frota;
    }
    public ClientePJ getCliente(){
        return cliente;
    }

    //Sets da classe
    public void setFrota(Frota frota){
        this.frota = frota;
    }
    public void setCliente(ClientePJ cliente){
        this.cliente = cliente;
    }

    @Override
    public boolean autorizarCondutor(){

    }

    @Override
    public boolean desautorizarCondutor(){

    }

    @Override
    public void gerarSinistro(){

    }

    @Override
    public void calcularValor(){

    }

    //toString da classe
    @Override
    public String toString(){
        return super.toString() + "frota: " + frota + "\n" + "cliente: " + cliente + "\n";
    }
}
