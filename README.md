###  数据结构课程设计 - 二叉树系统实现java

> 问题描述
>
> 从键盘读入一组数据，建立二叉排序树并对其进行查找、遍历、格式化输出操作。设数据元素关键字序列为{11,33,44,55,58,79,88}。
>
> 需求分析
>
> 1.按照用户的需求，构建二叉排序树。
>
> 2.对二叉排序树进行遍历输出操作。
>
> 3.对二叉排序树进行查找，包括成功和不成功两种情况，并给出查找长度。
>
> 4.对二叉排序树进行插入操作。
>
> 5.对二叉排序树进行删除操作。

####  1、主界面设计

![img](file:////Users/zhenggengqiong/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image002.jpg)

![文本框: 图 2.1](file:////Users/zhenggengqiong/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image003.jpg)

为了方便操作，界面结合了多个操作，并且可以通过相应的序号调取，实现对二叉排序树的各个操作。

####  2、存储结构设计

二叉排序树是通过树的基本结构类型构成。有存储数据的data和左右两结点lchild以及rchild。

####  3、系统功能设计

本程序共设置了8个子功能菜单。具体如下。

1、创建二叉树，creatBST,其参数为整形数组，通过循环调用add函数，不断插入数组值实现。可根据系统提示，输入值，并以逗号隔开。长度可以根据输入长度动态变化。

2、查找功能，通过searchData函数实现。查找到则返回1，并可以输出查找长度；如果查找失败则返回0。主要是通过判断查询值key与结点的大小，递归向左子树或右子树查找，知道找到相等的值，否则查找失败。

3、删除功能，主要通过deleteNode实现。还有search和searchParent找到要删除的结点和父节点删除有三种情况：

1）是要删除的是树中的叶子节点，则判断是左子节点还是右子节点，另其为空。

2）如果要删除的结点有两颗子树，则通过deleteRightNodeMin函数，删除右子树最小的结点，并替换位置(也可以找左子树最大的结点替换)。

3）如果要删除的结点有一颗子树，通过判断是左子树还是右子树，进行删除操作。

4、插入功能，通过add函数添加结点，判断当前树的情况，再通过比较插入值key的大小，如果小于当前结点则继续递归左子树，如果大于等于，则递归右子树（最好避免有相等的数据）。

5、前序遍历,preOrderTraverse，DLR输出二排序树的结点，如果树为空，则出现提示。

6、中序遍历，infixOrderTraverse，LDR输出二叉排序树的结点。

7、后续遍历，postOrderTraverse，LRD输出二叉排序树的结点。

8、退出系统。

####  4、模块设计

程序主要分为主程序模块和二叉排序树各个操作的模块

![img](file:////Users/zhenggengqiong/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image002.jpg)

####  5、系统子程序及功能设计

(1) public void createBST(int[] array)，创建二叉排序树，通过循环调用add函数将用户输入的数据插入树中，小于当前节点的值递归左子树，大于等于当前节点值的递归右子树，从而创建出一颗二叉排序树。

(2) public int searchData(Node node, int key)，查找数据，通过比较要查找的数据与当前结点数据的大小，如果小于则向左子树递归，如果大于或等于则向右子树递归，直到找到与查找结点相等的。查找成功返回1，查找失败返回0。还可以计算查找长度。

(3) public void add(Node node)，插入数据，先判断树的状态，在比较要插入结点与当前节点的大小，如果小于当前结点，则递归向左子树，如果大于或等于则向右子树递归。

(4) public void deleteNode(int data)，删除数据。通过是否有左右子树判断，如果没有左右子树，则要删除的为叶子节点；如果有两颗子树，则通过public int deleteRightTreeMin(Node node)函数，替换右子树中最小的节点值；如果有一颗子树，则判断是左子树还是右子树，进行删除操作。

(5) public void preOrderTraverse()，前序遍历，如果树为空，则提示不能遍历。先输出根节点，再递归输出左子树，再递归输出右子树。

(6) public void infixOrderTraverse()，中序遍历，如果树为空，则提示不能遍历。先递归输出左子树，在输出根节点，再递归输出右子树。

(7) public void postOrderTraverse()，后续遍历，如果树为空，则提示不能遍历。先递归输出左子树，再递归输出右子树，再输出根节点。

####  6、函数主要调用关系图

函数主要调用关系图如下：

![img](file:////Users/zhenggengqiong/Library/Group%20Containers/UBF8T346G9.Office/TemporaryItems/msohtmlclip/clip_image002.jpg)



对二叉排序树的存储结构类型定义如下：

```java
public class Node {
	int data;
	Node lchild;
	Node rchild;
}
```

具体功能代码如下

(1)创建功能

```java
//创建树
	public void createBST(int[] array) {
		for(int i = 0;i<array.length;i++) {
			add(new Node(array[i]));
		}
	}
```

（2）查找功能

```java
Node lastNode = null;// 最近查找的结点
	int n = 1;//计算查找长度
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

```

（3）删除功能

```java
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
					if (parent.lchild.data == data) {
						parent.lchild = targetNode.rchild;
					} else {
						parent.rchild = targetNode.rchild;
					}
				}
			}
		}
	}
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
```

（4）插入功能

```java
public void add(Node node) {
		if (root == null) {
			root = node;// root为空，直接指向node
		} else {
			root.add(node);
		}
	}
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

```

（5）前序遍历

```java
public void preOrderTraverse() {
		if (root == null) {
			System.out.println("当前树为空，不能遍历");
		} else {
			root.preOrderTraverse();
		}
	}	
public void preOrderTraverse() {
		System.out.print(this.data + "->");

		if (this.lchild != null) {
			this.lchild.infixOrderTraverse();
		}

		if (this.rchild != null) {
			this.rchild.infixOrderTraverse();
		}
	}

```

（6）中序遍历

```java
public void infixOrderTraverse() {
		if (root == null) {
			System.out.println("当前树为空，不能遍历");
		} else {
			root.infixOrderTraverse();
		}
	}
public void infixOrderTraverse() {
		if (this.lchild != null) {
			this.lchild.infixOrderTraverse();
		}
		System.out.print(this.data + "->");
		if (this.rchild != null) {
			this.rchild.infixOrderTraverse();
		}
	}

```

（7）后续遍历

```java
public void postOrderTraverse() {
		if (root == null) {
			System.out.println("当前树为空，不能遍历");
		} else {
			root.postOrderTraverse();
		}
	}
public void postOrderTraverse() {
		if (this.lchild != null) {
			this.lchild.infixOrderTraverse();
		}

		if (this.rchild != null) {
			this.rchild.infixOrderTraverse();
		}

		System.out.print(this.data + "->");
	}
```

####  实验结果

![image-20210422102814748](/Users/zhenggengqiong/Library/Application Support/typora-user-images/image-20210422102814748.png)

![image-20210422102820519](/Users/zhenggengqiong/Library/Application Support/typora-user-images/image-20210422102820519.png)

![image-20210422102824940](/Users/zhenggengqiong/Library/Application Support/typora-user-images/image-20210422102824940.png)

![image-20210422102829373](/Users/zhenggengqiong/Library/Application Support/typora-user-images/image-20210422102829373.png)

![image-20210422102835379](/Users/zhenggengqiong/Library/Application Support/typora-user-images/image-20210422102835379.png)

![image-20210422102839433](/Users/zhenggengqiong/Library/Application Support/typora-user-images/image-20210422102839433.png)

![image-20210422102843389](/Users/zhenggengqiong/Library/Application Support/typora-user-images/image-20210422102843389.png)

![image-20210422102847870](/Users/zhenggengqiong/Library/Application Support/typora-user-images/image-20210422102847870.png)