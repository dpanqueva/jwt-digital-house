package com.dh.bd.test.ms.bd.test.service.view;

import com.dh.bd.test.ms.bd.test.model.view.AccommodationView;
import com.dh.bd.test.ms.bd.test.repository.view.IAccommodationViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewServiceImpl implements IVIewService{
    @Autowired
    private IAccommodationViewRepository accommodationViewRepository;

    @Override
    public AccommodationView findByTitle(String title) {
        return accommodationViewRepository.findByTitle(title);
    }
}
