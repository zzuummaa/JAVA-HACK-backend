package app;

import java.util.Scanner;

import static app.TextSimilarityCalculator.answer;

public class LevenshteinDistance {

    public static void main(String[] args) {
//        String y = new Scanner(System.in).nextLine();
        String y = "Коннор сару вы спасете!";
        long start = System.nanoTime();
        String answer = answer(y);
        long end = System.nanoTime();
        System.out.println(answer);
        System.out.println("calc time: " + (end - start) / 1_000_000);
    }

}
