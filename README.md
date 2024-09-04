# 1. TDD 
## 1.1 TDD status 
### lavet 

* Given an initialized game, Then Findus is player in turn [✅]
* When Findus ends its turn, Then it is Peddersen in turn [✅]
* Given Card Dos Then it has attributes (2,2,2) [✅]
* When game starts Then Findus should have three cards in hand, Tres at index 0, Dos at index 1, and Uno at index 2. [✅]
* When Peddersen plays Dos, Then the mana available is two less.[✅]
* field size og hand size[✅].


### mangler
* Given a game When Findus plays Uno, Then it is allowed (Status.OK), and Then minion Uno appears at index 0 on the field[].
* When Findus plays a card, Then Peddersen still has 3 cards in his hand[].
* lavet dæk, og man trækker et kort når modstanderen bruger `end turn`[].
* man har altid 3 eller mindre mana og 21 hp[].
* når man ligger et kort i field så fjenes den fra hånden[].
* attack hero og attack card[].
* use hero power[]. 
* get winner[]. 



