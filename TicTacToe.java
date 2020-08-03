import java.lang.reflect.Array;
import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> playersPosition =new ArrayList<Integer>();
    static ArrayList<Integer> cpuPosition =new ArrayList<Integer>();
    public static void main(String[] args){
        char [][] gameBoard= {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printGameBoard(gameBoard);
    while (true){
        int pd1=0;
        Scanner scan =new Scanner(System.in);
        System.out.println("Enter your placements 1 through 9:");
        int position = scan.nextInt();
//        if(!playersPosition.contains(position)||!cpuPosition.contains(position))
//            pd1++;
        while (playersPosition.contains(position)||cpuPosition.contains(position)){
//            if(pd1==9)
//                break;
            System.out.println("Position taken! Enter a correct position!");
            position=scan.nextInt();

        }
        System.out.println(position);
        placePiece(gameBoard,position,"player");
        String result=checkWinner();
        if(result.length()>0){
            System.out.println(result);
            break;
        }
        Random rand = new Random();
        int cpuPos = rand.nextInt(9) + 1;

//        if(!playersPosition.contains(cpuPos)||!cpuPosition.contains(cpuPos))
//            pd1++;
        while (playersPosition.contains(cpuPos)||cpuPosition.contains(cpuPos)){
//            if(pd1==9)
//                break;
             cpuPos = rand.nextInt(9) + 1;

        }

        placePiece(gameBoard,cpuPos,"cpu");

    printGameBoard(gameBoard);
    result=checkWinner();
        if(result.length()>0){
            System.out.println(result);
            break;
        }
//    System.out.println(result);
    }
    }
    public static void printGameBoard(char [] [] gameBoard){
        for(char [] row:gameBoard){
            for(char c:row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void placePiece(char[] []gameBoard,int position,String user){
        char symbol='X';

        if(user.equals("player"))
        {
//            symbol='X';
            playersPosition.add(position);
        }
        if(user.equals("cpu")){
            symbol='0';
            cpuPosition.add(position);
        }
        switch (position){
            case 1:
                gameBoard[0][0]=symbol;
                break;
            case 2:
                gameBoard[0][2]=symbol;
                break;
            case 3:
                gameBoard[0][4]=symbol;
                break;
            case 4:
                gameBoard[2][0]=symbol;
                break;
            case 5:
                gameBoard[2][2]=symbol;
                break;
            case 6:
                gameBoard[2][4]=symbol;
                break;
            case 7:
                gameBoard[4][0]=symbol;
                break;
            case 8:
                gameBoard[4][2]=symbol;
                break;
            case 9:
                gameBoard[4][4]=symbol;
                break;
            default:
                 break;
        }
    }
    public static String checkWinner(){
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol=Arrays.asList(1,4,7);
        List midCol=Arrays.asList(2,5,8);
        List rightCol=Arrays.asList(3,6,9);
        List zcross= Arrays.asList(1,5,9);
        List ncross=Arrays.asList(7,5,3);
        List<List>winning=new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(zcross);
        winning.add(ncross);
        for(List l:winning){
            if(playersPosition.containsAll(l)){
                return "Congratulation you won!";
            }   else if(cpuPosition.containsAll(l)){
                return "Cpu wins! Sorry:(";
            }   else if(playersPosition.size()+cpuPosition.size()==9){
                return "CAT!";
            }

        }
        return "";
    }

}
