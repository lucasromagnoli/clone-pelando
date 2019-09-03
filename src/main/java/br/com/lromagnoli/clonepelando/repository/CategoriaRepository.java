package br.com.lromagnoli.clonepelando.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lromagnoli.clonepelando.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
