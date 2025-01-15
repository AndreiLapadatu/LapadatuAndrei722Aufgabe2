package Controller;

import Model.Medikamente;
import Model.Patienten;
import Service.MedikamentenService;
import Service.PatientenService;

import java.util.List;

public class PatientenController {

    PatientenService patientenService;


    public PatientenController(PatientenService patientenService) {
        this.patientenService = patientenService;
    }

    public void addPatient(int id, String name, int age,String diagnose) {
        Patienten patient = new Patienten(id, name, age,diagnose);
        patientenService.addPatient(patient);
    }


    public void updatePatient(int id, String name, int age,String diagnose) {
        Patienten patient = new Patienten(id, name, age,diagnose);
        patientenService.updatePatient(patient);
    }

    public void deletePatient(int id) {
        patientenService.removePatient(id);
    }

    public Patienten getPatient(int id) {
        return patientenService.getPatient(id);
    }

    public List<Patienten> getAllPatienten() {
        return patientenService.getAllPatienten();
    }

    public void addMedikamentToPatient(int customerId, Medikamente medikament) {
        Patienten patient = patientenService.getPatient(customerId);
        if (patient != null) {
            patient.addMedikament(medikament);
            patientenService.updatePatient(patient);
        }
    }

    public List<Patienten>filterClientsByKrank(String krank) {
        return patientenService.filterClientsByKrank(krank);
    }



    public List<Medikamente>sortPatientenMedikamente(Integer clientId, boolean ascending){
        return patientenService.sortPatientenMedikamente(clientId, ascending);
    }
}
