package control_classes;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * IOHandle will be a passive class that will determine whether objects need to be moved or not.
 * Makes the main game aware of any user inputs that have occured
 * Created by Jilada on 26/03/17.
 */
public class IOHandle {
    // Declare the attributes to be set:
    boolean movePaddle1right;
    boolean movePaddle1left;
    boolean movePaddle2;
    boolean movePaddle3;
    boolean movePaddle4;
    boolean pauseGame;
    Scene currentScene;

    // Declare the constructor
    public IOHandle(Scene mainScene) {
        this.currentScene = mainScene;
    }
    // Declare the scene events
    // If a key (A) was pressed then move paddle left will be set to 1 others = 0
    public void handleMovement() {
        //Handler for the key pressed for player one's paddle
        currentScene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (key.getCode() == KeyCode.A) {
                movePaddle1left = true;
                movePaddle1right = false;
            } else if (key.getCode() == KeyCode.S) {
                movePaddle1left = false;
                movePaddle1right = true;
            }
        });
    }

    // Declare getters and setters
    public boolean hasMovedRightP1() {
        return this.movePaddle1right;
    }

    public boolean hasMovedLeftP1() {
        return this.movePaddle1left;
    }

    public void resetP1() {
        this.movePaddle1left = false;
        this.movePaddle1right = false;
    }
}