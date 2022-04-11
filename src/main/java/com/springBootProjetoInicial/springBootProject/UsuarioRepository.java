package com.springBootProjetoInicial.springBootProject;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository  extends CrudRepository<Usuario, Integer>{
    Usuario findUserById(Integer id);
}
