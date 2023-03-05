package ru.netology.MovieManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    @Test
    public void getMovies() {
        Manager manager = new Manager();

        String[] expected = {};
        String[] actual = manager.getMovies();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void add1Films() {
        Manager manager = new Manager();

        manager.addMovie("Film1");

        String[] expected = {"Film1"};
        String[] actual = manager.getMovies();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void add2Films() {
        Manager manager = new Manager();

        manager.addMovie("Film1");
        manager.addMovie("Film2");

        String[] expected = {"Film1", "Film2"};
        String[] actual = manager.getMovies();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void LastAddedFilmsLessThanStandardLimit() {
        Manager manager = new Manager();

        manager.addMovie("Film1");
        manager.addMovie("Film2");

        String[] expected = {"Film2", "Film1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void LastAddedFilmsEqualToStandardLimit() {
        Manager manager = new Manager();

        manager.addMovie("Film1");
        manager.addMovie("Film2");
        manager.addMovie("Film3");
        manager.addMovie("Film4");
        manager.addMovie("Film5");
        manager.addMovie("Film6");
        manager.addMovie("Film7");
        manager.addMovie("Film8");
        manager.addMovie("Film9");
        manager.addMovie("Film10");

        String[] expected = {"Film10", "Film9", "Film8", "Film7", "Film6", "Film5", "Film4", "Film3", "Film2", "Film1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void LastAddedFilmsAboveStandardLimit() {
        Manager manager = new Manager();

        manager.addMovie("Film1");
        manager.addMovie("Film2");
        manager.addMovie("Film3");
        manager.addMovie("Film4");
        manager.addMovie("Film5");
        manager.addMovie("Film6");
        manager.addMovie("Film7");
        manager.addMovie("Film8");
        manager.addMovie("Film9");
        manager.addMovie("Film10");
        manager.addMovie("Film11");

        String[] expected = {"Film11", "Film10", "Film9", "Film8", "Film7", "Film6", "Film5", "Film4", "Film3", "Film2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void LastAddedFilmsLessThanSetLimit() {
        Manager manager = new Manager(5);

        manager.addMovie("Film1");
        manager.addMovie("Film2");

        String[] expected = {"Film2", "Film1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void LastAddedFilmsEqualToSetLimit() {
        Manager manager = new Manager(5);

        manager.addMovie("Film1");
        manager.addMovie("Film2");
        manager.addMovie("Film3");
        manager.addMovie("Film4");
        manager.addMovie("Film5");

        String[] expected = {"Film5", "Film4", "Film3", "Film2", "Film1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void LastAddedFilmsAboveSetLimit() {
        Manager manager = new Manager(5);

        manager.addMovie("Film1");
        manager.addMovie("Film2");
        manager.addMovie("Film3");
        manager.addMovie("Film4");
        manager.addMovie("Film5");
        manager.addMovie("Film6");

        String[] expected = {"Film6", "Film5", "Film4", "Film3", "Film2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
