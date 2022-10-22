# Clj-kondo configs

Clj-kondo configurations for libraries, as dependencies.

Libraries in this repository reflect coordinate names in
`deps.edn`. E.g. configuration for the [rum](https://github.com/tonsky/rum)
library is available in the `rum/rum` library.

## Clojars dependency

To include a configuration in your `deps.edn` or `project.clj` as a Clojars dependency

``` clojure
{:deps {io.github.clj-kondo/config-rum {:mvn/version "<version>"}}}
```

Replace `<version>` with the actual version you want to use.

## Git dependency

To include a configuration in your `deps.edn` as a git dependency:

``` clojure
{:deps {io.github.clj-kondo/config-rum {:git/url "https://github.com/clj-kondo/clj-kondo.configs"
                                        :git/sha "<sha>"
                                        :deps/root "rum/rum"}}}

```

Replace `<sha>` with the actual SHA you want to use.

Note: `:deps/root` indicates which `deps.edn` in this repository to use.
It is valid to add this repository multiple times with different `:deps/root`s in your `deps.edn`.

## License

MIT, see `LICENSE`.
