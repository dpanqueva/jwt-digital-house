package com.dh.bd.test.ms.bd.test.model.sp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Immutable
public class UserPerRolEntity {

    @Id
    private Integer id;

    private String name;

    private String email;
}
