package bd140657d.diplomski.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@RequiredArgsConstructor
public class ExamineeStudyId implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 2709230416721246731L;
  @NonNull
  private Long examineeId;
  @NonNull
  private Long studyId;
  
}
