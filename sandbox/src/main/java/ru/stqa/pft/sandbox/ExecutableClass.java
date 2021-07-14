package ru.stqa.pft.sandbox;

public class ExecutableClass {

    public static void main(String[] args) {

        Point p1 = new Point(2, 6);
        Point p2 = new Point(5,9);

        System.out.println("Расстояние между двумя точками p1 и p2 = " + distance(p1,p2)); // решение по заданию п. 2.1, 2.2, 2.3
        System.out.println("Расстояние между двумя точками p1 и p2 = " + p1.distance(p2)); //решение по заданию п. 2.4


    }

    // функция для решения по заданию п. 2.1, 2.2, 2.3
    public static double distance(Point p1, Point p2){
        return Math.sqrt(Math.pow((p2.x- p1.x),2)+ Math.pow((p2.y- p1.y),2));

    }

}
