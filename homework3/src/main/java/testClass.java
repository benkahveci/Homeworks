import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.course.Course;
import model.instructor.Instructor;
import model.instructor.VisitingResearcher;
import model.instructor.permenantInstructor;
import model.student.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class testClass {

    public static void main(String[] args) {


       Instructor instructor1 = new VisitingResearcher("Batuhan Kahvecioğlu", "Örnek Mh", "5555055", 12500.0);
       Instructor instructor2 = new VisitingResearcher("Batuhan Kava", "Ataşehir", "5555055", 12500.5);

       Instructor instructor3 = new permenantInstructor("ZH", "İstanbul", "2412412", 44444.0);
       Instructor instructor4 = new permenantInstructor("ZHsad", "İstanbulsadsa", "2412412213", 444445.0);

       List<Instructor> instructorList = new ArrayList<>();
       instructorList.add(instructor1);
       instructorList.add(instructor2);
       instructorList.add(instructor3);
       instructorList.add(instructor4);


       Course course1 = new Course("Political History", 301, 5);
       Course course2 = new Course("Political Economy", 401, 5);
       Course course3 = new Course("Political Psychology", 501, 5);
       Course course5 = new Course("Economic Psychology", 521, 5);
       Course course6 = new Course("Historical Psychology", 551, 5);

       course1.setInstructor(instructor1);
       course2.setInstructor(instructor2);
       course3.setInstructor(instructor3);
       course5.setInstructor(instructor4);
       course6.setInstructor(instructor4);

       List<Course> courseList = new ArrayList<>();

       courseList.add(course1);
       courseList.add(course2);
        courseList.add(course3);
        courseList.add(course5);
        courseList.add(course6);




        Student student1 = new Student("Enver K", LocalDate.of(2001, Month.APRIL, 22),"asda", "Male");
       Student student2 = new Student("Enver Kasda",  LocalDate.of(1993, Month.JANUARY, 31),"asasfda", "Masdale");
       Student student3 = new Student("Easdasnver K",  LocalDate.of(1887, Month.AUGUST, 22), "asafsda", "Maasdle");

       List<Student> studentList = new ArrayList<>();
       studentList.add(student1);
       studentList.add(student2);
       studentList.add(student3);

       List<Student> course1studentYoklama = new ArrayList<>();

       course1studentYoklama.add(student1);
       course1studentYoklama.add(student2);

       course1.setStudentYoklama(course1studentYoklama);

       EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
       EntityManager entityManager = emf.createEntityManager();



       Instructor.saveInstructor(instructorList, entityManager);

       Course.saveCourses(courseList, entityManager);

       Student.saveStudent(studentList, entityManager);

    }


}
