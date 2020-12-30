package me.Aqua_rel.HypixelBedwars.Utilities;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;

public class GetPlayerHead {
    private static Method metaSetProfileMethod;
    private static Field metaProfileField;

    public static void mutateItemMeta(SkullMeta meta, String b64) {
        try {
            if (metaProfileField == null) {
                metaProfileField = meta.getClass().getDeclaredField("profile");
                metaProfileField.setAccessible(true);
            }
            metaProfileField.set(meta, makeProfile(b64));

        } catch (NoSuchFieldException | IllegalAccessException ex2) {
            ex2.printStackTrace();
        }
    }

    private static GameProfile makeProfile(String b64) {
        UUID id = new UUID(
                b64.substring(b64.length() - 20).hashCode(),
                b64.substring(b64.length() - 10).hashCode()
        );
        GameProfile profile = new GameProfile(id, "aaaaa");
        profile.getProperties().put("textures", new Property("textures", b64));
        return profile;
    }

}
