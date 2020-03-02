package projectCode20280;

public class BracketChecker {
	public static boolean isMatched(String expression) {
		final String opening = "({["; // opening delimiters
		final String closing = ")}]"; // respective closing delimiters
		Stack<Character> buffer = new LinkedStack<>( );
		for (char c : expression.toCharArray( )) {
		if (opening.indexOf(c) != -1) // this is a left delimiter
		buffer.push(c);
		else if (closing.indexOf(c) != -1) { // this is a right delimiter
		if (buffer.isEmpty( )) // nothing to match with
		return false;
		if (closing.indexOf(c) != opening.indexOf(buffer.pop( )))
		 return false; // mismatched delimiter
		 }
		 }
		return buffer.isEmpty( ); // were all opening delimiters matched?
	}
	
	public static void main(String[] args) { 
		String [] inputs = { "[]]()()", "c[d]", "a{b[c]d}e", "a{b(c]d}e", "a[b{c}d]e}","a{b(c) ", "][]][][[]][]][][[[", "(((abc))((d)))))"};
		for(String input : inputs) { 
			boolean isBalanced = BracketChecker.isMatched(input);  
			System.out.println("isBalanced " + (isBalanced ? " yes! " : " no! ") + input); 
			} 
	}
}
