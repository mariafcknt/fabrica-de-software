package entidades;

import java.util.ArrayList;
public class Cliente {
    private String nome;
    private String endereco;
    private Cidade cidade;
    private ArrayList<Pokemon> listaPokemon 
            = new ArrayList<Pokemon>();


    public ArrayList<Pokemon> getListaPokemon() {
        return listaPokemon;
    }

    public void setListaPokemon(ArrayList<Pokemon> listaPokemon) {
        this.listaPokemon = listaPokemon;
    }



    //override - sobreescrita de metodo
    public String toString(){
        return getNome();
    }
    
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Cliente(String nome){
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
    
}