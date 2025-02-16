package com.github.vipulasri.timelineview.sample.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.vipulasri.timelineview.sample.ui.theme.TimelineTheme
import com.vipulasri.timelineview.compose.DashedLine
import com.vipulasri.timelineview.compose.LineStyle
import com.vipulasri.timelineview.compose.LineType
import com.vipulasri.timelineview.compose.SolidLine
import com.vipulasri.timelineview.compose.Timeline
import com.vipulasri.timelineview.compose.TimelineOrientation
import com.vipulasri.timelineview.compose.getLineType

/**
 * Created by Vipul Asri on 22/01/25.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeSampleScreen(
    onBackClick: () -> Unit
) {
    TimelineTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Compose Sample"
                        )
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors().copy(
                        containerColor = Color.Transparent,
                    ),
                    navigationIcon = {
                        IconButton(onBackClick) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "back"
                            )
                        }
                    }
                )
            },
            containerColor = Color.White
        ) { contentPadding ->

            val items =
                listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)

            LazyColumn(
                modifier = Modifier
                    .padding(contentPadding)
                    .fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                itemsIndexed(items) { index, item ->
                    Row(
                        modifier = Modifier.height(IntrinsicSize.Min)
                    ) {
                        Timeline(
                            modifier = Modifier.fillMaxHeight(),
                            lineType = getLineType(index, items.size),
                            orientation = TimelineOrientation.Vertical,
                            lineStyle = LineStyle.dashed(
                                color = Color(0xFF4CAF50),
                                width = 2.dp
                            ),
                            marker = {
                                Box(
                                    modifier = Modifier
                                        .size(24.dp)
                                        .background(MaterialTheme.colorScheme.primary, CircleShape)
                                )
                            }
                        )
                        Text(
                            text = "Item $item",
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                    Card {

                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
private fun ComposeSampleScreenPreview() {
    ComposeSampleScreen(
        onBackClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun TimelineVerticalPreview() {
    Column(Modifier.padding(16.dp)) {
        val totalItems = 4
        repeat(totalItems) { position ->
            Timeline(
                modifier = Modifier.height(100.dp),
                lineType = getLineType(position, totalItems),
                lineStyle = when (position) {
                    0 -> {
                        LineStyle.dashed(
                            color = Color(0xFF2196F3),
                            width = 3.dp
                        )
                    }

                    1 -> {
                        LineStyle(
                            startLine = DashedLine(
                                color = Color(0xFF2196F3),
                                width = 3.dp
                            ),
                            endLine = SolidLine(
                                color = Color(0xFF4CAF50),
                                width = 2.dp
                            ),
                        )
                    }

                    else -> {
                        LineStyle.solid(
                            color = Color(0xFF4CAF50),
                            width = 2.dp
                        )
                    }
                },
                marker = {
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .background(Color(0xFF2196F3), CircleShape)
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TimelineHorizontalPreview() {
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        val totalItems = 4
        repeat(totalItems) { position ->
            Timeline(
                modifier = Modifier.width(80.dp),
                lineType = getLineType(position, totalItems),
                orientation = TimelineOrientation.Horizontal,
                lineStyle = when (position) {
                    0 -> {
                        LineStyle.dashed(
                            color = Color(0xFF2196F3),
                            width = 3.dp
                        )
                    }

                    1 -> {
                        LineStyle(
                            startLine = DashedLine(
                                color = Color(0xFF2196F3),
                                width = 3.dp
                            ),
                            endLine = SolidLine(
                                color = Color(0xFF4CAF50),
                                width = 2.dp
                            ),
                        )
                    }

                    else -> {
                        LineStyle.solid(
                            color = Color(0xFF4CAF50),
                            width = 2.dp
                        )
                    }
                },
                marker = {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(Color(0xFF2196F3), CircleShape)
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun TimelineSingleItemPreview() {
    TimelineTheme {
        Column(Modifier.padding(horizontal = 16.dp)) {
            Timeline(
                modifier = Modifier.height(150.dp),
                lineType = LineType.MIDDLE,
                lineStyle = LineStyle.dashed(
                    color = MaterialTheme.colorScheme.primary
                ),
                marker = {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(MaterialTheme.colorScheme.primary, CircleShape)
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TimelineCustomMarkersPreview() {
    TimelineTheme {
        Column(Modifier.padding(horizontal = 16.dp)) {
            val totalItems = 4
            repeat(totalItems) { position ->

                var modifier = Modifier
                    .height(100.dp)

                if (position != 1) {
                    modifier = modifier.then(Modifier.padding(horizontal = 13.dp))
                }

                Timeline(
                    modifier = modifier,
                    lineType = getLineType(position, totalItems),
                    lineStyle = when (position) {
                        0 -> {
                            LineStyle.dashed(
                                color = Color.Gray,
                                width = 3.dp
                            )
                        }

                        1 -> {
                            LineStyle(
                                startLine = DashedLine(
                                    color = Color.Gray,
                                    width = 3.dp
                                ),
                                endLine = SolidLine(
                                    color = MaterialTheme.colorScheme.primary,
                                    width = 3.dp
                                ),
                            )
                        }

                        else -> {
                            LineStyle.solid(
                                color = MaterialTheme.colorScheme.primary,
                                width = 3.dp
                            )
                        }
                    }
                ) {
                    // Custom marker examples
                    when (position) {
                        0 -> Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(24.dp)
                        )

                        1 -> Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(
                                    MaterialTheme.colorScheme.primary,
                                    RoundedCornerShape(4.dp)
                                )
                        )

                        2 -> Box(
                            Modifier
                                .size(24.dp)
                                .background(MaterialTheme.colorScheme.primary, CircleShape)
                        ) {
                            Text(
                                modifier = Modifier.align(Alignment.Center),
                                text = "3",
                                color = Color.White,
                                textAlign = TextAlign.Center
                            )
                        }

                        else -> {
                            Box(
                                modifier = Modifier
                                    .size(24.dp)
                                    .background(MaterialTheme.colorScheme.primary, CircleShape)
                            )
                        }
                    }
                }
            }
        }
    }
}