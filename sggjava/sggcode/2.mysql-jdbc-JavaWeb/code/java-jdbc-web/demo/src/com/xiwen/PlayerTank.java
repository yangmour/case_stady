package com.xiwen;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/20 -11:32
 * @Version: 1.0
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerTank {
    private static final int SPEED = 5;
    private static final int SIZE = 50;
    private static final Color COLOR = Color.BLUE;

    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;

    private int x, y;
    private int direction;
    private Rectangle rectangle;

    public PlayerTank() {
        x = 100;
        y = TankGame.SCREEN_HEIGHT - SIZE - 50;
        direction = UP;
        rectangle = new Rectangle(x, y, SIZE, SIZE);
    }

    public void draw(Graphics g) {
        g.setColor(COLOR);
        g.fillRect(x, y, SIZE, SIZE);
    }

    public void move() {
        switch (direction) {
            case LEFT:
                x -= SPEED;
                if (x < 0) {
                    x = 0;
                }
                break;
            case RIGHT:
                x += SPEED;
                if (x + SIZE > TankGame.SCREEN_WIDTH) {
                    x = TankGame.SCREEN_WIDTH - SIZE;
                }
                break;
            case UP:
                y -= SPEED;
                if (y < 0) {
                    y = 0;
                }
                break;
            case DOWN:
                y += SPEED;
                if (y + SIZE > TankGame.SCREEN_HEIGHT) {
                    y = TankGame.SCREEN_HEIGHT - SIZE;
                }
                break;
        }
        rectangle.setLocation(x, y);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
