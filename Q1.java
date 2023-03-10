import java.util.Scanner;

//a class for Trie Structure
class Trie2 {
    String val; //leaf

    Trie2[] children = new Trie2[2];

    public Trie2() {
        val = "";
        children[0] = null;
        children[1] = null;
    }
}

public class Q1 {
	
	static Trie2 root;
	// Store line values
	static String[] binaryNumbers;
	// Put 0's to beginning of binary numbers
	static String[] binaryNumbersFormatted;
	
    static String mask;
    static final int MAX_SIZE = 32;
	
	public static void readInput(){
		Scanner sc = new Scanner(System.in);
        int numberOfBinary = Integer.parseInt(sc.nextLine().trim());
		binaryNumbers = new String[numberOfBinary];
		binaryNumbersFormatted = new String[numberOfBinary];
        for(int i=0; i<numberOfBinary; i++){
        	String line = sc.nextLine().trim();
        	binaryNumbers[i] = line;
        	binaryNumbersFormatted[i] = formatLine(line);
        }
        mask = formatLine(sc.nextLine().trim());
        sc.close();
    }
	
	// Put 0's to beginning of the binary numbers
	private static String formatLine(String line) {
		String formatted = "";
		for(int i=0;i<MAX_SIZE-line.length();i++)
			formatted+="0";
		formatted+=line;
		return formatted;
	}

	private static int findMinXOR() {

		String minXorVal = "2"; // "2" is always greater than 1111111...
		
		// Minimum xor value index
		int index = -1;

        for (int j = 0; j < binaryNumbersFormatted.length; j++) {
        	insert(binaryNumbersFormatted[j]);
        	String candidate = minXORUtil();
        	
        	if(minXorVal.compareTo(candidate)>0) {
        		minXorVal = candidate;
        		index = j;
        	}

        }
        return index;
		
	}
	
	static String minXORUtil() {
        Trie2 tmp = root;
        StringBuilder sb = new StringBuilder();
        
        for (int j = 0; j < MAX_SIZE; j++) {
            int currentBit = mask.charAt(j)-'0';
            if (tmp.children[currentBit] != null) {
                tmp = tmp.children[currentBit];
            }
            else if (tmp.children[1 - currentBit] != null) {
                tmp = tmp.children[1 - currentBit];
            }
        }
        
        // xor operation
        for (int j = 0; j < MAX_SIZE; j++) {        
            int currentBit = mask.charAt(j)-'0';
            sb.append("" + (currentBit ^ (tmp.val.charAt(j)-'0')));
        }
        return sb.toString();
    }
	
	public static void insert(String ele) {
        Trie2 tmp = root;
        
        for (int j = 0; j < MAX_SIZE; j++) {
       
            int currentBit = ele.charAt(j)-'0';
            
            // Adding a new node in the TRIE
            if (tmp != null && tmp.children[currentBit] == null) {
                tmp.children[currentBit] = new Trie2();
            }

            tmp = tmp.children[currentBit];
        }
        tmp.val = ele;
    }
	
	public static void main(String[] args) {
		
		root = new Trie2();
		readInput();
		int index = findMinXOR();
		System.out.println(binaryNumbers[index]);

	}



}
