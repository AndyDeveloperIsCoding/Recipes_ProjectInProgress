class Circle implements Measurable{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return (double)  radius * radius * Math.PI;
    }

    public double area(int radius) {
        return (double) radius * radius * Math.PI;
    }
}

// do not change the interface
interface Measurable {

    double area();

}