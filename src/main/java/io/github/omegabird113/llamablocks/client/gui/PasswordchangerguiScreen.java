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
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import io.github.omegabird113.llamablocks.world.inventory.PasswordchangerguiMenu;
import io.github.omegabird113.llamablocks.procedures.PasswordbananaprivlidgeescheckProcedure;
import io.github.omegabird113.llamablocks.procedures.PasswordbananaRightclickedOnBlockProcedure;
import io.github.omegabird113.llamablocks.procedures.IsThisBetaProcedureProcedure;
import io.github.omegabird113.llamablocks.network.PasswordchangerguiButtonMessage;
import io.github.omegabird113.llamablocks.init.LlamamodModScreens;

import com.mojang.blaze3d.platform.InputConstants;

public class PasswordchangerguiScreen extends AbstractContainerScreen<PasswordchangerguiMenu> implements LlamamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox password;
	private EditBox current_password;
	private Button button_submit;
	private Button button_x;
	private Button button_reset;
	private static final Identifier BACKGROUND = Identifier.parse("llamamod:textures/screens/passwordchangergui.png");
	private static final Identifier IMAGE_0 = Identifier.parse("llamamod:textures/screens/warning.png");

	public PasswordchangerguiScreen(PasswordchangerguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 134, 108);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("password"))
				password.setValue(stringState);
			else if (name.equals("current_password"))
				current_password.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		if (PasswordbananaprivlidgeescheckProcedure.execute(entity))
			if (mouseX > leftPos + 0 && mouseX < leftPos + 24 && mouseY > topPos + 107 && mouseY < topPos + 131) {
				guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.llamamod.passwordchangergui.tooltip_you_see_this_becuase_youre_an_o"), mouseX, mouseY);
			}
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
		password.extractWidgetRenderState(guiGraphics, mouseX, mouseY, partialTicks);
		current_password.extractWidgetRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + -1, this.topPos + -17, 0, 0, 16, 16, 16, 16);
	}

	@Override
	public boolean keyPressed(KeyEvent event) {
		int key = InputConstants.getKey(event).getValue();
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (password.isFocused())
			return password.keyPressed(event);
		if (current_password.isFocused())
			return current_password.keyPressed(event);
		return super.keyPressed(event);
	}

	@Override
	public void resize(int width, int height) {
		String passwordValue = password.getValue();
		String current_passwordValue = current_password.getValue();
		super.resize(width, height);
		password.setValue(passwordValue);
		current_password.setValue(current_passwordValue);
	}

	@Override
	protected void extractLabels(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY) {
		guiGraphics.text(this.font, Component.translatable("gui.llamamod.passwordchangergui.label_secure_stoorage_block"), 5, 6, -16777216, false);
		guiGraphics.text(this.font, Component.translatable("gui.llamamod.passwordchangergui.label_enter_password"), 5, 16, -16777016, false);
		guiGraphics.text(this.font, Component.translatable("gui.llamamod.passwordchangergui.label_enter_password_again"), 5, 45, -16777131, false);
		guiGraphics.text(this.font, Component.translatable("gui.llamamod.passwordchangergui.label_if_there_is_one"), 5, 53, -16777131, false);
		if (PasswordbananaprivlidgeescheckProcedure.execute(entity))
			guiGraphics.text(this.font, Component.translatable("gui.llamamod.passwordchangergui.label_change_password"), 1, 108, -1, false);
		if (PasswordbananaprivlidgeescheckProcedure.execute(entity))
			guiGraphics.text(this.font, PasswordbananaRightclickedOnBlockProcedure.execute(world, x, y, z, entity), 1, 117, -16711936, false);
		guiGraphics.text(this.font, Component.translatable("gui.llamamod.passwordchangergui.label_operators_can_see_your_passwords"), 16, -17, -256, false);
		guiGraphics.text(this.font, Component.translatable("gui.llamamod.passwordchangergui.label_see_your_passwords"), 16, -10, -256, false);
		if (IsThisBetaProcedureProcedure.execute())
			guiGraphics.text(this.font, Component.translatable("gui.llamamod.passwordchangergui.label_beta"), 135, 0, -65536, false);
	}

	@Override
	public void init() {
		super.init();
		password = new EditBox(this.font, this.leftPos + 5, this.topPos + 25, 118, 18, Component.translatable("gui.llamamod.passwordchangergui.password"));
		password.setMaxLength(8192);
		password.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "password", content, false);
		});
		password.setHint(Component.translatable("gui.llamamod.passwordchangergui.password"));
		this.addWidget(this.password);
		current_password = new EditBox(this.font, this.leftPos + 5, this.topPos + 62, 118, 18, Component.translatable("gui.llamamod.passwordchangergui.current_password"));
		current_password.setMaxLength(8192);
		current_password.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "current_password", content, false);
		});
		current_password.setHint(Component.translatable("gui.llamamod.passwordchangergui.current_password"));
		this.addWidget(this.current_password);
		button_submit = Button.builder(Component.translatable("gui.llamamod.passwordchangergui.button_submit"), e -> {
			int x = PasswordchangerguiScreen.this.x;
			int y = PasswordchangerguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new PasswordchangerguiButtonMessage(0, x, y, z));
				PasswordchangerguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 5, this.topPos + 82, 56, 20).build();
		this.addRenderableWidget(button_submit);
		button_x = Button.builder(Component.translatable("gui.llamamod.passwordchangergui.button_x"), e -> {
			int x = PasswordchangerguiScreen.this.x;
			int y = PasswordchangerguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new PasswordchangerguiButtonMessage(1, x, y, z));
				PasswordchangerguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 104, this.topPos + -21, 30, 20).build();
		this.addRenderableWidget(button_x);
		button_reset = Button.builder(Component.translatable("gui.llamamod.passwordchangergui.button_reset"), e -> {
			int x = PasswordchangerguiScreen.this.x;
			int y = PasswordchangerguiScreen.this.y;
			if (PasswordbananaprivlidgeescheckProcedure.execute(entity)) {
				ClientPacketDistributor.sendToServer(new PasswordchangerguiButtonMessage(2, x, y, z));
				PasswordchangerguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 72, this.topPos + 82, 51, 20).build();
		this.addRenderableWidget(button_reset);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.button_reset.visible = PasswordbananaprivlidgeescheckProcedure.execute(entity);
	}
}