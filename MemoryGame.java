import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

public class MemoryGame extends JFrame{
    
    final int COLUMNS = 4;
    final int ROWS = 3;
    

    ArrayList<JButton> buttonList = new ArrayList<JButton>();
    ArrayList<Color> colorList = new ArrayList<Color>();


    public MemoryGame() {
        super("Memory Game");
        GridLayout gridLayout = new GridLayout(ROWS, COLUMNS);
        for(int i = 0; i < ROWS*COLUMNS; i++) {
            JButton button = new JButton();
            button.addActionListener(e -> buttonClicked(e));
            buttonList.add(button);
            add(button);
        }
        initColorsList();
        setSize(900, 900);
        setLocation(500, 0);
        setVisible(true);
        setLayout(gridLayout);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initColorsList() {
        colorList.add(Color.BLUE);
        colorList.add(Color.BLUE);
        colorList.add(Color.CYAN);
        colorList.add(Color.CYAN);
        colorList.add(Color.DARK_GRAY);
        colorList.add(Color.DARK_GRAY);
        colorList.add(Color.MAGENTA);
        colorList.add(Color.MAGENTA);
        colorList.add(Color.BLACK);
        colorList.add(Color.BLACK);
        colorList.add(Color.YELLOW);
        colorList.add(Color.YELLOW);
    
        Collections.shuffle(colorList);
    }

    private void buttonClicked(ActionEvent actionEvent) {
        JButton button = (JButton) actionEvent.getSource();
        int index = buttonList.indexOf(button);
        Color color = colorList.get(index);
        button.setBackground(color);
    }
}
