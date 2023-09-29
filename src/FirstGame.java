import java.util.Scanner;

public class FirstGame {
    public static void main(String[] args) {
        //Bu bizim usaqliqda oynadigimiz Kagiz-Qayci-Dash oyunun Java Versionudur
//        This is the Java version of the Paper-Scissors-Rock game we used to play in our childhood
        int computerChoice;
        int playerChoice;
        String[] Choice = new String[]{"", "Rock", "Paper", "Scissors"};
//      Computerin secimlerinin hansilar oldugunu qeyd etdik 1-->Rock=Dash  2-->Paper=Kagiz   3-->Scissors=Qayci
//      We noted which computer's choices are 1-->Rock 2-->Paper 3-->Scissors
        int numberOfComputerWin = 0;
        int numberOfPlayerWin = 0;
        String red = "\033[0;31m";
        String resetColor = "\033[0m";
//    I will keep it in do while to keep the game spinning continuously.
//    Oyunun daima dovr etmesi ucun Do while icerisinde edecik
        do {
//      computerin secimi 1-3 arasinda secim edecek deye Math.random() reqemler versin bunu bilirik ki random
//      burda 0 ile 1 arasinda reqem derc edecek men bunu 1-3 arasinda etmesi ucun *3+1 deyirem
//      Let Math.random() give numbers so that the computer will choose
//      between 1-3. We know that random will type a number between 0 and 1
//      I say *3+1 to make it between 1-3.
            computerChoice = (int) (Math.random() * 3 + 1);
            System.out.print("Enter Your Choice = ");
            playerChoice = integerRead(0, 3);
//       Burda secimi cap edirdik bu secimi asagida Choice[]-ne index edirik.Yeni secim 2 deye
//       yox Choice[]-nin 2-ci elementi kimi gosterecek String bir ifade yazmis olacaq
//       Here we are making the selection and we are indexing this selection to Choice [] below
//       The new choice will show as the 2nd element of Choice[ ] instead of 2 String will have typed an expression
            System.out.print("ComputerChoice = " + red + Choice[computerChoice] + resetColor);
            System.out.println("  PlayerChoice = " + red + Choice[playerChoice] + resetColor);
//      Secimleri etdik indi kimin qalib geldiyini bilmeliyik
//      We held the elections, we need to know who won
            if (playerChoice != 0) {
                if (computerChoice == playerChoice) {
                    System.out.println("Draw");
                } else if ((computerChoice == 1 && playerChoice == 3) || (computerChoice == 2 && playerChoice == 1)
                        || (computerChoice == 3 && playerChoice == 2)) {
                    numberOfComputerWin++;
                    System.out.print(red + "Computer Win   " + resetColor);
                    System.out.println("Score ====>    Computer = " + red + numberOfComputerWin + resetColor + " - Player = " + red + numberOfPlayerWin + resetColor);
                } else {
                    numberOfPlayerWin++;
                    System.out.print(red + "Player Win   " + resetColor);
                    System.out.println("Score ===>     Computer = " + red + numberOfComputerWin + resetColor + " - Player = " + red + numberOfPlayerWin + resetColor);

                }
            }

        } while (playerChoice != 0);

//    The player will choose between 1 and 3. If he chooses 0 he will leave the game.
//        Oyuncu 1-3 arasnda secim edecek bilirik eger 0 secse oyundan cixsin

        if (numberOfComputerWin == numberOfPlayerWin) System.out.print("Draw");
        else if (numberOfComputerWin > numberOfPlayerWin) System.out.print("Computer Win");
        else System.out.println("Player Win");
        System.out.print("Last Score ===>     Computer = " +red+numberOfComputerWin + " - Player = " +numberOfPlayerWin+resetColor);
    }

    private static int integerRead(int min, int max) {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        boolean readingOk = false;
        do {
            try {
                number = Integer.parseInt(sc.nextLine());
                readingOk = true;

            } catch (NumberFormatException e) {

            }
            if( number< min || number >max || !readingOk){
                System.out.print("InCorrect-. Pleace Re-enter("+min+" - "+max+ ") : ");
            }
        } while (!readingOk || number < min || number > max);
        return number;
//        0 la 3 arasindaki reqemleri qebul eden bir metod yazdiq burda integerRead adinda bu metodun misyasi
//        Integer oxumaqdir eks halda basqa deyer girildiyinde bunu duzeltmekdir 2 deyiskeni var min ve max
//        Scanneri burda elan edirik cunki oxumaq isini burda edecik ve dogru olub olmadigini yoxlamaq ucun
//        boolean readingOk deyirik baslangicda false veririk heleki basdan hecne oxumayib cunki.
//        int number =0; deyirik bu oxumaq deyerimizdir ve bir do while icinde edecik xeta olsa tekrar oxusun.
//        readingOk false oldugu mudetde ve-ya number < min ve ya number > max-dan qebul etme bunu while davam etsin.
//        yeni min-dan kicik olmasin max-dan boyuk olmasin yeni 0,1,2,3 qebul etsin basqa hecne qebul etmesin.
//        ve return olaraqda number gonderdik.
//        try { numberi oxuyacaq Integer.parseInt(sc.nextLine()); onu Integere cevirecik
//        eger oxuma dogrudursa davam edecek proqramin kodu yeni readingOk = true; oxumaq basarili olub yeni (a,b)
//        herfine basilmamisdir.Eks halda basarisizsa catch ile tutaciq onu (NumberFormatException e)
//        catch dan sonra if ( number < min-dan ve-ya number > max-dan ve-ya readingOk deyilse gel deki
//        InCorrect yeniden girin.sonra +min+" - "+max evezine (0,3)- de deye bilerik
//        if-den sonraki mesaji catch-den sorada vere bilerdik ama men 0 ve 3 den ferqli reqem girersede xeta olar deye
//        sonda oranida yoxlasin mesaji versin deye orda yazdim

        
//        We have written a method that accepts numbers between 0 and 3, here is the mission of this method called integerRead
    //    Integer should be read, otherwise, if another value is entered, it should be corrected. There are 2 variables, min and max// We declare the scanner here because we will do the reading here and check if it is correct
//        boolean reading We say ok, we give false at the beginning, because no one has read it yet.
//        int number = 0; we say this is what we mean to read, and if there is a mistake in a do while, read it again.
//        Don't accept from number < min or number > max as long as readingOk is false let it continue while.
//        accept new 0,1,2,3, not less than min, not greater than max, accept nothing else.
//        and we sent a number as return.
//        will read the number try { Integer.parseInt(sc.nextLine()); we will convert it to Integer
//        program code to continue if reading is correct new readingOk = true; successfully read new (a,b)
//        letter failed. Otherwise, if it fails, we will catch it with catch (NumberFormatException e)
//        after catch if ( number < min or number > max or reading If not ok then come
//        Enter InCorrect again. Then we can say +min+" - "+max instead of (0,3)
//        we could send the message after if by asking catch, but if I enter a number other than 0 or 3, an error will occur
//        at the end, I wrote there to give the message to check the ratio
    }

}
