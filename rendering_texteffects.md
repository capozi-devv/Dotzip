# Text Effects
Text Effects are render changes that can be applied to text in most contexts

Hibiscus comes with several Text Effects built in inside the 
`com.everest.hibiscus.api.modules.rendering.text.effects` package:
1. WaveEffect

Custom Text Effects can be made by making a class that implements the `TextEffect` 
interface

```
public class ExampleTextEffect implements TextEffect {
    @Override
    public void render(TextRenderer textRenderer, OrderedText text, int x, int y, int color, float tickDelta) {
           
    }
}
```
These can be used to alter the rendering of text or load images / models into the text rendering

Text Effects are applied by using one of these two methods in `TextEffects`
```
public static MutableText withEffect(Text text, TextEffect effect) 

public static MutableText withEffect(MutableText text, TextEffect effect)
```

Take a look at the `TestItem` class for an example usage
