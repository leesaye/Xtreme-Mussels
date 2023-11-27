# Xtreme-Mussels
A Fitness App
CSC207 Group Project by Group 48

Xtreme Mussels is a fitness app that suggests workouts depending on user goals and chosen body parts, while also curating tailor-made workout routine all with leaderboard and mission systems (Duolingo style, possibly with PvP) to boost motivation.

Domain: Health and fitness - we're focused on improving self-improvement and wellness through exercise!

Software Specification:

The program should allow users to look up different types of exercises based on which muscle group they want to target while also accounting for their chosen difficulty level. It should also be able to generate and suggest workout routines depending on what kind of routine the user wants, such as an upper-body workout routine or a routine to build leg muscle. It should allow users to create new routines and add, edit, and delete exercises from those routines. It should allow  the user to start a real-time workout session and guide the user through reps and timed breaks. It should also assign random missions, have a daily-streak function, and contain achievements so individual users can complete them to stay motivated.

Additional features: The program would also allow users to connect with each other to keep each other motivated, either through collaboration or competition. Users can join a leaderboard with other users, or complete missions on their own. In leaderboards, users gain points by completing weekly/monthly missions. The program also celebrates the user’s achievements as a way to reward the user for exercising.

- API stuff (lisa)

Use cases:
- lookup (lisa)
- generate routine (dhwani)
- add routine (cindy)
- add exercise (to routine) (srika)
- delete exercise (to routine) (srika)
- edit routine (change name, change reps (for a given exercise), reorder) (yan)
- missions (completing)

Additional stuff:
- *signup/login/logout
- *logging completed routine
- *pvp

NOTES:
Entities
- Routine
  - Routine = List of elements each of type Exercise
- Exercise
  - DAO (from json file or calling api each time)
 
TODOS:
- multiple api calls (change how DAO works, get by exercise target and name, drop down bar with target list endpoint) - lisa
- view (GUI) - yan
