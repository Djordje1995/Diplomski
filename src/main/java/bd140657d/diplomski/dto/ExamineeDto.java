package bd140657d.diplomski.dto;

import java.util.Calendar;

import lombok.Data;

@Data
public class ExamineeDto {
  String name;
  String surname;
  String parentsName;
  String group;
  Integer age;
  Calendar entryDate;
  String comment;
}
