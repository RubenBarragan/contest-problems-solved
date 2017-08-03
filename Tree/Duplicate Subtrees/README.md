#  Find duplicate subtrees

## Problem
> Given a binary tree, return all **duplicate subtrees**. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

**Defitinion (Duplicate Tree)**. Two trees are duplicate if they have the same structure with same node values.

## Example
Given a tree *T*.

              1
            /   \
          2      3
         /      /   \
        4     2     4
             /
          4

The duplicate subtrees that are contained in *T* are:
```
     2
   /
4
```
and:
```
4
```
The last two subtrees are repeated in *T*, and by definition, they have the same structure and same value.