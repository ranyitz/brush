# 🖌️ Brush

> Scala Terminal String Styling

## Features
🪶 Dependency free<br/>
🤹‍♂️ Apply multiple text styles<br/>
🎨 Supports 256-color and Truecolor<br/>
🏳️‍🌈 Gradient text styling<br/>
🕵️‍♂️ Automatically detects color support and style accordingly<br/>

![brush](assets/brush.png)

## Installation
To include Brush in your Scala project, add the following dependency:

```scala
libraryDependencies += "io.github.ranyitz" %% "brush" % "0.2.1"
```

> Supports Scala 2.12, 2.13, 3.0
## Usage
To start styling your terminal strings, simply import `brush._` in your Scala file:

```scala
import brush._
 
println("bold".bold)
println("green".green)
println("inverted".blue.inverse)
println("strikethrough".bgYellow.italic.strikethrough)
println("use any css color".color("darkorchid"))
println(
"use a specific rgb color"
    .bgRgb(0, 66, 77)
    .rgb(255, 190, 255)
    .bold
    .underline
)
println("use a specific hex color".hex("#D2691E").bgHex("#E6E6FA"))
println(
"gradient background with rgb colors"
    .gradient(
    (255, 102, 102), // Red
    (255, 204, 102), // Orange
    (255, 255, 102), // Yellow
    (204, 255, 102) // Green
    )
)
println(
"gradient background with named css colors"
    .bgGradient(
    "lavender",
    "peachpuff",
    "mintcream",
    "aliceblue",
    "palegoldenrod",
    "lightgray",
    "paleturquoise"
    )
    .black
)
println(
"gradient with hex triplet colors"
    .gradient(
    "#008080", // Teal
    "#FFFF66", // Yellow
    "#FFCC66" // Orange
    )
    .black
)
```

### Text Modifiers
Brush provides various text modifiers for customization:

* `bold` - Makes the text bold.
* `dim` - Applies lower opacity to the text.
* `italic` - Renders the text in italics.
* `underline` - Adds a horizontal line below the text.
* `inverse` - Inverts background and foreground colors.
* `strikethrough` - Strikes a horizontal line through the text's center.
* `overline` - Adds a horizontal line above the text.
* `reset` - Resets the current style.
* `hidden` - Prints the text invisibly.

### Text Colors

`black` | `red` | `green` | `yellow` | `blue` | `magenta` | `cyan` | `white` | `blackBright` | `gray` | `redBright` | `greenBright` | `yellowBright` | `blueBright` | `magentaBright` | `cyanBright` | `whiteBright`

### Background Colors

`bgBlack` | `bgRed` | `bgGreen` | `bgYellow` | `bgBlue` | `bgMagenta` | `bgCyan` | `bgWhite` | `bgBlackBright` | `bgGray` | `bgRedBright` | `bgGreenBright` | `bgYellowBright` | `bgBlueBright` | `bgMagentaBright` | `bgCyanBright` | `bgWhiteBright`

### 256 and Truecolor Support

* `rgb` | `truecolor` - choose a color by providing red, green, and blue values between 0 and 255.
* `bgRgb` | `bgTruecolor` - same as rgb, but for background colors.

```scala
println("Yellow Green".rgb(154, 205, 50))
println("Steel Blue".bgRgb(70, 130, 180))
```

### CSS Named Colors

* `css` | `color` - choose a color by providing a CSS color name.
* `bgCss` | `bgColor` - same as css, but for background colors.

```scala
println("(154, 205, 50)".css("yellowgreen"))
println("(70, 130, 180)".bgCss("steelblue"))
```

For a complete list of available colors, refer to the [full named colors list](https://developer.mozilla.org/en-US/docs/Web/CSS/named-color)

### Hex Triplet Colors

* `hex` - choose a color by providing a [hex triplet](https://en.wikipedia.org/wiki/Web_colors#Hex_triplet).
* `bgHex` - same as hex, but for background colors.

```scala
println("Yellow Green".hex("#9acd32"))
println("Steel Blue".bgHex("#4682b4"))
```

### Gradients
> Note: Gradients are only supported in terminals that support 256-colors or Truecolor.

* `gradient` - apply a gradient to the text by providing a list of colors.
* `bgGradient` - same as gradient, but for background colors.

A color can be provided in any of the following formats:
* CSS color name
* Hex triplet
* RGB tuple

```scala
println("Gradient".gradient("red", "orange", "yellow"))
println("Gradient".bgGradient("#ff0000", "#ffa500", "#ffff00"))
println("Gradient".gradient((255, 0, 0), (255, 165, 0), (255, 255, 0)))
```

### Environment Variables
* `NO_COLOR` - If set to any value, disables all colors.
* `FORCE_COLOR` - If set to any value between `0`-`3`, forces the following color level:
    - `0` - All colors disabled.
    - `1` - Basic 16 colors support.
    - `2` - ANSI 256 colors support.
    - `3` - Truecolor 16 million colors support.

### Inspiration
* [chalk](https://github.com/chalk/chalk) (js)
* [colored](https://github.com/colored-rs/colored) (rust)
* [colored](https://github.com/defunkt/colored) (ruby)
* [rainbow](https://github.com/ktoso/scala-rainbow) (scala)
