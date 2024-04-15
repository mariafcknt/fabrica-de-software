package br.univille.projfso2024b;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import br.univille.projfso2024b.entity.Cliente;
import br.univille.projfso2024b.service.ClienteService;

@SpringBootTest
@ContextConfiguration
@ActiveProfiles(profiles = "test")
//agr nosso banco esta em memoria e nao em disco
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
//teste, nos vamos trabalar com contextos sujos
//um teste seuja o contexto do outro teste
//antes de cada teste, limpa o contexto, apaga o banco, a cada teste limpa o banco e comeca de novo

public class ClienteServiceTest {
    //vamos testar Cliente service impl, mas n vmaos chamar ela
    //eu quero o  cliente service, mas eu n quero saber a implementacao dele, usarmos autowired
    //spirng em algum lugar do codigo tem alguem q implementa a interface, procure e traga pra mim

    @Autowired
    private ClienteService service;

    //metodo void?!

    //esperamos uma lista vazia pois é o primeiro teste, tem que voltar nada
    //colocar @Test, se nao ele nao executa
    @Test
    public void getAllClientesEmptyList(){
        var listaClientes = service.getAll();
        //supor que o tamanho da lista é zero, esse é o nosso primeiro teste, supomos que ela estaja vazia, isso é um teste
        assertEquals(listaClientes.size(), 0);
    }

    @Test
    public void saveCliente(){
        //criar um cliente
        var novocliente = new Cliente();
        novocliente.setNome("Zezinho");
        service.save(novocliente);
        //salvar o cliente
        

        //essa parte falhou, vamos ver na outra aula
        var clienteConsulta = service.getById(1);
        //se eu conseguir pegar o cliente, salvar

        assertNotNull(clienteConsulta); //ver se não está vazio
        assertEquals(clienteConsulta.getNome(), "Zezinho");
    }
}
