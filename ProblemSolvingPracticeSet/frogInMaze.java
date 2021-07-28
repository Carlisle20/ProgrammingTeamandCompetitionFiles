/**
* Practice Set: Problem Solving.
* Written By: Carlisle Calabrese.
* Problem: Frog in Maze.
* Language Used: Java.
* Time to Solve: 6 Days.
* Solved: 4/5/2019.
* Last Modified: 7/28/2021.
*
*
**/

import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Map.Entry;

import static java.lang.Math.*;

public class Solution extends PrintWriter {

    void run() {
        int w = nextInt(), h = nextInt(), k = nextInt();

        char[][] m = new char[w][];

        int sx = 0, sy = 0;

        for (int x = 0; x < w; x++) {
            m[x] = next().toCharArray();

            for (int y = 0; y < h; y++) {
                if (m[x][y] == 'A') {
                    m[x][y] = 'O';
                    sx = x;
                    sy = y;
                }
            }
        }

        int[][] t = new int[w][h];

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                t[x][y] = -1;
            }
        }

        for (int i = 0; i < k; i++) {
            int ax = nextInt() - 1, ay = nextInt() - 1;
            int bx = nextInt() - 1, by = nextInt() - 1;

            t[ax][ay] = bx * h + by;
            t[bx][by] = ax * h + ay;
        }

        int[] dx = { +1, +0, -1, -0 };
        int[] dy = { +0, +1, -0, -1 };

        int[][] cnt = new int[w][h];

        for (int fx = 0; fx < w; fx++) {
            for (int fy = 0; fy < h; fy++) {
                for (int i = 0; i < 4; i++) {
                    int tx = fx + dx[i];
                    int ty = fy + dy[i];

                    if (0 <= tx && tx < w && 0 <= ty && ty < h && m[tx][ty] != '#') {
                        ++cnt[fx][fy];
                    }
                }
            }
        }

        int n = w * h;

        double[][] p = new double[n][n];

        for (int from = 0; from < n; from++) {
            int fx = from / h;
            int fy = from % h;

            if (m[fx][fy] == 'O' && cnt[fx][fy] > 0) {

                for (int i = 0; i < 4; i++) {
                    int tx = fx + dx[i];
                    int ty = fy + dy[i];

                    if (0 <= tx && tx < w && 0 <= ty && ty < h && m[tx][ty] != '#') {
                        int to = t[tx][ty];
                        if (to == -1) {
                            to = tx * h + ty;
                        }
                        p[to][from] = 1.0 / cnt[fx][fy];
                    }
                }

            } else {
                p[from][from] = 1;
            }
        }

//        for (int to = 0; to < n; to++) {
//            for (int from = 0; from < n; from++) {
//                printf(Locale.ENGLISH, "%.3f ", p[to][from]);
//            }
//            println();
//        }

        for (int rep = 0; rep < 16; rep++) {
            p = mul(n, p, n, p, n);
        }

        double[][] start = new double[n][1];

        start[sx * h + sy][0] = 1;

        double[][] finsh = mul(n, p, n, start, 1);

        double ans = 0;

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                if (m[x][y] == '%') {
                    ans += finsh[x * h + y][0];
                }
            }
        }

        printf(Locale.ENGLISH, "%.9f", ans);

    }

    double[][] mul(int n, double[][] a, int m, double[][] b, int k) {
        double[][] c = new double[n][k];

        for (int x = 0; x < n; x++) {
            for (int z = 0; z < k; z++) {
                for (int y = 0; y < m; y++) {
                    c[x][z] += a[x][y] * b[y][z];
                }
            }
        }

        return c;
    }

    int[][] nextMatrix(int n, int m) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matrix[i][j] = nextInt();
        return matrix;
    }

    String next() {
        while (!tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(nextLine());
        return tokenizer.nextToken();
    }

    boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String line = nextLine();
            if (line == null) {
                return false;
            }
            tokenizer = new StringTokenizer(line);
        }
        return true;
    }

    int[] nextArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException err) {
            return null;
        }
    }

    public Solution(OutputStream outputStream) {
        super(outputStream);
    }

    static BufferedReader reader;
    static StringTokenizer tokenizer = new StringTokenizer("");
    static Random rnd = new Random();

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution(System.out);
        solution.run();
        solution.close();
        reader.close();
    }
}
