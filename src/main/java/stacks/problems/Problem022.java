package stacks.problems;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

public class Problem022 {

  public static boolean aKnowsB(String a, String b) {
    //Assuming D is a celebrity
    if(a.equals("D")) return false;
    if(b.equals("D")) return true;

    //else we return random results
    Random random = new Random();
    int num = random.nextInt(10 - 1 + 1) + 1;
    return num % 2 == 0;
  }

  public static String findCelebrity(String people[]) {

    Stack<String> stack = new Stack<String>();
    for(String person : people) {
      stack.push(person);
    }

    while(!stack.isEmpty() && stack.size() != 1) {
      String personA = stack.pop();
      String personB = stack.pop();
      boolean doesAKnowsB = aKnowsB(personA, personB);
      if(doesAKnowsB) { // A is not a celebrity
        stack.push(personB);
      }
      else { //B is not a celebrity
        stack.push(personA);
      }
    }

    boolean celebrityPresent = true;
    String celebrity = stack.pop();

    for(String person : people) {
      if(aKnowsB(celebrity, person)) {
        celebrityPresent = false;
        break;
      }
    }

    return celebrityPresent ? celebrity : null;

  }

  public static void main(String[] args) {

    String[] people = new String[] {
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"
    };

    System.out.println(Arrays.toString(people));
    String celebrity = findCelebrity(people);
    System.out.println(celebrity);

  }

}

 /**
  *  If A knows B then we A is not a celebrity hence we can discard A.
  *  If A does not know B then B is not a celebrity hence we can discard B.
  *
  *  We will add the people in stack, pick two person at a time, check if they know one another
  *  and then discard one of them based on the result and move the other person on the stack.
  *
  *  We do this until we have only once person in the stack. And then we check if this person knows
  *  anyone or not.
  *
  *  The function 'aKnowsB' is called 3(N-1) times.
  *
  */
