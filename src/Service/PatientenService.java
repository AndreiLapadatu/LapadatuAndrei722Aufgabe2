package Service;

import Model.Medikamente;
import Model.Patienten;
import Repository.PatientenRepository;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Patienten>filterClientsByKrank(String krank) {
        return getAllPatienten().stream().filter(client -> client.getDiagnose().equalsIgnoreCase(krank)).collect(Collectors.toList());

    }


    public List<Medikamente>sortPatientenMedikamente(Integer clientId, boolean ascending){
        Patienten client = patientenRepository.get(clientId);
        if(client == null)
            return List.of();

        return client.getMedikamenteList().stream().sorted((p1,p2)->ascending ?
                p1.getName().compareTo(p2.getName()) :
                p2.getName().compareTo(p1.getName())).collect(Collectors.toList());
    }
}
