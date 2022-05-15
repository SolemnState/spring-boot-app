package innotech.springboot.service;

import innotech.springboot.dto.DateDTO;
import innotech.springboot.dto.mapper.DateMapper;
import innotech.springboot.model.Date;
import innotech.springboot.repository.DateRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DateService {
    private DateRepository dateRepository;
    private DateMapper dateMapper;


    public DateDTO currentDate() {
        return new DateDTO(
                Instant.now().atZone(
                        ZoneId.of("UTC")
                ).toLocalDate());

    }
    public List<DateDTO> findAll(){
        return dateRepository.findAll().stream().map(dateMapper::toDto).collect(Collectors.toList());
    }

    public void addNewDate(DateDTO date) {
        Date newDate = new Date();
        newDate.setValue(date.getDate()
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        dateRepository.save(newDate);
    }

}
