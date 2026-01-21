package mc.omegabird.llamablocks.client.gui;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import mc.omegabird.llamablocks.world.inventory.AuthblockauthguiMenu;
import mc.omegabird.llamablocks.network.AuthblockauthguiButtonMessage;
import mc.omegabird.llamablocks.init.LlamamodModScreens;

public class AuthblockauthguiScreen extends AbstractContainerScreen<AuthblockauthguiMenu> implements LlamamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox password;
	private Button button_submit;
	private Button button_x;

	public AuthblockauthguiScreen(AuthblockauthguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 130;
		this.imageHeight = 76;
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

	private static final ResourceLocation texture = ResourceLocation.parse("llamamod:textures/screens/authblockauthgui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		password.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("llamamod:textures/screens/my-levae_the_password_feild_empty_if_you_havent_yet_configured_a_password..png"), this.leftPos + -15, this.topPos + 76, 0, 0, 0, 0, 0, 0);
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (password.isFocused())
			return password.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String passwordValue = password.getValue();
		super.resize(minecraft, width, height);
		password.setValue(passwordValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.authblockauthgui.label_secure_stoorage_block"), 5, 4, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.authblockauthgui.label_enter_password"), 5, 15, -16777016, false);
	}

	@Override
	public void init() {
		super.init();
		password = new EditBox(this.font, this.leftPos + 6, this.topPos + 26, 118, 18, Component.translatable("gui.llamamod.authblockauthgui.password"));
		password.setMaxLength(8192);
		password.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "password", content, false);
		});
		password.setHint(Component.translatable("gui.llamamod.authblockauthgui.password"));
		this.addWidget(this.password);
		button_submit = Button.builder(Component.translatable("gui.llamamod.authblockauthgui.button_submit"), e -> {
			int x = AuthblockauthguiScreen.this.x;
			int y = AuthblockauthguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new AuthblockauthguiButtonMessage(0, x, y, z));
				AuthblockauthguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 5, this.topPos + 48, 56, 20).build();
		this.addRenderableWidget(button_submit);
		button_x = Button.builder(Component.translatable("gui.llamamod.authblockauthgui.button_x"), e -> {
			int x = AuthblockauthguiScreen.this.x;
			int y = AuthblockauthguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new AuthblockauthguiButtonMessage(1, x, y, z));
				AuthblockauthguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 100, this.topPos + -21, 30, 20).build();
		this.addRenderableWidget(button_x);
	}
}