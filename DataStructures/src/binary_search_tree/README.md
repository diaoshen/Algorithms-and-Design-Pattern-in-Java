# Table of Contents
## <a name=""></a>
<b>Description</b> :
</br><b>Parameters</b> : 
</br><b>Return</b> : 



* [int size(Node x)](#size) - Returns size of node x

* [Key min()](#min) - Returns minimum key in tree

* [Key max()](#max) - Returns maximum key in tree

* [boolean isEmpty()](#empty) - Returns true if tree is empty , false otherwise
---

* [void add(Key key , Value val)](#add) - Adds a node to tree with given key and associated value

* [Value get(Key key)](#get) - Returns the value of a given key

* [void delete(Key key)](#del) - Remove a key/value pair given key

* [void deleteMin()(#delMin) - Removes the minimum key from BST

* [void deleteMax()(#delMax) - Removes the maximum key from BST

## <a name="size">int size(Node x)</a>
<b>Description</b> : Returns number of nodes in left subtree of node x + number of nodes in right subtree of x  + 1 as total size. </br>Empty node will is default to size = 0 </br>
<b>Parameters</b> : Node x - the node of interest</br>
<b>Return</b> : Number of nodes in x's subtree plus node x

Formula : x.left.nField + x.right.nField + 1


## <a name="min">Key min()</a>
<b>Description</b> : Returns the minimum key in BST by recursively go left subtree until a null node is reached.
</br><b>Parameters</b> : NONE
</br><b>Return</b> : Minimum key in BST

## <a name="max">Key max()</a>
<b>Description</b> : Returns the maximum key in BST by recursively go right subtree until a null node is reached.
</br><b>Parameters</b> : NONE
</br><b>Return</b> : Maximum key in BST

## <a name="empty">boolean isEmpty()</a>
<b>Description</b> : Check if a BST is empty by calling size() passing root as arg.  If size() returns 0 then tree is empty.
</br><b>Parameters</b> : NONE
</br><b>Return</b> : True if tree is empty , False if not empty.

## <a name="add">void add(Key key , Value val)</a>
<b>Description</b> : Recursively traverse BST to look for insertion spot then creates a new node with given key and value and attach to BST
</br><b>Parameters</b> : Key key , Value val
</br><b>Return</b> : NONE

## <a name="get">Value get(Key key)</a>
<b>Description</b> : Recursively traverse BST to look for insertion spot then return the target key's value
</br><b>Parameters</b> : Key key - target key/node
</br><b>Return</b> : Target key's value

## <a name="del">void delete(Key key)</a>
<b>Description</b> : traverse BST to target and deletes it from BST , if target has left and right child then target's successor is used to replace target.
</br><b>Parameters</b> : Key key - target key 
</br><b>Return</b> : NONE

