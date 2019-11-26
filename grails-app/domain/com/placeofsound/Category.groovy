package com.placeofsound

class Category {

    long id
    String name
    int treeNode
    Integer parentId

    static constraints = {}

    Category(Category category) {
        id = category.id
        name = category.name
        treeNode = category.treeNode
        parentId = category.parentId
    }

    static class TreeNode {
        long id
        String name
        int treeNode
        List<Category.TreeNode> children
        Category parent

        TreeNode(long id, String name, int treeNode, Category parent, List<Category.TreeNode> children) {
            this.id = id
            this.name = name
            this.treeNode = treeNode
            this.parent = parent
            this.children = children
        }

    }

}
