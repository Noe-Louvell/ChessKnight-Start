package com.jad.chessknight;

public abstract class ChessKnightProblem {
    public static void solve() throws CloneNotSupportedException {
        ChessBoard chessBoard = new ChessBoard();
        ChessKnight chessKnight = new ChessKnight(chessBoard, 0, 0);

        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
        chessBoard.saveStepAt(0, 0, 0);
        if (!solveKTUtil(0, 0, 1, xMove, yMove, chessKnight, chessBoard)) {
            System.out.println("Solution does not exist");
        } else
            System.out.println(chessBoard);
    }

    static boolean isSafe(int x, int y, ChessBoard chessBoard) {
        return (x >= 0 && x < 8 && y >= 0 && y < 8
                && chessBoard.getAt(x, y).getValue() == -1);
    }

    static boolean solveKTUtil(int x, int y, int movei, int xMove[], int yMove[], ChessKnight chessKnight,
            ChessBoard chessBoard) {
        int k, next_x, next_y;
        if (movei == 8 * 8)
            return true;

        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, chessBoard)) {
                chessBoard.saveStepAt(next_x, next_y, movei);
                if (solveKTUtil(next_x, next_y, movei + 1, xMove, yMove, chessKnight, chessBoard))
                    return true;
                else
                    chessBoard.saveStepAt(next_x, next_y, -1);
            }
        }

        return false;
    }

}
