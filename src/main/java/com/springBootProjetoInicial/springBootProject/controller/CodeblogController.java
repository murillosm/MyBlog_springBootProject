package com.springBootProjetoInicial.springBootProject.controller;

import com.springBootProjetoInicial.springBootProject.model.Post;
import com.springBootProjetoInicial.springBootProject.service.CodeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CodeblogController {

    @Autowired
    CodeBlogService codeBlogService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPost(){
       ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = codeBlogService.findAll();
        mv.addObject("posts", posts);
        return mv;
    }
}
