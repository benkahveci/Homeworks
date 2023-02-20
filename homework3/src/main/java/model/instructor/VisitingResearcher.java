package model.instructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class VisitingResearcher extends Instructor{

    private Double salaryPerCourse;

    public VisitingResearcher(String name, String address, String phoneNumber, Double salaryPerCourse) {
        super(name, address, phoneNumber);
        this.salaryPerCourse = salaryPerCourse;
    }
}
