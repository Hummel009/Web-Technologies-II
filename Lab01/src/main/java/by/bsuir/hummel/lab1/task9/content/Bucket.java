package by.bsuir.hummel.lab1.task9.content;

import java.awt.*;
import java.util.Collection;
import java.util.HashSet;

public class Bucket {
	private int capacity;
	private int weight;
	private Collection<Ball> balls = new HashSet<>(capacity);

	public Bucket(int capacity) {
		this.capacity = capacity;
	}

	public void addBall(Ball ball) {
		if (weight + ball.getMass() <= capacity) {
			balls.add(ball);
			weight += ball.getMass();
		} else {
			System.out.print("That's impossible to add new ball.");
		}
	}

	public int findQuantity(Color color) {
		int k = 0;
		for (Ball ball : balls) {
			if (ball.getColor().equals(color)) {
				k++;
			}
		}
		return k;
	}

	public int getWeight() {
		return weight;
	}
}
