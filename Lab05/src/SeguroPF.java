import java.util.*;
import java.time.LocalDate;

public class SeguroPF extends Seguro{
    private Veiculo veiculo;
    private ClientePF cliente;

    //Construtora da classe
    public SeguroPF(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, int valorMensal, Veiculo veiculo, ClientePF cliente){
        //Chamando construtor da superclasse
        super(dataInicio, dataFim, seguradora, valorMensal);
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    //Gets da classe
    public Veiculo getVeiculo(){
        return veiculo;
    }
    public ClientePF getCliente(){
        return cliente;
    }

    //Sets da classe
    public void setVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }
    public void setClientePF(ClientePF cliente){
        this.cliente = cliente;
    }

    @Override
    public boolean autorizarCondutor() {

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
        return super.toString() + "veiculo: " + veiculo + "\n" + "cliente: " + cliente + "\n";
    }
}