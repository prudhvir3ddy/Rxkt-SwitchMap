### SwitchMap vs FlatMap 

Run the project 

Imagine a scenario 

Task has to be run either 

1. Every few seconds Or
2. When a button is clicked 

In the case of FlatMap, the task will be run every few seconds and when the button is clicked.

But the previous observable will still be alive and hence processes more events than required.

In the case of SwitchMap, the previous observable will be disposed of and the new observable will be created.
