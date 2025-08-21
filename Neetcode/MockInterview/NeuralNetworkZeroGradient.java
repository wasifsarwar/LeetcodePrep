package MockInterview;

/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/**
 * 
 * '''
 * Interview Question:
 * Debugging a Neural Network with Vanishing Gradients
 * 
 * Background and Assumptions:
 * 1. A neural network can be represented as a directed acyclic graph (DAG),
 * where each node represents a computation and edges represent the flow of
 * information forward (from parent to child nodes).
 * 
 * For this problem, you can ignore details such as weights, biases, and
 * activation functions (don't worry if you don't know what those are). Just
 * treat the neural network as a basic graph.
 * 
 * 2. During the training of neural networks, a process called backpropagation
 * is used to compute the gradients, which flow in the reverse direction of the
 * edges (from child to parent).
 * 
 * One common issue in deep neural networks is called vanishing gradients. This
 * occurs when the gradients in certain nodes approach zero, which can prevent
 * effective learning by causing gradients in ancestor nodes to also approach
 * zero.
 * 
 * Important: If a node has a gradient of 0, it doesn't necessarily mean that
 * all of its ancestor nodes will also have a gradient of 0.
 * 
 * 3. You are not given the exact architecture of the neural network; the
 * network can have any structure, as long as it remains a DAG (no cycles).
 * 
 * 
 * Problem Statement:
 * You are given a neural network graph and a list of nodes that have a gradient
 * of 0. Your task is to identify the root cause nodes.
 * 
 * A root cause node is defined as:
 * 1. A node with a gradient of 0.
 * 2. It has no descendants (including descendants of descendants) with a
 * gradient of 0.
 * 
 * Input:
 * 1. A neural network graph represented as an adjacency list. Each index in
 * this list contains the child nodes of that node. For example:
 * 
 * If the graph contains the list [[1, 2], [3], [3], []], this means:
 * 1. Node 0 has two children, nodes 1 and 2.
 * 2. Node 1 has one child, node 3.
 * 3 Node 2 has one child, node 3.
 * 4. Node 3 has no children.
 * 
 * 2. A list of nodes with a gradient of 0.
 * 
 * Output:
 * Return a list of root cause nodes. These are the nodes with 0 gradient that
 * do not have any descendants (direct or indirect) with 0 gradients.
 * '''
 * 
 * SOLUTION APPROACH:
 * 
 * 1. Convert zero_grad list to a Set for O(1) lookup
 * 2. For each node with zero gradient, check if it has any descendants with zero gradient
 * 3. Use DFS/BFS to explore all descendants of each zero-gradient node
 * 4. A node is a root cause if it has zero gradient but none of its descendants do
 * 
 * Algorithm:
 * - For each zero-gradient node:
 *   - Perform DFS on all its descendants
 *   - If any descendant also has zero gradient, this node is NOT a root cause
 *   - If no descendants have zero gradient, this node IS a root cause
 * 
 * Time Complexity: O(V + E) where V is number of nodes and E is number of edges
 * Space Complexity: O(V) for the recursion stack and data structures
 * 
 * # ---------------- TEST CASE 1 --------------------
 * network_1 = [
 * [3, 4], # node 0
 * [3, 4, 5], # node 1
 * [4, 5], # node 2
 * [6, 7], # node 3
 * [6, 7, 8], # node 4
 * [7, 8], # node 5
 * [9, 10], # node 6
 * [9, 10], # node 7
 * [9, 10], # node 8
 * [], # node 9
 * [] # node 10
 * ]
 * zero_grad_1 = [0, 1, 2, 5, 6]
 * 
 * Analysis:
 * - Node 0: descendants include nodes 3,4,6,7,8,9,10. Node 6 has zero gradient → NOT root cause
 * - Node 1: descendants include nodes 3,4,5,6,7,8,9,10. Nodes 5,6 have zero gradient → NOT root cause  
 * - Node 2: descendants include nodes 4,5,7,8,9,10. Node 5 has zero gradient → NOT root cause
 * - Node 5: descendants include nodes 7,8,9,10. None have zero gradient → IS root cause
 * - Node 6: descendants include nodes 9,10. None have zero gradient → IS root cause
 * 
 * Expected output: [5, 6]
 * 
 * causes_1 = find_root_cause_vanishing_grads(network_1, zero_grad_1)
 * causes_1 = ",".join(str(node) for node in sorted(causes_1))
 * assert causes_1 == "5,6"
 * 
 * print("test case 1 passes")
 * 
 * def find_root_cause_vanishing_grads(network: List[list], zero_grad: list) ->
 * list:
 * return []
 * 
 */

class NeuralNetworkZeroGradient {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
