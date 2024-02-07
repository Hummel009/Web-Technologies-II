package com.github.hummel.wt.lab1.task9.content;

import java.awt.*;
import java.util.Collection;
import java.util.HashSet;

public class Bucket {
	private final int capacity;
	private final Collection<Ball> balls;
	private int weight;

	public Bucket(int capacity) {
		this.capacity = capacity;
		balls = new HashSet<>(capacity);
	}

	public void addBall(Ball ball) {
		if (weight + ball.mass() <= capacity) {
			balls.add(ball);
			weight += ball.mass();
		} else {
			System.out.print("That's impossible to add new ball.");
		}
	}

	public int findQuantity(Color color) {
		var k = 0;
		for (var ball : balls) {
			if (ball.color().equals(color)) {
				k++;
			}
		}
		return k;
	}

	public int getWeight() {
		return weight;
	}
}
