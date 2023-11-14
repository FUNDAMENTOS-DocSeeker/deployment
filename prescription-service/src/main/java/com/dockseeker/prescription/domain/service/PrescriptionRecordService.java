package com.dockseeker.prescription.domain.service;

import com.dockseeker.prescription.domain.model.entity.PrescriptionRecord;

import java.util.List;
import java.util.Optional;

public interface PrescriptionRecordService {
    List<PrescriptionRecord> getAll();
    Optional<PrescriptionRecord> getById(Integer id);
    PrescriptionRecord save(PrescriptionRecord prescriptionRecord);
    PrescriptionRecord update(PrescriptionRecord prescriptionRecord);
    boolean deleteById(Integer id);
}
