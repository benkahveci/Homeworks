package model.instructor;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class permenantInstructor extends Instructor{

    private double salaryPerMonth;

    public permenantInstructor(String name, String address, String phoneNumber, double salaryPerMonth) {
        super(name, address, phoneNumber);
        this.salaryPerMonth = salaryPerMonth;
    }

}
