package bd140657d.diplomski.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bd140657d.diplomski.model.Examinee;
import bd140657d.diplomski.model.ExamineeStudy;
import bd140657d.diplomski.model.ExamineeStudyId;
import bd140657d.diplomski.model.GroupOfExaminees;
import bd140657d.diplomski.repository.ExamineeRepository;
import bd140657d.diplomski.repository.ExamineeStudyRepository;
import bd140657d.diplomski.repository.GroupOfExamineesRepository;
import bd140657d.diplomski.repository.StudyRepository;
import bd140657d.diplomski.request.InsertExamineeRequest;
import bd140657d.diplomski.response.InsertExamineeInitResponse;

@Service
public class ExamineeService {

  @Autowired
  StudyRepository studyRepository;
  @Autowired
  GroupOfExamineesRepository groupOfExamineesRepositroy;
  @Autowired
  ExamineeRepository examineeRepository;
  @Autowired
  ExamineeStudyRepository examineeStudyRepository;
  
  public InsertExamineeInitResponse init() {
    InsertExamineeInitResponse response = new InsertExamineeInitResponse();
    response.setStudies(studyRepository.findAll());
    return response;
  }

  @Transactional
  public Boolean insert(InsertExamineeRequest request) {
    Examinee examinee = new Examinee();
    List<GroupOfExaminees> groups = new LinkedList<>();
    groups.add(groupOfExamineesRepositroy.findById(request.getGroup()).get());
    examinee.setName(request.getName());
    examinee.setSurname(request.getSurname());
    examinee.setParentName(request.getParentsName());
    examinee.setGroups(groups);
    examinee.setDate(request.getDate());
    examinee.setAge(request.getAge());
    if(examinee != examineeRepository.save(examinee)) {
      return false;
    }
    ExamineeStudyId id = new ExamineeStudyId();
    id.setExamineeId(examinee.getId());
    id.setStudyId(request.getStudy());
    ExamineeStudy examineeStudy = new ExamineeStudy();
    examineeStudy.setId(id);
    examineeStudy.setDescription(request.getComment());
    if(examineeStudyRepository.save(examineeStudy) == null) {
      return false;
    }
    return true;
  }

}
