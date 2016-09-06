
# Yandex Translate API

[![License](http://img.shields.io/badge/license-MIT-blue.svg?style=flat)](http://www.opensource.org/licenses/MIT) 
[![Codacy Badge](https://api.codacy.com/project/badge/grade/000e32339abf4a7ab3b8fe98e07548bb)](https://www.codacy.com/app/bauer-vlad/yandex-translate-api) 
[![Coverage Status](https://coveralls.io/repos/vbauer/yandex-translate-api/badge.svg?branch=master&service=github)](https://coveralls.io/github/vbauer/yandex-translate-api?branch=master) 
[![Build Status](https://travis-ci.org/vbauer/yandex-translate-api.svg?branch=master)](https://travis-ci.org/vbauer/yandex-translate-api) 
[![Dependency Status](https://www.versioneye.com/user/projects/562e9ae336d0ab0016001618/badge.svg?style=flat)](https://www.versioneye.com/user/projects/562e9ae336d0ab0016001618)

**yandex-translate-api** is a simple REST client library for [Yandex.Translate](https://translate.yandex.com).
The API provides access to the Yandex online machine translation service. 
It supports more than 60 languages and can translate separate words or complete texts.

**Online documentation:** [Javadoc](https://vbauer.github.io/yandex-translate-api)


# Prerequisites

The following actions are required to work with this library:

* Install JDK 1.8
* Get a free [API key](https://tech.yandex.com/key/form.xml?service=trnsl).


# Setup

Maven configuration:
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.vbauer</groupId>
    <artifactId>yandex-translate-api</artifactId>
    <version>1.2.4</version>
</dependency>
```

Gradle configuration:
```groovy
repositories {
    maven {
        url "https://jitpack.io"
    }
}

dependencies {
    compile 'com.github.vbauer:yandex-translate-api:1.2.4'
}
```


# Usage

**FYI:**

* Groovy language is used in the examples just to simplify them.
* Additional documentation about the official Yandex.Translate API could be found here: https://tech.yandex.com/translate/doc/dg/concepts/api-overview-docpage/

The entry point of this library is `YTranslateApi` interface (and the corresponding implementation `YTranslateApiImpl`).

```groovy
def key = "<your key>"
def api = new YTranslateApiImpl(key)
```

Using instance of this service you can work with the following features:

* `DetectionApi` detects the language of the specified text.
* `LanguageApi` returns a list of translation directions supported by the service.
* `TranslationApi` allows to translate text from one language to another.


## DetectionApi

The following example returns `Language.EN`:

```groovy
def language = api.detectionApi().detect("Hello, World!")
```


## LanguageApi

To retrieve all available languages without their names, use the following code snippet:
 
```groovy
def languages = api.languageApi().all()
```

It is also possible to fetch names for each language, using `ui` parameter:

```groovy
def languages = api.languageApi().all(Language.RU)
```


## TranslationApi

The following code should translate Russian's `"Как дела?"` to some English variant 
(`"How are you doing?"` or something similar):

```groovy
def translation = api.translationApi().translate(
    "Как дела?", Direction.of(Language.RU, Language.EN)
)
```

Source language could be also detected automatically (so you need to specify only target language):
```groovy
def translation = api.translationApi().translate("Как дела?", Language.EN)
```


# Thanks to

* Yandex LLC and all their developers for the great service.
* [Vyacheslav Rusakov](https://github.com/xvik) for the following Gradle plugins: [gradle-java-lib-plugin](https://github.com/xvik/gradle-java-lib-plugin) and [gradle-quality-plugin](https://github.com/xvik/gradle-quality-plugin).


# License

[MIT](LICENSE)
