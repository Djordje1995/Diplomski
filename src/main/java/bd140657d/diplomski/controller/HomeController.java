package bd140657d.diplomski.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bd140657d.diplomski.model.Examinee;
import bd140657d.diplomski.service.HomeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("examinees")
public class HomeController {

  @Autowired
  HomeService homeService;
  
  private static Logger log = LoggerFactory.getLogger(HomeController.class);
  
  @GetMapping(value = "/{id}", produces = "application/json")
  public Examinee insertExaminee(@PathVariable Long id) {
    return homeService.getExaminee(id);
  }

}
