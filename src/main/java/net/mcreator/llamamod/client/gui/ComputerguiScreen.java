package net.mcreator.llamamod.client.gui;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.client.gui.widget.ExtendedSlider;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.llamamod.world.inventory.ComputerguiMenu;
import net.mcreator.llamamod.procedures.ReturnTrueProcedure;
import net.mcreator.llamamod.procedures.Ifplayerhaspermission2Procedure;
import net.mcreator.llamamod.procedures.GettimeasstringProcedure;
import net.mcreator.llamamod.procedures.ComputercalculateprocidureProcedure;
import net.mcreator.llamamod.procedures.CompmsgnotblankProcedure;
import net.mcreator.llamamod.network.ComputerguiSliderMessage;
import net.mcreator.llamamod.network.ComputerguiButtonMessage;
import net.mcreator.llamamod.init.LlamaModModScreens;

public class ComputerguiScreen extends AbstractContainerScreen<ComputerguiMenu> implements LlamaModModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox number1;
	private EditBox number2;
	private EditBox operation;
	private EditBox player_name;
	private EditBox msgbox;
	private EditBox msg;
	private EditBox result;
	private Checkbox includedRand;
	private Button button_x;
	private Button button_clear_inventory;
	private Button button_kill;
	private Button button_load;
	private Button button_save;
	private Button button_meassage;
	private Button button_generate;
	private Button button_set;
	private Button button_random;
	private ExtendedSlider minimumRand;
	private ExtendedSlider maximumRand;
	private ExtendedSlider power_output;

	public ComputerguiScreen(ComputerguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 256;
		this.imageHeight = 200;
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
			else if (name.equals("msgbox"))
				msgbox.setValue(stringState);
			else if (name.equals("msg"))
				msg.setValue(stringState);
			else if (name.equals("result"))
				result.setValue(stringState);
		}
		if (elementType == 1 && elementState instanceof Boolean logicState) {
			if (name.equals("includedRand")) {
				if (includedRand.selected() != logicState)
					includedRand.onPress();
			}
		}
		if (elementType == 2 && elementState instanceof Number n) {
			if (name.equals("minimumRand"))
				minimumRand.setValue(n.doubleValue());
			else if (name.equals("maximumRand"))
				maximumRand.setValue(n.doubleValue());
			else if (name.equals("power_output"))
				power_output.setValue(n.doubleValue());
		}
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("llama_mod:textures/screens/computergui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		number1.render(guiGraphics, mouseX, mouseY, partialTicks);
		number2.render(guiGraphics, mouseX, mouseY, partialTicks);
		operation.render(guiGraphics, mouseX, mouseY, partialTicks);
		player_name.render(guiGraphics, mouseX, mouseY, partialTicks);
		msgbox.render(guiGraphics, mouseX, mouseY, partialTicks);
		msg.render(guiGraphics, mouseX, mouseY, partialTicks);
		result.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
		if (msgbox.isFocused())
			return msgbox.keyPressed(key, b, c);
		if (msg.isFocused())
			return msg.keyPressed(key, b, c);
		if (result.isFocused())
			return result.keyPressed(key, b, c);
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
		String msgboxValue = msgbox.getValue();
		String msgValue = msg.getValue();
		String resultValue = result.getValue();
		super.resize(minecraft, width, height);
		number1.setValue(number1Value);
		number2.setValue(number2Value);
		operation.setValue(operationValue);
		player_name.setValue(player_nameValue);
		msgbox.setValue(msgboxValue);
		msg.setValue(msgValue);
		result.setValue(resultValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.llama_mod.computergui.label_calculator"), 6, 5, -12829636, false);
		guiGraphics.drawString(this.font, GettimeasstringProcedure.execute(world), 31, -11, -16711936, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.llama_mod.computergui.label_player_controll"), 6, 57, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.llama_mod.computergui.label_result"), 128, 34, -12829636, false);
		guiGraphics.drawString(this.font, ComputercalculateprocidureProcedure.execute(entity), 128, 43, -65536, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.llama_mod.computergui.label_meassage"), 6, 110, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.llama_mod.computergui.label_random_number"), 6, 141, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.llama_mod.computergui.label_time"), 4, -11, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.llama_mod.computergui.label_redstone_output"), 5, 201, -1, false);
	}

	@Override
	public void init() {
		super.init();
		number1 = new EditBox(this.font, this.leftPos + 6, this.topPos + 14, 118, 18, Component.translatable("gui.llama_mod.computergui.number1"));
		number1.setMaxLength(8192);
		number1.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "number1", content, false);
		});
		number1.setHint(Component.translatable("gui.llama_mod.computergui.number1"));
		this.addWidget(this.number1);
		number2 = new EditBox(this.font, this.leftPos + 6, this.topPos + 35, 118, 18, Component.translatable("gui.llama_mod.computergui.number2"));
		number2.setMaxLength(8192);
		number2.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "number2", content, false);
		});
		number2.setHint(Component.translatable("gui.llama_mod.computergui.number2"));
		this.addWidget(this.number2);
		operation = new EditBox(this.font, this.leftPos + 127, this.topPos + 14, 118, 18, Component.translatable("gui.llama_mod.computergui.operation"));
		operation.setMaxLength(8192);
		operation.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "operation", content, false);
		});
		operation.setHint(Component.translatable("gui.llama_mod.computergui.operation"));
		this.addWidget(this.operation);
		player_name = new EditBox(this.font, this.leftPos + 6, this.topPos + 67, 118, 18, Component.translatable("gui.llama_mod.computergui.player_name"));
		player_name.setMaxLength(8192);
		player_name.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "player_name", content, false);
		});
		player_name.setHint(Component.translatable("gui.llama_mod.computergui.player_name"));
		this.addWidget(this.player_name);
		msgbox = new EditBox(this.font, this.leftPos + 6, this.topPos + 120, 118, 18, Component.translatable("gui.llama_mod.computergui.msgbox"));
		msgbox.setMaxLength(8192);
		msgbox.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "msgbox", content, false);
		});
		msgbox.setHint(Component.translatable("gui.llama_mod.computergui.msgbox"));
		this.addWidget(this.msgbox);
		msg = new EditBox(this.font, this.leftPos + 6, this.topPos + 88, 118, 18, Component.translatable("gui.llama_mod.computergui.msg"));
		msg.setMaxLength(8192);
		msg.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "msg", content, false);
		});
		msg.setHint(Component.translatable("gui.llama_mod.computergui.msg"));
		this.addWidget(this.msg);
		result = new EditBox(this.font, this.leftPos + 75, this.topPos + 173, 118, 18, Component.translatable("gui.llama_mod.computergui.result"));
		result.setMaxLength(8192);
		result.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "result", content, false);
		});
		result.setHint(Component.translatable("gui.llama_mod.computergui.result"));
		this.addWidget(this.result);
		button_x = Button.builder(Component.translatable("gui.llama_mod.computergui.button_x"), e -> {
			int x = ComputerguiScreen.this.x;
			int y = ComputerguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new ComputerguiButtonMessage(0, x, y, z));
				ComputerguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 226, this.topPos + -20, 30, 20).build();
		this.addRenderableWidget(button_x);
		button_clear_inventory = Button.builder(Component.translatable("gui.llama_mod.computergui.button_clear_inventory"), e -> {
			int x = ComputerguiScreen.this.x;
			int y = ComputerguiScreen.this.y;
			if (Ifplayerhaspermission2Procedure.execute(entity)) {
				ClientPacketDistributor.sendToServer(new ComputerguiButtonMessage(1, x, y, z));
				ComputerguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 127, this.topPos + 66, 103, 20).build();
		this.addRenderableWidget(button_clear_inventory);
		button_kill = Button.builder(Component.translatable("gui.llama_mod.computergui.button_kill"), e -> {
			int x = ComputerguiScreen.this.x;
			int y = ComputerguiScreen.this.y;
			if (Ifplayerhaspermission2Procedure.execute(entity)) {
				ClientPacketDistributor.sendToServer(new ComputerguiButtonMessage(2, x, y, z));
				ComputerguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 195, this.topPos + 87, 46, 20).build();
		this.addRenderableWidget(button_kill);
		button_load = Button.builder(Component.translatable("gui.llama_mod.computergui.button_load"), e -> {
			int x = ComputerguiScreen.this.x;
			int y = ComputerguiScreen.this.y;
			if (CompmsgnotblankProcedure.execute(world, x, y, z)) {
				ClientPacketDistributor.sendToServer(new ComputerguiButtonMessage(3, x, y, z));
				ComputerguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 174, this.topPos + 119, 46, 20).build();
		this.addRenderableWidget(button_load);
		button_save = Button.builder(Component.translatable("gui.llama_mod.computergui.button_save"), e -> {
			int x = ComputerguiScreen.this.x;
			int y = ComputerguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new ComputerguiButtonMessage(4, x, y, z));
				ComputerguiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 127, this.topPos + 119, 46, 20).build();
		this.addRenderableWidget(button_save);
		button_meassage = Button.builder(Component.translatable("gui.llama_mod.computergui.button_meassage"), e -> {
			int x = ComputerguiScreen.this.x;
			int y = ComputerguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new ComputerguiButtonMessage(5, x, y, z));
				ComputerguiButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 127, this.topPos + 87, 67, 20).build();
		this.addRenderableWidget(button_meassage);
		button_generate = Button.builder(Component.translatable("gui.llama_mod.computergui.button_generate"), e -> {
			int x = ComputerguiScreen.this.x;
			int y = ComputerguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new ComputerguiButtonMessage(6, x, y, z));
				ComputerguiButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 5, this.topPos + 172, 67, 20).build();
		this.addRenderableWidget(button_generate);
		button_set = Button.builder(Component.translatable("gui.llama_mod.computergui.button_set"), e -> {
			int x = ComputerguiScreen.this.x;
			int y = ComputerguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new ComputerguiButtonMessage(7, x, y, z));
				ComputerguiButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 141, this.topPos + 199, 40, 20).build();
		this.addRenderableWidget(button_set);
		button_random = Button.builder(Component.translatable("gui.llama_mod.computergui.button_random"), e -> {
			int x = ComputerguiScreen.this.x;
			int y = ComputerguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new ComputerguiButtonMessage(8, x, y, z));
				ComputerguiButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}).bounds(this.leftPos + 184, this.topPos + 199, 56, 20).build();
		this.addRenderableWidget(button_random);
		boolean includedRandSelected = ReturnTrueProcedure.execute();
		includedRand = Checkbox.builder(Component.translatable("gui.llama_mod.computergui.includedRand"), this.font).pos(this.leftPos + 144, this.topPos + 151).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "includedRand", value, false);
		}).selected(includedRandSelected).build();
		if (includedRandSelected)
			menu.sendMenuStateUpdate(entity, 1, "includedRand", true, false);
		this.addRenderableWidget(includedRand);
		minimumRand = new ExtendedSlider(this.leftPos + 5, this.topPos + 151, 67, 20, Component.translatable("gui.llama_mod.computergui.minimumRand_prefix"), Component.translatable("gui.llama_mod.computergui.minimumRand_suffix"), -1000, 1000, 0, 1,
				0, true) {
			@Override
			protected void applyValue() {
				if (!menuStateUpdateActive)
					menu.sendMenuStateUpdate(entity, 2, "minimumRand", this.getValue(), false);
				ClientPacketDistributor.sendToServer(new ComputerguiSliderMessage(0, x, y, z, this.getValue()));
				ComputerguiSliderMessage.handleSliderAction(entity, 0, x, y, z, this.getValue());
			}
		};
		this.addRenderableWidget(minimumRand);
		if (!menuStateUpdateActive)
			menu.sendMenuStateUpdate(entity, 2, "minimumRand", minimumRand.getValue(), false);
		maximumRand = new ExtendedSlider(this.leftPos + 74, this.topPos + 151, 67, 20, Component.translatable("gui.llama_mod.computergui.maximumRand_prefix"), Component.translatable("gui.llama_mod.computergui.maximumRand_suffix"), -1000, 1000, 1000,
				1, 0, true) {
			@Override
			protected void applyValue() {
				if (!menuStateUpdateActive)
					menu.sendMenuStateUpdate(entity, 2, "maximumRand", this.getValue(), false);
				ClientPacketDistributor.sendToServer(new ComputerguiSliderMessage(1, x, y, z, this.getValue()));
				ComputerguiSliderMessage.handleSliderAction(entity, 1, x, y, z, this.getValue());
			}
		};
		this.addRenderableWidget(maximumRand);
		if (!menuStateUpdateActive)
			menu.sendMenuStateUpdate(entity, 2, "maximumRand", maximumRand.getValue(), false);
		power_output = new ExtendedSlider(this.leftPos + 92, this.topPos + 199, 46, 20, Component.translatable("gui.llama_mod.computergui.power_output_prefix"), Component.translatable("gui.llama_mod.computergui.power_output_suffix"), 0, 15, 0, 1, 0,
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
		this.button_clear_inventory.visible = Ifplayerhaspermission2Procedure.execute(entity);
		this.button_kill.visible = Ifplayerhaspermission2Procedure.execute(entity);
		this.button_load.visible = CompmsgnotblankProcedure.execute(world, x, y, z);
	}
}