package org.kostia.part1;

public class Rectangle extends GeometricalForm {

    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y, "Black", "Black");

        if (width <= 0) {
            throw new IllegalArgumentException("Negative or Zero width for Rectangle detected " + width);
        }

        if (height <= 0) {
            throw new IllegalArgumentException("Negative or Zero height for Rectangle detected " + height);
        }

        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void shrink() {
        if( width == 1 ){
            throw new IllegalArgumentException("Can't shrink, width will be 0");
        }
        if( height == 1 ){
            throw new IllegalArgumentException("Can't shrink, height will be 0");
        }
        width -= 1;
        height -= 1;
    }

    @Override
    public void enlarge() {
        width += 1;
        height += 1;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
