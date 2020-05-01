package calculatorPackage;

import java.util.Scanner;

public class Define implements Operate {
    public void Operation(Stack stack, String line) {
        Scanner scanner = new Scanner(line);
        scanner.next();
        stack.define_map.put(scanner.next(), scanner.nextDouble());
    }
}
