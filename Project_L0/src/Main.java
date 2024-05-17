import Model.Human;
import Model.Student;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = -1;

        while (x != 0) {
            System.out.println("===============MENU==============");
            System.out.println("1.Program Static Student");
            System.out.println("2.Program Student");
            System.out.println("0. Exit");

            x = scanner.nextInt();

            switch (x) {
                case 1:
                    programStaticStudent();
                    break;
                case 2:
                    programStudent();
                    break;
                case 0:
                    System.out.println("System Close !! ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    public static void programStaticStudent() {
        Scanner scanner = new Scanner(System.in);
        ProgramStaticStudent programStaticStudent = new ProgramStaticStudent();
        int x = -1;

        while (x != 0) {
            System.out.println(" PLEASE SELECT OPTION !!");
            System.out.println("==========MENU==========");
            System.out.println("1. Create Student");
            System.out.println("2. Info ALL Student");
            System.out.println("3. Find info student by id");
            System.out.println("4. Delete student by id");
            System.out.println("5. Update student by id");
            System.out.println("0. Close");
            x = scanner.nextInt();

            switch (x) {
                case 1:
                    programStaticStudent.createStudent();
                    break;
                case 2:
                    programStaticStudent.infoAllStudent();
                    break;
                case 3:
                    programStaticStudent.infoStudentWithId();
                    break;
                case 4:
                    programStaticStudent.deleteById();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Please choose option correct !");
            }
        }
    }

    public static void programStudent() {
        Scanner scanner = new Scanner(System.in);
        ProgramStudent programStudent = new ProgramStudent();
        int x = -1;

        while (x != 0) {
            System.out.println(" PLEASE SELECT OPTION !!");
            System.out.println("==========MENU==========");
            System.out.println("1. Create Student");
            System.out.println("2. Show info all student");
            System.out.println("3. Delete Student by ID");
            System.out.println("0. Close");
            x = scanner.nextInt();

            switch (x) {
                case 1 : programStudent.createStudent();
                    break;
                case 2 :programStudent.infoAllStudent();
                    break;
                case 3 : programStudent.deleteById();
                    break;
            }
        }
    }

}
