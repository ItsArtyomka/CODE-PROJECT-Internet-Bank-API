package solo.artyomka.internetbankapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/*
 * JPA Account entity that represents the 'operations' tables.
 */

@Getter
@Setter
@Entity
@Table(name = "operations", schema = "public")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "operation")
    private int operation;

    @Column(name = "amount")
    private Long amount;

    private Date date;
}
