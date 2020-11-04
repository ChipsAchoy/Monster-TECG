package monsterTecg.Interface;

/**
 *
 * @author Anthony 
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * AppInterface defines the attributes that will be seen on the run time Graphic Interface
 *
 */
public class AppInterface extends JPanel {
    /**
     * Class Constructor
     * 
     */
    public AppInterface(String fileName) {
        
        this.setLayout(null);
        try{
            bg = ImageIO.read(new File(fileName));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        
        hp = new JLabel("HP: 1000");
        hp.setForeground(Color.GREEN);
        hp.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        add(hp);
        hp.setBounds(600,100,200, 50);

        mana = new JLabel("Mana: 200");
        mana.setForeground(Color.BLUE);
        mana.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        add(mana);
        mana.setBounds(600,200,200, 50);
        
        info1 = new JLabel("");
        info1.setForeground(Color.cyan);
        info1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(info1);
        info1.setBounds(30,520,200, 50);
        
        info2 = new JLabel("");
        info2.setForeground(Color.cyan);
        info2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(info2);
        info2.setBounds(30,420,260,50);
        
        deckC = new JLabel("");
        deckC.setForeground(Color.cyan);
        deckC.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(deckC);
        deckC.setBounds(310,200,60, 50);
        
        deck = new JButton("Tomar carta");
        deck.setBackground(Color.BLUE);
        deck.setForeground(Color.white);
        add(deck);
        deck.setBounds(310,240,150, 50);
        
        listaCards = new JList();
        add(listaCards);
        listaCards.setLocation(600,360);
        
        textArea = new JTextArea(12, 20);
        textArea.setBackground(Color.DARK_GRAY);
        textArea.setForeground(Color.white);
        scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(30, 100,150, 150);
        add(scroll);
        
        carta = new JButton();
        add(carta);
        carta.setBounds(310,420,150, 210);
        
        right = new JButton("Siguiente");
        right.setBackground(Color.GREEN);
        right.setForeground(Color.white);
        add(right);
        right.setBounds(470,500,90, 70);

        left = new JButton("Anterior");
        left.setBackground(Color.GREEN);
        left.setForeground(Color.white);
        add(left);
        left.setBounds(210,500,90, 70);
        
        pass = new JButton("Pasar Turno");
        pass.setBackground(Color.blue);
        pass.setForeground(Color.white);
        add(pass);
        pass.setBounds(30,300,150, 70);
        
        
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image.
        g.drawImage(this.bg, 0, 0, this);
    }
    
    
    private Image bg = null; 
    
    public Icon icon;
    
    public JScrollPane scroll;
    
    public JTextArea textArea;

    public JLabel mana, hp, info1, info2, deckC;

    public JButton carta, deck, right, left, pass;

    public JList listaCards;
    
    
    
}
