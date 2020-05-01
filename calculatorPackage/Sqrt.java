package calculatorPackage;

import java.util.Scanner;

public class Sqrt implements Operate {
    public void Operation(Stack stack, String line) {
        double num = (double)stack.stack_list.get(stack.stack_list.size() - 1);
        stack.stack_list.remove(stack.stack_list.size() - 1);
        stack.stack_list.add(Math.sqrt(num));
    }
}