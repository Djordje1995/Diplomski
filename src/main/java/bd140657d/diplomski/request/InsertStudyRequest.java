package bd140657d.diplomski.request;

import java.util.List;

import lombok.Data;

@Data
public class InsertStudyRequest implements Request{

  private String name;
  private List<String> tasks;
  private List<String> groups;
  
}
