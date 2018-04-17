package com.libreria.app.handler;

import com.libreria.app.configuration.LibrarySessionContext;
import com.libreria.app.model.Libro;
import com.libreria.app.model.User;
import com.libreria.app.repository.UserRepository;
import com.libreria.app.service.LibroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by HP on 15/04/2018.
 */
@Component
public class LoginOkAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LibrarySessionContext sessionContext;

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LibroService libroService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("Inicio carga sesion");
        this.feedUsuario(authentication);
        this.feedLibros();
        logger.info("Sesion cargada");
        response.sendRedirect("/" );
    }

    private void feedUsuario(Authentication authentication){
        final User usuario = userRepository.findByEmail(authentication.getName());
        sessionContext.setUsuario(usuario);
        logger.info("Usuario cargado en sesion");
    }

    private void feedLibros(){
        final List<Libro> libros = libroService.findAllLibros();
        sessionContext.setLibros(libros);
        logger.info("Libros cargados en sesion");
    }
}
