package com.dh.bd.test.ms.bd.test.model.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "vw_accommodation_img")
@Immutable
public class AccommodationView {

    @Id
    @Column(name = "id_accommodation")
    private Integer id;

    @Column(name = "address")
    private String address;
    @Column(name = "title")
    private String title;
}
