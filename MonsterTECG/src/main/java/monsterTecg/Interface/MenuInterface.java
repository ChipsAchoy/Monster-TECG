package monsterTecg.Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import monsterTecg.Logics.Connect;
import monsterTecg.Logics.HostMatch;

/**
 *
 * @author Anthony Chaves
 */
public class MenuInterface extends JPanel{
    
    public MenuInterface(String fileName, MenuWindow mw) {
        
        this.setLayout(null);
        try{
            bg = ImageIO.read(new File(fileName));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        
        host = new JButton("Host Match");
        add(host);
        host.setBounds(120, 160, 150, 30);
        
        ipT = new JLabel("IP:");
        ipT.setForeground(Color.WHITE);
        add(ipT);
        ipT.setBounds(50, 220, 60, 30);
        
        portT = new JLabel("Port:");
        portT.setForeground(Color.WHITE);
        add(portT);
        portT.setBounds(190, 220, 60, 30);
        
        port = new JTextField(6);
        add(port);
        port.setBounds(230,220,60, 30);
        
        ip = new JTextField(9);
        add(ip);
        ip.setBounds(90,220,80, 30);
        
        connect = new JButton("Connect to host");
        add(connect);
        connect.setBounds(100, 280, 200, 30);
        
        info = new JLabel("");
        info.setForeground(Color.WHITE);
        add(info);
        info.setBounds(140, 330, 200, 30);
        
        Connect con = new Connect(this, mw);
        connect.addActionListener(con);
        
        HostMatch hm = new HostMatch(this, mw);
        host.addActionListener(hm);
        
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image.
        g.drawImage(this.bg, 0, 0, this);
    }
    
    private Image bg = null;
    
    public JTextField port, ip;
    
    public JLabel portT, ipT, info;

    public JButton connect, host;
}
