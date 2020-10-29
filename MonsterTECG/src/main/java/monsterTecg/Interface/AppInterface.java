package monsterTecg.Interface;

/**
 *
 * @author Anthony 
 */
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
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
    public AppInterface() {

        JLabel texto = new JLabel("-Chat-");

        add(texto);
        
        
        JLabel textip = new JLabel("Ip");
        
        add(textip);
        

        ip = new JTextField(8);

        add(ip);
        
        
        JLabel textport = new JLabel("Puerto");
        
        add(textport);
        

        port = new JTextField(6);

        add(port);
        
        boton2 = new JButton("Agregar");

        add(boton2);
        
        listaCards = new JList();

        add(listaCards);
        
        
        chat_space = new JTextArea(12, 20);

        add(chat_space);

        miboton = new JButton("Enviar");

        add(miboton);

        
    }

    public JTextArea chat_space;

    public JTextField port, ip;

    public JButton miboton;
    
    public JButton boton2;

    public JList listaCards;
    
    
    
}
