package com.springBootProjetoInicial.springBootProject.service;

import com.springBootProjetoInicial.springBootProject.model.Post;

import java.util.List;

public interface CodeblogService {
    List<Post> findAll();
    Post findById(long id);
    Post save(Post post);

}
