package mc.omegabird.llamablocks.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import mc.omegabird.llamablocks.world.inventory.BackpackguiMenu;
import mc.omegabird.llamablocks.procedures.IsThisBetaProcedureProcedure;
import mc.omegabird.llamablocks.network.BackpackguiButtonMessage;
import mc.omegabird.llamablocks.init.LlamamodModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class BackpackguiScreen extends AbstractContainerScreen<BackpackguiMenu> implements LlamamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_x;

	public BackpackguiScreen(BackpackguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 174;
		this.imageHeight = 156;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("llamamod:textures/screens/backpackgui.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.backpackgui.label_backpack1"), 6, 6, -14477568, false);
		if (IsThisBetaProcedureProcedure.execute())
			guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.backpackgui.label_beta"), 2, -11, -65536, false);
	}

	@Override
	public void init() {
		super.init();
		button_x = Button.builder(Component.translatable("gui.llamamod.backpackgui.button_x"), e -> {
			int x = BackpackguiScreen.this.x;
			int y = BackpackguiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new BackpackguiButtonMessage(0, x, y, z));
				BackpackguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 144, this.topPos + -21, 30, 20).build();
		this.addRenderableWidget(button_x);
	}
}