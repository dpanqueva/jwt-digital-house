package com.dh.bd.test.ms.bd.test.repository.sp;

import com.dh.bd.test.ms.bd.test.model.sp.UserPerRolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStoredProcedureRepository extends JpaRepository<UserPerRolEntity, Integer> {

    @Query(value = "{CALL sp_consulta_usuarios_roles()}", nativeQuery = true)
    public List<UserPerRolEntity> executeSP();
}
