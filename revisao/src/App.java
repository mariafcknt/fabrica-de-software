import entidades.Cidade;
import entidades.Cliente;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        Cliente umCliente;
        umCliente = new Cliente("Ana");

        //System.out.println(umCliente);
        //System.out.println(umCliente.getNome());
        

        var umaCidade = new Cidade("Joinville");
        umCliente.setCidade(umaCidade);
        System.out.println(umCliente.getCidade().getNome());

        //System.out.println(umCliente.toString());

    }
}
