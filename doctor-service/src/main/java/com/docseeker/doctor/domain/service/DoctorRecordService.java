package com.docseeker.doctor.domain.service;

import com.docseeker.doctor.domain.model.entity.DoctorRecord;

import java.util.List;
import java.util.Optional;

public interface DoctorRecordService {
    List<DoctorRecord> getAll();
    Optional<DoctorRecord> getById(Integer id);
    Optional<DoctorRecord> getByDniAndPassword(String dni, String password);
    DoctorRecord save(DoctorRecord doctorRecord);
    DoctorRecord update(DoctorRecord doctorRecord);
    boolean deleteById(Integer id);
}
