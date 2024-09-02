package hotstone.standard;

import hotstone.framework.Card;
import hotstone.framework.Player;

public class StandardCard implements Card {

    public StandardCard(String card){
        int health;
        int mana;
        int attack; 
        String name; 
    }
    public String getName() {
        Object card;
        return card.name;
    }

    public int getManaCost() {
        return 0;
    }

  
    public int getAttack() {
        return 0;
    }

    public int getHealth() {
        return 0;
    }
    
    public boolean isActive() {
        return false;
    }

    public Player getOwner() {
        return null;
    }

    public String getEffectDescription() {
        return null;
    }

}
