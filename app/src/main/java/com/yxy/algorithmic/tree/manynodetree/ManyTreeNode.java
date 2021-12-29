package com.yxy.algorithmic.tree.manynodetree;

import java.util.ArrayList;
import java.util.List;

/**
 * 多叉树节点
 */
public class ManyTreeNode {
    private TreeNode data;
    private List<ManyTreeNode> childList;

    public ManyTreeNode(TreeNode data) {
        this.data = data;
        childList = new ArrayList<>();
    }

    public ManyTreeNode(TreeNode data, List<ManyTreeNode> childList) {
        this.data = data;
        this.childList = childList;
    }

    public TreeNode getData() {
        return data;
    }

    public void setData(TreeNode data) {
        this.data = data;
    }

    public List<ManyTreeNode> getChildList() {
        return childList;
    }

    public void setChildList(List<ManyTreeNode> childList) {
        this.childList = childList;
    }
}
