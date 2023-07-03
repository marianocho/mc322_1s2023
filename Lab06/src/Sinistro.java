import java.time.LocalDate;

public class Sinistro {
	private final int id;
	private LocalDate data;
	private String endereco;
	private Condutor condutor;
	private Seguro seguro;
	//Primeiro idGerado é o 1, o proximo id sera idGerado++
	private static int idGerado = 1;
	
	//Construtor
	public Sinistro(LocalDate data, String endereco, Condutor condutor, Seguro seguro) {
		this.id = idGerado;
		//Gerado um id, somar um para gerar outro id na proxima
		idGerado++;
		this.data = data;
		this.endereco = endereco;
		this.condutor = condutor;
		this.seguro = seguro;
	}
	
	//Get da classe
	public int getId() {
		return id;
	}
	public LocalDate getData() {
		return data;
	}
	public String getEndereco() {
		return endereco;
	}
	public Condutor getCondutor(){
		return condutor;
	}
	public Seguro getSeguro(){
		return seguro;
	}
	
	//Set da classe
	public void setData(LocalDate data) {
		this.data = data;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setCondutor(Condutor condutor){
		this.condutor = condutor;
	}
	public void setSeguro(Seguro seguro){
		this.seguro = seguro;
	}

	//toString da classe retorna todas as variaveis
	public String toString(){
		return "id: " + id + "\n" + "data: " + data + "\n" + "endereco: " + endereco + "\n" + "condutor: " + condutor.getNome() + "\n"  
				+ "seguro: " + seguro + "\n";
	}
	
}
