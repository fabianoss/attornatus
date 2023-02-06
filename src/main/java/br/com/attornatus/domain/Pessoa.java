package br.com.attornatus.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "tb_pessoa")
@Getter
@Setter
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pessoa")
    private Long idPessoa;

    @Column(name = "nome")
    @NotNull(message = "O campo nome deve ser informado!")
    private String nome;

    @Column(name = "dt_nascimento")
    @NotNull(message = "O campo data nascimento deve ser informado!")
    private LocalDate dataNascimento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "idPessoa")
    @NotNull(message = "Endereço deve ser informado!")
    private Endereco endereco;
}
