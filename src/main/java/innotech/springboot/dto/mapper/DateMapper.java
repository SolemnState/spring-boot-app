package innotech.springboot.dto.mapper;

import innotech.springboot.dto.DateDTO;
import innotech.springboot.model.Date;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DateMapper {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public DateDTO toDto(Date date){
        DateDTO dateDTO = new DateDTO();
        dateDTO.setDate(LocalDate.parse(date.getValue(), formatter));
        return dateDTO;
    }
}
