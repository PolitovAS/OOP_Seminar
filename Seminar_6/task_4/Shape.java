package Seminar_6.task_4;

public class Shape {
    protected int width;
    protected int height;

    public Shape(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int area() {
        return this.width * this.height;
    }
}