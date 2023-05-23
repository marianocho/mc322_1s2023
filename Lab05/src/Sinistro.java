import java.time.LocalDate;

public class Sinistro {
	//OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK
		private int id;
		private LocalDate data;
		private String endereco;
		private Seguradora seguradora;
		private Veiculo veiculo;
		private Cliente cliente;
		//Primeiro idGerado é o 1, o proximo id sera idGerado++
		private static int idGerado = 1;
		
		//Construtor
		public Sinistro(LocalDate data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
			this.id = idGerado;
			//Gerado um id, somar um para gerar outro id na proxima
			idGerado++;
			this.data = data;
			this.endereco = endereco;
			this.seguradora = seguradora;
			this.veiculo = veiculo;
			this.cliente = cliente;
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

		public Seguradora getSeguradora(){
			return seguradora;
		}

		public Veiculo getVeiculo(){
			return veiculo;
		}

		public Cliente getCliente(){
			return cliente;
		}
		
		//Set da classe
		public void setId(int id) {
			this.id = id;
		}
		
		public void setData(LocalDate data) {
			this.data = data;
		}
		
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		public void setSeguradora(Seguradora seguradora){
			this.seguradora = seguradora;
		}

		public void setVeiculo(Veiculo veiculo){
			this.veiculo = veiculo;
		}

		public void setCliente(Cliente cliente){
			this.cliente = cliente;
		}

		//toString da classe retorna todas as variaveis
		public String toString(){
			return "id: " + id + "\n" + "data: " + data + "\n" + "endereco: " + endereco + "\n" 
					+ "seguradora: " + seguradora.getNome() + "\n" + "veiculo: " + veiculo + 
					"cliente: " + cliente.getNome() + "\n";
		}
		
}
