package br.univille.projfso2024b.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfso2024b.entity.Cliente;
import br.univille.projfso2024b.repository.ClienteRepository;
import br.univille.projfso2024b.service.ClienteService;

@Service
public class ClienteServiceImpl
    implements ClienteService{

    @Autowired //injeção de dependência, vc faz o trabalho por mim
    private ClienteRepository repository;

    @Override
    public void save(Cliente cliente) {
        repository.save(cliente);
        //aqui ele so salva, nao verifica nada
        //tem que fazer as regras de negocio, so escreve se tem cpf, nome, aqui que fazemos isso
        //isso e uma camada de servico, se snao puder imprimir aqui lancamos o erro
    }

    @Override
    public Cliente getById(long id) {
        return repository.getById(id);
        //codigo riscado é depreciado/deprecated, 'tem coisa melhor nova, mas vc pode continuar usando'
    }

    @Override
    public List<Cliente> getAll() {
        //ter uma lista de cliente
        return repository.findAll();
        //select * from cliente;
        //n fazemos isso em aplicacao real, temos que usar paginacao, mostrar 10, 20, etc
        //
    }
}
