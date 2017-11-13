import { Component } from '@angular/core';
import { Task } from '../model/task';

@Component({
  selector: 'ng-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent {
  tasks = [];
  task:Task = {
    name: "",
    value: 0,
    date_launch: new Date()
  };

  add(){
    this.tasks.push(this.task);
    this.task = new Task();
  }
}
