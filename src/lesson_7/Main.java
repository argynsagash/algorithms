package lesson_7;

import lesson_3.Queue;
import lesson_3.Stack;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addVertex('I');
        graph.addVertex('J');

        graph.addEdge(3,0);
        graph.addEdge(3,8);
        graph.addEdge(4,7);
        graph.addEdge(4,8);
        graph.addEdge(4,1);
        graph.addEdge(4,2);
        graph.addEdge(4,5);
        graph.addEdge(4,9);
        graph.addEdge(5,6);

        graph.widthTravers();
//        System.out.println();
    }

    public static class Graph {
        class Vertex {
            public char label;
            public boolean isVisited;

            public Vertex(char label) {
                this.label = label;
                this.isVisited = false;
            }

            @Override
            public String toString() {
                return "V{" + label + '}';
            }
        }

        private final int MAX_VERTICES = 32;
        private Vertex[] vertices;
        private int[][] adjacency;
        private int size;

        public Graph() {
            vertices = new Vertex[MAX_VERTICES];
            adjacency = new int[MAX_VERTICES][MAX_VERTICES];
            size = 0;
        }

        public void addVertex(char label) {
            vertices[size++] = new Vertex(label);
        }

        public void addEdge(int start, int end) {
            adjacency[start][end] = 1;
            adjacency[end][start] = 1;
        }

        public void displayVertex(int ver) {
            System.out.println(vertices[ver]);
        }

        private int getUnvisited(int ver) {
            for (int i = 0; i < size; i++) {
                if (adjacency[ver][i] == 1 && !vertices[i].isVisited) {
                    return i;
                }
            }
            return -1;
        }

        public void depthTravers() {
            Stack stack = new Stack(size);
            vertices[0].isVisited = true;
            displayVertex(0);
            stack.push(0);
            while (!stack.isEmpty()) {
                int v = getUnvisited(stack.peek());
                if (v == -1) {
                    stack.pop();
                } else {
                    vertices[v].isVisited = true;
                    displayVertex(v);
                    stack.push(v);
                }
            }
            for (int i = 0; i < size; i++) {
                vertices[i].isVisited = false;
            }
        }

        public void widthTravers() {
            Queue queue = new Queue(size);
            vertices[0].isVisited = true;
            displayVertex(0);
            queue.insert(0);
            int v2;
            while (!queue.isEmpty()) {
                int v1 = queue.remove();
                while ((v2 = getUnvisited(v1)) != -1) {
                    vertices[v2].isVisited = true;
                    displayVertex(v2);
                    queue.insert(v2);
                }
            }
            for (int i = 0; i < size; i++) {
                vertices[i].isVisited = false;
            }

        }

    }
}
