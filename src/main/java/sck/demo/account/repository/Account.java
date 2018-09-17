package sck.demo.account.repository;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String accountNo;
    private String acccountName;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Customer owner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAcccountName() {
        return acccountName;
    }

    public void setAcccountName(String acccountName) {
        this.acccountName = acccountName;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
}
