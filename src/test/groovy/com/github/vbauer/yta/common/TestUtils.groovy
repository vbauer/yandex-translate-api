package com.github.vbauer.yta.common

import groovy.transform.CompileStatic

import java.lang.reflect.Modifier

/**
 * Helper-class for unit tests.
 *
 * @author Vladislav Bauer
 */

@CompileStatic
final class TestUtils {

    private TestUtils() {
        throw new UnsupportedOperationException()
    }


    static def countStaticFields(Class<?> clazz) {
        return clazz.getDeclaredFields().count { field ->
            def modifiers = field.getModifiers()
            Modifier.isStatic(modifiers) && Modifier.isPublic(modifiers) ? 1 : 0
        }
    }

}
