package br.com.attornatus.service;

import br.com.attornatus.builder.impl.EnderecoBuilder;
import br.com.attornatus.builder.impl.PessoaBuilder;
import br.com.attornatus.domain.Endereco;
import br.com.attornatus.domain.Pessoa;
import br.com.attornatus.dto.EnderecoDTO;
import br.com.attornatus.dto.PessoaDTO;
import br.com.attornatus.exception.EnderecoException;
import br.com.attornatus.exception.PessoaException;
import br.com.attornatus.repository.EnderecoRepository;
import br.com.attornatus.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public List<EnderecoDTO> findAll(){
        List<Endereco> domains = repository.findAll();
        if(domains == null){
            return  Collections.emptyList();
        }
        return EnderecoBuilder.getInstance().listToDto(domains);
    }

    public List<EnderecoDTO> findByIdPessoa(Long idEndereco){
        if(idEndereco == null){
            throw new EnderecoException(Arrays.asList("idEndereco é obrigatório!"));
        }
        List<Endereco> domains = repository.findAll();
        if(domains == null){
            return  Collections.emptyList();
        }
        return EnderecoBuilder.getInstance().listToDto(domains);
    }

    public EnderecoDTO create(EnderecoDTO dto){
        Endereco domain = EnderecoBuilder.getInstance().toDomain(dto);
        return EnderecoBuilder.getInstance().toDto(repository.save(domain));
    }

    public void update(Long idEndereco, EnderecoDTO dto){
        Optional<Endereco> opt = repository.findById(idEndereco);
        if(opt.isEmpty()){
            throw new EnderecoException(Arrays.asList("idEndereco não encontrado!"));
        }
        Endereco updated = opt.get();
        EnderecoBuilder.getInstance().toUpdated(dto,updated);
        repository.save(updated);
    }

    public void delete(Long idEndereco){
        Optional<Endereco> opt = repository.findById(idEndereco);
        if(opt.isEmpty()){
            throw new EnderecoException(Arrays.asList("idEndereco não encontrado!"));
        }
        repository.deleteById(idEndereco);
    }


}
