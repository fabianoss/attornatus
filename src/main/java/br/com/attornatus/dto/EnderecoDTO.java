package br.com.attornatus.dto;

import br.com.attornatus.domain.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("enderecoDTO")
public class EnderecoDTO implements Serializable {


    @JsonProperty("idEndereco")
    private Long idEndereco;
    @JsonProperty("logradouro")
    @NotNull(message = "O campo logradouro deve ser informado!")
    private String logradouro;
    @JsonProperty("cep")
    @NotNull(message = "O campo cep deve ser informado!")
    private Long cep;
    @JsonProperty("numero")
    @NotNull(message = "O campo numero deve ser informado!")
    private String numero;
    @JsonProperty("cidade")
    @NotNull(message = "O campo cidade deve ser informado!")
    private String cidade;

}
