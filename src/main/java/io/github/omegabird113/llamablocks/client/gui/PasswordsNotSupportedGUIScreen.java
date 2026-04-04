package io.github.omegabird113.llamablocks.client.gui;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import io.github.omegabird113.llamablocks.world.inventory.PasswordsNotSupportedGUIMenu;
import io.github.omegabird113.llamablocks.procedures.IsThisBetaProcedureProcedure;
import io.github.omegabird113.llamablocks.network.PasswordsNotSupportedGUIButtonMessage;
import io.github.omegabird113.llamablocks.init.LlamamodModScreens;

public class PasswordsNotSupportedGUIScreen extends AbstractContainerScreen<PasswordsNotSupportedGUIMenu> implements LlamamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_x;

	public PasswordsNotSupportedGUIScreen(PasswordsNotSupportedGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 164;
		this.imageHeight = 50;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("llamamod:textures/screens/passwords_not_supported_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("llamamod:textures/screens/error.png"), this.leftPos + 3, this.topPos + 6, 0, 0, 16, 16, 16, 16);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.passwords_not_supported_gui.label_error"), 20, 6, -6946816, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.passwords_not_supported_gui.label_please_close_this_gui_and"), 5, 25, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.passwords_not_supported_gui.label_retry_entering_the_password"), 5, 33, -12829636, false);
		if (IsThisBetaProcedureProcedure.execute())
			guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.passwords_not_supported_gui.label_beta"), 1, -11, -65536, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.passwords_not_supported_gui.label_passwords"), 21, 13, -6946816, false);
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