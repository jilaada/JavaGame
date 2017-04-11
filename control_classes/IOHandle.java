package control_classes;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

import java.util.HashSet;
import java.util.Set;

/**
 * IOHandle will be a passive class that will determine whether objects need to be moved or not.
 * Makes the main game aware of any user inputs that have occured
 * Created by Jilada on 26/03/17.
 */
public class IOHandle {
    // Declare the attributes to be set:
    private boolean movePaddle1right;
    private boolean movePaddle1left;
    private boolean movePaddle2right;
    private boolean movePaddle2left;
    private boolean movePaddle3right;
    private boolean movePaddle3left;
    private boolean movePaddle4right;
    private boolean movePaddle4left;
    private boolean escGame;
    private boolean timeOut;
    private boolean pauseGame;
    private Scene currentScene;
    private int numPlayers;
    private final Set<String> KeysPressed = new HashSet<String>();


    EventHandler<KeyEvent> startEvent = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            //System.out.print(event.getCode().toString());
            if (!KeysPressed.contains(event.getCode().toString())) {
                KeysPressed.add(event.getCode().toString());
            }
            HandleMovement(KeysPressed);
        }
    };

    EventHandler<KeyEvent> closeEvent = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            KeysPressed.remove(event.getCode().toString());
        }
    };

    // Declare the constructor
    public IOHandle(Scene mainScene, int numPlayers) {
        this.numPlayers = numPlayers;
        this.currentScene = mainScene;
        System.out.println("I am constructed");
    }

    // Declare the scene events
    // If a key (A) was pressed then move paddle left will be set to 1 others = 0
    public void keyPressed() {
        currentScene.setOnKeyPressed(startEvent);
        currentScene.setOnKeyReleased(closeEvent);
    }

    public void HandleMovement(Set<String> pressed) {
        for (String e : pressed) {
            // Determine the number of players in a game and check for the corresponding key pressed else ignore
            if (numPlayers == 1) {
                if (e == "A") {
                    movePaddle1left = true;
                    movePaddle1right = false;
                } else if (e == "S") {
                    movePaddle1left = false;
                    movePaddle1right = true;
                }
            } else if (numPlayers == 2) {
                if (e == "A") {
                    movePaddle1left = true;
                    movePaddle1right = false;
                } else if (e == "S") {
                    movePaddle1left = false;
                    movePaddle1right = true;
                } else if (e == "F") {
                    movePaddle2left = true;
                    movePaddle2right = false;
                } else if (e == "G") {
                    movePaddle2left = false;
                    movePaddle2right = true;
                }
            } else if (numPlayers == 3) {
                if (e == "A") {
                    System.out.println("inA");
                    movePaddle1left = true;
                    movePaddle1right = false;
                } else if (e == "S") {
                    movePaddle1left = false;
                    movePaddle1right = true;
                } else if (e == "F") {
                    movePaddle2left = true;
                    movePaddle2right = false;
                } else if (e == "G") {
                    movePaddle2left = false;
                    movePaddle2right = true;
                } else if (e == "J") {
                    movePaddle3left = true;
                    movePaddle3right = false;
                } else if (e == "K") {
                    movePaddle3left = false;
                    movePaddle3right = true;
                }
            } else {
                if (e == "A") {
                    movePaddle1left = true;
                    movePaddle1right = false;
                } else if (e == "S") {
                    movePaddle1left = false;
                    movePaddle1right = true;
                } else if (e == "F") {
                    movePaddle2left = true;
                    movePaddle2right = false;
                } else if (e == "G") {
                    movePaddle2left = false;
                    movePaddle2right = true;
                } else if (e == "J") {
                    movePaddle3left = true;
                    movePaddle3right = false;
                } else if (e == "K") {
                    movePaddle3left = false;
                    movePaddle3right = true;
                } else if (e == "LEFT") {
                    movePaddle4left = true;
                    movePaddle4right = false;
                } else if (e == "RIGHT") {
                    movePaddle4left = false;
                    movePaddle4right = true;
                }
            }
            if (e == "P") {
                pauseGame = !pauseGame;
            } else if (e == "ESCAPE") {
                escGame = true;
            } else if (e == "PAGE_DOWN") {
                System.out.println("ITS GOING TRUUUUUUUUUE");
                timeOut = true;
            }
        }
    }


    // Declare getters and setters
    public boolean hasMovedRightP1() {
        return this.movePaddle1right;
    }

    public boolean hasMovedLeftP1() {
        return this.movePaddle1left;
    }

    // Declare getters and setters
    public boolean hasMovedRightP2() {
        return this.movePaddle2right;
    }

    public boolean hasMovedLeftP2() {
        return this.movePaddle2left;
    }

    // Declare getters and setters
    public boolean hasMovedRightP3() {
        return this.movePaddle3right;
    }

    public boolean hasMovedLeftP3() {
        return this.movePaddle3left;
    }

    // Declare getters and setters
    public boolean hasMovedRightP4() {
        return this.movePaddle4right;
    }

    public boolean hasMovedLeftP4() {
        return this.movePaddle4left;
    }

    public void setMovedRightP2() {
        movePaddle2right = !movePaddle2right;
    }

    public void setMovedLeftP2() {
        movePaddle2left = !movePaddle2left;
    }

    // Declare getters and setters
    public void setMovedRightP3() {
        movePaddle3right = !movePaddle3right;
    }

    public void setMovedLeftP3() {
        movePaddle3left = !movePaddle3left;
    }

    // Declare getters and setters
    public void setMovedRightP4() {
        movePaddle4right = !movePaddle4right;
    }

    public void setMovedLeftP4() {
        movePaddle4left = !movePaddle4left;
    }

    public boolean isPaused() {
        return this.pauseGame;
    }

    public boolean isEscGame() { return this.escGame; }

    public void setEscGame(boolean in) { this.escGame = in; }

    public void resetHandler() {
        this.escGame = false;
        this.timeOut = false;
        this.pauseGame = false;
}

    public boolean hasTimeOut() {
        return this.timeOut;
    }

    public int getNumPlayers() {
        return this.numPlayers;
    }

    public void resetPaddle() {
        this.movePaddle1left = false;
        this.movePaddle1right = false;
        this.movePaddle2left = false;
        this.movePaddle2right = false;
        this.movePaddle3left = false;
        this.movePaddle3right = false;
        this.movePaddle4left = false;
        this.movePaddle4right = false;
    }


}
