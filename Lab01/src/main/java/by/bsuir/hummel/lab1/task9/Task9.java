package by.bsuir.hummel.lab1.task9;

import by.bsuir.hummel.lab1.task9.content.Ball;
import by.bsuir.hummel.lab1.task9.content.Bucket;

import java.awt.*;

public class Task9 {
	public static void main(String[] args) {
		Ball[] balls = {new Ball(1, Color.GREEN), new Ball(2, Color.BLUE), new Ball(3, Color.GREEN), new Ball(13, Color.GREEN)};

		Bucket bucket = new Bucket(22);

		for (Ball ball : balls) {
			bucket.addBall(ball);
		}

		System.out.println(bucket.findQuantity(Color.BLUE));
	}
}
