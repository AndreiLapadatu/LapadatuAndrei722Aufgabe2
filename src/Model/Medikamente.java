package Model;

public class Medikamente {
    private String name;
    private int price;
    private String krankenheit;

    public Medikamente(String name, int price, String krankenheit) {
        this.name = name;
        this.price = price;
        this.krankenheit = krankenheit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getKrankenheit() {
        return krankenheit;
    }

    @Override
    public String toString() {
        return "Medikamente{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", krankenheit='" + krankenheit + '\'' +
                '}';
    }

    public void setKrankenheit(String krankenheit) {
        this.krankenheit = krankenheit;
    }
}
