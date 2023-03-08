package ru.netology.Repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    Film item1 = new Film(11, "Film1");
    Film item2 = new Film(22, "Film2");
    Film item3 = new Film(33, "Film3");

    Repository repo = new Repository();


    @Test
    public void save1Film() {

        repo.save(item1);

        Film[] expected = {item1};
        Film[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllFilms() {

        repo.save(item1);
        repo.save(item2);

        Film[] expected = {item1, item2};
        Film[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findFilmByIdWhenIdIsFound() {

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        Film[] expected = {item2};
        Film[] actual = repo.findById(22);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findFilmByIdWhenIdIsNotFound() {

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        Film[] expected = {null};
        Film[] actual = repo.findById(5);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeFilmByIdWhenIdIsFound() {

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        repo.removeById(22);

        Film[] expected = {item1, item3};
        Film[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void removeAll() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        repo.removeAll();

        Film[] expected = {};
        Film[] actual = repo.getItems();

    }


}
