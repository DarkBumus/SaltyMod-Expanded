package darkbum.saltymod.init;

import net.minecraft.block.Block;

/**
 * Sounds class.
 *
 * @author DarkBum
 * @since 1.9.f
 */
public class ModSounds {

    public static final Block.SoundType soundTypeMud = new Block.SoundType("MudBlock", 1.0F, 1.0F) {
        public String getBreakSound() {
            return "saltymod:block.mud.break";
        }
        public String getStepResourcePath() {
            return "saltymod:block.mud.step";
        }
    };

    public static final Block.SoundType soundTypeWetMudBrick = new Block.SoundType("MudBrickWet", 1.0F, 1.0F) {
        public String getBreakSound() {
            return "saltymod:block.wet_mud_bricks.break";
        }
        public String getStepResourcePath() {
            return "saltymod:block.wet_mud_bricks.step";
        }
    };

    public static final Block.SoundType soundTypeDryMudBrick = new Block.SoundType("MudBrickDry", 1.0F, 1.0F) {
        public String getBreakSound() {
            return "saltymod:block.dry_mud_bricks.break";
        }
        public String getStepResourcePath() {
            return "saltymod:block.dry_mud_bricks.step";
        }
    };

    public static final Block.SoundType soundTypeCookingPot = new Block.SoundType("CookingPot", 1.0F, 1.0F) {
        public String getBreakSound() { return "saltymod:block.cooking_pot.break"; }
        public String getStepResourcePath() { return "saltymod:block.cooking_pot.step"; }
    };


    /**
     * A customizable sound type class that allows for the use of default sounds or custom sound mappings.
     */
    @SuppressWarnings("unused")
    private static final class CustomSound extends Block.SoundType {

        private final boolean useDefaults;

        public CustomSound(String name, float volume, float pitch, boolean useDefaults) {
            super(name, volume, pitch);
            this.useDefaults = useDefaults;
        }

        public CustomSound(String name) {
            this(name, 1.0F, 1.0F, false);
        }

        public String getBreakSound() {
            return this.useDefaults ? super.getBreakSound() : this.soundName;
        }

        public String getStepResourcePath() {
            return this.useDefaults ? super.getStepResourcePath() : this.soundName;
        }
    }
}
