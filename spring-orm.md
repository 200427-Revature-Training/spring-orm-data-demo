# Spring ORM

	Spring ORM is to provide an integration between the Spring environment and a chosen ORM 
	technology (Hibernate).  This allows Spring manage the SessionFactory (or EntityManagerFactory),
	manage transactions, and manage session with the ultimate goal of removing as much boiler plate
	code as possible.  This should make using an ORM in the Java environment less repetitive.
	
## Major Features

### SessionFactory management as a Bean
	Spring ORM will create and manage our SessionFactory (EntityManagerFactory) and provide it to
	any daos or repositories which need to have access to it.
	
### Contextual Sessions
	When integrated with Spring MVC all HTTP requests are automatically provided a Hibernate session. 
	Therefore we do not need to make efforts to create session for every operation, we simply get the
	session we already have created.
	
### Transaction Propagation
	One challenge of working with transactions is how to effectively write reusable, small pieces of
	code while keeping operations transactional. Spring ORM allows us to resolve this by defining
	methods as transactional using the @Transactional annotation and allow transactional methods to
	be combined piecemeal by defining appropriate transaction propagation levels.  These help for 
	Spring and Hibernate to understand what the transactional context of a method should be when they
	are called with some existing context.