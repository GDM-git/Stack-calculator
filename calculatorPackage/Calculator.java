package calculatorPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

public class Calculator {
    Calculator() {
        Stack stack = new Stack();
        Properties properties = new Properties();
        HashMap<String, Operate> operate_map = new HashMap<String, Operate>();
        try {
            Scanner scan = new Scanner(System.in);
            FileInputStream in = new FileInputStream("Commands.properties");
            properties.load(in);
            while (scan.hasNextLine()) {
                try {
                    String line = scan.nextLine();
                    Scanner scan_line = new Scanner(line);
                    String command = scan_line.next();
                    if (command.charAt(0) == '#') continue;
                    Operate operation = operate_map.get(command);
                    if (operation == null) {
                        Class<?> class_operate = Class.forName(properties.getProperty(command));
                        Constructor<?> constructor_operate = class_operate.getConstructor();
                        operation = (Operate) constructor_operate.newInstance();
                        operate_map.put(command, operation);
                    }
                    operation.Operation(stack, line);
                } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exit");
        }
    }
    Calculator(String file_in) {
        File File_in = new File(file_in);
        Stack stack = new Stack();
        Properties properties = new Properties();
        HashMap<String, Operate> operate_map = new HashMap<String, Operate>();
        try {
            Scanner scan = new Scanner(File_in);
            FileInputStream in = new FileInputStream("Commands.properties");
            properties.load(in);
            try {
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    Scanner scan_line = new Scanner(line);
                    String command = scan_line.next();
                    if (command.charAt(0) == '#') continue;
                    Operate operation = operate_map.get(command);
                    if (operation == null) {
                        Class<?> class_operate = Class.forName(properties.getProperty(command));
                        Constructor<?> constructor_operate = class_operate.getConstructor();
                        operation = (Operate) constructor_operate.newInstance();
                        operate_map.put(command, operation);
                    }
                    operation.Operation(stack, line);
                }
            } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exit");
        }
    }
}