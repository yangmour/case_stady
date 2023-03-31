package com.xiwen;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/20 -11:37
 * @Version: 1.0
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {
    private static final int SPEED = 10;
    private static final int SIZE = 10;
    private static final Color COLOR = Color.YELLOW;

    private int x, y;
    private int direction;
    private Rectangle rectangle;

    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        rectangle = new Rectangle(x, y, SIZE, SIZE);
    }

    public void draw(Graphics g) {
        g.setColor(COLOR);
        g.fillOval(x, y, SIZE, SIZE);
    }

    public void move() {
        switch (direction) {
            case PlayerTank.LEFT:
                x -= SPEED;
                break;
            case PlayerTank.RIGHT:
                x += SPEED;
                break;
            case PlayerTank.UP:
                y -= SPEED;
                break;
            case PlayerTank.DOWN:
                y += SPEED;
                break;
        }
        rectangle.setLocation(x, y);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}