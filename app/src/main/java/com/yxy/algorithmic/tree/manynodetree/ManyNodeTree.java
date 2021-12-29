package com.yxy.algorithmic.tree.manynodetree;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 多叉树
 * https://blog.csdn.net/shanzhizi/article/details/13022749
 */
public class ManyNodeTree {
    public static final String ROOT = "root";
    private ManyTreeNode root;

    public ManyNodeTree() {
        root = new ManyTreeNode(new TreeNode(ROOT));
    }

    public ManyNodeTree createManyNodeTree(List<TreeNode> treeNodes) {
        if (treeNodes == null || treeNodes.size() < 0) {
            return null;
        }

        ManyNodeTree manyNodeTree = new ManyNodeTree();
        for (TreeNode treeNode : treeNodes) {
            if (treeNode.getParentId().equals(ROOT)) {
                manyNodeTree.getRoot().getChildList().add(new ManyTreeNode(treeNode));
            } else {
                addChild(manyNodeTree.getRoot(), treeNode);
            }
        }
        return manyNodeTree;
    }

    private void addChild(ManyTreeNode manyTreeNode, TreeNode child) {
        for (ManyTreeNode item : manyTreeNode.getChildList()) {
            if (item.getData().getNodeId().equals(child.getParentId())) {
                item.getChildList().add(new ManyTreeNode(child));
                break;
            } else {
                if (item.getChildList() != null && item.getChildList().size() > 0) {
                    addChild(item, child);
                }
            }
        }
    }

    //这种结构是竖向递归，只有第一个for循环的的值对应的递归执行完毕了，才会去执行外层的for循环的第二个值，然后第二个值
    //对应的再进行一个深度的循环
    public String iteratorTree(ManyTreeNode manyTreeNode) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("\n");
        if (manyTreeNode != null) {
            for (ManyTreeNode index : manyTreeNode.getChildList()) {
                buffer.append(index.getData().getNodeId());
                Log.i("tag5", "" + index.getData().getNodeId());
                if (index.getChildList() != null && index.getChildList().size() > 0) {
                    buffer.append(iteratorTree(index));
                }
            }
        }
        buffer.append("\n");
        return buffer.toString();
    }

    public ManyTreeNode getRoot() {
        return root;
    }

    public void setRoot(ManyTreeNode root) {
        this.root = root;
    }


}
