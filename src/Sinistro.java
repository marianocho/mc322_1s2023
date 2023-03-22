public class Sinistro {

		private int id;
		private String data;
		private String endereco;
		//Primeiro idGerado é o 1, o proximo id sera idGerado++
		private static int idGerado = 1;
		
		//Construtor
		public Sinistro(String data, String endereco) {
			this.id = idGerado;
			//Gerado um id, somar um para gerar outro id na proxima
			idGerado++;
			this.data = data;
			this.endereco = endereco;
		}
		
		//Get da classe
		public int getId() {
			return id;
		}

		public String getData() {
			return data;
		}

		public String getEndereco() {
			return endereco;
		}
		
		//Set da classe
		public void setId(int id) {
			this.id = id;
		}
		
		public void setData(String data) {
			this.data = data;
		}
		
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		
}
