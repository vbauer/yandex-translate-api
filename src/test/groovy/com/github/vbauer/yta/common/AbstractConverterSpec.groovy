package com.github.vbauer.yta.common

import groovy.transform.CompileStatic
import spock.lang.Specification

/**
 * Basic class to test converters.
 *
 * @author Vladislav Bauer
 */

@CompileStatic
abstract class AbstractConverterSpec extends Specification {

    protected abstract converter()

}
