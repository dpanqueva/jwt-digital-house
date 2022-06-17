package com.dh.bd.test.ms.bd.test.repository;

import com.dh.bd.test.ms.bd.test.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccommodation extends JpaRepository<Accommodation, Integer> {
}
