package com.springBootProjetoInicial.springBootProject.controller;

import com.springBootProjetoInicial.springBootProject.model.Post;
import com.springBootProjetoInicial.springBootProject.service.CodeblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CodeblogController {

    @Autowired
    CodeblogService codeblogService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts(){
       ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = codeblogService.findAll();
        mv.addObject("posts", posts);
        return mv;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getInicial(){
        return "inicial";
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = codeblogService.findById(id);
        mv.addObject("post", post);
        return mv;
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.GET)
    public String getPostForm(){
        return "postForm";
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.POST)
    public String SavePost(@Validated Post post, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem","Verifique se os capos Abrigatorios foram preenchidos!");
            return "redirect:/newpost";
        }
        post.setData(LocalDate.now());
        codeblogService.save(post);
        return "redirect:/posts";
    }

    /*@RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deletePost(long id){
        Post post = codeblogService.findById(id);
        codeblogService.delete(post);
        return "redirect:/posts";
    }*/
}
