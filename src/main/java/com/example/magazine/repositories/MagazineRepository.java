package com.example.magazine.repositories;

import com.example.magazine.entity.Magazine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public interface MagazineRepository extends CrudRepository<Magazine, Long> {
    Magazine findMagazineById(Long id);
    Long removeMagazineById(Long id);
    List<Magazine> findAll();
}
