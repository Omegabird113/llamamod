package io.github.omegabird113.llamablocks.world.inventory;

import net.neoforged.neoforge.transfer.transaction.Transaction;
import net.neoforged.neoforge.transfer.item.VanillaContainerWrapper;
import net.neoforged.neoforge.transfer.item.ResourceHandlerSlot;
import net.neoforged.neoforge.transfer.item.ItemUtil;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.Container;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

import io.github.omegabird113.llamablocks.procedures.DisablePlacementOfItemsInABackpackProcedureProcedure;
import io.github.omegabird113.llamablocks.init.LlamamodModMenus;

public class DoubleSecureStoorafeBlockGuiMenu extends AbstractContainerMenu implements LlamamodModMenus.MenuAccessor {
	public final Map<String, Object> menuState = new HashMap<>() {
		@Override
		public Object put(String key, Object value) {
			if (!this.containsKey(key) && this.size() >= 68)
				return null;
			return super.put(key, value);
		}
	};
	public final Level world;
	public final Player entity;
	public int x, y, z;
	private ContainerLevelAccess access = ContainerLevelAccess.NULL;
	private ResourceHandler<ItemResource> internal;
	private final Map<Integer, Slot> customSlots = new HashMap<>();
	private boolean bound = false;
	private Supplier<Boolean> boundItemMatcher = null;
	private Entity boundEntity = null;
	private BlockEntity boundBlockEntity = null;

	public DoubleSecureStoorafeBlockGuiMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(LlamamodModMenus.DOUBLE_SECURE_STOORAFE_BLOCK_GUI.get(), id);
		this.entity = inv.player;
		this.world = inv.player.level();
		this.internal = new ItemStacksResourceHandler(63);
		BlockPos pos = null;
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
			access = ContainerLevelAccess.create(world, pos);
		}
		if (pos != null) {
			if (extraData.readableBytes() == 1) { // bound to item
				byte hand = extraData.readByte();
				ItemStack itemstack = hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem();
				this.boundItemMatcher = () -> itemstack == (hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem());
				ResourceHandler<ItemResource> cap = itemstack.getCapability(Capabilities.Item.ITEM, ItemAccess.forPlayerSlot(this.entity, hand == 0 ? this.entity.getInventory().getSelectedSlot() : Inventory.SLOT_OFFHAND));
				if (cap != null) {
					this.internal = cap;
					this.bound = true;
				}
			} else if (extraData.readableBytes() > 1) { // bound to entity
				extraData.readByte(); // drop padding
				boundEntity = world.getEntity(extraData.readVarInt());
				if (boundEntity != null) {
					ResourceHandler<ItemResource> cap = boundEntity.getCapability(Capabilities.Item.ENTITY);
					if (cap != null) {
						this.internal = cap;
						this.bound = true;
					}
				}
			} else { // might be bound to block
				boundBlockEntity = this.world.getBlockEntity(pos);
				if (boundBlockEntity instanceof BaseContainerBlockEntity baseContainerBlockEntity) {
					this.internal = VanillaContainerWrapper.of(baseContainerBlockEntity);
					this.bound = true;
				}
			}
		}
		this.customSlots.put(0, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 0, 7, 17) {
			private final int slot = 0;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(1, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 1, 25, 17) {
			private final int slot = 1;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(2, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 2, 43, 17) {
			private final int slot = 2;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(3, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 3, 61, 17) {
			private final int slot = 3;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(4, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 4, 79, 17) {
			private final int slot = 4;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(5, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 5, 97, 17) {
			private final int slot = 5;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(6, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 6, 115, 17) {
			private final int slot = 6;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(7, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 7, 133, 17) {
			private final int slot = 7;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(8, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 8, 151, 17) {
			private final int slot = 8;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(9, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 9, 7, 35) {
			private final int slot = 9;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(10, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 10, 25, 35) {
			private final int slot = 10;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(11, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 11, 43, 35) {
			private final int slot = 11;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(12, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 12, 61, 35) {
			private final int slot = 12;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(13, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 13, 79, 35) {
			private final int slot = 13;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(14, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 14, 97, 35) {
			private final int slot = 14;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(15, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 15, 115, 35) {
			private final int slot = 15;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(16, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 16, 133, 35) {
			private final int slot = 16;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(17, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 17, 151, 35) {
			private final int slot = 17;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(18, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 18, 7, 53) {
			private final int slot = 18;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(19, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 19, 25, 53) {
			private final int slot = 19;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(20, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 20, 43, 53) {
			private final int slot = 20;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(21, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 21, 61, 53) {
			private final int slot = 21;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(22, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 22, 79, 53) {
			private final int slot = 22;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(23, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 23, 97, 53) {
			private final int slot = 23;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(24, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 24, 115, 53) {
			private final int slot = 24;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(25, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 25, 133, 53) {
			private final int slot = 25;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(26, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 26, 151, 53) {
			private final int slot = 26;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(27, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 27, 7, 71) {
			private final int slot = 27;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(28, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 28, 25, 71) {
			private final int slot = 28;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(29, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 29, 43, 71) {
			private final int slot = 29;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(30, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 30, 61, 71) {
			private final int slot = 30;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(31, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 31, 79, 71) {
			private final int slot = 31;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(32, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 32, 97, 71) {
			private final int slot = 32;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(33, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 33, 115, 71) {
			private final int slot = 33;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(34, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 34, 133, 71) {
			private final int slot = 34;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(35, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 35, 151, 71) {
			private final int slot = 35;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(36, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 36, 7, 89) {
			private final int slot = 36;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(37, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 37, 25, 89) {
			private final int slot = 37;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(38, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 38, 43, 89) {
			private final int slot = 38;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(39, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 39, 61, 89) {
			private final int slot = 39;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(40, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 40, 79, 89) {
			private final int slot = 40;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(41, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 41, 97, 89) {
			private final int slot = 41;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(42, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 42, 115, 89) {
			private final int slot = 42;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(43, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 43, 133, 89) {
			private final int slot = 43;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(44, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 44, 151, 89) {
			private final int slot = 44;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(45, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 45, 7, 107) {
			private final int slot = 45;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(46, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 46, 25, 107) {
			private final int slot = 46;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(47, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 47, 43, 107) {
			private final int slot = 47;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(48, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 48, 61, 107) {
			private final int slot = 48;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(49, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 49, 79, 107) {
			private final int slot = 49;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(50, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 50, 97, 107) {
			private final int slot = 50;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(51, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 51, 115, 107) {
			private final int slot = 51;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(52, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 52, 133, 107) {
			private final int slot = 52;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(53, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 53, 151, 107) {
			private final int slot = 53;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(54, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 54, 7, 125) {
			private final int slot = 54;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(55, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 55, 25, 125) {
			private final int slot = 55;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(56, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 56, 43, 125) {
			private final int slot = 56;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(57, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 57, 61, 125) {
			private final int slot = 57;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(58, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 58, 79, 125) {
			private final int slot = 58;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(59, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 59, 97, 125) {
			private final int slot = 59;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(60, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 60, 115, 125) {
			private final int slot = 60;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(61, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 61, 133, 125) {
			private final int slot = 61;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		this.customSlots.put(62, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 62, 151, 125) {
			private final int slot = 62;
			private int x = DoubleSecureStoorafeBlockGuiMenu.this.x;
			private int y = DoubleSecureStoorafeBlockGuiMenu.this.y;

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return !DisablePlacementOfItemsInABackpackProcedureProcedure.execute(world, itemstack);
			}
		}));
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, -1 + 8 + sj * 18, 62 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, -1 + 8 + si * 18, 62 + 142));
	}

	private void setItemInSlot(int index, ItemResource resource, int amount) {
		if (internal instanceof ItemStacksResourceHandler handler) {
			handler.set(index, resource, amount);
		} else if (boundBlockEntity instanceof Container container) {
			container.setItem(index, resource.toStack(Math.max(0, amount)));
		} else {
			try (var tx = Transaction.openRoot()) {
				if (!internal.getResource(index).isEmpty())
					internal.extract(index, internal.getResource(index), internal.getAmountAsInt(index), tx);
				if (!resource.isEmpty() && amount > 0)
					internal.insert(index, resource, amount, tx);
				tx.commit();
			}
		}
	}

	@Override
	public boolean stillValid(Player player) {
		if (this.bound) {
			if (this.boundItemMatcher != null)
				return this.boundItemMatcher.get();
			else if (this.boundBlockEntity != null)
				return AbstractContainerMenu.stillValid(this.access, player, this.boundBlockEntity.getBlockState().getBlock());
			else if (this.boundEntity != null)
				return this.boundEntity.isAlive();
		}
		return true;
	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < 63) {
				if (!this.moveItemStackTo(itemstack1, 63, this.slots.size(), true))
					return ItemStack.EMPTY;
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (!this.moveItemStackTo(itemstack1, 0, 63, false)) {
				if (index < 63 + 27) {
					if (!this.moveItemStackTo(itemstack1, 63 + 27, this.slots.size(), true))
						return ItemStack.EMPTY;
				} else {
					if (!this.moveItemStackTo(itemstack1, 63, 63 + 27, false))
						return ItemStack.EMPTY;
				}
				return ItemStack.EMPTY;
			}
			if (itemstack1.isEmpty()) {
				slot.setByPlayer(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}
			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}
			slot.onTake(playerIn, itemstack1);
		}
		return itemstack;
	}

	@Override
	protected boolean moveItemStackTo(ItemStack itemStack, int startSlot, int endSlot, boolean backwards) {
		boolean anythingChanged = false;
		int destSlot = startSlot;
		if (backwards) {
			destSlot = endSlot - 1;
		}
		if (itemStack.isStackable()) {
			while (!itemStack.isEmpty() && (backwards ? destSlot >= startSlot : destSlot < endSlot)) {
				Slot slot = this.slots.get(destSlot);
				ItemStack target = slot.getItem();
				if (slot.mayPlace(target) && !target.isEmpty() && ItemStack.isSameItemSameComponents(itemStack, target)) {
					int totalStack = target.getCount() + itemStack.getCount();
					int maxStackSize = slot.getMaxStackSize(target);
					if (totalStack <= maxStackSize) {
						itemStack.setCount(0);
						target.setCount(totalStack);
						slot.set(target);
						anythingChanged = true;
					} else if (target.getCount() < maxStackSize) {
						itemStack.shrink(maxStackSize - target.getCount());
						target.setCount(maxStackSize);
						slot.set(target);
						anythingChanged = true;
					}
				}
				if (backwards) {
					destSlot--;
				} else {
					destSlot++;
				}
			}
		}
		if (!itemStack.isEmpty()) {
			if (backwards) {
				destSlot = endSlot - 1;
			} else {
				destSlot = startSlot;
			}
			while (backwards ? destSlot >= startSlot : destSlot < endSlot) {
				Slot slotx = this.slots.get(destSlot);
				ItemStack targetx = slotx.getItem();
				if (targetx.isEmpty() && slotx.mayPlace(itemStack)) {
					int maxStackSize = slotx.getMaxStackSize(itemStack);
					slotx.setByPlayer(itemStack.split(Math.min(itemStack.getCount(), maxStackSize)));
					slotx.setChanged();
					anythingChanged = true;
					break;
				}
				if (backwards) {
					destSlot--;
				} else {
					destSlot++;
				}
			}
		}
		return anythingChanged;
	}

	@Override
	public void removed(Player playerIn) {
		super.removed(playerIn);
		if (!bound && playerIn instanceof ServerPlayer serverPlayer) {
			if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
				for (int j = 0; j < internal.size(); ++j) {
					playerIn.drop(ItemUtil.getStack(internal, j), false);
					setItemInSlot(j, ItemResource.EMPTY, 0);
				}
			} else {
				for (int i = 0; i < internal.size(); ++i) {
					playerIn.getInventory().placeItemBackInInventory(ItemUtil.getStack(internal, i));
					setItemInSlot(i, ItemResource.EMPTY, 0);
				}
			}
		}
	}

	@Override
	public Map<Integer, Slot> getSlots() {
		return Collections.unmodifiableMap(customSlots);
	}

	@Override
	public Map<String, Object> getMenuState() {
		return menuState;
	}
}