package com.github.sunlggggg.javalearning.concurrent;

import java.io.*;
// 使用vscode 在java中输入需要使用  integratedTerminal 而不是 internalConsole
public class VscodeInputDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String str = null; 
        System.out.println("Enter your value:"); 
        str = br.readLine(); 
        System.out.println("your value is :"+str); 
    }
}