package fpoly.edu.assignment_java5.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import fpoly.edu.assignment_java5.identity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByTelephone(Integer telephone);
}
