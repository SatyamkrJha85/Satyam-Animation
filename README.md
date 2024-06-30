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





