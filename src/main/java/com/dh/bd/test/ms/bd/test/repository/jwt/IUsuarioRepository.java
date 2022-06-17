package com.dh.bd.test.ms.bd.test.repository.jwt;

import com.dh.bd.test.ms.bd.test.model.jwt.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuarios, Long> {

    public Usuarios findByEmail(String email);
}
