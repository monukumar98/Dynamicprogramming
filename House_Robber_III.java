package Dynamicprogramming;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class House_Robber_III {
	static Scanner sc = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public House_Robber_III() {
		this.root = CreateNode();

	}

	private Node CreateNode() {
		int item = sc.nextInt();
		Node node = new Node();
		node.data = item;
		this.root = node;
		LinkedList<Node> q = new LinkedList<>();
		q.add(node);
		while (!q.isEmpty()) {
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();
			node = q.removeFirst();
			if (c1 != -1) {
				Node nn = new Node();
				nn.data = c1;
				node.left = nn;
				q.addLast(node.left);
			}
			if (c2 != -1) {
				Node nn = new Node();
				nn.data = c2;
				node.right = nn;
				q.addLast(node.right);
			}
		}
		return this.root;

	}

	public int Hous_Robber3() {
		HashMap<Node, Integer> map = new HashMap<Node, Integer>();
		return Hous_Robber3(this.root, map);
	}

	private int Hous_Robber3(Node node, HashMap<Node, Integer> map) {
		if (node == null) {
			return 0;
		}

		if (map.containsKey(node)) {
			return map.get(node);
		}
		int ans1 = node.data;
		if (node.left != null) {
			ans1 += Hous_Robber3(node.left.left, map) + Hous_Robber3(node.left.right, map);
		}
		if (node.right != null) {
			ans1 += Hous_Robber3(node.right.right, map) + Hous_Robber3(node.right.left, map);
		}

		int ans2 = Hous_Robber3(node.left, map) + Hous_Robber3(node.right, map);

		map.put(node, Math.max(ans1, ans2));
		return Math.max(ans1, ans2);
	}

	public void Display() {
		Display(this.root);
	}

	private void Display(Node node) {
		if (node == null) {
			return;
		}
		String str = "";
		if (node.left != null) {
			str += node.left.data;
			str += "<-";
		} else {
			str += ".";
			str += "<-";
		}
		str += node.data;
		str += "->";
		if (node.right != null) {
			str += node.right.data;

		} else {
			str += ".";

		}
		System.out.println(str);
		Display(node.left);
		Display(node.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		House_Robber_III hr = new House_Robber_III();
		//hr.Display();
		System.out.println(hr.Hous_Robber3());

	}

}
