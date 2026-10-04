class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord;
    }

    public WordDictionary() {}

    TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode node = root;

        for(char c : word.toCharArray()) {
            int index = c - 'a';

            if(node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }
        node.endOfWord = true;
    }

    boolean DFS(int index, String word, TrieNode node) {
        if(index == word.length()) {
            return node.endOfWord;
        }

        char c = word.charAt(index);

        if(c != '.') {
            int childIndex = c - 'a';
            if(node.children[childIndex] == null) {
                return false;
            }
            return DFS(index + 1, word, node.children[childIndex]);
        }

        for(int i = 0; i < 26; i++) {
            if(node.children[i] != null) {
                if(DFS(index + 1, word, node.children[i])) return true;
            }
        }
        return false;
    }

    public boolean search(String word) {
        return DFS(0, word, root);
    }
}
