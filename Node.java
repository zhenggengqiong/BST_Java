package com.Tree.BST;
//创建结点

import java.util.LinkedList;
import java.util.Queue;

public class Node {
	int data;
	Node lchild;
	Node rchild;

	public Node(int data) {
		this.data = data;
	}

	// -------插入功能---------

	// 添加结点的方法--递归实现
	public void add(Node node) {
		if (node == null) {
			return;
		}
		// 判断添加结点与当前子树根节点的大小关系
		if (node.data < this.data) {
			if (this.lchild == null) {
				this.lchild = node;
			} else {
				// 递归向左子树添加
				this.lchild.add(node);
			}
		} else {
			if (this.rchild == null) {
				this.rchild = node;
			} else {
				// 递归向右子树添加 如果有相等的结点，则设添加到右子树
				this.rchild.add(node);
			}
		}
	}
	/* 插入功能结束 */

	// -------删除功能---------

	// 查找要删除的结点
	public Node search(int data) {
		if (this.data == data) {// 如果当前结点即为所查找的值，直接返回该节点
			return this;
		} else if (data < this.data) {// 如果查找的值小于当前结点，向左子树递归查找
			// 如果左子结点空
			if (this.lchild == null) {
				return null;
			}
			return this.lchild.search(data);
		} else {// 如果查找的值大于等于当前结点，向右子树递归查找
			if (this.rchild == null) {
				return null;
			}
			return this.rchild.search(data);
		}
	}

	// 查找要删除节点的父节点
	public Node searchParent(int data) {
		// 如果当前结点就是要删除的结点的父节点，则返回
		if ((this.lchild != null && this.lchild.data == data) || (this.rchild != null && this.rchild.data == data)) {
			return this;
		} else {
			// 如果要查找的值小于当前结点的值，并且当前结点的左子节点不为空
			if (data < this.data && this.lchild != null) {
				return this.lchild.searchParent(data);// 向左子树递归查找
			} else if (data >= this.data && this.rchild != null) {
				return this.rchild.searchParent(data);// 向右子树递归查找
			} else {
				return null; // 无父节点，返回空
			}
		}
	}
	/* 删除功能结束 */

	// --------遍历功能--------

	// 前序遍历--递归实现
	public void preOrderTraverse() {
		System.out.print(this.data + "->");

		if (this.lchild != null) {
			this.lchild.infixOrderTraverse();
		}

		if (this.rchild != null) {
			this.rchild.infixOrderTraverse();
		}
	}

	// 中序遍历--递归实现
	public void infixOrderTraverse() {
		if (this.lchild != null) {
			this.lchild.infixOrderTraverse();
		}
		System.out.print(this.data + "->");
		if (this.rchild != null) {
			this.rchild.infixOrderTraverse();
		}
	}

	// 后序遍历--递归实现
	public void postOrderTraverse() {
		if (this.lchild != null) {
			this.lchild.infixOrderTraverse();
		}

		if (this.rchild != null) {
			this.rchild.infixOrderTraverse();
		}

		System.out.print(this.data + "->");
	}
	
	
	
}
