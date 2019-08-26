package set0000.set300.set350.p353;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by senyuanwang on 16/6/4.
 */
public class SnakeGame {
    private int width;
    private int height;
    private int x;
    private int y;
    private int[][] food;
    private int foodAt;
    private List<int[]> snake;
    private int score;

    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.food = food;
        this.foodAt = 0;
        this.snake = new LinkedList<>();
        moveSnake(x, y, true);
    }

    private boolean moveSnake(int x, int y, boolean grow) {
        int[] newPos = {x, y};
        this.snake.add(newPos);
        if (!grow) {
            this.snake.remove(0);
        }

        for (int i = 0; i < snake.size() - 1; i++) {
            int[] at = snake.get(i);
            if (at[0] == x && at[1] == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        switch (direction) {
            case "U":
                x = x - 1;
                break;
            case "L":
                y = y - 1;
                break;
            case "R":
                y = y + 1;
                break;
            case "D":
                x = x + 1;
                break;
        }

        if (x < 0 || x >= height) {
            return -1;
        }
        if (y < 0 || y >= width) {
            return -1;
        }

        boolean grow = false;

        if (foodAt < food.length) {
            int[] currentFood = food[foodAt];
            if (currentFood[0] == x && currentFood[1] == y) {
                grow = true;
            }
        }
        boolean biteSelf = moveSnake(x, y, grow);
        if (biteSelf) {
            return -1;
        }

        if (grow) {
            score += 1;
            foodAt += 1;
        }

        return score;
    }

    public static void main(String[] args) {
        SnakeGame snakeGame = new SnakeGame(3, 3, new int[][]{{2, 0}, {0, 0}, {0, 2}, {2, 2}});

        String[] directions = new String[]{"D", "D", "R", "U", "U", "L", "D", "R", "R", "U", "L", "D" };

        for (String dir : directions) {
            int score = snakeGame.move(dir);
            System.out.printf("%d ", score);
        }
    }
}
