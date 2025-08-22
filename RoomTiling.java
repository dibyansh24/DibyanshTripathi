public class RoomTiling {
    public static void main(String[] args) {
        int M = 4; // room size 4x4
        int[][] room = new int[M][M];
        int tileId = 1;

        for (int sz = M; sz >= 1; sz--) {
            boolean placed = false;
            for (int i = 0; i <= M - sz; i++) {
                for (int j = 0; j <= M - sz; j++) {
                    if (canPlace(room, i, j, sz)) {
                        placeTile(room, i, j, sz, tileId++);
                        placed = true;
                        break;
                    }
                }
                if (placed) break;
            }
        }
        // Print room filled
        for (int[] r : room) {
            for (int cell : r) System.out.print(cell + " ");
            System.out.println();
        }
    }
    static boolean canPlace(int[][] room, int r, int c, int sz) {
        for (int i = r; i < r + sz; i++)
            for (int j = c; j < c + sz; j++)
                if (room[i][j] != 0) return false;
        return true;
    }
    static void placeTile(int[][] room, int r, int c, int sz, int tileId) {
        for (int i = r; i < r + sz; i++)
            for (int j = c; j < c + sz; j++)
                room[i][j] = tileId;
    }
}

