package com.dh.bd.test.ms.bd.test.service;

import com.dh.bd.test.ms.bd.test.model.Accommodation;

import java.util.List;

public interface IAccommodationService {

    public Accommodation save(Accommodation accommodation);
    public List<Accommodation> findAll();
    public Accommodation findById(Integer id);
}
