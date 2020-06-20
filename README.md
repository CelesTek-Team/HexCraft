# HEXCraft

HEXCraft is a technology and decoration mod **inspired by XyCraft**. The idea was to bring back similar ideas of block design (we loved it just as much as you did), while still coming up with new ideas and new functionalities. The mod is heavily in a sci-fi tech territory featuring energy transfer, multitanks, chunk loading, beautiful blocks and more!

The mod is still in heavy development, but you are more than welcome to try it! Any help discovering bugs is always welcome!

## Features So Far
- Relatively difficult and expensive recipes and scarcity of ore make this a more challenging mod to play. As you will see, this is nothing like XyCraft, both in mechanics, block types and gameplay.
- All blocks and mechanics are based on a lore that we made and we stick to it very strictly.
- Ore world generation featuring glow-in-dark ores and crystal monoliths that use a unique spawning algorithm. This means no pockets of air!
- Unique energy transfer system that uses special HEX energy. Cables are not tile entities and this reduces server strain to a minimum.
- Energy Pylons which use lasers to transport energy within the energy network. They can be toggled with Redstone to use them as switches or maybe even make laser shows.
- Energy conversion system using a multiblock structure that lets you convert between any of the following energy types: HEX, RF, EU (and maybe more in future).
- Multiblock fluid tanks that are made out of HEXCraft blocks. Designed with performance in mind, no checking of the structure is done at all until a block is broken.
- A Hexorium Furnace for smelting ores quicker than with normal furnaces.
- A machine called Crystal Separator that can process Hexorium ore for higher crystal yield, but can also process other mod ores (provided they are gems).
- Personal Teleportation Pad which lets players teleport between two locations.
- A huge variety of unique, including glowing glass, doors, lamps, buttons, switches, pressure plates, etc. featuring 18 different colors (one being a slowly changing rainbow).
- Easy color changing of already placed blocks using a Molecular Transposer tool.
- Reinforcable decorative blocks to Obsidian hardness.
- Compatibility with a wide variety of mods, including Colored Light for making our lamps glow in different colors.
- A Sound Projector block, serving as a customizable sound source.
- Unique multiblock chunk loading system.

## Environment Setup

**Prerequisites**
- Java 8
- Minecraft 1.7.10
- Forge 10.13.4.1614

**Building**
1) Clone this repository.
2) Run `gradlew setupDecompWorkspace`
3) Run `gradlew setupDevWorkspace`
4) Run `gradlew build`

**IDE Setup (IntelliJ IDEA)**
1) Import to IntelliJ IDEA.
2) Through built in terminal, run `gradlew genIntellijRuns`
3) Go to "Edit Configurations" in top right.
4) Under "Use classpath of module", select the ".main" one.

## Special Thanks
- [GregoriusT](https://github.com/GregoriusT) for helping with the GregTech-6 integration and NEI integration
- [OvermindDL1](https://github.com/OvermindDL1) for helping setup a proper build environment
- [LuxusDarkangel](https://github.com/LuxusDarkangel) for Spanish Translation
- [Felixir](https://twitter.com/relgukxilef) for German Translation