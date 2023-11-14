package com.dockseeker.prescription.api;

import com.dockseeker.prescription.domain.model.entity.PrescriptionRecord;
import com.dockseeker.prescription.domain.service.PrescriptionRecordService;
import com.dockseeker.prescription.mapping.PrescriptionRecordMapper;
import com.dockseeker.prescription.resource.CreatePrescriptionRecordResource;
import com.dockseeker.prescription.resource.PrescriptionRecordResource;
import com.dockseeker.prescription.resource.UpdatePrescriptionRecordResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/prescriptions")
public class PrescriptionRecordController {

    private PrescriptionRecordService prescriptionRecordService;
    private PrescriptionRecordMapper mapper;

    public PrescriptionRecordController(PrescriptionRecordService prescriptionRecordService, PrescriptionRecordMapper mapper) {
        this.prescriptionRecordService = prescriptionRecordService;
        this.mapper = mapper;
    }

    @GetMapping("")
    public ResponseEntity<List<PrescriptionRecord>> fetchAll() {
        return ResponseEntity.ok(prescriptionRecordService.getAll());
    }

    // get by id
    @GetMapping("{id}")
    public ResponseEntity<PrescriptionRecordResource> fetchId(@PathVariable Integer id) {
        if (prescriptionRecordService.getById(id).isPresent()) {
            PrescriptionRecordResource prescriptionRecordResource = this.mapper.toResource(prescriptionRecordService.getById(id).get());
            return ResponseEntity.ok(prescriptionRecordResource);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("")
    public ResponseEntity<PrescriptionRecordResource> save(@RequestBody CreatePrescriptionRecordResource resource) {
        return ResponseEntity.ok(mapper.toResource(prescriptionRecordService.save(mapper.toModel(resource))));
    }

    @PutMapping("{id}")
    public ResponseEntity<PrescriptionRecordResource> update(@PathVariable Integer id, @RequestBody UpdatePrescriptionRecordResource resource) {
        if (id.equals(resource.getId())) {
            PrescriptionRecordResource prescriptionRecordResource =
                    mapper.toResource(
                            prescriptionRecordService.update(
                                    mapper.toModel(resource)
                            )
                    );
            return ResponseEntity.ok(prescriptionRecordResource);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (prescriptionRecordService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
