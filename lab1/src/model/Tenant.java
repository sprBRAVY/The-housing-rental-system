package model;

public class Tenant {
    private int id;
    private String name;

    public Tenant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Арендатор{" +
                "id=" + id +
                ", имя='" + name + '\'' +
                '}';
    }
}