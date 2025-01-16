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

## Enemies
- ### Barbarian Goblin

|  Info           |  Details  |
| :-------------: | :-------: |
|  Name           |  Barbarian Goblin         |
|  maxHP          |   15        |
|  specialName    |    Roast Meat        |
|  specialMax     |     4      |
|  attack         |   **Club Attack**: Deals **4 damage**        |
|  specialAttack  |  **Hunger Pains**: Enters an enraged state, taking **30% less damage** and has a **50% chance to do 1.5x damage** on **next turn**; only works if **no Roast Meat is remaining**         |
|  supportSelf    |    **Herbal Roast (self)** - Recovers **2 hp**; consumes **1 Roast Meat**       |
|  supportOther   |    **Herbal Roast (other)** - Allows ally to recover **2 hp**; consumes **1 Roast Meat**       |

- ### Drunk Goblin

|  Info           |  Details  |
| :-------------: | :-------: |
|  Name           |  Drunk Goblin         |
|  maxHP          |  15         |
|  specialName    |  Booze         |
|  specialMax     |  5         |
|  attack         |  **Alcohol Poisoning**: Deals **1 Damage** to one enemy and causes them to take **2x damage** on their **next attack**        |
|  specialAttack  |           |
|  supportSelf    |           |
|  supportOther   |           |

- ### Yin

|  Info           |  Details  |
| :-------------: | :-------: |
|  Name           |  Yin         |
|  maxHP          |  30         |
|  specialName    |  Moon Energy         |
|  specialMax     |  10         |
|  attack         |           |
|  specialAttack  |  **Total Eclipse**: Deals **5 damage** to all enemies; consumes **5 Moon Energy**          |
|  supportSelf    |           |
|  supportOther   |  **Celestial Protection**: **Reduces damage** taken by ally on **next hit by 30%**; consumes **3 Moon Energy**         |

- ### Yang

|  Info           |  Details  |
| :-------------: | :-------: |
|  Name           |   Yang        |
|  maxHP          |   18        |
|  specialName    |  Sun Energy         |
|  specialMax     |    8       |
|  attack         |  **Light Blade**: deals **2 dmg**         |
|  specialAttack  |  **Heavenly Jurisdiction**: **All enemies** now will take **2x damage on next hit**; consumes **4 Sun Energy**       |
|  supportSelf    |  **Heaven's Warrior**: Next enemy attack has a **30% chance of missing** and dealing **no damage**; does not stack         |
|  supportOther   |  **Blessing of the Sun**:  Buff ally’s **next attack** to deal **2x extra damage**; consumes **4 Sun Energy**         |
