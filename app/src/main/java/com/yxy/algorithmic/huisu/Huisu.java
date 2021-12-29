package com.yxy.algorithmic.huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * 回溯公式
 * List<Value> res
 * void backtrack(路径，选择列表){
 *     if(满足条件){
 *          res.add(路径)
 *         return
 *     }
 *      if（选择：选择列表）{
 *            做选择
 *            backtrack(路径，选择列表)
 *            撤销选择
 *       }
 * }
 *
 */

public class Huisu {


    //回溯算法，穷举，构造遍历多叉树，然后递归去调用
    //1.全排列
    private static List<List<Integer>> res=new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track=new LinkedList<>();
        backtrace(nums,track);
        return res;
    }
    private static void backtrace(int[] nums,LinkedList<Integer> track){
        if(track.size()==nums.length){
            res.add(new LinkedList(track));
        }
        for (int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])){
                continue;
            }
            //这种for循环加递归的形式，是for循环代码先执行完毕，然后再执行递归，然后再执行
            //递归之后的代码，for循环里代码执行几次，后边递归和递归后的函数就会对应的执行几次
            track.add(nums[i]);
            backtrace(nums,track);
            track.removeLast();
        }

    }

    //2.全排列去重(注意这里的这个去重逻辑，是加在for循环的)
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int[] visit=new int[nums.length];
        List<Integer> track=new ArrayList<>();
        backTrack(nums,track,visit);
        return result;
    }
    private void backTrack(int[] nums,List<Integer> track,int[] visit){
        if(track.size()==nums.length){
            result.add(new ArrayList<>(track));
        }
        for (int i = 0; i < nums.length; i++) {
            if(visit[i]==1){
                continue;
            }
            if(i>0&&nums[i]==nums[i-1]&&visit[i-1]==0){
                continue;
            }
            track.add(nums[i]);
            visit[i]=1;
            backTrack(nums,track,visit);
            visit[i]=0;
            track.remove(track.size()-1);
        }
    }

    //3.n皇后,也是按照那个公式去做的，注意一下一些基本的语法，比如二维数组构建，填充，回溯公式调用，以及char和数组
    //的来回转换，还有终止条件
    List<List<String>> queueRes=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        queueBackTrack(board,0);
        return queueRes;
    }

    private void queueBackTrack(char[][] board,int row){
        if(row==board.length){
            queueRes.add(charToList(board));
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if(!isValid(board,row,col)){
                continue;
            }
            board[row][col]='Q';
            queueBackTrack(board,row+1);
            board[row][col]='.';
        }
    }

    private boolean isValid(char[][] board,int row,int col){
        //检查列冲突
        int n=board.length;
        for (int i = 0; i < n; i++) {
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //检查右上角
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if(board[i][j]=='Q'){
                    return false;
                }
        }
        //检查左上角
        for (int i = row - 1,j = col - 1; i >= 0 && j >= 0 ; i--, j--) {
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }


    private List<String> charToList(char[][] board){
        List<String> list=new ArrayList<>();
        for(char[] c : board){
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    //4.电话号码的字母组合

}
