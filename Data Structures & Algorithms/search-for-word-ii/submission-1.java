class Solution {
    class TrieNode {
        boolean endOfWord;
        String word;
        TrieNode[] children = new TrieNode[26];
    }

    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode node = root;

        for(char c : word.toCharArray()) {
            int index = c - 'a';

            if(node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }
        node.endOfWord = true;
        node.word = word;
    }

    List<String> result = new ArrayList<>();

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    void DFS(int row, int col, TrieNode node, char[][] board) {
        int m = board.length;
        int n = board[0].length;

        if(row < 0 || row >= m || col < 0 || col >= n) return;

        if(board[row][col] == '#') return;

        char c = board[row][col];
        int index = c - 'a';
        if(node.children[index] == null) return;

        node = node.children[index];

        if(node.endOfWord) {
            result.add(node.word);
            node.endOfWord = false;
        }

        board[row][col] = '#';

        for(int i = 0; i < 4; i++) {
            int newrow = row + dr[i];
            int newcol = col + dc[i];

            DFS(newrow, newcol, node, board);
        }

        board[row][col] = c;
    }

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;

        for(String word : words) {
            insert(word);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                DFS(i, j, root, board);
            }
        }
        return result;
    }
}
