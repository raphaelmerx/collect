package org.odk.collect.projects

sealed class Project {
    abstract val name: String
    abstract val icon: String
    abstract val color: String

    data class New(
        override val name: String,
        override val icon: String,
        override val color: String
    ) : Project()

    data class Saved(
        val uuid: String,
        override val name: String,
        override val icon: String,
        override val color: String
    ) : Project() {

        constructor(uuid: String, project: New) : this(
            uuid,
            project.name,
            project.icon,
            project.color
        )
    }

    companion object {
        const val DEMO_PROJECT_ID = "MSSI"
        const val DEMO_PROJECT_NAME = "Subsidiu Fim do Ano"
        const val DEMO_PROJECT_ICON = "S"
        const val DEMO_PROJECT_COLOR = "#3e9fcc"

        val DEMO_PROJECT = Saved(DEMO_PROJECT_ID, DEMO_PROJECT_NAME, DEMO_PROJECT_ICON, DEMO_PROJECT_COLOR)
    }
}
