package com.Tree.BST;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void main(String[] arg) {
		// int arr[] = { 55, 79, 11, 33, 88, 58, 44 };
		Scanner input = new Scanner(System.in);
		menu();
		BinarySortTree T = new BinarySortTree();
		boolean flag = true;
		while (flag) {

			String select = input.next();
			try {
				Integer.parseInt(select);
				// 是整数
			} catch (NumberFormatException nfe) {
				System.out.println("输入错误");
				// 不是整数
			}
			int n = Integer.parseInt(select);
			switch (n) {

			case 1: {
				System.out.println("①请输入要构建的数字，用逗号隔开");
				Scanner sc = new Scanner(System.in);
				String str = sc.nextLine();
				String[] Arrays = str.split(","); // 通过“，”分离
				int[] arr = new int[Arrays.length];
				for (int i = 0; i < arr.length; i++) {
					arr[i] = Integer.parseInt(Arrays[i]); // 将String型转化成int型
				}
				T.createBST(arr);
				System.out.println("构建成功！");
				menu();
			}
				break;

			case 2: {
				System.out.println("②请输入要查找的数字：");
				int target = input.nextInt();
				System.out.println("查找结果为：" + T.searchData(T.root, target));
				System.out.println("查找长度为：" + T.n);
				menu();
			}
				break;

			case 3: {
				System.out.println("③请输入要删除的数字：");
				int target = input.nextInt();
				T.deleteNode(target);
				System.out.println("删除成功!");
				menu();
			}
				break;

			case 4: {
				System.out.println("④请输入要插入的数字：");
				int target = input.nextInt();
				T.add(new Node(target));
				menu();
			}
				break;

			case 5: {
				System.out.println("⑤前序遍历结果为：");
				T.preOrderTraverse();
				System.out.println();
				menu();
			}
				break;

			case 6: {
				System.out.println("⑥中序遍历结果为：");
				T.infixOrderTraverse();
				System.out.println();
				menu();
			}
				break;

			case 7: {
				System.out.println("⑦后序遍历结果为：");
				T.postOrderTraverse();
				System.out.println();
				menu();
			}
				break;

			case 8: {
				System.out.println("感谢使用，再见👋");
				flag = false;
			}
				break;
			default:
				System.out.println("输入错误，请重新输入");
				break;

			}
		}

	}

	public static void menu() {
		System.out.println("********************************************");
		System.out.println("             欢迎使用二叉排序树系统             ");
		System.out.println("   --------------------------------------   ");
		System.out.println("      1->创建功能            5->前序遍历       ");
		System.out.println("      2->查找功能            6->中序遍历       ");
		System.out.println("      3->删除功能            7->后序遍历       ");
		System.out.println("      4->插入功能            8->退出系统       ");
		System.out.println("********************************************");
		System.out.println("请输入您的操作并按回车键");
	}
}
