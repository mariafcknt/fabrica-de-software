package br.univille.projfso2024b.service;

import java.util.List;
import br.univille.projfso2024b.entity.Pet;

public interface PetService {
    void save(Pet pet);
    Pet getById(long id);
    List<Pet> getAll();
    Pet delete(long id);
}
