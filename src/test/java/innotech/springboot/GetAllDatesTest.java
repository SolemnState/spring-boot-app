package innotech.springboot;

import innotech.springboot.controller.DateController;
import innotech.springboot.dao.DateDAO;
import innotech.springboot.model.Date;
import innotech.springboot.model.Dates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class GetAllDatesTest {

    @Autowired
    DateController dateController;

    @Autowired
    DateDAO dao;

    @Test
    public void getAllDates_ok() {
        int expectedCount = DateDAO.getDatesList().getDateList().size();

        Dates dates = dateController.getAllDates();
        int actualCount = dates.getDateList().size();

        Assertions.assertEquals(expectedCount, actualCount);
    }

    @Test
    public void getAllDatesWithNew_ok() {
        DateDAO.getDatesList().getDateList().add(new Date(LocalDate.of(1998,10,6)));
        int expectedCount = DateDAO.getDatesList().getDateList().size();

        Dates dates = dateController.getAllDates();
        int actualCount = dates.getDateList().size();

        Assertions.assertEquals(expectedCount, actualCount);
    }
}
