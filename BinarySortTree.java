package com.Tree.BST;

import java.util.LinkedList;
import java.util.Queue;

//创建二叉排序树

public class BinarySortTree {
	public Node root;// 根节点

	// 创建树
	public void createBST(int[] array) {
		for (int i = 0; i < array.length; i++) {
			add(new Node(array[i]));
		}
	}

	// -------查找功能---------
	Node lastNode = null;// 最近查找的结点
	int n = 1;// 计算查找长度
	// 查找数据，查找成功返回1，失败返回0

	public int searchData(Node node, int key) {
		if (node == null) {
			return 0;
		}
		if (key == node.data) {
			lastNode = node;
			return 1;
		} else if (key < node.data) {// 查找数据小于当前结点
			n++;
			return searchData(node.lchild, key);// 递归向左子树查找
		} else {// 查找数据大于或等于当前结点
			n++;
			return searchData(node.rchild, key);// 递归向右子树查找
		}
	}
	/* 查找功能结束 */

	// ----------插入功能--------

	// 添加结点的方法
	public void add(Node node) {
		if (root == null) {
			root = node;// root为空，直接指向node
		} else {
			root.add(node);
		}
	}
	/* 插入功能结束 */

	// ----------删除功能---------

	// 查找要删除结点
	public Node search(int data) {
		if (root == null) {
			return null;
		} else {
			return root.search(data);
		}
	}

	// 查找父节点
	public Node searchParent(int data) {
		if (root == null) {
			return null;
		} else {
			return root.searchParent(data);
		}
	}

	// 删除并返回右子树最小结点
	public int deleteRightTreeMin(Node node) {
		Node target = node;
		// 循环查找左子节点，直到最小值
		while (target.lchild != null) {
			target = target.lchild;
		}
		// 这时target指向最小值
		// 删除最小结点
		deleteNode(target.data);
		return target.data;
	}

	// 删除结点
	public void deleteNode(int data) {
		if (root == null) {
			return;
		} else {
			// 先找到要删除的结点 targetNode
			Node targetNode = search(data);
			// 如果没找到
			if (targetNode == null) {
				System.out.println("不存在此数");
			}
			// 如果没有子节点
			if (root.lchild == null && root.rchild == null) {
				root = null;
				return;
			}

			// 找到targetNode的父节点
			Node parent = searchParent(data);

			// 共有三种情况：

			// ①如果要删除的是叶子节点
			if (targetNode.lchild == null && targetNode.rchild == null) {
				// 判断要删除的是其父节点的左结点还是右结点
				if (parent.lchild != null && parent.lchild.data == data) {// 是左子节点
					parent.lchild = null;
				} else if (parent.rchild != null && parent.rchild.data == data) {// 是右子节点
					parent.rchild = null;
				}
			}

			// ②如果要删除的是有两颗子树的结点
			else if (targetNode.lchild != null && targetNode.rchild != null) {
				// 可以找右子树的最小节点，或者找左子树的最大结点 替换要删除的结点
				int minData = deleteRightTreeMin(targetNode.rchild);
				targetNode.data = minData;
			}

			// ③如果要删除的是有一颗子树的结点
			else {
				// 如果是有左子结点
				if (targetNode.lchild != null) {
					// 如果是target是parent的左子节点
					if (parent.lchild.data == data) {
						parent.lchild = targetNode.lchild;
					} else {// 如果是target是parent的右子节点
						parent.rchild = targetNode.lchild;
					}
				} else {// 如果是有右子结点
					if (parent.rchild.data == data) {
						parent.rchild = targetNode.rchild;
					} else {
						parent.rchild = targetNode.lchild;
					}
				}
			}

		}
	}
	/* 删除功能结束 */

	// ----------遍历功能---------

	// 前序遍历
	public void preOrderTraverse() {
		if (root == null) {
			System.out.println("当前树为空，不能遍历");
		} else {
			root.preOrderTraverse();
		}
	}

	// 中序遍历
	public void infixOrderTraverse() {
		if (root == null) {
			System.out.println("当前树为空，不能遍历");
		} else {
			root.infixOrderTraverse();
		}
	}

	// 后序遍历
	public void postOrderTraverse() {
		if (root == null) {
			System.out.println("当前树为空，不能遍历");
		} else {
			root.postOrderTraverse();
		}
	}
	/* 遍历功能结束 */


}
