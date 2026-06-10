# kiroEmuCore - Libretro Emulation Cores for kiroEmu

This repository contains the dynamic feature modules and precompiled assets for all emulator cores used by the **kiroEmu** Android emulator.

> **Note**: The main kiroEmu emulator repository is currently private.

The repository is structured specifically to integrate seamlessly with the main emulator app as a Git submodule (`kirozxy-cores`), providing both bundled cores and on-demand downloadable components.

---

## What's Included

Each folder in this repository represents an Android **Dynamic Feature Module** wrapping a pre-built Libretro shared library (`.so`) target:

### Supported Emulation Cores

*   **Nintendo**
    *   **NES / Famicom**: `kirozxy_core_fceumm` (FCEUmm)
    *   **SNES / Super Famicom**: `kirozxy_core_snes9x` (Snes9x)
    *   **Game Boy / Game Boy Color**: `kirozxy_core_gambatte` (Gambatte)
    *   **Game Boy Advance**: `kirozxy_core_mgba` (mGBA)
    *   **Nintendo 64**: `kirozxy_core_mupen64plus_next_gles3` (Mupen64Plus-Next)
    *   **Nintendo DS**: `kirozxy_core_desmume` (DeSmuME) / `kirozxy_core_melonds` (MelonDS)
    *   **Nintendo 3DS**: `kirozxy_core_citra` (Citra)
*   **Sony**
    *   **PlayStation / PSX**: `kirozxy_core_pcsx_rearmed` (PCSX ReARMed)
    *   **PlayStation Portable (PSP)**: `kirozxy_core_ppsspp` (PPSSPP)
*   **Sega**
    *   **Genesis / Master System / Game Gear / CD**: `kirozxy_core_genesis_plus_gx` (Genesis Plus GX)
*   **Atari**
    *   **Atari 2600**: `kirozxy_core_stella` (Stella)
    *   **Atari 7800**: `kirozxy_core_prosystem` (ProSystem)
    *   **Atari Lynx**: `kirozxy_core_handy` (Handy)
*   **Others & Arcade**
    *   **Arcade (FBNeo)**: `kirozxy_core_fbneo` (FinalBurn Neo)
    *   **Arcade (MAME)**: `kirozxy_core_mame2003_plus` (MAME 2003 Plus)
    *   **DOS**: `kirozxy_core_dosbox_pure` (DOSBox Pure)
    *   **PC Engine / TurboGrafx-16**: `kirozxy_core_mednafen_pce_fast` (Beetle PCE Fast)
    *   **Neo Geo Pocket / Color**: `kirozxy_core_mednafen_ngp` (Beetle NeoPop)
    *   **WonderSwan / Color**: `kirozxy_core_mednafen_wswan` (Beetle Cygne)

---

## Repository Structure

*   **`bundled-cores/`**: Assets and config files containing emulator cores that are bundled directly inside the base APK download.
*   **`kirozxy_core_*/`**: Individual Gradle feature modules containing ABI-specific `.so` files compiled for Android architectures (`armeabi-v7a`, `arm64-v8a`, `x86`, `x86_64`) along with build scripts.
*   **`assets/`**: Shared controller layouts, mapping tables, database assets, and dynamic config properties.

---

## How It Works in kiroEmu

This project is linked directly into the main `kiroEmu` project as a git submodule:

```bash
# How the main project references this repository
kiroEmu/
 └── kirozxy-cores/   <-- git submodule (kiroEmuCore)
```

In the main application, dynamic modules are registered in `settings.gradle.kts` and included during build time. This allows Play Feature Delivery to serve cores dynamically on-demand, keeping the initial app download footprint exceptionally lightweight.

