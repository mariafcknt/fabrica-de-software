package entidades;

public class Cliente {
    private String nome;
    private String endereco;
    private Cidade cidade;

    public Cliente(String nome){
        setNome(nome);
    }

    //override - sobreescrita de método
    //para haver uma sobreescrita é necessária uma herança
    public String toString(){ //o método toString() retorna a representação de um objeto
        return getNome();
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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
}
