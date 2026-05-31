package devv.capozi.zip.common.api.index;

import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * Registrar is a registry system wherein the Type {@code T} of {@code Registrar}
 * determines the Minecraft registry that objects added to it are put into. Methods
 * in this class that would normally have a {@code return} value instead return an
 * value of Type {@code T}
 * <p> The Registrar class provides a versilitle way to store and access registries while
 * keeping unrelated registries seperate from others. </p>
 */
public @SuppressWarnings("all") class Registrar<T> {
    public Map<Identifier, T> entries = new LinkedHashMap<>();
    public final BiConsumer<Identifier, T> registry_consumer;
    /**
     * The Constructor determines the namespace of objects and the registry instance to which they are added
     * @param mod_id Namespace under which to register objects
     * @param registry Registry instace in which Objects are placed
     */
    public Registrar(BiConsumer<Identifier, T> registry_consumer) {
        this.registry_consumer = registry_consumer;
    }
    /**
     * Using the {@code add(String id, T object)} method is used to add objects to a registrar
     * instance. By adding objects, the user can determine precisely what they want to register.
     *
     * @param id Takes in the Id of your registry object
     * @param object An object to be registered that matches {@link T}, the class type
     * @return {@link T}, An object of the same class as the class type
     */
    public T add(Identifier id, T object) {
        if (entries.containsKey(id)) {
            throw new IllegalStateException("Duplicate object: " + id);
        }
        if (entries.containsValue(object)) {
            throw new IllegalStateException("Duplicate identifier: " + id);
        }
        entries.put(id, object);
        return object;
    }

    /**
     * The of method allows any amount of objects to be registered in one method. Using this also allows
     * users to create final instances of {@link Registrar}
     <pre>{@code
     *         public final Registrar<Item> example = Registrar.of(MOD_ID, Registries.ITEM, new Identifier[] {}, new Item[] {});
     * }</pre>
     * @param namespace The name under which objects and their ids are set
     * @param registry The {@link Registry} instance under which objects are added
     * @param ids The instances of {@link Identifier} that serve as object ids
     * @param objects The instances of class type {@link T} that are being registered
     * @return A new instance of the Registrar with the {@code Identifier[] ids} and
     * {@code T[] objects} built in to it
     * @throws IllegalStateException
     */
    public static <T> Registrar of(String namespace, Registry<T> registry, Identifier[] ids, T[] objects) throws IllegalStateException {
        if (ids.length != objects.length) throw new IllegalStateException("Every object must have an attached String id");
        Registrar<T> registrar = new Registrar<T>(((identifier, t) -> Registry.register(registry, identifier, t)));
        for (int i = 0; i < ids.length; i++) {
            if (registrar.entries.containsKey(ids[i])) {
                throw new IllegalStateException("Duplicate object: " + ids[i]);
            }
            if (registrar.entries.containsValue(objects[i])) {
                throw new IllegalStateException("Duplicate identifier: " + objects[i]);
            }
            registrar.entries.put(ids[i], objects[i]);
        }
        setRegistries(registrar.entries, registrar.registry_consumer);
        return registrar;
    }
    /**
     * Calling this method will cause all objects in {@code entries} to be added to the
     * selected registry of matching type with their corresponding id.
     */
    public static <T> void setRegistries(Map<Identifier, T> entries, BiConsumer<Identifier, T> registerer) {
        entries.forEach(registerer);
    }
}