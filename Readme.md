# `lx02-state` プロジェクト

Windows でこの sbt プロジェクトを使う場合は、日本語出力が文字化けすることがあります。その場合は、`project/programming1.scala` の以下の行を削除してから、sbt を再起動してみて下さい。

~~~
      run / fork          := true,
      run / connectInput  := true,
~~~

# [交通信号の例](src/trafficlight.scala)

時々刻々、色を変える交通信号をシミュレート。

# [タイマーの例1](src/timer1.scala)

開始からの秒数を表示。

# [タイマーの例2](src/timer2.scala)

状態の表現方法を変えた実装例。

# [オートマトンの例](src/automaton.scala)

オートマトンの状態遷移をシミュレート。

# [ポトンの例](src/poton.scala)

極く簡単なゲームの実装例。
