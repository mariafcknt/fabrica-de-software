import entidades.Cidade;
import entidades.Cliente;
import entidades.Pokemon;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        //Cliente umCliente;
        //umCliente = new Cliente("Ana");

        //System.out.println(umCliente);
        //System.out.println(umCliente.getNome());
        

        //var umaCidade = new Cidade("Joinville");
        //umCliente.setCidade(umaCidade);
        //System.out.println(umCliente.getCidade().getNome());

        //System.out.println(umCliente.toString());

        float peso = 100;
        int idade = 20;
        var nome = "zezinho";
        //variavel
        Cliente umCliente;
        //instanciação de um objeto
        umCliente = new Cliente("Zezinho");
        System.out.println(umCliente);
        System.out.println(umCliente.getNome());

        var umaCidade = new Cidade("Joinville");
        umCliente.setCidade(umaCidade);
        System.out.println(umCliente.getCidade().getNome());

        var bulbasaur = new Pokemon("Bulbasaur");
        var jigglypuff = new Pokemon("Jigglypuff");

        umCliente.getListaPokemon().add(bulbasaur);
        umCliente.getListaPokemon().add(jigglypuff);
        // umCliente.getListaPokemon().add("PEDRA");
        // umCliente.getListaPokemon().add(2134234234);
        // umCliente.getListaPokemon().add(false);
        
        System.out.println(umCliente.getListaPokemon());

    }
}
