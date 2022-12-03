package ms.aoc;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day3 extends Day {

    public Day3() {
        super("3");
    }

    @Override
    void solve(List<String> input) {
        //Part 1
        int priority = input.stream().map(s ->
                        IntStream.range(0, s.length())
                                .filter(e -> s.substring(0, s.length() / 2).contains(String.valueOf(s.charAt(e))) && s.substring(s.length() / 2).contains(String.valueOf(s.charAt(e))))
                                .map(s::charAt)
                                .map(e -> Integer.parseInt(String.valueOf(e)))
                                .distinct()
                                .map(b -> Character.isUpperCase(b) ? b - 38 : b - 96))
                .mapToInt(IntStream::sum)
                .sum();
        //Part 2
        int ans = 0;
        for (int i = 0; i < input.size() - 2; i += 3) {
            String s = input.get(i);
            String t = input.get(i + 1);
            String u = input.get(i + 2);
            var smallest = Stream.of(u, t, s).min(Comparator.comparingInt(String::length)).get();
            int minIndex = Stream.of(s.length(), t.length(), u.length()).mapToInt(e -> e).min().getAsInt();
            int priorityPerBP = 0;
            for (int j = 0; j < minIndex; j++) {
                char iterChar = smallest.charAt(j);
                String iterCharToString = String.valueOf(iterChar);
                if (s.contains(iterCharToString) && t.contains(iterCharToString) && u.contains(iterCharToString)) {
                    priorityPerBP = smallest.charAt(j);
                    break;
                }
            }
            //ascii charcode to priority
            if (Character.isLowerCase(priorityPerBP)) {
                priorityPerBP -= 96;
            } else {
                priorityPerBP -= 38;
            }
            ans += priorityPerBP;
        }
        System.out.printf("Part 1: %d%n", priority);
        System.out.printf("Part 2: %d", ans);
    }
}
