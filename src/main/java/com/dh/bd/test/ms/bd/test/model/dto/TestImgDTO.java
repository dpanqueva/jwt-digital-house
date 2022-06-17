package com.dh.bd.test.ms.bd.test.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TestImgDTO implements Serializable {

    private static final long serialVersionUID = 1l;

    private long codigo;
    private String name;
}
