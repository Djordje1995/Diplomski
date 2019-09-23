package bd140657d.diplomski.dto;

import java.util.Calendar;

import lombok.Data;

@Data
public class ExtendedMeasurementDto {
  
  String name;
  String surname;
  Integer age;
  String task;
  Calendar time;
  String comment;
  
}
