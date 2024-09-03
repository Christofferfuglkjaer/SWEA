package hotstone.standard;

import hotstone.framework.Hero;
import hotstone.framework.Player;

public class StandardHero implements Hero {
    
    public int ManaCount = 1; 
    
    /** Get the amount of mana this hero has available
     * for playing cards to the field.
    */

    public int getMana() {
        return ManaCount;
    }

    /** Get the value of health of this hero.
     *
     * 
     */
    public int getHealth() { return 0; }

    /** Get the state of the Hero's ability to use
     * his/her hero power. If true, the hero has not
     * yet used the hero power in this turn.
     * true if the hero is able to use the hero power,
     * false otherwise
     */
    public boolean canUsePower() { return true; }

    /** Get the type of the hero. Type is a
     * string value to be open for new hero types.
     * Default hero types are defined in GameConstants.
     *
     * the type of hero
     */
    public String getType() { return GameConstants.BABY_HERO_TYPE; }

    /** Get the owner of this hero.
     *
     *  the player having this hero
     */
    public Player getOwner() { return Player.FINDUS; }

    /** Get the text describing the hero's power
     *  short description of hero power/effect
     */
    public String getEffectDescription() { return "just cute"; }

}