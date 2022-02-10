package Gobblegum_Pack_Generator;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyboardListener {
    public static void addKeyboardListener(){
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(e -> {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
            }
            return false;
        });
    }
}
