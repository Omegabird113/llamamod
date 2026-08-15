package io.github.omegabird113.llamablocks.client.gui;

import net.minecraftforge.client.gui.widget.ForgeSlider;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import io.github.omegabird113.llamablocks.world.inventory.ComputerguiMenu;
import io.github.omegabird113.llamablocks.procedures.*;
import io.github.omegabird113.llamablocks.network.ComputerguiButtonMessage;
import io.github.omegabird113.llamablocks.init.LlamamodModScreens;
import io.github.omegabird113.llamablocks.LlamamodMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class ComputerguiScreen extends AbstractContainerScreen<ComputerguiMenu> implements LlamamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox number1;
	private EditBox number2;
	private EditBox operation;
	private EditBox player_name;
	private EditBox msg;
	private EditBox calculator_result;
	private Checkbox auto_calculate;
	private Button button_x;
	private Button button_kill;
	private Button button_set;
	private Button button_random;
	private Button button_message;
	private Button button_calculate;
	private Button button_clear_inventory;
	private Button button_clear_textboxes;
	private static final ResourceLocation BACKGROUND = new ResourceLocation("llamamod:textures/screens/computergui.png");
	private static final ResourceLocation IMAGE_0 = new ResourceLocation("llamamod:textures/screens/logo_16_border.png");
	private ForgeSlider power_output;

	public ComputerguiScreen(ComputerguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 256;
		this.imageHeight = 145;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("number1"))
				number1.setValue(stringState);
			else if (name.equals("number2"))
				number2.setValue(stringState);
			else if (name.equals("operation"))
				operation.setValue(stringState);
			else if (name.equals("player_name"))
				player_name.setValue(stringState);
			else if (name.equals("msg"))
				msg.setValue(stringState);
			else if (name.equals("calculator_result"))
				calculator_result.setValue(stringState);
		}
		if (elementType == 1 && elementState instanceof Boolean logicState) {
			if (name.equals("auto_calculate")) {
				if (auto_calculate.selected() != logicState)
					auto_calculate.onPress();
			}
		}
		if (elementType == 2 && elementState instanceof Number n) {
			if (name.equals("power_output"))
				power_output.setValue(n.doubleValue());
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		number1.render(guiGraphics, mouseX, mouseY, partialTicks);
		number2.render(guiGraphics, mouseX, mouseY, partialTicks);
		operation.render(guiGraphics, mouseX, mouseY, partialTicks);
		player_name.render(guiGraphics, mouseX, mouseY, partialTicks);
		msg.render(guiGraphics, mouseX, mouseY, partialTicks);
		calculator_result.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(IMAGE_0, this.leftPos + 243, this.topPos + 4, 0, 0, 8, 8, 8, 8);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (number1.isFocused())
			return number1.keyPressed(key, b, c);
		if (number2.isFocused())
			return number2.keyPressed(key, b, c);
		if (operation.isFocused())
			return operation.keyPressed(key, b, c);
		if (player_name.isFocused())
			return player_name.keyPressed(key, b, c);
		if (msg.isFocused())
			return msg.keyPressed(key, b, c);
		if (calculator_result.isFocused())
			return calculator_result.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
		return (this.getFocused() != null && this.isDragging() && button == 0) ? this.getFocused().mouseDragged(mouseX, mouseY, button, dragX, dragY) : super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String number1Value = number1.getValue();
		String number2Value = number2.getValue();
		String operationValue = operation.getValue();
		String player_nameValue = player_name.getValue();
		String msgValue = msg.getValue();
		String calculator_resultValue = calculator_result.getValue();
		super.resize(minecraft, width, height);
		number1.setValue(number1Value);
		number2.setValue(number2Value);
		operation.setValue(operationValue);
		player_name.setValue(player_nameValue);
		msg.setValue(msgValue);
		calculator_result.setValue(calculator_resultValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.computergui.label_calculator"), 5, 5, -12829636, false);
		guiGraphics.drawString(this.font, GettimeasstringProcedure.execute(world), 28, -9, -16711936, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.computergui.label_player_controll"), 6, 68, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.computergui.label_time"), 3, -9, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.computergui.label_redstone_output"), 4, 146, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.computergui.label_players"), 3, -18, -1, false);
		guiGraphics.drawString(this.font, ReturnPlayerListProcedureProcedure.execute(world), 47, -18, -16742401, false);
		guiGraphics.drawString(this.font, CurentlyBlankRedstonePowerTextCompProcedureProcedure.execute(world, x, y, z), 4, 155, -256, false);
		guiGraphics.drawString(this.font, ReturnNOBETALlamaModVersionProcedureProcedure.execute(), 220, 5, -16382202, false);
		if (IsThisBetaProcedureProcedure.execute())
			guiGraphics.drawString(this.font, Component.translatable("gui.llamamod.computergui.label_beta"), 227, -9, -65536, false);
	}

	@Override
	public void init() {
		super.init();
		number1 = new EditBox(this.font, this.leftPos + 4, this.topPos + 13, 120, 20, Component.translatable("gui.llamamod.computergui.number1"));
		number1.setMaxLength(8192);
		number1.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "number1", content, false);
		});
		number1.setHint(Component.translatable("gui.llamamod.computergui.number1"));
		this.addWidget(this.number1);
		number2 = new EditBox(this.font, this.leftPos + 4, this.topPos + 34, 120, 20, Component.translatable("gui.llamamod.computergui.number2"));
		number2.setMaxLength(8192);
		number2.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "number2", content, false);
		});
		number2.setHint(Component.translatable("gui.llamamod.computergui.number2"));
		this.addWidget(this.number2);
		operation = new EditBox(this.font, this.leftPos + 125, this.topPos + 13, 120, 20, Component.translatable("gui.llamamod.computergui.operation"));
		operation.setMaxLength(8192);
		operation.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "operation", content, false);
		});
		operation.setHint(Component.translatable("gui.llamamod.computergui.operation"));
		this.addWidget(this.operation);
		player_name = new EditBox(this.font, this.leftPos + 4, this.topPos + 76, 120, 20, Component.translatable("gui.llamamod.computergui.player_name"));
		player_name.setMaxLength(8192);
		player_name.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "player_name", content, false);
		});
		player_name.setHint(Component.translatable("gui.llamamod.computergui.player_name"));
		this.addWidget(this.player_name);
		msg = new EditBox(this.font, this.leftPos + 4, this.topPos + 97, 120, 20, Component.translatable("gui.llamamod.computergui.msg"));
		msg.setMaxLength(8192);
		msg.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "msg", content, false);
		});
		msg.setHint(Component.translatable("gui.llamamod.computergui.msg"));
		this.addWidget(this.msg);
		calculator_result = new EditBox(this.font, this.leftPos + 125, this.topPos + 34, 120, 20, Component.translatable("gui.llamamod.computergui.calculator_result"));
		calculator_result.setMaxLength(8192);
		calculator_result.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "calculator_result", content, false);
		});
		calculator_result.setHint(Component.translatable("gui.llamamod.computergui.calculator_result"));
		this.addWidget(this.calculator_result);
		button_x = Button.builder(Component.translatable("gui.llamamod.computergui.button_x"), e -> {
			int x = ComputerguiScreen.this.x;
			int y = ComputerguiScreen.this.y;
			if (true) {
				LlamamodMod.PACKET_HANDLER.sendToServer(new ComputerguiButtonMessage(0, x, y, z));
				ComputerguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 257, this.topPos + 0, 30, 20).build();
		this.addRenderableWidget(button_x);
		button_kill = Button.builder(Component.translatable("gui.llamamod.computergui.button_kill"), e -> {
			int x = ComputerguiScreen.this.x;
			int y = ComputerguiScreen.this.y;
			if (ComputerPlayerManagementPermissionCheckProcedure.execute(entity)) {
				LlamamodMod.PACKET_HANDLER.sendToServer(new ComputerguiButtonMessage(1, x, y, z));
				ComputerguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 187, this.topPos + 97, 46, 20).build();
		this.addRenderableWidget(button_kill);
		button_set = Button.builder(Component.translatable("gui.llamamod.computergui.button_set"), e -> {
			int x = ComputerguiScreen.this.x;
			int y = ComputerguiScreen.this.y;
			if (true) {
				LlamamodMod.PACKET_HANDLER.sendToServer(new ComputerguiButtonMessage(2, x, y, z));
				ComputerguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 140, this.topPos + 145, 40, 20).build();
		this.addRenderableWidget(button_set);
		button_random = Button.builder(Component.translatable("gui.llamamod.computergui.button_random"), e -> {
			int x = ComputerguiScreen.this.x;
			int y = ComputerguiScreen.this.y;
			if (true) {
				LlamamodMod.PACKET_HANDLER.sendToServer(new ComputerguiButtonMessage(3, x, y, z));
				ComputerguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 181, this.topPos + 145, 56, 20).build();
		this.addRenderableWidget(button_random);
		button_message = Button.builder(Component.translatable("gui.llamamod.computergui.button_message"), e -> {
			int x = ComputerguiScreen.this.x;
			int y = ComputerguiScreen.this.y;
			if (true) {
				LlamamodMod.PACKET_HANDLER.sendToServer(new ComputerguiButtonMessage(4, x, y, z));
				ComputerguiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 125, this.topPos + 97, 61, 20).build();
		this.addRenderableWidget(button_message);
		button_calculate = Button.builder(Component.translatable("gui.llamamod.computergui.button_calculate"), e -> {
			int x = ComputerguiScreen.this.x;
			int y = ComputerguiScreen.this.y;
			if (true) {
				LlamamodMod.PACKET_HANDLER.sendToServer(new ComputerguiButtonMessage(5, x, y, z));
				ComputerguiButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 172, this.topPos + 54, 72, 20).build();
		this.addRenderableWidget(button_calculate);
		button_clear_inventory = Button.builder(Component.translatable("gui.llamamod.computergui.button_clear_inventory"), e -> {
			int x = ComputerguiScreen.this.x;
			int y = ComputerguiScreen.this.y;
			if (ComputerPlayerManagementPermissionCheckProcedure.execute(entity)) {
				LlamamodMod.PACKET_HANDLER.sendToServer(new ComputerguiButtonMessage(6, x, y, z));
				ComputerguiButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 125, this.topPos + 76, 103, 20).build();
		this.addRenderableWidget(button_clear_inventory);
		button_clear_textboxes = Button.builder(Component.translatable("gui.llamamod.computergui.button_clear_textboxes"), e -> {
			int x = ComputerguiScreen.this.x;
			int y = ComputerguiScreen.this.y;
			if (ReturnComputerguiClearTextboxesButtonDisplayConditionProcedure.execute(entity)) {
				LlamamodMod.PACKET_HANDLER.sendToServer(new ComputerguiButtonMessage(7, x, y, z));
				ComputerguiButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 4, this.topPos + 119, 103, 20).build();
		this.addRenderableWidget(button_clear_textboxes);
		auto_calculate = new Checkbox(this.leftPos + 97, this.topPos + 55, 20, 20, Component.translatable("gui.llamamod.computergui.auto_calculate"), false) {
			@Override
			public void onPress() {
				super.onPress();
				if (!menuStateUpdateActive)
					menu.sendMenuStateUpdate(entity, 1, "auto_calculate", this.selected(), false);
			}
		};
		this.addRenderableWidget(auto_calculate);
		power_output = new ForgeSlider(this.leftPos + 93, this.topPos + 145, 46, 20, Component.translatable("gui.llamamod.computergui.power_output_prefix"), Component.translatable("gui.llamamod.computergui.power_output_suffix"), 0, 15, 0, 1, 0,
				true) {
			@Override
			protected void applyValue() {
				if (!menuStateUpdateActive)
					menu.sendMenuStateUpdate(entity, 2, "power_output", this.getValue(), false);
			}
		};
		this.addRenderableWidget(power_output);
		if (!menuStateUpdateActive)
			menu.sendMenuStateUpdate(entity, 2, "power_output", power_output.getValue(), false);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		number1.tick();
		number2.tick();
		operation.tick();
		player_name.tick();
		msg.tick();
		calculator_result.tick();
		this.button_kill.visible = ComputerPlayerManagementPermissionCheckProcedure.execute(entity);
		this.button_clear_inventory.visible = ComputerPlayerManagementPermissionCheckProcedure.execute(entity);
		this.button_clear_textboxes.visible = ReturnComputerguiClearTextboxesButtonDisplayConditionProcedure.execute(entity);
	}
}