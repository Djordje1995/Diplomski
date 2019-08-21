package bd140657d.diplomski.request;

import lombok.Data;

@Data
public class LoginRequest implements Request{

  private String email;
  private String password;
  
}
