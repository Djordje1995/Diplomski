package bd140657d.diplomski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bd140657d.diplomski.request.LoginRequest;
import bd140657d.diplomski.response.LoginResponse;
import bd140657d.diplomski.service.LoginService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("login")
public class LoginController {

  @Autowired
  LoginService loginService;
  
  @PostMapping(value = "/validate",  consumes = "application/json", produces = "application/json")
  public LoginResponse validateCredentials(@RequestBody LoginRequest request) {
    return loginService.validateCredentials(request);
  }
  
}
