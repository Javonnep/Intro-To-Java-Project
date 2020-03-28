package game;

import city.cs.engine.*;

import static game.Game.getPlayer;

public class PlayableCharacter extends Walker {
    private static Boolean specialGravity = false;
    private static int itemsCollected = 0;
    private Game game;
    private static final Shape llamaShape = new PolygonShape(-0.6f,-1.03f, 0.53f,-1.01f, 0.53f,1.24f, -0.6f,1.24f);
    private static final BodyImage llamaImage = new BodyImage("data/standRight2.png",3);

    // constructor
    public PlayableCharacter(World world, int itemsCollected, Boolean specialGravity, Game game) {
        super(world, llamaShape);
        this.game = game;
        this.itemsCollected = itemsCollected;
        this.specialGravity = specialGravity;
        addImage(llamaImage);
    }

    public static boolean isSpecialGravity() {
        return specialGravity;
    }

    public void setSpecialGravity(boolean specialGravity) {
        this.specialGravity = specialGravity;
    }

    public static int getItemsCollected() {
        if (Game.getLevel() == 1){
            return Level1.getLevel1items();
        }
        else if (Game.getLevel() == 2){
            return Level2.getLevel2items();
        }
        else{
            return Level3.getLevel3items();
        }
    }

    public void newItemCollected(){
        itemsCollected++;
        Scoreboard scoreboard = new Scoreboard(getPlayer(), game);
        System.out.println("Score: " + scoreboard.getScore());
    }

}

// constructor
// fields
// super
// methods
// getter methods
// setter methods
