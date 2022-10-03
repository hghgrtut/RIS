package com.bespalaya.bookCheck.entities;

public class BookEntity {
    private int id;
    private String name;
    private String author;
    private int countPages;

    public BookEntity(String name, String author, int countPages) {
        this.name = name;
        this.author = author;
        this.countPages = countPages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCountPages() {
        return countPages;
    }

    public void setCountPages(int countPages) {
        this.countPages = countPages;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", countPages=" + countPages +
                '}';
    }
}
