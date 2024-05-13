package org.tuc.btree;

public class BtreeMain
{
	 public static void main(String[] args) {
		    BTree b = new BTree(3);
		    b.insert(8);
		    b.insert(9);
		    b.insert(10);
		    b.insert(11);
		    b.insert(15);
		    b.insert(20);
		    b.insert(17);

		    b.Show();

		    b.delete(10);
		    System.out.println();
		    b.Show();
		  }
}