Feature: Login feature

#  CUCUMBER_PUBLISH_ENABLED=true;CUCUMBER_PUBLISH_TOKEN=bc3f277e-3114-461c-ad17-6af2ca084fbe

  Scenario: Valid user login feature
    Given Use has logged into the system
    When  User provide valid credentials
    And  Click login button
    Then  User should see welcome message in landing page

  Scenario: Valid user login feature2
    Given Use has logged into the system
    When  User provide valid credentials
    And  Click login button
    Then  User should see welcome message in landing page