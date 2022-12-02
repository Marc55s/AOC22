package ms.aoc;

import java.util.HashMap;
import java.util.List;

public class Day2 extends Day {
    public Day2() {
        super("2");
    }

    @Override
    void solve(List<String> input) {
        HashMap<String, Integer> lup = new HashMap<>();
        lup.put("A X", 1 + 3);
        lup.put("A Y", 2 + 6);
        lup.put("A Z", 3);
        lup.put("B X", 1);
        lup.put("B Y", 2 + 3);
        lup.put("B Z", 3 + 6);
        lup.put("C X", 1 + 6);
        lup.put("C Y", 2);
        lup.put("C Z", 3 + 3);
        int score = 0;
        int ans = 0;
        for (String s : input) {
            String[] hands = s.split(" ");
            String op = hands[0];
            String pred = hands[1];
            char c = 0;
            switch (pred) {
                case "X" -> {
                    if (!op.equals("A"))
                        c = (char) ((int) op.charAt(0) + 23 - 1);
                    else
                        c = 'Z';
                }
                case "Y" -> c = (char) ((int) op.charAt(0) + 23);
                case "Z" -> {
                    if (!op.equals("C"))
                        c = (char) ((int) op.charAt(0) + 23 + 1);
                    else
                        c = 'X';
                }
            }
            String con = op + " " + c;
            score += lup.get(s);
            ans += lup.get(con);
        }
        System.out.printf("Part 1: %d%n", score);
        System.out.printf("Part 2: %d%n", ans);
    }
}
