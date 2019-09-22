package bd140657d.diplomski.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bd140657d.diplomski.dto.MeasurementDto;
import bd140657d.diplomski.model.Examinee;
import bd140657d.diplomski.model.Measurement;
import bd140657d.diplomski.model.Task;
import bd140657d.diplomski.repository.ExamineeRepository;
import bd140657d.diplomski.repository.MeasurementRepository;
import bd140657d.diplomski.repository.StudyRepository;
import bd140657d.diplomski.repository.TaskRepository;
import bd140657d.diplomski.request.InsertMeasurementsRequest;
import bd140657d.diplomski.response.InsertMeasurementInitResponse;

@Service
public class MeasurementService {

  @Autowired
  StudyRepository studyRepository;
  @Autowired
  TaskRepository taskRepository;
  @Autowired
  ExamineeRepository examineeRepository;
  @Autowired
  MeasurementRepository measurementRepository;

  public InsertMeasurementInitResponse init() {
    InsertMeasurementInitResponse response = new InsertMeasurementInitResponse();
    response.setStudies(studyRepository.findAll());
    return response;
  }

  private Integer getHours(String time) {
    String temp = Character.toString(time.charAt(0)).concat(Character.toString(time.charAt(1)));
    return Integer.parseInt(temp);
  }

  private Integer getMinutes(String time) {
    String temp = Character.toString(time.charAt(3)).concat(Character.toString(time.charAt(4)));
    return Integer.parseInt(temp);
  }

  @Transactional
  public Boolean insert(InsertMeasurementsRequest request) {
    Task task = taskRepository.findById(request.getTask()).get();
    Examinee examinee = examineeRepository.findById(request.getExaminee()).get();
    for (MeasurementDto measurement : request.getMeasurements()) {
      Measurement m = new Measurement();
      m.setDescription(measurement.getDescription());
      Calendar time = examinee.getDate();
      time.set(Calendar.HOUR_OF_DAY, getHours(measurement.getTime()));
      time.set(Calendar.MINUTE, getMinutes(measurement.getTime()));
      m.setTime(time);
      m.setTask(task);
      m.setExaminee(examinee);
      if (!measurementRepository.save(m).equals(m)) {
        return false;
      }
    }
    return true;
  }

}
