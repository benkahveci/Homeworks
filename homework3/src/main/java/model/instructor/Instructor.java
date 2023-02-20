package model.instructor;

import jakarta.persistence.*;
import lombok.*;
import model.course.Course;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public abstract class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courseGiven = new ArrayList<>();

    public Instructor(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public static void saveInstructor(List<Instructor> instructorList, EntityManager entityManager) {
        for (Instructor instructor : instructorList) {
            entityManager.getTransaction().begin();
            entityManager.persist(instructor);
            entityManager.getTransaction().commit();
        }
    }

    public static void deleteInstructor(EntityManager entityManager, Instructor instructor) {
        entityManager.getTransaction().begin();
        // JPQL --> Java Persistence Query Language
        // HQL --> Hibernate Query Language
        Instructor foundInstructor = entityManager.createQuery
                        ("SELECT i FROM Instructor i WHERE i.name = :strName", Instructor.class)
                .setParameter("strName", instructor.getName())
                .getSingleResult();
        entityManager.remove(foundInstructor);

        entityManager.getTransaction().commit();
        System.out.println("Instructor deleted");
    }

    private static void findAllInstructors(EntityManager entityManager) {
        TypedQuery storeJpql = entityManager.createQuery("FROM Instructor i", Instructor.class);
        List<Instructor> instructorList = storeJpql.getResultList();

        for (Instructor instructor : instructorList) {
            System.out.println(instructor);
        }
    }
}
