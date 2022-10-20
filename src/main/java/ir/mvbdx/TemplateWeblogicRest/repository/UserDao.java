package ir.mvbdx.TemplateWeblogicRest.repository;

import ir.mvbdx.TemplateWeblogicRest.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findById(Long userId);
}