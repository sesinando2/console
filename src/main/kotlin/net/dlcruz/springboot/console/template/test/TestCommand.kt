package net.dlcruz.springboot.console.template.test

import com.github.fonimus.ssh.shell.PromptColor
import com.github.fonimus.ssh.shell.commands.SshShellComponent
import org.jline.utils.AttributedStringBuilder
import org.jline.utils.AttributedStyle
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellOption

@SshShellComponent
class TestCommand {

    @ShellMethod("Echo command")
    fun echo(message: String, @ShellOption(defaultValue = ShellOption.NULL) color: PromptColor?): String {

        if (color != null) {
            return AttributedStringBuilder().append(message, AttributedStyle.DEFAULT.foreground(color.toJlineAttributedStyle())).toAnsi()
        }

        return message
    }

    @ShellMethod("Pojo command")
    fun pojo(): Pojo {
        return Pojo("value1", "value2")
    }

    class Pojo {

        var key1: String? = null

        var key2: String? = null

        constructor(key1: String, key2: String) {
            this.key1 = key1
            this.key2 = key2
        }

        override fun toString(): String {
            return "Pojo{" +
                    "key1='" + key1 + '\''.toString() +
                    ", key2='" + key2 + '\''.toString() +
                    '}'.toString()
        }
    }
}