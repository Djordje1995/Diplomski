package bd140657d.diplomski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bd140657d.diplomski.request.InsertExamineeRequest;
import bd140657d.diplomski.response.InsertExamineeInitResponse;
import bd140657d.diplomski.service.ExamineeService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("examinee")
public class ExamineeController {
  
  @Autowired
  ExamineeService examineeService;
  
  @PostMapping(value = "/init", produces = "application/json")
  public InsertExamineeInitResponse init() {
    return examineeService.init();
  }

  @PostMapping(value = "/insert", consumes = "application/json", produces = "application/json")
  public Boolean insert(@RequestBody InsertExamineeRequest request) {
    return examineeService.insert(request);
  }
  
}
