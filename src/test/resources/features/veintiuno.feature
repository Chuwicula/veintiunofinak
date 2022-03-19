Feature: Dealer for 21

  Scenario: Deal initial cards
    Given a dealer
    When the round starts
    Then the dealer should have 2 cards

  Scenario Outline: Get hand total
    Given a <hand>
    When the dealer sums the cards
    Then the dealer should have a <total>
    Examples: Hands
      | hand  | total |
      | '5'     | 5     |
      | 'A,A'   | 12    |
      | 'A,2'   | 13    |
      | 'A,2'   | 13    |
      | 'Q,K'   | 20    |
      | 'K,K,A' | 21    |
      | 'K,K,Q' | 30    |

  Scenario Outline: Dealer plays by the rules
    Given a hand <total>
    When the dealer plays
    Then the dealer should play <action>
    Examples: Dealer plays
    |total|action|
    |12   |hit   |
    |13   |hit   |
    |20   |stand |
    |21   |stand |
    |22   |stand |
    |8    |hit   |
    |9    |hit   |


