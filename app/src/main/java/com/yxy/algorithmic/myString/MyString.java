package com.yxy.algorithmic.myString;

import java.util.ArrayList;
import java.util.List;

public class MyString {

    // 6 z字形变换
    public String covert(String s, int numRows) {
        if (numRows == 1) return s;//注意这里这个边界条件，要不后边会数组越界list.get(row).append(array[i]);
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {//注意这里这个判断条件，体现逻辑和思维的严谨性
            list.add(new StringBuilder());
        }
        int row = 0;
        boolean goingDown = false;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            list.get(row).append(array[i]);
            //注意这里的边界条件，两边都要进行边界替换
            if (row == 0 || row == numRows - 1) goingDown = !goingDown;
            row += goingDown ? 1 : -1;//这里在字母摆放的时候是没有空格的，只要确保最后输出的结果是正确的就可以
            //中间的运算过程只是一个推算的过程
        }
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < list.size(); j++) {
            result.append(list.get(j));
        }
        return result.toString();
    }
}
