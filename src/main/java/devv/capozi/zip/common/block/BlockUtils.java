package devv.capozi.zip.common.block;

import net.minecraft.block.BlockState;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.shape.VoxelShape;

import java.util.List;

public class BlockUtils {
    public VoxelShape varyingBlockstateModel(BlockState state, IntProperty property, List<VoxelShape> providedVoxelShapes) {
        VoxelShape voxelShape = providedVoxelShapes.get(state.get(property));
        return voxelShape;
    }
}
