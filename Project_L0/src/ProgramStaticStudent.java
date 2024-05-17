import Model.Human;
import Model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ProgramStaticStudent {
    static Constant constant = new Constant();
    static Scanner scanner = new Scanner(System.in);

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    static Student[] arrStudent = new Student[5];
    static {
        arrStudent = new Student[5];
        arrStudent[0] = new Student(1, "Student a", "25-03-2002", "16 Nguyen Hue", 180, 55, "20IT112", "VKU", "2002", 3.5);
        arrStudent[1] = new Student(2, "Student b", "26-04-2002", "17 Nguyen Hue", 181, 56, "20IT113", "VKU", "2002", 3.6);
        arrStudent[2] = new Student(3, "Student c", "27-05-2002", "18 Nguyen Hue", 182, 57, "20IT114", "VKU", "2002", 3.7);
        arrStudent[3] = new Student(4, "Student d", "28-06-2002", "19 Nguyen Hue", 183, 58, "20IT115", "VKU", "2002", 3.8);
        arrStudent[4] = new Student(5, "Student e", "29-07-2002", "20 Nguyen Hue", 184, 59, "20IT116", "VKU", "2002", 3.9);
    }


    public static void deleteById(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input id : ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            int Idfinded = -1;

            if(id <= arrStudent.length && id >= 0) {
                for(Student st : arrStudent) {
                    if(st.getId() == id) {
                        Idfinded = id - 1;
                    }
                }

                if(Idfinded != -1 ) {
                    Student[] newArrStudent = new Student[arrStudent.length - 1];
                    int newIndex = 0;
                    for (int i = 0; i < arrStudent.length ; i++) {
                        if (i != Idfinded) {
                            newArrStudent[newIndex] = arrStudent[i];
                            newIndex++;
                        }
                    }
                    arrStudent = newArrStudent;
                    System.out.println("Delete successfully");
                }
            }else {
                System.out.println("Not find data suitable !! Please try again");
            }
        } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid integer.");
        }
    }

    public static void infoAllStudent() {
        for (int i = 0; i < arrStudent.length ; i++) {
            Student student = arrStudent[i];
            System.out.println("Thông tin học sinh " + (i + 1) + ":");
            System.out.println("ID: " + student.getId());
            System.out.println("Tên: " + student.getName());
            System.out.println("Ngày sinh: " + student.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            System.out.println("Địa chỉ: " + student.getAddress());
            System.out.println("Chiều cao: " + student.getHeight());
            System.out.println("Cân nặng: " + student.getWeight());
            System.out.println("Mã sinh viên: " + student.getStudentCode());
            System.out.println("Trường: " + student.getUniversityName());
            System.out.println("Năm bắt đầu học: " + student.getYearBegins());
            System.out.println("Điểm trung bình: " + student.getGPA());
            System.out.println("----------------------------------");
        }
    }

    public static void infoStudentWithId() {
        System.out.println("Input ID student need get info : ");
        int id = new Scanner(System.in).nextInt();
        int findedID = -1;
        for(int i = 0 ; i < arrStudent.length ; i++){
            if(arrStudent[i].getId() == id) {
                findedID = i;
            }
        }
        if(findedID == -1){
            System.out.println("Not find data suitable !! Please try again");
        }else {
            System.out.println("Information student " + (id) + ":");
            System.out.println("ID: " + arrStudent[findedID].getId());
            System.out.println("Name: " + arrStudent[findedID].getName());
            System.out.println("Date of Birth: " + arrStudent[findedID].getDateOfBirth());
            System.out.println("Address: " + arrStudent[findedID].getAddress());
            System.out.println("Height: " + arrStudent[findedID].getHeight());
            System.out.println("Weight: " + arrStudent[findedID].getWeight());
            System.out.println("Student ID: " + arrStudent[findedID].getStudentCode());
            System.out.println("University: " + arrStudent[findedID].getUniversityName());
            System.out.println("Year begins: " + arrStudent[findedID].getYearBegins());
            System.out.println("GPA: " + arrStudent[findedID].getGPA());
            System.out.println("----------------------------------");
        }
    }


    public static void createStudent() {
        Scanner scanner = new Scanner(System.in);

        String name = promptForValidInput(scanner, "Input name student: ", "Invalid name. Name must be less than 100 characters and not null. Please try again.", ProgramStaticStudent::checkName);
        String dateOfBirth = promptForValidInput(scanner, "Input date of Birth (dd/MM/yyyy): ", "Invalid date of birth. Please follow the format dd/MM/yyyy and enter a valid date. Please try again.", ProgramStaticStudent::checkDateOfBirth);
        String address = promptForValidInput(scanner, "Input address: ", "Invalid address. Address must be less than " + constant.MAX_ADDRESS + " characters. Please try again.", ProgramStaticStudent::checkAddress);
        double height = promptForValidDouble(scanner, "Input height (cm): ", "Invalid height. Height must be between " + constant.MIN_HEIGHT + " and " + constant.MAX_HEIGHT + ". Please try again.", ProgramStaticStudent::checkHeight);
        double weight = promptForValidDouble(scanner, "Input weight (kg): ", "Invalid weight. Weight must be between " + constant.MIN_WEIGHT + " and " + constant.MAX_WEIGHT + ". Please try again.", ProgramStaticStudent::checkWeight);
        String studentCode = promptForValidInput(scanner, "Input student code: ", "Invalid student code OR student code available. Student code must be less than " + constant.MAX_STUDENT_CODE + " characters and not null. Please try again.", ProgramStaticStudent::checkStudentCode);
        String universityName = promptForValidInput(scanner, "Input University name: ", "Invalid university name. University name must be less than " + constant.MAX_NAME_SCHOOL + " characters and not null. Please try again.", ProgramStaticStudent::checkUniversityName);
        String yearBegins = promptForValidInput(scanner, "Input year begins: ", "Invalid year begins. Please follow the format yyyy and enter a valid year. Please try again.", ProgramStaticStudent::checkYearBegins);
        double gpa = promptForValidDouble(scanner, "Input GPA: ", "Invalid GPA. GPA must be between 0.0 and 10.0. Please try again.", ProgramStaticStudent::checkGpa);

        // Create a new Student object and add it to the array
        int newSize = arrStudent.length + 1;
        Student[] newArrStudent = new Student[newSize];
        System.arraycopy(arrStudent, 0, newArrStudent, 0, arrStudent.length);
        newArrStudent[arrStudent.length] = new Student(arrStudent.length + 1, name, dateOfBirth, address, height, weight, studentCode, universityName, yearBegins, gpa);
        arrStudent = newArrStudent;

        System.out.println("Student created successfully!");
    }

    private static String promptForValidInput(Scanner scanner, String prompt, String errorMessage, Validator<String> validator) {
        String input;
        do {
            System.out.println(prompt);
            input = scanner.nextLine();
            if (!validator.validate(input)) {
                System.out.println(errorMessage);
            }
        } while (!validator.validate(input));
        return input;
    }

    private static double promptForValidDouble(Scanner scanner, String prompt, String errorMessage, Validator<Double> validator) {
        double input;
        do {
            System.out.println(prompt);
            while (!scanner.hasNextDouble()) {
                System.out.println(errorMessage);
                System.out.println(prompt);
                scanner.next();
            }
            input = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
            if (!validator.validate(input)) {
                System.out.println(errorMessage);
            }
        } while (!validator.validate(input));
        return input;
    }

    public static boolean checkName(String name) {
        return name != null && name.length() > 0 && name.length() <= constant.MAX_NAME;
    }

    public static boolean checkDateOfBirth(String dateOfBirth){
        if (dateOfBirth == null || dateOfBirth.isEmpty()) {
            return false;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);

        try {
            Date parsedDate = dateFormat.parse(dateOfBirth);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parsedDate);

            int year = calendar.get(Calendar.YEAR);
            if(year >= constant.MIN_YEAR && year <= constant.MAX_YEAR.getYear() ) {
                return true;
            }
        } catch (ParseException e) {

        }

        return false;
    }


    public static boolean checkAddress(String address) {
        return address != null && address.length() <= constant.MAX_ADDRESS;
    }

    public static boolean checkHeight(double height) {
        return height >= constant.MIN_HEIGHT && height <= constant.MAX_HEIGHT;
    }

    public static boolean checkWeight(double weight) {
        return weight >= constant.MIN_WEIGHT && weight <= constant.MAX_WEIGHT;
    }

    public static boolean checkStudentCode(String studentCode) {
        if (studentCode == null || studentCode.length() == 0 || studentCode.length() > constant.MAX_STUDENT_CODE) {
            return false;
        }
        for (Student st : arrStudent) {
            if (st.getStudentCode().equals(studentCode)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkUniversityName(String universityName) {
        return universityName != null && universityName.length() > 0 && universityName.length() <= constant.MAX_NAME;
    }

    public static boolean checkYearBegins(String yearBegins) {
        if (yearBegins == null || yearBegins.length() != 4) {
            return false;
        }
        try {
            int year = Integer.parseInt(yearBegins);
            return year >= 1900 && year <= Calendar.getInstance().get(Calendar.YEAR);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean checkGpa(double gpa) {
        return gpa >= 0.0 && gpa <= 10.0;
    }

    @FunctionalInterface
    interface Validator<T> {
        boolean validate(T input);
    }





}
