package kz.raskaliyev.springproject.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import kz.raskaliyev.springproject.dao.PersonDAO;
import kz.raskaliyev.springproject.models.Person;

import java.util.List;


@Component
public class PersonValidator implements Validator {

    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        List<Person> existingPersons = personDAO.findByFullName(person.getFullName());
        if (!existingPersons.isEmpty()) {
            errors.rejectValue("fullName", "","Человек с таким ФИО уже существует");
        }
    }

}