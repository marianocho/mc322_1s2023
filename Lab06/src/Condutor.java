import java.util.*;
import java.time.LocalDate;

public class Condutor {
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private LocalDate dataNasc;
    private ArrayList<Sinistro> listaSinistros;

    //Construtora da classe
    public Condutor(String cpf, String nome, String telefone, String endereco, String email, LocalDate dataNasc, 
                        ArrayList<Sinistro> listaSinistros){
        //Validando cpf
        if(Validacao.validarCPF(cpf)){
            this.cpf = cpf;		
        }
        else{
            Scanner scan = new Scanner(System.in);
            System.out.println("CPF inválido! Digite novamente: ");
            this.cpf = scan.next();
            scan.close();
        }
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNasc = dataNasc;
        this.listaSinistros = listaSinistros;

    }

    //Gets da classe
    public String getCpf(){
        return cpf;
    }
    public String getNome(){
        return nome;
    }
    public String getTelefone(){
        return telefone;
    }
    public String getEndereco(){
        return endereco;
    }
    public String getEmail(){
        return email;
    }
    public LocalDate getDataNasc(){
        return dataNasc;
    }
    public ArrayList<Sinistro> getListaSinistros(){
        return listaSinistros;
    }

    //Sets da classe
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setDataNasc(LocalDate dataNasc){
        this.dataNasc = dataNasc;
    }
    public void setListaSinistros(ArrayList<Sinistro> listaSinistros){
        this.listaSinistros = listaSinistros;
    }

    //Controle da listaSinistros
    public void adicionarSinistro(Sinistro sin){
        //Verificando se o sinistro ja existe
        for(Sinistro s : listaSinistros){
            if(s == sin){
                System.out.println("Sinistro ja existente!");
                return;
            }
        }
        System.out.println("Sinistro cadastrado!");
        return;
    }

    //toString da classe
    public String toString(){
        return "cpf: " + cpf + "\n" + "nome: " + nome + "\n" + "telefone: " + telefone + "\n" + "endereco: " + endereco + "\n" +
            "email: " + email + "\n" + "dataNascimento: " + dataNasc + "\n" + "listaSinistros: " + listaSinistros + "\n";
    }
}
