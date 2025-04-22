package com.voltlife.backend.repository;

import com.voltlife.backend.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Long> {
    @Query("SELECT h FROM House h JOIN h.users hu WHERE hu.user.id = :userId")
    List<House> findByUserId(Long userId);
}
