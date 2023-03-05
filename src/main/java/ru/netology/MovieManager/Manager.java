package ru.netology.MovieManager;

public class Manager {
    private String[] movies = new String[0];
    private int maxLimit = 10;

    public Manager() {

    }

    public Manager(int newMaxLimit) {
        this.maxLimit = newMaxLimit;

    }

    public String[] getMovies() {
        return movies;
    }

    public void addMovie(String newMovie) {
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = newMovie;
        movies = tmp;
    }

    public String[] findAll() {
        return movies;
    }


    public String[] findLast() {
        int resultLength;

        if (movies.length < maxLimit) {
            resultLength = movies.length;
        } else {
            resultLength = maxLimit;
        }
        String[] result = new String[resultLength];

        for (int i = 0; i < result.length; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }

}
