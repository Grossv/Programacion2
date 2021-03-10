
package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Sistemas-03
 */
public class MainFrame extends JFrame{

    private JLabel titleLabel;
    
    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,400);
        setTitle("The first frame ");
        
        titleLabel = new JLabel("Normaluko!");
        
        getContentPane().add(titleLabel);
        setVisible(true);
    }
    
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}
