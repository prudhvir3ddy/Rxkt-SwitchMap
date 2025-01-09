### SwitchMap vs FlatMap 

Run the project 

Imagine a scenario 

Task has to be run either 

1. Every few seconds Or
2. When a button is clicked 

In the case of FlatMap, the task will be run every few seconds and when the button is clicked.

But the previous observable will still be alive and hence processes more events than required.

<img width="1279" alt="Screenshot 2025-01-09 at 5 39 11 PM" src="https://github.com/user-attachments/assets/0e9cffab-6644-4fb6-880b-3b6026e0eb43" />


In the case of SwitchMap, the previous observable will be disposed of and the new observable will be created.

Hence only process the event once 

<img width="1211" alt="Screenshot 2025-01-09 at 5 38 35 PM" src="https://github.com/user-attachments/assets/bd80740d-c4f0-4383-97a7-1a2fff690ca0" />
