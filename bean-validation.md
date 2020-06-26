# Bean Validation

Bean validation is the process of validating the form of beans at various stages during processing.
Bean validation has been defined using Java standards JSR-303 recently superceded by JSR-380. 

The principle idea is that we can provide simple rules for the format of data and then use hooks
provided by annotations to validate the form of data. This can also produce consistent feedback for
validation failure making it easy to integrate client side feedback to the user.

## Implementing Bean Validation

1. Apply appropriate JSR 303/380 annotations in the model class (or whatever bean you are validating).
2. Apply the @Valid annotation at the property at the level you want to validate it (often the controller).

When data is provided to the function with the @Valid constraint but does not meet the specification
for validity, it will throw an exception that details the constraint violations.  If it happens at the
Spring MVC controller layer, it will automatically generate a response which details which validation
errors failed and provide thorough feedback in the HTTP response.

Some Advice: You can get far more fine grained control if you create DTO objects. DTOs are 
Data Transfer Objects.  Rather than expecting users to send something matching the Model, we have them
send a DTO object which can have a different form and its own validation logic.

JSR 303/380 is a specification. Our implementation is the Hibernate Validator.  It is 
supplied to projects using spring-boot-starter-web (Spring Boot's MVC package).