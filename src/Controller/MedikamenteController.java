package Controller;

import Model.Medikamente;
import Service.MedikamentenService;

import java.util.List;

public class MedikamenteController {

    private MedikamentenService medikamentenService;


    public MedikamenteController(MedikamentenService medikamentenService) {
        this.medikamentenService = medikamentenService;
    }

    public void addMedikament(String name, int price, String krank) {
        Medikamente medikament = new Medikamente(name, price, krank);
        medikamentenService.addMedikament(medikament);
    }

    public void updateMedikament(String name, int price, String krank) {
         Medikamente medikament = new Medikamente(name, price, krank);
         medikamentenService.updateMedikament(medikament);
    }

    public void deleteMedikament(String name) {
        medikamentenService.removeMedikament(name);
    }

    public Medikamente getMedikament(String name) {
        return medikamentenService.getMedikament(name);
    }

    public List<Medikamente> getAllMedikamente() {
        return medikamentenService.getAllMedikamente();
    }
}
