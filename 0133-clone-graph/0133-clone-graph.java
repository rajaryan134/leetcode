class Solution {
    // A HashMap to map the original node's value (Integer) to its cloned node (Node).
    // This map handles "visited" tracking and provides fast access to clones.
    HashMap<Integer, Node> nodes = new HashMap<>();

    public Node cloneGraph(Node node) {
        // If the starting node is null, the clone must also be null.
        if (node == null) return null;

        // Check if the node has already been cloned.
        // The HashMap.containsKey() method checks for the key's existence.
        if (nodes.containsKey(node.val)) {
            // If it's already cloned, return the existing copy from the map.
            return nodes.get(node.val);
        }

        // This is the first time visiting this node.
        // Create a new node (the copy).
        Node copiedNode = new Node(node.val);
        // Add the newly created copy to the map to prevent re-cloning.
        nodes.put(node.val, copiedNode);

        // Iterate through all neighbors of the original node.
        for (Node neighbor : node.neighbors) {
            // Recursively call cloneGraph for each neighbor and add the
            // returned clone to our new node's neighbor list.
            copiedNode.neighbors.add(cloneGraph(neighbor));
        }

        // Return the new node, whose adjacency list is now fully copied.
        return copiedNode;
    }
}