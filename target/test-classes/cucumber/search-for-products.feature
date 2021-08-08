Feature: Add address
  Scenario: test
    Given Page https://prod-kurs.coderslab.pl/index.php opened in browser
    When Sign in link clicked on home page
    And email entered in login form email input
    And password entered in login form password input
    And SignIn button clicked
    Then find cloths you want
    And check if you found your product
    And click your product
    And select size
    And add the product to the cart and checkout
    Then finalize shopping
    And take screen shot and quit
    And close
