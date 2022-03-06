# Battleship
Battleship game built for my EBC-PJ - Java Programming Language course.

## What I Learned

- Developed a graphical user interface using Greenfoot
- Implemented functionality to the GUI: BattleshipWorld, CellActor, LoadActor, ShipActor etc.
- Designed saving the state of the game to a file and loading in the following games

## Repo Structure

```
/
├─ src/
│  ├─ main/ 
│  │  ├─ java/cz/mendelu/pjj/   # Runner
│  │  │  └─ battleship/         # The main logic
│  │  │     └─ greenfoot/       # GUI implementation
│  │  │    
│  │  └─ resources/             # Images and graphical elements
│  │
│  └─ test/java/cz/mendelu/pjj/ # Unit tests
│
├─ helper/                      # Helper text, which is loading on start
├─ save/                        # Saved the states of the game
├─ .gitignore                   # List of files and folders not tracked by Git
├─ build.gradle                 # Build configuration, tasks, and plugins
└─ README.md                    # This file
```
