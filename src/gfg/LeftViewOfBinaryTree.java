package gfg;

public class LeftViewOfBinaryTree {
}


class Tree
{
    void leftView(Node root)
    {
        int height[] = new int[101];
        for(int i = 0 ; i < 101 ; i++){
            height[i] = -1;
        }
        leftViewImpl(root,0,height);
        String result = "";
        for(int i = 0 ; i < 101 ; i++){
            if(height[i] != -1){
                result += (height[i] + " ");
            } else {
                break;
            }
        }
        System.out.print(result.trim());
    }

    private void leftViewImpl(Node root, int i, int[] height) {
        if(root != null) {
            if(height[i] == -1){
                height[i] = root.data;
            }

            if(root.left != null){
                leftViewImpl(root.left,i+1,height);
            }
            if(root.right != null){
                leftViewImpl(root.right,i+1,height);
            }
        }
        return;

    }
}

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}