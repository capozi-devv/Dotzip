package devv.capozi.zip.common.util;

import net.minecraft.text.ClickEvent;
import net.minecraft.text.HoverEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.awt.Color;
import java.util.List;
import java.util.function.UnaryOperator;

public class TextsUtils {

    /* ============================================================ */
    /* Creation                                                     */
    /* ============================================================ */

    public MutableText literal(String text) {
        return Text.literal(text);
    }

    public MutableText translatable(String key, Object... args) {
        return Text.translatable(key, args);
    }

    public MutableText empty() {
        return Text.empty();
    }

    /* ============================================================ */
    /* Color style overloads                                        */
    /* ============================================================ */

    public UnaryOperator<Style> colorRgb(int r, int g, int b) {
        Color color = new Color(
                clamp(r),
                clamp(g),
                clamp(b)
        );

        return style -> style.withColor(color.getRGB() & 0xFFFFFF);
    }

    public UnaryOperator<Style> colorRgb(int rgb) {
        return style -> style.withColor(rgb & 0xFFFFFF);
    }

    public UnaryOperator<Style> colorHex(String hex) {
        Color color = ColorUtils.hexToColor(hex);

        return style -> style.withColor(color.getRGB() & 0xFFFFFF);
    }

    public UnaryOperator<Style> colorHsv(float h, float s, float v) {
        Color color = ColorUtils.hsvToColor(h, s, v);

        return style -> style.withColor(color.getRGB() & 0xFFFFFF);
    }

    public UnaryOperator<Style> colorHsl(float h, float s, float l) {
        Color color = ColorUtils.hslToColor(h, s, l);

        return style -> style.withColor(color.getRGB() & 0xFFFFFF);
    }

    /* ============================================================ */
    /* Styling helpers                                              */
    /* ============================================================ */

    public UnaryOperator<Style> bold() {
        return style -> style.withBold(true);
    }

    public UnaryOperator<Style> italic() {
        return style -> style.withItalic(true);
    }

    public UnaryOperator<Style> underline() {
        return style -> style.withUnderline(true);
    }

    public UnaryOperator<Style> strikethrough() {
        return style -> style.withStrikethrough(true);
    }

    public UnaryOperator<Style> obfuscated() {
        return style -> style.withObfuscated(true);
    }

    public UnaryOperator<Style> formatting(Formatting formatting) {
        return style -> style.withFormatting(formatting);
    }

    public UnaryOperator<Style> font(Identifier font) {
        return style -> style.withFont(font);
    }

    public UnaryOperator<Style> hover(Text hover) {
        return style -> style.withHoverEvent(
                new HoverEvent(
                        HoverEvent.Action.SHOW_TEXT,
                        hover
                )
        );
    }

    public UnaryOperator<Style> clickRun(String command) {
        return style -> style.withClickEvent(
                new ClickEvent(
                        ClickEvent.Action.RUN_COMMAND,
                        command
                )
        );
    }

    public UnaryOperator<Style> clickSuggest(String command) {
        return style -> style.withClickEvent(
                new ClickEvent(
                        ClickEvent.Action.SUGGEST_COMMAND,
                        command
                )
        );
    }

    public UnaryOperator<Style> clickCopy(String text) {
        return style -> style.withClickEvent(
                new ClickEvent(
                        ClickEvent.Action.COPY_TO_CLIPBOARD,
                        text
                )
        );
    }

    /* ============================================================ */
    /* Style application                                            */
    /* ============================================================ */

    @SafeVarargs
    public final MutableText style(MutableText text, UnaryOperator<Style>... ops) {
        return text.styled(current -> {
            Style style = current;

            for (UnaryOperator<Style> op : ops) {
                style = op.apply(style);
            }

            return style;
        });
    }

    @SafeVarargs
    public final MutableText literalStyled(String text, UnaryOperator<Style>... ops) {
        MutableText literal = literal(text);

        return style(literal, ops);
    }

    /* ============================================================ */
    /* Joining                                                      */
    /* ============================================================ */

    public MutableText join(List<? extends Text> parts, Text separator) {
        MutableText out = empty();

        for (int i = 0; i < parts.size(); i++) {
            if (i > 0) {
                out.append(separator);
            }

            out.append(parts.get(i));
        }

        return out;
    }

    /* ============================================================ */
    /* Gradients – RGB                                              */
    /* ============================================================ */

    public MutableText gradientRgb(String text, int startRgb, int endRgb) {
        return gradientRgb(text, startRgb, endRgb, text.length());
    }

    public MutableText gradientRgb(String text, int startRgb, int endRgb, int length) {
        return gradientInternal(text, new Color(startRgb), new Color(endRgb), length);
    }

    public MutableText gradientRgb(String text, int r1, int g1, int b1, int r2, int g2, int b2) {
        return gradientRgb(text, r1, g1, b1, r2, g2, b2, text.length());
    }

    public MutableText gradientRgb(String text, int r1, int g1, int b1, int r2, int g2, int b2, int length) {
        Color start = new Color(clamp(r1), clamp(g1), clamp(b1));
        Color end = new Color(clamp(r2), clamp(g2), clamp(b2));

        return gradientInternal(text, start, end, length);
    }

    /* ============================================================ */
    /* Gradients – HEX                                              */
    /* ============================================================ */

    public MutableText gradientHex(String text, String startHex, String endHex) {
        return gradientHex(text, startHex, endHex, text.length());
    }

    public MutableText gradientHex(String text, String startHex, String endHex, int length) {
        Color start = ColorUtils.hexToColor(startHex);
        Color end = ColorUtils.hexToColor(endHex);

        return gradientInternal(text, start, end, length);
    }

    /* ============================================================ */
    /* Gradients – HSV                                              */
    /* ============================================================ */

    public MutableText gradientHsv(String text, float h1, float s1, float v1, float h2, float s2, float v2) {
        return gradientHsv(text, h1, s1, v1, h2, s2, v2, text.length());
    }

    public MutableText gradientHsv(String text, float h1, float s1, float v1, float h2, float s2, float v2, int length) {
        Color start = ColorUtils.hsvToColor(h1, s1, v1);
        Color end = ColorUtils.hsvToColor(h2, s2, v2);

        return gradientInternal(text, start, end, length);
    }

    /* ============================================================ */
    /* Gradients – HSL                                              */
    /* ============================================================ */

    public MutableText gradientHsl(String text, float h1, float s1, float l1, float h2, float s2, float l2) {
        return gradientHsl(text, h1, s1, l1, h2, s2, l2, text.length());
    }

    public MutableText gradientHsl(String text, float h1, float s1, float l1, float h2, float s2, float l2, int length) {
        Color start = ColorUtils.hslToColor(h1, s1, l1);
        Color end = ColorUtils.hslToColor(h2, s2, l2);

        return gradientInternal(text, start, end, length);
    }

    /* ============================================================ */
    /* Gradient core                                                */
    /* ============================================================ */

    protected MutableText gradientInternal(String text, Color start, Color end, int length) {
        MutableText out = empty();
        int limit = Math.min(length, text.length());

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (i < limit) {
                float t = limit <= 1
                        ? 0.0F
                        : (float) i / (float) (limit - 1);

                Color lerped = ColorUtils.lerpColor(start, end, t);

                out.append(
                        literal(String.valueOf(c))
                                .styled(style -> style.withColor(lerped.getRGB() & 0xFFFFFF))
                );
            } else {
                out.append(literal(String.valueOf(c)));
            }
        }

        return out;
    }

    /* ============================================================ */
    /* Utility                                                      */
    /* ============================================================ */

    protected int clamp(int value) {
        if (value < 0) {
            return 0;
        }

        if (value > 255) {
            return 255;
        }

        return value;
    }
}
