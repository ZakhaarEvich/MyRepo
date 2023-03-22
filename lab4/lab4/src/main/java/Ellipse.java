// Объявляем класс Ellipse, который наследует класс Figure
public class Ellipse extends Figure {
    // Объявляем приватные переменные majorAxis и minorAxis типа double
    private double majorAxis;
    private double minorAxis;
    // Объявляем конструктор класса Ellipse с параметрами majorAxis и minorAxis
    public Ellipse(double majorAxis, double minorAxis) {
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }
    // Переопределяем метод getArea() из класса Figure
    @Override
    public double getArea() {
        return Math.PI * majorAxis * minorAxis; // Возвращаем площадь эллипса, вычисленную по формуле
    }
    // Переопределяем метод getPerimeter() из класса Figure
    @Override
    public double getPerimeter() {
               return 2 * Math.PI * Math.sqrt((majorAxis * majorAxis + minorAxis * minorAxis) / 2);  // Возвращаем периметр эллипса, вычисленный по формуле
    }
}