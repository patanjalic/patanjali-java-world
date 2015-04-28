#include <iostream>
using namespace std;
#ifndef BINSTREE
#define BINSTREE


// you can change the type easily .
typedef int ElementType;
typedef int ValueType;

const int PRE_ORDER = 2;
const int IN_ORDER = 3;
const int POST_ORDER = 4;
const int LEVEL_ORDER = 5;
/*
Node class .
*/
class Node
{
	// Left node pointer.        
public: Node *left;
		// right node pointer.
public: Node *right;
		// ElementType integer in this case. 
public: ElementType data;

		// constructor 
public: Node(void);
		// constructor takes ElementType .
public: Node(ElementType);
};

/*
Binary Tree class
*/

class BinSTree
{     // Fields
private: Node *rootNode;
private: Node *currentNode;
private: int errorFlag;

		 // default Constructor and public methods
public: BinSTree(void);
		// insert ElementType to tree.
public: void insert(ElementType);
		// remove ElementType.
public: void remove(ValueType);
		// get currentNode element.
public: ElementType retrieve(void);
		// traverse the ree, 
public: void traverse(int order);
		// find a node by value.
public: void find(ValueType);
		// destroy tree.
public: void destroy(void);
		// check if the tree is full.
public: int isFull(void);
		// check if the ree empty.
public: int isEmpty(void);
public: int hasError(void);

		// private functions.    
private: void preorder(Node *, int);
private: void postorder(Node *, int);
private: void inorder(Node *, int);
private: Node* findParentForNode(ValueType key);
private: Node* findNodeByValue(ValueType key);
		 // find the right node.
private: Node* findRightNode(Node *);
		 // delete a specific node.
private: void destroyNode(Node *);
//function to find the difference in sum between nodes at odd even heights
public: int diffOddEvenHeights();
private: void diffOddEvenHeightsHelper(Node*, int&, int&, int);
};

Node::Node(void)
{
	left = right = 0;
}

Node::Node(ElementType el)
{
	left = right = 0;
	data = el;
}



BinSTree::BinSTree(void)
{
	rootNode = currentNode = 0;
	errorFlag = false;
}


void BinSTree::find(ValueType key)
{
	Node *p = findNodeByValue(key);
	if (p == 0)
		errorFlag = true;
	else
	{
		errorFlag = false;
		currentNode = p;
	}
}

void BinSTree::insert(ElementType el)
{
	if (rootNode == 0)
		rootNode = new Node(el);
	else
	{
		Node *p = findNodeByValue(el);
		// if element not found before 
		if (p == 0)
		{
			// In case root node is parent.
			Node *parent = rootNode;
			if (p != rootNode)
				parent = findParentForNode(el);
			if (el > parent->data)
			{
				parent->right = new Node(el);
				currentNode = parent->right;
			}
			else
			{
				parent->left = new Node(el);
				currentNode = parent->left;
			}
			// everthing is ok .
			errorFlag = false;
		}

		else
			// duplicate key.
			errorFlag = true;
	}
}

void BinSTree::traverse(int order)
{
	if (order == PRE_ORDER)
		preorder(rootNode, 0);
	else if (order == IN_ORDER)
		inorder(rootNode, 0);
	else if (order == POST_ORDER)
		postorder(rootNode, 0);
	else
		cout << "order doesn't exists" << endl;
}

ElementType BinSTree::retrieve(void)
{
	return currentNode->data;
}

int BinSTree::isFull(void)
{
	return 0;
}

int BinSTree::isEmpty(void)
{
	return (rootNode == 0);
}

int BinSTree::hasError(void)
{
	return errorFlag;
}

void BinSTree::remove(ValueType key)
{

	Node *p = findNodeByValue(key);
	// check if node exists.
	if (p == 0)
		errorFlag = true;
	// node exists .
	else
	{
		// delete leaf node.
		if ((p->right == 0) && (p->left == 0))
		{
			// (can find parent node.
			if (p != rootNode)
			{
				Node *parent = findParentForNode(key);
				if (parent->data < key)
					parent->right = 0;
				else
					parent->left = 0;
			}
			else
				rootNode = 0;
			delete(p);
			errorFlag = false;
			currentNode = rootNode;
		}
		else if ((p->right == 0) && (p->left != 0))  // right subtree empty,
			// left subtree not.
		{
			// can't find parent node .
			if (p != rootNode)
			{
				Node *parent = findParentForNode(key);
				if (parent->data < key)
					parent->right = p->left;
				else
					parent->left = p->left;
			}
			else
				rootNode = rootNode->left;
			delete(p);
			errorFlag = false;
			currentNode = rootNode;
		}
		else if ((p->right != 0) && (p->left == 0))  // left subtree empty,
			// right subtree not.
		{
			if (p != rootNode)    // (can find parent now ...)
			{
				Node *parent = findParentForNode(key);
				if (parent->data < key)
					parent->right = p->right;
				else
					parent->left = p->right;
			}
			else
				rootNode = p->right;
			delete(p);
			errorFlag = false;
			currentNode = rootNode;
		}
		else                                         // left and right 
			// subtrees not empty
		{
			Node *righty = findRightNode(p->left);
			Node *parent = findParentForNode(righty->data);
			p->data = righty->data;   // swapping data with righty
			if (parent != p)
				parent->right = righty->left;
			else
				p->left = righty->left;
			delete(righty);
			errorFlag = false;
			currentNode = rootNode;
		}
	}
}

void BinSTree::destroy(void)
{
	destroyNode(rootNode);
}



void BinSTree::inorder(Node *p, int level)
{
	if (p != 0)
	{
		inorder(p->left, level + 1);
		cout << "Node " << p->data << " at level " << level << endl;
		inorder(p->right, level + 1);
	}
}

void BinSTree::preorder(Node *p, int level)
{
	if (p != 0)
	{
		cout << "Node " << p->data << " at level " << level << endl;
		preorder(p->left, level + 1);
		preorder(p->right, level + 1);
	}
}

void BinSTree::postorder(Node *p, int level)
{
	if (p != 0)
	{
		postorder(p->left, level + 1);
		postorder(p->right, level + 1);
		cout << "Node " << p->data << " at level " << level << endl;
	}
}

void BinSTree::destroyNode(Node *p)
{
	if (p != 0)
	{
		destroyNode(p->left);
		destroyNode(p->right);
		delete(p);
	}
}

Node* BinSTree::findParentForNode(ValueType key)
{
	Node *p = rootNode, *q = 0;
	while ((p != 0) && (p->data != key))
	{
		q = p;
		if (p->data > key)
			p = p->left;
		else
			p = p->right;
	}
	return q;
}

Node* BinSTree::findNodeByValue(ValueType key)
/* This function returns a pointer to the node containing the key
value 'key' if it is in the tree. Otherwise, it returns null */
{
	Node *p = rootNode;
	while ((p != 0) && (p->data != key))
	if (p->data > key)
		p = p->left;
	else
		p = p->right;
	return p;
}

Node* BinSTree::findRightNode(Node *p)
{
	Node *righty = p;
	while (righty->right != 0)
		righty = righty->right;
	cout << "found right-most node to be: " << righty->data << "\n";
	return righty;
}

//function to find the difference in sum between nodes at odd even heights
int BinSTree::diffOddEvenHeights(){
	int evenSum = 0;
	int oddSum = 0;
	diffOddEvenHeightsHelper(rootNode, evenSum, oddSum, 0);
	return oddSum - evenSum;
}

void BinSTree::diffOddEvenHeightsHelper(Node* root, int& even, int& odd, int level){
	if (root){
		diffOddEvenHeightsHelper(root->left, even, odd, level+1);
		if (level & 1)
			odd += root->data;
		else
			even += root->data;
		diffOddEvenHeightsHelper(root->right, even, odd, level + 1);
	}
}
#endif


int main_bst()
{
	BinSTree tree;
	tree.insert(100);
	tree.insert(2);
	tree.insert(3);
	tree.insert(4);
	tree.insert(5);
	tree.insert(6);
	tree.insert(7);
	tree.insert(9);
	tree.insert(10);
	tree.traverse(IN_ORDER);
	cout << "sum difference is " << tree.diffOddEvenHeights();
	return 0;
}