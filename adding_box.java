package com.company;

import java.util.Scanner;

//在组合模式结构图中，如果聚合关联关系不是从Composite到Component的，而是从Composite到Leaf的，如图所示，会产生怎样的结果，请阐述？
public class Main {

    public static void main(String[] args) {
	// write your code here
    System.out.println("Hello world");
        Scanner in=new Scanner(System.in);
//        System.out.println("echo:"+in.nextLine());
        System.out.print("请输入数1:");

        final int amount=in.nextInt();
        System.out.print("请输入数2:");
    int price=in.nextInt();

        System.out.println(amount+"+"+price+"="+(amount+price));
    }
}
