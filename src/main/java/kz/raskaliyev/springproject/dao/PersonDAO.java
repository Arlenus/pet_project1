package kz.raskaliyev.springproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import kz.raskaliyev.springproject.models.Book;
import kz.raskaliyev.springproject.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(full_name, year_of_birth) VALUES(?, ?)", person.getFullName(),
                person.getYearOfBirth());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET full_name=?, year_of_birth=? WHERE id=?", updatedPerson.getFullName(),
                updatedPerson.getYearOfBirth(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }
    public List<Person> findByFullName(String fullname) {
        String sql = "SELECT * FROM person WHERE full_name = ?";
        return jdbcTemplate.query(sql, new Object[]{fullname}, new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Book> getBorrowedBooksByPerson(Person person) {
        String sql = "SELECT * FROM Book WHERE person_id = ?";
        List<Book> borrowedBooks = jdbcTemplate.query(sql, new Object[]{person.getId()}, new BeanPropertyRowMapper<>(Book.class));
        return borrowedBooks;
    }
}
