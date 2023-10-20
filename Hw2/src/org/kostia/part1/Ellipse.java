package org.kostia.part1;

public class Ellipse extends GeometricalForm {

    private int horRadius;
    private int verRadius;

    public Ellipse(int x, int y, int horRadius, int verRadius) {
        super(x, y, "Black", "Black");
        if (horRadius <= 0) {
            throw new IllegalArgumentException("Negative or Zero horRadius for Ellipse detected " + horRadius);
        }
        if (verRadius <= 0) {
            throw new IllegalArgumentException("Negative or Zero verRadius for Ellipse detected " + verRadius);
        }

        this.horRadius = horRadius;
        this.verRadius = verRadius;
    }

    public int getHorRadius() {
        return horRadius;
    }

    public int getVerRadius() {
        return verRadius;
    }

    @Override
    public void shrink() {
        if( horRadius == 1 ){
            throw new IllegalArgumentException("Can't shrink, horRadius will be 0");
        }
        if( verRadius == 1 ){
            throw new IllegalArgumentException("Can't shrink, verRadius will be 0");
        }

        horRadius -= 1;
        verRadius -= 1;
    }

    @Override
    public void enlarge() {
        horRadius += 1;
        verRadius += 1;
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "horRadius=" + horRadius +
                ", verRadius=" + verRadius +
                '}';
    }
}
