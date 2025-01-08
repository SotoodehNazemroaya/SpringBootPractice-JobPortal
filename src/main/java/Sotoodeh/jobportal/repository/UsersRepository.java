package Sotoodeh.jobportal.repository;

import Sotoodeh.jobportal.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
