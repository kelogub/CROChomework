package lesson0710;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        for (int i = 1; i<101; i++){
            if (i%3==0) System.out.print("Fizz");
            if (i%5==0) System.out.print("Buzz");
            if (!(i%3==0||i%5==0)) System.out.print(i);
            System.out.println();
        }
    }
}
