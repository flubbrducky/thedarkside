package EmpireUnderSiege;

public class SiegeModel {
	// the ball(s)
	protected double ballX, ballY;
	protected double velocityX, velocityY;
	protected double change;
	protected int ballDiameter;

	// the paddle
	protected int paddleX, paddleY;
	protected int paddleWidth, paddleHeight;
	protected int paddleSpeed;

	// the bricks
	protected double brickX, brickY;
	protected int brickHP;

	// the panel
	protected int width, height;

	// the game
	protected int hits, misses;
	protected boolean pause;
	protected int powerup;

	public SiegeModel() {
		paddleX = 0;
		paddleY = 390;
		paddleWidth = 100;
		paddleHeight = 11;
		ballX = 10000;
		ballY = 10000;
		ballDiameter = 12;
		change = 7;
		velocityX = change;
		velocityY = change;
		width = 0;
		height = 0;
		hits = 0;
		misses = 0;
		pause = false;
	}

	/**
	 * Set the position of the paddle based on the position of the mouse
	 * 
	 * @param x
	 *            horizontal position of the mouse
	 * @param y
	 *            vertical position of the mouse
	 */
	public void setPaddle(int x, int y) {
		paddleX = x - paddleWidth / 2;
		if (paddleX > width - paddleWidth) {
			paddleX = width - paddleWidth;
		}
		if (paddleX < 0) {
			paddleX = 0;
		}
	}

	/**
	 * Move the ball to its next position based on its current position, its
	 * velocity, and the position of the walls and the paddle.
	 */
	public void moveBall() {
		// Don't do anything if the game is paused.
		// Also, this might get called before the window is opened.
		if (height == 0 || pause) {
			return;
		}
		ballX += velocityX;
		ballY += velocityY;

		// collision with bottom of paddle
		if (ballX + ballDiameter >= paddleX
				&& ballX + ballDiameter <= paddleX + paddleWidth
				&& ballY >= paddleY && ballY <= paddleY + paddleHeight) {
			velocityY = change;
			hits++;
		}
		// collision with top of paddle
		if (ballY + ballDiameter >= paddleY && ballX >= paddleX
				&& ballX <= paddleX + paddleWidth
				&& ballY + ballDiameter <= paddleY + paddleHeight) {
			velocityY = -change;
			hits++;
		}
		// bounce into right wall
		if (ballX > width - ballDiameter) {
			ballX = width - ballDiameter;
			velocityX = -change;
		}
		// bounce into left wall
		if (ballX < 0) {
			ballX = 0;
			velocityX = change;
		}
		// bounce into bottom wall
		if (ballY > height - ballDiameter && velocityY >= 0) {
			ballY = height - ballDiameter;
			velocityY = -change;
		}
		// bounce into top wall
		if (ballY < 0) {
			ballY = 0;
			velocityY = change;
		}
	}

	public void gotThePower() {
		switch (powerup) {
		case 1:
			velocityX *= 1.5; // time warp (speeds up ball)
			velocityY *= 1.5;
			break;
		case 2: // do something
			break;
		case 3: // do something
			break;
		case 4: // do something
			break;
		default: // do nothing
			break;
		}

		powerup = 0;
	}

	// Lots of getters and a couple setters.

	public double getBallX() {
		return ballX;
	}

	public double getBallY() {
		return ballY;
	}

	public int getBallDiameter() {
		return ballDiameter;
	}

	public double getPaddleX() {
		return paddleX;
	}

	public double getPaddleY() {
		return paddleY;
	}

	public int getPaddleWidth() {
		return paddleWidth;
	}

	public int getPaddleHeight() {
		return paddleHeight;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getHits() {
		return hits;
	}

	public int getMisses() {
		return misses;
	}

	public boolean getPause() {
		return pause;
	}

	public void setSize(int width, int length) {
		this.width = width;
		this.height = length;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}
}
