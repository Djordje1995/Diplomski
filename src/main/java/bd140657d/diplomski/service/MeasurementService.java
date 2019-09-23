package bd140657d.diplomski.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bd140657d.diplomski.dto.ExtendedMeasurementDto;
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
import bd140657d.diplomski.response.MeasurementOverviewResponse;

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

  public MeasurementOverviewResponse overview() {
    List<Measurement> measures = measurementRepository.findAll();
    List<ExtendedMeasurementDto> meas= new ArrayList<>();
    for (Measurement m : measures) {
      ExtendedMeasurementDto emd = new ExtendedMeasurementDto();
      emd.setName(m.getExaminee().getName());
      emd.setSurname(m.getExaminee().getSurname());
      emd.setAge(m.getExaminee().getAge());
      emd.setTask(m.getTask().getName());
      emd.setTime(m.getTime());
      emd.setComment(m.getDescription());
      meas.add(emd);
    }
    MeasurementOverviewResponse measurements = new MeasurementOverviewResponse();
    measurements.setMeasurements(meas);
    return measurements;
  }
  
  @Transactional
  public Boolean insert(InsertMeasurementsRequest request) {
    Task task = taskRepository.findById(request.getTask()).get();
    Examinee examinee = examineeRepository.findById(request.getExaminee()).get();
    for (MeasurementDto measurement : request.getMeasurements()) {
      Measurement m = new Measurement();
      m.setDescription(measurement.getComment());
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
