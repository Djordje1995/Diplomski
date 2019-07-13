package bd140657d.diplomski.model;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Measurement {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @NonNull
  private int serialNumber;
  @Lob
  private String description;
  @NonNull
  private Time time;
  @ManyToOne
  @JoinColumn(foreignKey = @ForeignKey(name = "fk_measurement_task"))
  @NonNull
  private Task task;
  
}
