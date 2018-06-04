package com.company;
import com.sun.deploy.util.StringUtils;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;
import java.util.Random;

public class Eliza {
   private static String[] changedWordsHolder = new String[20];
    public static void main(String[] args) {
	// write your code here
        Random rand = new Random();
        int index = rand.nextInt(6);
        System.out.println("Good day. What is your problem? Enter your response here or Q to quit");
        Scanner input = new Scanner(System.in);
        String respo=input.nextLine();
        String[] splitWordsHolder = new String[20];
        final String[] response={"Why do you say that ","please tell me more  ","you seem to think that ","so , " +
                     "you are concerned that ","Many of my patients tell me the same thing ","It is getting late, maybe we had better quit "};

        while(!(respo.equalsIgnoreCase("q"))){
              int questionNumber= rand.nextInt(5);;
              arrayChanger(response[questionNumber],stringSplitter(respo));
              //System.out.println(fixedRes);
              String respo2=input.nextLine();
              respo=respo2;
              questionNumber++;

            }

        }

    public static String swapper(String word){
        switch (word){
            case "i":word="you";
            break;
            case"me":word="you";
            break;
            case "my":word="your";
            break;
            case"am":word="are";
            break;
        }
        return word;
    }
    public static void arrayChanger(String s1,String[]splitted){
        for(int i=0;i<splitted.length;i++){
            changedWordsHolder[i]=swapper(splitted[i]).concat(" ");
        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < splitted.length; i++) {
            result.append( changedWordsHolder[i] );
            //result.append( optional separator );
        }
        String combined=s1.concat(result.toString());
        System.out.println(combined);

    }

    public static String[] stringSplitter(String respo){
        int i=0;

        String[] splitted=respo.split(" ");

        return splitted;
    }
}
