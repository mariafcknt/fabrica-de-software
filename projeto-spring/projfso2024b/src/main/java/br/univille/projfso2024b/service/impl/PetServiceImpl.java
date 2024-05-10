package br.univille.projfso2024b.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfso2024b.entity.Pet;
import br.univille.projfso2024b.repository.PetRepository;
import br.univille.projfso2024b.service.PetService;

@Service
public class PetServiceImpl
    implements PetService{

    @Autowired //injeção de dependência, vc faz o trabalho por mim
    private PetRepository repository;

    @Override
    public void save(Pet pet) {
        repository.save(pet);
        //aqui ele so salva, nao verifica nada
        //tem que fazer as regras de negocio, so escreve se tem cpf, nome, aqui que fazemos isso
        //isso e uma camada de servico, se snao puder imprimir aqui lancamos o erro
    }

    @Override
    public Pet getById(long id) {
        return repository.getById(id);
        //codigo riscado é depreciado/deprecated, 'tem coisa melhor nova, mas vc pode continuar usando'
    }

    @Override
    public List<Pet> getAll() {
        //ter uma lista de Pet
        return repository.findAll();
        //select * from Pet;
        //n fazemos isso em aplicacao real, temos que usar paginacao, mostrar 10, 20, etc
        //
    }

    @Override
    public Pet delete(long id) {
        var pet = getById(id); //guardamos o que vai ser excluido para dar um retorno
        repository.deleteById(id);
        return pet;
    }
}
