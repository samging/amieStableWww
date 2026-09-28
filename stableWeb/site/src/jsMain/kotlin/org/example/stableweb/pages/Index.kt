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
import kotlinx.browser.window
import com.varabyte.kobweb.silk.components.icons.fa.FaCopy
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.dpi

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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .minHeight(100.vh)
            .backgroundColor(Colors.Black),
        verticalArrangement = Arrangement.SpaceBetween
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
                    .backgroundColor(Colors.Black),
                contentAlignment = Alignment.CenterEnd
            )
            {
                Button(attrs = buttonModifier.toAttrs()) { Text("Home") }
                Button(attrs = buttonModifier.toAttrs()) { Text("Documentation") }
                Button(attrs = buttonModifier.toAttrs()) { Text("Examples") }
            }
            Box(modifier = Modifier.padding(left = 75.vh)) {
                briefDescription()
                downloadBox(Modifier)
            }
        }
        Pipe("", {briefExample(Modifier)})
        footer()
    }
}

@Composable
fun footer(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .backgroundColor(Colors.Black)
            .padding(left = 20.px, right = 20.px)
            .margin(top = 220.px),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Span(
                attrs = Modifier
                    .color(Colors.White)
                    .fontFamily("JakartaSans")
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Bold)
                    .margin(bottom = 8.px)
                    .toAttrs()
            ) {
                Text("AMIE - ONNX Model Runtime Pipeline Manager")
            }
            Span(
                attrs = Modifier
                    .color(Colors.LightGray)
                    .fontFamily("JakartaSans")
                    .fontSize(12.px)
                    .toAttrs()
            ) {
                Text("© 2025 AMIE. All rights reserved.")
            }
        }
    }
}
@Composable
fun briefExample(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        H3(attrs = Modifier.fontFamily("JakartaSans").margin(bottom = 12.px).toAttrs()) {
            Text("Code snippet example")
        }
        Column(
            modifier = Modifier
                .backgroundColor(Colors.Black)
                .color(Colors.White)
                .fontFamily("monospace")
                .fontSize(14.px)
                .padding(all = 16.px)
                .borderRadius(8.px)
                .border(width = 1.px, style = LineStyle.Solid, color = Colors.DarkGray)
        ) {
            Row(modifier = Modifier.margin(bottom = 6.px), verticalAlignment = Alignment.CenterVertically) {
                Span(attrs = Modifier.color(Colors.Gray).width(24.px).toAttrs()) {
                    Text("1")
                }
                Span(attrs = Modifier.color(Colors.Cyan).margin(left = 8.px).toAttrs()) {
                    Text("amie.init()")
                }
            }
            Row(modifier = Modifier.margin(bottom = 6.px), verticalAlignment = Alignment.CenterVertically) {
                Span(attrs = Modifier.color(Colors.Gray).width(24.px).toAttrs()) {
                    Text("2")
                }
                Span(attrs = Modifier.color(Colors.White).margin(left = 8.px).toAttrs()) {
                    Text("val constrains = listOf('greetings')")
                }
            }
            Row(modifier = Modifier.margin(bottom = 12.px), verticalAlignment = Alignment.CenterVertically) {
                Span(attrs = Modifier.color(Colors.Gray).width(24.px).toAttrs()) {
                    Text("3")
                }
                Span(attrs = Modifier.color(Colors.White).margin(left = 8.px).toAttrs()) {
                    Text("amie.argmax(constrains) { print('hi') }")
                }
            }
            Row(
                modifier = Modifier.margin(top = 8.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(attrs = Modifier
                    .backgroundColor(Colors.White)
                    .color(Colors.Black)
                    .fontFamily("JakartaSans")
                    .fontWeight(FontWeight.Bold)
                    .padding(topBottom = 4.px, leftRight = 12.px)
                    .borderRadius(4.px)
                    .margin(right = 12.px)
                    .toAttrs()
                ) {
                    Text("Documentation")
                }
                Span(attrs = Modifier.color(Colors.Gray).fontFamily("JakartaSans").fontSize(12.px).toAttrs()) {
                    Text("Coming soon")
                }
            }
        }
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
                .color(Colors.White)
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
                .color(Colors.LightGray)
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
            .width(500.px)
            .height(150.px)
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
                .width(490.px)
                .height(120.px)
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
                        DownloadType.BREW -> {
                            Span(attrs = Modifier.fontFamily("JakartaSans").toAttrs()) {
                                Text(brewDialog)
                            }
                            Button(
                                attrs = Modifier
                                    .onClick {
                                        window.navigator.clipboard.writeText(brewDialog)
                                    }
                                    .toAttrs()
                            ) {
                                FaCopy()
                            }
                        }
                        DownloadType.CURL -> {
                            Span(attrs = Modifier.fontFamily("JakartaSans").toAttrs()) {
                                Text(curlDialog)
                            }
                        }
                        DownloadType.GIT -> {
                            Span(attrs = Modifier.fontFamily("JakartaSans").toAttrs()) {
                            Text(gitDialog)
                            }
                        }
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
                .padding(top = 10.px, bottom = 20.px)
                .fillMaxHeight()
                .backgroundColor(Colors.White)
        ) {
            Img(
                src = "astroWallpaper.png", attrs = Modifier
                    .width(50.vh)
                    .height(30.vh)
                    .padding(top = 50.vh)
                    .toAttrs()
            )
        }
        Box {
        composableComponent?.invoke(Modifier)
        Text("$txt")
    }
    }
}





//            Row(
//                modifier = Modifier
//                    .backgroundColor(Colors.Green)
//                    .fillMaxWidth(30.percent),
////                verticalAlignment = Alignment.CenterVertically,
////                horizontalArrangement = Arrangement.Center
//            ) {
