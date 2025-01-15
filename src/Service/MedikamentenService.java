package Service;

import Model.Medikamente;
import Repository.MedikamentRepository;

import java.util.List;

public class MedikamentenService {


    private MedikamentRepository medikamentRepository;


    public MedikamentenService(MedikamentRepository medikamentRepository) {
        this.medikamentRepository = medikamentRepository;
    }

    public void addMedikament(Medikamente medikament) {
        medikamentRepository.add(medikament);
    }

    public void updateMedikament(Medikamente medikament) {
        medikamentRepository.update(medikament);
    }

    public void removeMedikament(String name) {
        medikamentRepository.remove(name);
    }

    public Medikamente getMedikament(String name) {
        return medikamentRepository.getMedikament(name);
    }

    public List<Medikamente> getAllMedikamente() {
        return medikamentRepository.getAllMedikamente();
    }
}
