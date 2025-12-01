public class Point3D {
    private double x;
    private double y;
    private double z;
    
    // Конструкторы
    public Point3D() {
        this(0, 0, 0);
    }
    
    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    // Геттеры
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }
    
    // Сеттеры
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setZ(double z) { this.z = z; }
    
    // Метод toString()
    @Override
    public String toString() {
        return String.format("Point3D(%.2f, %.2f, %.2f)", x, y, z);
    }
    
    // Метод для вычисления расстояния до начала координат
    public double distanceToOrigin() {
        return Math.sqrt(x * x + y * y + z * z);
    }
}