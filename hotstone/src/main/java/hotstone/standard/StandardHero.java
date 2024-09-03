package hotstone.standard;

import hotstone.framework.Player;
import hotstone.framework.Hero;

import java.util.*;

import hotstone.framework.Game;

public class StandardHero implements Hero {
    
    public int ManaCount; 
    
    /** Get the amount of mana this hero has available
     * for playing cards to the field.
    */

    public int getMana(){
        
        return ManaCount;
    };
        

    /** Get the value of health of this hero.
     *
     * @return the value of health
     */
    public int getHealth(){};

    /** Get the state of the Hero's ability to use
     * his/her hero power. If true, the hero has not
     * yet used the hero power in this turn.
     * @return true if the hero is able to use the hero power,
     * false otherwise
     */
    public boolean canUsePower(){};

    /** Get the type of the hero. Type is a
     * string value to be open for new hero types.
     * Default hero types are defined in GameConstants.
     *
     * @return the type of hero
     */
    public String getType(){};

    /** Get the owner of this hero.
     *
     * @return the player having this hero
     */
    public Player getOwner(){};

    /** Get the text describing the hero's power
     * @return short description of hero power/effect
     */
    public String getEffectDescription(){};

}