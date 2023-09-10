package example

import brush._

object Example extends App {
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
      .underline,
  )
  println(
    "gradient background with rgb colors"
      .gradient(
        (255, 102, 102), // Red
        (255, 204, 102), // Orange
        (255, 255, 102), // Yellow
        (204, 255, 102), // Green
      ),
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
        "paleturquoise",
      )
      .black,
  )
}
