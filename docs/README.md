# User Guide

## Features 

### 1. Add Todo
Add a todo task to your task list.

### 2. Add Deadline
Add a deadline to your task list.

### 3. Add Event
Add an event to your task list.

### 4. Mark task as Done
Mark a task in your task list as done.

### 5. List all tasks
List all tasks in your task list.

### 6. Delete task
Delete a task from your task list.

### 7. Find task
Find tasks containing a keyword.

### 8. Save task list
Save your task list to a .txt file.

## Usage

### `todo <task description>` - Add a Todo task

Add a Todo task to your task list.

Example of usage:

`todo read book`

Expected outcome:

`____________________________________________________________
Got it. I've added this task: `
`[T][✗] read book`
`Now you have 1 tasks in the list.`
`____________________________________________________________`

### `deadline <task description> /by <date>` - Add a Deadline

Add a Deadline task to your task list.

Example of usage:

`deadline return book /by Monday`

Expected outcome:

`____________________________________________________________
Got it. I've added this task: `
`[D][✗] return book (by: Monday)`
`Now you have 2 tasks in the list.`
`____________________________________________________________`

### `event <task description> /at <date>` - Add an Event

Add an Event task to your task list.

Example of usage:

`event book fair /at 5pm Tuesday`

Expected outcome:

`____________________________________________________________
Got it. I've added this task: `
`[E][✘] book fair (at: 5pm Tuesday)`
`Now you have 3 tasks in the list.`
`____________________________________________________________`

### `done <task index>` - Mark task as done

Mark a task in your task list as done.

Example of usage:

`done 1`

Expected outcome:

`____________________________________________________________
Nice! I've marked this task as done: `
`[[T][✓] read book`
`____________________________________________________________`

### `list` - List all tasks

List all tasks in your task list.

Example of usage:

`list`

Expected outcome:

`____________________________________________________________
Here are the tasks in your list: `
`1. [T][✓] read book`
`2. [D][✘] return book (by: Monday)`
`3. [E][✘] book fair (at: 5pm Tuesday)`
`____________________________________________________________`

### `delete <task index>` - Delete a task
 
Delete a task from your task list.

Example of usage:

`delete 1`

Expected outcome:

`____________________________________________________________`
`Removed: [T][✓] read book`
`Now you have 2 task(s) in your list`
`____________________________________________________________`

### `find <keyword>` - Find tasks

Find tasks with matching keyword.

Example of usage:

`find book`

Expected outcome:


`Here are the matching tasks in your list: `
`1. [D][✘] return book (by: Monday)`
`2. [E][✘] book fair (at: 5pm Tuesday)`

### `save` - Save task list

Save task list to .txt file.

Example of usage:

`save`

Expected outcome:

	`Successfully saved to file!`

