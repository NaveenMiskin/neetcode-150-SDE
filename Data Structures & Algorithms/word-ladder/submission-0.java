class Solution {
    class Pair {
        String word;
        int steps;
        public Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> hs = new HashSet<>();
        for(int i = 0; i < wordList.size(); i++) {
            hs.add(wordList.get(i));
        }
        hs.remove(beginWord);

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            String word = cur.word;
            int steps = cur.steps;

            if(word.equals(endWord) == true) return steps;

            for(int i = 0; i < word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedChars = word.toCharArray();
                    replacedChars[i] = ch;
                    String replacedWord = new String(replacedChars);

                    if(hs.contains(replacedWord) == true) {
                        hs.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}
