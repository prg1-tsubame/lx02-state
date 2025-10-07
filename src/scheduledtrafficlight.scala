package prg1.lx02.scheduled_traffic_light

// bug: 最初の2秒赤信号が点灯しない。canvas.repaint のタイミングエラーか？

import prg1.support.world._
import prg1.graphics.color.Color
import java.awt.{Color => JColor, Graphics2D}

val Red    = Color(JColor.red)
val Green  = Color(JColor.green)
val Yellow = Color(JColor.yellow)

val SECS_FOR_RED    = 7
val SECS_FOR_GREEN  = 5
val SECS_FOR_YELLOW = 2

// 色と残り時間の組合せ (color, waitFor) によって状態を表現した例
case class ScheduledLight(color: Color, waitFor: Int, tick_ms: Int) extends World(tick_ms) {
  /**
   * 信号を描画する。円を塗り潰しているだけ。
   **/
  override def draw() = {
    val s = World.canvas.size
    val x = (s.width / 2).toInt
    val y = (s.height / 2).toInt
    val r = scala.math.min(x, y) * 4 / 5
    drawDisk(Pos(x, y), r, color)
  }

  /**
   * 信号の状態の遷
   **/
  override def tick(): World = {
    println(waitFor)
    val (c, w) = (color, waitFor) match {
      case (Red, 1) => (Green, SECS_FOR_GREEN)
      case (Green, 1) => (Yellow, SECS_FOR_YELLOW)
      case (Yellow, 1) => (Red, SECS_FOR_RED)
      case _ => (color, waitFor - 1)
    }
    ScheduledLight(c, w, tick_ms)
  }
}

@main def run = World.bigbang2d(new ScheduledLight(Red, SECS_FOR_RED, 2000), "Scheduled Traffic Light", 300, 300)