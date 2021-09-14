package com.example.DTODemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DTODemo.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
