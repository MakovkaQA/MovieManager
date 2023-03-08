package ru.netology.Repository;

public class Repository {
    private Film[] items = new Film[0];

    public Film[] getItems() {
        return items;
    }

    public Film[] findAll() {
        return getItems();
    }

    public Film[] findById(int id) {
        Film[] filmById = new Film[1];
        int copyToIndex = 0;
        for (Film item : items) {
            if (item.getId() == id) {
                filmById[copyToIndex] = item;
            }
        }
        return filmById;
    }

    public void save(Film item) {

        Film[] tmp = new Film[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public void removeById(int id) {
        Film[] tmp = new Film[items.length - 1];
        int copyToIndex = 0;
        for (Film item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    public void removeAll() {
        Film[] tmp = new Film[0];
        items = tmp;
    }
}
