package bd140657d.diplomski.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Study {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @NonNull
  private String name;
  @ManyToMany(mappedBy = "studies")
  private List<GroupOfExaminees> groups;
  @OneToMany(mappedBy = "study")
  private List<Task> tasks;
}
