package devv.capozi.zip.common.index;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.*;

/**
 * Registrar is a registry system wherein the Type {@code T} of {@code Registrar}
 * determines the Minecraft registry that objects added to it are put into. Methods
 * in this class that would normally have a {@code return} value instead return an
 * value of Type {@code T}
 * <p> The Registrar class provides a versilitle way to store and access registries while
 * keeping unrelated registries seperate from others. </p>
 */
public @SuppressWarnings("all") class Registrar<T> {
    public final String mod_id;
    private List<String> ids = new ArrayList<>();
    private List<T> registryObjects = new ArrayList<>();
    public final Registry<T> registry;

    /**
     * The Constructor determines the namespace of objects and the registry instance to which they are added
     * @param mod_id Namespace under which to register objects
     * @param registry Registry instace in which Objects are placed
     */
    public Registrar(String mod_id, Registry<T> registry) {
        this.mod_id = mod_id;
        this.registry = registry;
    }
    /**
     * Using the {@code add(String id, T object)} method is used to add objects to a registrar
     * instance. By adding objects, the user can determine precisely what they want to register.
     *
     * @param id Takes in the Id of your registry object
     * @param object An object to be registered that matches {@code T}, the class type
     * @return {@code T}, An object of the same class as the class type
     */
    public T add(String id, T object) {
        ids.add(id);
        registryObjects.add(object);
        return object;
    }
    /**
     * Calling this method will cause all objects in {@code registryObjects} to be added to the
     * selected registry of mathcing type with an id of a simliar List index to {@code ids}. If the size of
     * {@code ids} and {@code registryObjects} will cause an {@code IllegalStateException}
     * @throws  IllegalStateException
     */
    public void setRegistries() {
        if (ids.size() != registryObjects.size()) throw new IllegalStateException("mismatched_object_key_array_size");
        for (int i = 0; i < ids.size(); i++) {
            Registry.register(registry, Identifier.of(mod_id, ids.get(i)), registryObjects.get(i));
        }
    }
}