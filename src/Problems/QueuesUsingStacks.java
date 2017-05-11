package Problems;

import java.util.Stack;

// import com.google.common.base.Converter;

/**
 * Created by shobhitagarwal on 3/2/16.
 */
public class QueuesUsingStacks {

  public static void fizzBuzz() {
    for (int i = 1; i <= 100; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        System.out.println("fizzbuzz");
      } else if (i % 5 == 0) {
        System.out.println("buzz");
      } else if (i % 3 == 0) {
        System.out.println("fizz");
      } else {
        System.out.println(i);
      }
    }
  }


  // implementing queues means that we have to implement push, pop, first and isEmpty
  Stack<Integer> qStack = new Stack<Integer>();
  Stack<Integer> temp = new Stack<>();

  void push(int x) {
    if (qStack.isEmpty()) {
      qStack.push(x);
    } else {
      while (!qStack.isEmpty()) {
        temp.push(qStack.pop());
      }

      qStack.push(x);

      while (!temp.isEmpty()) {
        qStack.push(temp.pop());
      }
    }
  }

  int pop() {
    return qStack.pop();
  }

  boolean isEmpty() {
    return qStack.isEmpty();
  }

  int peek() {
    return qStack.peek();
  }

  //    @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Integer i : qStack) {
      sb.append(i.toString() + "--");

    }
    return sb.toString();
  }

  public static void main(String[] args) {
    QueuesUsingStacks.fizzBuzz();

    QueuesUsingStacks q = new QueuesUsingStacks();

    for (int i = 0; i < 20; i++) {
//            if( i%3 == 0)
      q.push(i);
    }

    System.out.println(q);


  }

}
