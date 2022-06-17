package com.dh.bd.test.ms.bd.test.service;

import com.dh.bd.test.ms.bd.test.model.Accommodation;
import com.dh.bd.test.ms.bd.test.repository.IAccommodation;
import com.dh.bd.test.ms.bd.test.repository.IImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AccommodationServiceImpl implements IAccommodationService {


    @Autowired
    private IAccommodation accommodationR;
    @Autowired
    private IImageRepo imageRepo;

    @Transactional
    @Override
    public Accommodation save(Accommodation accommodation) {
        return accommodationR.save(accommodation);
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationR.findAll();
    }

    @Override
    public Accommodation findById(Integer id) {
        return accommodationR.findById(id).orElse(null);
    }
}
