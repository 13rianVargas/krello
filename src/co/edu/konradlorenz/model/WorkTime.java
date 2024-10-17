package co.edu.konradlorenz.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public interface WorkTime {

    public final LocalTime HORA_INICIO = LocalTime.of(8, 0);
    public final LocalTime HORA_FIN = LocalTime.of(17, 0);

    abstract boolean isWorkTime(LocalDateTime dateTime);

}