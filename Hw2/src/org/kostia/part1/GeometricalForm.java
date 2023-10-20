package org.kostia.part1;

public class GeometricalForm implements FormOperations {

    private int xCoord;
    private int yCoord;
    private String innerColour;
    private String formColour;

    @Override
    public void move(int x, int y) {
        xCoord = x;
        yCoord = y;
    }

    @Override
    public void changeInnerColour(String colour) {
        if (colour == null) {
            throw new IllegalArgumentException("Can't change inner color to null");
        }
        this.innerColour = colour;
    }

    @Override
    public void changeFormColour(String colour) {
        if (colour == null) {
            throw new IllegalArgumentException("Can't change form color to null");
        }
        this.formColour = colour;
    }

    @Override
    public void shrink() {
        throw new UnsupportedOperationException("shrink not supported");
    }

    @Override
    public void enlarge() {
        throw new UnsupportedOperationException("enlarge not supported");
    }

    public GeometricalForm(int xCoord, int yCoord, String innerColour, String formColour) {
        if (innerColour == null) {
            throw new IllegalArgumentException("Null value for innerColour detected");
        }
        if (formColour == null) {
            throw new IllegalArgumentException("Null value for formColour detected");
        }
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.innerColour = innerColour;
        this.formColour = formColour;
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    public String getInnerColour() {
        return innerColour;
    }

    public String getFormColour() {
        return formColour;
    }

    @Override
    public String toString() {
        return "GeometricalForm{" +
                "xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                ", innerColour='" + innerColour + '\'' +
                ", formColour='" + formColour + '\'' +
                '}';
    }
}
