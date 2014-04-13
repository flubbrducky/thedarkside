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
    /* controls whether paddle appears on top of JPanel */
    protected boolean flipVertical;

    /**
     * The constructor creates the components and places them in the window.
     * @param model the model for this Siege game
     */
    public SiegeView(SiegeModel model) {
        super("Simple Siege Game");
        this.model = model;
        flipVertical = false;

        // create the menu

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        SiegeMenu = new JMenu("Menu");
        SiegeMenu.setMnemonic('M');
        menuBar.add(SiegeMenu);

        JMenuItem flipVerticalItem = new JMenuItem("Flip Vertically");
        flipVerticalItem.setMnemonic('F');
        SiegeMenu.add(flipVerticalItem);

        JMenuItem pauseItem = new JMenuItem("Pause/Continue");
        pauseItem.setMnemonic('P');
        SiegeMenu.add(pauseItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('E');
        SiegeMenu.add(exitItem);

        // create the popup menu, need new JMenuItems

        popupMenu = new JPopupMenu();
        popupMenu.add(new JMenuItem("Flip Vertically"));
        popupMenu.add(new JMenuItem("Pause/Continue"));
        popupMenu.add(new JMenuItem("Exit"));

        /* CENTER:
         * The panel where Siege is played
         */
        SiegePanel = new SiegePanel(model, this);
        add(SiegePanel, BorderLayout.CENTER);
        SiegePanel.setBackground(Color.WHITE);
        Dimension size = SiegePanel.getSize();
        model.setSize(size.width, size.height);

        /* SOUTH:
         * A status bar for telling us what happens.
         * Borrowed from Figure 14.15.
         */
        statusBar = new JLabel("The status bar is open.");
        statusBar.setBackground(Color.YELLOW);
        statusBar.setOpaque(true); // need this for setBackground to work
        add(statusBar, BorderLayout.SOUTH);

        // so the SiegePanel can listen to the keyboard
        SiegePanel.requestFocus();
    }

    /**
     * Register event handlers with the appropriate components.
     * @param controller1 a SiegeMouseController
     * @param controller2 a SiegeResizeController
     * @param controller3 a SiegeMenuController
     * @param controller4 a SiegePopupController
     */
    public void registerListeners(SiegeMouseController controller1, 
            SiegeResizeController controller2,
            SiegeMenuController controller3,
            SiegePopupController controller4) {
        SiegePanel.addMouseListener(controller1);
        SiegePanel.addMouseMotionListener(controller1);
        SiegePanel.addComponentListener(controller2);
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
     * Translate from mouse x to model x depending on view mode.
     * @param x horizontal location of mouse
     */
    public int translateX(int x) {
        return x;
    }

    /**
     * Translate from mouse y to model y depending on view mode.
     * @param y vertical location of mouse or model
     */
    public int translateY(int y) {
        if (flipVertical) {
            Dimension size = getSiegePanelSize();
            y = size.height - y;
        }
        return y;
    }

    /**
     * @return value of flipVertical
     */
    public boolean getFlipVertical() {
        return flipVertical;
    }

    /**
     * Set value of flipVertical
     * @param b new value for flipVertical
     */
    public void setFlipVertical(boolean b) {
        flipVertical = b;
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
