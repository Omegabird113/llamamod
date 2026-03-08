package mc.omegabird.llamablocks.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import mc.omegabird.llamablocks.world.inventory.NetherbackpackguiMenu;
import mc.omegabird.llamablocks.procedures.IsThisBetaProcedureProcedure;
import mc.omegabird.llamablocks.procedures.IsAllowClearingBoxCheckedProcedure;
import mc.omegabird.llamablocks.network.NetherbackpackguiButtonMessage;
import mc.omegabird.llamablocks.init.LlamamodModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class NetherbackpackguiScreen extends AbstractContainerScreen<NetherbackpackguiMenu> implements LlamamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Checkbox allow_clearing;
	private Button button_x;
	private Button button_delete_items;

	public NetherbackpackguiScreen(NetherbackpackguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 174;
		this.imageHeight = 174;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 1 && elementState instanceof Boolean logicState) {
			if (name.equals("allow_clearing")) {
				if (allow_clearing.selected() != logicState)
					allow_clearing.onPress();
			}
		}
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("llamamod:textures/screens/netherbackpackgui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.netherbackpackgui.label_netherite_backpack"), 5, 6, -12243393, false);
		if (IsThisBetaProcedureProcedure.execute())
			guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.netherbackpackgui.label_beta"), 90, -12, -65536, false);
	}

	@Override
	public void init() {
		super.init();
		button_x = Button.builder(Component.translatable("gui.llamamod.netherbackpackgui.button_x"), e -> {
			int x = NetherbackpackguiScreen.this.x;
			int y = NetherbackpackguiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new NetherbackpackguiButtonMessage(0, x, y, z));
				NetherbackpackguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 144, this.topPos + -21, 30, 20).build();
		this.addRenderableWidget(button_x);
		button_delete_items = Button.builder(Component.translatable("gui.llamamod.netherbackpackgui.button_delete_items"), e -> {
			int x = NetherbackpackguiScreen.this.x;
			int y = NetherbackpackguiScreen.this.y;
			if (IsAllowClearingBoxCheckedProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new NetherbackpackguiButtonMessage(1, x, y, z));
				NetherbackpackguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 0, this.topPos + -21, 87, 20).build();
		this.addRenderableWidget(button_delete_items);
		allow_clearing = Checkbox.builder(Component.translatable("gui.llamamod.netherbackpackgui.allow_clearing"), this.font).pos(this.leftPos + 2, this.topPos + 176).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "allow_clearing", value, false);
		}).build();
		this.addRenderableWidget(allow_clearing);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.button_delete_items.visible = IsAllowClearingBoxCheckedProcedure.execute(entity);
	}
}