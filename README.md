# Jetpack Compose Animation Series

Welcome to my **10 Days of Jetpack Compose Animations**! 🎉 In this series, I explore various animations using Jetpack Compose, showcasing creative ways to enhance UI/UX in Android applications.

## Day-by-Day Breakdown

### Day 1: Thread Card Animation
Simple Roatating Card composable.

```kotlin
 Card(
        modifier = modifier
            .graphicsLayer {
                rotationY = positionAxisY // Move card according to value of customY.
                cameraDistance = 14f * density
            },
    ) {

        // Here, logic is about coordinate system such as [0..90], [91..270], [270..360].
        if (abs(positionAxisY.toInt()) % 360 <= 90) {
            Box(
                Modifier.fillMaxSize()
            ) {
                frontSide()
            }
        } else if (abs(positionAxisY.toInt()) % 360 in 91..270) {
            Box(
                Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        rotationY = 180f // Important to avoid mirror effect.
                    },
            )
}
```
## Day 1 demo

https://github.com/SatyamkrJha85/Satyam-Animation/assets/111700337/292d2d84-2c23-4cb5-9513-61193c3b4c42






### Day 2: Game Pad Animation
SimpleGame Pad composable.

```kotlin
 Position.values().forEach { position ->
                    val offset = position.getOffset(buttonSizePx)
                    MyButton(
                        modifier = Modifier
                            .offset {
                                IntOffset(
                                    x = offset.x.roundToInt(),
                                    y = offset.y.roundToInt()
                                )
                            }
                            .graphicsLayer {
                                alpha = buttonAlpha.value
                                scaleX = buttonAlpha.value
                                scaleY = buttonAlpha.value
                            }
                            .size(buttonSize)
                            .padding(8.dp)
                        ,
                        isSelected = position == currentPosition,
                        position = position
                    )
                }

            }
```
## Day 2 demo

https://github.com/user-attachments/assets/4bf8d006-74f8-4117-ae7c-7d0cc09e49cc







