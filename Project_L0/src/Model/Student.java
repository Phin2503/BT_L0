package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formattable;

public class Student extends Human {
    private String studentCode;
    private String UniversityName;
    private String yearBegins;
    private double GPA;


    //Constructor
    public Student(int id, String name, String dateOfBirth, String address, double height, double weight) {
        super(id, name, dateOfBirth, address, height, weight);
    }

    public Student(int id, String name, String dateOfBirth, String address, double height, double weight, String studentCode, String universityName, String yearBegins, double GPA) {
        super(id, name, dateOfBirth, address, height, weight);
        this.studentCode = studentCode;
        UniversityName = universityName;
        this.yearBegins = yearBegins;
        this.GPA = GPA;
    }



    //Getter

    public String getStudentCode() {
        return studentCode;
    }

    public String getUniversityName() {
        return UniversityName;
    }

    public String getYearBegins() {
        return yearBegins;
    }

    public double getGPA() {
        return GPA;
    }

    //Setter


    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public void setUniversityName(String universityName) {
        UniversityName = universityName;
    }

    public void setYearBegins(String yearBegins) {
        this.yearBegins = yearBegins;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String toString() {
        return "Student Code: " + this.studentCode + "\n" + "University name : " + this.UniversityName + "\n" + "Year begins : " + this.yearBegins + "\n" + "GPA : " + this.GPA + "\n";
     }
}
