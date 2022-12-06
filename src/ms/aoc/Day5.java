package ms.aoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Day5 extends Day {
    public Day5() {
        super("5");
    }

    @Override
    void solve(List<String> input) {
        List<Stack<String>> cargo = new ArrayList<>();
        List<Stack<String>> fastCargo = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            cargo.add(new Stack<>());
            fastCargo.add(new Stack<>());
        }
        for (int i = 0; i < 8; i++) {
            int stackCounter = 0;
            char[] line = input.get(i).toCharArray();
            for (int j = 1; j < line.length; j += 4) {
                if (!Character.isSpaceChar(line[j])) {
                    cargo.get(stackCounter).push(String.valueOf(line[j]));
                    fastCargo.get(stackCounter).push(String.valueOf(line[j]));
                }
                stackCounter++;
            }
        }

        cargo.forEach(Collections::reverse);
        fastCargo.forEach(Collections::reverse);
        input.subList(0, 10).clear();
        for (String value : input) {
            String[] f = value.trim().split(" ");
            int cratesToBeMoved = Integer.parseInt(f[1].trim());
            int from = Integer.parseInt(f[3].trim());
            int to = Integer.parseInt(f[5].trim());
            List<String> crane = new ArrayList<>();
            for (int j = 0; j < cratesToBeMoved; j++) {
                crane.add(fastCargo.get(from - 1).pop());
                cargo.get(to - 1).push(cargo.get(from - 1).pop());
            }
            Collections.reverse(crane);
            for (String s : crane) {
                fastCargo.get(to - 1).push(s);
            }
        }
        System.out.print("Part 1: ");
        cargo.forEach(e -> System.out.print(e.peek()));
        System.out.print("\nPart 2: ");
        fastCargo.forEach(e -> System.out.print(e.peek()));

    }
}
