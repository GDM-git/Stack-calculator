package calculatorPackage;

public class Plus implements Operate {
    public void Operation(Stack stack, String line) {
        double num1 = (double)stack.stack_list.get(stack.stack_list.size() - 1);
        stack.stack_list.remove(stack.stack_list.size() - 1);
        double num2 = (double)stack.stack_list.get(stack.stack_list.size() - 1);
        stack.stack_list.remove(stack.stack_list.size() - 1);
        stack.stack_list.add(num1+num2);
    }
}
