package com.dockseeker.prescription.cucumberglue;

import com.dockseeker.prescription.api.PrescriptionRecordController;
import com.dockseeker.prescription.domain.model.entity.PrescriptionRecord;
import com.dockseeker.prescription.resource.CreatePrescriptionRecordResource;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private PrescriptionRecordController prescriptionRecordController;

    public StepDefinitions(PrescriptionRecordController prescriptionRecordController) {
        this.prescriptionRecordController = prescriptionRecordController;
    }

    @When("the user clicks on the appointment")
    public void userClicksAppointment() {
        CreatePrescriptionRecordResource resource1 = new CreatePrescriptionRecordResource(1, 1,
                "Paracetamol", "1 dose per day", "1 week", "2021-01-01");
        CreatePrescriptionRecordResource resource2 = new CreatePrescriptionRecordResource(1, 2,
                "Vitapyrena Forte Antigripal", "1 dose per day", "3 days", "2022-07-23");

        Integer responseCode1 = prescriptionRecordController.save(resource1).getStatusCode().value();
        Integer responseCode2 = prescriptionRecordController.save(resource2).getStatusCode().value();

        assertEquals(200, responseCode1);
        assertEquals(200, responseCode2);
    }

    @Then("the user is shown all the prescriptions made by the doctor in that appointment")
    public void UserIsShownPrescriptions() {
        List<PrescriptionRecord>  prescriptions = prescriptionRecordController.fetchAll().getBody();
        for (PrescriptionRecord prescription : prescriptions) {
            assertEquals(1, prescription.getPatientId());
        }
    }

}
