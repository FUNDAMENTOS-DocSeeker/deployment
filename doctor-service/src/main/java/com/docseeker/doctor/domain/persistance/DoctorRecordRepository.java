package com.docseeker.doctor.domain.persistance;

import com.docseeker.doctor.domain.model.entity.DoctorRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRecordRepository extends JpaRepository<DoctorRecord, Integer> {
    Optional<DoctorRecord> findByDniAndPassword(String dni, String password);
}
