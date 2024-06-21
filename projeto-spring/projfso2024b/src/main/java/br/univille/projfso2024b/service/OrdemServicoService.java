package br.univille.projfso2024b.service;

import java.util.List;
import br.univille.projfso2024b.entity.OrdemServico;

public interface OrdemServicoService {
    void save(OrdemServico servico);
    OrdemServico getById(long id);
    List<OrdemServico> getAll();
    OrdemServico delete(long id);
}
