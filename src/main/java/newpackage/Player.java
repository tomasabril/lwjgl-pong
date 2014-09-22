package newpackage;

/**
 *
 * @author tomas
 */
public class Player extends GameObject {

	public static final int sizex = 16;
	public static final int sizey = sizex * 7;
	public static final float speed = 4;
	private Ball ball;

	public Player(float x, float y, Ball ball) {
		this.x = x;
		this.y = y;

		this.sx = sizex;
		this.sy = sizey;

		this.ball = ball;
	}

	@Override
	void update() {
		if (Physics.checkCollisions(this, ball)) {
			ball.reverseX(getCenterY());
			if (ball.velx > 0) {
				ball.velx += 0.25f;
			}
			if (ball.velx < 0) {
				ball.velx -= 0.25f;
			}
		}

	}

	public void move(float mag) {
		y += speed * mag;
	}

}
