class Solution {
    public class Cell{
        int r;
        int c;
        int height;

        Cell(int r, int c, int height){
            this.r = r;
            this.c = c;
            this.height = height;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] vis = new boolean[m][n];

        if(heightMap == null || m == 0 || heightMap[0].length == 0){
            return 0;
        } 

        PriorityQueue<Cell> q = new PriorityQueue<>(1, new Comparator<Cell>(){
            public int compare(Cell a, Cell b){
                return a.height - b.height;
            }
        });

        for(int i = 0; i < m; i++){
            vis[i][0] = true;
            vis[i][n-1] = true;
            q.offer(new Cell(i, 0, heightMap[i][0]));
            q.offer(new Cell(i, n-1, heightMap[i][n-1]));
        }
        for(int i = 0; i < n; i++){
            vis[0][i] = true;
            vis[m-1][i] = true;
            q.offer(new Cell(0, i, heightMap[0][i]));
            q.offer(new Cell(m-1, i, heightMap[m-1][i]));
        }

        int[][] d = new int[][]{{-1, 0}, {1, 0},{0, -1},{0, 1}};
        int result = 0;
        while(!q.isEmpty()){
            Cell cell = q.poll();
            for(int[] dir : d){
                int r = cell.r + dir[0];
                int c = cell.c + dir[1];
                if(r >= 0 && r < m && c < n && c >= 0 && !vis[r][c]){
                    vis[r][c] = true;
                    result += Math.max(0, cell.height - heightMap[r][c]);
                    q.offer(new Cell(r, c, Math.max(heightMap[r][c], cell.height)));
                }
            }
        }
        return result;
    }
}