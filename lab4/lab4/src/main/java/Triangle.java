// Объявляем класс Triangle, который наследует класс Figure
public class Triangle extends Figure {
    // Объявляем приватные переменные sideA, sideB и sideC типа double
    private double sideA;
    private double sideB;
    private double sideC;
    // Объявляем конструктор класса Triangle с параметрами sideA, sideB и sideC
    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    // Переопределяем метод getArea() из класса Figure
    @Override
    public double getArea() {
        double p = (sideA + sideB + sideC) / 2; //  вычисление полупериметра
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC)); // вычисление площади по формуле Герона
    }
    // Переопределяем метод getPerimeter() из класса Figure
    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }
}