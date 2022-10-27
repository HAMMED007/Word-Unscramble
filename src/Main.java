import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

//First we need to add the dictionary.txt of 70,000 words to arraylist

        BufferedReader bufReader = new BufferedReader(new FileReader("C:\\dictionary.txt"));
        ArrayList<String> listOfLines = new ArrayList<>();
        String line = bufReader.readLine();
        while (line != null) {

            listOfLines.add(line);
            line = bufReader.readLine();

        }

        bufReader.close();




//Ends here

// now we need to scramble the word
        double scores = 0;
        double total = 1;

while (true) {

    // we are generating random words from the dictionary here
    Random randomGenerator2 = new Random();
    int rd = randomGenerator2.nextInt(listOfLines.size());
    String dictionary_word = listOfLines.get(rd);

    char[] ch = dictionary_word.toCharArray();
    StringBuilder sb = new StringBuilder();


    ArrayList<Integer> numbers = new ArrayList<>();
    Random randomGenerator = new Random();



    while (sb.length() < dictionary_word.length()) {


        int random = randomGenerator.nextInt(dictionary_word.length());
        if (!numbers.contains(random)) {

            numbers.add(random);
            sb.append(ch[random]);


        }


    }


    Scanner sc = new Scanner(System.in);

    while (true) {


        System.out.println();
        System.out.println("Unscramble the world: " + sb.toString().toUpperCase());

        System.out.println("Answer:");
        String answer = sc.next();


        if (answer.equals(dictionary_word)) {
            System.out.println("correct!");
            scores++;
            break;

        } else
            System.out.println("INCORRECT");
        break;






    }
    System.out.println("press 'y' to continue and press 'n' to get your score:");
    char com = sc.next().charAt(0);

    if (com == 'n')
        break;

    total++;
  System.out.println("******************************************************************************");
}

        System.out.println("your score is " + (scores/total)*100 +"% " );

    }
}