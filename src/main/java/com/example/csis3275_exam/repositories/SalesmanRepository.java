package com.example.csis3275_exam.repositories;

import com.example.csis3275_exam.entities.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SalesmanRepository extends JpaRepository<Salesman, Long> {
    public void deleteById(Long id);
}
