# purescript-prelude

## JVM tests

`./bin/test` selects `prelude` in the [common isolated runner](../javapurs/docs/testing.md#port-particulier), preserving this checkout and its outputs. `MainRun` calls the original synchronous `AlmostEff = Unit -> Unit` entrypoint.
Use `./bin/test --help` for options and `./bin/test --clean` to rebuild the backend. The linked guide covers prerequisites, Java target/runtime settings and retained failure logs.

[![Latest release](http://img.shields.io/github/release/purescript/purescript-prelude.svg)](https://github.com/purescript/purescript-prelude/releases)
[![Build status](https://github.com/purescript/purescript-prelude/workflows/CI/badge.svg?branch=master)](https://github.com/purescript/purescript-prelude/actions?query=workflow%3ACI+branch%3Amaster)
[![Pursuit](https://pursuit.purescript.org/packages/purescript-prelude/badge)](https://pursuit.purescript.org/packages/purescript-prelude)

The PureScript prelude.

## Installation

```
spago install prelude
```

## Documentation

Module documentation is [published on Pursuit](http://pursuit.purescript.org/packages/purescript-prelude).
