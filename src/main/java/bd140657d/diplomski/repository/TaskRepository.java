package bd140657d.diplomski.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bd140657d.diplomski.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
