import java.util.*;
import java.time.LocalDate;

public class SeguroPJ extends Seguro {
    private Frota frota;
    private ClientePJ cliente;

    public SeguroPJ(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, double valorMensal, Frota frota, ClientePJ cliente){
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
        this.cliente.getAutorizacao() = true;
    }

    @Override
    public boolean desautorizarCondutor(){
        this.cliente.getAutorizacao() = false;
    }

    @Override
    public double calcularValor(){
        int qtdSinCond = 0;
        //calculando a qtd de sinistros que os condutores tem
        for(Condutor cond : this.getListaCondutores()){ //para cada condutor
            for(Sinistro s : cond.getListaSinistros()){ //para cada sinistro
                //se a seguradora do sinistro for a mesma do seguro
                if(s.getSeguro().getSeguradora() == this.getSeguradora()){
                    qtdSinCond++;
                }
            }
        }
        return (CalcSeguro.VALOR_BASE.getValor() * (10 + (cliente.getQtdeFuncionarios())/10) * (1 + 1/(frota.getListaVeiculos().size()+2)) * 
                (1 + 1/(cliente.getAnosPosFundacao()+2)) * (2 + this.getListaSinistros().size()/10) * (5 + qtdSinCond/10));
    }

    //toString da classe
    @Override
    public String toString(){
        return super.toString() + "frota: " + frota + "\n" + "cliente: " + cliente + "\n";
    }
}
