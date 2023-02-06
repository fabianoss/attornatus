package br.com.attornatus.repository;

import br.com.attornatus.domain.Endereco;
import br.com.attornatus.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Long, Endereco>, CrudRepository<Long, Endereco> {
}
