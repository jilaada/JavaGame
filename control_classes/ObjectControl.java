package control_classes;
import model_classes.*;
import view_classes.RenderView;

import java.lang.Math;

public class ObjectControl {
	
	public ObjectControl() {
		//Add some constructor information
	}
	
	//Need to add:
	/**
	 * movePaddle is a function that will move the paddle in a specific direction determined by keyboard inputs
	 * @param currentPaddle - paddle to be moved
	 * @param direction - direction of movement; determined via keyboard inputs (1 = right, 0 = left)
	 */
	public boolean movePaddle(Paddle currentPaddle, int direction) {
		//TODO: move paddle is a function that will move the paddle according to the inputs
		int newX, newY;
		int paddleSpeed = (int)currentPaddle.getPaddleSpeed();
		int paddleLength = (int)currentPaddle.getPaddleSize();
		int paddleHeight = (int)currentPaddle.getPaddleHeight();
		Point curPos = currentPaddle.getCurrentPos();
		Point startPos = currentPaddle.getPaddleStart();
		Point endPos = currentPaddle.getPaddleEnd();
		Point boundPos = currentPaddle.getPaddleBounds();
		int token = currentPaddle.getPaddleToken();

		// Determine if the paddle is in between;
		//	1. start and middle
		//	2. middle and end
		//	3. at middle

		// Specifying at least one sustained position
		newX = curPos.getX();
		newY = curPos.getY();

		if (token == 1) {
			//Move player 1 paddle
			if (direction == 1) {
				// Move to the right
				if (curPos.getY() == boundPos.getY()) {
					// Horizontal
					if (curPos.getX() + paddleSpeed + paddleLength <= boundPos.getX()) {
						// Get new x coordinates
						newX = curPos.getX() + paddleSpeed;
						newY = boundPos.getY();
					} else {
						newX = boundPos.getX();
						newY = boundPos.getY() - paddleLength + paddleHeight;
					}
				} else {
					// Vertical
					if ((curPos.getY() - paddleSpeed) > endPos.getY()) {
						newX = boundPos.getX();
						newY = curPos.getY() - paddleSpeed;
					} else {
						newX = boundPos.getX();
						newY = endPos.getY();
					}
				}
			} else {
				// Moving to the left
				if (curPos.getX() == boundPos.getX()) {
					//Vertical
					if ((curPos.getY() + paddleSpeed + paddleLength) <= boundPos.getY()) {
						// Paddle moving down
						newX = boundPos.getX();
						newY = curPos.getY() + paddleSpeed;
					} else {
						// Paddle is moving down and across
						newX = boundPos.getX() - paddleLength + paddleHeight;
						newY = boundPos.getY();
					}
				} else {
					// Horizontal
					if (curPos.getX() - paddleSpeed >= startPos.getX()) {
						newX = curPos.getX() - paddleSpeed;
						newY = boundPos.getY();
					} else {
						newX = startPos.getX();
						newY = boundPos.getY();
					}
				}
			}
		} else if (token == 2) {
			//Move player 2 paddle
			if (direction == 1) {
				// Move to the right
				if (curPos.getY() == boundPos.getY()) {
					// Horizontal
					if (curPos.getX() + paddleSpeed <= endPos.getX()) {
						newX = curPos.getX() + paddleSpeed;
						newY = boundPos.getY();
					} else {
						newX = endPos.getX();
						newY = boundPos.getY();
					}
				} else {
					// Vertical
					if ((curPos.getY() + paddleSpeed + paddleLength) >= endPos.getY()) {
						newX = boundPos.getX() + paddleSpeed - (boundPos.getY() - (curPos.getY() + paddleLength));
						newY = boundPos.getY();
					} else {
						newX = boundPos.getX();
						newY = curPos.getY() + paddleSpeed;
					}
				}
			} else {
				// Moving to the left
				if (curPos.getX() == boundPos.getX()) {
					//Vertical
					if ((curPos.getY() - paddleSpeed) <= startPos.getY()) {
						newX = boundPos.getX();
						newY = startPos.getY();
					} else {
						newX = boundPos.getX();
						newY = curPos.getY() - paddleSpeed;
					}
				} else {
					// Horizontal
					if ((curPos.getX() - paddleSpeed) <= startPos.getX()) {
						newX = boundPos.getX();
						newY = boundPos.getY() - paddleLength + paddleHeight;
					} else {
						newX = curPos.getX() - paddleSpeed;
						newY = boundPos.getY();
					}
				}
			}
		} else if (token == 3) {
			//Move player 2 paddle
			if (direction == 1) {
				// Move to the right
				if ((curPos.getY() == boundPos.getY()) && (curPos.getX() != boundPos.getX())) {
					// Horizontal
					if (curPos.getX() + paddleSpeed + paddleLength < boundPos.getX()) {
						newX = curPos.getX() + paddleSpeed;
						newY = boundPos.getY();
					} else {
						newX = endPos.getX();
						newY = boundPos.getY() + paddleSpeed - (boundPos.getX() - (curPos.getX() + paddleLength));
					}
				} else {
					// Vertical
					if ((curPos.getY() + paddleSpeed) >= endPos.getY()) {
						newX = boundPos.getX();
						newY = endPos.getY();
					} else {
						newX = boundPos.getX();
						newY = curPos.getY() + paddleSpeed;
					}
				}
			} else {
				// Moving to the left
				if (curPos.getX() == boundPos.getX()) {
					//Vertical
					if ((curPos.getY() - paddleSpeed) <= boundPos.getY()) {
						newX = boundPos.getX() - (curPos.getY() - boundPos.getY()) - paddleLength;
						newY = boundPos.getY();
					} else {
						newX = boundPos.getX();
						newY = curPos.getY() - paddleSpeed;
					}
				} else {
					// Horizontal
					if (curPos.getX() - paddleSpeed >= startPos.getX()) {
						newX = curPos.getX() - paddleSpeed;
						newY = boundPos.getY();
					} else {
						newX = startPos.getX();
						newY = boundPos.getY();
					}
				}
			}
		} else if (token == 4) {
			//Move player 2 paddle
			if (direction == 1) {
				// Move to the right
				if (curPos.getY() == boundPos.getY()) {
					// Horizontal
					if (curPos.getX() + paddleSpeed <= endPos.getX()) {
						newX = curPos.getX() + paddleSpeed;
						newY = boundPos.getY();
					} else {
						newX = endPos.getX();
						newY = boundPos.getY();
					}
				} else {
					// Vertical
					if ((curPos.getY() - paddleSpeed) >= boundPos.getY()) {
						newX = boundPos.getX();
						newY = curPos.getY() - paddleSpeed;
					} else {
						newX = boundPos.getX() + (curPos.getY() - boundPos.getY());
						newY = boundPos.getY();
					}
				}
			} else {
				// Moving to the left
				if (curPos.getX() == boundPos.getX()) {
					//Vertical
					if ((curPos.getY() + paddleSpeed) >= startPos.getY()) {
						newX = boundPos.getX();
						newY = startPos.getY();
					} else {
						newX = boundPos.getX();
						newY = curPos.getY() + paddleSpeed;
					}
				} else {
					// Horizontal
					if (curPos.getX() - paddleSpeed >= boundPos.getX()) {
						newX = curPos.getX() - paddleSpeed;
						newY = boundPos.getY();
					} else {
						newX = boundPos.getX();
						newY = boundPos.getY() + (curPos.getX() - boundPos.getX());
					}
				}
			}
		}

		// Set the newY and newX coordinates and switch to old coordinates
		currentPaddle.setPreviousPos(currentPaddle.getCurrentPos());
		currentPaddle.getCurrentPos().setX(newX);
		currentPaddle.getCurrentPos().setY(newY);

		if (newX == boundPos.getX() && newY == boundPos.getY()) {
			return false;
		} else if (newX == boundPos.getX()) {
			return false;
		} else {
			return true;
		}
	}
	
	//MoveBall:
	/**
	 * moveBall is a function that will move the ball when called. Direction of ball movement is dependent on the previous direction
	 * and the angle as well as the speed of the ball
	 * @param currentBall - the ball to be moved
	 */
	public void moveBall(Ball currentBall, CollisionStruct inp) {
		//TODO: change so angle can be changed randomly


		//Declare and get variables from checkCollision function
		double newX = inp.getNewValues()[0], newY = inp.getNewValues()[1];
		double updatePrevX = currentBall.getCurrentPos().getX(), updatePrevY = currentBall.getCurrentPos().getY();
		boolean[] wallArray = inp.getWallHit();
		boolean wallLeft = wallArray[0], wallRight = wallArray[1], wallTop = wallArray[2], wallBottom = wallArray[3];
		Point finalPoint = inp.getFinalPoint();
		double xDel = Math.abs(currentBall.getPreviousPos().getX() - updatePrevX), yDel = Math.abs(currentBall.getPreviousPos().getY() - updatePrevY);

		// Check if there was a collision
		if (finalPoint != null) {//IF INTERSECTS WORKS BUT THEN BALL WONT COLLIDE (line is from centre)

			//Since collision has occured, account for it by updating current and previous ball coordinates

			if ((newX > finalPoint.getX()) && (wallLeft == true)) { //Left wall collision
				newX = finalPoint.getX() - (newX - finalPoint.getX());
				updatePrevX = newX + xDel;
			} else if ((newX < finalPoint.getX()) && (wallRight == true)) { //Right wall collision
				newX = finalPoint.getX() + (finalPoint.getX() - newX);
				updatePrevX = newX - xDel;
			}

			if ((newY > finalPoint.getY()) && (wallTop == true)) { //Top wall collision
				newY = finalPoint.getY() - (newY - finalPoint.getY());
				updatePrevY = newY + yDel;
			} else if ((newY < finalPoint.getY()) && (wallBottom == true)) { //Bottom wall collision
				newY = finalPoint.getY() + (finalPoint.getY() - newY);
				updatePrevY = newY - yDel;
			}

			//Update previous coordinates
			currentBall.getPreviousPos().setX((int) updatePrevX);
			currentBall.getPreviousPos().setY((int) updatePrevY);

			// Set the new point with the new x and y coordinate
			currentBall.getCurrentPos().setX((int) Math.round(newX));
			currentBall.getCurrentPos().setY((int) Math.round(newY));

			currentBall.setMoved(true);
		}

	}

	public void moveInBounds(Ball currentBall, Collision col) {
			//Object collision hasn't occurred so check boundary collision
			// Then account for it by updating current and previous ball coordinates
		Point check = col.getDels((Ball) currentBall.getObj());

		//Get new and current positions
		double newX = check.getX();
		double newY = check.getY();
		double updatePrevX = ((Ball) currentBall.getObj()).getCurrentPos().getX();
		double updatePrevY = ((Ball) currentBall.getObj()).getCurrentPos().getY();

		double xDel = Math.abs(currentBall.getCurrentPos().getX() - newX);
		double yDel = Math.abs(currentBall.getCurrentPos().getY() - newY);

			if (newX > 1024) { //Right boundary
				newX = 1024 - (newX - 1024);
				updatePrevX = newX + xDel;
			} else if (newX < 0) { //Left boundary
				newX = Math.abs(newX);
				updatePrevX = newX - xDel;
			}

			if (newY > 768) { //Bottom boundary
				newY = 768 - (newY - 768);
				updatePrevY = newY + yDel;
			} else if (newY < 0) { //Top boundary
				newY = Math.abs(newY);
				updatePrevY = newY - yDel;
			}

			//Update previous coordinates
			currentBall.getPreviousPos().setX((int)updatePrevX);
			currentBall.getPreviousPos().setY((int)updatePrevY);

			// Set the new point with the new x and y coordinate
			currentBall.getCurrentPos().setX((int)Math.round(newX));
			currentBall.getCurrentPos().setY((int)Math.round(newY));

	}

	public void moveAllPaddles(RenderView render, IOHandle HandleIO, GameSetUp SetUpGame) {
		if (HandleIO.hasMovedLeftP1()) {
			if (movePaddle(SetUpGame.getPlayer1().getPlayerPaddle(), 0)) {
				// Is not horizontal
				SetUpGame.getPlayer1().getPlayerPaddle().setRotated(false);
				render.getP1Render().setHeight(15);
				render.getP1Render().setWidth(80);
			} else {
				SetUpGame.getPlayer1().getPlayerPaddle().setRotated(true);
				render.getP1Render().setHeight(80);
				render.getP1Render().setWidth(15);
			}
		} else if (HandleIO.hasMovedRightP1()) {
			if (movePaddle(SetUpGame.getPlayer1().getPlayerPaddle(), 1)) {
				// Is not horizontal
				SetUpGame.getPlayer1().getPlayerPaddle().setRotated(false);
				render.getP1Render().setHeight(15);
				render.getP1Render().setWidth(80);
			} else {
				SetUpGame.getPlayer1().getPlayerPaddle().setRotated(true);
				render.getP1Render().setHeight(80);
				render.getP1Render().setWidth(15);
			}
		}

		if (HandleIO.hasMovedLeftP2()) {
			if (movePaddle(SetUpGame.getPlayer2().getPlayerPaddle(), 0)) {
				// Is not horizontal
				SetUpGame.getPlayer2().getPlayerPaddle().setRotated(false);
				render.getP2Render().setHeight(15);
				render.getP2Render().setWidth(80);
			} else {
				SetUpGame.getPlayer2().getPlayerPaddle().setRotated(true);
				render.getP2Render().setHeight(80);
				render.getP2Render().setWidth(15);
			}
		} else if (HandleIO.hasMovedRightP2()) {
			if (movePaddle(SetUpGame.getPlayer2().getPlayerPaddle(), 1)) {
				// Is not horizontal
				SetUpGame.getPlayer2().getPlayerPaddle().setRotated(false);
				render.getP2Render().setHeight(15);
				render.getP2Render().setWidth(80);
			} else {
				SetUpGame.getPlayer2().getPlayerPaddle().setRotated(true);
				render.getP2Render().setHeight(80);
				render.getP2Render().setWidth(15);
			}
		}

		if (HandleIO.hasMovedLeftP3()) {
			if (movePaddle(SetUpGame.getPlayer3().getPlayerPaddle(), 0)) {
				// Is not horizontal
				SetUpGame.getPlayer3().getPlayerPaddle().setRotated(false);
				render.getP3Render().setHeight(15);
				render.getP3Render().setWidth(80);
			} else {
				SetUpGame.getPlayer3().getPlayerPaddle().setRotated(true);
				render.getP3Render().setHeight(80);
				render.getP3Render().setWidth(15);
			}
		} else if (HandleIO.hasMovedRightP3()) {
			if (movePaddle(SetUpGame.getPlayer3().getPlayerPaddle(), 1)) {
				// Is not horizontal
				SetUpGame.getPlayer3().getPlayerPaddle().setRotated(false);
				render.getP3Render().setHeight(15);
				render.getP3Render().setWidth(80);
			} else {
				SetUpGame.getPlayer3().getPlayerPaddle().setRotated(true);
				render.getP3Render().setHeight(80);
				render.getP3Render().setWidth(15);
			}
		}
		if (HandleIO.hasMovedLeftP4()) {
			if (movePaddle(SetUpGame.getPlayer4().getPlayerPaddle(), 0)) {
				// Is not horizontal
				SetUpGame.getPlayer4().getPlayerPaddle().setRotated(false);
				render.getP4Render().setHeight(15);
				render.getP4Render().setWidth(80);
			} else {
				SetUpGame.getPlayer4().getPlayerPaddle().setRotated(true);
				render.getP4Render().setHeight(80);
				render.getP4Render().setWidth(15);
			}
		} else if (HandleIO.hasMovedRightP4()) {
			if (movePaddle(SetUpGame.getPlayer4().getPlayerPaddle(), 1)) {
				// Is not horizontal
				SetUpGame.getPlayer4().getPlayerPaddle().setRotated(false);
				render.getP4Render().setHeight(15);
				render.getP4Render().setWidth(80);
			} else {
				SetUpGame.getPlayer4().getPlayerPaddle().setRotated(true);
				render.getP4Render().setHeight(80);
				render.getP4Render().setWidth(15);
			}
		}
	}

}
