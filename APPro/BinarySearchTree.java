import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree extends Component {
    private BSTNode root;
    StringBuilder displayText = new StringBuilder();
    JTextArea displayArea = new JTextArea();

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(String key, String value) {
        root = insertRec(root, key, value);
    }

    private BSTNode insertRec(BSTNode node, String key, String value) {
        if (node == null) {
            return new BSTNode(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = insertRec(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = insertRec(node.right, key, value);
        } else {
            node.value = value; // Update the value if the key exists
        }
        return node;
    }

    public String search(String key) {
        return searchRec(root, key);
    }

    private String searchRec(BSTNode node, String key) {
        if (node == null) {
            return null;
        }
        if (key.equals(node.key)) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return searchRec(node.left, key);
        } else {
            return searchRec(node.right, key);
        }
    }

    public void inOrderTraversal() {
        inOrderRec(root);
    }

    private void inOrderRec(BSTNode node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.key + ": " + node.value);

            displayText.append(node.key).append(": ").append(node.value).append("\n");
            displayArea.setText(displayText.toString());
            inOrderRec(node.right);
        }
    }

    public void saveToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        saveToFileRec(root, writer);
        writer.close();
    }

    private void saveToFileRec(BSTNode node, BufferedWriter writer) throws IOException {
        if (node != null) {
            writer.write(node.key + "|" + node.value);
            writer.newLine();
            saveToFileRec(node.left, writer);
            saveToFileRec(node.right, writer);
        }
    }

    public void loadFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|", 2); // Split into key and value
            if (parts.length == 2) {
                insert(parts[0], parts[1]);
            }
        }
        reader.close();
    }

    public void delete(String key) {
        root = deleteRec(root, key);
    }

    private BSTNode deleteRec(BSTNode root, String key) {
        if (root == null) {
            return root;
        }
        if (key.compareTo(root.key) < 0) {
            root.left = deleteRec(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    private String minValue(BSTNode root) {
        String minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    
    public List<String> searchByPrefix(String prefix) {
        List<String> results = new ArrayList<>();
        searchByPrefixRec(root, prefix, results);
        return results;
    }

    private void searchByPrefixRec(BSTNode node, String prefix, List<String> results) {
        if (node != null) {
            if (node.key.startsWith(prefix)) {
                results.add(node.key);
            }
            searchByPrefixRec(node.left, prefix, results);
            searchByPrefixRec(node.right, prefix, results);
        }
    }
    
    public List<String> suggestClosest(String partialWord) {
        List<String> suggestions = new ArrayList<>();
        suggestClosestRec(root, partialWord, suggestions);
        return suggestions;
    }

    private void suggestClosestRec(BSTNode node, String partialWord, List<String> suggestions) {
        if (node != null) {
            if (node.key.contains(partialWord)) {
                suggestions.add(node.key);
            }
            suggestClosestRec(node.left, partialWord, suggestions);
            suggestClosestRec(node.right, partialWord, suggestions);
        }
    }

    private class BSTNode {
        String key;
        String value;
        BSTNode left, right;

        public BSTNode(String key, String value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }
}
