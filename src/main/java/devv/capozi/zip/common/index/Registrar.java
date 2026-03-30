package devv.capozi.zip.common.index;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.*;

public @SuppressWarnings("all") class Registrar<T> {
    public final String mod_id;
    private List<String> ids = new ArrayList<>();
    private List<T> registryObjects = new ArrayList<>();
    public final Registry<T> registry;
    public Registrar(String mod_id, Registry<T> registry) {
        this.mod_id = mod_id;
        this.registry = registry;
    }
    public T add(String id, T object) {
        ids.add(id);
        registryObjects.add(object);
        if (registry == Registries.BLOCK) {
            return Registry.register(registry, Identifier.of(mod_id, id), object);
        }
        return object;
    }
    public void setRegistries() {
        if (ids.size() != registryObjects.size()) throw new RuntimeException("mismatched_object_key_array_size");
        if (registry == Registries.BLOCK) return;
        for (int i = 0; i < ids.size(); i++) {
            Registry.register(registry, Identifier.of(mod_id, ids.get(i)), registryObjects.get(i));
        }
    }
}
