package br.com.attornatus.builder.impl;

import br.com.attornatus.builder.Builder;
import br.com.attornatus.domain.Pessoa;
import br.com.attornatus.dto.EnderecoDTO;
import br.com.attornatus.dto.PessoaDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PessoaBuilder implements Builder<PessoaDTO, Pessoa> {

    private static PessoaBuilder me = new PessoaBuilder();

    public static PessoaBuilder getInstance() {
        return me;
    }

    private PessoaBuilder() {
        super();
    }
    @Override
    public PessoaDTO toDto(Pessoa domain) {
        if(domain == null){
            return null;
        }
        PessoaDTO dto = new PessoaDTO();
        dto.setIdPessoa(domain.getIdPessoa());
        dto.setNome(domain.getNome());
        dto.setDataNascimento(domain.getDataNascimento());
        dto.setEndereco(EnderecoBuilder.getInstance().toDto(domain.getEndereco()));
        return dto;
    }

    @Override
    public List<PessoaDTO> listToDto(List<Pessoa> domains) {
        if(domains == null){
            return Collections.emptyList();
        }
        List<PessoaDTO> listToDto = new ArrayList<>();
        domains.stream().forEach(d -> listToDto.add(toDto(d)));
        return listToDto;
    }

    @Override
    public Pessoa toDomain(PessoaDTO dto) {
        if(dto == null){
            return null;
        }
        Pessoa domain = new Pessoa();
        domain.setIdPessoa(dto.getIdPessoa());
        domain.setNome(dto.getNome());
        domain.setDataNascimento(dto.getDataNascimento());
        domain.setEndereco(EnderecoBuilder.getInstance().toDomain(dto.getEndereco()));
        return domain;
    }

    @Override
    public List<Pessoa> listToDomain(List<PessoaDTO> dtos) {
        if(dtos == null){
            return Collections.emptyList();
        }
        List<Pessoa> listToDomain = new ArrayList<>();
        dtos.stream().forEach(d -> listToDomain.add(toDomain(d)));
        return listToDomain;
    }
}
