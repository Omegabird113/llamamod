# Authenticator
The Authenticator is a redstone block that uses the Password System to prevent access to an area using vanilla redstone features. When a player right clicks it, they are shown a password prompt UI. If the correct password is entered, the block emits a redstone pulse from all sides for `15 game ticks` (`0.75 seconds`) which will go away after. There is no cooldown for repeated failed password attempts, like the rest of the [Password System](password_system.md). Also, any player can re-authenticate which would restart the countdown.

## What if There's No Password?
If the Authenticator has no password set, the player has to leave the password field
**empty** and press the `Submit` button in order to successfully authenticate. Submitting any non-empty input will cause an incorrect password warning.

You can set a password using the `Password Changer`.

## Showcase Image
![This shows the Authenticator Password Prompt UI.](../images/authenticator_showcase.png)