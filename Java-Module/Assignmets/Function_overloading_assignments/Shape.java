class Shape 
{
    double triangleArea(double base, double height) 
    {
        return 0.5 * base * height;
    }

    double rectangleArea(double length, double breadth) 
    {
        return length * breadth;
    }

    double circleArea(double radius) 
    {
        return 3.14 * radius * radius;
    }


}

class TestShape 
{
    public static void main(String[] args) 
    {
        Shape s = new Shape();

        System.out.println("Triangle Area: " + s.triangleArea(5.3, 3.4));
        System.out.println("Triangle Area: " + s.triangleArea(5, 3));
        System.out.println("Triangle Area: " + s.triangleArea(3, 3.4));

        System.out.println("Rectangle Area: " + s.rectangleArea(8.6, 5.7));
        System.out.println("Circle Area: " + s.circleArea(7.8));
    }


}
