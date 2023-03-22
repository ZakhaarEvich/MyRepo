// Создаем класс Circle, который наследуется от класса Figure
public class Circle extends Figure {
    // Объявляем приватные переменные: радиус, координаты центра круга
    private double radius;
    private double centerX;
    private double centerY;
    // Создаем конструктор класса, который принимает значения радиуса и координат центра круга
    public Circle(double radius, double centerX, double centerY) {
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }
    // Переопределяем метод getArea из класса Figure для расчета площади круга
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    // Переопределяем метод getPerimeter из класса Figure для расчета периметра круга
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}