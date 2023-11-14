package com.dockseeker.prescription.service;

import com.dockseeker.prescription.domain.model.entity.PrescriptionRecord;
import com.dockseeker.prescription.domain.persistance.PrescriptionRecordRepository;
import com.dockseeker.prescription.domain.service.PrescriptionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionRecordServiceImpl implements PrescriptionRecordService {

    @Autowired
    private PrescriptionRecordRepository prescriptionRecordRepository;

    @Transactional(readOnly = true)
    @Override
    public List<PrescriptionRecord> getAll() {
        return prescriptionRecordRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<PrescriptionRecord> getById(Integer id) {
        return prescriptionRecordRepository.findById(id);
    }

    @Transactional
    @Override
    public PrescriptionRecord save(PrescriptionRecord prescriptionRecord) {
        return prescriptionRecordRepository.save(prescriptionRecord);
    }

    @Transactional
    @Override
    public PrescriptionRecord update(PrescriptionRecord prescriptionRecord) {
        return prescriptionRecordRepository.save(prescriptionRecord);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if (prescriptionRecordRepository.existsById(id)) {
            prescriptionRecordRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
