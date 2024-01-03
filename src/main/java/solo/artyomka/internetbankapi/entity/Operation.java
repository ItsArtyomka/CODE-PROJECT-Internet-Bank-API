package solo.artyomka.internetbankapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "operations", schema = "public")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "account_id")
    private Long account_id;
    @Column(name = "operation")
    private int operation;
    @Column(name = "amount")
    private Long amount;
}
