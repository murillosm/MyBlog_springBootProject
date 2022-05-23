package com.springBootProjetoInicial.springBootProject.service.serviceImpl;

import com.springBootProjetoInicial.springBootProject.model.Post;
import com.springBootProjetoInicial.springBootProject.repository.CodeblogRepository;
import com.springBootProjetoInicial.springBootProject.service.CodeblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeblogServiceImpl implements CodeblogService {

    @Autowired
    CodeblogRepository codeblogRepository;

    @Override
    public List<Post> findAll() {
        return codeblogRepository.findAll();
    }

    @Override
    public Post findById(long id) {
        return codeblogRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return codeblogRepository.save(post);
    }

}
