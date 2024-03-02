import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int studentId;

    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }
}

class Course {
    private String courseName;
    private int courseId;
    private int capacity;
    private List<Student> enrolledStudents;

    public Course(String courseName, int courseId, int capacity) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean enrollStudent(Student student) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
            return true;
        } else {
            System.out.println("Course is full. Cannot enroll " + student.getName());
            return false;
        }
    }
}

class CourseRegistrationSystem {
    private List<Student> students;
    private List<Course> courses;

    public CourseRegistrationSystem() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course.getCourseId() + ". " + course.getCourseName() + " (Capacity: " + course.getCapacity() + ")");
        }
    }

    public static void main(String[] args) {
        CourseRegistrationSystem registrationSystem = new CourseRegistrationSystem();

        Student student1 = new Student("John Doe", 1);
        Student student2 = new Student("Jane Smith", 2);

        Course course1 = new Course("Introduction to Java", 101, 20);
        Course course2 = new Course("Data Structures", 201, 15);

        registrationSystem.addStudent(student1);
        registrationSystem.addStudent(student2);

        registrationSystem.addCourse(course1);
        registrationSystem.addCourse(course2);

        registrationSystem.displayCourses();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID to enroll in a course: ");
        int studentId = scanner.nextInt();

        System.out.print("Enter course ID to enroll in: ");
        int courseId = scanner.nextInt();

        Student selectedStudent = null;
        for (Student student : registrationSystem.students) {
            if (student.getStudentId() == studentId) {
                selectedStudent = student;
                break;
            }
        }

        if (selectedStudent == null) {
            System.out.println("Invalid student ID");
            return;
        }

        Course selectedCourse = null;
        for (Course course : registrationSystem.courses) {
            if (course.getCourseId() == courseId) {
                selectedCourse = course;
                break;
            }
        }

        if (selectedCourse == null) {
            System.out.println("Invalid course ID");
            return;
        }

        if (selectedCourse.enrollStudent(selectedStudent)) {
            System.out.println(selectedStudent.getName() + " enrolled in " + selectedCourse.getCourseName());
        }
    }
}
