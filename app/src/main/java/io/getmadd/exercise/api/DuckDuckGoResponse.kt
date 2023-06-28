package io.getmadd.exercise.api

import java.io.Serializable

data class DuckDuckGoResponse(
    val Abstract: String,
    val AbstractSource: String,
    val AbstractText: String,
    val AbstractURL: String,
    val Answer: String,
    val AnswerType: String,
    val Definition: String,
    val DefinitionSource: String,
    val DefinitionURL: String,
    val Entity: String,
    val Heading: String,
    val Image: String,
    val ImageHeight: String,
    val ImageIsLogo: String,
    val ImageWidth: String,
    val Infobox: String,
    val Redirect: String,
    val RelatedTopics: List<RelatedTopic>
)

data class RelatedTopic(
    val FirstURL: String,
    val Icon: Icon,
    val Result: String,
    val Text: String
):Serializable

data class Icon(
    val Height: String,
    val URL: String,
    val Width: String
)
