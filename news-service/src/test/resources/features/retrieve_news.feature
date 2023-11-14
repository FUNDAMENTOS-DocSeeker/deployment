Feature: See relevant news about health and fitness
  The News service stores and retrieves news articles from the database.
  Users can stay up-to-date with the latest news about health and fitness around the world.

  Scenario: User is shown the latest news about health and fitness
    Given the user is on the home page
    When the user clicks on the news button
    Then the user is shown the latest news about health and fitness