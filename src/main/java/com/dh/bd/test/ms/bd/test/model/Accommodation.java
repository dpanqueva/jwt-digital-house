/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.bd.test.ms.bd.test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "accommodations")
public class Accommodation implements Serializable {

    private static final long serialVersionUID = 1l;
    @Id
    //@SequenceGenerator(name="accommodation_sequence", sequenceName = "accommodation_sequence", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accommodation_sequence")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String address;
    private Float latitude;
    private Float longitude;
    private String description;
    private Double rating;
    private Integer stars;
    private Integer cancellation_policy;


    //ONE ACCOMMODATION HAS MANY IMAGES
    //@OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL)
    @JsonBackReference
    @JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    //@JsonIgnore
    private List<Image> images = new ArrayList<>();
    //private List<Image> images;

}
