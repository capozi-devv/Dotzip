package devv.capozi.zip.common.util;

import java.awt.*;

public class ColorUtils {

    // Convert RGB (0–255) to Hex
    public static String rgbToHex(int r, int g, int b) {
        return String.format(
                "#%02X%02X%02X",
                clamp(r),
                clamp(g),
                clamp(b)
        );
    }

    // Convert Hex to Color
    public static Color hexToColor(String hex) {
        return Color.decode(hex);
    }

    // Convert RGB to HSL (H: 0–360, S/L: 0–1)
    public static float[] rgbToHSL(int r, int g, int b) {
        float rf = clamp(r) / 255.0F;
        float gf = clamp(g) / 255.0F;
        float bf = clamp(b) / 255.0F;

        float max = Math.max(rf, Math.max(gf, bf));
        float min = Math.min(rf, Math.min(gf, bf));
        float delta = max - min;

        float h;
        float s;
        float l = (max + min) / 2.0F;

        if (delta == 0.0F) {
            h = 0.0F;
            s = 0.0F;
        } else {
            s = delta / (1.0F - Math.abs(2.0F * l - 1.0F));

            if (max == rf) {
                h = ((gf - bf) / delta) % 6.0F;
            } else if (max == gf) {
                h = ((bf - rf) / delta) + 2.0F;
            } else {
                h = ((rf - gf) / delta) + 4.0F;
            }

            h *= 60.0F;

            if (h < 0.0F) {
                h += 360.0F;
            }
        }

        return new float[] { h, s, l };
    }

    // Convert HSV (H: 0–360, S/V: 0–1) to Color
    public static Color hsvToColor(float h, float s, float v) {
        h = (h % 360.0F + 360.0F) % 360.0F;
        s = clamp01(s);
        v = clamp01(v);

        float c = v * s;
        float x = c * (1.0F - Math.abs((h / 60.0F) % 2.0F - 1.0F));
        float m = v - c;

        float rf;
        float gf;
        float bf;

        if (h < 60.0F) {
            rf = c;
            gf = x;
            bf = 0.0F;
        } else if (h < 120.0F) {
            rf = x;
            gf = c;
            bf = 0.0F;
        } else if (h < 180.0F) {
            rf = 0.0F;
            gf = c;
            bf = x;
        } else if (h < 240.0F) {
            rf = 0.0F;
            gf = x;
            bf = c;
        } else if (h < 300.0F) {
            rf = x;
            gf = 0.0F;
            bf = c;
        } else {
            rf = c;
            gf = 0.0F;
            bf = x;
        }

        int r = clamp(Math.round((rf + m) * 255.0F));
        int g = clamp(Math.round((gf + m) * 255.0F));
        int b = clamp(Math.round((bf + m) * 255.0F));

        return new Color(r, g, b);
    }

    // Convert HSL (H: 0–360, S/L: 0–1) to Color
    public static Color hslToColor(float h, float s, float l) {
        h = (h % 360.0F + 360.0F) % 360.0F;
        s = clamp01(s);
        l = clamp01(l);

        float c = (1.0F - Math.abs(2.0F * l - 1.0F)) * s;
        float x = c * (1.0F - Math.abs((h / 60.0F) % 2.0F - 1.0F));
        float m = l - c / 2.0F;

        float rf;
        float gf;
        float bf;

        if (h < 60.0F) {
            rf = c;
            gf = x;
            bf = 0.0F;
        } else if (h < 120.0F) {
            rf = x;
            gf = c;
            bf = 0.0F;
        } else if (h < 180.0F) {
            rf = 0.0F;
            gf = c;
            bf = x;
        } else if (h < 240.0F) {
            rf = 0.0F;
            gf = x;
            bf = c;
        } else if (h < 300.0F) {
            rf = x;
            gf = 0.0F;
            bf = c;
        } else {
            rf = c;
            gf = 0.0F;
            bf = x;
        }

        int r = clamp(Math.round((rf + m) * 255.0F));
        int g = clamp(Math.round((gf + m) * 255.0F));
        int b = clamp(Math.round((bf + m) * 255.0F));

        return new Color(r, g, b);
    }

    // Brightness adjustment
    public static Color adjustBrightness(Color color, float factor) {
        int r = clamp((int) (color.getRed() * factor));
        int g = clamp((int) (color.getGreen() * factor));
        int b = clamp((int) (color.getBlue() * factor));

        return new Color(r, g, b, color.getAlpha());
    }

    // Alpha blending (0.0–1.0 alpha)
    public static Color blend(Color base, Color overlay, float alpha) {
        float invAlpha = 1.0F - alpha;

        int r = clamp((int) (base.getRed() * invAlpha + overlay.getRed() * alpha));
        int g = clamp((int) (base.getGreen() * invAlpha + overlay.getGreen() * alpha));
        int b = clamp((int) (base.getBlue() * invAlpha + overlay.getBlue() * alpha));

        return new Color(r, g, b);
    }

    // Interpolate between two colors
    public static Color lerpColor(Color c1, Color c2, float t) {
        int r = clamp((int) (c1.getRed() + (c2.getRed() - c1.getRed()) * t));
        int g = clamp((int) (c1.getGreen() + (c2.getGreen() - c1.getGreen()) * t));
        int b = clamp((int) (c1.getBlue() + (c2.getBlue() - c1.getBlue()) * t));

        return new Color(r, g, b);
    }

    // Make a color transparent
    public static Color setAlpha(Color color, int alpha) {
        return new Color(
                color.getRed(),
                color.getGreen(),
                color.getBlue(),
                clamp(alpha)
        );
    }

    private static int clamp(int value) {
        return Math.max(0, Math.min(255, value));
    }

    private static float clamp01(float value) {
        if (value < 0.0F) {
            return 0.0F;
        }

        if (value > 1.0F) {
            return 1.0F;
        }

        return value;
    }
}

