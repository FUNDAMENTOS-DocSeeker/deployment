package com.docseeker.doctor.mapping;

import com.docseeker.doctor.domain.model.entity.DoctorRecord;
import com.docseeker.doctor.resource.CreateDoctorRecordResource;
import com.docseeker.doctor.resource.DoctorRecordResource;
import com.docseeker.doctor.resource.UpdateDoctorRecordResource;
import com.docseeker.doctor.shared.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class DoctorRecordMapper {

    @Autowired
    EnhancedModelMapper mapper;

    public DoctorRecord toModel(CreateDoctorRecordResource resource) {
        return this.mapper.map(resource, DoctorRecord.class);
    }

    public DoctorRecord toModel(UpdateDoctorRecordResource resource) {
        return this.mapper.map(resource, DoctorRecord.class);
    }

    public DoctorRecordResource toResource(DoctorRecord resource) {
        return this.mapper.map(resource, DoctorRecordResource.class);
    }
}
