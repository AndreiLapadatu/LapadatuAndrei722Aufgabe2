package Repository;

import Model.Patienten;

import java.util.ArrayList;
import java.util.List;

public class PatientenRepository {

    List<Patienten> patienten = new ArrayList<>();

    public void add(Patienten patient) {
        patienten.add(patient);
    }

    public void update(Patienten patient) {
        for(int i = 0; i < patienten.size(); i++) {
            if(patienten.get(i).getId() == patient.getId()) {
                patienten.set(i, patient);
                return;
            }
        }
    }

    public void remove(Integer id) {
        patienten.removeIf(p -> p.getId() == id);
    }

    public Patienten get(int id) {
        return patienten.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public List<Patienten>getAllPatienten() {
        return new ArrayList<>(patienten);
    }


}
