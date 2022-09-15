package org.example;
import java.io.Serializable;


public class Ship implements Serializable {
 // перечисление полей класса
 private String name; // имя корабля
 private int year; // год постройки корабля

 // конструктор класса, задача которого - присвоение значений полям класса
 public Ship(String name, int year) {
  this.name = name;
  this.year = year;
 }

 // методы класса
  void showInfo() {
  System.out.println("name: " +
          name + "; year of construction: " + year);
 }

}