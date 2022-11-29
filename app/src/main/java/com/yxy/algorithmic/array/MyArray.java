package com.yxy.algorithmic.array;

/**
 * 数组问题法宝--双指针 对复杂度进行优化
 */
public class MyArray {
    // leetcode 283 移动非0元素到前边，并且保证其相对顺序
    private void moveZero(int[] nums){
        if(nums==null)return;
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[j]=nums[i];
                j++;
            }
        }
        //第二次遍历，j指的位置也是需要变更为0的位置
        for (int i = j; i < nums.length; i++) {
            nums[j]=0;
        }
    }

}
