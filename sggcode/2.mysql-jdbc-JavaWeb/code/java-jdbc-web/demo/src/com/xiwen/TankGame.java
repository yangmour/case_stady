package com.xiwen;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/03/20 -11:29
 * @Version: 1.0
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class TankGame extends JPanel implements ActionListener {
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;
    private static final int DELAY = 25;
    private final PlayerTank playerTank;
    private final ArrayList<EnemyTank> enemyTanks;
    private Bullet bullet;
    private boolean running = false;
    private Timer timer;

    public TankGame() {
        playerTank = new PlayerTank();
        enemyTanks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            enemyTanks.add(new EnemyTank(100 + i * 150, 50, 0));
        }
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            playerTank.draw(g);
            for (int i = 0; i < enemyTanks.size(); i++) {
                enemyTanks.get(i).draw(g);
            }
            if (bullet != null) {
                bullet.draw(g);
            }
        } else {
            gameOver(g);
        }
    }

    public void move() {
        playerTank.move();
        for (int i = 0; i < enemyTanks.size(); i++) {
            enemyTanks.get(i).move();
        }
        if (bullet != null) {
            bullet.move();
        }
    }

    public void checkCollisions() {
        Rectangle playerRect = playerTank.getRectangle();
        for (int i = 0; i < enemyTanks.size(); i++) {
            if (playerRect.intersects(enemyTanks.get(i).getRectangle())) {
                running = false;
            }
        }
        if (bullet != null) {
            Rectangle bulletRect = bullet.getRectangle();
            for (int i = 0; i < enemyTanks.size(); i++) {
                if (bulletRect.intersects(enemyTanks.get(i).getRectangle())) {
                    enemyTanks.remove(i);
                    bullet = null;
                    break;
                }
            }
        }
        if (!running) {
            timer.stop();
        }
    }

    public void gameOver(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics1.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Enemies Destroyed: " + (5 - enemyTanks.size()), (SCREEN_WIDTH - metrics2.stringWidth("Enemies Destroyed: " + (5 - enemyTanks.size()))) / 2, SCREEN_HEIGHT / 2 + g.getFont().getSize());
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (running) {
            move();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    playerTank.setDirection(PlayerTank.LEFT);
                    break;
                case KeyEvent.VK_RIGHT:
                    playerTank.setDirection(PlayerTank.RIGHT);
                    break;
                case KeyEvent.VK_UP:
                    playerTank.setDirection(PlayerTank.UP);
                    break;
                case KeyEvent.VK_DOWN:
                    playerTank.setDirection(PlayerTank.DOWN);
                    break;
                case KeyEvent.VK_SPACE:
                    if (bullet == null) {
                        bullet = new Bullet(playerTank.getX(), playerTank.getY(), playerTank.getDirection());
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tank Game");
        TankGame game = new TankGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}