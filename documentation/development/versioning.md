# The LlamaBlocks Versioning System
LlamaBlocks uses [SemVer](https://semver.org) to determine versions. Here's an explanation:

## The Main Version Number
The main version number follows the pattern `x.y.z` where:

| Segment | Meaning                                                 | Examples                                                                 |
|:--------|:--------------------------------------------------------|:-------------------------------------------------------------------------|
| `x`     | a game-changing update                                  | A rewrite, a ridiculous amount of new features, etc.                     |
| `y`     | represents an update which changes features or behavior | New blocks, Minecraft version update, new function in the computer, etc. |
| `z`     | a bugfix or smaller enhancement update                  | A hotfix/bugfix, small texture/GUI change, etc.                          |

## The Pre-Release Suffix
After the Main Version, you'll sometimes see `-betaX` or `-rcX` where:

- `beta` represents a potentially unstable build of the main version.
- `rc` is an almost complete build with beta branding which will likely receive little changes, if any, before becoming a full release. Their purpose is to catch major bugs before a full release.

When using a `beta` or `rc` version, every UI in the mod has the text `BETA` in red somewhere within the GUI and the version of LlamaBlocks you're running is sent to you in chat every time you load a world. This behavior cannot be disabled.

> **Warning**:
> 
> Compatibility between beta versions is not guaranteed. Some items and other things may be deleted or not work in your world anymore if they are from a beta version.

## The Minecraft Version Suffix
Every release of LlamaBlocks is actually 2 versions: one that ends in `+mc1.21.8` and a backport that ends in `+mc1.21.1`. This final suffix tells you which version of Minecraft the specific build of LlamaBlocks is made for.