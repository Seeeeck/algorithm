package m09.d26;

import java.util.ArrayList;
import java.util.List;


/**
 * 前缀树 a-z
 */
public class TrieTree {
    private TrieNode root;

    public TrieTree(){
        root = new TrieNode();
    }

    public List<String> toList(){
        List<String> strings = new ArrayList<>();
        listStr("",root,-1,strings);
        return strings;
    }

    private void listStr(String prefix,TrieNode cur,int index,List<String> strings){
        if(cur == null){
            return;
        }
        if(cur.end != 0){
            for (int i = 0; i < cur.end; i++) {
                if(index == -1){
                    strings.add("");
                }else {
                    strings.add(prefix+(char)(index+'a'));
                }
            }
        }
        for (int i = 0; i < cur.nextNodes.length; i++) {
            if(cur.nextNodes[i] != null){
                if(index == -1){
                    listStr(prefix,cur.nextNodes[i],i,strings);
                }else {
                    listStr(prefix+(char)(index+'a'),cur.nextNodes[i],i,strings);
                }

            }
        }
    }

    public void insert(String ...words){
        for (String word : words) {
            insert(word);
        }
    }

    public void insert(String word){
        if (word == null){
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index;
        node.pass++;
        for (char aChar : chars) {
            index = aChar - 'a';
            if (node.nextNodes[index] == null) {
                node.nextNodes[index] = new TrieNode();
            }
            node = node.nextNodes[index];
            node.pass++;
        }
        node.end++;
    }


    public int deleteAll(String word){
        int count = count(word);
        delete(word,count);
        return count;
    }

    public boolean delete(String word){
        if (!exist(word)){
            return false;
        }
        delete(word,1);
        return true;
    }

    private void delete(String word,int count){
        if(count == 0){
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        node.pass -= count;
        int index;
        for (char aChar : chars){
            index = aChar - 'a';
            node.nextNodes[index].pass -= count;
            if (node.nextNodes[index].pass == 0){
                node.nextNodes[index] = null;
                return;
            }
            node = node.nextNodes[index];
        }
        node.end -= count;
    }

    public boolean exist(String word){
        return count(word) != 0;
    }

    private int count(String word){
        TrieNode node = lastNode(word);
        return node == null ? 0 : node.end;
    }

    public int countPrefix(String prefix){
        TrieNode node = lastNode(prefix);
        return node == null ? 0 : node.pass;
    }
    private TrieNode lastNode(String word){
        if(word == null){
            return null;
        }
        TrieNode node = root;
        int index;
        char[] chars = word.toCharArray();
        for (char aChar : chars){
            index = aChar - 'a';
            if(node.nextNodes[index] == null){
                return null;
            }
            node = node.nextNodes[index];
        }
        return node;
    }


    public int size(){
        return root.pass;
    }

    public void clear(){
        root = new TrieNode();
    }


    private static class TrieNode{
        private int pass;
        private int end;
        private final TrieNode[] nextNodes;

        public TrieNode(){
            pass = 0;
            end = 0;
            nextNodes = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        TrieTree tree = new TrieTree();
        tree.insert("","","cccc","aaa","abc","ddca","bcsd","abbb","abc","abad",null);
        List<String> strings = tree.toList();
        System.out.println(strings);
        tree.deleteAll("abc");
        tree.delete("bbbv");
        tree.deleteAll("");
        List<String> strings1 = tree.toList();
        System.out.println(strings1);

    }
}
