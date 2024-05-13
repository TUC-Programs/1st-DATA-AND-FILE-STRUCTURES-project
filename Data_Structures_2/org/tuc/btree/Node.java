package org.tuc.btree;


public class Node {
    private int T;

    int n;
    int key[];
    Node child[];
    boolean leaf = true;

    public Node(int T) {
    	this.T = T;
    	key = new int[2 * T - 1];
    	child = new Node[2 * T];
    }
    public int search(int k) {
      for (int i = 0; i < this.n; i++) {
        if (this.key[i] == k) {
          return i;
        }
      }
      return -1;
    };
  }
