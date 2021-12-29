package com.yxy.algorithmic.dongtaiguihua;

import java.util.Arrays;

/**
 * 动态规划一般用来求最值，来穷举（递归）
 * 状态(会变的叫状态)转移方程
 * 穷举每个组合
 * <p>
 * 初始化base dp[0][0][...]=base(根据已知数据进行初始化赋值)
 * for循环 状态1 in 状态1的所有取值
 * for循环状态2 in 状态2的所有取值
 * for ...
 * dp[状态1][状态2][...]=求最值（选择1，选择2,...）
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
    public int fib2(int n) {
        if (n == 0) return 0;
        //初始化base
        int[] dp = new int[n + 1];//注意这个细节，这里的状态转移方程要+1 ,因为数组从0开始
        dp[0] = 0;
        dp[1] = 1;
        //状态转移(注意这里要加等号)
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //2.找零钱问题
    //画图分析，先分解出子问题,
    // 注意去重
    //变成求子问题所需硬币数加一，子问题就是总数-所有可能的单个硬币数目
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        return dp(coins, amount);
    }
    private int dp(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo[amount] != -666) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin);
            if (subProblem == -1) continue;
            res = Math.min(res, subProblem + 1);
        }
        //注意这里最后往备忘录存的是最终的计算结果
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }


}
