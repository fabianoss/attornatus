package br.com.attornatus.service;

import br.com.attornatus.builder.impl.EnderecoBuilder;
import br.com.attornatus.domain.Endereco;
import br.com.attornatus.dto.EnderecoDTO;
import br.com.attornatus.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public List<EnderecoDTO> findAll(){
        List<Endereco> domains = repository.findAll();
        if(domains == null){
            return Collections.emptyList();
        }
        return EnderecoBuilder.getInstance().listToDto(domains);
    }


}
