package model;

import java.time.format.DateTimeFormatter;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DateTime {

    private LocalDateTime currentDateTime;
    private final String date;
    private final String time;

    public DateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        date = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy년mm월dd일"));
        time = currentDateTime.format(DateTimeFormatter.ofPattern("HH시mm분"));
    }

}
