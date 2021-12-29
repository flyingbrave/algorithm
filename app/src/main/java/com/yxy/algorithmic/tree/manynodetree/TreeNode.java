package com.yxy.algorithmic.tree.manynodetree;


/**
 * 普通节点
 */
public class TreeNode {
    private String parentId;
    private String nodeId;
    private String text;

    public TreeNode(String nodeId) {
        this.nodeId = nodeId;
    }

    public TreeNode(String nodeId, String parentId) {
        this.nodeId = nodeId;
        this.parentId = parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getParentId() {
        return parentId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public String getText() {
        return text;
    }
}
