package DSA;



//import the all GUI file add 



import javax.swing.*; // this * means all file are include here 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class TicTacToeGUI extends JFrame { // here extends in inheritance to GUI jFrame

	
	// create String type array . and this arrays name is board
	
 private static String[] board;
 private static String turn; // this is a string type variable . variable name is turn.

 private JButton[] buttons;  // JButton for GUI button also for declared arrays.

 // now create method for GUI
 
 public TicTacToeGUI() {
     board = new String[9]; // create and initial the arrays.
     turn = "X";  // also this String type of variable turn initial the value --> X

     buttons = new JButton[9]; // also this arrays initial

     
     // now called the method
     
     
     initializeBoard();
     initializeGUI();
     
 }
 
 
 // here a create method how many element are print in the board.
 
 private void initializeBoard() {
     for (int a = 0; a < 9; a++) {
         board[a] = String.valueOf(a + 1); // here the print 1,2,3,4--->9
     }
 }
 
 

 // here the create method for initial the GUI board such as >>> Set Title
 
 private void initializeGUI() {
     setTitle("Tic Tac Toe"); // set title 
     setSize(300, 300); // set size
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cannot close option off when you wanted to close this option than close 
     setLayout(new GridLayout(3, 3)); // this is row and column gridLayout (3,3)

     
     // for set the board visible 
     
     for (int i = 0; i < 9; i++) {
         buttons[i] = new JButton(board[i]); // set the button initial 
         buttons[i].setFont(new Font("Arial", Font.PLAIN, 24)); // to set the front any text style 
         buttons[i].addActionListener(new ButtonClickListener());
         add(buttons[i]);
     }
     
 }
 
 // to set the on button click listener 
 

 private class ButtonClickListener implements ActionListener {
     public void actionPerformed(ActionEvent e) {
         JButton clickedButton = (JButton) e.getSource();

         // convert the type casting 
         
         int numInput = Integer.parseInt(clickedButton.getText());

         if (board[numInput - 1].equals(String.valueOf(numInput))) {
             board[numInput - 1] = turn;
             clickedButton.setText(turn);

             if (turn.equals("X")) {  // when started first turn "X" then second turn "O"
                 turn = "O";
             } else {
                 turn = "X";
             }

             // called the checkWinner method
             
             String winner = checkWinner();
             if (winner != null) {
                 displayResult(winner); // if slot is not equal to null than print x/o winner
             }
         } else {
             JOptionPane.showMessageDialog(null, "Slot already taken; choose another slot.");
         }
     }
 }

 // create a method for check winner 
 // main part/question part
 private String checkWinner() {
		for (int a = 0; a < 8; a++) {
			String line = null;

			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			//For X winner
			if (line.equals("XXX")) {
				return "X";
			}
			
			// For O winner
			else if (line.equals("OOO")) {
				return "O";
			}
		}
		
		// using loop for draw display message
		
		
		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(
					String.valueOf(a + 1))) {
				break;
			}
			else if (a == 8) {
				return "draw";
			}
		}
	

	// To enter the X Or O at the exact place on board.
		System.out.println(
			turn + "'s turn; enter a slot number to place "
			+ turn + " in:");
		return null;
	}
 
 // create method for display win or loss
 
 
 private void displayResult(String winner) {
     if (winner.equalsIgnoreCase("draw")) {
         JOptionPane.showMessageDialog(null, "It's a draw! Thanks for playing.");
     } else {
         JOptionPane.showMessageDialog(null, "Congratulations! " + winner + "'s have won! Thanks for playing.");
     }
     System.exit(0);
 }

 public static void main(String[] args) {
 	
 	// create class to TicTacToeGUI 
 	
     SwingUtilities.invokeLater(() -> {
         TicTacToeGUI ticTacToeGUI = new TicTacToeGUI();
          
         // to set the visible 
         
         ticTacToeGUI.setVisible(true);
     });
 }
}


