# Rest User Greeting

Returns a greeting when requested. A username from [basic-rest-users][1] can be optionally used as input.

## Abstract

This REST based application is used in conjuction with [basic-rest-users][1] for a REST producer/consumer example.

## Test Strategy

This application assumes that [basic-rest-users][1] is running and providing user information from its user details endpoint (/users/{id}). On that assumption, we bound this rest-user-greeting to a contract with [basic-rest-users][1].

The contract will be tested using a "contract test", which is the same as calling the API with specific expectations. Spring Cloud Contract will be used for both projects to test the contract.

[1]: https://github.com/gumold/basic-rest-users
