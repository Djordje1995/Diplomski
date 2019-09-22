package bd140657d.diplomski.response;

import java.util.List;

import bd140657d.diplomski.dto.ExamineeDto;
import bd140657d.diplomski.dto.StudyDto;
import lombok.Data;

@Data
public class StudyOverviewResponse implements Response{

  List<ExamineeDto> examinees;
  List<StudyDto> studies;
  
}
