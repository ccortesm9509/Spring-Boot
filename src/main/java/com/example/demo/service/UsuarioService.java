package com.example.demo.service;


import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("Usuarioservicio")
public class UsuarioService implements UserDetailsService {


    @Autowired // inyectar el repositorio ->
    @Qualifier("UsuarioRepositorio")

    private UsuarioRepositorio repo ;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       Usuario user =  repo.findByUsuario(s);
        return new
                User(user.getUsuario(),
                user.getContrasena(),
                user.isActivo(),
                user.isActivo(),
                user.isActivo(),
                user.isActivo(),
                buildGrante(user.getRol()));
    }

    public List<GrantedAuthority> buildGrante(byte rol){
        String [] roles = {"Lector", "Usuario", "Administrador"};
        List<GrantedAuthority> aut = new ArrayList<>();
        for (int i = 0 ; i<rol ; i++){
            aut.add(new SimpleGrantedAuthority(roles[i]));
        }
        return  aut;
    }




}
