package com.example.magazine.repositories;

import com.example.magazine.entity.Magazine;
import com.example.magazine.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public interface MagazineRepository extends CrudRepository<Magazine, Long> {
    List<Magazine> findMagazineById(Long id);
    Long removeMagazineById(Long id);
}