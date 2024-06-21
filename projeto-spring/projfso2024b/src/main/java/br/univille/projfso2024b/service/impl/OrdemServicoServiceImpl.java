package br.univille.projfso2024b.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfso2024b.entity.OrdemServico;
import br.univille.projfso2024b.repository.OrdemServicoRepository;
import br.univille.projfso2024b.service.OrdemServicoService;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService{
    @Autowired
    private OrdemServicoRepository repository;

    @Override
    public void save(OrdemServico ordemServico) {
        repository.save(ordemServico);
    }

    @Override
    public OrdemServico getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<OrdemServico> getAll() {
        return repository.findAll();
    }

    @Override
    public OrdemServico delete(long id){
        var ordemServico = getById(id);
        repository.deleteById(id);
        return ordemServico;
    }
}
