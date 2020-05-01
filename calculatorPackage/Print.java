package calculatorPackage;

public class Print implements Operate {
    public void Operation(Stack stack, String line) {
        System.out.println(stack.stack_list.get(stack.stack_list.size() - 1));
    }
}
