Flag Guessing Game (Android)

Overview
The Flag Guessing Game is an interactive Android-based app developed using Kotlin and Jetpack Compose, intended for testing your world geography skills. 
The app displays several national flags and requires you to guess the corresponding countries. 
It has a dynamic user interface, real-time feedback, and an integrated learning process for any incorrect answers.

Key Features
- Dynamic Flag Interface: A random selection of flags from an internal list of countries (for example, Andorra, UAE, Afghanistan) to present a new set of flags for guessing.
- Real-Time Validation: Your answers are validated in real-time, providing instant feedback.
- Three-Attempt Mechanism: You can enter up to three incorrect answers for each round before the correct answers are revealed.
- Dynamic Interface: Built using Jetpack Compose for a seamless user experience and clean, modern code.

How to Play
- View the Flags: A list of national flags appears on the screen to begin the Flag Guessing Game.
- Enter Your Answers: Enter the names of the countries corresponding to the flags in the designated boxes.
- Submit: You can submit your answers by clicking on the Submit button.
- Feedback:
  - Correct: A green “CORRECT!” appears on the screen.
  - Incorrect: A red “WRONG!” appears on the screen.
- Learn from Mistakes: If you are not able to identify all the flags correctly in three attempts, the correct flag names appear on the screen in blue color for the next round.
- Move to Next Round: You can move to the next round by clicking on the Next button.

Developer Setup & Technical Details
- Programming Language: Kotlin
- Programming Framework: Jetpack Compose for a more modern and reactive approach
- Data Structure:
  - Flag Data Class: A flag is represented by linking the resource ID of the flag image and the name of the country.
- Prerequisites:
  - IDE: Android Studio
  - SDK: Android SDK with API level suitable for Jetpack Compose
  - Resources: Flag images are kept in the drawable folder
