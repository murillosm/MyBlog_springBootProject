package com.springBootProjetoInicial.springBootProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/add")
    public String addUser(@RequestParam String first, @RequestParam String last) {
        Usuario user = new Usuario();
        user.setFirstName(first);
        user.setLastName(last);
        usuarioRepository.save(user);
        return "Added new user to repo!";
    }

    @GetMapping("/list")
    public Iterable<Usuario> getUser() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Usuario findUserById(@PathVariable Integer id) {
        return usuarioRepository.findUserById(id);
    }
}
