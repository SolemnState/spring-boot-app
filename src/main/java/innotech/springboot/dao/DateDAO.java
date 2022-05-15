package innotech.springboot.dao;

import innotech.springboot.model.Date;
import innotech.springboot.model.Dates;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class DateDAO {

    private static Dates datesList = new Dates();

    static {
        datesList.getDateList().add(new Date(LocalDate.of(2020,12,10)));
        datesList.getDateList().add(new Date(LocalDate.of(2021,10,14)));
        datesList.getDateList().add(new Date(LocalDate.of(2022, 5,10)));
    }

    public static Dates getDatesList() {
        return datesList;
    }

    public void addDate(Date date) {
        datesList.getDateList().add(date);
    }
}
