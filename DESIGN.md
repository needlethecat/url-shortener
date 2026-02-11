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


## Ongoing thinking - to be deleted later
Database - need to store longUrl and alias, with alias being unique. Might be a good time to learn
using redis? Seems like a good for key-value storage with alias being the key

Shortening url - need to have some way to generate the short url so there is a sufficient number of 
combinations for use. Also so that they are unique, dont want two to generate the same. Both for the
database and also because even if a url is deleted, ideally I dont want to generate the same url for
another url. Maybe some sort of hashing? Or maybe enough combinations that collisions are very
unlikely 

