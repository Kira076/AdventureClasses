package io.github.kira076.adventureclasses.utils;

import com.google.common.reflect.TypeToken;
import io.github.kira076.adventureclasses.catalogtypes.styles.StyleType;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import ninja.leaping.configurate.objectmapping.serialize.TypeSerializer;
import org.spongepowered.api.item.ItemType;

import java.util.List;

public class StyleSerializer implements TypeSerializer<StyleType> {

    @Override
    public StyleType deserialize(TypeToken<?> type, ConfigurationNode value) throws ObjectMappingException {
        String name = value.getNode("name").getString();
        String id = value.getNode("id").getString();
        List<ItemType> profsList = value.getNode("profs").getList(TypeToken.of(ItemType.class));
        return new StyleType(name, id, profsList.toArray(new ItemType[]{}));
    }

    @Override
    public void serialize(TypeToken<?> type, StyleType obj, ConfigurationNode value) throws ObjectMappingException {
        value.getNode("name").setValue(obj.getName());
        value.getNode("id").setValue(obj.getId());
        value.getNode("profs").setValue(obj.getProfs());
    }
}
