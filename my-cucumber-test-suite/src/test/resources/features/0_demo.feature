@0_demo
  Feature: Check the greetings controller of demo-cli service
    Scenario Outline: Hit the greeting wish endpoint testing scenario
      Given Create a greeting request object with <greeting>, <name> and <message>
      When Call the greetings endpoint with <lines>, <salary>, <new_line> and fetch the result
      Then Validate the result is expected or not
      Examples:
        |   greeting     |   name   |    message    | lines | salary | new_line |
        | "Good Morning" | "Gourav" | "How are you" |  3    | 23.5   | 12       |
        | "Good Evening" | "Nikhil" |         ""    |  2    | 34.6   | 45       |

