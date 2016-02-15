package com.github.aroq.groflow.jobdsl.git

class Branch {
    String name

    Branch parent

    boolean autoMergeToParent = false

    String getParentName() { parent?.name }
}
