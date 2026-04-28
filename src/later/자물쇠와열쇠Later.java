package later;

class 자물쇠와열쇠Later {
    int n;
    int m;

    public boolean solution(int[][] key, int[][] lock) {
        n = lock.length;
        m = key.length;

        for (int dir = 0; dir < 4; dir++) {
            if (canOpen(key, lock)) return true;
            key = rotate(key);
        }

        return false;
    }

    boolean canOpen(int[][] key, int[][] lock) {
        int size = n * 3;
        int[][] board = new int[size][size];

        // 가운데에 lock 배치
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                board[y + n][x + n] = lock[y][x];
            }
        }

        // key의 시작 위치를 전부 시도
        for (int sy = 0; sy <= size - m; sy++) {
            for (int sx = 0; sx <= size - m; sx++) {

                int[][] copy = copyBoard(board);

                // key 올리기
                for (int y = 0; y < m; y++) {
                    for (int x = 0; x < m; x++) {
                        copy[sy + y][sx + x] += key[y][x];
                    }
                }

                if (check(copy)) return true;
            }
        }

        return false;
    }

    boolean check(int[][] board) {
        // lock 영역이 전부 1이어야 함
        for (int y = n; y < 2 * n; y++) {
            for (int x = n; x < 2 * n; x++) {
                if (board[y][x] != 1) return false;
            }
        }

        return true;
    }

    int[][] rotate(int[][] key) {
        int[][] rotated = new int[m][m];

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < m; x++) {
                rotated[x][m - 1 - y] = key[y][x];
            }
        }

        return rotated;
    }

    int[][] copyBoard(int[][] board) {
        int[][] copy = new int[board.length][board.length];

        for (int i = 0; i < board.length; i++) {
            copy[i] = board[i].clone();
        }

        return copy;
    }
}