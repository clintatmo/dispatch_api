package sr.dispatch.api.service;

import sr.dispatch.api.dto.PersonDto;
import sr.dispatch.api.model.Person;
import sr.dispatch.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* * * @author Clint Atmosoerodjo #commander *  */

@Service
public class PersonServiceBean implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person findById(long id) {
        return personRepository.findOne(id);
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void updatePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void deletePersonById(long id) {
        personRepository.delete(id);
    }

    @Override
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public void deleteAllPersons() {
        personRepository.deleteAll();
    }

    @Override
    public boolean isPersonExist(PersonDto person) {
        return personRepository.exists(person.getId());
    }
}
