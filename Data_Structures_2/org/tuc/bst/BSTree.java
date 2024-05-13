package org.tuc.bst;

import org.tuc.interfaces.SearchInsert;

public class BSTree implements SearchInsert
{
    // NODE structure


    Node Root;

    @Override
    public boolean searchKey(int key){
        return findNode(Root, key) != null;
    }



    private Node insertNode(Node root, int key)
    {
        // Performs normal BST insertion
        if (root == null)
            return new Node(key);

        else if (key < root.value)
            root.left = insertNode(root.left, key);

        else
            root.right = insertNode(root.right, key);

        // Balances the tree after BST Insertion
        return root;
    }

    // Successor returns the next largest node
    private Node Successor(Node root)
    {
        if (root.left != null)
            return Successor(root.left);

        else
            return root;
    }


    private Node deleteNode(Node root, int key)
    {
        // Performs standard BST Deletion
        if (root == null)
            return root;

        else if (key < root.value)
            root.left = deleteNode(root.left, key);

        else if (key > root.value)
            root.right = deleteNode(root.right, key);

        else
        {
            if (root.right == null)
                root = root.left;

            else if (root.left == null)
                root = root.right;

            else
            {
                Node temp = Successor(root.right);
                root.value = temp.value;
                root.right = deleteNode(root.right, root.value);
            }
        }

        return root;
    }

    // findNode is used to search for a particular value given the root
    private Node findNode(Node root, int key)
    {
        if (root == null || key==root.value)
            return root;

        if (key < root.value)
            return findNode(root.left, key);

        else
            return findNode(root.right, key);
    }

    // Utility function for insertion of node
    public void insert(int key)
    {
        if (findNode(Root , key) == null)
        {
            Root = insertNode(Root , key);
            //System.out.println("Insertion successful");
        }

        else {
            //System.out.println("\nKey with the entered value already exists in the tree");
        }
    }

    
   
    public int search(int key)
    {
        if(findNode(Root, key) == null)
            return 0;
        else
            return 1;
    }

    // Utility function for deletion of node
    public void delete(int key)
    {
        if (findNode(Root , key) != null)
        {
            Root = deleteNode(Root , key);
            System.out.println("\nDeletion successful ");
        }

        else
            System.out.println("\nNo node with entered value found in tree");
    }

    public void InOrder(Node root)
    {
        if(root == null)
        {
            System.out.println("\nNo nodes in the tree");
            return;
        }

        if(root.left != null)
            InOrder(root.left);
        System.out.print(root.value + " ");
        if(root.right != null)
            InOrder(root.right);

    }

    public void PreOrder(Node root)
    {
        if(root == null)
        {
            System.out.println("No nodes in the tree");
            return;
        }

        System.out.print(root.value + " ");
        if(root.left != null)
            PreOrder(root.left);
        if(root.right != null)
            PreOrder(root.right);

    }

    public void PostOrder(Node key)
    {
        if(key == null)
        {
            System.out.println("No nodes in the tree");
            return;
        }


        if(key.left != null)
            PostOrder(key.left);
        if(key.right != null)
            PostOrder(key.right);
        System.out.print(key.value + " ");

    }

}
