package ru.sk.millionaire.repository;

import lombok.SneakyThrows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sk.millionaire.model.User;

import java.util.Optional;

@Repository
@RepositoryRestResource(
        collectionResourceRel = "users",
        itemResourceRel = "user"
)
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    @SneakyThrows
    @Transactional
    default User insert(User user) {
        save(user);
        return user;
    }

}
