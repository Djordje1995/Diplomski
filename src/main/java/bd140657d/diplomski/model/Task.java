package bd140657d.diplomski.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @NonNull
  private String name;
  @ManyToOne
  @JoinColumn(foreignKey = @ForeignKey(name = "fk_task_study"))
  @NonNull 
  private Study study;
  @OneToMany(mappedBy = "task")
  private List<Measurement> measurements;
  
}
