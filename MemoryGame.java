import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

public class MemoryGame extends JFrame{
    
    int score = 0;
    int matchCount = 0;
    JPanel mainContents = new JPanel();
    JButton reset = new JButton("Reset");
    JPanel buttonPanel = new JPanel();
    JLabel mainLabel = new JLabel("Welcome new player. Curent score: 0");
    
    final int COLUMNS = 4;
    final int ROWS = 3;
    ArrayList<JButton> buttonList = new ArrayList<JButton>();
    ArrayList<Color> colorList = new ArrayList<Color>();

    
    JButton firstClick;



    public MemoryGame() {
        super("Memory Game");

        add(mainContents);
        mainContents.setLayout(new BorderLayout());
        mainContents.add(mainLabel, BorderLayout.NORTH);
        mainContents.add(reset, BorderLayout.SOUTH);
        mainContents.add(buttonPanel, BorderLayout.CENTER);

        mainContents.setVisible(true);


        GridLayout gridLayout = new GridLayout(ROWS, COLUMNS);
        buttonPanel.setLayout(gridLayout);
        
        for(int i = 0; i < ROWS*COLUMNS; i++) {
            JButton button = new JButton();
            button.addActionListener(e -> buttonClicked(e));
            buttonList.add(button);
            buttonPanel.add(button);
        }
        reset.addActionListener(e -> resetGame());
        initColorsList();
        setSize(900, 900);
        setLocation(500, 0);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initColorsList() {
        
        Collections.addAll(colorList, Color.BLUE, Color.GRAY, Color.CYAN, Color.MAGENTA, Color.ORANGE, Color.YELLOW);
        Collections.addAll(colorList, Color.BLUE, Color.GRAY, Color.CYAN, Color.MAGENTA, Color.ORANGE, Color.YELLOW);
        Collections.shuffle(colorList);
    }

    private void buttonClicked(ActionEvent actionEvent) {

        JButton button = (JButton) actionEvent.getSource();
        int index = buttonList.indexOf(button);
        Color color = colorList.get(index);
        button.setBackground(color);
        
        if(firstClick == null) {
                firstClick = button;
            button.setEnabled(false);
        } else {
                if(firstClick.getBackground().equals(button.getBackground())) {
                // match
                button.setEnabled(false);
                score+= 10;
                matchCount++;
                mainLabel.setText("Current Score: " + score);
                if(matchCount == 6) {
                    JOptionPane.showMessageDialog(this, "You is a winner");
                    resetGame();
                }
            } else {
                //reset the buttons
                //let user know there was no match
                JOptionPane.showMessageDialog(this, "colors don't match");
                button.setEnabled(true);
                button.setBackground(null);
                firstClick.setEnabled(true);
                firstClick.setBackground(null);
                if(score > 0) {
                    score--;
                }
                mainLabel.setText("Current Score: " + score);
            }
        firstClick = null;
        }
    }
    public void resetGame() {
        for(int i = 0; i < 12; i++) {
            JButton button = buttonList.get(i);
            button.setEnabled(true);
            button.setBackground(null);
            score = 0;
            matchCount = 0;
            Collections.shuffle(colorList);
            mainLabel.setText("Welcome new player. Curent score: 0"); 
        }
    }
}
