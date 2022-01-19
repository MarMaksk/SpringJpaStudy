package study.lesson.two.lessonthree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.lesson.two.lessonthree.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Person, Long> {
    Optional<Person> findById(Long id);

    Person findByFio(String fio);

    List<Person> findAllByFio(String fio);
}
