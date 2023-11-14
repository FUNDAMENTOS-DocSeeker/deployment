package com.dockseeker.prescription.mapping;

import com.dockseeker.prescription.domain.model.entity.PrescriptionRecord;
import com.dockseeker.prescription.resource.CreatePrescriptionRecordResource;
import com.dockseeker.prescription.resource.PrescriptionRecordResource;
import com.dockseeker.prescription.resource.UpdatePrescriptionRecordResource;
import com.dockseeker.prescription.shared.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PrescriptionRecordMapper {

    @Autowired
    EnhancedModelMapper mapper;

    public PrescriptionRecord toModel(CreatePrescriptionRecordResource resource) {
        return this.mapper.map(resource, PrescriptionRecord.class);
    }

    public PrescriptionRecord toModel(UpdatePrescriptionRecordResource resource) {
        return this.mapper.map(resource, PrescriptionRecord.class);
    }

    public PrescriptionRecordResource toResource(PrescriptionRecord prescriptionRecord) {
        return this.mapper.map(prescriptionRecord, PrescriptionRecordResource.class);
    }
}
