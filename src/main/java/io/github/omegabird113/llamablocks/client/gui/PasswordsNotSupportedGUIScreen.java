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

import io.github.omegabird113.llamablocks.world.inventory.PasswordsNotSupportedGUIMenu;
import io.github.omegabird113.llamablocks.procedures.IsThisBetaProcedureProcedure;
import io.github.omegabird113.llamablocks.network.PasswordsNotSupportedGUIButtonMessage;
import io.github.omegabird113.llamablocks.init.LlamamodModScreens;

import com.mojang.blaze3d.platform.InputConstants;

public class PasswordsNotSupportedGUIScreen extends AbstractContainerScreen<PasswordsNotSupportedGUIMenu> implements LlamamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_x;
	private static final Identifier BACKGROUND = Identifier.parse("llamamod:textures/screens/passwords_not_supported_gui.png");
	private static final Identifier IMAGE_0 = Identifier.parse("llamamod:textures/screens/error.png");

	public PasswordsNotSupportedGUIScreen(PasswordsNotSupportedGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 164, 50);
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 3, this.topPos + 6, 0, 0, 16, 16, 16, 16);
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
		guiGraphics.text(this.font, Component.translatable("gui.llamamod.passwords_not_supported_gui.label_error"), 20, 6, -6946816, false);
		guiGraphics.text(this.font, Component.translatable("gui.llamamod.passwords_not_supported_gui.label_please_close_this_gui_and"), 5, 25, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.llamamod.passwords_not_supported_gui.label_retry_entering_the_password"), 5, 33, -12829636, false);
		if (IsThisBetaProcedureProcedure.execute())
			guiGraphics.text(this.font, Component.translatable("gui.llamamod.passwords_not_supported_gui.label_beta"), 1, -11, -65536, false);
		guiGraphics.text(this.font, Component.translatable("gui.llamamod.passwords_not_supported_gui.label_passwords"), 21, 13, -6946816, false);
	}

	@Override
	public void init() {
		super.init();
		button_x = Button.builder(Component.translatable("gui.llamamod.passwords_not_supported_gui.button_x"), e -> {
			int x = PasswordsNotSupportedGUIScreen.this.x;
			int y = PasswordsNotSupportedGUIScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new PasswordsNotSupportedGUIButtonMessage(0, x, y, z));
				PasswordsNotSupportedGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 134, this.topPos + -21, 30, 20).build();
		this.addRenderableWidget(button_x);
	}
}