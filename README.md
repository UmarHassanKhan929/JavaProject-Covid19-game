# CV-19 !nfected

A 2D platformer awareness game built in Java as part of our Object-Oriented Programming course project. The game educates players about coronavirus/COVID-19 through interactive gameplay across multiple levels.

## Team Members

- Umar Hassan Khan
- Muhammad Umair Nasrullah
- Mohammad Noman Shahid

## Features

- **Multiple Game Levels** — 4 unique levels with progressive difficulty
- **Game State Management** — Main menu, pause menu, help screen, controls menu, death screen, end credits, and finale
- **NPC Interactions** — Encounter various characters throughout the game
- **Enemy System** — Fight COVID-themed enemies including Corona variants and other obstacles
- **HUD System** — On-screen display showing health, inventory, and game stats
- **Tile-Based Map System** — Background rendering and collision detection
- **Audio Support** — Background music and sound effects
- **Keyboard Controls** — Full keyboard input handling

## Project Structure

```
Project_OOP_c19/src/
├── Main/              # Game entry point and core game loop
├── GameStates/        # All game states (menus, levels, screens)
├── Entity/            # Player, NPCs, enemies, HUD, and animations
│   ├── Npcs/          # Non-playable characters
│   └── Enemies/       # Enemy types
├── TileMap/           # Tile-based rendering system
├── ControlHandlers/   # Input handling
└── Audio/             # Music and sound management
```

## How to Run

### Option 1: Using the JAR File
Simply run the provided `CV-19 !nfected.jar` file:
```bash
java -jar "CV-19 !nfected.jar"
```

### Option 2: From Source
1. Open the `Project_OOP_c19` folder in your preferred Java IDE (Eclipse, IntelliJ IDEA, NetBeans)
2. Navigate to `src/Main/GameLaunch.java`
3. Run the `GameLaunch` class from the IDE

## Requirements

- Java 8 or higher
- Any Java IDE or command-line Java environment

## Controls

Refer to the in-game Controls menu for the full list of keyboard bindings.

## Acknowledgments

The base structure of this project is adapted from:
- [foreignguymike/legacyYTtutorials](https://github.com/foreignguymike/legacyYTtutorials/tree/master/dragontale) — Dragon Tale tutorial series

---

*This project was developed for academic purposes as part of an Object-Oriented Programming course.*
