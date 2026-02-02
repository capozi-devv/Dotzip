# Welcome to the Hibiscus Wiki
If you are looking for a specific section, see the list below
1. Compat
   1. @RequiresMod
2. GUI 
   1. Variable Texture
   2. Variable Model
3. Prefab
   1. Autostat Items
4. Rendering
   1. Text Rendering
      1. Text Effects
   2. World Rendering
      1. Shape Renderer
      2. Chain Renderer
      3. Spotlight Beam Renderer
      4. Sky Beam Renderer
      5. Symbol Renderer
   3. Render Options
5. Util
   1. Colour Utils
   2. Math Utils

## Installation
In `build.gradle`, add the Modrinth maven to your dependencies  
```
repositories { 
    maven { url = "https://api.modrinth.com/maven" }
}
```
Then, in the `dependencies` block of `build.gradle` add
```
dependencies {
    modImplementation "maven.modrinth:hibiscus-api:${project.hibiscus_version}"
}
```
Then add the `hibiscus_version` object in `gradle.properties` corresponding to the Hibiscus version you want to use