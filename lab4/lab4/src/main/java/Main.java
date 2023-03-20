public class Main {
    public static void main(String[] args) {
        Figure circle = new Circle(5, 0, 0);
        Figure rectangle = new Rectangle(3, 4);
        Figure triangle = new Triangle(3, 4, 5);
        Figure ellipse = new Ellipse(5, 3);

        System.out.println("Circle area: " + circle.getArea());
        System.out.println("Circle perimeter: " + circle.getPerimeter());

        System.out.println("Rectangle area: " + rectangle.getArea());
        System.out.println("Rectangle perimeter: " + rectangle.getPerimeter());

        System.out.println("Triangle area: " + triangle.getArea());
        System.out.println("Triangle perimeter: " + triangle.getPerimeter());

        System.out.println("Ellipse area: " + ellipse.getArea());
        System.out.println("Ellipse perimeter: " + ellipse.getPerimeter());
    }
}
