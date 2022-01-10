Feature: Product Store

  Scenario: Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart" and accept pop up confirmation.
    Given I navigate main Product store page
    And I click on laptop tab
    And I click on "Sony vaio i5" item
    When I click Add Button
    Then I verify that popup window opens
    When I navigate main Product store page
    And I click on laptop tab
    And I click on "Dell i7 8gb" item
    When I click Add Button
    Then I verify that popup window opens
    When I click on Cart tab