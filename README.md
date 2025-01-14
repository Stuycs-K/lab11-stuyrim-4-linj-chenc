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
|  specialAttack  |  **Divine Judgement**: Deals dmg equivalent to **2x # of enemies to one target** and leaves burn damage that inflicts **1 dmg on target for the next 2 turns**; consumes **4 faith**                                                                                  |
|  supportSelf    |  **Prayer**: Recover **3 faith**                                                                                   |
|  supportOther   |  **Resurrection**: **Resurrects** one fallen ally; Priest takes **2x more dmg for next 2 turns**; consumes **8 faith**         |

- ### Sorcerer

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

## Bosses
- ### Phase 1: Little Cheese

|  Info           |  Details  |
| :-------------: | :-------: |
|  Name           |  Little Cheese          |
|  maxHP          |  30        |
|  specialName    |  Dairy        |
|  specialMax     |  5         |
|  attack         |  **Cheese Chuck**: Deals **1 dmg to one enemy**        |
|  specialAttack  |  **Spoiled Milk**: Leaves poison effect that deals **1 dmg to all enemies** at the end of each turn before Little Cheese is defeated; consumes **5 dairy**          |
|  supportSelf    |   **Cheese Churn**: Recovers **0 to 3 dairy**   |

- ### Phase 2: Big Cheese the Destroyer of Worlds

|  Info           |  Details  |
| :-------------: | :-------: |
|  Name           |  Big Cheese the Destroyer of Worlds          |
|  maxHP          |  60        |
|  specialName    |  Evil Dairy        |
|  specialMax     |  15         |
|  attack         |  **TBD**: Deals **1-8 dmg to one enemy**        |
|  specialAttack  |  **Mark of Vengeance**: Deals **5 dmg to one enemy** and inflicts the Lactose Intolerance Debuff that will **remove 50% of the target's special on the next attack**. The mark does not disappear until they are attacked (can be stacked (?)); consumes **5 evil dairy**          |
|  supportSelf    |  **TBD**: **recovers 10 hp points** and either **recovers or consumes 2 evil dairy**    |
