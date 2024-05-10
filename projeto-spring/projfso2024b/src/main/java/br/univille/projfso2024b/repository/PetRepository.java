package br.univille.projfso2024b.repository;

import org.springframework.stereotype.Repository;

import br.univille.projfso2024b.entity.Pet;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PetRepository
    //entidade e nome da tabela, tipo da chave primaria
    extends JpaRepository<Pet, Long> {
}
