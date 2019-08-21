package bd140657d.diplomski.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bd140657d.diplomski.model.User;
import bd140657d.diplomski.repository.UserRepository;
import bd140657d.diplomski.request.LoginRequest;
import bd140657d.diplomski.response.LoginResponse;

@Service
public class LoginService {

  private static final String WRONG_EMAIL_ERROR_MASSAGE = "Pogresili ste email";
  private static final String WRONG_PASSWORD_ERROR_MASSAGE = "Pogresili ste passowrd";
  @Autowired
  UserRepository userRepository;
  
  public LoginResponse validateCredentials(LoginRequest request) {
    LoginResponse response = new LoginResponse();
    User user = userRepository.findByEmail(request.getEmail());
    if (user == null) {
      response.setEmailErrorMassage(WRONG_EMAIL_ERROR_MASSAGE);
      response.setIsSuccessful(false);
    }
    else {
      if (!user.getPassword().equals(request.getPassword())) {
        response.setPasswordErrorMassage(WRONG_PASSWORD_ERROR_MASSAGE);
        response.setIsSuccessful(false);
      }
      else {
        response.setUser(user);
        response.setIsSuccessful(true);
        response.setIsAdmin(user.getIsAdmin());
      }
    }
    return response;
  }
  
}
