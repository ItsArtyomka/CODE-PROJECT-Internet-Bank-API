package solo.artyomka.internetbankapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/*
 * JPA Account entity that represents the 'accounts' tables.
 */

@Getter
@Setter
@Entity
@Table(name = "accounts", schema = "public")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_holder_name")
    private String accountHolderName;

    @Column(name = "balance")
    private double balance;
}
