
import java.util.ArrayList;

import java.util.Scanner;
import java.util.Set;
 

/**
 * LongestPrefix.
 */
public class Trie{
    private static Scanner sc;
    TrieNode root;
	static ArrayList<String> inputs;
	
	public TrieNode getRoot() {
		return root;
	}
	public void setRoot(TrieNode root) {
		this.root = root;
	}
	public static ArrayList<String> getInputs() {
		return inputs;
	}
	public static void setInputs(ArrayList<String> inputs) {
		Trie.inputs = inputs;
	}
	public Trie()
	{
		root = new TrieNode();
	}
	
	public void insert(String word)
	{
		TrieNode current = root;
		for(int i=0;i<word.length();i++)
		{
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if(node==null)
			{
				node = new TrieNode();
				current.children.put(ch,node);
			}
			current = node;
		}
		current.isEndOfWord = true;
	}
	public boolean search(String word)
	{
		TrieNode current = root;
		for(int i=0;i<word.length();i++)
		{
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if(node==null)
				return false;
			current = node;
		}
		
		return current.isEndOfWord;
	}
	public String longestCommonPrefix()
	{
		StringBuilder prefix = new StringBuilder();
		TrieNode current = root;
		while(current!=null && current.children.size()==1 && !current.isEndOfWord)
		{
			Set<Character> set = current.children.keySet();
			
			String key = set.iterator().next().toString();
			TrieNode node = current.children.get(key.charAt(0));
			current = node;
			prefix.append(key.charAt(0));
		}
		
		return "Longest common prefix: " + prefix.toString();
	}
	public int countWords(ArrayList<String> words, String prefix){
		int count=0;
		for(String a: words)
			if(a.startsWith(prefix))
			count++;
			return count;
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int numberOfWords = Integer.parseInt(sc.nextLine().trim());


		
	}
    }
	

