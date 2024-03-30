@0_demo
  Feature: Check the greetings controller of demo-cli service
    Scenario Outline: Hit the greeting wish endpoint testing scenario
      Given Create a greeting request object with <greeting>, <name> and <message>
      When Call the greetings endpoint and fetch the result
      Then Validate the result is expected or not
      Examples:
        |   greeting     |   name   |    message    |
        | "Good Morning" | "Gourav" | "How are you" |
        | "Good Evening" | "Nikhil" |         ""    |

