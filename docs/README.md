# User Guide

## Features 

### List Tasks
Displays a list of existing tasks

### Add Task
Adds a new task to the list of tasks. Task can be in the form of a Todo, a Deadline, or an Event

### Find Tasks
Displays a list of tasks matching the given keyword

### Complete Task
Marks a task as done

### Delete Task
Deletes a task

### Undo
Undoes the previous action if it modified the list of tasks

### Display Help
Displays a list of available commands

## Usage

### `list` - Displays a list of existing tasks

Displays a list of existing tasks

Format: `list`

Example of usage: `list`

Expected outcome:

```
Here are the tasks in your list nya:
    1.[T][n] CS2100 revision
    2.[D][n] CS2103 iP (by: 30/09/2019 2359)
    3.[E][n] Celebrate end of mid-terms (at: 05/10/2019 1300)
```

### `todo` - Adds a new Todo task to the list of tasks

Adds a new Todo task tagged with a name to the list of tasks.

Format: `todo [name]`

Example of usage: `todo CS2103 tP`

Expected outcome:

```
Meow! Got it~ I've added this task nya:
    [T][n] CS2103 tP
Now you have 4 tasks in the list nya~
```

### `deadline` - Adds a new Deadline task to the list of tasks

Adds a new Deadline task tagged with a name and due date to the list of tasks.

Format: `deadline [name] /by [dd/mm/yyyy hhmm]` 

Example of usage: `deadline iP user guide /by 30/09/2019 2359`

Expected outcome:

```
Meow! Got it~ I've added this task nya:
    [D][n] iP user guide (by: 30/09/2019 2359)
Now you have 5 tasks in the list nya~
```

### `event` - Adds a new Event task to the list of tasks

Adds a new Event task tagged with a name and date to the list of tasks.

Format: `event [name] /at [dd/mm/yyyy hhmm]`

Example of usage: `event Celebrate completion of iP /at 30/09/2019 2359`

Expected outcome:

```
Meow! Got it~ I've added this task nya:
    [E][n] Celebrate completion of iP (by: 30/09/2019 2359)
Now you have 6 tasks in the list nya~
```

### `find` - Displays a list of tasks matching the given keyword

Displays a list of tasks matching the given keyword.

Format: `find [keyword]`

Example of usage: `find iP`

Expected outcome:

```
Here are the matching tasks in your list nya:
    1.[D][n] CS2103 iP (by: 30/09/2019 2359)
    2.[D][n] iP user guide (by: 30/09/2019 2359)
    3.[E][n] Celebrate completion of iP (at: 30/09/2019 2359)
```

### `done` - Marks a task as done

Marks the task at the specified index in the list of tasks as done.

Format: `done [index]`

Example of usage: `done 5`

Expected outcome:

```
Nice nya! I've marked this task as done nya:
    [D][y] iP user guide (by: 30/09/2019 2359)
```

### `delete` - Deletes a task

Marks the task at the specified index in the list of tasks.

Format: `delete [index]`

Example of usage: `delete 6`

Expected outcome:

```
Meow! Noted~ I've removed this task nya:
    [E][n] Celebrate completion of iP (at: 30/09/2019 2359)
Now you have 5 tasks in the list nya~
```

### `undo` - Undoes the previous action if it modified the list of tasks

Undoes the previous action if it modified the list of tasks.

Format: `undo`

Example of usage: `undo`

Expected outcome:

```
Meow! Noted~ Your previous command has been undone. Here are the tasks in your list nya:
    1.[T][n] CS2100 revision
    2.[D][n] CS2103 iP (by: 30/09/2019 2359)
    3.[E][n] Celebrate end of mid-terms (at: 05/10/2019 1300)
    4.[T][n] CS2103 tP
    5.[D][y] iP user guide (by: 30/09/2019 2359)
    6.[E][n] Celebrate completion of iP (at: 30/09/2019 2359)
```

### `help` - Displays a list of available commands

Displays a list of available commands.

Format: `help`

Example of usage: `help`

Expected outcome:

```
Here are the commands available nya :3
- list -> returns the current list of tasks nya

- todo [name] -> creates a Todo nya

- deadline [name] /by [dd/mm/yyyy hhmm] -> creates a Deadline nya

- event [name] /at [dd/mm/yyyy hhmm] -> creates an Event nya

- find [keyword] -> returns tasks matching the keyword given nya

- done [index] -> marks the task at the index as done nya

- delete [index] -> deletes the task at the index nya

- undo -> undoes your previous action nya

- bye -> saves your task list and ends the program nya~ bye bye!

You can also type 'more help' for other interesting commands nya!
```

### `bye` - Exits the program

Saves the current list of tasks and exits the program.

Format: `bye`

Example of usage: `bye`

Expected outcome:

```
Bye bye! Hope to see you again soon nya! :3 :3 :3
```