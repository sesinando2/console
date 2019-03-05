ruleset {

    ruleset('rulesets/basic.xml')
    ruleset('rulesets/braces.xml')
    ruleset('rulesets/concurrency.xml')
    ruleset('rulesets/convention.xml') {
        NoDef {
            enabled = false
        }

        VariableTypeRequired {
            enabled = false
        }
    }
    ruleset('rulesets/design.xml')
    ruleset('rulesets/dry.xml')
    ruleset('rulesets/exceptions.xml')
    ruleset('rulesets/formatting.xml') {
        ClassEndsWithBlankLine {
            enabled = false
        }

        SpaceAroundMapEntryColon {
            characterAfterColonRegex = '\\s'
        }
    }
    ruleset('rulesets/generic.xml')
    ruleset('rulesets/groovyism.xml')
    ruleset('rulesets/imports.xml') {
        MisorderedStaticImports {
            enabled = false
        }
    }
    ruleset('rulesets/jdbc.xml')
    ruleset('rulesets/logging.xml')
    ruleset('rulesets/naming.xml') {
        MethodName {
            doNotApplyToFileNames = '*Spec.groovy'
        }
    }
    ruleset('rulesets/security.xml')
    ruleset('rulesets/serialization.xml')
    ruleset('rulesets/size.xml') {
        CrapMetric {
            enabled = false
        }
    }
    ruleset('rulesets/unnecessary.xml')
    ruleset('rulesets/unused.xml')
}