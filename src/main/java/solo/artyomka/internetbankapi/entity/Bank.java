package solo.artyomka.internetbankapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

// Data Model
@Component
@Entity
@Table(name = "bankDB")
@Data
public class Bank implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "balance")
    private Long balance;

    public Bank() {
        // Needed for the JPA.
    }

    public Bank(Long balance) {
        this.balance = balance;
    }

    // Lombok covers all the getters and setters.
}
