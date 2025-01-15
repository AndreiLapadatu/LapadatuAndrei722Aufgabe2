package Service;

import Model.Patienten;
import Repository.PatientenRepository;

import java.util.List;

public class PatientenService {
    private PatientenRepository patientenRepository;


    public PatientenService(PatientenRepository patientenRepository) {
        this.patientenRepository = patientenRepository;
    }

    public void addPatient(Patienten patient) {
        patientenRepository.add(patient);
    }

    public void updatePatient(Patienten patient) {
        patientenRepository.update(patient);
    }

    public void removePatient(Integer id) {
        patientenRepository.remove(id);
    }

    public Patienten getPatient(Integer id) {
        return patientenRepository.get(id);
    }

    public List<Patienten> getAllPatienten() {
        return patientenRepository.getAllPatienten();
    }
}
