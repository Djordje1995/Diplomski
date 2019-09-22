package bd140657d.diplomski.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Examinee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @NonNull
  private String name;
  @NonNull
  private String surname;
  @NonNull
  private String parentName;
  @NonNull
  private Integer age;
  @NonNull
  private Calendar date;
  @JsonIgnore
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "examinee_group",
      joinColumns = @JoinColumn(name = "examinee_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"))
  private List<GroupOfExaminees> groups;
  @OneToMany(mappedBy = "examinee")
  private List<Measurement> measurements;
}
