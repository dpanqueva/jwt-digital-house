package com.dh.bd.test.ms.bd.test.service.jwt;

import com.dh.bd.test.ms.bd.test.model.jwt.Usuarios;
import com.dh.bd.test.ms.bd.test.repository.jwt.IUsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UsuarioService implements UserDetailsService {
    /**
     * Clase que implementa seguridad aplicando authentication con jpa
     * con roles y usuarios
     */
    @Autowired
    private IUsuarioRepository usuarioRepository;

    /**
     * Se implementa el metodo proveniente de la interfaz UserDetailServce
     *
     * @param username este debe ser igual al que voy a enviar desde el front
     */
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuarios = usuarioRepository.findByEmail(username);/** Busco en la bd si el usuario existe*/
        if (usuarios == null) {
            String msj = "usuario no existe ".concat(username);
            log.error(msj);
            throw new UsernameNotFoundException(msj);
        }
        /**
         * Debemos sacar el nombre del ROL para que pueda funcionar de manera correcta, ya que el usuario
         * de userDetails requiere las autoridades para acceder.
         * */
        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority(usuarios.getRoleId().getName());
        authorities.add(authority);
        log.info(usuarios.getRoleId().getName());
        /** le envio el password sacado de base de datos para que User lo compare con el password que viene
         * en en el formulario*/
        return new User(usuarios.getEmail(), usuarios.getPassword(), usuarios.getEnabled()
                , true, true, true, authorities);
    }
}
