package bd140657d.diplomski.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bd140657d.diplomski.model.GroupOfExaminees;
import bd140657d.diplomski.model.Study;
import bd140657d.diplomski.model.Task;
import bd140657d.diplomski.repository.GroupOfExamineesRepository;
import bd140657d.diplomski.repository.StudyRepository;
import bd140657d.diplomski.repository.TaskRepository;
import bd140657d.diplomski.request.InsertStudyRequest;

@Service
public class StudyService {

  @Autowired
  StudyRepository studyRepository;
  @Autowired
  TaskRepository taskRepository;
  @Autowired
  GroupOfExamineesRepository groupOfExamineesRepositroy;
  
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
  
}
