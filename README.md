
# Yandex Translate API

**yandex-translate-api** is a simple REST client library for [Yandex.Translate](https://translate.yandex.com).
The API provides access to the Yandex online machine translation service. 
It supports more than 60 languages and can translate separate words or complete texts.


# Prerequisites

The following actions are required to work with this library:

* Install JRE 1.8
* Get a free [API key](https://tech.yandex.com/key/form.xml?service=trnsl).


# Usage

**FYI:**

* Groovy language is used in examples just to simplify them.
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
(`"How are you doing?" or something similar):`

```
def translation = api.translationApi().translate("Как дела?", Language.EN)
```


# Thanks to

Yandex LLC and all their developers for the great service.


# License

[MIT](LICENSE.md)
