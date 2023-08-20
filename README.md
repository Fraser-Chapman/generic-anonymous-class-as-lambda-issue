# Generic anonymous class as lambda issue
Project to reproduce error seen when using Java's shorthand to declare anonymous classes.

# Steps to reproduce:

1. Run `./gradlew build`
2. Observe error
3. navigate to `uk.co.fraserchapman.configuration.MongoTypeConverters`
4. Uncomment anonymous class definitions, comment shorthand lambda definitions
5. Run `./gradlew build` observe tests passing
