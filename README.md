# Xtreme-Mussels
A Fitness App
CSC207 Group Project by Group 48

Xtreme Mussels is a fitness app that suggests workouts depending on user goals and chosen body parts.

Domain: Health and fitness - we're focused on improving self-improvement and wellness through exercise!

Software Specification:

The program should allow users to look up different types of exercises based on which muscle group they want to target. It should also be able to generate and suggest workout routines according to user's needs, such as an upper-body workout routine or a routine to build leg muscle. It should allow users to create new routines and add, edit, and delete exercises from those routines. It should provide user clear instructions for each exercise.

- API stuff (lisa)

Main features:
- Look up exercises (lisa)
  - Users can search an exercise by its name or by a target muscle
- Generate routine (dhwani)
  - Users can generate a customized routine by typing in the desired target body part and customize the number of exercises to be added in the routine
  - Users can also choose a name for each generated routine
  - Generated routine will be added in the routines view
- Add routine (cindy)
  - Users can create a new routine and customize the routine name
  - The default routine is empty. Users can add/delete exercises once the routine is created (srika)
  - The routine can also be edited any time (change name, change reps (for a given exercise), reorder) (yan)

NOTES:
Entities
- Routine
  - Routine = List of elements each of type Exercise
- Exercise
  - DAO (from json file or calling api each time)