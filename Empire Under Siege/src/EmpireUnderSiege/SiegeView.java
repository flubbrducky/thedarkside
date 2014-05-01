package EmpireUnderSiege;

import java.awt.*;
import java.awt.event.*;

import javax.lang.model.element.Element;
import javax.swing.*;

public class SiegeView extends JFrame
{
	protected SiegeModel model;
    protected SiegePanel SiegePanel;
    protected JLabel statusBar;
    protected JMenu SiegeMenu;
    protected JPopupMenu popupMenu;
    /* controls whether paddle appears on top of JPanel */

    /**
     * The constructor creates the components and places them in the window.
     * @param model the model for this Siege game
     */
    public SiegeView(SiegeModel m, Level2 level2) {
        super("Simple Siege Game");
        model = m;
        
        Font font = new Font("SanSerif", Font.BOLD, 20);
        JButton button = new JButton("START GAME");
        button.setFont(font);
        button.setBounds(701,700,300,100);
        add(button);
        
        
        JLabel label = new JLabel("<html><tr><td align='center'><br><br>OBJECTIVE: <br><br> " +
        		"You must destroy all enemy bricks located above the paddle  " +
        		"while protecting your own bricks below.<html>", JLabel.CENTER);
        label.setBounds(701,0,300,220);
        add(label);
        label.setBackground(Color.GRAY.brighter());
        label.setFont(font);
        label.setOpaque(true);
        
        JLabel label2 = new JLabel("<html><tr><td align='center'>HOW TO PLAY:<br><br> " +
        		" Movement: <br>Keyboard<br>(left and right arrows)<br><br>" +
        		" Pause game: <br>Spacebar</html>", JLabel.CENTER);
        label2.setBounds(701,90,300,610);
        add(label2);
        
        label2.setBackground(Color.GRAY.brighter());
        label2.setFont(font);
        label2.setOpaque(true);
        // create the menu

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        SiegeMenu = new JMenu("Menu");
        SiegeMenu.setMnemonic('M');
        menuBar.add(SiegeMenu);

        JMenuItem pauseItem = new JMenuItem("Pause/Continue");
        pauseItem.setMnemonic('P');
        SiegeMenu.add(pauseItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('E');
        SiegeMenu.add(exitItem);

        // create the popup menu, need new JMenuItems

        popupMenu = new JPopupMenu();
        popupMenu.add(new JMenuItem("Pause/Continue"));
        popupMenu.add(new JMenuItem("Exit"));

        /* CENTER:
         * The panel where Siege is played
         */
        SiegePanel = new SiegePanel(model, this, level2);
        add(SiegePanel, BorderLayout.CENTER);
        SiegePanel.setBackground(Color.BLACK);
        Dimension size = SiegePanel.getSize();
        //model.setSize(size.width, size.height);

        /* SOUTH:
         * A status bar for telling us what happens.
         * Borrowed from Figure 14.15.
         */
        statusBar = new JLabel("The status bar is open.");
        statusBar.setBackground(Color.RED);
        statusBar.setOpaque(true); // need this for setBackground to work
        add(statusBar, BorderLayout.SOUTH);

                    
        // so the SiegePanel can listen to the keyboard
        SiegePanel.requestFocus();
        
        setSize(model.GetWidth(), model.GetHeight());
       
        
        
    }

    /**
     * Register event handlers with the appropriate components.
     * @param controller1 a SiegeMouseController
     * @param controller3 a SiegeMenuController
     * @param controller4 a SiegePopupController
     */
    public void registerListeners(SiegeMouseController controller1, SiegeKeyboardController controller2,
            SiegeMenuController controller3,
            SiegePopupController controller4) {
        SiegePanel.addMouseListener(controller1);
        SiegePanel.addKeyListener(controller2);
        SiegePanel.addKeyListener(controller3);
        this.addMouseListener(controller4);

        Component[] components = SiegeMenu.getMenuComponents();
        for (Component component : components) {
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.addActionListener(controller3);
            }
        }

        components = popupMenu.getComponents();
        for (Component component : components) {
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.addActionListener(controller3);
            }
        }
    }

    /**
     * Set the text in the status bar.
     * @param text
     */
    public void setStatus(String text) {
        statusBar.setText(text);
    }

    /**
     * @return The size of the SiegePanel.
     */
    public Dimension getSiegePanelSize() {
        return SiegePanel.getSize();
    }


    /**
     * Show popup menu if indicated.
     * @param event
     */
    public void checkForTriggerEvent(MouseEvent event) {
        if (event.isPopupTrigger()) {
            popupMenu.show(event.getComponent(), event.getX(), event.getY()); 
        }
    }
}
