package bd140657d.diplomski.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bd140657d.diplomski.model.ExamineeStudy;
import bd140657d.diplomski.model.ExamineeStudyId;

public interface ExamineeStudyRepository extends JpaRepository<ExamineeStudy, ExamineeStudyId>{

}
