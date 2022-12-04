package ms.aoc;

import java.util.List;

public class Day4 extends Day {

    public Day4() {
        super("4");
    }

    @Override
    void solve(List<String> input) {
        int ans = 0;
        int p2 = 0;
        for (int i = 0; i < input.size(); i++) {
            if (!input.get(i).isEmpty()) {
                String[] f = input.get(i).split(",");
                String[] range = f[0].split("-");
                String[] rangetwo = f[1].split("-");
                int one = Integer.parseInt(range[0]);
                int two = Integer.parseInt(range[1]);
                int three = Integer.parseInt(rangetwo[0]);
                int four = Integer.parseInt(rangetwo[1]);
                if ((one >= three && two <= four) || (three >= one && four <= two)) {

                    ans++;
                }

                boolean z = false;
                for (int j = one; j <= two; j++) {
                    if (z) break;
                    for (int k = three; k <= four; k++) {
                        if (k == j) {
                            p2++;
                            z = true;
                        }
                    }
                }
            }
        }
        System.out.printf("Part 1: %d%n",ans);
        System.out.printf("Part 2: %d%n",p2);

    }
}
