// Создаем класс Rectangle, который наследуется от класса Figure
public class Rectangle extends Figure {
    // Объявляем приватные переменные: ширина и высота прямоугольника
    private double width;
    private double height;
    // Создаем конструктор класса, который принимает значения ширины и высоты прямоугольника
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    // Переопределяем метод getArea из класса Figure для расчета площади прямоугольника
    @Override
    public double getArea() {
        return width * height;
    }
    // Переопределяем метод getPerimeter из класса Figure для расчета периметра прямоугольника
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}