import java.util.*;
import java.time.LocalDate;

public class SeguroPF extends Seguro{
    private Veiculo veiculo;
    private ClientePF cliente;


    //Construtora da classe
    public SeguroPF(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, double valorMensal, Veiculo veiculo, ClientePF cliente){
        //Chamando construtor da superclasse
        super(dataInicio, dataFim, seguradora, valorMensal);
        this.cliente = cliente;
        this.veiculo = veiculo;
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
        this.cliente.getAutorizacao() = true;
    }

    @Override
    public boolean desautorizarCondutor(){
        this.cliente.getAutorizacao() = false;
    }

    @Override
    public double calcularValor(){
        //calculando o fator idade
        double fatorIdade = 0.0;
        if(cliente.getIdade() < 30){
            fatorIdade = CalcSeguro.FATOR_18_30.getValor();
        }
        else if(cliente.getIdade() < 60){
            fatorIdade = CalcSeguro.FATOR_30_60.getValor();
        }
        else{
            fatorIdade = CalcSeguro.FATOR_60_90.getValor();
        }

        //calculando a qtd de sinistros dos condutores
        int qtdSinCond = 0;
        for(Condutor cond : this.getListaCondutores()){ //para cada condutor
            for(Sinistro s : cond.getListaSinistros()){ //para cada sinistro
                //se a seguradora do sinistro for a mesma do seguro
                if(s.getSeguro().getSeguradora() == this.getSeguradora()){
                    qtdSinCond++;
                }
            }
        }
        return (CalcSeguro.VALOR_BASE.getValor() * fatorIdade * (1 + 1/(cliente.getListaVeiculos().size()+2)) 
                * (2 + this.getListaSinistros().size()/10) * (5 + qtdSinCond/10));
    }

    //toString da classe
    @Override
    public String toString(){
        return super.toString() + "veiculo: " + veiculo + "\n" + "cliente: " + cliente + "\n";
    }
}