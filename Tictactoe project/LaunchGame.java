import java.util.*;
class TicTacToe{
    static char[][] board;
    public TicTacToe()
    {
        board =new char[3][3];
        initBoard();
    }
    static void initBoard()
    {
          for(int i=0;i<board.length;i++)
          {
             for(int j=0;j<board[i].length;j++)
             {
                board[i][j]=' ';
             }
          }
    }
    static void displayBoard()
    {    System.out.println("-------------");
        for(int i=0;i<board.length;i++)
          {  
            System.out.print("| ");
             for(int j=0;j<board[i].length;j++)
             {
                System.out.print(board[i][j]+ " | ");
             }
             System.out.println();
             System.out.println("-------------");
          }
    }
    static void placeMark(int row, int col, char mark)
    {   
        if(row>=0 && row<=2 && col>=0 && col<=2)
        {
            board[row][col] =mark;
        }
        else{
            System.out.println("Invalid rows or colums");
        }
    }
    static boolean checkWin()
    {
        for(int j=0;j<=2;j++)
        {
            if(board[0][j]!=' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j])
            {
              return true;
            }
        }
        for(int i=0;i<=2;i++){
            if(board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2]){
                return true;
            }
        }
        if((board[0][0]!=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2]) || (board[0][2]!=' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0])){
             return true;
        }
       return false;
    }
}
class HumanPlayer{
    String name;
    char mark;
    HumanPlayer(String name, char mark){
        this.name=name;
        this.mark=mark;

    }
    void makeMove()
    {  Scanner sc=new Scanner(System.in);
    int row,col;
    do{
        System.out.println("Enter row and column");
         row=sc.nextInt();
        col=sc.nextInt();}while(!isValidMove(row,col));
        
            TicTacToe.placeMark(row,col,mark);
            
        }
       

    
    boolean isValidMove(int row, int col){
        if(TicTacToe.board[row][col]==' ' && row>=0 && row<=2 && col>=0 && col<=2){
            return true;
        }
        return false;

    }
}



public class LaunchGame{
    public static void main(String[] args){
        TicTacToe t =new TicTacToe();
        HumanPlayer p1 =new HumanPlayer("Bob",'X');
        HumanPlayer p2 =new HumanPlayer("Priya",'O');

        HumanPlayer cp;
        cp=p1;
        while(true) { 
            System.out.println(cp.name+" turn");
        cp.makeMove();
        TicTacToe.displayBoard();
        if (TicTacToe.checkWin()){
            System.out.println(cp.name+" has won");
            break;
        }
        else{
            if(cp==p1){
                cp=p2;
            }
            else{
                cp=p1;
            }
        }
        }
    }
}