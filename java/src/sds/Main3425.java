package sds;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main3425 {
    static Stack<Long> stack = new Stack<Long>();
    static List<Command> cmdList = new ArrayList<>();
    static boolean success;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String comm = sc.next();
            if (comm.equals("END")) {
                int num = sc.nextInt();
                for (int i = 0; i < num; i++) {
                    stack.clear();
                    success = true;
                    stack.push(sc.nextLong());
                    for (Command cmd: cmdList){
                        if (!success) break;
                        switch (cmd.cmd) {
                            case "NUM":
                                stack.push(cmd.param);
                                break;
                            case "POP":
                                if (isOne()) stack.pop();
                                else success = false;
                                break;
                            case "INV":
                                if (isOne()) {
//                                    long a = stack.pop();
//                                    stack.push(-a);
                                    stack.push(-stack.pop());
                                } else success = false;
                                break;
                            case "DUP":
                                if (isOne()) stack.push(stack.peek());
                                else success = false;
                                break;
                            case "SWP":
                                if (isTwo()){
                                    long a = stack.pop();
                                    long b = stack.pop();
                                    stack.push(a);
                                    stack.push(b);
                                } else success = false;
                                break;
                            case "ADD":
                                if (isTwo()) {
                                    long a = stack.pop();
                                    long b = stack.pop();
                                    if (abs(a+b))
                                        stack.push(a+b);
                                    else success = false;
                                } else success = false;
                                break;
                            case "SUB":
                                if (isTwo()) {
                                    long a = stack.pop();
                                    long b = stack.pop();
                                    if (abs(b-a))
                                        stack.push(b-a);
                                    else success = false;
                                } else success = false;
                                break;
                            case "MUL":
                                if (isTwo()) {
                                    long a = stack.pop();
                                    long b = stack.pop();
                                    if (abs(a*b))
                                        stack.push(a*b);
                                    else success = false;
                                } else success = false;
                                break;
                            case "DIV":
                                if (isTwo()) {
                                    long a = stack.pop();
                                    long b = stack.pop();
                                    if (a != 0 && abs(b/a))
                                        stack.push(b/a);
                                    else success = false;
                                } else success = false;
                                break;
                            case "MOD":
                                if (isTwo()) {
                                    long a = stack.pop();
                                    long b = stack.pop();
                                    if (a != 0 && abs(b%a))
                                        stack.push(b%a);
                                    else success = false;
                                } else success = false;
                                break;
                        }
//                        System.out.println(cmd.cmd+"  stack >> "+stack);
                    }
                    if (success && stack.size()==1) System.out.println(stack.pop());
                    else System.out.println("ERROR");
                }
                System.out.println();
                cmdList.clear();
            } else if (comm.equals("QUIT")) {
                break;
            } else if (comm.equals("NUM")) {
                cmdList.add(new Command("NUM", sc.nextLong()));
            } else {
                cmdList.add(new Command(comm, 0));
            }

        }
    }

    static boolean isTwo () {
        return (stack.size() >= 2);
    }
    static boolean isOne () {
        return (stack.size() >= 1);
    }
    static boolean abs (long num) {
        return (Math.abs(num) <= 1000000000);
    }

}

class Command {
    long param;
    String cmd;

    public Command (String cmd, long param) {
        this.param = param;
        this.cmd = cmd;
    }

}

/*
num x = push (0 <= x <= 10**9) --> int 범위 +- 20억 2*10**9 / long 범위 +- 9*10**18
pop
inv = 부호 변경
dup = peek, push
swp = 위에 두 값 위치 변경
add = 위에 두개 더하기
sub = 두번쨰 - 첫번째
mul = 첫번째 * 두번째
div = second / first
mod = second mod first

program err
    숫자부족
    0으로 나눌때
    절댓값 10**9이상

 */