package com.github.aroq.groflow

class Branch {
    String name

    Branch parent

    boolean autoMergeToParent = false

    String getParentName() { parent?.name }
}
