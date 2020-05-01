package calculatorPackage;

import java.util.Scanner;

public class Push implements Operate {
    public void Operation(Stack stack, String line) {
        Scanner scanner = new Scanner(line);
        scanner.next();
        String num = scanner.next();
        if (stack.define_map.containsKey(num)) {
            stack.stack_list.add(stack.define_map.get(num));
        }
        else {
            stack.stack_list.add(Double.parseDouble(num));
        }
    }
}
