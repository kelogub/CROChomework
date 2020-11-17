package work;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    static String normalize(String args){
        Stack<String> stack = new Stack<>();
        String [] a = args.split("/");
        for (var i : a){
            String tmp = null;
            if (stack.size()>0) tmp = stack.pop();
            if (i.equals("..") && tmp != null &&!tmp.equals("..")) continue;
            else if (i.equals(".")) stack.push(tmp);
            else{
                if (tmp!=null) stack.push(tmp);
                stack.push(i);
            }
        }
        var ret = new StringBuilder("");
        for (var i : stack){
            ret.append(i).append("/");
        }
        ret.deleteCharAt(ret.length()-1);
        return ret.toString();
    }

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        try{
            System.out.println(normalize(args[0]));
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Введите строку в качестве параметра:");
            Scanner in = new Scanner(System.in);
            System.out.println(normalize(in.nextLine()));
        }
    }
}
