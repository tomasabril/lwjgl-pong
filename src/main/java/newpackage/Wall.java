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
public class Wall extends GameObject {
	
	private Ball ball;

	public Wall(float x, float y, float sx, float sy, Ball ball) {
		this.x = x;
		this.y = y;
		this.sx = sx;
		this.sy = sy;
		this.ball = ball;
	}

	@Override
	void update() {
		if (Physics.checkCollisions(this, ball)) {
			ball.reverseY();
		}
	}

}
