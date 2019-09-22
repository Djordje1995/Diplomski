package bd140657d.diplomski.response;

import java.util.List;

import bd140657d.diplomski.model.Study;
import lombok.Data;

@Data
public class InsertExamineeInitResponse implements Response{

  private List<Study> studies;
}
