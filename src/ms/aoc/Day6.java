package ms.aoc;

import java.util.List;

public class Day6 extends Day {
    public Day6() {
        super("6");
    }

    @Override
    void solve(List<String> input) {
        System.out.printf("Part 1: %d%n", getIndexOfPaket(input, 4));
        System.out.printf("Part 2: %d%n", getIndexOfPaket(input, 14));
    }

    int getIndexOfPaket(List<String> input, int length) {
        String buffer = input.get(0);
        int index = -1;
        for (int i = 0; i < buffer.length(); i++) {
            String paket = "";
            boolean b = false;
            paket = buffer.substring(i, i + length);
            for (int j = i; j < i + length; j++) {
                int ind = paket.indexOf(buffer.charAt(j), paket.indexOf(buffer.charAt(j)) + 1);
                if (ind != -1) {
                    b = true;
                    break;
                }
            }
            if (!b) {
                index = i + length;
                break;
            }
        }
        return index;
    }
}
