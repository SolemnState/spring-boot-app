package innotech.springboot;

import innotech.springboot.controller.DateController;
import innotech.springboot.dto.DateDTO;
import innotech.springboot.dto.DatesDTO;
import innotech.springboot.model.Date;
import innotech.springboot.repository.DateRepository;
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
    DateRepository dateRepository;

    @Test
    public void getAllDates_ok() {
        long expectedCount = dateRepository.count();

        DatesDTO dates = dateController.getAllDates();
        int actualCount = dates.getDates().size();

        Assertions.assertEquals(expectedCount, actualCount);
    }

    @Test
    public void getAllDatesWithNew_ok() {
        dateController.addDate(new DateDTO(LocalDate.of(1998,10,6)));
        long expectedCount = dateRepository.count();

        DatesDTO dates = dateController.getAllDates();
        int actualCount = dates.getDates().size();

        Assertions.assertEquals(expectedCount, actualCount);
    }
}
