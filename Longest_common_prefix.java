import java.util.Scanner;

public class Longest_common_prefix {
      
    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;
       
    // Trie node
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
       
        // isLeaf is true if the node represents
        // end of a word
        boolean isLeaf;
          
        // constructor
        public TrieNode() {
            isLeaf = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    };
       
    static TrieNode root;
    static int indexs;
       
    // If not present, inserts the key into the trie
    // If the key is a prefix of trie node, just marks
    // leaf node
    static void insert(String key)
    {
        int length = key.length();
        int index;
       
        TrieNode pCrawl = root;
       
        for (int level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
       
            pCrawl = pCrawl.children[index];
        }
       
        // mark last node as leaf
        pCrawl.isLeaf = true;
    }
       
    // Counts and returns the number of children of the
    // current node
    static int countChildren(TrieNode node)
    {
        int count = 0;
        for (int i=0; i<ALPHABET_SIZE; i++)
        {
            if (node.children[i] != null)
            {
                count++;
                indexs = i;
            }
        }
        return (count);
    }
       
    // Perform a walk on the trie and return the
    // longest common prefix string
    static String walkTrie()
    {
        TrieNode pCrawl = root;
        indexs = 0;
        String prefix = "";
       
        while (countChildren(pCrawl) == 1 &&
                pCrawl.isLeaf == false)
        {
            pCrawl = pCrawl.children[indexs];
            prefix += (char)('a' + indexs);
        }
        return prefix;
    }
       
    // A Function to construct trie
    static void constructTrie(String arr[], int n)
    {
        for (int i = 0; i < n; i++)
            insert (arr[i]);
        return;
    }
       
    // A Function that returns the longest common prefix
    // from the array of strings
    static String commonPrefix(String arr[], int n)
    {
        root = new TrieNode();
        constructTrie(arr, n);
       
        // Perform a walk on the trie
        return walkTrie();
    }
    public static int countWords(String[] arr, String prefix){
		int count=0;
		for(String a: arr)
			if(a.startsWith(prefix))
			count++;
			return count;
		
	}   
    
    // Driver program to test above function
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int numberOfWords = Integer.parseInt(sc.nextLine().trim());
		String[] array = new String[4];
		String[] array2 = new String[3];
        for(int i=0; i<array.length; i++){
        	//String line = sc.nextLine().trim();
        	array[i] = sc.nextLine();
        	
        }
        for(int i=0; i<array2.length; i++){
        	//String line = sc.nextLine().trim();
        	array2[i] = sc.nextLine();
        	
        }
        sc.close();
        //for(int i=0; i<array.length; i++)
        //System.out.println(array[i]);
        //String array[] = {"engineer", "engaging", "engine", "english"};
        int n = array.length;
        String ans = commonPrefix(array, n);
        int count= countWords(array, ans);
        
        //String array2[] = {"word","wolve" , "wolf"};
        int l=array2.length;
        String result=commonPrefix(array2, l);
        int count2=countWords(array2, result);
        

        if(ans.length()>result.length()){

             System.out.println("Longest common prefix: "+ans);
            System.out.println("Number of strings: " + count);
        }

        else{
            System.out.println("Longest common prefix is "+result);
            System.out.println("Number of strings: " + count2);

        }

           
        
            
        
            //System.out.println("There is no common prefix");

    }
}
