import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Q2
{
// A class to store a Trie node


	// Iterative function to insert a string into a Trie
	private static void insert(TrieNode head, String str)
	{
		// start from the root node
		TrieNode curr = head;

		for (char c: str.toCharArray())
		{
			// create a new node if the path doesn't exist
			curr.character.putIfAbsent(c, new TrieNode());

			// go to the next node
			curr = curr.character.get(c);
		}

		curr.isLeaf = true;
	}

	// Function to find the longest common prefix
	public static String findLCP(List<String> dict)
	{
		// insert all keys into a Trie
		TrieNode head = new TrieNode();
		for (String s: dict) {
			insert(head, s);
		}

		// traverse the Trie and find the longest common prefix

		StringBuilder lcp = new StringBuilder();
		TrieNode curr = head;

		// loop until we find a leaf node or a node has more than 1 child
		while (curr != null && !curr.isLeaf && (curr.character.size() == 1))
		{
			for (var entry: curr.character.entrySet())
			{
				// append current char to LCP
				lcp.append(entry.getKey());

				// update `curr` pointer to the child node
				curr = entry.getValue();
			}
		}

		return lcp.toString();
	}

	public static void main (String[] args)
	{
		// given set of keys
		List<String> dict = Arrays.asList(
				"engineer",
                "engaging",
                "engine", 
                "english" ,
                "word" ,
                "wolve" ,
                "wolf"
		);

		System.out.println("The longest common prefix is " + findLCP(dict));
	}
}