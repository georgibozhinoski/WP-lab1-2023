package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Production {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String country;
    private String address;
    public Production(String name, String country, String address) {
        this.id=(long) (Math.random() * 1000);
        this.name = name;
        this.country = country;
        this.address = address;
    }

    public Production() {

    }
}