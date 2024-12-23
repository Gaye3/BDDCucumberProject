Feature: Create a multiple post

  Scenario Outline: user creates a multiple post
    When user click on create a new post
    Then A Create new post -Select type pop up should open
    When user click on mulitple choice
    Then Create new post -Select group pop up with drop down should open
    When User selects "<value>" and click on select
    Then Create new post -Write post should open
    When user enters "<question>" "<choice1>" "<choice2>" and click on publish post
    Then A new post with above data should be published

    Examples: 
      | value             | question | choice1 | choice2 |
      | Women in Business | testing  | option1 | option2 |
