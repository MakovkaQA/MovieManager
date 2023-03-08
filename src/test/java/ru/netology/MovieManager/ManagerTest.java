package ru.netology.MovieManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import ru.netology.Repository.Film;
import ru.netology.Repository.Repository;

public class ManagerTest {
    Repository repo = Mockito.mock(Repository.class);
    Manager manager = new Manager(repo);

    Film item1 = new Film(11, "Film1");
    Film item2 = new Film(22, "Film2");
    Film item3 = new Film(33, "Film3");
    Film item4 = new Film(44, "Film4");


    @Test
    public void LastAddedFilmsLessThanStandardLimit() {
        Film[] items = {item1, item2, item3};

        doReturn(items).when(repo).getItems();

        Film[] expected = {item3, item2, item1};
        Film[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void LastAddedFilmsAboveSetLimit() {
        Film[] items = {item1, item2, item3};
        doReturn(items).when(repo).getItems();
        Manager manager = new Manager(repo, 2);

        Film[] expected = {item3, item2};
        Film[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}
