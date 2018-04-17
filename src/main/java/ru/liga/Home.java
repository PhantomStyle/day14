package ru.liga;

public class Home {
    private String address;
    private String name;
    private Integer people;

    @Override
    public String toString() {
        return "Home{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", people=" + people +
                '}';
    }

    public Home() {
    }

    public Home(String address, String name, Integer people) {

        this.address = address;
        this.name = name;
        this.people = people;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }
}
