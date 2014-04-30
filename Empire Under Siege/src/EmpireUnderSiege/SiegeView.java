package EmpireUnderSiege;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SiegeView extends JFrame
{
	protected SiegeModel model;
    protected SiegePanel SiegePanel;
    protected JLabel statusBar;
    protected JMenu SiegeMenu;
    protected JPopupMenu popupMenu;
    protected JPanel sideMenu;
    /* controls whether paddle appears on top of JPanel */

    /**
     * The constructor creates the components and places them in the window.
     * @param model the model for this Siege game
     */
    public SiegeView(SiegeModel m) {
        super("Simple Siege Game");
        model = m;
        
        //creates a button
        Font font = new Font("SanSerif", Font.BOLD, 10);
        JButton button = new JButton("START GAME");
        button.setFont(font);
        button.setBounds(700,700,170,110);
        add(button);
        
        //creates labels of how to play and game info
        JLabel topSideMenu = new JLabel("Game Info", JLabel.CENTER);
        topSideMenu.setBackground(Color.RED);
        topSideMenu.setFont(font);
        topSideMenu.setBounds(700,0,170,760);
        topSideMenu.setOpaque(true);
        add(topSideMenu);
        
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
        SiegePanel = new SiegePanel(model, this);
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
