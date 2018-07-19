package com.yjh.java.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AVLTree {

    Note root = new Note();

    void add(Note root, Note note, AVLTree avlTree) {
        root.add(root, note, avlTree);
    }

    void printf() {
        //将节点存入一个list中，得到一个排序好的集合（对排序树遍历）
        List<Note> list = new ArrayList<Note>();
        Stack<Note> stack = new Stack<Note>();
        //先取树的根节点
        Note note = this.root;
        do {
            //入栈
            stack.push(note);
            //如果节点存在左孩子，则继续入栈
            if (note.lchild != null) {
                note = note.lchild;
            }

            //出栈
            else {
                while (true) {
                    note = stack.pop();
                    list.add(note);
                    if (null != note.rchild) {
                        note = note.rchild;
                        break;
                    }
                }
            }

        } while (stack.size() != 0 || note.rchild != null);

        for (Note n : list) {
            System.out.println(n.data);
        }
    }


    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int arr[] = {5,8,9,3,6,7, 11, 10};

        for (int i = 0; i < arr.length; i++) {
            tree.add(tree.root, new Note(arr[i]), tree);
        }
        tree.printf();

    }

}

class Note {

    Integer data;
    Note parent;
    Note lchild;
    Note rchild;
    int height;


    public Note(int data) {
        this.data = data;
    }

    public Note() {
    }

    int getHeight(Note note) {
        return null == note ? -1 : note.height;
    }

    Note LR(Note note, AVLTree avlTree) {
        return LL(RR(note.lchild, avlTree).parent, avlTree);
    }

    Note LL(Note note, AVLTree avlTree) {
        Note parent = note.parent;
        Note lchild = note.lchild;

        if (parent == null) {
            avlTree.root = lchild;
            lchild.parent = null;
        } else {
            if (parent.data > lchild.data) {
                parent.lchild = lchild;
            }else {
                parent.rchild = lchild;
            }
            lchild.parent = parent;

        }

        if (lchild.rchild == null) {
            note.lchild = null;
        } else {
            note.lchild = note.lchild.rchild;
            note.lchild.parent = note;
        }

        note.parent = lchild;
        lchild.rchild = note;

        note.height = Math.max(getHeight(note.lchild), getHeight(note.rchild)) + 1;
        note.parent.height = Math.max(getHeight(note.parent.lchild), getHeight(note.parent.rchild)) + 1;

        return note.parent;
    }

    Note RL(Note note, AVLTree avlTree) {
        return RR(LL(note.rchild, avlTree).parent, avlTree);
    }

    Note RR(Note note, AVLTree avlTree) {
        Note parent = note.parent;
        Note rchild = note.rchild;

        if (parent == null) {
            avlTree.root = rchild;
            rchild.parent = null;
        } else {
            if (parent.data < rchild.data) {
                parent.rchild = rchild;
            } else {
                parent.lchild = rchild;
            }

            rchild.parent = parent;

        }

        if (rchild.lchild == null) {
            note.rchild = null;
        } else {
            note.rchild = note.rchild.lchild;
            note.rchild.parent = note;
        }

        note.parent = rchild;
        rchild.lchild = note;

        note.height = Math.max(getHeight(note.lchild), getHeight(note.rchild)) + 1;
        note.parent.height = Math.max(getHeight(note.parent.lchild), getHeight(note.parent.rchild)) + 1;

        return note.parent;
    }


    Note add(Note parent, Note newNote, AVLTree avlTree) {

        if (null != parent && null == parent.data) {
            parent.data = newNote.data;
            return parent;
        }


        //小于parent值往左添加
        if (newNote.data < parent.data) {
            if (parent.lchild == null) {
                parent.lchild = newNote;
                newNote.parent = parent;
            } else {
                add(parent.lchild, newNote, avlTree);
                //检查parent节点是否平衡
                if (getHeight(parent.lchild) - getHeight(parent.rchild) == 2) {
                    //LL
                    if (parent.lchild.data > newNote.data) {
                        LL(parent, avlTree);
                    }
                    //LR
                    else {
                        LR(parent, avlTree);
                    }
                }
            }

        }
        //大于paren值往右添加
        else {
            if (parent.rchild == null) {
                parent.rchild = newNote;
                newNote.parent = parent;
            } else {
                add(parent.rchild, newNote, avlTree);
                //检查parent节点是否平衡
                if (getHeight(parent.rchild) - getHeight(parent.lchild) == 2) {
                    //RR
                    if (parent.rchild.data < newNote.data) {
                        RR(parent, avlTree);
                    }
                    //RL
                    else {
                        RL(parent, avlTree);
                    }
                }
            }
        }

        //返回前先计算一下parent的高
        parent.height = Math.max(getHeight(parent.lchild), getHeight(parent.rchild)) + 1;

        // 递归返回每个经过的节点
        return parent; //
    }
}