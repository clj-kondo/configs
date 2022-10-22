# Clj-kondo configs

Clj-kondo configurations for libraries, as dependencies.

## Including configuration with your own libraries

To give users the best out of the box experience, it is preferred that
configurations for libraries are part of those libraries proper. Read
[here](https://github.com/clj-kondo/clj-kondo/blob/master/doc/config.md#exporting-and-importing-configuration)
how you can do that. Also see a list of projects
[here](https://github.com/clj-kondo/clj-kondo/issues/1383) that are already
currently doing that.

## Gettings configurations from this repo

You can get configurations for your libraries, if they are available in this
repo, by adding dependencies to your `deps.edn` or `project.clj`. E.g. to add a
configuration for Rum:

``` clojure
{:deps {io.github.clj-kondo/config-rum-rum {:mvn/version "<version>"}}}
```

To always get the newest version, you can use [neil](https://github.com/babashka/neil):

```
neil dep add io.github.clj-kondo/config-rum-rum
```

If you don't already have a `.clj-kondo` directory, create one.

With the extra dependencies in place, you can run this:

```
$ clj-kondo --lint $(clojure -Spath) --dependencies --skip-lint --copy-configs
```

and clj-kondo will copy configurations from the dependencies to your local
`.clj-kondo` directory. For leiningen, replace `clojure -Spath` with `lein
classpath`.

If you are using [clojure-lsp](https://github.com/clojure-lsp/clojure-lsp/) the
above will happen automatically.

It is fine to check those configurations into source control if you want to, so
everyone who is linting your code with clj-kondo, will get to see the same
results.

## Naming scheme

Libraries in this repository reflect coordinate names in
`deps.edn`. E.g. configuration for the [rum](https://github.com/tonsky/rum)
library is available in the `configs/rum/rum` library.

The configuration dependency on Clojars follows a similar scheme:

``` clojure
{:deps {io.github.clj-kondo/config-<org>-<lib> {:mvn/version "<version>"}}}
```

## Clojars dependency

To include a configuration in your `deps.edn` or `project.clj` as a Clojars dependency

``` clojure
{:deps {io.github.clj-kondo/config-rum-rum {:mvn/version "<version>"}}}
```

Replace `<version>` with the actual version you want to use.

## Git dependency

To include a configuration in your `deps.edn` as a git dependency:

``` clojure
{:deps {io.github.clj-kondo/config-rum-rum
        {:git/url "https://github.com/clj-kondo/clj-kondo.configs"
         :git/sha "<sha>"
         :deps/root "configs/rum/rum"}}}
```

Replace `<sha>` with the actual SHA you want to use.

Note: `:deps/root` indicates which `deps.edn` in this repository to use.
It is valid to add this repository multiple times with different `:deps/root`s in your `deps.edn`.

## License

MIT, see `LICENSE`.
