# Dynamic mappings

Show case for using java system properties to change your build behaviour.
Used to create different output packages.


```bash
sbt -Denv=test universal:packageBin
sbt -Denv=stage universal:packageBin
sbt -Denv=prod universal:packageBin
```
# Sbt Docker
```bash
sbt -Denv=test docker:publishLocal
sbt -Denv=stage universal:publishLocal
sbt -Denv=prod universal:publishLocal
```

The `BuildEnv` autoplugin is responsible for parsing the env parameter.
