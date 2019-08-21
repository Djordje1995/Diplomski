package bd140657d.diplomski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bd140657d.diplomski.request.InsertStudyRequest;
import bd140657d.diplomski.service.StudyService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("study")
public class StudyController {

  @Autowired
  StudyService studyService;
  
  @PostMapping(value = "/insert",  consumes = "application/json")
  public Boolean validateCredentials(@RequestBody InsertStudyRequest request) {
    return studyService.insert(request);
  }
  
}
