Feature: meme feature

  Scenario: A user gets the memes
    Given the following memes
      | meme            | likes  |
      | scumbag man     | 3     |
      | bad luck brian  | 5     |
    When the user requests all the memes
    Then all the memes are returned