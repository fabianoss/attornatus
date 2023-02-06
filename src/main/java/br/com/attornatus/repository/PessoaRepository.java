package br.com.attornatus.repository;

import br.com.attornatus.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Long, Pessoa>, CrudRepository<Long, Pessoa> {
}