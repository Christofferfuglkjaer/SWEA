package hotstone.standard;

import hotstone.framework.Card;
import hotstone.framework.Player;
import java.util.*;

public class StandardCard implements Card {
    // Initialize variables
    private String name;
    private int manaCost;
    private int attack;
    private int health;
    private boolean active;
    private Player owner;
    private String effect;

    public StandardCard(int i){
        // Pull card info from CardConstants
        CardConstants cc = new CardConstants();
        List<Object> cardInfo = cc.getCardInfo(i);
        this.name = (String) cardInfo.get(0);
        this.manaCost = (int) cardInfo.get(1);
        this.attack = (int) cardInfo.get(2);
        this.health = (int) cardInfo.get(3);
    }
    public String getName() {
        return name;
    }

    public int getManaCost() {
        return manaCost;
    }

  
    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }
    
    public boolean isActive() {
        return active;
    }

    public Player getOwner() {
        return owner;
    }

    public String getEffectDescription() {
        return effect;
    }

}
