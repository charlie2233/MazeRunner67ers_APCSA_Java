import java.util.*;

public class Path_Finder {
    // BFS that returns the path of cells from start to goal (inclusive), or null if none.
    public static java.util.List<Kid_67_Aura.Point> bfsPath(int[][] grid, Kid_67_Aura.Point start, Kid_67_Aura.Point goal) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Kid_67_Aura.Point[][] parent = new Kid_67_Aura.Point[n][m];
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<Kid_67_Aura.Point> q = new LinkedList<>();
        q.add(start);
        vis[start.x][start.y] = true;
        while (!q.isEmpty()) {
            Kid_67_Aura.Point cur = q.poll();
            if (cur.x == goal.x && cur.y == goal.y) break;
            for (int[] d : dirs) {
                int nx = cur.x + d[0], ny = cur.y + d[1];
                if (nx>=0 && ny>=0 && nx<n && ny<m && !vis[nx][ny] && grid[nx][ny]==0) {
                    vis[nx][ny] = true;
                    parent[nx][ny] = cur;
                    q.add(new Kid_67_Aura.Point(nx, ny));
                }
            }
        }
        if (!vis[goal.x][goal.y]) return null;
        java.util.LinkedList<Kid_67_Aura.Point> path = new LinkedList<>();
        Kid_67_Aura.Point cur = goal;
        while (cur != null) {
            path.addFirst(cur);
            cur = parent[cur.x][cur.y];
        }
        return path;
    }
}
