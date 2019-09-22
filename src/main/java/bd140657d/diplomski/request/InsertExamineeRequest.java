package bd140657d.diplomski.request;

import java.util.Calendar;

import lombok.Data;

@Data
public class InsertExamineeRequest implements Request{
  
  private String name;
  private String surname;
  private String parentsName;
  private String comment;
  private Calendar date;
  private Integer age;
  private Long study;
  private Long group;

}
