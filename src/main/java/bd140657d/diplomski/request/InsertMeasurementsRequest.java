package bd140657d.diplomski.request;

import java.util.List;

import bd140657d.diplomski.dto.MeasurementDto;
import lombok.Data;

@Data
public class InsertMeasurementsRequest implements Request{

  Long study;
  Long group;
  Long task;
  Long examinee;
  List<MeasurementDto> measurements;
  
}
