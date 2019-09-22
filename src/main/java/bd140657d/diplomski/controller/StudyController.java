package bd140657d.diplomski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bd140657d.diplomski.request.InsertStudyRequest;
import bd140657d.diplomski.response.StudyOverviewResponse;
import bd140657d.diplomski.service.StudyService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("study")
public class StudyController {

  @Autowired
  StudyService studyService;
  
  @PostMapping(value = "/insert",  consumes = "application/json")
  public Boolean insert(@RequestBody InsertStudyRequest request) {
    return studyService.insert(request);
  }
  
  @GetMapping(value = "/overview",  produces = "application/json")
  public StudyOverviewResponse overview() {
    return studyService.overview();
  }
  
}
