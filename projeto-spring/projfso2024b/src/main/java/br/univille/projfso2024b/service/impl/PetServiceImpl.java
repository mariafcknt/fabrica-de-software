package br.univille.projfso2024b.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfso2024b.entity.Pet;
import br.univille.projfso2024b.repository.PetRepository;
import br.univille.projfso2024b.service.PetService;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetRepository repository;

    @Override
    public void save(Pet pet) {
        repository.save(pet);
    }

    @Override
    public Pet getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Pet> getAll() {
        return repository.findAll();
    }

    @Override
    public Pet delete(long id){
        var pet = getById(id);
        repository.deleteById(id);
        return pet;
    }
}
