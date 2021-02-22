

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;


import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class UltimateTTT extends JFrame{
	private JPanel commands, playArea, stats, p1, p2, p3, p4, p5, p6, p7, p8, p9;
	private JLabel nowPlaying, manageGame, winPercent, totalNumGames, avgMovesPerWin;
	private JButton player1, player2, restart, undo, playingStats; // need to add 81 playable buttons
	private JButton b11, b12, b13, b14, b15, b16, b17, b18, b19, b21, b22, b23, b24, b25, b26, b27, b28, b29, b31, b32, b33, b34, b35, b36, b37, b38, b39, b41, b42, b43, b44, b45, b46, b47, b48, b49, b51, b52, b53, b54, b55, b56, b57, b58, b59, b61, b62, b63, b64, b65, b66, b67, b68, b69, b71, b72, b73, b74, b75, b76, b77, b78, b79, b81, b82, b83, b84, b85, b86, b87, b88, b89, b91, b92, b93, b94, b95, b96, b97, b98, b99;
	private JTextField winPercentField, totalNumGamesField, avgMovesPerWinField;
	private String currentPlayer = "1";
	private int lastButton = 0;
	private int lastPanel = 0;
	private ArrayList<String> totalPanelsList = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
	private ArrayList<JButton> buttonList = new ArrayList<JButton>();
	private String[][] allButtons = { {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"} };
	private int gameCount = 0;
	private int player1Wins = 0;
	private int player2Wins = 0;
	private int player1MoveCount = 0;
	private int player2MoveCount = 0;
	private ArrayList<Integer> player1Moves = new ArrayList<Integer>();
	private ArrayList<Integer> player2Moves = new ArrayList<Integer>();
	private JButton[] lastMove = new JButton[1];

	
	
	public UltimateTTT() {
		// Set up
		super("Ultimate TicTacToe");
		setSize(new Dimension(1200, 800));
//		setLayout(new GridLayout(3, 3));
		
		this.createGUI();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void createGUI() {
		// Command panel
		this.commands = new JPanel();
		this.nowPlaying = new JLabel("Now Playing:");
		this.player1 = new JButton("Player O");
		player1.setBackground(Color.BLUE);
		this.player2 = new JButton("Player X");
		this.manageGame = new JLabel("Manage Game");
		this.restart = new JButton("Restart");
		restart.addActionListener(new PanelListener());
		this.undo = new JButton("Undo");
		undo.addActionListener(new PanelListener());
		// Add to Command panel
		this.commands.add(this.nowPlaying);
		this.commands.add(this.player1);
		this.commands.add(this.player2);
		this.commands.add(this.manageGame);
		this.commands.add(this.restart);
		this.commands.add(this.undo);
		// Add command panel to Frame
		add(this.commands, BorderLayout.NORTH);
		
		
		// Play Area panel
		// Create one large panel to put in the middle
		this.playArea = new JPanel();
		this.playArea.setLayout(new GridLayout(3, 3, 5, 5));
		this.playArea.setBackground(Color.MAGENTA);
		// Add panels to Play Area
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p8 = new JPanel();
		p9 = new JPanel();
		
		
		//Panel 1
		p1.setLayout(new GridLayout(3, 3));
		b11 = new JButton("1");
		b11.addActionListener(new PanelListener());
		p1.add(b11);
		b12 = new JButton("2");
		b12.addActionListener(new PanelListener());
		p1.add(b12);
		b13 = new JButton("3");
		b13.addActionListener(new PanelListener());
		p1.add(b13);
		b14 = new JButton("4");
		b14.addActionListener(new PanelListener());
		p1.add(b14);
		b15 = new JButton("5");
		b15.addActionListener(new PanelListener());
		p1.add(b15);
		b16 = new JButton("6");
		b16.addActionListener(new PanelListener());
		p1.add(b16);
		b17 = new JButton("7");
		b17.addActionListener(new PanelListener());
		p1.add(b17);
		b18 = new JButton("8");
		b18.addActionListener(new PanelListener());
		p1.add(b18);
		b19 = new JButton("9");
		b19.addActionListener(new PanelListener());
		p1.add(b19);
			
		//Panel 2
		p2.setLayout(new GridLayout(3, 3));
		b21 = new JButton("1");
		b21.addActionListener(new PanelListener());
		p2.add(b21);
		b22 = new JButton("2");
		b22.addActionListener(new PanelListener());
		p2.add(b22);
		b23 = new JButton("3");
		b23.addActionListener(new PanelListener());
		p2.add(b23);
		b24 = new JButton("4");
		b24.addActionListener(new PanelListener());
		p2.add(b24);
		b25 = new JButton("5");
		b25.addActionListener(new PanelListener());
		p2.add(b25);
		b26 = new JButton("6");
		b26.addActionListener(new PanelListener());
		p2.add(b26);
		b27 = new JButton("7");
		b27.addActionListener(new PanelListener());
		p2.add(b27);
		b28 = new JButton("8");
		b28.addActionListener(new PanelListener());
		p2.add(b28);
		b29 = new JButton("9");
		b29.addActionListener(new PanelListener());
		p2.add(b29);
		
		p3.setLayout(new GridLayout(3, 3));
		b31 = new JButton("1");
		b31.addActionListener(new PanelListener());
		p3.add(b31);
		b32 = new JButton("2");
		b32.addActionListener(new PanelListener());
		p3.add(b32);
		b33 = new JButton("3");
		b33.addActionListener(new PanelListener());
		p3.add(b33);
		b34 = new JButton("4");
		b34.addActionListener(new PanelListener());
		p3.add(b34);
		b35 = new JButton("5");
		b35.addActionListener(new PanelListener());
		p3.add(b35);
		b36 = new JButton("6");
		b36.addActionListener(new PanelListener());
		p3.add(b36);
		b37 = new JButton("7");
		b37.addActionListener(new PanelListener());
		p3.add(b37);
		b38 = new JButton("8");
		b38.addActionListener(new PanelListener());
		p3.add(b38);
		b39 = new JButton("9");
		b39.addActionListener(new PanelListener());
		p3.add(b39);
		
		p4.setLayout(new GridLayout(3, 3));
		b41 = new JButton("1");
		b41.addActionListener(new PanelListener());
		p4.add(b41);
		b42 = new JButton("2");
		b42.addActionListener(new PanelListener());
		p4.add(b42);
		b43 = new JButton("3");
		b43.addActionListener(new PanelListener());
		p4.add(b43);
		b44 = new JButton("4");
		b44.addActionListener(new PanelListener());
		p4.add(b44);
		b45 = new JButton("5");
		b45.addActionListener(new PanelListener());
		p4.add(b45);
		b46 = new JButton("6");
		b46.addActionListener(new PanelListener());
		p4.add(b46);
		b47 = new JButton("7");
		b47.addActionListener(new PanelListener());
		p4.add(b47);
		b48 = new JButton("8");
		b48.addActionListener(new PanelListener());
		p4.add(b48);
		b49 = new JButton("9");
		b49.addActionListener(new PanelListener());
		p4.add(b49);
		
		p5.setLayout(new GridLayout(3, 3));
		b51 = new JButton("1");
		b51.addActionListener(new PanelListener());
		p5.add(b51);
		b52 = new JButton("2");
		b52.addActionListener(new PanelListener());
		p5.add(b52);
		b53 = new JButton("3");
		b53.addActionListener(new PanelListener());
		p5.add(b53);
		b54 = new JButton("4");
		b54.addActionListener(new PanelListener());
		p5.add(b54);
		b55 = new JButton("5");
		b55.addActionListener(new PanelListener());
		p5.add(b55);
		b56 = new JButton("6");
		b56.addActionListener(new PanelListener());
		p5.add(b56);
		b57 = new JButton("7");
		b57.addActionListener(new PanelListener());
		p5.add(b57);
		b58 = new JButton("8");
		b58.addActionListener(new PanelListener());
		p5.add(b58);
		b59 = new JButton("9");
		b59.addActionListener(new PanelListener());
		p5.add(b59);
		
		p6.setLayout(new GridLayout(3, 3));
		b61 = new JButton("1");
		b61.addActionListener(new PanelListener());
		p6.add(b61);
		b62 = new JButton("2");
		b62.addActionListener(new PanelListener());
		p6.add(b62);
		b63 = new JButton("3");
		b63.addActionListener(new PanelListener());
		p6.add(b63);
		b64 = new JButton("4");
		b64.addActionListener(new PanelListener());
		p6.add(b64);
		b65 = new JButton("5");
		b65.addActionListener(new PanelListener());
		p6.add(b65);
		b66 = new JButton("6");
		b66.addActionListener(new PanelListener());
		p6.add(b66);
		b67 = new JButton("7");
		b67.addActionListener(new PanelListener());
		p6.add(b67);
		b68 = new JButton("8");
		b68.addActionListener(new PanelListener());
		p6.add(b68);
		b69 = new JButton("9");
		b69.addActionListener(new PanelListener());
		p6.add(b69);
		
		p7.setLayout(new GridLayout(3, 3));
		b71 = new JButton("1");
		b71.addActionListener(new PanelListener());
		p7.add(b71);
		b72 = new JButton("2");
		b72.addActionListener(new PanelListener());
		p7.add(b72);
		b73 = new JButton("3");
		b73.addActionListener(new PanelListener());
		p7.add(b73);
		b74 = new JButton("4");
		b74.addActionListener(new PanelListener());
		p7.add(b74);
		b75 = new JButton("5");
		b75.addActionListener(new PanelListener());
		p7.add(b75);
		b76 = new JButton("6");
		b76.addActionListener(new PanelListener());
		p7.add(b76);
		b77 = new JButton("7");
		b77.addActionListener(new PanelListener());
		p7.add(b77);
		b78 = new JButton("8");
		b78.addActionListener(new PanelListener());
		p7.add(b78);
		b79 = new JButton("9");
		b79.addActionListener(new PanelListener());
		p7.add(b79);
		
		p8.setLayout(new GridLayout(3, 3));
		b81 = new JButton("1");
		b81.addActionListener(new PanelListener());
		p8.add(b81);
		b82 = new JButton("2");
		b82.addActionListener(new PanelListener());
		p8.add(b82);
		b83 = new JButton("3");
		b83.addActionListener(new PanelListener());
		p8.add(b83);
		b84 = new JButton("4");
		b84.addActionListener(new PanelListener());
		p8.add(b84);
		b85 = new JButton("5");
		b85.addActionListener(new PanelListener());
		p8.add(b85);
		b86 = new JButton("6");
		b86.addActionListener(new PanelListener());
		p8.add(b86);
		b87 = new JButton("7");
		b87.addActionListener(new PanelListener());
		p8.add(b87);
		b88 = new JButton("8");
		b88.addActionListener(new PanelListener());
		p8.add(b88);
		b89 = new JButton("9");
		b89.addActionListener(new PanelListener());
		p8.add(b89);
		
		p9.setLayout(new GridLayout(3, 3));
		b91 = new JButton("1");
		b91.addActionListener(new PanelListener());
		p9.add(b91);
		b92 = new JButton("2");
		b92.addActionListener(new PanelListener());
		p9.add(b92);
		b93 = new JButton("3");
		b93.addActionListener(new PanelListener());
		p9.add(b93);
		b94 = new JButton("4");
		b94.addActionListener(new PanelListener());
		p9.add(b94);
		b95 = new JButton("5");
		b95.addActionListener(new PanelListener());
		p9.add(b95);
		b96 = new JButton("6");
		b96.addActionListener(new PanelListener());
		p9.add(b96);
		b97 = new JButton("7");
		b97.addActionListener(new PanelListener());
		p9.add(b97);
		b98 = new JButton("8");
		b98.addActionListener(new PanelListener());
		p9.add(b98);
		b99 = new JButton("9");
		b99.addActionListener(new PanelListener());
		p9.add(b99);
		
		this.playArea.add(p1);
		this.playArea.add(p2);
		this.playArea.add(p3);
		this.playArea.add(p4);
		this.playArea.add(p5);
		this.playArea.add(p6);
		this.playArea.add(p7);
		this.playArea.add(p8);
		this.playArea.add(p9);
		
		// Add Play Area panel to Frame
		add(this.playArea, BorderLayout.CENTER);
		
		
		
		// Stats panel
		this.stats = new JPanel();
		this.playingStats = new JButton("Playing Stats");
		playingStats.addActionListener(new PanelListener());
		this.winPercent = new JLabel("Win %:");
		this.winPercentField = new JTextField(10);
		this.totalNumGames = new JLabel("Total # of games:");
		this.totalNumGamesField = new JTextField(10);
		this.avgMovesPerWin = new JLabel("Average # of moves per win:");
		this.avgMovesPerWinField = new JTextField(10);
		// Add to Stats panel
		this.stats.add(this.playingStats);
		this.stats.add(this.winPercent);
		this.stats.add(this.winPercentField);
		this.stats.add(this.totalNumGames);
		this.stats.add(this.totalNumGamesField);
		this.stats.add(this.avgMovesPerWin);
		this.stats.add(this.avgMovesPerWinField);
		// Add Stats panel to Frame
		add(this.stats, BorderLayout.SOUTH);
		
	}
	
	class PanelListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource();
			String text = button.getText();
			String value = button.getActionCommand();
			if(text.contentEquals("Undo")) {
				if(lastMove[0] != null) {
					allButtons[lastPanel - 1][lastButton - 1] = "-";
					JButton undo = lastMove[0];
					undo.setBackground(null);
					buttonList.remove(undo);
					changePlayer();
					if(currentPlayer == "1") {
						player1MoveCount--;
					}
					else {
						player2MoveCount--;
					}
					lastMove[0] = null;
					JButton lastButtonChange = buttonList.get(buttonList.size() - 1);
					lastButton = Integer.parseInt(lastButtonChange.getText());
					lastPanel = 0;
				}
				else {
					JOptionPane.showMessageDialog(null, "Cannot undo");
				}
			}
			else if(text.contentEquals("Playing Stats")) {
				if(gameCount ==0) {
					JOptionPane.showMessageDialog(null, "There are not any stats yet.\nPlay more games first.");
				}
				else if(currentPlayer == "1" && player1Wins == 0) {
					JOptionPane.showMessageDialog(null, "This player has not won a game.\nThere are no stats yet.");
				}
				else if(currentPlayer == "2" && player2Wins == 0) {
					JOptionPane.showMessageDialog(null, "This player has not won a game.\nThere are no stats yet.");
				}
				else {
					if(currentPlayer == "1") {
						double winrate = (player1Wins/gameCount)*100;
						int moves = 0;
						double averageMoves = 0;
						for(int i = 0; i < player1Moves.size(); i++) {
							moves = player1Moves.get(i) + moves;
						}
						averageMoves = moves/player1Wins;
						winPercentField.setText("" + winrate);
						totalNumGamesField.setText("" + gameCount);
						avgMovesPerWinField.setText("" + averageMoves);
					}
					else {
						double winrate = (player2Wins/gameCount)*100;
						int moves = 0;
						double averageMoves = 0;
						for(int i = 0; i < player2Moves.size(); i++) {
							moves = player2Moves.get(i) + moves;
						}
						averageMoves = moves/player2Wins;
						winPercentField.setText("" + winrate);
						totalNumGamesField.setText("" + gameCount);
						avgMovesPerWinField.setText("" + averageMoves);
					}
				}
			}
			else if(text.contentEquals("Restart")){
				clearBoard();
			}
			else if(button.getParent() == p1) {
				if(lastButton == 0 || lastButton == 1) {
					if(totalPanelsList.contains("1") == false) {
						JOptionPane.showMessageDialog(null, "This panel has been won or is a draw. Select another one.");
					}
					else {
						if(checkIfAllowed(button) == true) {
							lastPanel = 1;
							changePanel(value);
							colorButton(button);
							checkForPanelWin();
							if(checkForGameWin() == false) {
								changePlayer();
							}
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Click a button in panel " + lastButton);
				}
			}
			else if(button.getParent() == p2) {
				if(lastButton == 0 || lastButton == 2) {
					if(totalPanelsList.contains("2") == false) {
						JOptionPane.showMessageDialog(null, "This panel has been won or is a draw. Select another one.");
					}
					else {
						if(checkIfAllowed(button) == true) {
							lastPanel = 2;
							changePanel(value);
							colorButton(button);
							checkForPanelWin();
							if(checkForGameWin() == false) {
								changePlayer();
							}
						}
					}	
				}
				else {
					JOptionPane.showMessageDialog(null, "Click a button in panel " + lastButton);
				}
			}
			else if(button.getParent() == p3) {
				if(lastButton == 0 || lastButton == 3) {
					if(totalPanelsList.contains("3") == false) {
						JOptionPane.showMessageDialog(null, "This panel has been won or is a draw. Select another one.");
					}
					else {
						if(checkIfAllowed(button) == true) {
							lastPanel = 3;;
							changePanel(value);
							colorButton(button);
							checkForPanelWin();
							if(checkForGameWin() == false) {
								changePlayer();
							}
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Click a button in panel " + lastButton);
				}
			}
			else if(button.getParent() == p4) {
				if(lastButton == 0 || lastButton == 4) {
					if(totalPanelsList.contains("4") == false) {
						JOptionPane.showMessageDialog(null, "This panel has been won or is a draw. Select another one.");
					}
					else {
						if(checkIfAllowed(button) == true) {
							lastPanel = 4;
							changePanel(value);
							colorButton(button);
							checkForPanelWin();
							if(checkForGameWin() == false) {
								changePlayer();
							}
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Click a button in panel " + lastButton);
				}
			}
			else if(button.getParent() == p5) {
				if(lastButton == 0 || lastButton == 5) {
					if(totalPanelsList.contains("5") == false) {
						JOptionPane.showMessageDialog(null, "This panel has been won or is a draw. Select another one.");
					}
					else {
						if(checkIfAllowed(button) == true) {
							lastPanel = 5;
							changePanel(value);
							colorButton(button);
							checkForPanelWin();
							if(checkForGameWin() == false) {
								changePlayer();
							}
						}
					}	
				}
				else {
					JOptionPane.showMessageDialog(null, "Click a button in panel " + lastButton);
				}
			}
			else if(button.getParent() == p6) {
				if(lastButton == 0 || lastButton == 6) {
					if(totalPanelsList.contains("6") == false) {
						JOptionPane.showMessageDialog(null, "This panel has been won or is a draw. Select another one.");
					}
					else {
						if(checkIfAllowed(button) == true) {
							lastPanel = 6;
							changePanel(value);
							colorButton(button);
							checkForPanelWin();
							if(checkForGameWin() == false) {
								changePlayer();
							}
						}
					}	
				}
				else {
					JOptionPane.showMessageDialog(null, "Click a button in panel " + lastButton);
				}
			}
			else if(button.getParent() == p7) {
				if(lastButton == 0 || lastButton == 7) {
					if(totalPanelsList.contains("7") == false) {
						JOptionPane.showMessageDialog(null, "This panel has been won or is a draw. Select another one.");
					}
					else {
						if(checkIfAllowed(button) == true) {
							lastPanel = 7;;
							changePanel(value);
							colorButton(button);
							checkForPanelWin();
							if(checkForGameWin() == false) {
								changePlayer();
							}
						}
					}	
				}
				else {
					JOptionPane.showMessageDialog(null, "Click a button in panel " + lastButton);
				}
			}
			else if(button.getParent() == p8) {
				if(lastButton == 0 || lastButton == 8) {
					if(totalPanelsList.contains("8") == false) {
						JOptionPane.showMessageDialog(null, "This panel has been won or is a draw. Select another one.");
					}
					else {
						if(checkIfAllowed(button) == true) {
							lastPanel = 8;
							changePanel(value);
							colorButton(button);
							checkForPanelWin();
							if(checkForGameWin() == false) {
								changePlayer();
							}
						}
					}	
				}
				else {
					JOptionPane.showMessageDialog(null, "Click a button in panel " + lastButton);
				}
			}
			else if(button.getParent() == p9) {
				if(lastButton == 0 || lastButton == 9) {
					if(totalPanelsList.contains("9") == false) {
						JOptionPane.showMessageDialog(null, "This panel has been won or is a draw. Select another one.");
					}
					else {
						if(checkIfAllowed(button) == true) {
							lastPanel = 9;
							changePanel(value);
							colorButton(button);
							checkForPanelWin();
							if(checkForGameWin() == false) {
								changePlayer();
							}
						}
					}	
				}
				else {
					JOptionPane.showMessageDialog(null, "Click a button in panel " + lastButton);
				}
			}
			
			

		}
	}
	
	public boolean checkIfAllowed(JButton button) {
		if(buttonList.contains(button) == false) {
			buttonList.add(button);
			lastMove[0] = button;
			return true;
				
			}
		else {
			return false;
		}
	}
	
	public void colorButton(JButton button) {
		if(currentPlayer == "1") {
			button.setBackground(Color.BLUE);
		}
		else {
			button.setBackground(Color.RED);
		}
	}
	
	public void changePlayer() {
		if(currentPlayer == "1") {
			this.currentPlayer = "2";
			player2.setBackground(Color.RED);
			player1.setBackground(null);
		}
		else {
			this.currentPlayer = "1";
			player1.setBackground(Color.BLUE);
			player2.setBackground(null);
		}
	}
	
	public void changePanel(String value) {
		this.lastButton = Integer.parseInt(value);
		updateAllButtonsList();
		if(totalPanelsList.get(Integer.parseInt(value) - 1) == "-") {
			lastButton = 0;
		}
		if(currentPlayer == "1") {
			player1MoveCount++;
		}
		else {
			player2MoveCount++;
		}
	}
	
	public void updateAllButtonsList() {
		if(allButtons[lastPanel - 1][lastButton - 1] == "-") {
			allButtons[lastPanel - 1][lastButton - 1] = currentPlayer;
		}
	}
	
	public void checkForPanelWin() {
		if(allButtons[lastPanel - 1][0] == currentPlayer && allButtons[lastPanel - 1][1] == currentPlayer && allButtons[lastPanel - 1][2] == currentPlayer) {
			allButtons[lastPanel - 1][9] = currentPlayer;
			totalPanelsList.set(lastPanel - 1, "-");
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won panel " + lastPanel);
		}
		else if(allButtons[lastPanel - 1][3] == currentPlayer && allButtons[lastPanel - 1][4] == currentPlayer && allButtons[lastPanel - 1][5] == currentPlayer) {
			allButtons[lastPanel - 1][9] = currentPlayer;
			totalPanelsList.set(lastPanel - 1, "-");
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won panel " + lastPanel);
		}
		else if(allButtons[lastPanel - 1][6] == currentPlayer && allButtons[lastPanel - 1][7] == currentPlayer && allButtons[lastPanel - 1][8] == currentPlayer) {
			allButtons[lastPanel - 1][9] = currentPlayer;
			totalPanelsList.set(lastPanel - 1, "-");
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won panel " + lastPanel);
		}
		else if(allButtons[lastPanel - 1][0] == currentPlayer && allButtons[lastPanel - 1][3] == currentPlayer && allButtons[lastPanel - 1][6] == currentPlayer) {
			allButtons[lastPanel - 1][9] = currentPlayer;
			totalPanelsList.set(lastPanel - 1, "-");
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won panel " + lastPanel);
		}
		else if(allButtons[lastPanel - 1][1] == currentPlayer && allButtons[lastPanel - 1][4] == currentPlayer && allButtons[lastPanel - 1][7] == currentPlayer) {
			allButtons[lastPanel - 1][9] = currentPlayer;
			totalPanelsList.set(lastPanel - 1, "-");
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won panel " + lastPanel);
		}
		else if(allButtons[lastPanel - 1][2] == currentPlayer && allButtons[lastPanel - 1][5] == currentPlayer && allButtons[lastPanel - 1][8] == currentPlayer) {
			allButtons[lastPanel - 1][9] = currentPlayer;
			totalPanelsList.set(lastPanel - 1, "-");
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won panel " + lastPanel);
		}
		else if(allButtons[lastPanel - 1][0] == currentPlayer && allButtons[lastPanel - 1][4] == currentPlayer && allButtons[lastPanel - 1][8] == currentPlayer) {
			allButtons[lastPanel - 1][9] = currentPlayer;
			totalPanelsList.set(lastPanel - 1, "-");
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won panel " + lastPanel);
		}
		else if(allButtons[lastPanel - 1][2] == currentPlayer && allButtons[lastPanel - 1][4] == currentPlayer && allButtons[lastPanel - 1][6] == currentPlayer) {
			allButtons[lastPanel - 1][9] = currentPlayer;
			totalPanelsList.set(lastPanel - 1, "-");
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won panel " + lastPanel);
		}
		else {
			boolean isDraw = true;
			for(int i = 0; i < 9; i++) {
				if(allButtons[lastPanel - 1][i] == "-") {
					isDraw = false;
				}
			}
			if(isDraw == true) {
				allButtons[lastPanel - 1][9] = "draw";
				JOptionPane.showMessageDialog(null, "This panel is a drraw");
			}
		}
	}
	
	public boolean checkForGameWin() {
		if(allButtons[0][9] == currentPlayer && allButtons[1][9] == currentPlayer && allButtons[2][9] == currentPlayer) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won the game! \nThe game will now reset");
			updateStats();
			clearBoard();
			return true;
		}
		else if(allButtons[3][9] == currentPlayer && allButtons[4][9] == currentPlayer && allButtons[5][9] == currentPlayer) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won the game! \nThe game will now reset");
			updateStats();
			clearBoard();
			return true;
		}
		else if(allButtons[6][9] == currentPlayer && allButtons[7][9] == currentPlayer && allButtons[8][9] == currentPlayer) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won the game! \nThe game will now reset");
			updateStats();
			clearBoard();
			return true;
		}
		else if(allButtons[0][9] == currentPlayer && allButtons[3][9] == currentPlayer && allButtons[6][9] == currentPlayer) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won the game! \nThe game will now reset");
			updateStats();
			clearBoard();
			return true;
		}
		else if(allButtons[1][9] == currentPlayer && allButtons[4][9] == currentPlayer && allButtons[7][9] == currentPlayer) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won the game! \nThe game will now reset");
			updateStats();
			clearBoard();
			return true;
		}
		else if(allButtons[2][9] == currentPlayer && allButtons[5][9] == currentPlayer && allButtons[8][9] == currentPlayer) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won the game! \nThe game will now reset");
			updateStats();
			clearBoard();
			return true;
		}
		else if(allButtons[0][9] == currentPlayer && allButtons[4][9] == currentPlayer && allButtons[8][9] == currentPlayer) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won the game! \nThe game will now reset");
			updateStats();
			clearBoard();
			return true;
		}
		else if(allButtons[2][9] == currentPlayer && allButtons[4][9] == currentPlayer && allButtons[6][9] == currentPlayer) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won the game! \nThe game will now reset");
			updateStats();
			clearBoard();
			return true;
		}
		else {
			boolean isDraw = true;
			for(int i = 0; i < 9; i++) {
				if(allButtons[i][9] == "-") {
					isDraw = false;
				}
			}
			if(isDraw == true) {
				JOptionPane.showMessageDialog(null, "The game is a draw, neither player wins. \nThe game will now reset.");
				gameCount++;
				clearBoard();
				return true;
			}
		}
		return false;
	}
	
	public void updateStats() {
		if(currentPlayer == "1") {
			player1Wins++;
			player1Moves.add(player1MoveCount);
		}
		else {
			player2Wins++;
			player2Moves.add(player2MoveCount);
		}
		gameCount++;
	}
	
	public void clearBoard() {
		currentPlayer = "1";
		player1.setBackground(Color.BLUE);
		player2.setBackground(null);
		for(JButton button : buttonList) {
			button.setBackground(null);
		}
		lastButton = 0;
		lastPanel = 0;
		buttonList.clear();
		player1MoveCount = 0;
		player2MoveCount = 0;
		totalPanelsList.clear();
		lastMove[0] = null;
		totalPanelsList = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
		for(int row = 0; row < allButtons.length; row++) {
			for(int col = 0; col < allButtons[row].length; col++) {
				allButtons[row][col] = "-";
			}
		}
	}
	
}


