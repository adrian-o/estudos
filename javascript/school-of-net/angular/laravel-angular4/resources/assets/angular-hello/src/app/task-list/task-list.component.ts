import { Component } from '@angular/core';
import { Task } from '../model/task';
import { TaskService } from '../task.service';

@Component({
  selector: 'ng-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent {

  tasks: Array<Task>= [];

  constructor(private taskService:TaskService) {
    this.taskService
        .getTasks()
        .then((tasks:Array<Task>)=>this.tasks = tasks);
  }
}
