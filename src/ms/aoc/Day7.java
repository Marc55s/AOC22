package ms.aoc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Day7 extends Day {

    public Day7() {
        super("7");
    }

    @Override
    void solve(List<String> input) {
        Stack<String> navi = new Stack<>();
        Map<String, Long> sizeOfDirectory = new HashMap<>();
        for (String line : input) {
            String[] l = line.split(" ");
            if (l[0].equals("$")) {
                if (l[1].equals("cd")) {
                    if (l[2].equals("..")) {
                        //change to higher dir
                        navi.pop();
                    } else {
                        navi.push(l[2]);
                    }
                }
            } else if (!l[0].equals("dir")) {
                long v = Long.parseLong(line.split(" ")[0]);
                boolean b = false;
                for (int j = 0; j < navi.size(); j++) {
                    String c = "";
                    for (int k = 0; k < j + 1; k++) {
                        c = c.concat(navi.get(k) + ",");
                    }
                    if (sizeOfDirectory.containsKey(c))
                        sizeOfDirectory.computeIfPresent(c, (s, aLong) -> aLong + v);
                    else
                        sizeOfDirectory.put(c, v);

                }
            }
        }


        long ans = 0;
        long totalDiskSpace = 70_000_000;
        long neededSpace = 30_000_000;
        long smallestDir = totalDiskSpace;
        long outermostDirSize = sizeOfDirectory.get("/,");
        for (Map.Entry<String, Long> entry : sizeOfDirectory.entrySet()) {
            if (entry.getValue() <= 100_000) {
                ans += entry.getValue();
            }
            if (totalDiskSpace - outermostDirSize + entry.getValue() >= neededSpace) {
                smallestDir = Math.min(entry.getValue(), smallestDir);
            }
        }

        System.out.printf("Part 1: %d%n", ans);
        System.out.printf("Part 2: %d", smallestDir);
    }
}
