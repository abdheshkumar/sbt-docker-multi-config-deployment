```
# Sbt Docker
```bash
sbt -Denv=test docker:publishLocal
sbt -Denv=stage docker:publishLocal
sbt -Denv=prod prod:publishLocal
```
