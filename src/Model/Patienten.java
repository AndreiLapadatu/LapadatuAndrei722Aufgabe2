package Model;
import java.util.ArrayList;
import java.util.List;

public class Patienten {
    private int id;
    private String name;
    private int age;
    private String diagnose;
    private List<Medikamente> medikamenteList;

    public Patienten(int id, String name, int age,String diagnose) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.diagnose = diagnose;
        this.medikamenteList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public List<Medikamente> getMedikamenteList() {
        return medikamenteList;
    }

    public void setMedikamenteList(List<Medikamente> medikamenteList) {
        this.medikamenteList = medikamenteList;
    }


    public void addMedikament(Medikamente medikament) {
        this.medikamenteList.add(medikament);
    }


    @Override
    public String toString() {
        return "Patienten{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", diagnose='" + diagnose + '\'' +
                ", medikamenteList=" + medikamenteList +
                '}';
    }
}


