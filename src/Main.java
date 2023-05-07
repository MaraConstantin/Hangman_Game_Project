import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        // 1.afiseaza la consola Welcome to Hangman
        // 2.afiseaza la consola: cuvantul este: *****
        // 3.cere o litera de la user: Introdu o litera
        // 4. citeste de la user litera si o salveaza intr-o variabila
        // 5. parcurgem cuv si comparam cu fiecare litera din cuv cu litera salvata
        // 6.daca exista litera inlocuim steluta de la pozitia literei din cuvant in sirul de stelute
        //

        Scanner sc = new Scanner(System.in);
        Random rnd = new Random(); //genereaza doar numere
        int attempts = 7;
        ArrayList<String[]> pictures = new ArrayList<>(List.of(
                new String[] {
                        "  +----+\n",
                        "  |    |\n",
                        "       |\n",
                        "       |\n",
                        "       |\n",
                        "       |\n",
                        "=========\n"
                },
                new String[] {
                        "  +----+\n",
                        "  |    |\n",
                        "  O    |\n",
                        "       |\n",
                        "       |\n",
                        "       |\n",
                        "=========\n"
                },
                new String[] {
                        "  +----+\n",
                        "  |    |\n",
                        "  O    |\n",
                        "  |    |\n",
                        "       |\n",
                        "       |\n",
                        "=========\n"
                },
                new String[] {
                        "  +----+\n",
                        "  |    |\n",
                        "  O    |\n",
                        " /|    |\n",
                        "       |\n",
                        "       |\n",
                        "=========\n"
                },
                new String[] {
                        "  +----+\n",
                        "  |    |\n",
                        "  O    |\n",
                        " /|\\   |\n",
                        "       |\n",
                        "       |\n",
                        "=========\n"
                },
                new String[] {
                        "  +----+\n",
                        "  |    |\n",
                        "  O    |\n",
                        " /|\\   |\n",
                        " /     |\n",
                        "       |\n",
                        "=========\n"
                },
                new String[] {
                        "  +----+\n",
                        "  |    |\n",
                        "  O    |\n",
                        " /|\\   |\n",
                        " / \\   |\n",
                        "       |\n",
                        "=========\n"
                } ));
        ArrayList<Character> usedLetters = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>(Arrays.asList("parfume", "transport", "manager", "woman", "proportion", "prestige", "vegetable", "environment", "obligation", "exemple", "liability"));
        int index = rnd.nextInt(words.size());
        System.out.println("Welcome to Hangman!");

        System.out.print("Cuvantul este ");
        String hiddenWord = words.get(index);
        char[] stars = new char[hiddenWord.length()];
//        for (int i = 0; i <= stars.length-1 ; i++)
//        {
//            stars[i] = '*';
//        }
        Arrays.fill(stars, '*');
        System.out.println(String.valueOf(stars));

        while (true){
            boolean isLetterFound = false;
        System.out.println("Introdu o litera:");
        char letter = sc.next().charAt(0);
        if(!usedLetters.contains(letter))
        {
            usedLetters.add(letter);
        }
        else {
            System.out.println("You have already used this letter.");
        }
        for (int i = 0; i < hiddenWord.length(); i++)
        {
            if(hiddenWord.charAt(i) == letter)
            {
                stars[i] = letter;
                isLetterFound = true;
            }
        }
        if(!isLetterFound)  //e fals
        {
            attempts--;
            System.out.println("You have " + attempts + " attempts left.");
            for (String line : pictures.get(0)) {
                System.out.println(line);
            }
            pictures.remove(0);
        }
        if( pictures.isEmpty())
        {
            System.out.println("Game over! Try Again!");
            System.out.println("The hidden word was " + hiddenWord);
            break;
        }
            System.out.println(String.valueOf(stars));

        if(hiddenWord .equals(String.valueOf(stars)))
        {
            System.out.println("Felicitari! Ai castigat.");
            break;
        }
        }


    }
}