# Game(league of legends) Queue implementation

## 1. Project Description
- This project enables the user to understand how a real life game queue works by randomly adding hundred players, then asking the user if they want to display the players in queue, make a match, genenerate new players or finally exit the queue. 

## 2. Tech Stack/ Language
- Language: Java 
- IDE: Visual Studio Code

## 3. File Structure
- Main.java
- MyQueue.java
- Player.java

## 4. Features
- genPlayer(MyQueue match): Generates 100 players with random tiers, names or time.
- tenPlayers(): Allows the user to take the first ten players in the front.
- dequeue(): Removes and returns the player at the front of the queue.
- enqueue(): Adds a player at the rear of the queue.
- printMatch(Player[] dataTen): Prints a single match that is happening between the players. 
- Command line interface menu: asks the user either to show players, make matches, generate new players, or exit.
- print(): prints the players left in the queue.
- mergeSort(): Sorts the players in a way of rank, if their rank is the same the person who waited more comes first

## 5. Concepts Used
- Command line interface menu: to display what options the user has
- Queue System(First in First out): the first player that is in the queue is the first player to get out
- Random System : randomizes the tier, name, time of the player.
- Greedy algorithm: makes the best local decision at each step.
- Merge Sort: being able to sort the array of players with O(n log n) time speed.

## 6. How to Run
javac *.java
java Main