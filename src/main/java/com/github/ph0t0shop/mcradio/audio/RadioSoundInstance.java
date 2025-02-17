package com.github.ph0t0shop.mcradio.audio;

import net.minecraft.client.sound.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;

public class RadioSoundInstance extends PositionedSoundInstance {
    public RadioSoundInstance(RadioIdentifier id, float volume, int attenuation, AttenuationType attenuationType) {
        super(id, SoundCategory.RECORDS, volume, 1.0f, false, 0, attenuationType, id.getSpeakerX(), id.getSpeakerY(), id.getSpeakerZ(), false);
        this.sound = new LavaPlayerSound(id, attenuation);
    }

    @Override
    public boolean canPlay() {
        return true;
    }

    @Override
    public WeightedSoundSet getSoundSet(SoundManager soundManager) {
        return new WeightedSoundSet(this.id, this.id.getPath());
    }

    public static class LavaPlayerSound extends Sound {
        private RadioIdentifier rid;
        public LavaPlayerSound(RadioIdentifier id, int attenuation) {
            super(id.toString(), 1.0f, 1.0f, 1, RegistrationType.FILE, true, true, attenuation);
            rid = id;
        }

        @Override
        public Identifier getLocation() {
            return rid;
        }
    }
}

