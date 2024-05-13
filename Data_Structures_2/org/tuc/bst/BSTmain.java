package org.tuc.bst;

import java.util.Scanner;

public class BSTmain
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        BSTree tree = new BSTree();
        while(true)
        {
            System.out.println("\n\n1. Insert\n2. Delete\n3. Search\n4. Inorder traversal\n5. Preorder traversal\n6. Postorder traversal\n7. Exit");
            int choice = scan.nextInt();
            if(choice == 7) {
                System.out.println("Exit");
                break;
            }
            switch(choice) {
                case 1:
                {
                    System.out.println("Enter the elements to insert and enter -999 to stop:");
                    while(scan.hasNext()) {
                        int temp = scan.nextInt();
                        if(temp == -999)
                            break;
                        tree.insert(temp);
                    }
                    System.out.println("\nInOrder Traversal :");
                    tree.InOrder(tree.Root);
                    System.out.println("\nPreOrder Traversal :");
                    tree.PreOrder(tree.Root);
                    break;
                }

                case 2:
                {
                    System.out.println("Enter the element to be deleted:");
                    int temp = scan.nextInt();
                    tree.delete(temp);
                    System.out.println("\nInOrder Traversal :");
                    tree.InOrder(tree.Root);
                    System.out.println("\nPreOrder Traversal :");
                    tree.PreOrder(tree.Root);
                    break;
                }

                case 3:
                {
                    System.out.println("Enter the element to be searched:");
                    int temp = scan.nextInt();
                    int c = tree.search(temp);
                    if(c==0)
                        System.out.println("\nKey not found");
                    else
                        System.out.println(temp + "found");
                }

                case 4:
                {
                    System.out.println("\nInOrder Traversal :");
                    tree.InOrder(tree.Root);
                    break;
                }

                case 5:
                {
                    System.out.println("\nPreOrder Traversal :");
                    tree.PreOrder(tree.Root);
                    break;
                }
                case 6:
                {
                    System.out.println("\nPostOrder Traversal :");
                    tree.PostOrder(tree.Root);
                    break;
                }

            }
        }
    }
}