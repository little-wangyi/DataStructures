package Tree;

import com.sun.xml.internal.fastinfoset.util.ValueArrayResourceException;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: DataStructures
 * @description: 二叉树
 * @author: 王易
 * @create: 2022-05-01 08:40
 **/

class BinaryTree {
    HeroNode root;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void preOrderFind(int id) {
        HeroNode b = this.root.preOrderFind(id);
        if (b != null) {
            System.out.println("找到此人:" + b.getName());
        } else {
            System.out.println("查无此人");
        }
    }

    public void infixOrderFind(int id) {
        HeroNode b = this.root.infixOrderFind(id);
        if (b != null) {
            System.out.println("找到此人:" + b.getName());
        } else {
            System.out.println("查无此人");
        }
    }

    public void postOrderFind(int id) {
        HeroNode b = this.root.postOrderFind(id);
        if (b != null) {
            System.out.println("找到此人:" + b.getName());
        } else {
            System.out.println("查无此人");
        }
    }

    public void preOrderCount(int id) {
//        System.out.println("遍历查找使用了" + this.root.preOrderCount() + "次");
    }

    public void delNode(int no){
        if(root == null){
            System.out.println("空树");
        }
        if(root.getId() == no){
            root = null;
        }else{
            root.DelNode(no);
        }
    }
}

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode hero1 = new HeroNode(1, "宋江");
        HeroNode hero2 = new HeroNode(2, "吴用");
        HeroNode hero3 = new HeroNode(3, "卢俊义");
        HeroNode hero4 = new HeroNode(4, "林冲");
        HeroNode hero5 = new HeroNode(5, "关胜");
        HeroNode hero6 = new HeroNode(6, "老六");
        binaryTree.setRoot(hero1);
        hero1.setLeft(hero2);
        hero1.setRight(hero3);
        hero3.setLeft(hero4);
        hero3.setRight(hero5);
        hero2.setLeft(hero6);
//        binaryTree.preOrder();
//        binaryTree.infixOrder();
//        binaryTree.postOrder();
//        binaryTree.preOrderFind(5);
//        binaryTree.infixOrderFind(1);
//        binaryTree.postOrderFind(5);
//        binaryTree.preOrderCount(4);
        binaryTree.delNode(3);
        binaryTree.preOrder();
    }

}


class HeroNode {
    private int id;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public HeroNode preOrderFind(int id) {
        HeroNode resNode = null;
        if (this.getId() == id) {
            resNode = this;
            return resNode;
        }
        if (this.left != null) {
            resNode = this.left.preOrderFind(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderFind(id);
        }
        return resNode;
    }

    public HeroNode infixOrderFind(int id) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderFind(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.getId() == id) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderFind(id);
        }
        return resNode;
    }

    public HeroNode postOrderFind(int id) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderFind(id);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.postOrderFind(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.getId() == id) {
            return this;
        }
        return resNode;
    }
    public void DelNode(int no){
        if(this.left != null && this.left.id == no){
            this.left = null;
            return;
        }
        if(this.right != null && this.right.id == no){
            this.right = null;
            return;
        }

        if(this.left != null){
            this.left.DelNode(no);
        }
        if(this.right != null){
            this.right.DelNode(no);
        }
    }
}
