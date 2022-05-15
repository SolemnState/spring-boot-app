package innotech.springboot.dao.entitiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Date {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer date_id;

    private String value;
}
