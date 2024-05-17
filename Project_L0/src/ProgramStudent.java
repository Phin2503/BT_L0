import Model.Human;
import Model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class ProgramStudent {
    private static Scanner scanner = new Scanner(System.in);
    private static LinkedList<Student> studentLinkedList = new LinkedList<>();


    static {
        studentLinkedList.add(new Student(1, "Student a", "25-03-2002", "16 Nguyen Hue", 180, 55, "20IT112", "VKU", "2002", 3.5));
        studentLinkedList.add(new Student(2, "Student b", "26-04-2002", "17 Nguyen Hue", 181, 56, "20IT113", "VKU", "2002", 3.6));
        studentLinkedList.add(new Student(3, "Student c", "27-05-2002", "18 Nguyen Hue", 182, 57, "20IT114", "VKU", "2002", 3.7));
        studentLinkedList.add(new Student(4, "Student d", "28-06-2002", "19 Nguyen Hue", 183, 58, "20IT115", "VKU", "2002", 3.8));
        studentLinkedList.add(new Student(5, "Student e", "29-07-2002", "20 Nguyen Hue", 184, 59, "20IT116", "VKU", "2002", 3.9));
    }

    static Constant constant = new Constant();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    public static void deleteById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input id: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            int indexFound = -1;

            for (int i = 0; i < studentLinkedList.size(); i++) {
                if (studentLinkedList.get(i).getId() == id) {
                    indexFound = i;
                    break;
                }
            }

            if (indexFound != -1) {
                studentLinkedList.remove(indexFound);
                System.out.println("Delete successfully");
            } else {
                System.out.println("No data found with the specified ID. Please try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer.");
        }
    }


    public static void infoAllStudent(){
        for (int i = 0; i < studentLinkedList.size() ; i++) {
            Student student = studentLinkedList.get(i);
            System.out.println("Info student " + (i + 1) + ":");
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Date of Birth: " + student.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            System.out.println("Address: " + student.getAddress());
            System.out.println("Height: " + student.getHeight());
            System.out.println("Weight: " + student.getWeight());
            System.out.println("Student Code: " + student.getStudentCode());
            System.out.println("Unviersity: " + student.getUniversityName());
            System.out.println("Year begins: " + student.getYearBegins());
            System.out.println("GPA: " + student.getGPA());
            System.out.println("----------------------------------");
        }
    }



    public static void createStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin sinh viên mới:");

        String name = promptForValidInput(scanner, "Input name student: ", "Invalid name. Name must be less than 100 characters and not null. Please try again.", ProgramStaticStudent::checkName);
        String dateOfBirth = promptForValidInput(scanner, "Input date of Birth (dd/MM/yyyy): ", "Invalid date of birth. Please follow the format dd/MM/yyyy and enter a valid date. Please try again.", ProgramStaticStudent::checkDateOfBirth);
        String address = promptForValidInput(scanner, "Input address: ", "Invalid address. Address must be less than " + constant.MAX_ADDRESS + " characters. Please try again.", ProgramStaticStudent::checkAddress);
        double height = promptForValidDouble(scanner, "Input height (cm): ", "Invalid height. Height must be between " + constant.MIN_HEIGHT + " and " + constant.MAX_HEIGHT + ". Please try again.", ProgramStaticStudent::checkHeight);
        double weight = promptForValidDouble(scanner, "Input weight (kg): ", "Invalid weight. Weight must be between " + constant.MIN_WEIGHT + " and " + constant.MAX_WEIGHT + ". Please try again.", ProgramStaticStudent::checkWeight);
        String studentCode = promptForValidInput(scanner, "Input student code: ", "Invalid student code OR student code available. Student code must be less than " + constant.MAX_STUDENT_CODE + " characters and not null. Please try again.", ProgramStaticStudent::checkStudentCode);
        String universityName = promptForValidInput(scanner, "Input University name: ", "Invalid university name. University name must be less than " + constant.MAX_NAME_SCHOOL + " characters and not null. Please try again.", ProgramStaticStudent::checkUniversityName);
        String yearBegins = promptForValidInput(scanner, "Input year begins: ", "Invalid year begins. Please follow the format yyyy and enter a valid year. Please try again.", ProgramStaticStudent::checkYearBegins);
        double gpa = promptForValidDouble(scanner, "Input GPA: ", "Invalid GPA. GPA must be between 0.0 and 10.0. Please try again.", ProgramStaticStudent::checkGpa);

        // Tạo đối tượng sinh viên mới và thêm vào danh sách
        Student newStudent = new Student(studentLinkedList.size() + 1,name, dateOfBirth, address, height, weight, studentCode, universityName, yearBegins, gpa);
        studentLinkedList.add(newStudent);

        System.out.println("Created Successfully!");
    }

    private static int promptForValidInt(Scanner scanner, String prompt, String errorMessage, Validator<Integer> validator) {
        int value;
        do {
            System.out.print(prompt);
            try {
                value = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(errorMessage);
                value = -1;
            } finally {
                scanner.nextLine(); // Đọc dòng mới để loại bỏ ký tự xuống dòng
            }
        } while (!validator.validate(value));
        return value;
    }
    private static String promptForValidInput(Scanner scanner, String prompt, String errorMessage, ProgramStudent.Validator<String> validator) {
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

    private static double promptForValidDouble(Scanner scanner, String prompt, String errorMessage, ProgramStudent.Validator<Double> validator) {
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




    private static LocalDate promptForValidDate(Scanner scanner,String prompt, String errorMessage, Validator<LocalDate> validator) {
        LocalDate date;
        do {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                date = LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println(errorMessage);
                date = null;
            }
        } while (!validator.validate(date));
        return date;
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
        for (Student st : studentLinkedList) {
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

    private static int promptForValidInt(String prompt, String errorMessage, Validator<Integer> validator) {
        int input;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println(errorMessage);
                System.out.print(prompt);
                scanner.next();
            }
            input = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (!validator.validate(input)) {
                System.out.println(errorMessage);
            }
        } while (!validator.validate(input));
        return input;
    }

    @FunctionalInterface
    interface Validator<T> {
        boolean validate(T input);
    }






}
