# Table of Contents
## <a name=""></a>
<b>Description</b> :
</br><b>Parameters</b> : 
</br><b>Return</b> : 



* [int size(Node x)](#size) - Returns size of node x

* [Key min()](#min) - Returns minimum key in tree

* [Key max()](#max) - Returns maximum key in tree

* [boolean isEmpty()](#empty) - Returns true if tree is empty , false otherwise

* [boolean contains(Key key)](#contain) - Returns true if given key is in BST , false otherwise

* [int getHeight()](#height) - Returns height of BST 

---

* [void printLevel()](#printlevel) - Prints tree level by level

* [void printSideWays()](#printsideway) - Prints tree side ways

---
* [Key floor(Key key)](#floor) - Returns smallest key <= input key

* [Key ceiling(Key key)](#ceiling) - Returns largest key >= input key

* [int rank(Key key)](#rank) - Returns # of keys <= given key

* [Key select(int k)](#select) - Returns kth key (zero based)

* [double getAverage(int k)](#avg) - Returns average of k smallest element's key from BST

---

* [void add(Key key , Value val)](#add) - Adds a node to tree with given key and associated value

* [Value get(Key key)](#get) - Returns the value of a given key

* [void delete(Key key)](#del) - Remove a key/value pair given key

* [void deleteMin()](#delMin) - Removes the minimum key from BST

* [void deleteMax()](#delMax) - Removes the maximum key from BST

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

## <a name="delMin">void deleteMin()</a>
<b>Description</b> : Deletes the minimum key in BST
</br><b>Parameters</b> : NONE
</br><b>Return</b> : NONE

## <a name="delMax">void deleteMax()</a>
<b>Description</b> : Deletes the maximum key in BST
</br><b>Parameters</b> : NONE
</br><b>Return</b> : NONE

## <a name="contain">boolean contains(Key key)</a>
<b>Description</b> : Returns true if given key is in BST by calling get() passing key as param , false otherwise.
</br><b>Parameters</b> : Key key - target key
</br><b>Return</b> : True if target is in BST , False if target is not in BST

## <a name="height">int getHeight()</a>
<b>Description</b> : Returns height of a BST that is the longest path from root to a leaf node , Default height for empty tree is 0 , tree with only one node is 1. 
</br><b>Parameters</b> : NONE
</br><b>Return</b> : Height of BST as an INT

## <a name="printlevel">void printLevel()</a>
<b>Description</b> : Prints BST level by level starting at level/row = root  , ending at last leaf row
</br><b>Parameters</b> : NONE
</br><b>Return</b> : SEE ABOVE.

## <a name="printsideway">void printSideWays()</a>
<b>Description</b> : Prints BST side ways
</br><b>Parameters</b> : NONE
</br><b>Return</b> : NONE

## <a name="floor">Key floor(Key)</a>
<b>Description</b> : For a given key in BST , there is a list of number <= key. floor() will return the largest key in this list.
In order words, floor() finds the largest key <= given key
</br><b>Parameters</b> : Key key
</br><b>Return</b> : Largest key smaller or equal to given key

## <a name="ceiling">Key ceiling(Key)</a>
<b>Description</b> : For a given key in BST , there is a list of number >= key. ceiling() will return the smallest key in this list
In order words, ceiling() finds the smallest key >= given key
</br><b>Parameters</b> : Key key
</br><b>Return</b> : Smallest key larger or equal to given key

## <a name="rank">int rank(Key key)</a>
<b>Description</b> : Finds how many key <= given key 
NOTE: If all nodes in BST are sorted in list then key will be at position rank(key). In other words int n = rank(k) , n is the nth key in the BST
</br><b>Parameters</b> : Key key
</br><b>Return</b> : # of keys smaller than or equal to input key

## <a name="select">Key select(int k)</a>
<b>Description</b> : Finds the kth key in BST starting from 0th
</br><b>Parameters</b> : int k - kth key of interest
</br><b>Return</b> : kth key

## <a name="avg">double getAverage(int k)</a>
<b>Description</b> : Returns average of (0-k)
</br><b>Parameters</b> : upper limit k
</br><b>Return</b> : Returns average of (0-k)
