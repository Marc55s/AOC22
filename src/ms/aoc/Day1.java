package ms.aoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 extends Day{

    public Day1() {
        super("1");
    }

    @Override
    void solve(List<String> input) {
        int cal = 0;
        int max = 0;
        ArrayList<Integer> sumCals = new ArrayList<>();
        for (String s : input) {
            if (!s.isEmpty()) {
                cal += Integer.parseInt(s);
            } else {
                max = Math.max(max, cal);
                sumCals.add(cal);
                cal = 0;
            }
        }
        var p2= sumCals.stream().sorted(Collections.reverseOrder()).limit(3).mapToInt(i -> i).sum();
        System.out.printf("Part 1: %d%n",max);
        System.out.printf("Part 2: %d%n",p2);
    }
}
