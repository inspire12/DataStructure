
    /*
       In this applet, the user plays a game of Blackjack.  The
       computer acts as the dealer.  The user plays by clicking
       "Hit!" and "Stand!" buttons.
       
       The programming of this applet assumes that the applet is
       set up to be about 466 pixels wide and about 346 pixels high.
       That width is just big enough to show 2 rows of 5 cards.
       The height is probably a little bigger than necessary,
       to allow for variations in the size of buttons from one platform
       to another.
       
       This file defines two classes, the applet class BlackjackGUI
       and a class BlackjackCanvas which is used in the applet.
       (This is slightly bad style, but is OK since the BlackjackCanvas
       class is not public and is not used outside this file.)
    */
    
    import java.awt.*;
    import java.awt.event.*;
    import java.applet.*;
    
    public class BlackjackGUI extends Applet {
    
       public void init() {
       
             // The init() method lays out the applet using a BorderLayout.
             // A BlackjackCanvas occupies the CENTER position of the layout.
             // On the bottom is a panel that holds three buttons.  The
             // HighLowCanvas object listens for ActionEvents from the buttons
             // and does all the real work of the program.
             
          setBackground( new Color(130,50,40) );
          setLayout( new BorderLayout(3,3) );
          
          BlackjackCanvas board = new BlackjackCanvas();
          add(board, BorderLayout.CENTER);
          
          Panel buttonPanel = new Panel();
          buttonPanel.setBackground( new Color(220,200,180) );
          add(buttonPanel, BorderLayout.SOUTH);
          
          Button hit = new Button( "Hit!" );
          hit.addActionListener(board);
          hit.setBackground(Color.lightGray);
          buttonPanel.add(hit);
          
          Button stand = new Button( "Stand!" );
          stand.addActionListener(board);
          stand.setBackground(Color.lightGray);
          buttonPanel.add(stand);
          
          Button newGame = new Button( "New Game" );
          newGame.addActionListener(board);
          newGame.setBackground(Color.lightGray);
          buttonPanel.add(newGame);
          
       }  // end init()
       
       public Insets getInsets() {
             // Specify how much space to leave between the edges of
             // the applet and the components it contains.  The background
             // color shows through in this border.
          return new Insets(3,3,3,3);
       }
    
    } // end class HighLowGUI
    
    
    class BlackjackCanvas extends Canvas implements ActionListener {
    
          // A class that displays the card game and does all the work
          // of keeping track of the state and responding to user events.
    
       Deck deck;         // A deck of cards to be used in the game.
       
       BlackjackHand dealerHand;   // Hand containing the dealer's cards.
       BlackjackHand playerHand;   // Hand containing the user's cards.
    
       String message;  // A message drawn on the canvas, which changes
                        //    to reflect the state of the game.
                        
       boolean gameInProgress;  // Set to true when a game begins and to false
                                //   when the game ends.
       
       Font bigFont;      // Font that will be used to display the message.
       Font smallFont;    // Font that will be used to draw the cards.
       
    
       BlackjackCanvas() {
             // Constructor.  Creates fonts and starts the first game.
          setBackground( new Color(0,120,0) );
          smallFont = new Font("SansSerif", Font.PLAIN, 12);
          bigFont = new Font("Serif", Font.BOLD, 14);
          doNewGame();
       }
       
    
       public void actionPerformed(ActionEvent evt) {
              // Respond when the user clicks on a button by calling
              // the appropriate procedure.  Note that the canvas is
              // registered as a listener in the BlackjackGUI class.
          String command = evt.getActionCommand();
          if (command.equals("Hit!"))
             doHit();
          else if (command.equals("Stand!"))
             doStand();
          else if (command.equals("New Game"))
             doNewGame();
       }
       
    
       void doHit() {
              // This method is called when the user clicks the "Hit!" button.
              // First check that a game is actually in progress.  If not, give
              // an error message and exit.  Otherwise, give the user a card.
              // The game can end at this point if the user goes over 21 or
              // if the user has taken 5 cards without going over 21.
          if (gameInProgress == false) {
             message = "Click \"New Game\" to start a new game.";
             repaint();
             return;
          }
          playerHand.addCard( deck.dealCard() );
          if ( playerHand.getBlackjackValue() > 21 ) {
             message = "You've busted!  Sorry, you lose.";
             gameInProgress = false;
          }
          else if (playerHand.getCardCount() == 5) {
             message = "You win by taking 5 cards without going over 21.";
             gameInProgress = false;
          }
          else {
             message = "You have " + playerHand.getBlackjackValue() + ".  Hit or Stand?";
          }
          repaint();
       }
       
    
       void doStand() {
               // This method is called when the user clicks the "Stand!" button.
               // Check whether a game is actually in progress.  If it is,
               // the game ends.  The dealer takes cards until either the
               // dealer has 5 cards or more than 16 points.  Then the 
               // winner of the game is determined.
          if (gameInProgress == false) {
             message = "Click \"New Game\" to start a new game.";
             repaint();
             return;
          }
          gameInProgress = false;
          while (dealerHand.getBlackjackValue() <= 16 && dealerHand.getCardCount() < 5)
             dealerHand.addCard( deck.dealCard() );
          if (dealerHand.getBlackjackValue() > 21)
              message = "You win!  Dealer has busted with " + dealerHand.getBlackjackValue() + ".";
          else if (dealerHand.getCardCount() == 5)
              message = "Sorry, you lose.  Dealer took 5 cards without going over 21.";
          else if (dealerHand.getBlackjackValue() > playerHand.getBlackjackValue())
              message = "Sorry, you lose, " + dealerHand.getBlackjackValue()
                                                + " to " + playerHand.getBlackjackValue() + ".";
          else if (dealerHand.getBlackjackValue() == playerHand.getBlackjackValue())
              message = "Sorry, you lose.  Dealer wins on a tie.";
          else
              message = "You win, " + playerHand.getBlackjackValue()
                                                + " to " + dealerHand.getBlackjackValue() + "!";
          repaint();
       }
       
    
       void doNewGame() {
              // Called by the constructor, and called by actionPerformed() if
              // the use clicks the "New Game" button.  Start a new game.
              // Deal two cards to each player.  The game might end right then
              // if one of the players had blackjack.  Otherwise, gameInProgress
              // is set to true and the game begins.
          if (gameInProgress) {
                  // If the current game is not over, it is an error to try
                  // to start a new game.
             message = "You still have to finish this game!";
             repaint();
             return;
          }
          deck = new Deck();   // Create the deck and hands to use for this game.
          dealerHand = new BlackjackHand();
          playerHand = new BlackjackHand();
          deck.shuffle();
          dealerHand.addCard( deck.dealCard() );  // Deal two cards to each player.
          dealerHand.addCard( deck.dealCard() );
          playerHand.addCard( deck.dealCard() );
          playerHand.addCard( deck.dealCard() );
          if (dealerHand.getBlackjackValue() == 21) {
              message = "Sorry, you lose.  Dealer has Blackjack.";
              gameInProgress = false;
          }
          else if (playerHand.getBlackjackValue() == 21) {
              message = "You win!  You have Blackjack.";
              gameInProgress = false;
          }
          else {
              message = "You have " + playerHand.getBlackjackValue() + ".  Hit or stand?";
              gameInProgress = true;
          }
          repaint();
       }  // end newGame();
    
       
       public void paint(Graphics g) {
             // The paint method shows the message at the bottom of the
             // canvas, and it draws all of the dealt cards spread out
             // across the canvas.
    
          g.setFont(bigFont);
          g.setColor(Color.green);
          g.drawString(message, 10, getSize().height - 10);
          
          // Draw labels for the two sets of cards.
          
          g.drawString("Dealer's Cards:", 10, 23);
          g.drawString("Your Cards:", 10, 153);
          
          // Draw dealer's cards.  Draw first card face down if
          // the game is still in progress,  It will be revealed
          // when the game ends.
          
          g.setFont(smallFont);
          if (gameInProgress)
             drawCard(g, null, 10, 30);
          else
             drawCard(g, dealerHand.getCard(0), 10, 30);
          for (int i = 1; i < dealerHand.getCardCount(); i++)
             drawCard(g, dealerHand.getCard(i), 10 + i * 90, 30);
             
          // Draw the user's cards.
    
          for (int i = 0; i < playerHand.getCardCount(); i++)
             drawCard(g, playerHand.getCard(i), 10 + i * 90, 160);
    
       }  // end paint();
       
    
       void drawCard(Graphics g, Card card, int x, int y) {
               // Draws a card as a 80 by 100 rectangle with
               // upper left corner at (x,y).  The card is drawn
               // in the graphics context g.  If card is null, then
               // a face-down card is drawn.  (The cards are 
               // rather primitive.)
          if (card == null) {  
                 // Draw a face-down card
             g.setColor(Color.blue);
             g.fillRect(x,y,80,100);
             g.setColor(Color.white);
             g.drawRect(x+3,y+3,73,93);
             g.drawRect(x+4,y+4,71,91);
          }
          else {
             g.setColor(Color.white);
             g.fillRect(x,y,80,100);
             g.setColor(Color.gray);
             g.drawRect(x,y,79,99);
             g.drawRect(x+1,y+1,77,97);
             if (card.getSuit() == Card.DIAMONDS || card.getSuit() == Card.HEARTS)
                g.setColor(Color.red);
             else
                g.setColor(Color.black);
             g.drawString(card.getValueAsString(), x + 10, y + 30);
             g.drawString("of", x+ 10, y + 50);
             g.drawString(card.getSuitAsString(), x + 10, y + 70);
          }
       }  // end drawCard()
    
    
    } // end class BlackjackCanvas