package com.dh.bd.test.ms.bd.test.service;

import com.dh.bd.test.ms.bd.test.model.Image;
import com.dh.bd.test.ms.bd.test.repository.IImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements IImageService{

    @Autowired
    private IImageRepo imageRepo;

    @Override
    public Image save(Image image) {
        return imageRepo.save(image);
    }
}
