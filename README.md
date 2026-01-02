# LlamaMod
LlamaMod is a chaotic, but interesting Minecraft mod I've made using [MCreator](https://mcreator.net) over the past few years. It has a massive variety of features, with the only real criteria for each being what I thought would be interesting, either to play or code.

## The Features
LlamaMod has a **ton** of features. These range from a massive amounts of similar building blocks with specific color variants and blocksets, to single blocks with tons of redstone and operator functionality.

### Building Blocks
Their are 2 massive sets of building blocks;
1. The custom colored bricks
2. The large tiles

Both sets come in 19 colors:
- All **16 Vanilla Colors** *(White, Light Gray, Gray, Black, Brown, Red, Orange, Yellow, Lime, Green, Cyan, light Blue, Blue, Purple, Magenta, Pink)*
- "Industrial' variants which are colored similar to Netherite
- "Cherry" variants which are hot pink
- Teal variants

There are also the Tiles *(Black and White)* and the Ceiling tiles *(Blue and Light Gray)*.

Each color variants of the massive set, alongside each Tile set has the following types of blocks:
- a full block
- a stair
- a slab
- a wall
- a fence
- a fence gate
- a trapdoor
- a pressure plate
- a button

This totals to **360** building blocks as of release [0.45](https://github.com/Omegabird113/llama_mod/releases/tag/0.45)!

### Bananas, Banana Plants, and Farm Scraps
All of these items are related together.

#### The Banana
The banana is a kinda bad food item, other than that you can eat them very fast. Here are their exact properties:
- a nutritional value of `2` *(it heals 1 hunger bar)*
- a saturation of `3.55` *(not very good)*
- it can be eaten in `8 ticks` *(You can eat them in `0.4 seconds` instead of the typical `1.6 seconds` for food)*
- It can be composted with a `32.5%` success rate

#### The Banana Plant

This is a naturally spawning plant which works similarly to something like Sugar Cane, but:
- It grows up to `5` blocks high
- It's drops are random and can include Bananas, Banana plants, and Farm Scraps
- It can be bone-mealed in vanilla Java Edition.
- It can be composted with a `50%` success rate

#### Farm Scraps

Farm scraps are non-plantable items which can be used for the following:
- Placing 4 of them plus one of the following items in crafting table makes 2 of that item:
  - Wheat seeds, carrots, beetroot seeds, melon seeds, potatoes, sugar cane, and bamboo
- Placing 8 of them and a banana plant in a crafting table makes another banana plant
- They can be composted at a `17.5%` success rate
- `1` of them can be crafted into `1` brown dye

### Acid

Acid is a fluid which currently does not generate naturally and is not accesable outside of the creative inventory. It deals damage to any entity that comes in contact with it. You can also drown in it. It has more fog than water, but way less than lava.

#### The Acid Dissolving effect

Coming in contact with acid gives level 1 of this effect to the entity for 8.25 seconds *(165 ticks)*.

The the player gets the effect:
- If the level is below 5, `1.5` damage of type `acid_damage` is dealt
- If the level is at or above 5, damage of type `acid_damage` is dealt according to the formula `(a - 2) * 3.05 + 1.5` where `a` is the amplifier

On each tick the effect is active:
- Damage of type `acid_damage` is dealt according to rounding up the result of the formula, `(a + 0.87) * 1.15` where `a` is the amplifier

The Acid Damage type:
- Scales with difficulty
- Has an exhaustion value of `0.65`

### The Password System

The [Secure Storage Block](#the-secure-storage-block), [Computer](#the-computer), and [Authenticator](#the-authenticator) all support passwords. By default, the password is blank. When there is no password yet, the [Computer](#the-computer) and [Secure Storage Block](#the-secure-storage-block) skip the password screen, but the Authenticator instead requires the user to leave the password field blank. The user can change passwords using the Password Changer, though they need to enter the existing password. Though, those with operator permissions see what the previous password is.

#### <ins>**Important Security Concerns**</ins>
1. **Operators can see any password**, meaning that all passwords aren't actually private.
2. **Passwords are basically stored in plaintext**, this means that from a cybersecurity perspective, it is very unsafe to put a real password into LlamamMod.
> More specifically, passwords are stored in a text NBT tag named `access_password`, which can be easily viewed using the vanilla `/data` command.

### The Computer

The complex offers a variety or features for information, math, player management, and more. Here's a list of its features:
- It supports having passwords with the [Password System](#the-password-system), only people with access can use the other features
- Players can make calculations between 2 numbers using the operations: `+`, `-`, `*`, `/`, and `^`
- Players can send messages to other players
- Operators can clear the inventory of and kill players
- Players can store and retreive a message within the computer block itself
- Players can generate a random number with a minimum and maximum values as low as `-1,000` and as high as `1,000`, including or exclusive. (exclusive includes decimal values)
- Players can access a formatted string of the 24-hour time (Ex. `7 o'clock (10% through the day)`)
- Players can set a redstone output between 0 and 15, and they can chose to have the computer pick a random power output between 0 and 15.

### The Secure Storage Block

This is like a barrel, but:
- it has `7` rows of items
- There's a button which deletes all items, though there's a checkbox on whether or not to show that button in order to prevent accidental deletions
- It supports the having passwords with the [Password System](#the-password-system)

### The Authenticator

This asks for a password using the [Password System](#the-password-system) and if successful, gives a redstone pulse for `15 game ticks` (`0.75 seconds`).

### The Backpack

The Backpack is an item which stores that same amount as a chest, but is instead solely in your inventory.

### The Netherite Backpack

The Netherite backpack is an upgrade to the backpack which:
- has `4` rows of items, instead of `3`
- cannot burn
- has a clear all items button which deletes everything, though it is protected with a checkbox to prevent accidental deletions

### The Variable Light

This is a block which, when a block next to it is updated, will set it's light level it produces to the maximum redstone value going into the block.

## Development

Here's some information about the development of LlamaMod

### Current Requirements to Run LlamaMod in Minecraft:
- [Minecraft](https://minecraft.net) version 1.21.8
- [Neoforge](https://neoforged.net/) version [21.8.31](https://maven.neoforged.net/releases/net/neoforged/neoforge/21.8.31/neoforge-21.8.31-installer.jar) or higher

### Current minecraft.net to Open the Workspace in MCreator:
- [MCreator](https://mcreator.net) version [2025.3](https://mcreator.net/download/2025-3)
- The [Blockstates](https://mcreator.net/plugin/104253/blockstates) plugin.

> Note that in order to connect to the GitHub repo, I'm also using the [Remote Workspaces Support](https://mcreator.net/plugin/97468/remote-workspaces-support-20232) plugin

### The LlamaMod Versioning system

The current LlamaMod version system produces versions in the format `x.y.z` where:
- `x` represents what I deem to be a huge update (ex. a rewrite, tons of new features, etc)
- `y` represents update which adds features, changes behavior in a noticeable way, or changes the neoforge or Minecraft version requirement (ex. some new blocks, a Minecraft version update, a new feature is added to the computer, etc)
- `z` represents a bugfix or very small update (ex. an important hotfix, a consistency or bug fix, a small texture or GUI change, etc)

### Licensing, Modpacks, etc

You can use LlamaMod in any modpack with credit, you may use LlamaMod's code or make changes as long as it's compliant with the [GPLv3](https://www.gnu.org/licenses/gpl-3.0.en.html) license.
