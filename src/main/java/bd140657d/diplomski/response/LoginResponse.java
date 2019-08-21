package bd140657d.diplomski.response;

import bd140657d.diplomski.model.User;
import lombok.Data;

@Data
public class LoginResponse implements Response{

  private User user;
  private String emailErrorMassage;
  private String passwordErrorMassage;
  private String successMessage;
  private Boolean isSuccessful;
  private Boolean isAdmin;
  
}
