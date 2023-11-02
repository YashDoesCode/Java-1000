public class FloodFill2D {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) { int old = image[sr][sc];
        if (old != color) dfs(image, sr, sc, old, color);
        return image;
    } private void dfs(int[][] img, int r, int c, int old, int color) { if (r < 0 || c < 0 || r >= img.length || c >= img[0].length || img[r][c] != old) return;
        img[r][c] = color;
        dfs(img, r + 1, c, old, color);
        dfs(img, r - 1, c, old, color);
        dfs(img, r, c + 1, old, color);
        dfs(img, r, c - 1, old, color);
    };
}
