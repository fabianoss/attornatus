package br.com.attornatus.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "tb_endereco")
@Getter
@Setter
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_endereco")
    private Long idEndereco;

    @Column(name = "logradouro")
    @NotNull(message = "O campo logradouro deve ser informado!")
    private String logradouro;
    @Column(name = "cep")
    @NotNull(message = "O campo cep deve ser informado!")
    private Long cep;
    @Column(name = "numero")
    @NotNull(message = "O campo numero deve ser informado!")
    private String numero;
    @Column(name = "cidade")
    @NotNull(message = "O campo cidade deve ser informado!")
    private String cidade;

    @OneToOne(mappedBy = "endereco")
    private Pessoa pessoa;
}
