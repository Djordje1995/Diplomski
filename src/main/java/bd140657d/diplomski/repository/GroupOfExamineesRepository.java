package bd140657d.diplomski.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bd140657d.diplomski.model.GroupOfExaminees;
import bd140657d.diplomski.model.Study;

public interface GroupOfExamineesRepository extends JpaRepository<GroupOfExaminees, Long>{
  
  List<GroupOfExaminees> findByStudies(List<Study> studies);
}
