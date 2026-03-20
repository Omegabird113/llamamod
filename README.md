# LlamaBlocks
LlamaBlocks is a mod I've been working on, on and off, since the summer of 2022 using [MCreator](https://mcreator.net). It has a massive variety of interesting features that range from massive sets of building blocks with specific color variants, to the Computer block with a bunch of varied features, or specialized blocks like the Variable Light Block.

![This showcases Teal Bricks, White Large Tiles, Secure Storage Blocks, the Authenticator, and the Variable Light Block with shaders in a building with some vanilla blocks also.](https://cdn.modrinth.com/data/cached_images/6941b4cd5c02161ce848f6a60105d11bd034ce34.jpeg)

## Features:
Each sub-category of this section represents a feature or set of related features.

### Building Blocks
There are Custom Bricks and "Large Tiles" added in LlamaBlocks. Bothcome in 19 colors: All 16 vanilla colors *(White, Light Gray, Gray, Black, Brown, Red, Orange, Yellow, Lime, Green, Cyan, Light Blue, Blue, Purple, Magenta, Pink)*, Industrial (Netherite Colored) variants, Cherry (Hot Pink) variants, and Teal variants

There are also the Tiles *(Black and White)* and the Ceiling tiles *(Blue and Light Gray)*.

Each color variant, or tile type, has a corresponding block set, which includes the following full block, stair, slab, wall, fence, fence gate, trapdoor, pressure plate, and button.

![This showcases every vanilla-colored variant of the Bricks and Large Tiles.](https://cdn.modrinth.com/data/cached_images/41e08bc20ee9215c4dcb19822d6d078fbe0905d9.jpeg)

### Banana-Adjacent Features
#### The Banana
The banana is a somewhat bad food item in terms of nutrition, but you can eat them **very fast**. Banana Plants naturally generate in Banana Patches

#### The Golden Banana
When you surround a Banana in 8 gold in a crafting table, you get a Golden Banana. These have more saturation/hunger healing, they give you regeneration for a split second (just enougth for you to heal up once), and you get the Luck effect for 45 seconds after eating them.

#### The Banana Plant

This is a naturally spawning plant which works similarly to something like sugar cane, but it grows 5 blocks high, can be bonemealed, and drops a combination of Bananas/Banana Plants/Bonemeal.

#### Farm Scraps

Farm scraps are non-plantable items which can be used to duplicate some seeds, be composted, and be crafting into brown dye.

![This showcases the Banana Plants as seen in the Banana Patch Feature.](https://cdn.modrinth.com/data/cached_images/e70b91fc362fd4ae098ce912f154d4a5240bc672.jpeg)

### Acid

Acid is a fluid which naturally generates in Acid Lakes in the Outer End Islands, and can be accessed in the Creative menu. When you step into acid, it damages you instantly, kinda like lava. However, it's not based on fire and has a custom damage system.

![This showcase a naturally generating Acid Lake in the End.](https://cdn.modrinth.com/data/cached_images/0c887786ebf1a161067662150855afde79fa6eb5.jpeg)

### The Backpacks

The Backpacks are items which store items like a chest, but are kept in your inventory instead of being placed as a block.

#### The Backpack

This is the cheaper to craft, but less functional, variant of the backpack. It can store 3 rows of items, but that's pretty much it.

#### The Netherite Backpack

The Netherite backpack is an upgrade to the backpack which:
- Has 4 rows of items
- Cannot burn, which protects your items if you drop them or die in fire or lava.
- Has a Delete Items button

### The Variable Light

This is a block which, when a block next to it is updated, will set the light level it produces to the maximum redstone power going into the block.

![This showcases Cherry walls, Industrial floor/ceiling, and mood mood lighting with the Variable light with no shaders.](https://cdn.modrinth.com/data/cached_images/563992bdd456b962c393e0771959f22365f5d028.jpeg)

### The Secure Storage Block

This is like a barrel, but:
- It has 7 rows of items
- There is a button which deletes all items, though there's a checkbox on whether or not to show that button in order to prevent accidental deletions
- It supports having passwords with the Password System

![This shows a Secure Storage Block's UI with a bunch of items in it.](https://cdn.modrinth.com/data/cached_images/4b23d8becca8ca368aa103337e5704d2cc9be8c9.jpeg)

### The Password System

The Secure Storage Block, Computer, and Authenticator all support passwords. By default, the password is blank. When there is no password yet, the Computer and Secure Storage Block skip the password screen, but the Authenticator instead requires the user to leave the password field blank. The user can change passwords using the Password Changer, though they need to enter the existing password. 

#### Important Security Concerns
1. **Operators can see any password**, meaning that all passwords aren't actually private.
2. **Passwords are basically stored in plaintext**, this means that from a cybersecurity perspective, it is very unsafe to put a real password into LlamaBlocks.
> More specifically, passwords are stored in a NBT text tag named `access_password`, which can be easily viewed using the vanilla `/data` command.

![This shows the UI of the Password changer being used to change a sample block's password.](https://cdn.modrinth.com/data/cached_images/521c9c8838c4b49edaf5008d1d5dfa1560ae33ac.jpeg)

### The Authenticator

This asks for a password using the Password System, and, if successful, gives a redstone pulse for 0.75 seconds.

### The Computer

The computer offers a variety of features for information, math, player management, and more. This includes a calculator, random number generator, a player messaging system, a message storage system, a redstone output slider, text with a formatted in-game time, and a list of players.

![This shows the Computer UI as of v1.2.0, with a calculator, redstone output selector, random number generator, player management controls, in-game time, player list, LlamaBlocks version, and message loading/saving.](https://cdn.modrinth.com/data/cached_images/83a8dc9f58808e295b15323dfc782b793afd8463.png)

### Where to Download
LlamaBlocks is available on the following mod hosting websites:
- [Modrinth](https://modrinth.com/mod/llamablocks)
- [CurseForge](https://www.curseforge.com/minecraft/mc-mods/llamablocks)
- [MCreator's Website](https://mcreator.net/modification/121457/llamablocks)

## Development

Here's some information about the development of LlamaBlocks.

### Current Requirements to Open the Workspace in MCreator:
- [MCreator](https://mcreator.net) version [2025.3](https://mcreator.net/download/2025-3)
- The [Blockstates](https://mcreator.net/plugin/104253/blockstates) plugin

> Note that in order to connect to the GitHub repo, I'm also using the [Remote Workspaces Support](https://mcreator.net/plugin/97468/remote-workspaces-support-20232) plugin

### Licensing, Modpacks, etc

You can use LlamaBlocks with credit, or use its code or even jar files in a Modpack or other project, as long as that use is compliant with the [GPLv3](https://www.gnu.org/licenses/gpl-3.0.en.html) license.
