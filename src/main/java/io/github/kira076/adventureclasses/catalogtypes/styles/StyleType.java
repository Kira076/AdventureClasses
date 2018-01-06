package io.github.kira076.adventureclasses.catalogtypes.styles;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.item.ItemType;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

@ConfigSerializable
public class StyleType implements CatalogType {
    @Setting(value = "name", comment = "Style Name")
    private final String name;
    @Setting(value = "id", comment = "Style ID")
    private final String id;
    @Setting(value = "profs", comment = "Style proficiencies")
    private List<ItemType> profs;


    public StyleType(@Nonnull final String name, @Nonnull final String id, @Nonnull ItemType... profs) {
        this.name = name;
        this.id = id;
        this.profs = Arrays.asList(profs);
    }


    public List<ItemType> getProfs() {return this.profs;}

    @Override @Nonnull public String getName() { return name; }
    @Override @Nonnull public String getId() { return id; }

    public void addProf(ItemType item) { this.profs.add(item); }
    public void addProf(ItemType... items) { this.profs.addAll(Arrays.asList(items)); }
}
