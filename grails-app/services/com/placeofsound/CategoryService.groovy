package com.placeofsound

import grails.transaction.Transactional

import java.util.stream.Collectors

@Transactional
class CategoryService {

    List<Category> getAllCategories() {
        return Category.findAll()
    }

    List<Category.TreeNode> getCategoriesList() {
        List<Category> allCategories = getAllCategories()

        return allCategories.stream()
                .filter { c -> 0 == c.treeNode }
                .map { c ->
                    new Category.TreeNode(c.id, c.name, c.treeNode, null, allCategories.findAll { (c.id == it.parentId) }
                    .collect { new Category.TreeNode(it.id, it.name, it.treeNode, new Category(it), []) })
                }
                .collect(Collectors.toList())
    }
}
