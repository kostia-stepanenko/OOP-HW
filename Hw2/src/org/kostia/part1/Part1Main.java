package org.kostia.part1;

public class Part1Main {
    public static void main(String[] args) {

        Object[] arr = {
                new Ellipse(0, 0, 12, 30),
                new Rectangle(0, 0, 40, 20),
                new GeometricalForm(90, 80, "Black", "Pink")
        };

        for (Object obj : arr) {
            FormOperations form = (FormOperations) obj;

            form.move(1, 1);
            form.changeFormColour("Red");
            form.changeInnerColour("Blue");

            if (form instanceof Rectangle || form instanceof Ellipse) {
                form.enlarge();
                form.enlarge();
                form.shrink();
            }
        }

        for (Object obj : arr) {

            FormOperations form = (FormOperations) obj;

            if (form instanceof Rectangle r) {
                System.out.printf("Rectangle, width = %d, height = %d, colors = %s, %s %n",
                        r.getWidth(), r.getHeight(),
                        r.getInnerColour(), r.getFormColour());
            } else if (form instanceof Ellipse e) {
                System.out.printf("Ellipse, horRadius = %d, verRadius = %d, colors = %s, %s %n",
                        e.getHorRadius(), e.getVerRadius(),
                        e.getInnerColour(), e.getFormColour());
            } else if (form instanceof GeometricalForm geometricalForm) {
                System.out.printf("GeometricalForm, x = %d, y = %d, colors = %s, %s%n",
                        geometricalForm.getXCoord(),
                        geometricalForm.getYCoord(),
                        geometricalForm.getInnerColour(), geometricalForm.getFormColour());
            }
        }
    }

}