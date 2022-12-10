package ms.aoc;

import java.awt.Point;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day9 extends Day {

    public Day9() {
        super("9");
    }

    Point head;
    Point[] tails;

    @Override
    void solve(List<String> input) {
        Set<Point> uniqueLastTail = new HashSet<>();
        Set<Point> uniqueTail = new HashSet<>();

        tails = new Point[10];
        head = new Point(500, 500);

        for (int i = 0; i < tails.length; i++) {
            tails[i] = new Point(500, 500);
        }

        for (String s : input) {
            String[] lineSplit = s.split(" ");
            int moveUnits = Integer.parseInt(lineSplit[1]);
            for (int i = 0; i < moveUnits; i++) {
                switch (lineSplit[0]) {
                    case "R" -> head.x++;
                    case "L" -> head.x--;
                    case "U" -> head.y++;
                    case "D" -> head.y--;
                }
                followHead(tails[0], head);
                for (int j = 0; j < tails.length - 1; j++) {
                    followHead(tails[j + 1], tails[j]);
                    uniqueTail.add(new Point(tails[0].x, tails[0].y));
                    uniqueLastTail.add(new Point(tails[8].x, tails[8].y));
                }
            }
        }
        System.out.printf("Part 1: %d%n", uniqueTail.size());
        System.out.printf("Part 2: %d", uniqueLastTail.size());
    }

    private void followHead(Point tail, Point head) {
        if (tail.distance(head) == 2) {
            if (tail.y == head.y) {
                if (tail.x < head.x) {
                    tail.x++;
                } else {
                    tail.x--;
                }
            } else if (tail.x == head.x) {
                if (tail.y < head.y) {
                    tail.y++;
                } else {
                    tail.y--;
                }
            }
        } else if (tail.distance(head) == Math.sqrt(5) || tail.distance(head) == Math.sqrt(8)) {
            if (head.x > tail.x && head.y > tail.y) {
                tail.x++;
                tail.y++;
            } else if (head.x > tail.x && head.y < tail.y) {
                tail.x++;
                tail.y--;
            } else if (head.x < tail.x && head.y > tail.y) {
                tail.x--;
                tail.y++;
            } else if (head.x < tail.x && head.y < tail.y) {
                tail.x--;
                tail.y--;
            }
        }
    }

    void print(String s) {
        System.out.println(s);
        for (int cw = 520; cw >= 489; cw--) {
            for (int c = 489; c < 520; c++) {
                Point current = new Point(c, cw);
                int a = 0;
                for (int j = 0; j < tails.length; j++) {
                    if (current.equals(tails[j])) {
                        a = j;
                    }
                }
                if (head.equals(current)) {
                    System.out.print("H");
                } else if (tails[a].equals(current)) {
                    System.out.print(a + 1);
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }
}
