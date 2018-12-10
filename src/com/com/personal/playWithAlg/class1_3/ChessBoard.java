package com.personal.playWithAlg.class1_3;

/**
 * Created by mingyue on 2018/11/4.
 */
public class ChessBoard {

    int tile = 1; //表示L型骨牌的编号
    int[][] board = new int[4][4]; //表示棋盘


    //处理带有特殊棋子的棋盘，tr，tc 分别表示棋盘的入口即左上角的行列号，dr，dc 分别表示特殊棋子的行列位置，size表示棋盘的行数或者列数
    public void chessBoard(int tr, int tc, int dr, int dc, int size) {
        if (size == 1) {
            return ;
        }
        int t = tile++;
        System.out.println(t);
        int s = size / 2; //每一次化大棋盘为小一半的小棋盘
        //先处理左上角的棋盘
        if (dr < tr + s && dc < tc + s) { //左上角棋盘有特殊棋子
            chessBoard(tr, tc, dr, dc, s); //
        } else { //左上角棋盘无特殊棋子
            board[tr + s - 1][tc + s - 1] = t;//
            chessBoard(tr, tc, tr + s -1, tc + s -1, s);
        }

        //处理右上角的棋盘
        if (dr < tr + s && dc >= tc + s) { //右上角有特殊棋子
            chessBoard(tr, tc + s, dr, dc, s); //
        } else {
            board[tr + s - 1][tc + s] = t; //
            chessBoard(tr, tc + s, tr + s -1, tc + s, s); //
        }

        //处理左下角的棋盘
        if (dr >= tr + s && dc < tc + s) {
            chessBoard(tr + s, tc, dr, dc, s); //左下角有特殊棋子
        } else {
            board[tr + s][tc + s - 1] = t; //
            chessBoard(tr + s, tc, tr + s, tc + s - 1,s); //
        }

        //处理右下脚的棋盘
        if (dr >= tr + s && dc >= tc + s){
            chessBoard(tr + s, tc + s, dr, dc, s);//右下角有特殊棋子
        } else {
            board[tr + s][tc + s] = t; //
            chessBoard(tr + s , tc + s, tr + s, tc + s, s ); //
        }
    }

}
