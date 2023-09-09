package by.bsuir.lab1.task9;

import java.awt.*;

public class Main {
	public static void main(String[] args) {
		Ball[] balls = {new Ball(1, Color.GREEN), new Ball(2, Color.BLUE), new Ball(3, Color.GREEN), new Ball(13, Color.GREEN)};

		Bucket bucket = new Bucket(22);

		for (Ball ball : balls) {
			bucket.addBall(ball);
		}

		System.out.println(bucket.findQuantity(Color.BLUE));
	}
}
