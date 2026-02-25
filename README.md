# LlamaBlocks
LlamaBlocks is a chaotic, but interesting Minecraft mod I've made using [MCreator](https://mcreator.net) over the past few years. It has a massive variety of features, with the only real criteria for each being what I thought would be interesting, either to play or code. Its features range from a massive amount of similar building blocks with specific color variants, to single blocks with tons of functionality.

![A showcase build w/ teal & white blocks plus Secure Storage Blocks and more](https://github.com/user-attachments/assets/50106e12-fee9-433e-afd0-c3dcc8ad3796)

## The Features
Each sub-category of this section represents a feature or set of related features.

### Building Blocks
There are 2 massive sets of building blocks:
1. The custom colored bricks
2. The Large Tiles

Both sets come in 19 colors:
- All **16 vanilla colors** *(White, Light Gray, Gray, Black, Brown, Red, Orange, Yellow, Lime, Green, Cyan, Light Blue, Blue, Purple, Magenta, Pink)*
- Industrial (Netherite Colored) variants
- Cherry (Hot Pink) variants
- Teal variants

![Showcases all 16 vanilla colors of all brick & large tile block variants](https://github.com/user-attachments/assets/a48eeedb-e050-49eb-aaad-ff086ab20845)

There are also the Tiles *(Black and White)* and the Ceiling tiles *(Blue and Light Gray)*.

Each color variant, or tile type, has a corresponding block set, which includes the following:
- A full block
- A stair
- A slab
- A wall
- A fence
- A fence gate
- A trapdoor
- A pressure plate
- A button

### Bananas, Banana Plants, Banana Patches, and Farm Scraps
All of these items are related together.

![Showcases Banana Plants in a Banana Patch](https://github.com/user-attachments/assets/f524dfa5-bfbe-4a32-921c-873f788b57c2)

#### The Banana
The banana is a somewhat bad food item in terms of nutrition, but you can eat them very fast. Here are their exact properties:
- A nutritional value of `2` *(it heals `1` hunger bar)*
- A saturation of `3.65` *(not very good)*
- It can be eaten in `12 ticks` *(You can eat them in `0.6 seconds` instead of the typical `1.6 seconds` for food)*
- It can be composted with a `32.5%` success rate
- It can fuel a furnace for `100 ticks` *(`5 seconds`)*

#### The Golden Banana
A Golden Banana is a variant of the banana which is much better, but a bit slower and somewhat expensive:
- A nutritional value of `5` *(it heals `2.5` hunger bar)*
- A saturation of `7.1`
- It can be eaten in `1 second` *(`20 ticks`)*
- It can't be composted or used as furnace fuel
- It can be crafted with a Banana suronded by Gold Ingots

#### The Banana Plant

This is a naturally spawning plant which works similarly to something like sugar cane, but:
- It grows up to `5` blocks high
- Its drops are random and can include Bananas, Banana plants, and Farm Scraps
- It can be bonemealed in vanilla Java Edition.
- It can be composted with a `50%` success rate

#### Banana Patches

Banana Plants naturally generate in Banana Patches, and here's some info about them:
- They can generate in the following biomes: *`Flower Forest`, `Forest`, `Jungle`, `Cherry Grove`, `Plains`*
- They can only generate on Grass and Dirt blocks
- They have a `1/70` chance of trying to generate in a chunk

#### Farm Scraps

Farm scraps are non-plantable items which can be used for the following:
- Placing 4 of them, plus one of the following items in a crafting table makes 2 of that item:
  - Wheat seeds, carrots, beetroot seeds, melon seeds, potatoes, sugar cane, and bamboo
- Placing 8 of them and a banana plant in a crafting table makes another banana plant
- Placing 6 of them plus a sapling creates 2 of those saplings
- You can add 3 Farm Scraps, a Milk Bucket, and a Honey Bottle to the Posionous Potato in a crafting grid to make a reguluar potato
- They can be composted at a `17.5%` success rate
- `3` of them can be crafted into `1` brown dye

### Acid

Acid is a fluid which naturally generates in Acid Lakes (technically a feature named `acid_lake`) in the Outer End Islands, and can be accessed in the Creative menu.

![Showcases a naturally generating Acid Lake in the Outer End Islands](https://media.forgecdn.net/attachments/1476/635/2026-01-18_12-13-50-large-jpeg.jpeg)

#### The Acid Dissolving effect

Coming into contact with acid gives level 1 of this effect to the entity for 7.5 seconds *(150 ticks)*.

The player gets the effect:
- If the level is below 5, `1.5` damage of type `acid_damage` is dealt
- If the level is at or above 5, damage of type `acid_damage` is dealt according to the formula `(a - 2) * 3.05 + 1.5` where `a` is the amplifier

On each tick the effect is active:
- Damage of type `acid_damage` is dealt according to the rounded-up result of the formula, `(a + 1.05) * 1.18` where `a` is the amplifier
- If the player is `≥ 1.9` blocks deep in acid, 2 damage of type `acid_drowning` is dealt

The Acid Damage type:
- Scales with difficulty
- Has an exhaustion value of `0.92`

The Acid Drowning damage type:
- Does not scale with difficulty
- Has an exhaustion value of `0.6`

### The Password System

The [Secure Storage Block](#the-secure-storage-block), [Computer](#the-computer), and [Authenticator](#the-authenticator) all support passwords. By default, the password is blank. When there is no password yet, the [Computer](#the-computer) and [Secure Storage Block](#the-secure-storage-block) skip the password screen, but the Authenticator instead requires the user to leave the password field blank. The user can change passwords using the Password Changer, though they need to enter the existing password. 

#### <ins>**Important Security Concerns**</ins>
1. **Operators can see any password**, meaning that all passwords aren't actually private.
2. **Passwords are basically stored in plaintext**, this means that from a cybersecurity perspective, it is very unsafe to put a real password into LlamaBlocks.
> More specifically, passwords are stored in a NBT text tag named `access_password`, which can be easily viewed using the vanilla `/data` command.

![This shows the UI of the Password changer being used to change a sample block's password.](https://cdn.modrinth.com/data/cached_images/521c9c8838c4b49edaf5008d1d5dfa1560ae33ac.jpeg)

#### The Secure Storage Block

This is like a barrel, but:
- It has `7` rows of items
- There is a button which deletes all items, though there's a checkbox on whether or not to show that button in order to prevent accidental deletions
- It supports having passwords with the [Password System](#the-password-system)

![This shows a Secure Storage Block's UI with a bunch of items in it.](https://cdn.modrinth.com/data/cached_images/4b23d8becca8ca368aa103337e5704d2cc9be8c9.jpeg)

#### The Authenticator

This asks for a password using the [Password System](#the-password-system), and, if successful, gives a redstone pulse for `15 game ticks` (`0.75 seconds`).

### The Computer

The complex offers a variety of features for information, math, player management, and more. Here's a list of its features:
- It supports having passwords with the [Password System](#the-password-system), so only people with access can use the other features
- Players can make calculations between 2 numbers using the operations: `+`, `-`, `*`, `/`, `^`, `MOD`, `MIN`, `MAX`, `ATAN2`, `HYPOT`, `AND`, `OR`, `XOR`, `LOG`, and `ROOT`.
  - `AND`, `OR`, and `XOR` are all bitwise operations
  - `LOG` is a logbase operation with the syntax `<base> log <n>`
  - LlamaMod supports the irrational numbers `pi` and `e` to be entered.
- One value operations supported with just value one: `NLOG`, `ROUND`, `CEIL`, `FLOOR`, `SQRT`, `3ROOT`, `ABS`, `SIGNUM`, `SIN`, `COS`, `TAN`, `ASIN`, `ACOS`, `ATAN`, `LOG10`, `RAD>DEG`, and `DEG>RAD`.
- Players can send messages to other players
- Operators can clear the inventory of and kill players
- Players can store and retrieve a message within the computer block itself
- Players can generate a random number with a minimum and maximum values as low as `-1,000` and as high as `1,000`, inclusive or exclusive (exclusive also causes random numbers decimal values).
- Players can access a formatted string of the 24-hour time (Ex. `7 o'clock (10% through the day)`)
- Players can set a redstone output between 0 and 15, and they can choose to have the computer pick a random power output between 0 and 15.
- It shows a list of the names of every player connected to a world/server.

![This shows the Computer UI as of v1.2.0, with a calculator, redstone output selector, random number generator, player management controls, in-game time, player list, LlamaBlocks version, and message loading/saving.](https://cdn.modrinth.com/data/cached_images/83a8dc9f58808e295b15323dfc782b793afd8463.png)

### The Backpacks

The Backpacks are items which store items like a chest, but are kept in your inventory instead of being placed as a block.

#### The Backpack

This is the cheaper to craft, but less functional, variant of the backpack. It can store `3` rows of items, but that's pretty much it.

#### The Netherite Backpack

The Netherite backpack is an upgrade to the backpack which:
- Has `4` rows of items, instead of `3`
- Cannot burn, which protects your items if you drop them or die in fire or lava.
- Has a `Delete Items` button which deletes every item, though it is protected with a checkbox to prevent accidental deletions

### The Variable Light

This is a block which, when a block next to it is updated, will set the light level it produces to the maximum redstone power going into the block.

![This showcases Cherry walls, Industrial floor/ceiling, and mood mood lighting with the Variable light with no shaders.](https://cdn.modrinth.com/data/cached_images/563992bdd456b962c393e0771959f22365f5d028.jpeg)

### Game Rules
**TBD**

## Where to Download
LlamaBlocks is avalible on the following mod hosting websites:
- [Modrinth](https://modrinth.com/mod/llamablocks)
- [CurseForge](https://www.curseforge.com/minecraft/mc-mods/llamablocks)
- [MCreator's Website](https://mcreator.net/modification/121457/llamablocks)

## Development

Here's some information about the development of LlamaBlocks.

### Current Requirements to Run LlamaBlocks in Minecraft:
#### 1.21.8 version:
- [Minecraft](https://minecraft.net) version 1.21.8
- [NeoForge](https://neoforged.net/) version [21.8.31](https://maven.neoforged.net/releases/net/neoforged/neoforge/21.8.31/neoforge-21.8.31-installer.jar) or higher

#### 1.21.1 version:
- [Minecraft](https://minecraft.net) version 1.21.1
- [NeoForge](https://neoforged.net/) version [21.1.190](https://maven.neoforged.net/releases/net/neoforged/neoforge/21.1.190/neoforge-21.1.190-installer.jar) or higher

### Current Requirements to Open the Workspace in MCreator:
- [MCreator](https://mcreator.net) version [2025.3](https://mcreator.net/download/2025-3)
- The [Blockstates](https://mcreator.net/plugin/104253/blockstates) plugin

> Note that in order to connect to the GitHub repo, I'm also using the [Remote Workspaces Support](https://mcreator.net/plugin/97468/remote-workspaces-support-20232) plugin

### Color Hex Codes
These are applied using the MCreator texture maker’s `Colorize` tool (with `Lock Hue, Saturation, and Brightness` disabled unless said otherwise)

#### Vanilla Colors:
- White: `cfd5d6`
- Light Gray: `7d7d73`
- Gray: `373a3e`
- Black: `080a0f`
- Brown: `603c20`
- Red: `8e2121`
- Orange: `e06101`
- Yellow: `f1af15`
- Lime: `5ea918`
- Green: `495b24`
- Cyan: `157788`
- Light Blue: `2489c7`
- Blue: `2d2f8f`
- Purple: `64209c`
- Magenta: `a9309f`
- Pink: `d5658f`

#### Custom Colors
- Industrial: `452e3f`
- Teal: `037c6e`
- Cherry: `a84365` with `Lock Hue, Saturation, and Brightness` enabled

### The LlamaBlocks Versioning system

The current LlamaBlocks version system produces versions in the format `x.y.z` where:
- `x` represents what a game-changing update (ex. a rewrite, a ridiculous amount of new features, etc)
- `y` represents an update which adds features, changes behavior in a large way, or changes the NeoForge or Minecraft version requirement (ex. some new blocks, a Minecraft version update, a new function is added to the computer, etc)
- `z` represents a bugfix or small update with very few features (ex. an important hotfix, a consistency or bugfix, a small texture or GUI change, etc)

### Licensing, Modpacks, etc

You can use LlamaBlocks in any modpack with credit, you may use LlamaBlocks's code or jar files as long as the use is compliant with the [GPLv3](https://www.gnu.org/licenses/gpl-3.0.en.html) license.
