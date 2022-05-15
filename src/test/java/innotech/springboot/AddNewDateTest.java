package innotech.springboot;

import innotech.springboot.controller.DateController;
import innotech.springboot.dto.DateDTO;
import innotech.springboot.dto.DatesDTO;
import innotech.springboot.model.Date;
import innotech.springboot.repository.DateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AddNewDateTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    DateController dateController;
    @Autowired
    DateRepository dateRepository;

    @Test
    public void addNewDateTest_ok() throws Exception {
        long countBefore = dateRepository.count();
        LocalDate localDate = LocalDate.parse("06.10.1998", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        DateDTO testDate = new DateDTO(localDate);

        dateController.addDate(testDate);

        List<Date> datesList= dateRepository.findAll();
        int countAfter = datesList.size();
        Date addedDate = datesList.get(datesList.size()-1);

        Assertions.assertEquals(countBefore + 1, countAfter);
        Assertions.assertTrue(testDate.equals(addedDate));
    }

    String requestBody =
            "{\n" +
            "    \"date\": \"%s\"\n" +
            "}";

    @Test
    public void addNewDateTests_request_ok() throws Exception {
        this.mockMvc.perform(post("/date/add")
            .contentType(MediaType.APPLICATION_JSON)
            .content(String.format(requestBody, "01.01.2000")))
        .andExpect(status().isOk());
    }

    @Test
    public void addNewDateTests_request_wrong_format() throws Exception {
        this.mockMvc.perform(post("/date/add")
            .contentType(MediaType.APPLICATION_JSON)
            .content(String.format(requestBody, "1.1.2000")))
        .andExpect(status().isBadRequest());
    }
}
