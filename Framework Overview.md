Framework Overview
==================

What follows is a typical request/response cycle for my web application. I recommend you open the SequenceDiagram.jpg file, found in the root app directory, as it provides a visual representation of this description.

1. Client sends an HTTP request. All request URLs should map to the `FrontController`'s URL pattern which, by default, is `"/pages/*"`.

2. Before reaching the `FrontController`, the request is intercepted by the `AttributeSafetyFilter`. This filter wraps the request and response objects in the attribute-safety wrappers, which add functionality to keep request attributes alive if a client-side redirect occurs (normally the request object would be dropped on a redirect, and any attributes it references would be lost).
Note: this step is currently missing from the sequence diagram.

3. The request reaches the `FrontController`. It's first action is form validation: it checks to see if the request contains any form data by calling the `FormFactory`'s `getForm()` method.

4. The `FormFactory` will check it's map of `Form` classes to see if any match the request parameters (this map should be populated via dependency injection prior to the application's first request). If a `Form` class is found, it will be instantiated and populated with the relevant HTTP parameters, and then returned.

5. The `FrontController` then calls the `Form` class' `validate()` method. This method runs through each field in the `Form` and applies basic validation rules as defined by the parameters of the `FormField` annotation on that field. It then runs through any custom validation rules as defined by any methods in the `Form` that are annotated with `Validation`. If any error messages result, a map is populated with the necessary information, and the `FrontController` will send the client back to the web form, displaying the error messages.

6. If the form data passes validation, the `Form` will be added to the request for use in the appropriate service method. Next, the `FrontController` calls the `ActionFactory`'s `getAction()` method to get the correct service class, or `Action`, for servicing the request.

7. The `ActionFactory` will check it's map of `Action` classes to see if any match the request parameters (this map should be populated via dependency injection prior to the application's first request). If an `Action` class is found, it will be instantiated and then returned. If no Action is found, the default Action, ViewPage, will be returned, on the assumption that the request was for a simple page view.

8. The `FrontController` will then call the `Action` class' `execute()` method. This method will perform the necessary steps to complete the service required, for example logging a user in to the system. It should then return a `String` representing the JSP that should process the response. For example, the ViewPage Action simply returns the String from the original HTTP request.

9. The `FrontController` then decides whether to forward the request to a JSP to render the response, or to redirect the client to a new page. If the `String` returned by the `Action` matches the original request URL, the request will be forwarded. If the `String` is different, a redirect will be sent, so that the client's browser address bar will not display a mismatched URL. This also helps prevent duplicate form submissions. (This is the reason for the attribute-safety component: attributes such as feedback messages generated and added to the request by the Action would be lost without it.)

10. The appropriate JSP renders the response, and sends it back to the client.