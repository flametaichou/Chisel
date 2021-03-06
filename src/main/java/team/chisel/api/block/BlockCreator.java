package team.chisel.api.block;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

@ParametersAreNonnullByDefault
public interface BlockCreator<T extends Block & ICarvable> {

    T createBlock(Material mat, int index, int maxVariation, VariationData... data);

}
