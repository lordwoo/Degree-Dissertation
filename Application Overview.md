Application Package Overview
============================

What follows is a brief overview of each package in the application. For a more detailed overview of the framework package, see the "Framework Overview.md" file in the root directory.

* **action**
The action package contains all the Action classes (service classes) for the application. These classes do the bulk of the work for each client request.

* **dao**
The dao package contains the classes that handle database access. These are called by the Action classes whenever data access is needed.

* **form**
The form package contains the Form classes for the application. These classes handle validation of web form data.

* **framework**
The framework package contains the web application framework classes (see "Framework Overview.md").

* **misc**
The misc package contains several useful classes, such as UnitConverter to handle weight conversion, and FactoryInitialiser to inject the necessary Form and Action classes into the FormFactory and ActionFactory framework classes.

* **model**
The model package contains the classes that handle the osteoporosis risk prediction.