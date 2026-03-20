# The Password System
The Secure Storage Block, Computer, and Authenticator all support passwords. By default, the password is blank. When there is no password yet, the Computer and Secure Storage Block skip the password screen, but the Authenticator instead requires the user to leave the password field blank. The user can change passwords using the Password Changer, though they need to enter the existing password. 

## Important Security Concerns
1. **Operators can see any password**, meaning that passwords aren't actually private from them.
2. **Passwords are basically stored in plaintext**, this means that from a cybersecurity perspective, it is very unsafe to put a real password into LlamaBlocks.
> More specifically, passwords are stored in a NBT text tag named `access_password`, which can be easily viewed using the vanilla `/data` command.

![This shows the UI of the Password changer being used to change a sample block's password.](https://cdn.modrinth.com/data/cached_images/521c9c8838c4b49edaf5008d1d5dfa1560ae33ac.jpeg)
