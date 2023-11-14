package com.docseeker.doctor.api;

import com.docseeker.doctor.domain.model.entity.DoctorRecord;
import com.docseeker.doctor.domain.service.DoctorRecordService;
import com.docseeker.doctor.mapping.DoctorRecordMapper;
import com.docseeker.doctor.resource.CreateDoctorRecordResource;
import com.docseeker.doctor.resource.DoctorLoginResource;
import com.docseeker.doctor.resource.DoctorRecordResource;
import com.docseeker.doctor.resource.UpdateDoctorRecordResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/doctors")
@CrossOrigin()
public class DoctorRecordController {

    private DoctorRecordService doctorRecordService;
    private DoctorRecordMapper mapper;

    public DoctorRecordController(DoctorRecordService doctorRecordService, DoctorRecordMapper mapper) {
        this.doctorRecordService = doctorRecordService;
        this.mapper = mapper;
    }

    @GetMapping("")
    public ResponseEntity<List<DoctorRecord>> fetchAll() {
        return ResponseEntity.ok(doctorRecordService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<DoctorRecord> fetchId(@PathVariable Integer id) {
        if (doctorRecordService.getById(id).isPresent()) {
            DoctorRecord doctorRecord = doctorRecordService.getById(id).get();
            return ResponseEntity.ok(doctorRecord);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("")
    public ResponseEntity<DoctorRecordResource> save(@RequestBody CreateDoctorRecordResource resource) {
        return ResponseEntity.ok(mapper.toResource(doctorRecordService.save(mapper.toModel(resource))));
    }

    @PutMapping("{id}")
    public ResponseEntity<DoctorRecordResource> update(@PathVariable Integer id, @RequestBody UpdateDoctorRecordResource resource) {
        if (id.equals(resource.getId()) && doctorRecordService.getById(id).isPresent()) {
            DoctorRecordResource doctorResource = mapper.toResource(doctorRecordService.update(mapper.toModel(resource)));
            return ResponseEntity.ok(doctorResource);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (doctorRecordService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("login")
    public ResponseEntity<DoctorRecordResource> getDoctorByDNIAndPassword(@RequestBody DoctorLoginResource doctorLoginResource) {
        if (doctorRecordService.getByDniAndPassword(doctorLoginResource.getDni(), doctorLoginResource.getPassword()).isPresent()) {
            DoctorRecordResource doctor =
                    this.mapper.toResource(
                            doctorRecordService.getByDniAndPassword(
                                    doctorLoginResource.getDni(),
                                    doctorLoginResource.getPassword()
                            ).get()
                    );
            return ResponseEntity.ok(doctor);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
