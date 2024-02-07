package com.github.hummel.wt.lab1.task9;

import com.github.hummel.wt.lab1.task9.content.Ball;
import com.github.hummel.wt.lab1.task9.content.Bucket;

import java.awt.*;

public class Main {
	public static final Bucket bucket = new Bucket(22);

	private Main() {
	}

	public static void main(String[] args) {
		initBucket();

		System.out.println(getQuantity(bucket, Color.BLUE));
	}

	public static void initBucket() {
		var balls = new Ball[]{new Ball(1, Color.GREEN), new Ball(2, Color.BLUE), new Ball(3, Color.GREEN), new Ball(13, Color.GREEN)};

		for (var ball : balls) {
			bucket.addBall(ball);
		}
	}

	public static int getQuantity(Bucket bucket, Color color) {
		return bucket.findQuantity(color);
	}
}
