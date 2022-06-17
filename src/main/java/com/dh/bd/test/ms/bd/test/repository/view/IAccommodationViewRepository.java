package com.dh.bd.test.ms.bd.test.repository.view;

import com.dh.bd.test.ms.bd.test.model.view.AccommodationView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccommodationViewRepository extends JpaRepository<AccommodationView,Integer> {
@Query(value = "select * from vw_accommodation_img",nativeQuery = true)
    public AccommodationView findByTitle(String title);
}
