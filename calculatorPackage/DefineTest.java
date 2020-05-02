package calculatorPackage;

import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class DefineTest {

    @org.junit.jupiter.api.Test
    void operation() {
        Define define = new Define();
        Stack stack = new Stack();
        String str = new String();
        boolean def_bool = true;
        for (int i = 0; i < 1000000; i++) {
            str = "DEFINE a " + i;
            define.Operation(stack, str);
            if (stack.define_map.get("a") != i) {
                def_bool = false;
                break;
            }
        }
        Assert.assertTrue(def_bool);
    }
}