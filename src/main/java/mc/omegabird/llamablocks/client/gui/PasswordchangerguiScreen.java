package mc.omegabird.llamablocks.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import mc.omegabird.llamablocks.world.inventory.PasswordchangerguiMenu;
import mc.omegabird.llamablocks.procedures.PasswordbananaprivlidgeescheckProcedure;
import mc.omegabird.llamablocks.procedures.PasswordbananaRightclickedOnBlockProcedure;
import mc.omegabird.llamablocks.procedures.PasswordResetPasswordChangerGUIPermissionProcedureProcedure;
import mc.omegabird.llamablocks.procedures.IsThisBetaProcedureProcedure;
import mc.omegabird.llamablocks.network.PasswordchangerguiButtonMessage;
import mc.omegabird.llamablocks.init.LlamamodModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

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

	public PasswordchangerguiScreen(PasswordchangerguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 130;
		this.imageHeight = 107;
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

	private static final ResourceLocation texture = ResourceLocation.parse("llamamod:textures/screens/passwordchangergui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		password.render(guiGraphics, mouseX, mouseY, partialTicks);
		current_password.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (PasswordbananaprivlidgeescheckProcedure.execute(entity))
			if (mouseX > leftPos + 0 && mouseX < leftPos + 24 && mouseY > topPos + 106 && mouseY < topPos + 130) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.llamamod.passwordchangergui.tooltip_you_see_this_becuase_youre_an_o"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(ResourceLocation.parse("llamamod:textures/screens/warning.png"), this.leftPos + 0, this.topPos + -16, 0, 0, 16, 16, 16, 16);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (password.isFocused())
			return password.keyPressed(key, b, c);
		if (current_password.isFocused())
			return current_password.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String passwordValue = password.getValue();
		String current_passwordValue = current_password.getValue();
		super.resize(minecraft, width, height);
		password.setValue(passwordValue);
		current_password.setValue(current_passwordValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.passwordchangergui.label_secure_stoorage_block"), 4, 4, -16777216, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.passwordchangergui.label_enter_password"), 4, 13, -16777016, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.passwordchangergui.label_enter_password_again"), 4, 42, -16777131, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.passwordchangergui.label_if_there_is_one"), 4, 50, -16777131, false);
		if (PasswordbananaprivlidgeescheckProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.passwordchangergui.label_change_password"), 1, 107, -1, false);
		if (PasswordbananaprivlidgeescheckProcedure.execute(entity))
			guiGraphics.drawString(this.font, PasswordbananaRightclickedOnBlockProcedure.execute(world, x, y, z, entity), 1, 116, -65536, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.passwordchangergui.label_operators_can_see_your_passwords"), 16, -17, -256, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.passwordchangergui.label_see_your_passwords"), 16, -9, -256, false);
		if (IsThisBetaProcedureProcedure.execute())
			guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.passwordchangergui.label_beta"), 107, -31, -65536, false);
	}

	@Override
	public void init() {
		super.init();
		password = new EditBox(this.font, this.leftPos + 5, this.topPos + 23, 118, 18, Component.translatable("gui.llamamod.passwordchangergui.password"));
		password.setMaxLength(8192);
		password.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "password", content, false);
		});
		password.setHint(Component.translatable("gui.llamamod.passwordchangergui.password"));
		this.addWidget(this.password);
		current_password = new EditBox(this.font, this.leftPos + 5, this.topPos + 61, 118, 18, Component.translatable("gui.llamamod.passwordchangergui.current_password"));
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
				PacketDistributor.sendToServer(new PasswordchangerguiButtonMessage(0, x, y, z));
				PasswordchangerguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 4, this.topPos + 82, 56, 20).build();
		this.addRenderableWidget(button_submit);
		button_x = Button.builder(Component.translatable("gui.llamamod.passwordchangergui.button_x"), e -> {
			int x = PasswordchangerguiScreen.this.x;
			int y = PasswordchangerguiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new PasswordchangerguiButtonMessage(1, x, y, z));
				PasswordchangerguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 100, this.topPos + -21, 30, 20).build();
		this.addRenderableWidget(button_x);
		button_reset = Button.builder(Component.translatable("gui.llamamod.passwordchangergui.button_reset"), e -> {
			int x = PasswordchangerguiScreen.this.x;
			int y = PasswordchangerguiScreen.this.y;
			if (PasswordResetPasswordChangerGUIPermissionProcedureProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new PasswordchangerguiButtonMessage(2, x, y, z));
				PasswordchangerguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 73, this.topPos + 82, 51, 20).build();
		this.addRenderableWidget(button_reset);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.button_reset.visible = PasswordResetPasswordChangerGUIPermissionProcedureProcedure.execute(entity);
	}
}