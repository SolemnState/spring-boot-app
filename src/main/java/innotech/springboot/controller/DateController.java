package innotech.springboot.controller;

import innotech.springboot.dao.DateDAO;
import innotech.springboot.dao.repository.DateRepository;
import innotech.springboot.model.Date;
import innotech.springboot.model.Dates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.Instant;
import java.time.ZoneId;


@RestController
@RequestMapping("/date")
public class DateController {

    @Autowired
    DateDAO dateDAO;

    @Autowired
    DateRepository dateRepository;

    @GetMapping(path = "/current", produces = "application/json")
    public Date currentDate() {
        return new Date(
                Instant.now().atZone(
                        ZoneId.of("UTC")
                ).toLocalDate());

    }

    @GetMapping(path = "/all", produces = "application/json")
    public Dates getAllDates() {
        return DateDAO.getDatesList();
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addDate(
            @RequestBody Date body
    ) {
        dateDAO.addDate(body);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping(path = "/test", consumes = "application/json")
    public @ResponseBody String testPost(@RequestBody Date body) {

        innotech.springboot.dao.entitiy.Date date = new innotech.springboot.dao.entitiy.Date();
        date.setValue(body.getDate().toString());
        dateRepository.save(date);
        return "Saved";
    }

}
