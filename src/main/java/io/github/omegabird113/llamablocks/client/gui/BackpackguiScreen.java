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
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import io.github.omegabird113.llamablocks.world.inventory.BackpackguiMenu;
import io.github.omegabird113.llamablocks.procedures.IsThisBetaProcedureProcedure;
import io.github.omegabird113.llamablocks.network.BackpackguiButtonMessage;
import io.github.omegabird113.llamablocks.init.LlamamodModScreens;

import com.mojang.blaze3d.platform.InputConstants;

public class BackpackguiScreen extends AbstractContainerScreen<BackpackguiMenu> implements LlamamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_x;
	private static final Identifier BACKGROUND = Identifier.parse("llamamod:textures/screens/backpackgui.png");

	public BackpackguiScreen(BackpackguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 174, 156);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.extractBackground(guiGraphics, mouseX, mouseY, partialTicks);
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
		guiGraphics.text(this.font, Component.translatable("gui.llamamod.backpackgui.label_backpack1"), 6, 8, -16186368, false);
		if (IsThisBetaProcedureProcedure.execute())
			guiGraphics.text(this.font, Component.translatable("gui.llamamod.backpackgui.label_beta"), 2, -11, -65536, false);
	}

	@Override
	public void init() {
		super.init();
		button_x = Button.builder(Component.translatable("gui.llamamod.backpackgui.button_x"), e -> {
			int x = BackpackguiScreen.this.x;
			int y = BackpackguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new BackpackguiButtonMessage(0, x, y, z));
				BackpackguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 144, this.topPos + -21, 30, 20).build();
		this.addRenderableWidget(button_x);
	}
}