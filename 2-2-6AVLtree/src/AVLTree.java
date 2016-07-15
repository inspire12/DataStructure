
public class AVLTree {
	private int key, height;
	private AVLTree left, right;
	public static final AVLTree NIL = new AVLTree();

	public AVLTree(int key){
		this.key = key;
		left = right = NIL;
	}
	//생성자 하나만 사용자가 쓸수 있게 통제 임의로 만들수 없게
	private AVLTree(){
		left = right =this;
		height =-1;
	}
	private void setLeft(AVLTree a){
		this.left = a;

	}
	private void setRight(AVLTree a){
		this.right=a;

	}
	private AVLTree(int key,AVLTree left, AVLTree right){
		this.key=key;
		this.left=left;
		this.right=right;
		height = 1+ Math.max(left.height, right.height);
	}
	private AVLTree(int key,AVLTree left, AVLTree right,int count){
		this.key=key;
		this.left=left;
		this.right=right;
		
		height = 1+ Math.max(left.height, right.height);
	}
	public boolean add(int key){
		int oldSize=size();
		grow(key);
		return size()>oldSize;
	}
	public AVLTree grow(int key){
		if(this ==NIL) return new AVLTree(key);
		if(key== this.key) return this;
		if(key<this.key)left = left.grow(key);
		else right = right.grow(key);

		rebalance();
		height = 1+Math.max(left.height, right.height);
		return this;
	}
	public AVLTree delete(int key){
		
		if(this ==NIL){return NIL;}
		if(key== this.key) return deleteRebalance(key);
		if(key<this.key)left = left.delete(key);
		else right = right.delete(key);

		rebalance();
		height = 1+Math.max(left.height, right.height);
		return this;

		//찾는 부분

	}
	
	private AVLTree deleteRebalance(int key){
		
		
		AVLTree currentNode = left;
		AVLTree parentNode= this;
		if(currentNode==NIL){
			parentNode=parentNode.right;
		}
		if(this ==NIL) return NIL;
		//	if(key== this.key) return currentNode;
		if(currentNode==NIL){
			currentNode = right;
			while(currentNode.left!=NIL){
				parentNode= currentNode;
				currentNode = currentNode.left;
			}
			this.key=currentNode.key;
			this.height=currentNode.height;
			if(key<currentNode.key){
				parentNode.left=currentNode.left;
			}else{
				parentNode.right=currentNode.left;
			}
		}
		while(currentNode.right!=NIL){
			parentNode= currentNode;
			currentNode = currentNode.right;
		}
		int iskey = parentNode.key;
		this.key=currentNode.key;

		if(currentNode.key<iskey){
			parentNode.left=currentNode.left;
			height = 1+Math.max(left.height, right.height);
			
		}else if(currentNode.key>iskey){
			parentNode.right=currentNode.left;
			height = 1+Math.max(left.height, right.height);
			
		}else{
			
		}
	
		return this;

	}

	public int size(){ //재귀로 모든 사이즈를 알아냄
		if(this == NIL) return 0;
		return 1+left.size()+right.size();
	}
	public String toString(){
		if(this.key==0)return "";
		//내림차순으로 나오게

		return right+" "+key+" "+left;
	}
	private void rebalance(){
		if(right.height>left.height+1){
			if(right.left.height>right.right.height)
				right.rotateRight();
			rotateLeft();
		}else if(left.height>right.height+1){
			if(left.height>left.left.height)
				left.rotateLeft();
			rotateRight();
		}
	}

	private void rotateLeft(){
		left = new AVLTree(key,left, right.left);
		key = this.right.key;
		right = this.right.right;
	}
	private void rotateRight(){
		right = new AVLTree(key,left.right, right);
		key = this.left.key;
		left = this.left.left;
	}
	
	
	public AVLTree remove(int aKey){
		AVLTree removedObject = NIL;
		if(this==NIL){
			return NIL;
		}else if(this.key==aKey){
			removedObject=this;
			if(this.left==NIL&&this.right==NIL){
				return NIL;
			}else if(this.left == NIL){
				removedObject=this.right;
			}else if(this.right==NIL){
				removedObject=this.left;

			}else{
				AVLTree newRoot = removeRightMostOfLeftTree(this);
				newRoot.setLeft(this.left);
				newRoot.setRight(this.right);
				removedObject=newRoot;
			}
			return removedObject;
		}else{
			return removeObjectForKeyFromSubtree(this,aKey);
		}

	}
	private AVLTree removeObjectForKeyFromSubtree(AVLTree currentRoot, int aKey){
		if(currentRoot.key>aKey){
			AVLTree child = currentRoot.left;
			if(child==NIL){
				return null;
			}else{
				if(child.left==NIL&&child.right==NIL){
					AVLTree removedObject = child;
					if(child.left==NIL&&child.right==NIL){
						currentRoot.left=NIL;

					}else if(child.left==NIL){
						currentRoot.left=child.right;
					}else if(child.right==NIL){
						currentRoot.left=child.right;
					}else{
						AVLTree newRoot = removeRightMostOfLeftTree(this);
						newRoot.left= child.left;
						newRoot.right = child.left;
						currentRoot = newRoot;
					}
					return removedObject;
				}else{
					return removeObjectForKeyFromSubtree(child, aKey);
				}
			}
		}else{	
			AVLTree child = currentRoot.right;
			if(child==NIL)return null;
			else{
				if(child.key==0){
					AVLTree removedObject = child;
					if(child.left==null&&child.right==NIL){
						currentRoot.left=NIL;
					}else if(child.left==NIL){
						currentRoot.right=child.right;
					}else if(child.right==NIL){
						currentRoot.right=left;
					}else{
						AVLTree newRoot = removeRightMostOfLeftTree(this);
						newRoot.left= child.left;
						newRoot.right = child.right;
						currentRoot = newRoot;
					}
					return removedObject;
				}else{
					return removeObjectForKeyFromSubtree(child, aKey);
				}
			}
		}
	}
	private AVLTree removeRightMostOfLeftTree(AVLTree currentNode){
		AVLTree leftOfCurrentRoot = currentNode.left;
		if(leftOfCurrentRoot==NIL){
			return null;
		}
		if(leftOfCurrentRoot.right==NIL){
			currentNode.left=leftOfCurrentRoot.left;
			return leftOfCurrentRoot;
		}else{
			AVLTree parentofRightMost=leftOfCurrentRoot;
			AVLTree rightMost = leftOfCurrentRoot.right;
			while(rightMost.right!=NIL){
				parentofRightMost=rightMost;
				rightMost=rightMost.right;
			}
			parentofRightMost.right=rightMost.left;
			rightMost.setLeft(NIL);
			return rightMost;
		}
	}


}
