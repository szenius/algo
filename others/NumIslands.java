/**
 * Input:
 * 1 2 3 3 3
 * 1 4 4 3 3
 * 2 3 1 1 1
 * 
 * Expected output: 
 * 7
 * 
 * Explanation:
 * Found 7 regions of the same number congregated together
 */
import java.util.*;

class NumIslands {

    private static boolean traverse(int[][] map, boolean[][] visited, int i, int j, int prevI, int prevJ) {
        // Base case 1: index out of range
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length) {
            return false;
        }

        // Base case 2: already visited this cell
        if (visited[i][j]) {
            return false;
        }

        // Base case 3: cell no longer part of previously traversed island
        if (map[i][j] != map[prevI][prevJ]) {
            return false;
        }

        visited[i][j] = true;

        traverse(map, visited, i + 1, j, i, j); // down
        traverse(map, visited, i - 1, j, i, j); // up
        traverse(map, visited, i, j - 1, i, j); // left
        traverse(map, visited, i, j + 1, i, j); // right

        return true;
    }

    private static int countNumIslands(int[][] map) {
        int count = 0;

        boolean[][] visited = new boolean[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (traverse(map, visited, i, j, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 1 2 3 3 3
        // 1 4 4 3 3
        // 2 3 1 1 1
        int[][] test = new int[][]{{1, 2, 3, 3, 3}, {1, 4, 4, 3, 3}, {2, 3, 1, 1, 1}};
        System.out.println("Expected ans: " + 7 + "; Actual ans: " + countNumIslands(test));
    }
}
