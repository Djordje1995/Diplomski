package bd140657d.diplomski.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bd140657d.diplomski.dto.ExamineeDto;
import bd140657d.diplomski.dto.StudyDto;
import bd140657d.diplomski.model.Examinee;
import bd140657d.diplomski.model.ExamineeStudy;
import bd140657d.diplomski.model.ExamineeStudyId;
import bd140657d.diplomski.model.GroupOfExaminees;
import bd140657d.diplomski.model.Study;
import bd140657d.diplomski.model.Task;
import bd140657d.diplomski.repository.ExamineeStudyRepository;
import bd140657d.diplomski.repository.GroupOfExamineesRepository;
import bd140657d.diplomski.repository.StudyRepository;
import bd140657d.diplomski.repository.TaskRepository;
import bd140657d.diplomski.request.InsertStudyRequest;
import bd140657d.diplomski.response.StudyOverviewResponse;

@Service
public class StudyService {

  @Autowired
  StudyRepository studyRepository;
  @Autowired
  TaskRepository taskRepository;
  @Autowired
  GroupOfExamineesRepository groupOfExamineesRepositroy;
  @Autowired
  ExamineeStudyRepository examineeStudyRepository;
  
  @Transactional
  public Boolean insert(InsertStudyRequest request) { 
    List<String> t = request.getTasks();
    List<String> g = request.getGroups();
    Study study = new Study(request.getName());
    List<Task> tasks = new ArrayList<>();
    List<GroupOfExaminees> groups = new ArrayList<>();
    List<Study> studies = new ArrayList<>();
    studies.add(study);
    for(String tsk: t) {
      Task task = new Task(tsk, study);
      tasks.add(task);
      if(task != taskRepository.save(task)) {
        return false;
      }
    }
    for(String grp: g) {
      GroupOfExaminees group = new GroupOfExaminees(grp);
      group.setStudies(studies);
      groups.add(group);
      if(group != groupOfExamineesRepositroy.save(group)) {
        return false;
      };
    }
    study.setTasks(tasks);
    study.setGroups(groups);
    if(study != studyRepository.save(study)) {
      return false;
    }
    return true;
  }
  
  private String findComment(Examinee examinee, List<Study> studies) {
    for (Study s : studies) {
      ExamineeStudyId id = new ExamineeStudyId();
      id.setExamineeId(examinee.getId());
      id.setStudyId(s.getId());
      Optional<ExamineeStudy> es = examineeStudyRepository.findById(id);
      if (es.isPresent()) {
        return es.get().getDescription();
      }
    }
    return "";
  }
  
  public StudyOverviewResponse overview() {
    List<Study> studies = studyRepository.findAll();
    List<StudyDto> studyDtos = new ArrayList<>();
    List<GroupOfExaminees> groups = new ArrayList<>();
    for (Study s : studies) {
      StudyDto sd = new StudyDto();
      sd.setId(s.getId());
      sd.setName(s.getName());
      groups.addAll(s.getGroups());
      studyDtos.add(sd);
    }
    List<ExamineeDto> examinees = new ArrayList<>();
    for (GroupOfExaminees g : groups) {
      List<Examinee> exam = g.getExaminees();
      for (Examinee e : exam) {
        String comment = findComment(e, studies);
        ExamineeDto examineeDto = new ExamineeDto();
        examineeDto.setAge(e.getAge());
        examineeDto.setComment(comment);
        examineeDto.setEntryDate(e.getDate());
        examineeDto.setGroup(g.getName());
        examineeDto.setName(e.getName());
        examineeDto.setParentsName(e.getParentName());
        examineeDto.setSurname(e.getSurname());
        examinees.add(examineeDto);
      }
    }
    StudyOverviewResponse response = new StudyOverviewResponse();
    response.setStudies(studyDtos);
    response.setExaminees(examinees);
    return response;
  }
}
