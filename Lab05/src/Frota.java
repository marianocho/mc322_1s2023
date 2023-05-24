import java.util.*;

public class Frota {
    private String code;
    ArrayList<Veiculo> listaVeiculos;

    //Construtora da classe
    public Frota(String code){
        this.code = code;
        this.listaVeiculos = new ArrayList<Veiculo>();
    }

    //Gets da classe
    public String getCode(){
        return code;
    }
    public ArrayList<Veiculo> getListaVeiculos(){
        return listaVeiculos;
    }

    //Sets da classe
    public void setCode(String code){
        this.code = code;
    }
    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos){
        this.listaVeiculos = listaVeiculos;
    }

    //Controle da lista de veiculos
    public boolean addVeiculo(Veiculo v){
		for(Veiculo veiculo : listaVeiculos){
			if(veiculo == v){
				System.out.println("Veiculo ja existente!");
				return false;
			}
		}
		System.out.println("Veiculo adicionado!");
		listaVeiculos.add(v);
		return true;
	}

	public boolean removeVeiculo(Veiculo v){
		for(Veiculo veiculo : listaVeiculos){
			if(veiculo == v){
				System.out.println("Removendo veiculo!");
				listaVeiculos.remove(v);
				return true;
			}
		}
		System.out.println("Nao existe esse veiculo!");
		return false;
	}
	
    public String gerarCode(){
        Random r = new Random();
        //String que vai de a-z
        String alph = "abcdefghijklmnopqrstuvwxyz";

        StringBuilder s = new StringBuilder(26);
        for(int i = 0; i < 8; i++){
            //gerando um numero aleatorio
            int ch = (int)(AlphaNumericString.length() * Math.random());
        }

    }

    //toString da classe
    public String toString(){
        return "code: " + code + "\n" + "listaVeiculos: " + listaVeiculos + "\n";
    }
}
