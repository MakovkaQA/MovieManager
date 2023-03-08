package ru.netology.MovieManager;

import ru.netology.Repository.Film;
import ru.netology.Repository.Repository;

import java.util.Objects;

public class Manager {
    private Repository repo;
    private int maxLimit = 10;

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public Manager(Repository repo, int newMaxLimit) {
        this.repo = repo;
        this.maxLimit = newMaxLimit;
    }

    public void add(Film item) {
        repo.save(item);
    }

    public Film[] findLast() {
        int resultLength;
        Film[] all = repo.getItems();

        if (all.length < maxLimit) {
            resultLength = all.length;
        } else {
            resultLength = maxLimit;
        }
        Film[] result = new Film[resultLength];

        for (int i = 0; i < result.length; i++) {
            result[i] = all[all.length - 1 - i];
        }
        return result;
    }

}
