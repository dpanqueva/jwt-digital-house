package com.dh.bd.test.ms.bd.test.controller;

import com.dh.bd.test.ms.bd.test.model.dto.ImageDTO;
import com.dh.bd.test.ms.bd.test.model.dto.TestImgDTO;
import com.dh.bd.test.ms.bd.test.service.IAccommodationService;
import com.dh.bd.test.ms.bd.test.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ControllerAcc {

    @Autowired
    private IAccommodationService accommodationService;

    @Autowired
    private IImageService imageService;

    @GetMapping("/listAcc")
    public ResponseEntity<?> listA() {
        Map response = new HashMap<>();

        response.put("respuesta", accommodationService.findAll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> listA(@PathVariable Integer id) {
        Map response = new HashMap<>();

        response.put("respuesta", accommodationService.findById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //@Secured("ROLE_ADMIN")
    @PostMapping("/create-test")
    public ResponseEntity<?> createTest(@RequestBody TestImgDTO testImgDTO) {
        Map response = new HashMap<>();

        response.put("respuesta", testImgDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //@Secured("ROLE_USER")
    @PostMapping("/create-image")
    public ResponseEntity<?> createTestImage(@RequestBody ImageDTO testImgDTO) {
        Map response = new HashMap<>();

        response.put("respuesta", testImgDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
