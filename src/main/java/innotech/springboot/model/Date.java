package innotech.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;


import java.time.LocalDate;

@Data
@Builder
public class Date {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @NonNull
    private LocalDate date;

    public Date() { }

    public Date(String dateString) {
        this.date = LocalDate.parse(dateString);
    }

    public Date(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Date{" +
                "date='" + date + '\'' +
                '}';
    }

    public Boolean equals(Date date) {
        return this.date.isEqual(date.getDate());
    }
}
