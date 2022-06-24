package com.dh.bd.test.ms.bd.test.model.sp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_rol_test")
@Immutable
public class UserPerRolEntity {

    @Id
    private Integer id;

    private String name;

    private String email;
}
