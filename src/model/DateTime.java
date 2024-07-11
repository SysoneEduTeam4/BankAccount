package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Getter;

@Getter
public class DateTime {

    private final String date;
    private final String time;

    public DateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH시mm분");
        this.date = currentDateTime.format(dateFormat);
        this.time = currentDateTime.format(timeFormat);
    }
}
