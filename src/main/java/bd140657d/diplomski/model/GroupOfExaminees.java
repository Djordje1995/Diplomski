package bd140657d.diplomski.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class GroupOfExaminees {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @NonNull
  private String name;
  @ManyToMany(mappedBy = "groups")
  private List<Examinee> examinees;
  @JsonIgnore
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "group_study",
      joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "study_id", referencedColumnName = "id"))
  private List<Study> studies;
}
