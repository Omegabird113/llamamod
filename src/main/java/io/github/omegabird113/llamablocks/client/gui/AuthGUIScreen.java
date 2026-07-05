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

import io.github.omegabird113.llamablocks.world.inventory.AuthGUIMenu;
import io.github.omegabird113.llamablocks.procedures.ReturnNameOfSelectedBlockProcedureProcedure;
import io.github.omegabird113.llamablocks.procedures.IsThisBetaProcedureProcedure;
import io.github.omegabird113.llamablocks.network.AuthGUIButtonMessage;
import io.github.omegabird113.llamablocks.init.LlamamodModScreens;

import com.mojang.blaze3d.platform.InputConstants;

public class AuthGUIScreen extends AbstractContainerScreen<AuthGUIMenu> implements LlamamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox password;
	private Button button_submit;
	private Button button_x;
	private static final Identifier BACKGROUND = Identifier.parse("llamamod:textures/screens/auth_gui.png");
	private static final Identifier IMAGE_0 = Identifier.parse("llamamod:textures/screens/my-levae_the_password_feild_empty_if_you_havent_yet_configured_a_password..png");

	public AuthGUIScreen(AuthGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 130, 76);
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
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
		password.extractWidgetRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.extractBackground(guiGraphics, mouseX, mouseY, partialTicks);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + -14, this.topPos + 76, 0, 0, 0, 0, 0, 0);
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
		return super.keyPressed(event);
	}

	@Override
	public void resize(int width, int height) {
		String passwordValue = password.getValue();
		super.resize(width, height);
		password.setValue(passwordValue);
	}

	@Override
	protected void extractLabels(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY) {
		guiGraphics.text(this.font, ReturnNameOfSelectedBlockProcedureProcedure.execute(world, x, y, z), 5, 6, -16777216, false);
		guiGraphics.text(this.font, Component.translatable("gui.llamamod.auth_gui.label_enter_password"), 5, 17, -16777016, false);
		if (IsThisBetaProcedureProcedure.execute())
			guiGraphics.text(this.font, Component.translatable("gui.llamamod.auth_gui.label_beta"), 2, -11, -65536, false);
	}

	@Override
	public void init() {
		super.init();
		password = new EditBox(this.font, this.leftPos + 4, this.topPos + 26, 120, 20, Component.translatable("gui.llamamod.auth_gui.password"));
		password.setMaxLength(8192);
		password.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "password", content, false);
		});
		password.setHint(Component.translatable("gui.llamamod.auth_gui.password"));
		this.addWidget(this.password);
		button_submit = Button.builder(Component.translatable("gui.llamamod.auth_gui.button_submit"), e -> {
			int x = AuthGUIScreen.this.x;
			int y = AuthGUIScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new AuthGUIButtonMessage(0, x, y, z));
				AuthGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 5, this.topPos + 48, 56, 20).build();
		this.addRenderableWidget(button_submit);
		button_x = Button.builder(Component.translatable("gui.llamamod.auth_gui.button_x"), e -> {
			int x = AuthGUIScreen.this.x;
			int y = AuthGUIScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new AuthGUIButtonMessage(1, x, y, z));
				AuthGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 100, this.topPos + -21, 30, 20).build();
		this.addRenderableWidget(button_x);
	}
}