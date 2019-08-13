# testPH
PlaceHolder api Test

#to run
gradlew build test 

test https://jsonplaceholder.typicode.com/

Not RESTful
404 on post request
delete returns 200 but does not delete resources
put returns the correct changes with a 200 
as does patch but upon a new get request the resources are unchanged
options returns the correct response 204 when no body returned
no cache 
Read only, data appears to be transactional at first but it is static on the client side and no data is altered
data can only be consumed despite the responses given the service is static

Uses a uniform interface and all data can be accesseed using paths, no queries needed
