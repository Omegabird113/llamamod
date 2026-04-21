# Historical Versioning Systems

> **Warning**:
> 
> These systems are **no longer in use**, and are documented for historical purposes only. The current system is described [here](../development/versioning.md).

## System 1 - Build-Only
LlamaBlocks started at version `0.0` and, with each feature added, the 2nd version segment would increase as a build number, so:

This system was used very early in development (pre-2023)

| Segment | Meaning                                            | 
|:--------|:---------------------------------------------------|
| `0`     | Always `0` due to being a non-public-ready version |
| `x`     | Build number, increments with each change          |

## System 2 - Major Versions + Betas w/ Builds
This system actually comes in 2 different formats for 2 separate types of versions (`Developer Versions` and `Full Versions`)

This system was used until the switch to the current system with `1.0.0` development cycle before LlamaBlocks' posting to mod platforms.

> **Note**:
> 
> `0.45.05` was a development build within the `1.0.0` cycle, but it still used the old versioning system and was not retroactively renamed in any way. When the versioning system was changed to the current one, it began at `1.0.0-beta2`, since it was the 2nd public development version released in that cycle.

### Full Versions
| Segment | Meaning                                                | 
|:--------|:-------------------------------------------------------|
| `0`     | Always `0` due to being a non-public-ready version     |
| `x`     | Major version (increments with major feature releases) |

### Development Versions
| Segment | Meaning                                                                           | 
|:--------|:----------------------------------------------------------------------------------|
| `0`     | Always `0` due to being a non-public-ready version                                |
| `x`     | Major version (increments with major feature releases)                            |
| `y`     | Build number for the development build for version `0.(x+1)` which starts at `00` |

### Examples
- `0.42` is the major release **42**
- `0.34.09` is the **10th** development build of the **next** version: `0.35`. 
- `0.40.00` is the **1st** development build of the **next** version: `0.41`

### Why So Complex?
Until MCreator 2026.1, it strips out any characters other than numbers and dots in mod versions before generating the actual NeoForge `mods.toml` file which is where the version that shows in the mod menu comes from. Alongside that, I did not have a git repository to track commits and how much I'd done in an update.

I wanted a versioning system that met these requirements:

- It could show pre-release versions in some clear way
- MCreator's versioning stripping would end up not affecting it
- Newer versions, when sorted as strings, would have newer versions come after older ones
- It could track changes like commits do before having a git repo
