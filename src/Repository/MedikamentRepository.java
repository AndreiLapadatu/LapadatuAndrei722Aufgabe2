package Repository;

import Model.Medikamente;

import java.util.ArrayList;
import java.util.List;

public class MedikamentRepository {
    private List<Medikamente> medikamente = new ArrayList<>();



    public void add(Medikamente medikament) {
        medikamente.add(medikament);
    }


    public void update(Medikamente medikament) {
        for(int i = 0; i<medikamente.size(); i++){
            if(medikamente.get(i).getName().equals(medikament.getName())){
                medikamente.set(i, medikament);
                return;
            }
        }
    }

    public void remove(String name) {
        medikamente.removeIf(medikament -> medikament.getName().equals(name));
    }

    public Medikamente getMedikament(String name) {
        return medikamente.stream().filter(medikament -> medikament.getName().equals(name)).findFirst().orElse(null);
    }

    public List<Medikamente> getAllMedikamente() {
        return new ArrayList<>(medikamente);
    }
}
