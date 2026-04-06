Rate Limiter LLD

1. First off, what a Rate Limiter is?
   1. A Rate Limiter is a mechanism to control how many requests a client can make within a specific timeframe.
   2. It acts like a **traffic controller** for our API  allowing for example 1000 requests per minute.
   3. Prevents abuse, protects our server from being overwhelmed by bursts of traffic, and ensure fair usage.
   
2. Clarifying the requirements:
   1. Functional (The What: Features of a system.)
      1. Need to be able to identify the user by id, IP, or API key.
      2. **Limit Requests** based on configurable rules.
      3. Return proper headers and status codes.
   2. Non-functional (The How: How the sys needs to be able to do 'em.)
      1. I'll assume: 
         1. **Low-latency** 
         2. **Thread-safe:** Multiple threads may call `allowRequest()` concurrently.
         3. Implemented as a single-node in-memory rate limiter. 
         4. **Consistency:** No two requests should consume the same token (atomic check-and-decrement). **It’s concurrency first, but used to guarantee consistency.**
      
2. Algorithm Choice:
   1. Quite a few algos: Fixed window, Sliding window, & Token-bucket, etc.
   2. I'll go w token-bucket as it allows:
      1. Controlled bursts (good for real APIs)
      2. Smooth Rate Limiting
      3. Relatively simple to reason about
      4. Followed by Industry standards: AWS, nginx, etc.
      
5. High-level flow:
   1. Request comes w a key: `allowRequest(clientKey)`
   2. Fetch/Create bucket for that key atomically.
   3. Refill tokens based on elapsed time
   4. If token >= 1, allow decrement
   5. Else -> reject the request

5. Now, I'll map the entities based on the aforementioned flow:
   1. Request
   2. Token -> No identity or behaviour
   3. Token Bucket (Encapsulates the rate-limiting logic)
   4. Rate Limiter (Orchestrator)
   5. Rate Limit Config -> capacity, refillRate (token/s)
