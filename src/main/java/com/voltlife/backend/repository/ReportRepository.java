package com.voltlife.backend.repository;

import com.voltlife.backend.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByIdDspIn(List<String> idDsps);
}