package com.placeofsound

import grails.transaction.Transactional

@Transactional
class CategoryService {
    private final int FIRST_NODE = 0

    List<Category> getLOneCategories() {
        return Category.findAllByTreeNode(FIRST_NODE)
    }
}
