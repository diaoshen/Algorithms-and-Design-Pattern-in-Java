# Table of Contents

* [int size(Node x)](#size) - Returns size of node x

* [Key min()](#min) - Returns minimum key in tree

* [Key max()](#max) - Returns maximum key in tree

* [boolean isEmpty()](#empty) - Returns true if tree is empty , false otherwise
---

## <a name="size">int size(Node x)</a>
<b>Description</b> : Returns number of nodes in left subtree of node x + number of nodes in right subtree of x  + 1 as total size. </br>Empty node will is default to size = 0 </br>
<b>Parameters</b> : Node x - the node of interest</br>
<b>Return</b> : Number of nodes in x's subtree plus node x

Formula : x.left.nField + x.right.nField + 1


## <a name="min">Key min()</a>
<b>Description</b> : Returns the minimum key in BST
</br><b>Parameters</b> : NONE
</br><b>Return</b> : Minimum key in BST
