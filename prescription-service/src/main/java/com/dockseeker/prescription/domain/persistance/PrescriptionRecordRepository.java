package com.dockseeker.prescription.domain.persistance;

import com.dockseeker.prescription.domain.model.entity.PrescriptionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRecordRepository extends JpaRepository<PrescriptionRecord, Integer> {
}
