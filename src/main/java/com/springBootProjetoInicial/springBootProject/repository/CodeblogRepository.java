package com.springBootProjetoInicial.springBootProject.repository;

import com.springBootProjetoInicial.springBootProject.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeblogRepository extends JpaRepository<Post, Long> {

}
