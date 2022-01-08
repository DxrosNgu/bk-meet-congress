package com.pe.stmp.one.meetcongressoauth.event;

import com.pe.stmp.one.meetcongressoauth.mapper.UserMapper;
import com.pe.stmp.one.meetcongressoauth.models.User;
import com.pe.stmp.one.meetcongressoauth.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher {

    private final Logger log = LoggerFactory.getLogger(AuthenticationSuccessErrorHandler.class);

    @Autowired
    private UserService userService;

    @Autowired
    UserMapper userMapper;

    @Override
    public void publishAuthenticationSuccess(Authentication authentication) {
        if(authentication.getName().equalsIgnoreCase("frontendapp")){
            return; // si es igual a frontendapp se salen del método!
        }

        UserDetails user = (UserDetails) authentication.getPrincipal();
        String message = "Success Login: " + user.getUsername();
        log.info(message);

        User usuario = userMapper.toUser(userService.findByUsername(user.getUsername()));

        if(usuario.getIntentos() != null && usuario.getIntentos() > 0){
            usuario.setIntentos(0);
            userService.update(usuario, usuario.getId());
        }
    }

    @Override
    public void publishAuthenticationFailure(AuthenticationException e, Authentication authentication) {
        String message = "Error en el login: " + e.getMessage();
        log.error(message + " : ");
        System.out.println(message);
        StringBuilder errors = new StringBuilder();

        errors.append(message);
        User user = userMapper.toUser(userService.findByUsername(authentication.getName()));

        if (user.getIntentos() == null) {
            user.setIntentos(0);
        }
        String errorAttemp = String.format("Intento actual, %s de ingreso del usuario.", user.getIntentos());
        log.error(errorAttemp);
        errors.append(" - ").append(errorAttemp);
        String errorMaxAttemps = String.format("Maximo de intento superado usuario %s se encuenta bloqueado.", user.getUsername());
        user.setIntentos(user.getIntentos() + 1);
        if (user.getIntentos() >= 3){

            errors.append(errorMaxAttemps);
            user.setEnabled(false);
        }
        userService.update(user, user.getId());
    }
}
