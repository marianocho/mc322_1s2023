public class Veiculo {
	//OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK

	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	
	//Construtor
	public Veiculo(String placa, String marca, String modelo, int anoFabricacao) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
	}
	
	//Get da classe
	public String getPlaca() {
		return placa;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String getModelo() {
		return modelo;
	}

	public int getAnoFabricacao(){
		return anoFabricacao;
	}
	
	//Set da classe
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setAnoFabricacao(int anoFabricacao){
		this.anoFabricacao = anoFabricacao;
	}

	//toString da classe retorna todas variaveis
	public String toString() {
		return "placa: " + placa + "\n" + "marca: " + marca + "\n" + "modelo: " 
				+ modelo + "\n" + "anoFabricacao: " + anoFabricacao + "\n";
	}
	
	
}
