This is the graphql webflux tutorial. In Reactive Streaming, we have
to return the Mono<Object> or Flux<Object>, However, in GraphQL Kickstart
library, we have to convert the Flux to Mono, then call toFuture to convert
the Flux to Future. I think this is limited by the graphql java library.

This has to be changed. Because it's making the code really bad.