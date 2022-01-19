package study.lesson.two.lessonthree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import study.lesson.two.lessonthree.entity.Person;
import study.lesson.two.lessonthree.service.PersonOperation;

import java.util.List;

@RestController
@RequestMapping("/addresBook")
@RequiredArgsConstructor
public class AdressBook {

    private final PersonOperation personOperation;

    @PostMapping("/addUser")
    public Person addUser(@RequestBody Person person) {
        return personOperation.createPerson(person);
    }

    @PostMapping("/updateUser")
    public Person updateUser(@RequestBody Person person) {
        return personOperation.editPerson(person);
    }

    @PostMapping("/deleteUser")
    public void deleteUser(@RequestBody Person person) {
        personOperation.deletePerson(person);
    }

    @GetMapping("/findByFio")
    public List<Person> findByFio(@RequestParam String fio) {
        return personOperation.findByFio(fio);
    }
}
