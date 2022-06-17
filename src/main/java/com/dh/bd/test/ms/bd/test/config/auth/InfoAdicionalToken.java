package com.dh.bd.test.ms.bd.test.config.auth;

import com.dh.bd.test.ms.bd.test.model.jwt.Usuarios;
import com.dh.bd.test.ms.bd.test.repository.jwt.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * esta clase me permite traer más información de mi base de datos para nutrir nuestro jwt
 * */
@Component
public class InfoAdicionalToken implements TokenEnhancer {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    /**
     * Este metodo es el que nos permite traer la información de autenticación y así poder usar el
     * nombre de usuario o correo para buscar los datos que necesito e incluirlos en el jwt
     * */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Usuarios u = usuarioRepository.findByEmail(oAuth2Authentication.getName());
        Map<String, Object> dataInfo = new HashMap<>();
        dataInfo.put("info_adicional", oAuth2Authentication.getName());
        dataInfo.put("nombre_usuario", u.getName());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(dataInfo);
        return oAuth2AccessToken;
    }
}
