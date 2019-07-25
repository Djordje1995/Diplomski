package bd140657d.diplomski.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bd140657d.diplomski.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

  User getUserByEmail(String email);
  
}
