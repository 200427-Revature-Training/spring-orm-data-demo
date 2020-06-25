# Spring Data

Spring data is a module for the Spring Framework which attempts to entirely abstract the process of
handling persistent data.  This is accomplished by providing interfaces which can interact with the
persistence context natively without us having to provide any help regarding how those methods should
be implemented.  Essentially, it allows us to tell the persistence context what Entity we're operating
on at the class level, such that all operations in class can be assumed to be about this entity
and expose a variety of methods directly without the implementation of a DAO.

# Major feature: Repository interfaces - which provide variety of built in methods similar to 
	Hibernate's session but requiring very little code to work with.
	
	1. Repository - Generic Repository base interface
	2. CrudRepository - Repository with built in CRUD operations.
	3. PagingAndSortingRepository - Repository with built in support for paging and sorting result sets.
	4. JpaRepository - Leverages full JPA power to provide more generated methods and a fluent-method API.
	
