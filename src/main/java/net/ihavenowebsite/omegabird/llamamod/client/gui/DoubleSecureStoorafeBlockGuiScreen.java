package net.ihavenowebsite.omegabird.llamamod.client.gui;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.ihavenowebsite.omegabird.llamamod.world.inventory.DoubleSecureStoorafeBlockGuiMenu;
import net.ihavenowebsite.omegabird.llamamod.procedures.IsAllowClearingBoxCheckedProcedure;
import net.ihavenowebsite.omegabird.llamamod.network.DoubleSecureStoorafeBlockGuiButtonMessage;
import net.ihavenowebsite.omegabird.llamamod.init.LlamamodModScreens;

public class DoubleSecureStoorafeBlockGuiScreen extends AbstractContainerScreen<DoubleSecureStoorafeBlockGuiMenu> implements LlamamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Checkbox allow_clearing;
	private Button button_clear;
	private Button button_close;

	public DoubleSecureStoorafeBlockGuiScreen(DoubleSecureStoorafeBlockGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 174;
		this.imageHeight = 228;
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

	private static final ResourceLocation texture = ResourceLocation.parse("llamamod:textures/screens/double_secure_stoorafe_block_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.double_secure_stoorafe_block_gui.label_secure_stoorage_block"), 6, 6, -15658701, false);
	}

	@Override
	public void init() {
		super.init();
		button_clear = Button.builder(Component.translatable("gui.llamamod.double_secure_stoorafe_block_gui.button_clear"), e -> {
			int x = DoubleSecureStoorafeBlockGuiScreen.this.x;
			int y = DoubleSecureStoorafeBlockGuiScreen.this.y;
			if (IsAllowClearingBoxCheckedProcedure.execute(entity)) {
				ClientPacketDistributor.sendToServer(new DoubleSecureStoorafeBlockGuiButtonMessage(0, x, y, z));
				DoubleSecureStoorafeBlockGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 175, this.topPos + 122, 51, 20).build();
		this.addRenderableWidget(button_clear);
		button_close = Button.builder(Component.translatable("gui.llamamod.double_secure_stoorafe_block_gui.button_close"), e -> {
			int x = DoubleSecureStoorafeBlockGuiScreen.this.x;
			int y = DoubleSecureStoorafeBlockGuiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DoubleSecureStoorafeBlockGuiButtonMessage(1, x, y, z));
				DoubleSecureStoorafeBlockGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 175, this.topPos + 0, 51, 20).build();
		this.addRenderableWidget(button_close);
		allow_clearing = Checkbox.builder(Component.translatable("gui.llamamod.double_secure_stoorafe_block_gui.allow_clearing"), this.font).pos(this.leftPos + 175, this.topPos + 100).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "allow_clearing", value, false);
		}).build();
		this.addRenderableWidget(allow_clearing);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.button_clear.visible = IsAllowClearingBoxCheckedProcedure.execute(entity);
	}
}