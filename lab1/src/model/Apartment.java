package model;

public class Apartment {
    private int id;
    private String address;
    private double rentPrice;

    public Apartment(int id, String address, double rentPrice) {
        this.id = id;
        this.address = address;
        this.rentPrice = rentPrice;
    }

    public int getId() { return id; }
    public String getAddress() { return address; }
    public double getRentPrice() { return rentPrice; }

    @Override
    public String toString() {
        return "Квартира{" +
                "id=" + id +
                ", адрес='" + address + '\'' +
                ", цена=" + rentPrice +
                '}';
    }
}