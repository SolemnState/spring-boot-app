package innotech.springboot;

import innotech.springboot.controller.DateController;
import innotech.springboot.model.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class GetCurrentDateTest {

    @Autowired
    DateController dateController;

    @Test
    public void getCurrentDate_ok() {
        Date testDate =  new Date(Instant.now().atZone(
                ZoneId.of("UTC")
        ).toLocalDate());

        Date currentDate = dateController.currentDate();

        assertTrue(testDate.equals(currentDate));
    }
}
