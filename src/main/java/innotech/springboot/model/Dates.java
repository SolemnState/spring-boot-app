package innotech.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dates {

    private List<Date> dateList;

    public List<Date> getDateList() {
        if (dateList == null) {
            dateList = new ArrayList<>();
        }
        return dateList;
    }

}
