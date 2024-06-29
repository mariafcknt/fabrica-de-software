package br.univille.projfso2024b.repository;

import org.springframework.stereotype.Repository;

import br.univille.projfso2024b.entity.OrdemServico;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrdemServicoRepository
    //entidade e nome da tabela, tipo da chave primaria
    extends JpaRepository<OrdemServico, Long> {
}
