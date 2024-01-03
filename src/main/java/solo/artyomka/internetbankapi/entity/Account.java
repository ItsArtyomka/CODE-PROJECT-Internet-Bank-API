package solo.artyomka.internetbankapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/*
 * JPA Account entity.
 */
@Getter
@Setter
@Entity
@Table(name = "account", schema = "public")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "account_holder_name")
    private String accountHolderName;

    @Column(name = "balance")
    private double balance;
}
