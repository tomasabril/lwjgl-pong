package newpackage;

import java.util.ArrayList;
import java.util.List;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

/**
 *
 * @author Tomás Abril
 */
public class Game {

	private List<GameObject> objects;
	Player player1;
	Ball ball;
	private int playerScore;
	private int enemyScore;

	public Game() {
		playerScore = 0;
		enemyScore = 0;

		objects = new ArrayList<>();
		ball = new Ball(Display.getWidth() / 2 - Ball.size / 2,
			Display.getHeight() / 2 - Ball.size / 2);
		objects.add(ball);

		player1 = new Player(5,
			Display.getHeight() / 2 - Player.sizey / 2, ball);
		objects.add(player1);

		Enemy enemy = new Enemy(Display.getWidth() - Enemy.sizex - 5,
			Display.getHeight() / 2 - Enemy.sizey / 2, ball);
		objects.add(enemy);

		Wall wallBottom = new Wall(0, 0,
			Display.getWidth(),
			16,
			ball);
		objects.add(wallBottom);

		Wall wallUp = new Wall(0, Display.getHeight() - 16,
			Display.getWidth(),
			16,
			ball);
		objects.add(wallUp);

	}

	public void getInput() {
		if (Keyboard.isKeyDown(Keyboard.KEY_W)
			|| Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			player1.move(1);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)
			|| Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			player1.move(-1);
		}
	}

	public void update() {
		for (GameObject g : objects) {
			g.update();
		}
		if(ball.getX() > Display.getWidth()){
			playerScore ++;
			ball.resetPosition();
		}
		if(ball.getX() < 0){
			enemyScore++;
			ball.resetPosition();
		}
	}

	public void render() {
		for (GameObject g : objects) {
			g.render();
		}
		Display.setTitle("lwjgl-Pong| Score: " 
			+ playerScore + " x " + enemyScore
			+ "   _ Tomás");
	}
}
