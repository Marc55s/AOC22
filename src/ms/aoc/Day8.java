package ms.aoc;

import java.util.ArrayList;
import java.util.List;

public class Day8 extends Day {
    public Day8() {
        super("8");
    }

    @Override
    void solve(List<String> input) {
        int[][] map = new int[input.size()][input.get(0).length()];
        int ans = 0;
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).length(); j++) {
                map[i][j] = Integer.parseInt(String.valueOf(input.get(i).charAt(j)));
            }
        }
        List<Integer> max = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).length(); j++) {
                if(isVisible(map, i, j)){
                   ans++;
                }
                max.add(getScenicScore(map,i,j));
            }
        }
        System.out.printf("Part 1: %d%n",ans);
        int highestScenic = max.stream().mapToInt(e -> e).max().getAsInt();
        System.out.printf("Part 2: %d",highestScenic);
    }

    boolean isVisible(int[][] map, int i, int j) {
        if(i == 0 || i == map.length-1|| j == 0 || j == map[0].length-1){
            return true;
        }
        boolean down = true;
        boolean up = true;
        boolean left = true;
        boolean right = true;
        for (int l = i+1; l < map.length; l++) {
            if (map[i][j] <= map[l][j]) {
                down = false;
                break;
            }
        }
        for (int l = i-1; l >= 0; l--) {
            if (map[i][j] <= map[l][j]) {
                up = false;
                break;
            }
        }
        for (int l = j-1; l >= 0; l--) {
            if (map[i][j] <= map[i][l]) {
                left = false;
                break;
            }
        }
        for (int l = j+1; l < map.length; l++) {
            if (map[i][j] <= map[i][l]) {
                right = false;
                break;
            }
        }
        return left || right || up || down;
    }
    int getScenicScore(int[][] map, int i, int j) {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for (int l = i+1; l < map.length; l++) {
           a++;
            if (map[i][j] <= map[l][j]) {
                break;
            }
        }
        for (int l = i-1; l >= 0; l--) {
            b++;
            if (map[i][j] <= map[l][j]) {
                break;
            }
        }
        for (int l = j-1; l >= 0; l--) {
            c++;
            if (map[i][j] <= map[i][l]) {
                break;
            }
        }
        for (int l = j+1; l < map.length; l++) {
            d++;
            if (map[i][j] <= map[i][l]) {
                break;
            }
        }
        return a*b*c*d;
    }
}
