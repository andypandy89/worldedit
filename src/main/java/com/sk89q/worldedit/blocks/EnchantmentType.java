// $Id$
/*
 * WorldEdit
 * Copyright (C) 2010 sk89q <http://www.sk89q.com> and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package com.sk89q.worldedit.blocks;

import java.util.Map;
import java.util.HashMap;
import java.util.EnumSet;

/**
 * Enchantment types.
 * 
 */
public enum EnchantmentType {
    PROTECTION_ENVIRONMENTAL(ID.PROTECTION_ENVIRONMENTAL, "Protection", "protection"),
    PROTECTION_FIRE(ID.PROTECTION_FIRE, "Fire protection", new String[]{"fireprotection", "flameprotection"}),
    PROTECTION_FALL(ID.PROTECTION_FALL, "Feather falling", new String[]{"featherfalling", "fallprotection", "fallingprotection"}),
    PROTECTION_EXPLOSIONS(ID.PROTECTION_EXPLOSIONS, "Blast protection", new String[]{"explotionprotection", "explotionsprotection", "blastprotection"}),
    PROTECTION_PROJECTILE(ID.PROTECTION_PROJECTILE, "Projectile protection", "projectileprotection"),
    OXYGEN(ID.OXYGEN, "Respiration", new String[]{"respiration", "oxygen", "breathing"}),
    WATER_WORKER(ID.WATER_WORKER, "Aqua affinity", new String[]{"waterworker", "aquaaffinity", "watermine"}),
    THORNS(ID.THORNS, "Thorns", new String[]{"thorns", "highcrit", "thorn", "highercrit"}),
    DAMAGE_ALL(ID.DAMAGE_ALL, "Sharpness", new String[]{"alldamage", "sharpness", "sharp"}),
    DAMAGE_UNDEAD(ID.DAMAGE_UNDEAD, "Smite", new String[]{"smite", "damageundead", "undeaddamage"}),
    DAMAGE_ARTHROPODS(ID.DAMAGE_ARTHROPODS, "Bane of Arthropods", new String[]{"baneofarthropods", "baneofarthropod", "arthropod"}),
    KNOCKBACK(ID.KNOCKBACK, "Knockback", "knockback"),
    FIRE_ASPECT(ID.FIRE_ASPECT, "Fire aspect", new String[]{"fireaspect", "fire", "meleefire", "meleeflame"}),
    LOOT_BONUS_MOBS(ID.LOOT_BONUS_MOBS, "Looting", "looting"),
    DIG_SPEED(ID.DIG_SPEED, "Efficiency", new String[]{"efficiency", "digspeed", "minespeed"}),
    SILK_TOUCH(ID.SILK_TOUCH, "Silk touch", new String[]{"silktouch", "softtouch"}),
    DURABILITY(ID.DURABILITY, "Unbreaking", new String[]{"durability", "unbreaking"}),
    LOOT_BONUS_BLOCKS(ID.LOOT_BONUS_BLOCKS, "Fortune", new String[]{"fortune", "lootbonus"}),
    ARROW_DAMAGE(ID.ARROW_DAMAGE, "Power", new String[]{"power", "arrowdamage", "arrowpower"}),
    ARROW_KNOCKBACK(ID.ARROW_KNOCKBACK, "Punch", new String[]{"punch", "arrowpunch", "arrowknockback"}),
    ARROW_FIRE(ID.ARROW_FIRE, "Flame", new String[]{"firearrow", "flame", "flamearrow"}),
    ARROW_INFINITE(ID.ARROW_INFINITE, "Infinity", new String[]{"infinity", "infinite", "unlimited", "infinitearrows", "unlimitedarrows"}),
    LUCK(ID.LUCK, "Luck of the sea", new String[]{"luck", "luckofthesea", "luckofsea", "rodluck"}),
    LURE(ID.LURE, "Lure", new String[]{"lure", "rodlure"});

    public static final class ID {
        public final static int PROTECTION_ENVIRONMENTAL = 0;
        public final static int PROTECTION_FIRE = 1;
        public final static int PROTECTION_FALL = 2;
        public final static int PROTECTION_EXPLOSIONS = 3;
        public final static int PROTECTION_PROJECTILE = 4;
        public final static int OXYGEN = 5;
        public final static int WATER_WORKER = 6;
        public final static int THORNS = 7;
        public final static int DAMAGE_ALL = 16;
        public final static int DAMAGE_UNDEAD = 17;
        public final static int DAMAGE_ARTHROPODS = 18;
        public final static int KNOCKBACK = 19;
        public final static int FIRE_ASPECT = 20;
        public final static int LOOT_BONUS_MOBS = 21;
        public final static int DIG_SPEED = 22;
        public final static int SILK_TOUCH = 33;
        public final static int DURABILITY = 34;
        public final static int LOOT_BONUS_BLOCKS = 35;
        public final static int ARROW_DAMAGE = 48;
        public final static int ARROW_KNOCKBACK = 49;
        public final static int ARROW_FIRE = 50;
        public final static int ARROW_INFINITE = 51;
        public final static int LUCK = 61;
        public final static int LURE = 62;
    }

    /**
     * Stores a map of the IDs for fast access.
     */
    private static final Map<Integer, EnchantmentType> ids = new HashMap<Integer, EnchantmentType>();
    /**
     * Stores a map of the names for fast access.
     */
    private static final Map<String, EnchantmentType> lookup = new HashMap<String, EnchantmentType>();

    private final int id;
    private final String name;
    private final String[] lookupKeys;

    static {
        for (EnchantmentType type : EnumSet.allOf(EnchantmentType.class)) {
            ids.put(type.id, type);
            for (String key : type.lookupKeys) {
                lookup.put(key, type);
            }
        }
    }


    /**
     * Construct the type.
     *
     * @param id
     * @param name
     */
    EnchantmentType(int id, String name, String lookupKey) {
        this.id = id;
        this.name = name;
        this.lookupKeys = new String[] { lookupKey };
    }

    /**
     * Construct the type.
     *
     * @param id
     * @param name
     */
    EnchantmentType(int id, String name, String[] lookupKeys) {
        this.id = id;
        this.name = name;
        this.lookupKeys = lookupKeys;
    }

    /**
     * Return type from ID. May return null.
     *
     * @param id
     * @return
     */
    public static EnchantmentType fromID(int id) {
        return ids.get(id);
    }

    /**
     * Return type from name. May return null.
     *
     * @param name
     * @return
     */
    public static EnchantmentType lookup(String name) {
        return lookup.get(name.toLowerCase());
    }

    /**
     * Get enchantment numeric ID.
     *
     * @return
     */
    public int getID() {
        return id;
    }

    /**
     * Get user-friendly enchantment name.
     *
     * @return
     */
    public String getName() {
        return name;
    }
}
