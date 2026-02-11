# Design Decisions

## Backend 

### Database

I chose Redis as the backend database, configured with persistence enabled so that shortened URLs 
survive application restarts

Redis is commonly used as an in-memory key–value store (e.g. caching), rather than as a primary database 
for large/complex datasets, however the data model for this application is simple

I selected Redis for two main reasons:
- The key–value access pattern maps naturally to alias-based URL lookups and redirects
- It provided a good opportunity to learn and work with Redis in a context where its limitations are 
  acceptable and well understood

In a production system with larger scale or stronger durability requirements, a relational or 
document-oriented database might be more appropriate

### Alias Generation

The url alias is generated with a Base62 random 8 character string. This gives about 200 trillion combinations.
I check the existence of the alias in the database before saving to avoid collisions. In a production system I
(as mentioned before) would use a different type of database with a unique id. I would use that id to encode
a Base62 string as it would guarantee uniquess and I would be able to remove the collision check

