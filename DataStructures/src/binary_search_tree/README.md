# Table of Contents
# Number of Supported Operations [18]



* [int size(Node x)](#int-size-node-x) - Returns size of node x

* [Key min()](#key-min) - Returns minimum key in tree

* [Key max()](#key-max) - Returns maximum key in tree

* [boolean isEmpty()](#boolean-isempty) - Returns true if tree is empty , false otherwise

* [boolean contains(Key key)](#boolean-contains-key-key) - Returns true if given key is in BST , false otherwise

* [int getHeight()](#int-getheight) - Returns height of BST 

---

* [void printLevel()](#void-printlevel) - Prints tree level by level

* [void printSideWays()](#void-printsideways) - Prints tree side ways

---
* [Key floor(Key key)](#key-floor-key) - Returns smallest key <= input key

* [Key ceiling(Key key)](#key-ceiling-key) - Returns largest key >= input key

* [int rank(Key key)](#int-rank-key-key) - Returns # of keys <= given key

* [Key select(int k)](#key-select-int-k) - Returns kth key (zero based)

* [double getAverage(int k)](#double-getaverage-int-k) - Returns average of k smallest element's key from BST

---

* [void add(Key key , Value val)](#void-add-key-key-value-val) - Adds a node to tree with given key and associated value

* [Value get(Key key)](#value-get-key-key) - Returns the value of a given key

* [void delete(Key key)](#void-delete-key-key) - Remove a key/value pair given key

* [void deleteMin()](#void-deletemin) - Removes the minimum key from BST

* [void deleteMax()](#void-deletemax) - Removes the maximum key from BST

#int-size-node-x
##int size(Node x)
<b>Description</b> : Returns number of nodes in left subtree of node x + number of nodes in right subtree of x  + 1 as total size. </br>Empty node will is default to size = 0 </br>
<b>Parameters</b> : Node x - the node of interest</br>
<b>Return</b> : Number of nodes in x's subtree plus node x

Formula : x.left.nField + x.right.nField + 1


##Key min()
<b>Description</b> : Returns the minimum key in BST by recursively go left subtree until a null node is reached.
</br><b>Parameters</b> : NONE
</br><b>Return</b> : Minimum key in BST

##Key max()
<b>Description</b> : Returns the maximum key in BST by recursively go right subtree until a null node is reached.
</br><b>Parameters</b> : NONE
</br><b>Return</b> : Maximum key in BST

##boolean isEmpty()
<b>Description</b> : Check if a BST is empty by calling size() passing root as arg.  If size() returns 0 then tree is empty.
</br><b>Parameters</b> : NONE
</br><b>Return</b> : True if tree is empty , False if not empty.

##void add(Key key , Value val)
<b>Description</b> : Recursively traverse BST to look for insertion spot then creates a new node with given key and value and attach to BST
</br><b>Parameters</b> : Key key , Value val
</br><b>Return</b> : NONE

##Value get(Key key)
<b>Description</b> : Recursively traverse BST to look for insertion spot then return the target key's value
</br><b>Parameters</b> : Key key - target key/node
</br><b>Return</b> : Target key's value

##void delete(Key key)
<b>Description</b> : traverse BST to target and deletes it from BST , if target has left and right child then target's successor is used to replace target.
</br><b>Parameters</b> : Key key - target key 
</br><b>Return</b> : NONE

##void deleteMin()
<b>Description</b> : Deletes the minimum key in BST
</br><b>Parameters</b> : NONE
</br><b>Return</b> : NONE

##void deleteMax()
<b>Description</b> : Deletes the maximum key in BST
</br><b>Parameters</b> : NONE
</br><b>Return</b> : NONE

##boolean contains(Key key)
<b>Description</b> : Returns true if given key is in BST by calling get() passing key as param , false otherwise.
</br><b>Parameters</b> : Key key - target key
</br><b>Return</b> : True if target is in BST , False if target is not in BST

##int getHeight()
<b>Description</b> : Returns height of a BST that is the longest path from root to a leaf node , Default height for empty tree is 0 , tree with only one node is 1. 
</br><b>Parameters</b> : NONE
</br><b>Return</b> : Height of BST as an INT

##void printLevel()
<b>Description</b> : Prints BST level by level starting at level/row = root  , ending at last leaf row
</br><b>Parameters</b> : NONE
</br><b>Return</b> : SEE ABOVE.

##void printSideWays()
<b>Description</b> : Prints BST side ways
</br><b>Parameters</b> : NONE
</br><b>Return</b> : NONE

##Key floor(Key)
<b>Description</b> : For a given key in BST , there is a list of number <= key. floor() will return the largest key in this list.
In order words, floor() finds the largest key <= given key
</br><b>Parameters</b> : Key key
</br><b>Return</b> : Largest key smaller or equal to given key

##Key ceiling(Key)
<b>Description</b> : For a given key in BST , there is a list of number >= key. ceiling() will return the smallest key in this list
In order words, ceiling() finds the smallest key >= given key
</br><b>Parameters</b> : Key key
</br><b>Return</b> : Smallest key larger or equal to given key

##int rank(Key key)
<b>Description</b> : Finds how many key <= given key 
NOTE: If all nodes in BST are sorted in list then key will be at position rank(key). In other words int n = rank(k) , n is the nth key in the BST
</br><b>Parameters</b> : Key key
</br><b>Return</b> : # of keys smaller than or equal to input key

##Key select(int k)
<b>Description</b> : Finds the kth key in BST starting from 0th
</br><b>Parameters</b> : int k - kth key of interest
</br><b>Return</b> : kth key

##double getAverage(int k)
<b>Description</b> : Returns average of (0-k)
</br><b>Parameters</b> : upper limit k
</br><b>Return</b> : Returns average of (0-k)
