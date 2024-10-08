package com.theapplication.satyamanimation.AnimatedStory


import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.*
import kotlin.math.absoluteValue

data class AnimatableState(
    val animatableStateTag: AnimatableStateTag,
    val index: Int,

    private val initialPadding: PaddingValues? = null,
    private val targetPadding: PaddingValues? = null,
    private val toTargetPaddingAnimationSpec: AnimationSpec<Float>? = null,
    private val toInitialPaddingAnimationSpec: AnimationSpec<Float>? = null,
    private val onPaddingAnimation: (AnimationState) -> Unit = {},

    private val initialSize: DpSize? = null,
    private val targetSize: DpSize? = null,
    private val toTargetSizeAnimationSpec: AnimationSpec<Size>? = null,
    private val toInitialSizeAnimationSpec: AnimationSpec<Size>? = null,
    private val onSizeAnimation: (AnimationState) -> Unit = {},

    private val initialShape: Shape? = null,
    private val targetShape: Shape? = null,
    private val toTargetShapeAnimationSpec: AnimationSpec<Float>? = null,
    private val toInitialShapeAnimationSpec: AnimationSpec<Float>? = null,
    private val onShapeAnimation: (AnimationState) -> Unit = {},

    private val initialBorder: BorderStroke? = null,
    private val targetBorder: BorderStroke? = null,
    private val toTargetBorderAnimationSpec: AnimationSpec<Float>? = null,
    private val toInitialBorderAnimationSpec: AnimationSpec<Float>? = null,
    private val onBorderAnimation: (AnimationState) -> Unit = {},

    private val initialAlpha: Float? = null,
    private val targetAlpha: Float? = null,
    private val toTargetAlphaAnimationSpec: AnimationSpec<Float>? = null,
    private val toInitialAlphaAnimationSpec: AnimationSpec<Float>? = null,
    private val onAlphaAnimation: (AnimationState) -> Unit = {},

    private val initialOffset: DpOffset? = null,
    private val targetOffset: DpOffset? = null,
    private val toTargetOffsetAnimationSpec: AnimationSpec<Size>? = null,
    private val toInitialOffsetAnimationSpec: AnimationSpec<Size>? = null,
    private val onOffsetAnimation: (AnimationState) -> Unit = {},

    private val initialAlignment: Alignment? = null,
    private val targetAlignment: Alignment? = null,
    private val toTargetAlignmentAnimationSpec: AnimationSpec<Float>? = null,
    private val toInitialAlignmentAnimationSpec: AnimationSpec<Float>? = null,
    private val onAlignmentAnimation: (AnimationState) -> Unit = {},

    private val initialFontSize: TextUnit? = null,
    private val targetFontSize: TextUnit? = null,
    private val toTargetFontSizeAnimationSpec: AnimationSpec<Float>? = null,
    private val toInitialFontSizeAnimationSpec: AnimationSpec<Float>? = null,
    private val onFontSizeAnimation: (AnimationState) -> Unit = {},

    private val toTargetAnimationSpec: AnimationSpec<Float>? = null,
    private val toInitialAnimationSpec: AnimationSpec<Float>? = null,
    private val onAnimation: (AnimationState) -> Unit = {}
) {
    private var padding by mutableStateOf(initialPadding)
    private var paddingAnimationSpec by mutableStateOf(
        toTargetPaddingAnimationSpec ?: toTargetAnimationSpec
    )
    private var paddingAnimState by mutableStateOf(AnimationState.INITIAL)
    private fun setPaddingAnim(animationState: AnimationState) {
        paddingAnimState = animationState
        onPaddingAnimation(animationState)
        calculateSharedAnimationState()
    }

    private var size by mutableStateOf(initialSize)
    private var sizeAnimationSpec by mutableStateOf(
        toTargetSizeAnimationSpec ?: toTargetAnimationSpec
    )
    private var sizeAnimState by mutableStateOf(AnimationState.INITIAL)
    private fun setSizeAnim(animationState: AnimationState) {
        sizeAnimState = animationState
        onSizeAnimation(animationState)
        calculateSharedAnimationState()
    }

    private var shape by mutableStateOf(initialShape)
    private var shapeAnimationSpec by mutableStateOf(
        toTargetShapeAnimationSpec ?: toTargetAnimationSpec
    )
    private var shapeAnimState by mutableStateOf(AnimationState.INITIAL)
    private fun setShapeAnim(animationState: AnimationState) {
        shapeAnimState = animationState
        onShapeAnimation(animationState)
        calculateSharedAnimationState()
    }

    private var border by mutableStateOf(initialBorder)
    private var borderAnimationSpec by mutableStateOf(
        toTargetBorderAnimationSpec ?: toTargetAnimationSpec
    )
    private var borderAnimState by mutableStateOf(AnimationState.INITIAL)
    private fun setBorderAnim(animationState: AnimationState) {
        borderAnimState = animationState
        onBorderAnimation(animationState)
        calculateSharedAnimationState()
    }

    private var alpha by mutableStateOf(initialAlpha)
    private var alphaAnimationSpec by mutableStateOf(
        toTargetAlphaAnimationSpec ?: toTargetAnimationSpec
    )
    private var alphaAnimState by mutableStateOf(AnimationState.INITIAL)
    private fun setAlphaAnim(animationState: AnimationState) {
        alphaAnimState = animationState
        onAlphaAnimation(animationState)
        calculateSharedAnimationState()
    }

    private var offset by mutableStateOf(initialOffset)
    private var offsetAnimationSpec by mutableStateOf(
        toTargetOffsetAnimationSpec ?: toTargetAnimationSpec
    )
    private var offsetAnimState by mutableStateOf(AnimationState.INITIAL)
    private fun setOffsetAnim(animationState: AnimationState) {
        offsetAnimState = animationState
        onOffsetAnimation(animationState)
        calculateSharedAnimationState()
    }

    private var alignment by mutableStateOf(initialAlignment)
    private var alignmentAnimationSpec by mutableStateOf(
        toTargetAlignmentAnimationSpec ?: toTargetAnimationSpec
    )
    private var alignmentAnimState by mutableStateOf(AnimationState.INITIAL)
    private fun setAlignmentAnim(animationState: AnimationState) {
        alignmentAnimState = animationState
        onAlignmentAnimation(animationState)
        calculateSharedAnimationState()
    }

    private var fontSize by  mutableStateOf(initialFontSize)
    private var fontSizeAnimationSpec by mutableStateOf(
        toTargetFontSizeAnimationSpec ?: toTargetAnimationSpec
    )
    private var fontSizeAnimState by mutableStateOf(AnimationState.INITIAL)
    private fun setFontSizeAnim(animationState: AnimationState) {
        fontSizeAnimState = animationState
        onFontSizeAnimation(animationState)
        calculateSharedAnimationState()
    }

    internal val screenHeight: Dp
        @Composable
        get() {
            return Dp(LocalConfiguration.current.screenHeightDp.toFloat())
        }

    internal val screenWidth: Dp
        @Composable
        get() {
            return Dp(LocalConfiguration.current.screenWidthDp.toFloat())
        }

    fun animate() {

        if(initialPadding != null && targetPadding != null) {
            animatePadding()
        }

        if(initialSize != null && targetSize != null) {
            animateSize()
        }

        if(initialShape != null && targetShape != null) {
            animateShape()
        }

        if(initialBorder != null && targetBorder != null) {
            animateBorder()
        }

        if(initialAlpha != null && targetAlpha != null) {
            animateAlpha()
        }

        if(initialOffset != null && targetOffset != null) {
            animateOffset()
        }

        if(initialAlignment != null && targetAlignment  != null) {
            animateAlignment()
        }

        if(initialFontSize != null && targetFontSize != null) {
            animateFontSize()
        }
    }

    fun animateToTarget() {

        if(initialPadding != null && targetPadding != null) {
            animatePaddingToTarget()
        }

        if(initialSize != null && targetSize != null) {
            animateSizeToTarget()
        }

        if(initialShape != null && targetShape != null) {
            animateShapeToTarget()
        }

        if(initialBorder != null && targetBorder != null) {
            animateBorderToTarget()
        }

        if(initialAlpha != null && targetAlpha != null) {
            animateAlphaToTarget()
        }

        if(initialOffset != null && targetOffset != null) {
            animateOffsetToTarget()
        }

        if(initialAlignment != null && targetAlignment != null) {
            animateAlignmentToTarget()
        }

        if(initialFontSize != null && targetFontSize != null) {
            animateFontSizeToTarget()
        }
    }

    fun animateToInitial() {

        if(initialPadding != null && targetPadding != null) {
            animatePaddingToInitial()
        }

        if(initialSize != null && targetSize != null) {
            animateSizeToInitial()
        }

        if(initialShape != null && targetShape != null) {
            animateShapeToInitial()
        }

        if(initialBorder != null && targetBorder != null) {
            animateBorderToInitial()
        }

        if(initialAlpha != null && targetAlpha != null) {
            animateAlphaToInitial()
        }

        if(initialOffset != null && targetOffset != null) {
            animateOffsetToInitial()
        }

        if(initialAlignment != null && targetAlignment != null) {
            animateAlignmentToInitial()
        }

        if(initialFontSize != null && targetFontSize != null) {
            animateFontSizeToInitial()
        }
    }

    private fun animatePadding() {
        when(paddingAnimState) {
            AnimationState.INITIAL, AnimationState.TARGET_TO_INITIAL -> {
                animatePaddingToTarget()
            }
            AnimationState.TARGET, AnimationState.INITIAL_TO_TARGET -> {
                animatePaddingToInitial()
            }
        }
    }
    private fun animatePaddingToTarget() {
        setPaddingAnim(AnimationState.INITIAL_TO_TARGET)
        padding = targetPadding
        paddingAnimationSpec = toTargetPaddingAnimationSpec ?: toTargetAnimationSpec
    }
    private fun animatePaddingToInitial() {
        setPaddingAnim(AnimationState.TARGET_TO_INITIAL)
        padding = initialPadding
        paddingAnimationSpec = toInitialPaddingAnimationSpec ?: toInitialAnimationSpec
    }
    internal val animatedPadding: PaddingValues
        @Composable
        get() {
            padding?.let { padding ->

                paddingAnimationSpec?.let { spec ->

                    val startPadding = animateFloatAsState(
                        targetValue = padding.calculateStartPadding(LayoutDirection.Ltr).value,
                        animationSpec = spec
                    )
                    val topPadding = animateFloatAsState(
                        targetValue = padding.calculateTopPadding().value,
                        animationSpec = spec
                    )
                    val endPadding = animateFloatAsState(
                        targetValue = padding.calculateEndPadding(LayoutDirection.Rtl).value,
                        animationSpec = spec
                    )
                    val bottomPadding = animateFloatAsState(
                        targetValue = padding.calculateBottomPadding().value,
                        animationSpec = spec,
                        finishedListener = {
                            when(paddingAnimState) {
                                AnimationState.INITIAL_TO_TARGET -> {
                                    setPaddingAnim(AnimationState.TARGET)
                                }

                                AnimationState.TARGET_TO_INITIAL -> {
                                    setPaddingAnim(AnimationState.INITIAL)
                                }
                                else -> {}
                            }
                        }
                    )
                    return PaddingValues(
                        start = Dp(startPadding.value),
                        top = Dp(topPadding.value),
                        end = Dp(endPadding.value),
                        bottom =Dp(bottomPadding.value)
                    )
                }
            }
            return PaddingValues(0.dp)
        }

    private fun animateSize() {
        when(sizeAnimState) {
            AnimationState.INITIAL, AnimationState.TARGET_TO_INITIAL -> {
                animateSizeToTarget()
            }
            AnimationState.TARGET, AnimationState.INITIAL_TO_TARGET -> {
                animateSizeToInitial()
            }
        }
    }
    private fun animateSizeToTarget() {
        setSizeAnim(AnimationState.INITIAL_TO_TARGET)
        size = targetSize
        sizeAnimationSpec = toTargetSizeAnimationSpec ?: toTargetAnimationSpec
    }
    private fun animateSizeToInitial() {
        setSizeAnim(AnimationState.TARGET_TO_INITIAL)
        size = initialSize
        sizeAnimationSpec = toInitialSizeAnimationSpec ?: toInitialAnimationSpec
    }
    internal val animatedSize: DpSize
        @Composable
        get() {
            size?.let { size ->
                sizeAnimationSpec?.let { spec ->

                    val animatedFloatSize = animateSizeAsState(
                        targetValue = Size(
                            width = if(size.width == Dp.Infinity) screenWidth.value else size.width.value,
                            height = if(size.height == Dp.Infinity) screenHeight.value else size.height.value
                        ),
                        animationSpec = spec as AnimationSpec<Size>,
                        finishedListener = {
                            when(sizeAnimState) {
                                AnimationState.INITIAL_TO_TARGET -> {
                                    setSizeAnim(AnimationState.TARGET)
                                }

                                AnimationState.TARGET_TO_INITIAL -> {
                                    setSizeAnim(AnimationState.INITIAL)
                                }
                                else -> {}
                            }
                        }
                    )
                    return DpSize(
                        Dp(animatedFloatSize.value.width),
                        Dp(animatedFloatSize.value.height)
                    )
                }
            }
            return DpSize(Dp.Unspecified, Dp.Unspecified)
        }


    private fun animateShape() {
        when(shapeAnimState) {
            AnimationState.INITIAL, AnimationState.TARGET_TO_INITIAL -> {
                animateShapeToTarget()
            }
            AnimationState.TARGET, AnimationState.INITIAL_TO_TARGET -> {
                animateShapeToInitial()
            }
        }
    }
    private fun animateShapeToTarget() {
        setShapeAnim(AnimationState.INITIAL_TO_TARGET)
        shape = targetShape
        shapeAnimationSpec = toTargetShapeAnimationSpec ?: toTargetAnimationSpec
    }
    private fun animateShapeToInitial() {
        setShapeAnim(AnimationState.TARGET_TO_INITIAL)
        shape = initialShape
        shapeAnimationSpec = toInitialShapeAnimationSpec ?: toInitialAnimationSpec
    }
    internal val animatedShape: RoundedCornerShape
        @Composable
        get() {

            shape?.let { shape ->

                shapeAnimationSpec?.let { spec ->

                    val targetShape: RoundedCornerShape = if(shape == CircleShape) {
                        if(size != null) {
                            RoundedCornerShape(
                                maxOf(
                                    size!!.width,
                                    size!!.height
                                )
                            )
                        }else {
                            throw IllegalArgumentException(
                                "Please specify size in state for use shape animation"
                            )
                        }
                    } else {
                        shape as RoundedCornerShape
                    }

                    targetSize?.let { size ->

                        val topStartCornerSize = targetShape.topStart.toPx(
                            shapeSize = Size(
                                width = size.width.value,
                                height = size.height.value
                            ),
                            density = Density(LocalContext.current)
                        )

                        val topEndCornerSize = targetShape.topEnd.toPx(
                            shapeSize = Size(
                                width = size.width.value,
                                height = size.height.value
                            ),
                            density = Density(LocalContext.current)
                        )
                        val bottomStartCornerSize = targetShape.bottomStart.toPx(
                            shapeSize = Size(
                                width = size.width.value,
                                height = size.height.value
                            ),
                            density = Density(LocalContext.current)
                        )
                        val bottomEndCornerSize = targetShape.bottomEnd.toPx(
                            shapeSize = Size(
                                width = size.width.value,
                                height = size.height.value
                            ),
                            density = Density(LocalContext.current)
                        )

                        val animatedTopStartCornerSize = animateFloatAsState(
                            targetValue = topStartCornerSize,
                            animationSpec = spec
                        )
                        val animatedTopEndCornerSize = animateFloatAsState(
                            targetValue = topEndCornerSize,
                            animationSpec = spec
                        )
                        val animatedBottomStartCornerSize = animateFloatAsState(
                            targetValue = bottomStartCornerSize,
                            animationSpec = spec
                        )
                        val animatedBottomEndCornerSize = animateFloatAsState(
                            targetValue = bottomEndCornerSize,
                            animationSpec = spec,
                            finishedListener = {
                                when(shapeAnimState) {
                                    AnimationState.INITIAL_TO_TARGET -> {
                                        setShapeAnim(AnimationState.TARGET)
                                    }
                                    AnimationState.TARGET_TO_INITIAL -> {
                                        setShapeAnim(AnimationState.INITIAL)
                                    }
                                    else -> {}
                                }
                            }
                        )

                        return RoundedCornerShape(
                            topStart = if(animatedTopStartCornerSize.value < 0f) {
                                0f
                            } else animatedTopStartCornerSize.value.absoluteValue,
                            topEnd = if(animatedTopEndCornerSize.value < 0f) {
                                0f
                            } else animatedTopEndCornerSize.value.absoluteValue,
                            bottomStart = if(animatedBottomStartCornerSize.value < 0f) {
                                0f
                            } else animatedBottomStartCornerSize.value.absoluteValue,
                            bottomEnd = if(animatedBottomEndCornerSize.value < 0f) {
                                0f
                            } else animatedBottomEndCornerSize.value.absoluteValue,
                        )
                    }
                }
            }
            return RoundedCornerShape(0.dp)
        }

    private fun animateBorder() {
        when(borderAnimState) {
            AnimationState.INITIAL, AnimationState.TARGET_TO_INITIAL -> {
                animateBorderToTarget()
            }
            AnimationState.TARGET, AnimationState.INITIAL_TO_TARGET -> {
                animateBorderToInitial()
            }
        }
    }
    private fun animateBorderToTarget() {
        setBorderAnim(AnimationState.INITIAL_TO_TARGET)
        border = targetBorder
        borderAnimationSpec = toTargetBorderAnimationSpec ?: toTargetAnimationSpec
    }
    private fun animateBorderToInitial() {
        setBorderAnim(AnimationState.TARGET_TO_INITIAL)
        border = initialBorder
        borderAnimationSpec = toInitialBorderAnimationSpec ?: toInitialAnimationSpec
    }
    internal val animatedBorder: BorderStroke
        @Composable
        get() {
            border?.let { border ->
                borderAnimationSpec?.let { spec ->

                    val animatedBorderWidth = animateDpAsState(
                        targetValue = border.width,
                        animationSpec = spec as AnimationSpec<Dp>,
                        finishedListener = {
                            when(borderAnimState) {
                                AnimationState.INITIAL_TO_TARGET -> {
                                    setBorderAnim(AnimationState.TARGET)
                                }

                                AnimationState.TARGET_TO_INITIAL -> {
                                    setBorderAnim(AnimationState.INITIAL)
                                }
                                else -> {}
                            }
                        }
                    )

                    return border.copy(
                        width = animatedBorderWidth.value
                    )
                }
            }
            return BorderStroke(0.dp, Color.Unspecified)
        }

    private fun animateAlpha() {
        when(alphaAnimState) {
            AnimationState.INITIAL, AnimationState.TARGET_TO_INITIAL -> {
                animateAlphaToTarget()
            }
            AnimationState.TARGET, AnimationState.INITIAL_TO_TARGET -> {
                animateAlphaToInitial()
            }
        }
    }
    private fun animateAlphaToTarget() {
        setAlphaAnim(AnimationState.INITIAL_TO_TARGET)
        alpha = targetAlpha
        alphaAnimationSpec = toTargetAlphaAnimationSpec ?: toTargetAnimationSpec
    }
    private fun animateAlphaToInitial() {
        setAlphaAnim(AnimationState.TARGET_TO_INITIAL)
        alpha = initialAlpha
        alphaAnimationSpec = toInitialAlphaAnimationSpec ?: toInitialAnimationSpec
    }
    internal val animatedAlpha: Float
        @Composable
        get() {
            alpha?.let { alpha ->
                alphaAnimationSpec?.let { spec ->
                    return animateFloatAsState(
                        targetValue = alpha,
                        animationSpec = spec,
                        finishedListener = {
                            when(alphaAnimState) {
                                AnimationState.INITIAL_TO_TARGET -> {
                                    setAlphaAnim(AnimationState.TARGET)
                                }

                                AnimationState.TARGET_TO_INITIAL -> {
                                    setAlphaAnim(AnimationState.INITIAL)
                                }
                                else -> {}
                            }
                        }
                    ).value
                }
            }
            return 1f
        }

    private fun animateOffset() {
        when(offsetAnimState) {
            AnimationState.INITIAL, AnimationState.TARGET_TO_INITIAL -> {
                animateOffsetToTarget()
            }
            AnimationState.TARGET, AnimationState.INITIAL_TO_TARGET -> {
                animateOffsetToInitial()
            }
        }
    }
    private fun animateOffsetToTarget() {
        setOffsetAnim(AnimationState.INITIAL_TO_TARGET)
        offset = targetOffset
        offsetAnimationSpec = toTargetOffsetAnimationSpec ?: toTargetAnimationSpec
    }
    private fun animateOffsetToInitial() {
        setOffsetAnim(AnimationState.TARGET_TO_INITIAL)
        offset = initialOffset
        offsetAnimationSpec = toInitialOffsetAnimationSpec ?: toInitialAnimationSpec
    }
    internal val animatedOffset: DpOffset
        @Composable
        get() {
            offset?.let { offset ->

                offsetAnimationSpec?.let { spec ->

                    val reminderOfWidth: Dp
                    val reminderOfHeight: Dp

                    initialOffset?.let { initialOffset ->

                        targetOffset?.let { targetOffset ->

                            if(size == null) {
                                if(initialOffset.x == Dp.Infinity
                                    || initialOffset.x == - Dp.Infinity
                                    || initialOffset.y == Dp.Infinity
                                    || initialOffset.y == - Dp.Infinity
                                    || targetOffset.x == Dp.Infinity
                                    || targetOffset.x == - Dp.Infinity
                                    || targetOffset.y == Dp.Infinity
                                    || targetOffset.y == - Dp.Infinity
                                ){
                                    throw IllegalArgumentException(
                                        "Please specify size in state for use Dp.Infinity in offset animation"
                                    )
                                }else {
                                    reminderOfWidth = 0.dp
                                    reminderOfHeight = 0.dp
                                }
                            }else {
                                reminderOfWidth = if(size!!.width == Dp.Infinity) {
                                    0.dp
                                } else {
                                    ((screenWidth - (size!!.width)) / 2)
                                }
                                reminderOfHeight = if(size!!.height == Dp.Infinity) {
                                    0.dp
                                } else {
                                    ((screenHeight - (size!!.height)) / 2)
                                }
                            }

                            val animatedOffset = animateSizeAsState(
                                targetValue = Size(
                                    width = when(offset.x) {
                                        Dp.Infinity -> reminderOfWidth.value
                                        - Dp.Infinity -> - reminderOfWidth.value
                                        else -> offset.x.value
                                    },
                                    height = when(offset.y) {
                                        Dp.Infinity -> reminderOfHeight.value
                                        - Dp.Infinity -> - reminderOfHeight.value
                                        else -> offset.y.value
                                    }
                                ),
                                animationSpec = spec as AnimationSpec<Size>,
                                finishedListener = {
                                    when(offsetAnimState) {
                                        AnimationState.INITIAL_TO_TARGET -> {
                                            setOffsetAnim(AnimationState.TARGET)
                                        }

                                        AnimationState.TARGET_TO_INITIAL -> {
                                            setOffsetAnim(AnimationState.INITIAL)
                                        }
                                        else -> {}
                                    }
                                }
                            )
                            return DpOffset(
                                Dp(animatedOffset.value.width),
                                Dp(animatedOffset.value.height)
                            )
                        }
                    }
                }
            }
            return DpOffset(x = 0.dp, y = 0.dp)
        }

    private fun animateAlignment() {
        when(alignmentAnimState) {
            AnimationState.INITIAL, AnimationState.TARGET_TO_INITIAL -> {
                animateAlignmentToTarget()
            }
            AnimationState.TARGET, AnimationState.INITIAL_TO_TARGET -> {
                animateAlignmentToInitial()
            }
        }
    }
    private fun animateAlignmentToTarget() {
        setAlignmentAnim(AnimationState.INITIAL_TO_TARGET)
        alignment = targetAlignment
        alignmentAnimationSpec = toTargetAlignmentAnimationSpec ?: toTargetAnimationSpec
    }
    private fun animateAlignmentToInitial() {
        setAlignmentAnim(AnimationState.TARGET_TO_INITIAL)
        alignment = initialAlignment
        alignmentAnimationSpec = toInitialAlignmentAnimationSpec ?: toInitialAnimationSpec
    }
    internal val animatedAlignment: Alignment
        @Composable
        get() {

            alignment?.let { alignment ->

                alignmentAnimationSpec?.let { spec ->

                    val animatedHorizontalBias = animateFloatAsState(
                        targetValue = when(alignment) {
                            TopStart -> -1f
                            TopCenter -> 0f
                            TopEnd -> 1f
                            CenterStart -> -1f
                            Center -> 0f
                            CenterEnd -> 1f
                            BottomStart -> -1f
                            BottomCenter -> 0f
                            BottomEnd -> 1f
                            else -> 0f
                        },
                        animationSpec = spec
                    )
                    val animatedVerticalBias = animateFloatAsState(
                        targetValue = when(alignment) {
                            TopStart -> -1f
                            TopCenter -> -1f
                            TopEnd -> -1f
                            CenterStart -> 0f
                            Center -> 0f
                            CenterEnd -> 0f
                            BottomStart -> 1f
                            BottomCenter -> 1f
                            BottomEnd -> 1f
                            else -> 0f
                        },
                        animationSpec = spec,
                        finishedListener = {
                            when(alignmentAnimState) {
                                AnimationState.INITIAL_TO_TARGET -> {
                                    setAlignmentAnim(AnimationState.TARGET)
                                }
                                AnimationState.TARGET_TO_INITIAL -> {
                                    setAlignmentAnim(AnimationState.INITIAL)
                                }
                                else -> {}
                            }
                        }
                    )

                    return BiasAlignment(animatedHorizontalBias.value, animatedVerticalBias.value)
                }
            }
            return BiasAlignment(0f, 0f)
        }

    private fun animateFontSize() {
        when(fontSizeAnimState) {
            AnimationState.INITIAL, AnimationState.TARGET_TO_INITIAL -> {
                animateFontSizeToTarget()
            }
            AnimationState.TARGET, AnimationState.INITIAL_TO_TARGET -> {
                animateFontSizeToInitial()
            }
        }
    }
    private fun animateFontSizeToTarget() {
        setFontSizeAnim(AnimationState.INITIAL_TO_TARGET)
        fontSize = targetFontSize
        fontSizeAnimationSpec = toTargetFontSizeAnimationSpec ?: toTargetAnimationSpec
    }
    private fun animateFontSizeToInitial() {
        setFontSizeAnim(AnimationState.TARGET_TO_INITIAL)
        fontSize = initialFontSize
        fontSizeAnimationSpec =  toInitialFontSizeAnimationSpec ?: toInitialAnimationSpec
    }
    internal val animatedFontSize: TextUnit
        @Composable
        get() {
            fontSize?.let { fontSize ->
                fontSizeAnimationSpec?.let { spec ->
                    return animateFloatAsState(
                        targetValue = fontSize.value,
                        animationSpec = spec,
                        finishedListener = {
                            when(fontSizeAnimState) {
                                AnimationState.INITIAL_TO_TARGET -> {
                                    setFontSizeAnim(AnimationState.TARGET)
                                }
                                AnimationState.TARGET_TO_INITIAL -> {
                                    setFontSizeAnim(AnimationState.INITIAL)
                                }
                                else -> {}
                            }
                        }
                    ).value.sp
                }
            }
            return TextUnit.Unspecified
        }

    private fun calculateSharedAnimationState() {

        val animationStates = mutableListOf<AnimationState>()

        if(padding != null ) {
            animationStates.add(paddingAnimState)
        }
        if(size != null ) {
            animationStates.add(sizeAnimState)
        }
        if(shape != null ) {
            animationStates.add(shapeAnimState)
        }
        if(border != null ) {
            animationStates.add(borderAnimState)
        }
        if(alpha != null ) {
            animationStates.add(alphaAnimState)
        }
        if(offset != null ) {
            animationStates.add(offsetAnimState)
        }
        if(alignment != null ) {
            animationStates.add(alignmentAnimState)
        }
        if(fontSize != null ) {
            animationStates.add(fontSizeAnimState)
        }

        if(animationStates.all { it == AnimationState.INITIAL }) {
            onAnimation(AnimationState.INITIAL)
            return
        }
        if(animationStates.all { it == AnimationState.INITIAL_TO_TARGET }) {
            onAnimation(AnimationState.INITIAL_TO_TARGET)
            return
        }
        if(animationStates.all { it == AnimationState.TARGET }) {
            onAnimation(AnimationState.TARGET)
            return
        }
        if(animationStates.all { it == AnimationState.TARGET_TO_INITIAL }) {
            onAnimation(AnimationState.TARGET_TO_INITIAL)
            return
        }
    }
}

enum class AnimationState {
    INITIAL, INITIAL_TO_TARGET, TARGET_TO_INITIAL, TARGET
}

enum class AnimatableStateTag {
    SPACER, TEXT, BOX, CARD, ICON, LAZY_ROW, LAZY_COLUMN,
}

@Composable
fun rememberAnimatableSpacerState(
    index: Int = 0,
    initialSize: DpSize? = null,
    targetSize: DpSize? = null,
    toTargetSizeAnimationSpec: AnimationSpec<Size>? = tween(500),
    toInitialSizeAnimationSpec: AnimationSpec<Size>? = tween(500),
    onSizeAnimation: (AnimationState) -> Unit = {}
): AnimatableState {
    return remember {
        AnimatableState(
            animatableStateTag = AnimatableStateTag.SPACER,
            index = index,
            initialSize = initialSize,
            targetSize = targetSize,
            toTargetSizeAnimationSpec = toTargetSizeAnimationSpec,
            toInitialSizeAnimationSpec = toInitialSizeAnimationSpec,
            onSizeAnimation = onSizeAnimation
        )
    }
}

@Composable
fun rememberAnimatableTextState(
    index: Int = 0,
    initialFontSize: TextUnit? = null,
    targetFontSize: TextUnit? = null,
    toTargetFontSizeAnimationSpec: AnimationSpec<Float>? = null,
    toInitialFontSizeAnimationSpec: AnimationSpec<Float>? = null,
    onFontSizeAnimation: (AnimationState) -> Unit = {},
    initialAlpha: Float? = null,
    targetAlpha: Float? = null,
    toTargetAlphaAnimationSpec: AnimationSpec<Float>? = null,
    toInitialAlphaAnimationSpec: AnimationSpec<Float>? = null,
    onAlphaAnimation: (AnimationState) -> Unit = {},
    initialOffset: DpOffset? = null,
    targetOffset: DpOffset? = null,
    toTargetOffsetAnimationSpec: AnimationSpec<Size>? = null,
    toInitialOffsetAnimationSpec: AnimationSpec<Size>? = null,
    onOffsetAnimation: (AnimationState) -> Unit = {},
    toTargetAnimationSpec: AnimationSpec<Float>? = tween(500),
    toInitialAnimationSpec: AnimationSpec<Float>? = tween(500),
    onAnimation: (AnimationState) -> Unit = {}
): AnimatableState {
    return remember {
        AnimatableState(
            animatableStateTag = AnimatableStateTag.TEXT,
            index = index,
            initialFontSize = initialFontSize,
            targetFontSize = targetFontSize,
            toTargetFontSizeAnimationSpec = toTargetFontSizeAnimationSpec,
            toInitialFontSizeAnimationSpec = toInitialFontSizeAnimationSpec,
            onFontSizeAnimation = onFontSizeAnimation,
            initialAlpha = initialAlpha,
            targetAlpha = targetAlpha,
            toTargetAlphaAnimationSpec = toTargetAlphaAnimationSpec,
            toInitialAlphaAnimationSpec = toInitialAlphaAnimationSpec,
            onAlphaAnimation = onAlphaAnimation,
            initialOffset = initialOffset,
            targetOffset = targetOffset,
            toTargetOffsetAnimationSpec = toTargetOffsetAnimationSpec,
            toInitialOffsetAnimationSpec = toInitialOffsetAnimationSpec,
            onOffsetAnimation = onOffsetAnimation,
            toTargetAnimationSpec = toTargetAnimationSpec,
            toInitialAnimationSpec = toInitialAnimationSpec,
            onAnimation = onAnimation
        )
    }
}

@Composable
fun rememberAnimatableBoxState(
    index: Int = 0,
    initialSize: DpSize? = null,
    targetSize: DpSize? = null,
    toTargetSizeAnimationSpec: AnimationSpec<Size>? = null,
    toInitialSizeAnimationSpec: AnimationSpec<Size>? = null,
    onSizeAnimation: (AnimationState) -> Unit = {},
    initialBorder: BorderStroke? = null,
    targetBorder: BorderStroke? = null,
    toTargetBorderAnimationSpec: AnimationSpec<Float>? = null,
    toInitialBorderAnimationSpec: AnimationSpec<Float>? = null,
    onBorderAnimation: (AnimationState) -> Unit = {},
    initialOffset: DpOffset? = null,
    targetOffset: DpOffset? = null,
    toTargetOffsetAnimationSpec: AnimationSpec<Size>? = null,
    toInitialOffsetAnimationSpec: AnimationSpec<Size>? = null,
    onOffsetAnimation: (AnimationState) -> Unit = {},
    initialAlignment: Alignment? = null,
    targetAlignment: Alignment? = null,
    toTargetAlignmentAnimationSpec: AnimationSpec<Float>? = null,
    toInitialAlignmentAnimationSpec: AnimationSpec<Float>? = null,
    onAlignmentAnimation: (AnimationState) -> Unit = {},
    toTargetAnimationSpec: AnimationSpec<Float>? = tween(500),
    toInitialAnimationSpec: AnimationSpec<Float>? = tween(500),
    onAnimation: (AnimationState) -> Unit = {}
): AnimatableState {
    return remember {
        AnimatableState(
            animatableStateTag = AnimatableStateTag.BOX,
            index = index,
            initialSize = initialSize,
            targetSize = targetSize,
            toTargetSizeAnimationSpec = toTargetSizeAnimationSpec,
            toInitialSizeAnimationSpec = toInitialSizeAnimationSpec,
            onSizeAnimation = onSizeAnimation,
            initialBorder = initialBorder,
            targetBorder = targetBorder,
            toTargetBorderAnimationSpec = toTargetBorderAnimationSpec,
            toInitialBorderAnimationSpec = toInitialBorderAnimationSpec,
            onBorderAnimation = onBorderAnimation,
            initialOffset = initialOffset,
            targetOffset = targetOffset,
            toTargetOffsetAnimationSpec = toTargetOffsetAnimationSpec,
            toInitialOffsetAnimationSpec = toInitialOffsetAnimationSpec,
            onOffsetAnimation = onOffsetAnimation,
            initialAlignment = initialAlignment,
            targetAlignment = targetAlignment,
            toTargetAlignmentAnimationSpec = toTargetAlignmentAnimationSpec,
            toInitialAlignmentAnimationSpec = toInitialAlignmentAnimationSpec,
            onAlignmentAnimation = onAlignmentAnimation,
            toTargetAnimationSpec = toTargetAnimationSpec,
            toInitialAnimationSpec = toInitialAnimationSpec,
            onAnimation = onAnimation
        )
    }
}

@Composable
fun rememberAnimatableCardState(
    index: Int = 0,
    initialPadding: PaddingValues? = null,
    targetPadding: PaddingValues? = null,
    toTargetPaddingAnimationSpec: AnimationSpec<Float>? = null,
    toInitialPaddingAnimationSpec: AnimationSpec<Float>? = null,
    onPaddingAnimation: (AnimationState) -> Unit = {},
    initialSize: DpSize? = null,
    targetSize: DpSize? = null,
    toTargetSizeAnimationSpec: AnimationSpec<Size>? = null,
    toInitialSizeAnimationSpec: AnimationSpec<Size>? = null,
    onSizeAnimation: (AnimationState) -> Unit = {},
    initialShape: Shape? = null,
    targetShape: Shape? = null,
    toTargetShapeAnimationSpec: AnimationSpec<Float>? = null,
    toInitialShapeAnimationSpec: AnimationSpec<Float>? = null,
    onShapeAnimation: (AnimationState) -> Unit = {},
    initialBorder: BorderStroke? = null,
    targetBorder: BorderStroke? = null,
    toTargetBorderAnimationSpec: AnimationSpec<Float>? = null,
    toInitialBorderAnimationSpec: AnimationSpec<Float>? = null,
    onBorderAnimation: (AnimationState) -> Unit = {},
    initialAlpha: Float? = null,
    targetAlpha: Float? = null,
    toTargetAlphaAnimationSpec: AnimationSpec<Float>? = null,
    toInitialAlphaAnimationSpec: AnimationSpec<Float>? = null,
    onAlphaAnimation: (AnimationState) -> Unit = {},
    initialOffset: DpOffset? = null,
    targetOffset: DpOffset? = null,
    toTargetOffsetAnimationSpec: AnimationSpec<Size>? = null,
    toInitialOffsetAnimationSpec: AnimationSpec<Size>? = null,
    onOffsetAnimation: (AnimationState) -> Unit = {},
    toTargetAnimationSpec: AnimationSpec<Float>? = tween(500),
    toInitialAnimationSpec: AnimationSpec<Float>? = tween(500),
    onAnimation: (AnimationState) -> Unit = {}
): AnimatableState {
    return remember {
        AnimatableState(
            animatableStateTag = AnimatableStateTag.CARD,
            index = index,
            initialPadding = initialPadding,
            targetPadding = targetPadding,
            toTargetPaddingAnimationSpec = toTargetPaddingAnimationSpec,
            toInitialPaddingAnimationSpec = toInitialPaddingAnimationSpec,
            onPaddingAnimation = onPaddingAnimation,
            initialSize = initialSize,
            targetSize = targetSize,
            toTargetSizeAnimationSpec = toTargetSizeAnimationSpec,
            toInitialSizeAnimationSpec = toInitialSizeAnimationSpec,
            onSizeAnimation = onSizeAnimation,
            initialShape = initialShape,
            targetShape = targetShape,
            toTargetShapeAnimationSpec = toTargetShapeAnimationSpec,
            toInitialShapeAnimationSpec = toInitialShapeAnimationSpec,
            onShapeAnimation = onShapeAnimation,
            initialBorder = initialBorder,
            targetBorder = targetBorder,
            toTargetBorderAnimationSpec = toTargetBorderAnimationSpec,
            toInitialBorderAnimationSpec = toInitialBorderAnimationSpec,
            onBorderAnimation = onBorderAnimation,
            initialAlpha = initialAlpha,
            targetAlpha = targetAlpha,
            toTargetAlphaAnimationSpec = toTargetAlphaAnimationSpec,
            toInitialAlphaAnimationSpec = toInitialAlphaAnimationSpec,
            onAlphaAnimation = onAlphaAnimation,
            initialOffset = initialOffset,
            targetOffset = targetOffset,
            toTargetOffsetAnimationSpec = toTargetOffsetAnimationSpec,
            toInitialOffsetAnimationSpec = toInitialOffsetAnimationSpec,
            onOffsetAnimation = onOffsetAnimation,
            toTargetAnimationSpec = toTargetAnimationSpec,
            toInitialAnimationSpec = toInitialAnimationSpec,
            onAnimation = onAnimation
        )
    }
}

@Composable
fun rememberAnimatableIconState(
    index: Int = 0,
    initialSize: DpSize? = null,
    targetSize: DpSize? = null,
    toTargetSizeAnimationSpec: AnimationSpec<Size>? = null,
    toInitialSizeAnimationSpec: AnimationSpec<Size>? = null,
    onSizeAnimation: (AnimationState) -> Unit = {},
    initialAlpha: Float? = null,
    targetAlpha: Float? = null,
    toTargetAlphaAnimationSpec: AnimationSpec<Float>? = null,
    toInitialAlphaAnimationSpec: AnimationSpec<Float>? = null,
    onAlphaAnimation: (AnimationState) -> Unit = {},
    initialOffset: DpOffset? = null,
    targetOffset: DpOffset? = null,
    toTargetOffsetAnimationSpec: AnimationSpec<Size>? = null,
    toInitialOffsetAnimationSpec: AnimationSpec<Size>? = null,
    onOffsetAnimation: (AnimationState) -> Unit = {},
    toTargetAnimationSpec: AnimationSpec<Float>? = tween(500),
    toInitialAnimationSpec: AnimationSpec<Float>? = tween(500),
    onAnimation: (AnimationState) -> Unit = {}
): AnimatableState {
    return remember {
        AnimatableState(
            animatableStateTag = AnimatableStateTag.ICON,
            index = index,
            initialSize = initialSize,
            targetSize = targetSize,
            toTargetSizeAnimationSpec = toTargetSizeAnimationSpec,
            toInitialSizeAnimationSpec = toInitialSizeAnimationSpec,
            onSizeAnimation = onSizeAnimation,
            initialAlpha = initialAlpha,
            targetAlpha = targetAlpha,
            toTargetAlphaAnimationSpec = toTargetAlphaAnimationSpec,
            toInitialAlphaAnimationSpec = toInitialAlphaAnimationSpec,
            onAlphaAnimation = onAlphaAnimation,
            initialOffset = initialOffset,
            targetOffset = targetOffset,
            toTargetOffsetAnimationSpec = toTargetOffsetAnimationSpec,
            toInitialOffsetAnimationSpec = toInitialOffsetAnimationSpec,
            onOffsetAnimation = onOffsetAnimation,
            toTargetAnimationSpec = toTargetAnimationSpec,
            toInitialAnimationSpec = toInitialAnimationSpec,
            onAnimation = onAnimation
        )
    }
}

@Composable
fun rememberAnimatableLazyRowState(
    index: Int = 0,
    initialSize: DpSize? = null,
    targetSize: DpSize? = null,
    toTargetSizeAnimationSpec: AnimationSpec<Size>? = null,
    toInitialSizeAnimationSpec: AnimationSpec<Size>? = null,
    onSizeAnimation: (AnimationState) -> Unit = {},
    initialOffset: DpOffset? = null,
    targetOffset: DpOffset? = null,
    toTargetOffsetAnimationSpec: AnimationSpec<Size>? = null,
    toInitialOffsetAnimationSpec: AnimationSpec<Size>? = null,
    onOffsetAnimation: (AnimationState) -> Unit = {},
    toTargetAnimationSpec: AnimationSpec<Float>? = tween(500),
    toInitialAnimationSpec: AnimationSpec<Float>? = tween(500),
    onAnimation: (AnimationState) -> Unit = {}
): AnimatableState {
    return remember {
        AnimatableState(
            animatableStateTag = AnimatableStateTag.LAZY_ROW,
            index = index,
            initialSize = initialSize,
            targetSize = targetSize,
            toTargetSizeAnimationSpec = toTargetSizeAnimationSpec,
            toInitialSizeAnimationSpec = toInitialSizeAnimationSpec,
            onSizeAnimation = onSizeAnimation,
            initialOffset = initialOffset,
            targetOffset = targetOffset,
            toTargetOffsetAnimationSpec = toTargetOffsetAnimationSpec,
            toInitialOffsetAnimationSpec = toInitialOffsetAnimationSpec,
            onOffsetAnimation = onOffsetAnimation,
            toTargetAnimationSpec = toTargetAnimationSpec,
            toInitialAnimationSpec = toInitialAnimationSpec,
            onAnimation = onAnimation
        )
    }
}

@Composable
fun rememberAnimatableLazyColumnState(
    index: Int = 0,
    initialSize: DpSize? = null,
    targetSize: DpSize? = null,
    toTargetSizeAnimationSpec: AnimationSpec<Size>? = null,
    toInitialSizeAnimationSpec: AnimationSpec<Size>? = null,
    onSizeAnimation: (AnimationState) -> Unit = {},
    initialOffset: DpOffset? = null,
    targetOffset: DpOffset? = null,
    toTargetOffsetAnimationSpec: AnimationSpec<Size>? = null,
    toInitialOffsetAnimationSpec: AnimationSpec<Size>? = null,
    onOffsetAnimation: (AnimationState) -> Unit = {},
    toTargetAnimationSpec: AnimationSpec<Float>? = tween(500),
    toInitialAnimationSpec: AnimationSpec<Float>? = tween(500),
    onAnimation: (AnimationState) -> Unit = {}
): AnimatableState {
    return remember {
        AnimatableState(
            animatableStateTag = AnimatableStateTag.LAZY_COLUMN,
            index = index,
            initialSize = initialSize,
            targetSize = targetSize,
            toTargetSizeAnimationSpec = toTargetSizeAnimationSpec,
            toInitialSizeAnimationSpec = toInitialSizeAnimationSpec,
            onSizeAnimation = onSizeAnimation,
            initialOffset = initialOffset,
            targetOffset = targetOffset,
            toTargetOffsetAnimationSpec = toTargetOffsetAnimationSpec,
            toInitialOffsetAnimationSpec = toInitialOffsetAnimationSpec,
            onOffsetAnimation = onOffsetAnimation,
            toTargetAnimationSpec = toTargetAnimationSpec,
            toInitialAnimationSpec = toInitialAnimationSpec,
            onAnimation = onAnimation
        )
    }
}