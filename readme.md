<<<<<<< HEAD
=======
<!-- vscode-markdown-toc -->
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

>>>>>>> a8d9309a8be2893a49f5d943a3eff749c6a03eb3
# Hello World: The Game

![Alt text](<_media/Screenshot 2023-10-20 092415.png>)
<!-- vscode-markdown-toc -->
* [My first attempted capstone project](#Myfirstattemptedcapstoneproject)
	* [Background](#Background)
* [Features](#Features)
* [Gameplay](#Gameplay)
	* [Controls](#Controls)

<!-- vscode-markdown-toc-config
	numbering=false
	autoSave=true
	/vscode-markdown-toc-config -->
<!-- /vscode-markdown-toc -->

## <a name='Myfirstattemptedcapstoneproject'></a>My first attempted capstone project

This project uses built-in Java libraries to handle rendering, keyboard and mouse input, sprites, and level generation.

### <a name='Background'></a>Background
This is an older version of an unfinished, untitled game project I made from the ground up with Java. It was first written back in 2013 when I began learning software engineering as a hobby.

The original concept of the game was an action RPG wherein you would play as an increasingly powerful adventurer with skills that grow in potency as you utilize them passively. Its mechanics would be inspired by [Ratchet & Clank's](https://www.wikiwand.com/en/Ratchet_%26_Clank) upgrade system, [Mabinogi's](https://www.wikiwand.com/en/Mabinogi_(video_game)) open-ended skill system, and popular anime like [Dragon Ball Z](https://www.wikiwand.com/en/Dragon_Ball_Z).

The farmer boy is a placeholder character I used to test the spritesheet parser. He has no fleshed out backstory or character, but if I couldn't think of another design, I would have kept him. Due to the very small size and features of the sprite, I added a hat and backpack to make his rotations more apparent. _**~Try spinning him around. It's kinda satisfying, right?**_ 😁

The computer I originally wrote this project on failed during development, but I was able to salvage this version from [DropBox](https://www.dropbox.com/scl/fo/k7w56rd4teayreo54wuy2/h?rlkey=5yb2pcqv2stkuaqonq02tg904&dl=0). I waned interest in further development after losing progress and moved onto other projects.

I may come back to this project to to clean and experiment with at a later date. However, if I decide to launch a game in the future, I would rather use a pre-made framework or a game engine.

## <a name='Features'></a>Features

Completed features include:

* A renderer
* 60Hz update cycle
* Input handler
* Spritesheet system
* Tile mapping with a pixel map
* Particles
* Collision detection

Missing features as of initial commit include:

* **_COMMENTS_**, Please don't ask.
* Improved modularity
* Improved readability
* Enemies
* Random level generation
* Gamepad input
* Crosshair/Arrowhead

## <a name='Gameplay'></a>Gameplay

You're a farm boy who can shoot magic oranges.

### <a name='Controls'></a>Controls

| Action | Keys              |
|:------:|-------------------|
|  Walk  | WASD or ⬆️⬅️⬇️➡️|
| Sprint | Hold Shift + Walk |
| Shoot  | Left Mouse Button |
