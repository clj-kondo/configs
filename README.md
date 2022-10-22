# Clj-kondo configs

Clj-kondo configurations for libraries, as dependencies.

## Gettings configurations

You can get configurations for your libraries, if they are available in this
repo, by adding dependencies to your `deps.edn` or `project.clj`, e.g.:

```
{:deps {io.github.clj-kondo/config-rum-rum {:mvn/version "<version>"}}}
```

If you don't already have a `.clj-kondo` directory, create one.

With the extra dependencies in place, you can run this:

```
$ clj-kondo --lint $(clojure -Spath) --dependencies --skip-lint --copy-configs
```

and clj-kondo will copy configurations from the dependencies to your local
`.clj-kondo` directory.

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
