package br.com.attornatus.builder.impl;

import br.com.attornatus.builder.Builder;
import br.com.attornatus.domain.Endereco;
import br.com.attornatus.domain.Pessoa;
import br.com.attornatus.dto.EnderecoDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnderecoBuilder implements Builder<EnderecoDTO, Endereco>{

    private static EnderecoBuilder me = new EnderecoBuilder();

    public static EnderecoBuilder getInstance() {
        return me;
    }

    private EnderecoBuilder() {
        super();
    }
    @Override
    public EnderecoDTO toDto(Endereco domain) {
        if(domain == null){
            return null;
        }
        EnderecoDTO dto = new EnderecoDTO();
        dto.setIdEndereco(domain.getIdEndereco());
        dto.setLogradouro(domain.getLogradouro());
        dto.setCep(domain.getCep());
        dto.setNumero(domain.getNumero());
        dto.setCidade(domain.getCidade());
        return dto;
    }

    @Override
    public List<EnderecoDTO> listToDto(List<Endereco> domains) {
        if(domains == null){
            return Collections.emptyList();
        }
        List<EnderecoDTO> listToDto = new ArrayList<>();
        domains.stream().forEach(d -> listToDto.add(toDto(d)));
        return listToDto;
    }

    @Override
    public Endereco toDomain(EnderecoDTO dto) {
        if(dto == null){
            return null;
        }
        Endereco domain = new Endereco();
        domain.setIdEndereco(dto.getIdEndereco());
        domain.setLogradouro(dto.getLogradouro());
        domain.setCep(dto.getCep());
        domain.setNumero(dto.getNumero());
        domain.setCidade(dto.getCidade());
        return domain;
    }

    @Override
    public List<Endereco> listToDomain(List<EnderecoDTO> dtos) {
        if(dtos == null){
            return Collections.emptyList();
        }
        List<Endereco> listToDomain = new ArrayList<>();
        dtos.stream().forEach(d -> listToDomain.add(toDomain(d)));
        return listToDomain;
    }
}
