/**
 * LeetCode 1232 - Check If It Is a Straight Line
 * 
 * Problem:
 * Given an array of coordinates, determine whether all the points
 * lie on a straight line in the XY plane.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public boolean checkStraightLine(int[][] coordinates) {

        // First two points
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];

        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];

        // Calculate differences
        int dx = x2 - x1;
        int dy = y2 - y1;

        // Check every remaining point
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];

            // Cross multiplication to avoid division
            if (dy * (x - x1) != dx * (y - y1)) {
                return false;
            }
        }

        return true;
    }
}
