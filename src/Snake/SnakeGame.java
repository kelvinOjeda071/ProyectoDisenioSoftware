package Snake;

<<<<<<< Updated upstream

import static Snake.Snake.r;
import java.awt.Point;
import java.util.ArrayList;

public class SnakeGame {
    Board board;
    Snake snake; 
    Food food;
    Enemy enemy;
    Entity entity;
    public void startGame(){
        snake = new Snake();    
        board = new Board("Slither.io");
        food = new Food();
        enemy = new Enemy();

        board.snake = snake; 
        snake.board = board;
        
        board.food = food; 
        
        board.enemy = enemy;
        enemy.board = board;
        
        snake.snake = new ArrayList<>();
        enemy.enemy = new ArrayList<>();
        food.food = new ArrayList<>();
        
        snake.snake.add(new Point(500, 500));
        enemy.enemy.add(new Point(r.nextInt(900), r.nextInt(900)));

        snake.start();
        food.start();
        enemy.start();
        //finishGame();
        while(true){
             getScore();
        }
       
    }
    
    public void getScore(){
        System.out.println("Puntaje por comida" + snake.score());
    }
    
    /*
    public void finishGame()
        board.controlSize();
    }*/
    
}
=======
public class SnakeGame {
    public static void main(String[] args) {
        Game c = new Game();
        c.startGame();
    }
}
>>>>>>> Stashed changes
