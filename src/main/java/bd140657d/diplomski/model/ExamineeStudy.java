package bd140657d.diplomski.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class ExamineeStudy {

  @EmbeddedId
  private ExamineeStudyId id;
  private String description;
}
