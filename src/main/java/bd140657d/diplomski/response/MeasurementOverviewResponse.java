package bd140657d.diplomski.response;

import java.util.List;

import bd140657d.diplomski.dto.ExtendedMeasurementDto;
import lombok.Data;

@Data
public class MeasurementOverviewResponse implements Response{

  List<ExtendedMeasurementDto> measurements;
  
}
