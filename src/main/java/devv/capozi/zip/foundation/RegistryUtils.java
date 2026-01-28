package devv.capozi.zip.foundation;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class RegistryUtils {
    public static Block registerBlock(String mod_id, String name, Block block, boolean registerBlockItem) {
        if (registerBlockItem) {
            registerBlockItem(mod_id, name, block);
        }
        return Registry.register(Registries.BLOCK, new Identifier(mod_id, name), block);
    }
    public static Item registerBlockItem(String mod_id, String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(mod_id, name), new BlockItem(block, new FabricItemSettings()));
    }
    public static RegistryKey<DamageType> registerDamageType(String mod_id, String path) {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(mod_id, path));
    }
    public static RegistryEntry<StatusEffect> registerStatusEffect(String mod_id, String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(mod_id, name),statusEffect);
    }
    public static Enchantment registerEnchantment(String mod_id, String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(mod_id, name), enchantment);
    }
    public static Item registerItems(String mod_id, String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(mod_id, name), item);
    }
    public static SoundEvent registerSoundEvent(String mod_id, String name) {
        Identifier id = new Identifier(mod_id, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
