package io.github.omegabird113.llamablocks.client.gui;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import io.github.omegabird113.llamablocks.world.inventory.DoubleSecureStoorafeBlockGuiMenu;
import io.github.omegabird113.llamablocks.procedures.IsThisBetaProcedureProcedure;
import io.github.omegabird113.llamablocks.procedures.IsAllowClearingBoxCheckedProcedure;
import io.github.omegabird113.llamablocks.network.DoubleSecureStoorafeBlockGuiButtonMessage;
import io.github.omegabird113.llamablocks.init.LlamamodModScreens;

import com.mojang.blaze3d.platform.InputConstants;

public class DoubleSecureStoorafeBlockGuiScreen extends AbstractContainerScreen<DoubleSecureStoorafeBlockGuiMenu> implements LlamamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Checkbox allow_clearing;
	private Button button_clear;
	private Button button_close;
	private static final Identifier BACKGROUND = Identifier.parse("llamamod:textures/screens/double_secure_stoorafe_block_gui.png");

	public DoubleSecureStoorafeBlockGuiScreen(DoubleSecureStoorafeBlockGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 174, 229);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 1 && elementState instanceof Boolean logicState) {
			if (name.equals("allow_clearing")) {
				if (allow_clearing.selected() != logicState)
					allow_clearing.onPress(null);
			}
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
	}

	@Override
	public boolean keyPressed(KeyEvent event) {
		int key = InputConstants.getKey(event).getValue();
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(event);
	}

	@Override
	protected void extractLabels(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY) {
		guiGraphics.text(this.font, Component.translatable("gui.llamamod.double_secure_stoorafe_block_gui.label_secure_stoorage_block"), 6, 7, -16316660, false);
		if (IsThisBetaProcedureProcedure.execute())
			guiGraphics.text(this.font, Component.translatable("gui.llamamod.double_secure_stoorafe_block_gui.label_beta"), 176, 21, -65536, false);
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