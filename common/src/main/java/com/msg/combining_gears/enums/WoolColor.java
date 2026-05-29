package com.msg.combining_gears.enums;

import java.util.Arrays;
import java.util.function.IntFunction;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.ByIdMap.OutOfBoundsStrategy;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.util.StringRepresentable;

public enum WoolColor implements StringRepresentable {
    WHITE(0, "white", Items.WHITE_WOOL),
    ORANGE(1, "orange", Items.ORANGE_WOOL),
    MAGENTA(2, "magenta", Items.MAGENTA_WOOL),
    LIGHT_BLUE(3, "light_blue", Items.LIGHT_BLUE_WOOL),
    YELLOW(4, "yellow", Items.YELLOW_WOOL),
    LIME(5, "lime", Items.LIME_WOOL),
    PINK(6, "pink", Items.PINK_WOOL),
    GRAY(7, "gray", Items.GRAY_WOOL),
    LIGHT_GRAY(8, "light_gray", Items.LIGHT_GRAY_WOOL),
    CYAN(9, "cyan", Items.CYAN_WOOL),
    PURPLE(10, "purple", Items.PURPLE_WOOL),
    BLUE(11, "blue", Items.BLUE_WOOL),
    BROWN(12, "brown", Items.BROWN_WOOL),
    GREEN(13, "green", Items.GREEN_WOOL),
    RED(14, "red", Items.RED_WOOL),
    BLACK(15, "black", Items.BLACK_WOOL);
    private static final IntFunction<WoolColor> BY_ID = ByIdMap.continuous(WoolColor::getId, values(), OutOfBoundsStrategy.ZERO);
    public static final StringRepresentable.EnumCodec<WoolColor> CODEC = StringRepresentable.fromEnum(WoolColor::values);
    public static final StreamCodec<ByteBuf, WoolColor> STREAM_CODEC = ByteBufCodecs.idMapper(BY_ID, WoolColor::getId);

    private final int id;
    private final String name;
    private final Item woolItem;

    private WoolColor(final int id, final String name, Item woolItem) {
        this.id = id;
        this.name = name;
        this.woolItem = woolItem;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Item getWoolItem() {
        return this.woolItem;
    }

    public static WoolColor byId(int id) {
        return BY_ID.apply(id);
    }

    @Nullable
    @Contract("_,!null->!null;_,null->_")
    public static WoolColor byName(String translationKey, @Nullable WoolColor fallback) {
        WoolColor woolColor = (WoolColor)CODEC.byName(translationKey);
        return woolColor != null ? woolColor : fallback;
    }

    @Nullable
    public static WoolColor byItem(Item item) {
        return Arrays.stream(values())
                .filter(color -> color.woolItem == item)
                .findFirst()
                .orElse(null);
}

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}
