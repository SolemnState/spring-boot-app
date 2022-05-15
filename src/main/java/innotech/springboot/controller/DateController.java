package innotech.springboot.controller;

import innotech.springboot.dto.DateDTO;
import innotech.springboot.dto.DatesDTO;
import innotech.springboot.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/date")
public class DateController {
    @Autowired
    DateService dateService;

    @GetMapping(path = "/current", produces = "application/json")
    public DateDTO getCurrentDate() {
        return dateService.currentDate();
    }

    @GetMapping(path = "/all", produces = "application/json")
    public DatesDTO getAllDatess() {
       List<DateDTO> list = dateService.findAll();
       return new DatesDTO(list);
    }

    @PostMapping(path = "/add", consumes = "application/json")
    public void addDate(@RequestBody DateDTO date) {
        dateService.addNewDate(date);
    }

}
