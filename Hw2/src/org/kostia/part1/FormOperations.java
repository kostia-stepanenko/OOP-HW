package org.kostia.part1;

public interface FormOperations {

    void move (int x , int y);
    void shrink();
    void enlarge ();

    void changeInnerColour(String colour);

    void changeFormColour(String colour);
}
