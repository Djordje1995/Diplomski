package bd140657d.diplomski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bd140657d.diplomski.request.InsertMeasurementsRequest;
import bd140657d.diplomski.response.InsertMeasurementInitResponse;
import bd140657d.diplomski.response.MeasurementOverviewResponse;
import bd140657d.diplomski.service.MeasurementService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("measurement")
public class MeasurementController {

  @Autowired
  MeasurementService measurementService;
  
  @PostMapping(value = "/init", produces = "application/json")
  public InsertMeasurementInitResponse init() {
    return measurementService.init();
  }
  
  @PostMapping(value = "/insert", consumes = "application/json", produces = "application/json")
  public Boolean insert(@RequestBody InsertMeasurementsRequest request) {
    return measurementService.insert(request);
  }
  
  @GetMapping(value = "/overview", produces = "application/json")
  public MeasurementOverviewResponse overview() {
    return measurementService.overview();
  }
}
