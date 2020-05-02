/**
 * The {@code BracketChecker} in this class is an 
 * implementation of a bracket checker which ensures
 * brackets in a string are balanced (each open bracket
 * has a closing one of the same type).
 *
 * @author Ahmed Jouda
 */
package projectCode20280;

public class BracketChecker {
	public static boolean isMatched(String expression) {
		final String opening = "({["; // opening parenthesis
		final String closing = ")}]"; // respective closing parenthesis
		Stack<Character> buffer = new LinkedStack<>();
		for (char c : expression.toCharArray()) {
			if (opening.indexOf(c) != -1) // this is a left delimiter
				buffer.push(c);
			else if (closing.indexOf(c) != -1) { // this is a right delimiter
				if (buffer.isEmpty()) // nothing to match with
					return false;
				if (closing.indexOf(c) != opening.indexOf(buffer.pop()))
					return false; // mismatched delimiter
			}
		}
		return buffer.isEmpty(); //were they all matched
	}

	public static void main(String[] args) {
		// create strings including brackets to test in a string array
		String[] inputs = { "[]]()()", "c[d]", "a{b[c]d}e", "a{b(c]d}e", "a[b{c}d]e}", "a{b(c) ", "][]][][[]][]][][[[",
				"(((abc))((d)))))", "([)]", "([{}])" };
		// iterate through the string array and test each string while outputting the
		// results
		for (String input : inputs) {
			boolean isBalanced = BracketChecker.isMatched(input);
			System.out.println("isBalanced " + (isBalanced ? " YES " : "  NO ") + input);
		}
	}
}
