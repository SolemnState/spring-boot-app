package innotech.springboot;

import innotech.springboot.controller.DateController;
import innotech.springboot.dto.DateDTO;
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
        DateDTO testDate =  new DateDTO(Instant.now().atZone(
                ZoneId.of("UTC")
        ).toLocalDate());

        DateDTO currentDate = dateController.getCurrentDate();

        assertTrue(testDate.equals(currentDate));
    }
}
