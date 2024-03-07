package entidades;

public class Cliente {
    private String nome;
    private String endereco;

    public Cliente(String nome){
        setNome(nome);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public String getEndereco(){
        return endereco;
    }
    
}
