package study.lesson.two.lessonthree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.lesson.two.lessonthree.entity.Person;
import study.lesson.two.lessonthree.repository.UserRepository;

import java.util.List;

@Service
public class PersonOperation {

    @Autowired
    private UserRepository userRepository;

    public Person createPerson(Person person) {
        return userRepository.save(person);
    }

    public Person editPerson(Person person) {
        Person newPerson = userRepository.findById(person.getId()).orElseThrow();
        newPerson.setEmail(person.getEmail());
        newPerson.setLink(person.getLink());
        newPerson.setNumber(person.getNumber());
        newPerson.setNotes(person.getNotes());
        return userRepository.save(newPerson);
    }

    public void deletePerson(Person person) {
        userRepository.delete(person);
    }

    public List<Person> findByFio(String fio) {
        return userRepository.findAllByFio(fio);
    }
}
