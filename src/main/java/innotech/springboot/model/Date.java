package innotech.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "date")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Date {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long date_id;
    @Column(nullable = false)
    private String value;
}
