package br.com.attornatus.service;

import br.com.attornatus.exception.PessoaException;
import br.com.attornatus.builder.impl.PessoaBuilder;
import br.com.attornatus.domain.Pessoa;
import br.com.attornatus.dto.PessoaDTO;
import br.com.attornatus.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public List<PessoaDTO> findAll(){
        List<Pessoa> domains = repository.findAll();
        if(domains == null){
            return  Collections.emptyList();
        }
        return PessoaBuilder.getInstance().listToDto(domains);
    }

    public List<PessoaDTO> findByIdPessoa(Long idPessoa){
        if(idPessoa == null){
            throw new PessoaException(Arrays.asList("IdPessoa é obrigatório!"));
        }
        List<Pessoa> domains = repository.findAll();
        if(domains == null){
            return  Collections.emptyList();
        }
        return PessoaBuilder.getInstance().listToDto(domains);
    }

    public PessoaDTO create(PessoaDTO dto){
        Pessoa domain = PessoaBuilder.getInstance().toDomain(dto);
        return PessoaBuilder.getInstance().toDto(repository.save(domain));
    }
}
