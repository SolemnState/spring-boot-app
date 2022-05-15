package innotech.springboot;

import innotech.springboot.controller.DateController;
import innotech.springboot.dao.DateDAO;
import innotech.springboot.model.Date;
import innotech.springboot.model.Dates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
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

    @Test
    public void addNewDateTest_ok() throws Exception {
        int countBefore = DateDAO.getDatesList().getDateList().size();
        Date testDate = new Date(LocalDate.of(1998,10,6));

        dateController.addDate(testDate);

        Dates dates = DateDAO.getDatesList();
        List<Date> datesList = dates.getDateList();
        int countAfter = datesList.size();
        Date addedDate = datesList.get(datesList.size() - 1);

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
        .andExpect(status().isCreated());
    }

    @Test
    public void addNewDateTests_request_wrong_format() throws Exception {
        this.mockMvc.perform(post("/date/add")
            .contentType(MediaType.APPLICATION_JSON)
            .content(String.format(requestBody, "1.1.2000")))
        .andExpect(status().isBadRequest());
    }
}
