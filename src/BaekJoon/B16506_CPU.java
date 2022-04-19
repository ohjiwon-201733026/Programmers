package BaekJoon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class B16506_CPU {

    static HashMap<String,String> rB;
    static HashMap<String,String> sharpC;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();

        initHashMap();
        StringBuilder sb=new StringBuilder();
        while (n-->0){
            String s=sc.nextLine();
            sb.append(machLan(s)).append("\n");
        }
        System.out.println(sb.toString());

    }

    static void initHashMap(){
        rB=new HashMap<>();
        sharpC=new HashMap<>();

        rB.put("ADD","00000");
        rB.put("SUB","00010");
        rB.put("MOV","00100");
        rB.put("AND","00110");
        rB.put("OR","01000");
        rB.put("NOT","01010");
        rB.put("MULT","01100");
        rB.put("LSFTL","01110");
        rB.put("LSFTR","10000");
        rB.put("ASFTR","10010");
        rB.put("RL","10100");
        rB.put("RR","10110");

        sharpC.put("ADDC","00001");
        sharpC.put("SUBC","00011");
        sharpC.put("MOVC","00101");
        sharpC.put("ANDC","00111");
        sharpC.put("ORC","01001");
        sharpC.put("MULTC","01101");
        sharpC.put("LSFTLC","01111");
        sharpC.put("LSFTRC","10001");
        sharpC.put("ASFTRC","10011");
        sharpC.put("RLC","10101");
        sharpC.put("RRC","10111");
    }

    static String machLan(String s){
        String [] arr=s.split(" ");
        String op=arr[0];
        StringBuilder sb=new StringBuilder();
        if(rB.containsKey(op)){
            String opcode=rB.get(op);
            sb.append(opcode).append(0).append(toBinary(Integer.parseInt(arr[1])))
                    .append(toBinary(Integer.parseInt(arr[2]))).append(toBinary(Integer.parseInt(arr[3]))).append(0);
        }
        else if(sharpC.containsKey(op)){
            String opcode=sharpC.get(op);
            sb.append(opcode).append(0).append(toBinary(Integer.parseInt(arr[1])))
                    .append(toBinary(Integer.parseInt(arr[2]))).append(toSharpC(arr[3]));
        }
        return sb.toString();
    }

    static String toBinary(int num){
        if(num==0) return "000";
        if(num==1) return "001";
        if(num==2) return "010";
        if(num==3) return "011";
        if(num==4) return "100";
        if(num==5) return "101";
        if(num==6) return "110";
        if(num==7) return "111";

        return "";
    }

    static String toSharpC(String n){
        int num=Integer.parseInt(n);
        StringBuilder sb=new StringBuilder();
        while (num!=0){
            sb.insert(0,num%2);
            num/=2;
        }

        if(sb.toString().length()==4) return sb.toString();
        else{
            int x=4-sb.toString().length();
            for(int i=0;i<x;++i) sb.insert(0,0);
            return sb.toString();
        }
    }



}
