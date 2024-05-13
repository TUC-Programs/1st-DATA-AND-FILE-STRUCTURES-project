package org.tuc.avl;


class Node
{
    int value;
    int height;
    Node left;
    Node right;

    public Node(int value)
    {
        this.value = value;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}
