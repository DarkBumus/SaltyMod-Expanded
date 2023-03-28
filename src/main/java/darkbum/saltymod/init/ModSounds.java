package darkbum.saltymod.init;

import net.minecraft.block.Block;

public class ModSounds {

	public static final Block.SoundType soundFizz = new CustomSound("random.fizz", 0.3F, 2.0F, false);

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
