package ca.hotdang.carddeck;

import ca.hotdang.carddeck.DeckOfCards;
import ca.hotdang.carddeck.Card;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/deck")
public class CardController {

  /**
    * Current server-instance of a single deck of cards
    */
  private static DeckOfCards deckOfCards;

  @GetMapping
  @ResponseBody
  public ArrayList<Card> deck() {
    if (deckOfCards == null || deckOfCards.length() == 0) {
      deckOfCards = new DeckOfCards();
    }

    return deckOfCards.getDeck();
  }

  @GetMapping("/new")
  @ResponseBody
  public ArrayList<Card> newDeck() {
    deckOfCards = new DeckOfCards();
    return deckOfCards.getDeck();
  }

  @GetMapping("/shuffle")
  @ResponseBody
  public ArrayList<Card> shuffle() {
    if (deckOfCards == null || deckOfCards.length() == 0) {
      deckOfCards = new DeckOfCards();
    }

    deckOfCards.shuffle();

    return deckOfCards.getDeck();
  }

  @GetMapping("/describe")
  @ResponseBody
  public ArrayList<String> describedDeck(@RequestParam(value = "type") String type) {
    boolean isShortDescription = false;

    if (deckOfCards == null || deckOfCards.length() == 0) {
      deckOfCards = new DeckOfCards();
    }

    if (type != null && type.equals("short")) {
      isShortDescription = true;
    }

    return deckOfCards.getDescribedDeck(isShortDescription);
  }

  @GetMapping("/deal")
  @ResponseBody
  public ArrayList<Card> deal(@RequestParam(required=false, value = "number") Integer number) {
    if (deckOfCards == null || deckOfCards.length() == 0) {
      deckOfCards = new DeckOfCards();
    }

    ArrayList<Card> dealtCards = new ArrayList<Card>();

    if (number == null) {
      number = 0;
    }

    if (number >= deckOfCards.length()) {
      number = deckOfCards.length();
    }

    for (int i = number; i >= 0; i--) {
      try {
        dealtCards.add(deckOfCards.dealCardAtIndex(0));
      } catch (java.lang.IndexOutOfBoundsException e) {
        // no more cards
      }
    }

    return dealtCards;
  }
}
