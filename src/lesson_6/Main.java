package lesson_6;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = -100; i <= 100; i++) {
            list.add(i);
        }
//        System.out.println(list);
        Collections.shuffle(list);
        Tree t = new Tree();
        for(Integer i:list){
            t.insert(new Number(i));
        }
        t.displayTree();
//        System.out.println(list);
    }

    private static class Number {
        int digit;
        public Number(int digit) {
            this.digit = digit;
        }
        public int getDigit() {
            return digit;
        }
        public void setDigit(int digit) {
            this.digit = digit;
        }
        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Number number = (Number) o;
            return digit == number.digit;
        }
        @Override public int hashCode() {
            return Objects.hash(digit);
        }
        @Override public String toString() {
            return String.format("C (%d)", digit);
        }
    }
    public static class Tree {
        public class TreeNode {
            private Number number;
            public TreeNode leftChild;
            public TreeNode rightChild;

            public TreeNode(Number number) {
                this.number = number;
            }

            @Override
            public String toString() {
                return String.format("TN(%s)", number);
            }
        }
        private TreeNode root;
        public Tree() {
            root = null;
        }
        public void insert(Number c) {
            TreeNode node = new TreeNode(c);
            if (root == null) {
                root = node;
            } else {
                TreeNode current = root;
                TreeNode parent;
                while (true) {
                    parent = current;
                    if (c.digit < current.number.digit) {
                        current = current.leftChild;
                        if (current == null) {
                            parent.leftChild = node;
                            return;
                        }
                    } else if (c.digit > current.number.digit){
                        current = current.rightChild;
                        if (current == null) {
                            parent.rightChild = node;
                            return;
                        }
                    } else {
                        return;
                    }
                }

            }
        }
        public Number find(int age) {
            TreeNode current = root;
            while (current.number.digit != age) {
                if (age < current.number.digit)
                    current = current.leftChild;
                else
                    current = current.rightChild;

                if (current == null)
                    return null;
            }
            return current.number;
        }
        private void inOrderTravers(TreeNode current) {
            if (current != null) {
                System.out.println(current);
                inOrderTravers(current.leftChild);
                inOrderTravers(current.rightChild);
            }
        }
        public void displayTree() {
            inOrderTravers(root);
        }
        public boolean delete(int age) {
            TreeNode curr = root;
            TreeNode prev = root;
            boolean isLeftChild = true;
            while (curr.number.digit != age) {
                prev = curr;
                if (age < curr.number.digit) {
                    isLeftChild = true;
                    curr = curr.leftChild;
                } else {
                    isLeftChild = false;
                    curr = curr.rightChild;
                }

                if (curr == null)
                    return false;
            }

            if (curr.leftChild == null && curr.rightChild == null) {
                if (curr == root) {
                    root = null;
                } else if (isLeftChild) {
                    prev.leftChild = null;
                } else {
                    prev.rightChild = null;
                }
            } else if (curr.rightChild == null) {
                if (isLeftChild) {
                    prev.leftChild = curr.leftChild;
                } else {
                    prev.rightChild = curr.leftChild;
                }
            } else if (curr.leftChild == null) {
                if (isLeftChild) {
                    prev.leftChild = curr.rightChild;
                } else {
                    prev.rightChild = curr.rightChild;
                }
            } else {
                TreeNode successor = getSuccessor(curr);
                if (curr == root) {
                    root = successor;
                } else if (isLeftChild) {
                    prev.leftChild = successor;
                } else {
                    prev.rightChild = successor;
                }
                successor.leftChild = curr.leftChild;
            }
            return true;
        }

        private TreeNode getSuccessor(TreeNode deleted) {
            TreeNode successorParent = deleted;
            TreeNode successor = deleted;
            TreeNode flag = deleted.rightChild;

            while (flag != null) {
                successorParent = successor;
                successor = flag;
                flag = flag.leftChild;
            }
            if (successor != deleted.rightChild) {
                successorParent.leftChild = successor.rightChild;
                successor.rightChild = deleted.rightChild;
            }
            return successor;
        }

    }
}
