package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Human {
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private double height;
    private double weight;


    // Constructor


    public Human() {

    }

    public Human(int id, String name, String dateOfBirth, String address, double height, double weight) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.id = id;
        this.name = name;
        this.dateOfBirth = LocalDate.parse(dateOfBirth, dateTimeFormatter);
        this.address = address;
        this.height = height;
        this.weight = weight;
    }

    //Getter

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    //Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.dateOfBirth = birthDay;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public String toString(){
        return "id: " + this.id + "\n" + "name : " + this.name + "\n" + "address : " + this.address + "\n" + "Date of birth : " + this.dateOfBirth+ "\n" + "Weight : " + this.weight+ "\n" + "Height : " + this.height+ "\n" ;
    }
}
