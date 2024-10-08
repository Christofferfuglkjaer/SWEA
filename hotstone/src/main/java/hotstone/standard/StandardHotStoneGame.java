/*
 * Copyright (C) 2022-2024. Henrik Bærbak Christensen, Aarhus University.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package hotstone.standard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hotstone.framework.Card;
import hotstone.framework.Game;
import hotstone.framework.Hero;
import hotstone.framework.Player;
import hotstone.framework.Status;


/** This is the 'temporary test stub' in TDD
 * terms: the initial empty but compilable implementation
 * of the game interface.
 *
 * It already includes a bit of FAKE-IT code for the first
 * test case about hand management and player in turn.
 *
 * Start solving the AlphaStone exercise by
 * following the TDD rhythm: pick a one-step-test
 * from your test list, quickly add a test,
 * run it to see it fail, and then modify this
 * implementing class (and supporting classes)
 * to make your test case run. Refactor and repeat.
 *
 * While this is the implementation of Game for
 * the AlphaStone game, you will constantly
 * refactor it over the course of the exercises
 * to become the 'core implementation' which will
 * enable a lot of game variants. This is also
 * why it is not called 'AlphaGame'.
 */
public class StandardHotStoneGame implements Game {
  // Initializes turn number
  private int turnNumber = 0;
  // Intializes cards and hand (FAKE IT)
  public Card uno = new StandardCard(1);
  public Card dos = new StandardCard(2);
  public Card tres = new StandardCard(3);
  public List<Card> hand = Arrays.asList(tres, dos, uno);

  public List<Card> field = new ArrayList<>();

  // Initialize hero
  public Hero hero = new StandardHero();

  @Override
  public Player getPlayerInTurn() {
    // Return Findus if turn number is even, else Peddersen
    return turnNumber % 2 == 0 ? Player.FINDUS : Player.PEDDERSEN;
  }

  @Override
  public Hero getHero(Player who) {
    return hero;
  }

  @Override
  public Player getWinner() {
    return null;
  }

  @Override
  public int getTurnNumber() {
    return turnNumber;
  }

  @Override
  public int getDeckSize(Player who) {
    return 0;
  }

  @Override
  public Card getCardInHand(Player who, int indexInHand) {
    return hand.get(indexInHand);
  }

  @Override
  public Iterable<? extends Card> getHand(Player who) {
    return hand;
  }

  @Override
  public int getHandSize(Player who) {
    return hand.size();
  } // FAKE-IT

  @Override
  public Card getCardInField(Player who, int indexInField) {
    return null;
  }

  @Override
  public Iterable<? extends Card> getField(Player who) {
    return field;
  }

  @Override
  public int getFieldSize(Player who) {
    return field.size();
  }

  @Override
  public void endTurn() {
    // Iterate turn number
   turnNumber ++;
   StandardHero shero = (StandardHero) getHero(getPlayerInTurn());
   shero.ManaCount = (turnNumber + 2) / 2;
  }

  @Override
  public Status playCard(Player who, Card card, int atIndex) {
    StandardHero shero = (StandardHero) getHero(getPlayerInTurn());
    // In the future we need to use atIndex to check is it is a legal move.
    if(card.getManaCost() > shero.ManaCount){return Status.NOT_ENOUGH_MANA;}
    hand.remove(card);
    field.add(card);
    shero.ManaCount -= card.getManaCost();
    return Status.OK;
  }

  @Override
  public Status attackCard(Player playerAttacking, Card attackingCard, Card defendingCard) {
    return null;
  }

  @Override
  public Status attackHero(Player playerAttacking, Card attackingCard) {
    return null;
  }

  @Override
  public Status usePower(Player who) {
    return null;
  }
}
