package newpackage;

/**
 *
 * @author tomas
 */
public class Ball extends GameObject {

	public static final int size = 16;
	public static final float MAX_VELX = 4;
	public static final float MAX_VELY = 8;
	public static final float DAMPING = 0.05f;

	public float velx;
	public float vely;
	public float startX;
	public float startY;

	public Ball(float x, float y) {
		this.x = x;
		this.y = y;
		startX = x;
		startY = y;

		this.sx = size;
		this.sy = size;
		velx = -MAX_VELX;
		vely = 0;
	}

	@Override
	public void update() {
		x += velx;
		y += vely;
	}

	void resetPosition() {
		x = startX;
		y = startY;
		vely = 0;
		velx *= -1;
	}

	public void reverseX(float center) {
		velx *= -1;
		vely += (getCenterY() - center) * DAMPING;
		if (vely > MAX_VELY) {
			vely = MAX_VELY;
		}
		if (velx > MAX_VELX) {
			velx = MAX_VELX;
		}
	}

	public void reverseY() {
		vely *= -1;
	}

}
