[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Features

Make a clear list of features that work/dont work

:white_check_mark: This feature works.

:question: This feature works partially.

:ballot_box_with_check: This extra (beyond the things that the lab was supposed to do) feature works.

:x: This required feature does not work.

:beetle: This is a bug that affects the game.

***

## Adventurer Subclasses
- ### Priest

|  Info           |  Details                                                                                                   |
| :-------------: | :--------------------------------------------------------------------------------------------------------: |
|  Name           |  Priest                                                                                                    |
|  maxHP          |  30                                                                                                        |
|  specialName    |  Faith                                                                                                     |
|  specialMax     |  12                                                                                                        |
|  attack         |  **Light Arrows**: Deals **2 dmg to all enemies**                                                                |
|  specialAttack  |  **Holy Fire**: Deals dmg equivalent to **2x # of enemies to one target** and leaves burn damage that inflicts **1 dmg on target for the next 2 turns**; consumes **4 faith**                                                                                  |
|  supportSelf    |  **Prayer**: Recover **3 faith**                                                                                   |
|  supportOther   |  **Resurrection**: **Resurrects** one fallen ally; Priest takes **2x more dmg for next 2 turns**; consumes **8 faith**         |

- ### Name 2

|  Info           |  Details  |
| :-------------: | :-------: |
|  Name           |  Sorcerer          |
|  maxHP          |  25        |
|  specialName    |  Mana        |
|  specialMax     |  10         |
|  attack         |  **Arcane Bolt**: Deals **4 dmg to one enemy**         |
|  specialAttack  |  **Arcane Nova**: Deals **6 dmg to all enemies** with a **30% chance to stun each enemy for 1 turn**; deals **1 dmg to all allies**; consumes **6 mana**          |
|  supportSelf    |  **Mana Surge**: Recover **2 mana**; increases the Sorcerer's **atk dmg by +2 for next atk** (buff can not stack)         |
|  supportOther   |  **Arcane Shield**: Grants an ally a shield that absorbs **6 dmg**; consumes **4 mana**         |
