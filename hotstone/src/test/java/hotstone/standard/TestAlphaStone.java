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
 * tester test 
 */

package hotstone.standard;

/**
 * Skeleton class for AlphaStone test cases
 *
 *    This source code is from the book
 *      "Flexible, Reliable Software:
 *        Using Patterns and Agile Development"
 *      2nd Edition
 *    Author:
 *      Henrik Bærbak Christensen
 *      Department of Computer Science
 *      Aarhus University
 */

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hotstone.framework.Card;
import hotstone.framework.Game;
import hotstone.framework.Player;
import hotstone.framework.Status;
import hotstone.utility.TestHelper;

/** Template for your own ongoing TDD process.
 * Fill it out until you have covered all
 * requirements for the alpha stone game.
 */
public class TestAlphaStone {
  private Game game;

  /** Fixture for AlphaStone testing. */
  @BeforeEach
  public void setUp() {
    game = new StandardHotStoneGame();
    TestHelper.printGameState(game);
  }

  // Example of an early, simple test case:
  // Turn handling
  @Test
  public void shouldHaveFindusAsFirstPlayer() {
    // Given a game
    // When I ask for the player in turn
    Player player = game.getPlayerInTurn();
    // Then it should be Findus
    assertThat(player, is(Player.FINDUS));
  }


  // Example of a later, more complex, test case:
  // Card handling

  // The HotStone specs are quite insisting on how
  // the cards, drawn from the deck, are organized
  // in the hand. So when drawing the top three cards
  // from the deck (uno, dos, tres) they have to
  // be organized in the hand as
  // index 0 = tres; index 1 = dos; index 2 = uno
  // That is, a newly drawn card is 'at the top'
  // of the hand - always entered at position 0
  // and pushing the rest of the cards 1 position
  // 'down'
  @Test
  public void shouldHaveThreeCardsInHandInitially() {
    // Given a game, Findus has 3 cards in hand
    int count = game.getHandSize(Player.FINDUS);
    assertThat(count, is(3));
    // And these are ordered Tres, Dos, Uno in slot 0,1,2

    // When I pick card 0
    // Card card = game.getCardInHand(Player.FINDUS, 0);
    // Then is it Tres
    // ENABLE TO START TDD'ing
    // assertThat(card.getName(), is(GameConstants.TRES_CARD));
  }

  @Test
  public void shouldChangePlayerOnEndTurn() {
    // Check that Findus starts the game
    assertThat(game.getPlayerInTurn(), is(Player.FINDUS));
    // End turn
    game.endTurn();
    // Check that the player in turn is switched to Peddersen
    assertThat(game.getPlayerInTurn(), is(Player.PEDDERSEN));
    System.out.println("Test player change Ok👍");
  }

  @Test 
  public void shouldReturnWholeHand(){
    // Casts game as standard game, so hand is available
    StandardHotStoneGame sgame = (StandardHotStoneGame) game;
    // Check that we are able to return the whole hand
    assertThat(game.getHand(Player.FINDUS), is(sgame.hand));
  }

  @Test
  public void startingHandConfigurationForFindus() {
    // Casts game to StandardHotStoneGame
    StandardHotStoneGame sgame = (StandardHotStoneGame) game;
    // Takes starting hand
    List<Card> check = sgame.hand;
    int i = 0;
    // For each card in hand
    while (i <= 2) {
      // Check it is the correct card
      assertThat(game.getCardInHand(Player.FINDUS, i), is(check.get(i)));
      // Print card
      System.out.println(sgame.getCardInHand(Player.FINDUS, i));
      // Iterate i
      i ++;
    }
  }

  @Test
  public void shouldReturnCardName(){
    // Initialize check card
    Card dos = new StandardCard(2);
    // Check name
    assertThat(dos.getName(), is("Dos"));
    // Check other values
    assertThat(dos.getAttack(), is(2));
    assertThat(dos.getHealth(), is(2));
    assertThat(dos.getManaCost(), is(2));
  }

  @Test
  public void shouldReduceAmountOfMana() {

    // Advance to round 3
    TestHelper.advanceGameNRounds(game, 2);
    assertThat(game.getTurnNumber(), is(4));
    // Check hero has 3 mana
    assertThat(game.getHero(Player.FINDUS).getMana(), is(3));
    // Play Dos
    game.playCard(Player.FINDUS, game.getCardInHand(Player.FINDUS, 1), 0);
    // Check mana reduced by 2
    assertThat(game.getHero(Player.FINDUS).getMana(), is(1));
    // Check hand size = 2
    assertThat(game.getHandSize(Player.FINDUS), is(2));
    // Check field size = 1
    assertThat(game.getFieldSize(Player.FINDUS), is(1));
  }

  @Test
  public void shouldnotallowbigmanacost() {
    assertThat(game.playCard(Player.FINDUS, new StandardCard(3), 0), is(Status.NOT_ENOUGH_MANA));
  }














}
