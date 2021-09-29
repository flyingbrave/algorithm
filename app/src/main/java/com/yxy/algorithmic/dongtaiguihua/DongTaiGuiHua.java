package com.yxy.algorithmic.dongtaiguihua;

/**
 * 动态规划一般用来求最值，来穷举（递归）
 * 状态(会变的叫状态)转移方程
 * 穷举每个组合
 *
 * 初始化base dp[0][0][...]=base(根据已知数据进行初始化赋值)
 * for循环 状态1 in 状态1的所有取值
 *    for循环状态2 in 状态2的所有取值
 *       for ...
 *         dp[状态1][状态2][...]=求最值（选择1，选择2,...）
 *
 *
 */
public class DongTaiGuiHua {
    //1。斐波那契数列（递归时间复杂度=递归方法执行的次数*递归方法一次的时间复杂度）
    //备忘录模式，进行减枝，进行空间换时间
    //自顶向下的递归过程
    public int fib(int n) {
        int[] memo = new int[n + 1];//因为数组索引是从0开始的
        return f(n, memo);
    }

    public int f(int n, int[] memo) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (memo[n] != 0) return memo[n];
        memo[n] = f(n - 1, memo) + f(n - 2, memo);
        return memo[n];
    }
    //1。斐波那契数列 自底向上的迭代解法
    public int fib2(int n){
        if(n==0) return 0;
        //初始化base
        int[] dp=new int[n+1];//注意这个细节，这里的状态转移方程要+1 ,因为数组从0开始
        dp[0]=0;
        dp[1]=1;
        //状态转移(注意这里要加等号)
        for (int i = 2; i <= n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    //2.找零钱问题



}
