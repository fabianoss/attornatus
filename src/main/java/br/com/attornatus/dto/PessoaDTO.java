package br.com.attornatus.dto;

import br.com.attornatus.domain.Endereco;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("pessoaDTO")
public class PessoaDTO implements Serializable {

    @JsonProperty("idPessoa")
    private Long idPessoa;
    @JsonProperty("nome")
    @NotNull(message = "O campo nome deve ser informado!")
    private String nome;
    @JsonProperty("dataNascimento")
    @NotNull(message = "O campo dataNascimento deve ser informado!")
    @JsonDeserialize(contentUsing = LocalDateDeserializer.class)
    @JsonSerialize(contentUsing = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
    private LocalDate dataNascimento;
    @JsonProperty("endereco")
    @NotNull(message = "O campo endereco deve ser informado!")
    private EnderecoDTO endereco;
}
