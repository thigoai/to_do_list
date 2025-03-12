package br.ufrn.thiago.to_do_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufrn.thiago.to_do_list.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

    
}
