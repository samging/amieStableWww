package org.example.stableweb.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import org.example.stableweb.components.layouts.PageLayoutData
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Text
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.modifiers.display
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.vh
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import org.jetbrains.compose.web.dom.Span
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H3
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.onMouseMove
import org.w3c.dom.events.MouseEvent
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.compose.ui.modifiers.left
import com.varabyte.kobweb.compose.ui.modifiers.bottom
import com.varabyte.kobweb.compose.ui.modifiers.right
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.position
import org.jetbrains.compose.web.css.Position
import com.varabyte.kobweb.compose.ui.styleModifier
import org.w3c.dom.HTMLElement
import com.varabyte.kobweb.compose.dom.ref
import androidx.compose.runtime.DisposableEffectScope
import com.varabyte.kobweb.compose.dom.disposableRef
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import org.jetbrains.compose.web.css.vh

@InitRoute
fun initHomePage(ctx: InitRouteContext) {
    ctx.data.add(PageLayoutData("Home"))
}

private val buttonModifier = Modifier
    .border(width = 2.px, style = LineStyle.Solid, color = Colors.Black)
    .backgroundColor(Colors.White)
    .fontFamily("JakartaSans")
    .color(Colors.Black)
    .fontWeight(FontWeight.Bold)
    .borderRadius(0.px)
    .padding(topBottom = 5.px, leftRight = 30.px)

private val downloadButtons = Modifier
    .border(width = 2.px, style = LineStyle.Solid, color = Colors.Black)
    .backgroundColor(Colors.White)
    .fontFamily("JakartaSans")
    .color(Colors.Black)



@Page
@Composable
fun HomePage() {
    var circleRef by remember { mutableStateOf<HTMLElement?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .minHeight(100.vh)
            .position(Position.Relative)
            .onMouseMove { event ->
                val x = event.clientX
                val y = event.clientY

                circleRef?.style?.transform =
                    "translate3d(${x}px, ${y}px, 0px) translate(-50%, -50%)"
            }
    )
    {

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .backgroundColor(Colors.Black)
                    .padding(leftRight = 20.px),
                contentAlignment = Alignment.Center
            ) {
                Img(
                    src = "ascii_amie_welcome.png",
                    alt = "Site Logo",
                    attrs = Modifier
                        .width(180.px)
                        .display(DisplayStyle.Block)
                        .margin(all = 0.px)
                        .toAttrs()
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .backgroundColor(Colors.White),
                contentAlignment = Alignment.CenterEnd
            )
            {
                Button(attrs = buttonModifier.toAttrs()) { Text("Home") }
                Button(attrs = buttonModifier.toAttrs()) { Text("Documentation") }
                Button(attrs = buttonModifier.toAttrs()) { Text("Examples") }
            }
            Pipe("")
        }
    }
}


@Composable
fun briefExample(modifier: Modifier) {
    H3 {
        Text("All it takes")
    }
    Span(attrs = Modifier.backgroundColor(Colors.Gray).toAttrs()) {
        Text("1")
    }
}

enum class DownloadType { BREW, CURL, GIT }

@Composable
fun briefDescription(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .maxWidth(600.px)
            .padding(topBottom = 20.px, leftRight = 15.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        H1(
            attrs = Modifier
                .color(Colors.Black)
                .fontSize(32.px)
                .fontWeight(FontWeight.Bold)
                .margin(bottom = 12.px)
                .textAlign(TextAlign.Center)
                .fontFamily("JakartaSans")
                .toAttrs()
        ) {
            Text("Welcome to AMIE")
        }

        P(
            attrs = Modifier
                .color(Colors.DarkGray)
                .fontSize(16.px)
                .lineHeight(1.5.em)
                .margin(all = 0.px)
                .textAlign(TextAlign.Center)
                .fontFamily("JakartaSans")
                .toAttrs()
        ) {
            Text("Amie is a dedicated tool for managing ONNX model runtime pipelines using its macros and pre-built pilot.")
        }
    }
}

@Composable
fun briefDocumentation(modifier: Modifier) {
    H3 (attrs = Modifier.fontFamily("JakartaSans").toAttrs()){
        Text("Documentation made easy")
    }
    Button(attrs = Modifier.backgroundColor(Colors.Blue).color(Colors.White).fontFamily("JakartaSans").toAttrs()) {
        Text("Documentation")
    }
}

@Composable
fun downloadBox(modifier: Modifier) {
    var brewDialog = "brew --cask install amie"
    var curlDialog = "curl -sSl github.com/amie"
    var gitDialog = "git clone github.com/amie"
    var activeType by remember { mutableStateOf(DownloadType.BREW) }


    Box(
        modifier = Modifier
            .backgroundColor(Colors.Black)
            .width(200.px)
            .height(240.px)
            .padding(top = 30.px, left = 10.px)
    ) {
        Span(
            attrs = Modifier
                .color(Colors.White)
                .textAlign(TextAlign.Center)
                .fontFamily("JakartaSans")
                .toAttrs()
        ) {
            Text("Download")
        }
            Box(
            modifier = Modifier
                .backgroundColor(Colors.White)
                .width(190.px)
                .height(220.px)
        ) {
                Button(
                    attrs = downloadButtons
                        .fontFamily("JakartaSans")
                        .onClick { activeType = DownloadType.BREW }
                        .toAttrs()
                ) {
                    Text("Brew")
                }

                Button(
                    attrs = downloadButtons
                        .onClick { activeType = DownloadType.CURL }
                        .toAttrs()
                ) {
                    Text("Curl")
                }

                Button(
                    attrs = downloadButtons
                        .onClick { activeType = DownloadType.GIT }
                        .toAttrs()
                ) {
                    Text("Git")
                }

                Box {
                    when (activeType) {
                        DownloadType.BREW -> Text(brewDialog)
                        DownloadType.CURL -> Text(curlDialog)
                        DownloadType.GIT -> Text(gitDialog)
                    }
                }
            }
    }
}

@Composable
fun Pipe(txt: String, composableComponent: (@Composable (Modifier) -> Unit)? = null) {
    Box(
        modifier = Modifier
            .height(100.vh)
            .padding(top = 10.px, left = 85.vh),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(2.px)
                .margin(leftRight = 50.px)
                .fillMaxHeight()
                .backgroundColor(Colors.Black)
        ) {}

        composableComponent?.invoke(Modifier)
        Text("$txt")
    }
}





//            Row(
//                modifier = Modifier
//                    .backgroundColor(Colors.Green)
//                    .fillMaxWidth(30.percent),
////                verticalAlignment = Alignment.CenterVertically,
////                horizontalArrangement = Arrangement.Center
//            ) {
