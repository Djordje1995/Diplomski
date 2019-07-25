package bd140657d.diplomski.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bd140657d.diplomski.controller.HomeController;
import bd140657d.diplomski.model.Examinee;
import bd140657d.diplomski.repository.ExamineeRepository;

@Service
public class HomeService {

  @Autowired
  ExamineeRepository examineeRepository;
  
  private static Logger log = LoggerFactory.getLogger(HomeService.class);
  
  public Examinee getExaminee(Long id) {
    return examineeRepository.getOne(id);
  }
  
  public Examinee insertExaminee() {
    Examinee examinee = new Examinee("Djordje", "Bozovic", "0109995721518");
    examineeRepository.save(examinee);
    return examinee;
  }
  
}
