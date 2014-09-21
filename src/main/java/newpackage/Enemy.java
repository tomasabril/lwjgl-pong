/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author tomas
 */
public class Enemy extends GameObject {

	public static final int sizex = 16;
	public static final int sizey = sizex * 7;
	public static final float speed = 4;
	private Ball ball;

	public Enemy(float x, float y, Ball ball) {
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
		}
		if (getCenterY() - ball.getCenterY() < 0) {
			move(1);
		}
		if (getCenterY() - ball.getCenterY() > 0) {
			move(-1);
		}
	}

	public void move(float mag) {
		y += speed * mag;
	}
}
