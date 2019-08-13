  Feature: Test first API
    @Credentials

    Scenario Outline: A user wants to read post in their timeline
      Given I want to operate on "jsonplaceholder.typicode.com"
      When I get the body of "<endpoint>" number "<num>"
      Then I can see the response "<value>" in "<field>" is "<bool>"

      Examples:
      | endpoint  | num | field     | value                                                                     | bool|
      | albums    | 2   | title     | sunt qui excepturi placeat culpa                                          | true|
      | comments  | 12  | name      | modi ut eos dolores illum nam dolor                                       | true|
      | photos    | 34  | title     | vitae est facere quia itaque adipisci perferendis id maiores              | true|
      | todos     | 6   | title     | qui ullam ratione quibusdam voluptatem quia omnis                         | true|
      | posts     | 1   | title     | sunt aut facere repellat provident occaecati excepturi optio reprehenderit| true|
      | users     | 5   | username  | Kamren                                                                    | true|

    Scenario: A user wants to delete posts in the timeline
      Given I want to operate on "jsonplaceholder.typicode.com"
      When I delete the body of "comments" number "12"

      When I get the body of "comments" number "12"
      Then I can see the response "modi ut eos dolores illum nam dolor" in "name" is "true"

    Scenario: A user wants to patch an entry in their album
      Given I want to operate on "jsonplaceholder.typicode.com"
      And I want to intitialise a patch request to "albums" with "the lazy fox" in "title"
      When I patch the body of "albums" number "2"
      Then I can see the response "the lazy fox" in "title" is "true"

      When I get the body of "albums" number "2"
      Then I can see the response "the lazy fox" in "title" is "false"

    Scenario: A user wants to post an entry in their album
      Given I want to operate on "jsonplaceholder.typicode.com"
      And I want to intitialise a post request to "albums" with "title" to "101"
      When I post the body of "albums" number "101" with status "200"
      Then I can see the response "Le coeur a ses raisons que le raison ne connait point" in "title" is "true"

      When I get the body of "albums" number "101" with "404"


    Scenario: A user wants to put an entry in their album
      Given I want to operate on "jsonplaceholder.typicode.com"
      And I want to intitialise a put request to "albums" with "trust the process" in "title" to "3"
      When I put the body of "albums" number "3"
      Then I can see the response "trust the process" in "title" is "true"

      When I get the body of "albums" number "3"
      Then I can see the response "trust the process" in "title" is "false"




