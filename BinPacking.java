
public class BinPacking {
    static class Tile {
        int width, height, id;
        Tile(int id, int w, int h) { this.id = id; width = w; height = h; }
    }
    public static void main(String[] args) {
        int containerW = 10;
        int containerH = 4;
        Tile[] tiles = {
            new Tile(1, 5, 1), 
            new Tile(2, 3, 1),
            new Tile(3, 2, 1),
            new Tile(4, 4, 1)
        };
        // Container grid
        int[][] container = new int[containerH][containerW];
        int currRow = 0, currCol = 0;
        for (Tile t : tiles) {
            if (currCol + t.width > containerW) {
                currRow++;
                currCol = 0;
            }
            if (currRow < containerH) {
                for (int j = currCol; j < currCol + t.width; j++)
                    container[currRow][j] = t.id;
                currCol += t.width;
            }
        }
        // Print packed container
        for (int[] row : container) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}